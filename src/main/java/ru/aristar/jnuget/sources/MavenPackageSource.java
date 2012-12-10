package ru.aristar.jnuget.sources;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.maven.artifact.deployer.ArtifactDeployer;
import org.apache.maven.artifact.deployer.ArtifactDeploymentException;
import org.apache.maven.artifact.deployer.DefaultArtifactDeployer;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.repository.DefaultArtifactRepository;
import org.apache.maven.artifact.repository.layout.DefaultRepositoryLayout;
import org.apache.maven.index.ArtifactInfo;
import org.apache.maven.index.Field;
import org.apache.maven.index.Indexer;
import org.apache.maven.index.IteratorResultSet;
import org.apache.maven.index.IteratorSearchRequest;
import org.apache.maven.index.IteratorSearchResponse;
import org.apache.maven.index.MAVEN;
import org.apache.maven.index.context.IndexCreator;
import org.apache.maven.index.context.IndexingContext;
import org.apache.maven.index.expr.SourcedSearchExpression;
import org.apache.maven.index.updater.IndexUpdateRequest;
import org.apache.maven.index.updater.IndexUpdateResult;
import org.apache.maven.index.updater.IndexUpdater;
import org.apache.maven.index.updater.ResourceFetcher;
import org.apache.maven.index.updater.WagonHelper;
import org.apache.maven.wagon.Wagon;
import org.apache.maven.wagon.events.TransferEvent;
import org.apache.maven.wagon.events.TransferListener;
import org.apache.maven.wagon.observers.AbstractTransferListener;
import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.PlexusContainerException;
import org.codehaus.plexus.component.repository.exception.ComponentLookupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonatype.aether.util.version.GenericVersionScheme;
import org.sonatype.aether.version.InvalidVersionSpecificationException;
import ru.aristar.jnuget.Version;
import ru.aristar.jnuget.files.MavenNupkg;
import ru.aristar.jnuget.files.NugetFormatException;
import ru.aristar.jnuget.files.Nupkg;
import ru.aristar.jnuget.files.TempNupkgFile;
import ru.aristar.jnuget.sources.push.ModifyStrategy;

/**
 * Хранилище пакетов Maven.
 *
 * @author maksimov
 */
public class MavenPackageSource implements PackageSource<MavenNupkg> {

    private final String INDEX = "index";
    private final String CACHE = "cache";
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private String url;
    private File storage;
    private PlexusContainer plexusContainer;
    private Indexer indexer;
    private IndexUpdater indexUpdater;
    private Wagon httpWagon;

    public MavenPackageSource() {
        try {
            plexusContainer = new DefaultPlexusContainer();
            indexer = plexusContainer.lookup(Indexer.class);
            indexUpdater = plexusContainer.lookup(IndexUpdater.class);
            httpWagon = plexusContainer.lookup(Wagon.class, "http");
        } catch (PlexusContainerException | ComponentLookupException ex) {
            logger.error("Инициализация контейнера дала сбой.", ex);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStorage() {
        return storage.getAbsolutePath();
    }

    public void setStorage(String location) {
        storage = new File(location);
        if (!storage.exists()) {
            storage.mkdirs();
        }
    }

    public boolean isIndexActual() {
        return false;
    }

    public void loadIndex() throws ComponentLookupException, IOException {
        // Размещение служебных файлов.
        File localCache = new File(storage, CACHE);
        File indexDir = new File(storage, INDEX);
        // Создаем индексаторы
        List<IndexCreator> indexers = new ArrayList<>();
        indexers.add(plexusContainer.lookup(IndexCreator.class, "min"));
        indexers.add(plexusContainer.lookup(IndexCreator.class, "jarContent"));

        // Контекст
        IndexingContext context = indexer.createIndexingContext("context", "local", localCache, indexDir,
                url, null, true, true, indexers);

        TransferListener listener = new AbstractTransferListener() {
            @Override
            public void transferStarted(TransferEvent transferEvent) {
                logger.debug(" Downloading " + transferEvent.getResource().getName());
            }

            @Override
            public void transferProgress(TransferEvent transferEvent, byte[] buffer, int length) {
            }

            @Override
            public void transferCompleted(TransferEvent transferEvent) {
                logger.debug(" - Done");
            }
        };
        ResourceFetcher resourceFetcher = new WagonHelper.WagonFetcher(httpWagon, listener, null, null);

        Date centralContextCurrentTimestamp = context.getTimestamp();
        IndexUpdateRequest updateRequest = new IndexUpdateRequest(context, resourceFetcher);
        IndexUpdateResult updateResult = indexUpdater.fetchAndUpdateIndex(updateRequest);
        // Выводим статус обновления.
        if (updateResult.isFullUpdate()) {
            logger.debug("Full update happened!");
        } else if (updateResult.getTimestamp().equals(centralContextCurrentTimestamp)) {
            logger.debug("No update needed, index is up to date!");
        } else {
            logger.debug("Incremental update happened, change covered " + centralContextCurrentTimestamp
                    + " - " + updateResult.getTimestamp() + " period.");
        }
    }

    @Override
    public Collection<MavenNupkg> getPackages() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<MavenNupkg> getLastVersionPackages() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<MavenNupkg> getPackages(String id) {
        try {
            // construct the query for known GA
            final Query groupIdQ =
                    indexer.constructQuery(MAVEN.GROUP_ID, new SourcedSearchExpression(id));
            final Query artifactIdQ =
                    indexer.constructQuery(MAVEN.ARTIFACT_ID, new SourcedSearchExpression(id));
            final BooleanQuery query = new BooleanQuery();
            query.add(groupIdQ, Occur.MUST);
            query.add(artifactIdQ, Occur.MUST);

            // we want "nupkg" artifacts only
            query.add(indexer.constructQuery(MAVEN.PACKAGING, new SourcedSearchExpression("nupkg")), Occur.MUST);
            // we want main artifacts only (no classifier)
            // Note: this below is unfinished API, needs fixing
            query.add(indexer.constructQuery(MAVEN.CLASSIFIER, new SourcedSearchExpression(Field.NOT_PRESENT)),
                    Occur.MUST_NOT);

            final IteratorSearchRequest request = new IteratorSearchRequest(query);
            final IteratorSearchResponse response = indexer.searchIterator(request);

            Collection<MavenNupkg> result = new ArrayList<>();
            final IteratorResultSet cursor = response.getResults();
            while (cursor.hasNext()) {
                ArtifactInfo info = cursor.next();
                //
                // MavenNupkg pack
                // result.add(pack);
                throw new UnsupportedOperationException(info.toString());
            }
        } catch (IOException ex) {
            logger.error("Ошибка при поиске пакета id:" + id, ex);
        }

        throw new UnsupportedOperationException();
    }

    @Override
    public MavenNupkg getLastVersionPackage(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MavenNupkg getPackage(String id, Version version) {
        try {
            final GenericVersionScheme versionScheme = new GenericVersionScheme();
            final org.sonatype.aether.version.Version mavenVersion = versionScheme.parseVersion(version.toString());

            // construct the query for known GA
            final Query groupIdQ =
                    indexer.constructQuery(MAVEN.GROUP_ID, new SourcedSearchExpression(id));
            final Query artifactIdQ =
                    indexer.constructQuery(MAVEN.ARTIFACT_ID, new SourcedSearchExpression(id));
            final Query versionQ = indexer.constructQuery(MAVEN.VERSION, new SourcedSearchExpression(mavenVersion.toString()));
            final BooleanQuery query = new BooleanQuery();
            query.add(groupIdQ, Occur.MUST);
            query.add(artifactIdQ, Occur.MUST);
            query.add(versionQ, Occur.MUST);

            // we want "nupkg" artifacts only
            query.add(indexer.constructQuery(MAVEN.PACKAGING, new SourcedSearchExpression("nupkg")), Occur.MUST);
            // we want main artifacts only (no classifier)
            // Note: this below is unfinished API, needs fixing
            query.add(indexer.constructQuery(MAVEN.CLASSIFIER, new SourcedSearchExpression(Field.NOT_PRESENT)),
                    Occur.MUST_NOT);

            final IteratorSearchRequest request = new IteratorSearchRequest(query);
            final IteratorSearchResponse response = indexer.searchIterator(request);
            if (response.getResults().hasNext()) {
                ArtifactInfo info = response.getResults().next();
                throw new UnsupportedOperationException(info.toString());
            }
        } catch (InvalidVersionSpecificationException | IOException ex) {
            logger.error("Ошибка при поиске пакета id:" + id + " версии:" + version, ex);
        }

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean pushPackage(Nupkg file) throws IOException {
        if (getPushStrategy().canPush()) {
            try {
                ArtifactDeployer deployer = new DefaultArtifactDeployer();
                ArtifactRepository repository = new DefaultArtifactRepository(url, url, new DefaultRepositoryLayout());
                TempNupkgFile nupkgFile;
                try {
                    nupkgFile = new TempNupkgFile(file);
                } catch (NugetFormatException ex) {
                    logger.error("Ошибка загрузки артефакта.", ex);
                    return false;
                }
                deployer.deploy(nupkgFile.getFile(), new MavenNupkg(file).getArtifact(), repository, repository);
                return true;
            } catch (ArtifactDeploymentException ex) {
                logger.error("Ошибка загрузки артефакта.", ex);
                return false;
            }
        }
        return false;
    }

    @Override
    public ModifyStrategy getPushStrategy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPushStrategy(ModifyStrategy strategy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removePackage(Nupkg nupkg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void refreshPackage(Nupkg nupkg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
