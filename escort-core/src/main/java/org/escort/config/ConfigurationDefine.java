package org.escort.config;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 15:39
 */
public class ConfigurationDefine {

    public static final String ROOT_DEFINE = "escort";

    public static final String CONFIG_SPLIT_CHAR = ".";

    public static final String CURRENT_VERSION = "v1";

    public static String getCurrentRootDefine() {
        return ROOT_DEFINE + CONFIG_SPLIT_CHAR + CURRENT_VERSION;
    }

    public static String getEscortPath(String subsidiary) {
        return getCurrentRootDefine() + CONFIG_SPLIT_CHAR + subsidiary;
    }
}
