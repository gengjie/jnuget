package ru.aristar.jnuget.sources;

import java.io.IOException;
import java.util.Collection;
import ru.aristar.jnuget.Version;
import ru.aristar.jnuget.files.Nupkg;
import ru.aristar.jnuget.sources.push.PushStrategy;

/**
 * Контракт источника пакетов
 *
 * @param <T> тип пакета
 * @author sviridov
 */
public interface PackageSource<T extends Nupkg> {

    /**
     * Возвращает полный список пакетов в хранилище
     *
     * @return коллекция файлов пакетов
     */
    Collection<T> getPackages();

    /**
     * Возвращает список пакетов, содержащий только последние версии
     *
     * @return коллекция файлов пакетов
     */
    Collection<T> getLastVersionPackages();

    /**
     * Возвращает пакеты с указанным идентификатором
     *
     * @param id
     * @return коллекция файлов пакетов
     */
    Collection<T> getPackages(String id);

    /**
     * Возвращает последнюю версию указанного пакета
     *
     * @param id идентификатор пакета
     * @return файл пакета
     */
    T getLastVersionPackage(String id);

    /**
     * Возвращает пакет с указанной версией и идентификатором
     *
     * @param id идентификатор пакета
     * @param version версия пакета
     * @return файл пакета
     */
    T getPackage(String id, Version version);

    /**
     * Загружает пакет в хранилище
     *
     * @param file Файл для загрузки
     * @param apiKey ключ (пароль для репозитория)
     * @return true в случае, если пакет помещен в хранилище
     * @throws IOException ошибка чтения/записи
     */
    boolean pushPackage(Nupkg file, String apiKey) throws IOException;

    /**
     * Возвращает стратегию помещения пакетов в базу данных
     *
     * @return стратегия помещения пакетов
     */
    PushStrategy getPushStrategy();

    /**
     * Устанавливает стратегию помещения пакетов в базу данных
     *
     * @param strategy стратегия помещения пакетов
     */
    void setPushStrategy(PushStrategy strategy);

    /**
     * Удаляет выбранный пакет из хранилища.
     *
     * @param id Идентификатор пакета.
     * @param version Версия пакета.
     */
    void removePackage(String id, Version version);

    /**
     * Обновить информацию о пакете
     *
     * @param nupkg пакет
     */
    void refreshPackage(Nupkg nupkg);
}
