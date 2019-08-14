package org.escort.spring.client.config;

import org.escort.config.Configuration;
import org.escort.loader.SimpleServiceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 15:59
 */
@Service
public class SpringConfiguration implements Configuration {

    @Autowired
    private Environment environment;

    @Override
    public String getProperty(String key) {
        return environment.getProperty(key);
    }

    @Override
    public String getProperty(String key, String defaultValue) {
        return environment.getProperty(key, defaultValue);
    }

    @Override
    public <T> T getProperty(String key, Class<T> targetType) {
        return environment.getProperty(key, targetType);
    }

    @Override
    public <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
        return environment.getProperty(key, targetType, defaultValue);
    }

    @PostConstruct
    public void inject() {
        SimpleServiceLoader.inject(Configuration.class, this);
    }
}
