package ru.aristar.jnuget.sources;

import java.io.File;
import java.lang.reflect.Method;
import java.net.Authenticator;
import java.net.ProxySelector;
import java.util.Map;
import javax.activation.UnsupportedDataTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.aristar.jnuget.Common.*;
import ru.aristar.jnuget.files.Nupkg;
import ru.aristar.jnuget.sources.push.PushStrategy;
import ru.aristar.jnuget.sources.push.PushTrigger;
import ru.aristar.jnuget.sources.push.SimplePushStrategy;

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
    private volatile PackageSource<Nupkg> packageSource = null;
    /**
     * Логгер
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Создает индексируемую обертку для хранилища пакетов
     *
     * @param packageSource хранилище, которое необходимо индексировать
     * @param storageName имя, используемое для сохранения индекса
     * @param refreshInterval интервал обновления информации в индекск
     * @return индексируемое хранилище
     */
    protected PackageSource<Nupkg> createIndexForStorage(PackageSource<Nupkg> packageSource,
            String storageName, Integer refreshInterval) {
        logger.debug("Создание индекса для хранилища {}", new Object[]{packageSource});
        IndexedPackageSource indexedPackageSource = new IndexedPackageSource();
        indexedPackageSource.setUnderlyingSource(packageSource);
        if (storageName != null) {
            File storageFile = new File(Options.getNugetHome(), storageName + ".idx");
            indexedPackageSource.setIndexStoreFile(storageFile);
        }
        indexedPackageSource.setRefreshInterval(refreshInterval);
        return indexedPackageSource;
    }

    /**
     * Создание нового корневого хранилища на основе настроек
     *
     * @param serviceOptions настройки приложения
     * @return хранилище пакетов
     */
    protected PackageSource<Nupkg> createRootPackageSource(Options serviceOptions) {
        //Создание корневого хранилища
        logger.info("Инициализация файлового хранища");
        RootPackageSource rootPackageSource = new RootPackageSource();
        PushStrategy pushStrategy = null;
        try {
            if (serviceOptions.getStrategyOptions() != null) {
                pushStrategy = createPushStrategy(serviceOptions.getStrategyOptions());
            }
        } catch (Exception e) {
            logger.error("Ошибка создания стратегии фиксации", e);
        }
        if (pushStrategy == null) {
            pushStrategy = new SimplePushStrategy(true);
            logger.warn("Для корневого репозитория разрешается публикация "
                    + "пакетов. (поведение по умолчанию)");
        }
        rootPackageSource.setPushStrategy(pushStrategy);

        for (StorageOptions storageOptions : serviceOptions.getStorageOptionsList()) {
            try {
                PackageSource<Nupkg> childSource = createPackageSource(storageOptions);
                rootPackageSource.getSources().add(childSource);
            } catch (Exception e) {
                logger.warn("Ошибка создания хранилища пакетов", e);
            }
        }
        logger.info("Создано {} хранилищ", new Object[]{rootPackageSource.getSources().size()});
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
    protected PackageSource<Nupkg> createPackageSource(StorageOptions storageOptions)
            throws Exception {
        //Создание файлового хранилища
        logger.info("Инициализация хранилища типа {}", new Object[]{storageOptions.getClassName()});
        Class<?> sourceClass = Class.forName(storageOptions.getClassName());
        Object object = sourceClass.newInstance();
        if (!(object instanceof PackageSource)) {
            throw new UnsupportedDataTypeException("Класс " + sourceClass + " не является хранилищем пакетов");
        }
        @SuppressWarnings("unchecked")
        PackageSource<Nupkg> newSource = (PackageSource) object;
        setObjectProperties(storageOptions.getProperties(), object);
        if (storageOptions.getStrategyOptions() != null) {
            PushStrategy pushStrategy = createPushStrategy(storageOptions.getStrategyOptions());
            newSource.setPushStrategy(pushStrategy);
            logger.info("Установлена стратегия по фиксации");
        } else {
            newSource.setPushStrategy(new SimplePushStrategy(false));
            logger.warn("Используется стратегия фиксации по умолчанию");
        }
        if (storageOptions.isIndexed()) {
            newSource = createIndexForStorage(newSource, storageOptions.getStorageName(), storageOptions.getRefreshInterval());
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
    protected PushStrategy createPushStrategy(PushStrategyOptions strategyOptions) throws Exception {
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
     * Создает триггер фиксации пакета
     *
     * @param triggerOptions настройки триггера
     * @return триггер
     */
    protected PushTrigger createPushTrigger(TriggerOptions triggerOptions) {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    /**
     * Возвращает значение для примитивного типа
     *
     * @param string строковое значение
     * @param targetClass тип значения, в которое требуется преобразовать строку
     * @return преобразованное значение примитивного типа
     */
    private Object getPrimitiveValue(String string, Class<?> targetClass) {
        if (targetClass == java.lang.Boolean.TYPE) {
            return Boolean.valueOf(string);
        } else if (targetClass == java.lang.Character.TYPE) {
            return Character.valueOf(string.charAt(0));
        } else if (targetClass == java.lang.Byte.TYPE) {
            return Byte.valueOf(string);
        } else if (targetClass == java.lang.Short.TYPE) {
            return Short.valueOf(string);
        } else if (targetClass == java.lang.Integer.TYPE) {
            return Integer.valueOf(string);
        } else if (targetClass == java.lang.Long.TYPE) {
            return Long.valueOf(string);
        } else if (targetClass == java.lang.Float.TYPE) {
            return Float.valueOf(string);
        } else if (targetClass == java.lang.Double.TYPE) {
            return Double.valueOf(string);
        } else {
            throw new UnsupportedOperationException("Primitive type "
                    + targetClass + " is unsupported");
        }
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
            Object value;
            if (valueType.isPrimitive()) {
                value = getPrimitiveValue(stringValue, valueType);
            } else {
                value = valueType.getConstructor(String.class).newInstance(stringValue);
            }
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
                if (instance
                        == null) {
                    instance = new PackageSourceFactory();
                }
            }
        }
        return instance;
    }

    /**
     * Возвращает источник пакетов
     *
     * @param reinitialize необходима переинициализация
     * @return источник пакетов
     */
    public PackageSource<Nupkg> getPackageSource(boolean reinitialize) {
        if (reinitialize || packageSource == null) {
            synchronized (this) {
                if (packageSource == null) {
                    initializeProxyOptions(options.getProxyOptions());
                    packageSource = createRootPackageSource(options);
                }
            }
        }
        return packageSource;
    }

    /**
     * Возвращает источник пакетов
     *
     * @return источник пакетов
     */
    public PackageSource<Nupkg> getPackageSource() {
        return getPackageSource(false);
    }

    /**
     * Инициализация настроек прокси
     *
     * @param proxyOptions настройки прокси сервера
     */
    private void initializeProxyOptions(ProxyOptions proxyOptions) {
        if (proxyOptions.getUseSystemProxy() != null && proxyOptions.getUseSystemProxy()) {
            logger.info("Используется системный прокси");
            System.setProperty("java.net.useSystemProxies", "true");
        } else if (proxyOptions.getNoProxy() != null && proxyOptions.getNoProxy()) {
            logger.info("Прокси отключен");
            ProxySelector.setDefault(new CustomProxySelector());
        } else {
            logger.info("Используется прокси {}:{}",
                    new Object[]{proxyOptions.getHost(), proxyOptions.getPort()});
            ProxySelector.setDefault(new CustomProxySelector(
                    proxyOptions.getHost(),
                    proxyOptions.getPort()));
            Authenticator.setDefault(new CustomProxyAuthenticator(
                    proxyOptions.getLogin(),
                    proxyOptions.getPassword()));
        }
    }
}
