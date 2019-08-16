package org.escort.client.context;

import org.escort.client.MethodHandler;
import org.escort.client.MethodType;
import org.escort.client.Node;
import org.escort.client.TransactionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 19:07
 */
public class ContextManager implements MethodHandlerManager, TransactionManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContextManager.class);

    private static ConcurrentMap<String, MethodHandler> METHOD_HANDLER_MAP = new ConcurrentHashMap<>(256);
    private static final ThreadLocal<TransactionContext> CURRENT_TRANSACTION = new ThreadLocal<>();

    private Node current;

    private ContextManager() {
    }

    private static class ContextManagerHolder {
        private final static ContextManager contextManager = new ContextManager();
    }

    public static ContextManager getInstance() {
        return ContextManagerHolder.contextManager;
    }

    @Override
    public TransactionContext getCurrentTransactionContext() {
        return CURRENT_TRANSACTION.get();
    }

    @Override
    public TransactionContext startGlobalTransaction() {
        Integer xid = applyGlobalXid();
        TransactionContext transactionContext = new TransactionContext(xid);
        CURRENT_TRANSACTION.set(transactionContext);
        return transactionContext;
    }

    private Integer applyGlobalXid() {
        // TODO apply new
        return new Random().nextInt(1000);
    }

    @Override
    public void endGlobalTransaction() {
        CURRENT_TRANSACTION.remove();
    }

    @Override
    public void attachTransaction(TransactionContext transactionContext) {
        CURRENT_TRANSACTION.set(transactionContext);
    }

    @Override
    public TransactionContext buildSpanTransactionContext() {
        TransactionContext transactionContext = CURRENT_TRANSACTION.get();
        return new TransactionContext(transactionContext.getXid(), transactionContext.getSpanId(), transactionContext.addAndGetSpanId());
    }

    @Override
    public void endAttachTransaction() {
        CURRENT_TRANSACTION.remove();
    }

    @Override
    public void register(MethodType methodType, String methodRootId, MethodHandler methodHandler) {
        LOGGER.debug("MethodHandlerManager register: MethodType of {}, MethodRootId of {}", methodType, methodRootId);
        METHOD_HANDLER_MAP.putIfAbsent(buildMethodName(methodRootId, methodType), methodHandler);
    }

    @Override
    public MethodHandler getMethodHandler(String methodRootId, MethodType methodType) {
        return METHOD_HANDLER_MAP.get(buildMethodName(methodRootId, methodType));
    }

    private static String buildMethodName(String methodRootId, MethodType methodType) {
        return methodRootId + ":" + methodType;
    }

    public Node getCurrentNode() {
        return current;
    }

    public void setCurrent(Node current) {
        this.current = current;
    }
}
