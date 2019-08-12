package org.escort.client.context;

import org.escort.client.MethodHandler;
import org.escort.client.MethodType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 16:06
 */
public class DefaultMethodHandlerManager implements MethodHandlerManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMethodHandlerManager.class);

    private static ConcurrentMap<String, MethodHandler> methodHandlerMap = new ConcurrentHashMap<>(256);

    @Override
    public void register(MethodType methodType, String methodRootId, MethodHandler methodHandler) {
        LOGGER.debug("MethodHandlerManager register: MethodType of {}, MethodRootId of {}", methodType, methodRootId);
        methodHandlerMap.putIfAbsent(buildMethodName(methodRootId, methodType), methodHandler);
    }

    @Override
    public MethodHandler getMethodHandler(String methodRootId, MethodType methodType) {
        return methodHandlerMap.get(buildMethodName(methodRootId, methodType));
    }

    private static String buildMethodName(String methodRootId, MethodType methodType) {
        return methodRootId + ":" + methodType;
    }
}
