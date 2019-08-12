package org.escort.client.pattern;

import java.lang.annotation.Annotation;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/12 15:41
 */
public interface AnnotationDefine {

    Class<? extends Annotation> getAnnotation();

}
