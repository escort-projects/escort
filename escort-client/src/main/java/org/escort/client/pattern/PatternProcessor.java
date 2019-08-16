package org.escort.client.pattern;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/12 14:21
 */
public interface PatternProcessor extends AnnotationDefine {

    void init(Annotation annotation, final Class clazz, final Method method,Object bean) throws Exception;



}
