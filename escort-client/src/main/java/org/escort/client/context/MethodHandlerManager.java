package org.escort.client.context;

import org.escort.client.MethodHandler;
import org.escort.client.MethodType;

/**
 * 负责分布式事务RM方法管理（静态信息）
 *
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 15:16
 */
public interface MethodHandlerManager {

    void register(MethodType methodType, String methodRootId, MethodHandler methodHandler);

    MethodHandler getMethodHandler(String methodRootId, MethodType methodType);

}
