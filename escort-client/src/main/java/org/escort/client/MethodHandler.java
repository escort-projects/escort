package org.escort.client;

import java.util.List;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 16:02
 */
public interface MethodHandler {
    Object invoke(List<String> arguments) throws Throwable;
}
