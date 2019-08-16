package org.escort.client.handler;

import org.escort.client.MethodHandler;
import org.escort.client.MethodType;
import org.escort.client.context.ContextManager;
import org.escort.client.context.MethodHandlerManager;
import org.escort.protocol.BaseEvent;
import org.escort.remote.RemoteHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 18:38
 */
public class ClientHandler implements RemoteHandler {

    private MethodHandlerManager methodHandlerManager = ContextManager.getInstance();

    @Override
    public BaseEvent receiveEventSyncReply(BaseEvent event) {
        MethodHandler methodHandler = methodHandlerManager.getMethodHandler("ORG.ESCORT.SAMPLES.TCC.STOCK.SERVICE.STOCKSERVICE:DEDUCT", MethodType.BRANCH_TCC_CANCEL);
        List<String> arguments = new ArrayList<>();
        arguments.add("{\"productId\":2,\"stock\":3}");
        Object result = null;
        try {
            result = methodHandler.invoke(arguments);
            System.out.println("ClientHandler result: " + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return new BaseEvent(1, "ok");
    }

    @Override
    public void receiveEventNoReply(BaseEvent event) {

    }
}
