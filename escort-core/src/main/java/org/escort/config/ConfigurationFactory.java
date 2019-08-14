package org.escort.config;

import org.escort.loader.SimpleServiceLoader;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 15:20
 */
public class ConfigurationFactory {

    private static volatile Configuration INSTANCE = null;

    public static Configuration getConfiguration() {
        if (INSTANCE == null) {
            synchronized (ConfigurationFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = SimpleServiceLoader.load(Configuration.class);
                }
            }
        }
        return INSTANCE;
    }

}
