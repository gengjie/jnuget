package ru.aristar.jnuget.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.handler.ArtifactHandler;
import org.apache.maven.artifact.metadata.ArtifactMetadata;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.filter.ArtifactFilter;
import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.OverConstrainedVersionException;
import org.apache.maven.artifact.versioning.VersionRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Пакет nupkg, размещенный в хранилище Maven.
 *
 * @author maksimov
 */
public class ArtifactNupkg implements Artifact {

    static private final String DEFAULT_TYPE = "nupkg";
    /**
     * Логгер
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Nupkg pack;

    public ArtifactNupkg(Nupkg pack) {
        this.pack = pack;
    }

    @Override
    public String getGroupId() {
        return pack.getId();
    }

    @Override
    public String getArtifactId() {
        return pack.getId();
    }

    @Override
    public String getVersion() {
        return pack.getVersion().toString();
    }

    @Override
    public void setVersion(String version) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getScope() {
        return null;
    }

    @Override
    public String getType() {
        return DEFAULT_TYPE;
    }

    @Override
    public String getClassifier() {
        return null;
    }

    @Override
    public boolean hasClassifier() {
        return false;
    }

    @Override
    public File getFile() {
        try {
            return File.createTempFile(pack.getFileName(), Nupkg.DEFAULT_EXTENSION);
        } catch (IOException ex) {
            logger.error("При создании файла произошла ошибка.", ex);
            return null;
        }
    }

    @Override
    public void setFile(File destination) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getBaseVersion() {
        return pack.getVersion().toString();
    }

    @Override
    public void setBaseVersion(String baseVersion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getId() {
        return pack.getId();
    }

    @Override
    public String getDependencyConflictId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addMetadata(ArtifactMetadata metadata) {
    }

    @Override
    public Collection<ArtifactMetadata> getMetadataList() {
        return new ArrayList<>();
    }

    @Override
    public void setRepository(ArtifactRepository remoteRepository) {
    }

    @Override
    public ArtifactRepository getRepository() {
        return null;
    }

    @Override
    public void updateVersion(String version, ArtifactRepository localRepository) {
    }

    @Override
    public String getDownloadUrl() {
        return null;
    }

    @Override
    public void setDownloadUrl(String downloadUrl) {
    }

    @Override
    public ArtifactFilter getDependencyFilter() {
        return null;
    }

    @Override
    public void setDependencyFilter(ArtifactFilter artifactFilter) {
    }

    @Override
    public ArtifactHandler getArtifactHandler() {
        return null;
    }

    @Override
    public List<String> getDependencyTrail() {
        return new ArrayList<>();
    }

    @Override
    public void setDependencyTrail(List<String> dependencyTrail) {
    }

    @Override
    public void setScope(String scope) {
    }

    @Override
    public VersionRange getVersionRange() {
        return null;
    }

    @Override
    public void setVersionRange(VersionRange newRange) {
    }

    @Override
    public void selectVersion(String version) {
    }

    @Override
    public void setGroupId(String groupId) {
    }

    @Override
    public void setArtifactId(String artifactId) {
    }

    @Override
    public boolean isSnapshot() {
        return false;
    }

    @Override
    public void setResolved(boolean resolved) {
    }

    @Override
    public boolean isResolved() {
        return true;
    }

    @Override
    public void setResolvedVersion(String version) {
    }

    @Override
    public void setArtifactHandler(ArtifactHandler handler) {
    }

    @Override
    public boolean isRelease() {
        return true;
    }

    @Override
    public void setRelease(boolean release) {
    }

    @Override
    public List<ArtifactVersion> getAvailableVersions() {
        return new ArrayList<>();
    }

    @Override
    public void setAvailableVersions(List<ArtifactVersion> versions) {
    }

    @Override
    public boolean isOptional() {
        return false;
    }

    @Override
    public void setOptional(boolean optional) {
    }

    @Override
    public ArtifactVersion getSelectedVersion() throws OverConstrainedVersionException {
        return null;
    }

    @Override
    public boolean isSelectedVersionKnown() throws OverConstrainedVersionException {
        return true;
    }

    @Override
    public int compareTo(Artifact o) {
        return 0;
    }
}
