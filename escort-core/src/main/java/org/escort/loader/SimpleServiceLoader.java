package org.escort.loader;

import org.escort.exception.EscortRuntimeException;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.StreamSupport;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 15:37
 */
public class SimpleServiceLoader {

    private static final String DEFAULT = "default";

    private static ConcurrentMap<String, ConcurrentMap<String, Object>> BEANS = new ConcurrentHashMap<>(128);

    public static synchronized void inject(Class clazz, Object object) {
        if (!BEANS.containsKey(clazz.getName())) {
            BEANS.put(clazz.getName(), new ConcurrentHashMap<>());
        }
        BEANS.get(clazz.getName()).put(DEFAULT, object);
    }

    public static synchronized void inject(Class clazz, String beanName, Object object) {
        if (!BEANS.containsKey(clazz.getName())) {
            BEANS.put(clazz.getName(), new ConcurrentHashMap<>());
        }
        BEANS.get(clazz.getName()).put(beanName, object);
    }

    private static Object provide(Class clazz, String beanName) {
        throw new EscortRuntimeException("not implements");
    }

    private static Object provide(Class clazz) {
        if (!BEANS.containsKey(clazz.getName())) {
            return null;
        }
        return BEANS.get(clazz).get(DEFAULT);
    }

    public static <T> T load(Class<T> clazz) {
        Object bean = provide(clazz);
        if (bean == null) {
            return loadBySpi(clazz);
        }
        return (T) bean;
    }

    public static <T> T load(Class<T> clazz, String name) {
        throw new EscortRuntimeException("not implements");
    }

    public static <T> T loadBySpi(Class<T> clazz) {
        ServiceLoader<T> serviceLoader = ServiceLoader.load(clazz);
        final Optional<T> serializer = StreamSupport
                .stream(serviceLoader.spliterator(), false)
                .findFirst();
        if (serializer.isPresent()) {
            throw new EscortRuntimeException("Load configuration error. Can't find Configuration implement Class");
        }
        return serializer.get();
    }
}
