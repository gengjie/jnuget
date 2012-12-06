package ru.aristar.jnuget.sources;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.maven.index.Indexer;
import org.apache.maven.index.context.IndexCreator;
import ru.aristar.jnuget.Version;
import ru.aristar.jnuget.files.MavenNupkg;
import ru.aristar.jnuget.files.Nupkg;
import ru.aristar.jnuget.sources.push.ModifyStrategy;
import org.apache.maven.index.context.IndexingContext;
import org.apache.maven.index.updater.IndexUpdater;
import org.apache.maven.wagon.Wagon;
import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.PlexusContainerException;
import org.codehaus.plexus.component.repository.exception.ComponentLookupException;
import org.slf4j.LoggerFactory;

/**
 * Хранилище пакетов Maven.
 *
 * @author maksimov
 */
public class MavenPackageSource implements PackageSource<MavenNupkg> {

    private final String INDEX = "index";
    private final String CACHE = "cache";
    protected org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
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

        // Контекст
        IndexingContext context = indexer.createIndexingContext("context", "local", localCache, indexDir,
                url, null, true, true, indexers);

        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MavenNupkg getLastVersionPackage(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MavenNupkg getPackage(String id, Version version) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean pushPackage(Nupkg file) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
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
