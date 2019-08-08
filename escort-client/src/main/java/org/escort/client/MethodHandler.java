package org.escort.client;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 16:02
 */
public interface MethodHandler {
    Object invoke(Object[] argv) throws Throwable;
}
