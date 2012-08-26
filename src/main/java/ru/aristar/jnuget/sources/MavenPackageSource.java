package ru.aristar.jnuget.sources;

import java.io.IOException;
import java.util.Collection;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.repository.DefaultArtifactRepository;
import ru.aristar.jnuget.Version;
import ru.aristar.jnuget.files.MavenNupkg;
import ru.aristar.jnuget.files.Nupkg;
import ru.aristar.jnuget.sources.push.ModifyStrategy;

/**
 * Хранилище пакетов Maven.
 *
 * @author maksimov
 */
public class MavenPackageSource implements PackageSource<MavenNupkg> {

    private ArtifactRepository repository;
    private String url;

    public MavenPackageSource() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        repository = new DefaultArtifactRepository("maven", this.url, null);
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
