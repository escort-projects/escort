package org.escort.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/12 14:34
 */
public class ReflectionUtils {

    public static <T extends Annotation> boolean isProxyTargetBean(Class<?> clazz, Class<T> annotationClass) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(annotationClass) != null) {
                return true;
            }
        }
        return false;
    }

    public static Method getMethodByAnnotation(Class<?> clazz, Class annotationClass) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(annotationClass) != null) {
                return method;
            }
        }
        return null;
    }
}
