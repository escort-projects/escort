package org.escort.spring.client.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/7 16:06
 */
public final class EscortBeanParserUtils {

    public static <T extends Annotation> boolean isProxyTargetBean(Class<?> clazz, Class<T> annotationClass) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(annotationClass) != null) {
                return true;
            }
        }
        return false;
    }

}
