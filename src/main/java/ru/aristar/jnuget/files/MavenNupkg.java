package ru.aristar.jnuget.files;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.EnumSet;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.artifact.handler.ArtifactHandler;
import ru.aristar.jnuget.Version;
import ru.aristar.jnuget.files.nuspec.NuspecFile;

/**
 * Пакет nupkg с возможностью размещения в хранилище Maven.
 *
 * @author maksimov
 */
public class MavenNupkg implements Nupkg {
    /*
     * Класс выполняется в форме декоратора с возможностью получения объекта типа Artifact.
     */

    /**
     * Пакет Nupkg.
     */
    private Nupkg pack;
    /**
     * Пакет Artifact.
     */
    private Artifact artifact;

    /**
     * Создает декоратор на основе готового пакета Nupkg.
     *
     * @param pack Пакет для декорирования.
     */
    public MavenNupkg(Nupkg pack) {
        if (pack instanceof MavenNupkg) {
            MavenNupkg mavenPack = (MavenNupkg) pack;
            this.pack = mavenPack.pack;
            this.artifact = mavenPack.artifact;
        } else {
            this.pack = pack;
        }
    }

    /**
     * Возвращает артефакт
     *
     * @return
     */
    public Artifact getArtifact() {
        if (artifact == null) {
            artifact = new NupkgArtifact(this, null);
        }
        return artifact;
    }

    @Override
    public String getFileName() {
        return pack.getFileName();
    }

    @Override
    public Hash getHash() throws NoSuchAlgorithmException, IOException {
        return pack.getHash();
    }

    @Override
    public NuspecFile getNuspecFile() throws NugetFormatException {
        return pack.getNuspecFile();
    }

    @Override
    public Long getSize() {
        return pack.getSize();
    }

    @Override
    public InputStream getStream() throws IOException {
        return pack.getStream();
    }

    @Override
    public Date getUpdated() {
        return getUpdated();
    }

    @Override
    public String getId() {
        return pack.getId();
    }

    @Override
    public Version getVersion() {
        return pack.getVersion();
    }

    @Override
    public EnumSet<Framework> getTargetFramework() {
        return pack.getTargetFramework();
    }

    @Override
    public void load() throws IOException {
        pack.load();
    }

    /**
     * Артефакт файла Nupkg.
     */
    private class NupkgArtifact extends DefaultArtifact implements Artifact {

        /**
         * Создает артефакт файла Nupkg.
         *
         * @param nupkg Исходный файл
         * @param artifactHandler
         */
        public NupkgArtifact(Nupkg nupkg, ArtifactHandler artifactHandler) {
            super(nupkg.getId(), nupkg.getId(), nupkg.getVersion().toString(), "compile", "nupkg", "", artifactHandler);
        }
    }
}
