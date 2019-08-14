package org.escort.config;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 15:18
 */
public interface Configuration {

    String getProperty(String key);

    String getProperty(String key, String defaultValue);

    <T> T getProperty(String key, Class<T> targetType);

    <T> T getProperty(String key, Class<T> targetType, T defaultValue);
}
