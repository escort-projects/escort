package org.escort.serializer;

import org.escort.loader.SimpleServiceLoader;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 17:45
 */
public class ObjectSerializerFactory {

    private static volatile ObjectSerializer INSTANCE = null;

    public static ObjectSerializer getSerializer() {
        if (INSTANCE == null) {
            synchronized (ObjectSerializer.class) {
                if (INSTANCE == null) {
                    INSTANCE = SimpleServiceLoader.load(ObjectSerializer.class);
                }
            }
        }
        return INSTANCE;
    }
}
