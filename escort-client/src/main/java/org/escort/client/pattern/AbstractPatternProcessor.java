package org.escort.client.pattern;

import java.lang.reflect.Method;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/12 18:39
 */
public abstract class AbstractPatternProcessor implements PatternProcessor {

    protected String buildRootId(Class clazz, Method method) {
        return clazz.getName().toUpperCase() + ":" + method.getName().toUpperCase();
    }

}
