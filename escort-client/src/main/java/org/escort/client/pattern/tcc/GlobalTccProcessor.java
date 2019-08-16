package org.escort.client.pattern.tcc;

import org.escort.client.TransactionContext;
import org.escort.client.context.ContextManager;
import org.escort.client.context.TransactionManager;
import org.escort.client.core.GlobalTccTransaction;
import org.escort.client.pattern.AbstractPatternProcessor;
import org.escort.client.pattern.BusinessHandler;
import org.escort.remote.RemoteSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/12 14:21
 */
public class GlobalTccProcessor extends AbstractPatternProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalTccProcessor.class);

    private RemoteSender remoteSender;
    private TransactionManager transactionManager = ContextManager.getInstance();

    public GlobalTccProcessor(RemoteSender remoteSender) {
        this.remoteSender = remoteSender;
    }

    @Override
    public void init(Annotation annotation, Class clazz, Method method,Object object) throws Exception {
        // 记录注解的静态信息
        LOGGER.info("Global Tcc annotation of {}, class of {}, method of {}", annotation, clazz, method);
    }

    public void reportStarted() {
        TransactionContext transactionContext = transactionManager.startGlobalTransaction();
        LOGGER.debug("Branch Tcc begin. TransactionContext: {}", transactionContext);
    }

    public void reportFinish() {
        LOGGER.debug("Branch Tcc Finish. TransactionContext: {}", transactionManager.getCurrentTransactionContext());
        transactionManager.endGlobalTransaction();
    }

    public void reportError(Throwable throwable) {
        LOGGER.debug("Branch Tcc Error. TransactionContext: {}, Error info: {}", transactionManager.getCurrentTransactionContext(), throwable);
    }

    public Object proceed(BusinessHandler businessHandler) throws Throwable {
        LOGGER.debug("Branch Tcc execute.");
        return businessHandler.proceed();
    }

    @Override
    public Class<? extends Annotation> getAnnotation() {
        return GlobalTccTransaction.class;
    }
}
