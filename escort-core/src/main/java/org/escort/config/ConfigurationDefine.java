package org.escort.config;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 15:39
 */
public interface ConfigurationDefine {

    String ROOT_DEFINE = "escort";

    String CONFIG_SPLIT_CHAR = ".";

    String CURRENT_VERSION = "v1";

    default String getCurrentRootDefine() {
        return ROOT_DEFINE + CONFIG_SPLIT_CHAR + CURRENT_VERSION;
    }
}
