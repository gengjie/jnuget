package ru.aristar.jnuget.sources;

import java.lang.reflect.Method;
import java.util.Map;
import javax.activation.UnsupportedDataTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.aristar.jnuget.Common.OptionConverter;
import ru.aristar.jnuget.Common.Options;
import ru.aristar.jnuget.Common.PushStrategyOptions;
import ru.aristar.jnuget.Common.StorageOptions;

/**
 * Фабрика источников данных
 *
 * @author sviridov
 */
public class PackageSourceFactory {

    /**
     * Экземпляр фабрики
     */
    private volatile static PackageSourceFactory instance;
    /**
     * Настройки сервера
     */
    private final Options options;

    /**
     * Конструктор, перечитывающий настройки
     */
    public PackageSourceFactory() {
        this.options = Options.loadOptions();
    }
    /**
     * Источник пакетов
     */
    private volatile PackageSource packageSource = null;
    /**
     * Логгер
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Создание нового корневого хранилища на основе настроек
     *
     * @param serviceOptions настройки приложения
     * @return хранилище пакетов
     */
    protected PackageSource createRootPackageSource(Options serviceOptions) {
        //Создание корневого хранилища
        logger.info("Инициализация файлового хранища");
        RootPackageSource rootPackageSource = new RootPackageSource();
        for (StorageOptions storageOptions : serviceOptions.getStorageOptionsList()) {
            try {
                PackageSource childSource = createPackageSource(storageOptions);
                rootPackageSource.getSources().add(childSource);
            } catch (Exception e) {
                logger.warn("Ошибка создания хранилища пакетов", e);
            }
        }
        return rootPackageSource;
    }

    /**
     * Производит поиск сеттера для свойства
     *
     * @param sourceClass класс, в котором производится поиск сеттера
     * @param propertyName имя свойства
     * @return метод - сеттер
     * @throws NoSuchMethodException метод не найден
     */
    protected Method findSetter(Class<?> sourceClass, String propertyName) throws NoSuchMethodException {
        String setterName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        for (Method method : sourceClass.getMethods()) {
            if (method.getName().equals(setterName) && method.getParameterTypes().length == 1) {
                return method;
            }
        }
        throw new NoSuchMethodException("Метод " + setterName + " не найден в классе " + sourceClass.getName());
    }

    /**
     * Создание нового дочернего хранилища на основе настроек
     *
     * @param storageOptions настройки хранилища
     * @return хранилище пакетов
     * @throws Exception ошибка создания хранилища
     */
    protected PackageSource createPackageSource(StorageOptions storageOptions)
            throws Exception {
        //Создание файлового хранилища
        logger.info("Инициализация хранилища типа {}", new Object[]{storageOptions.getClassName()});
        Class<?> sourceClass = Class.forName(storageOptions.getClassName());
        Object object = sourceClass.newInstance();
        if (!(object instanceof PackageSource)) {
            throw new UnsupportedDataTypeException("Класс " + sourceClass + " не является хранилищем пакетов");
        }
        PackageSource newSource = (PackageSource) object;
        setObjectProperties(storageOptions.getProperties(), object);
        if (storageOptions.getStrategyOptions() != null) {
            PushStrategy pushStrategy = createPushStrategy(storageOptions.getStrategyOptions());
            newSource.setPushStrategy(pushStrategy);
            logger.info("Установлена стратегия по фиксации");
        } else {
            newSource.setPushStrategy(new SimplePushStrategy(false));
            logger.warn("Используется стратегия фиксации по умолчанию");
        }

        logger.info("Хранилище создано");
        return newSource;
    }

    /**
     * Создает стратегию фиксации пакетов
     *
     * @param strategyOptions настройки стратегии
     * @return стратегия фиксации
     * @throws Exception ошибка создания стратегии
     */
    private PushStrategy createPushStrategy(PushStrategyOptions strategyOptions) throws Exception {
        //Создание стратегии фиксации
        logger.info("Инициализация стратегии типа {}", new Object[]{strategyOptions.getClassName()});
        Class<?> sourceClass = Class.forName(strategyOptions.getClassName());
        Object object = sourceClass.newInstance();
        if (!(object instanceof PushStrategy)) {
            throw new UnsupportedDataTypeException("Класс " + sourceClass + " не является стратегией публикации");
        }
        PushStrategy newSource = (PushStrategy) object;
        setObjectProperties(strategyOptions.getProperties(), newSource);
        logger.info("Стратегия создана");
        return newSource;
    }

    /**
     * Устанавливает свойства объекту
     *
     * @param properties карта свойств
     * @param newObject объект
     * @throws Exception ошибка установки свойств
     */
    private void setObjectProperties(Map<String, String> properties, Object newObject)
            throws Exception {
        Class<?> sourceClass = newObject.getClass();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            Method method = findSetter(sourceClass, entry.getKey());
            Class<?> valueType = method.getParameterTypes()[0];
            String stringValue = OptionConverter.replaceVariables(entry.getValue());
            Object value = valueType.getConstructor(String.class).newInstance(stringValue);
            method.invoke(newObject, value);
        }
    }

    /**
     * Возвращает экземпляр фабрики, или создает новый
     *
     * @return экземпляр фабрики
     */
    public static PackageSourceFactory getInstance() {
        if (instance == null) {
            synchronized (PackageSourceFactory.class) {
                if (instance == null) {
                    instance = new PackageSourceFactory();
                }
            }
        }
        return instance;
    }

    /**
     * Возвращает источник пакетов
     *
     * @return источник пакетов
     */
    public PackageSource getPackageSource() {
        if (packageSource == null) {
            //TODO Добавить возможность переинициализации
            synchronized (this) {
                if (packageSource == null) {
                    packageSource = createRootPackageSource(options);
                }
            }
        }
        return packageSource;
    }
}
