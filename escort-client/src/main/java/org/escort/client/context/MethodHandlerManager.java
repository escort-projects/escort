package org.escort.client.context;

import org.escort.client.MethodHandler;
import org.escort.client.MethodType;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 15:16
 */
public interface MethodHandlerManager {

    void register(MethodType methodType, String methodRootId, MethodHandler methodHandler);

    MethodHandler getMethodHandler(String methodRootId, MethodType methodType);

}
