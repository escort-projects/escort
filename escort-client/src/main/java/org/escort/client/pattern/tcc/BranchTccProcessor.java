package org.escort.client.pattern.tcc;

import com.alibaba.fastjson.JSON;
import org.escort.client.MethodHandler;
import org.escort.client.MethodType;
import org.escort.client.TransactionContext;
import org.escort.client.context.ContextManager;
import org.escort.client.context.DefaultMethodHandler;
import org.escort.client.context.MethodHandlerManager;
import org.escort.client.context.TransactionManager;
import org.escort.client.core.BranchTccAction;
import org.escort.client.pattern.AbstractPatternProcessor;
import org.escort.client.pattern.BusinessHandler;
import org.escort.protocol.transaction.RmToTcReportRequest;
import org.escort.remote.RemoteSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.escort.common.utils.NetUtils.getLocalHost;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/12 14:20
 */
public class BranchTccProcessor extends AbstractPatternProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BranchTccProcessor.class);

    private RemoteSender remoteSender;
    private MethodHandlerManager methodHandlerManager = ContextManager.getInstance();
    private TransactionManager transactionManager = ContextManager.getInstance();

    public BranchTccProcessor(RemoteSender remoteSender) {
        this.remoteSender = remoteSender;
    }

    @Override
    public Class<? extends Annotation> getAnnotation() {
        return BranchTccAction.class;
    }

    @Override
    public void init(final Annotation annotation, final Class clazz, final Method method, Object object) throws NoSuchMethodException, IllegalAccessException {
        LOGGER.debug("BranchTccProcessor init. Annotation: {}, Class:{}, Method:{}", annotation, clazz, method);
        BranchTccAction branchTccAction = (BranchTccAction) annotation;
        methodHandlerManager.register(MethodType.BRANCH_TCC_ROOT, buildRootId(clazz, method), new DefaultMethodHandler(object, method));

        // CANCEL
        Method cancelMethod = clazz.getMethod(branchTccAction.cancelMethod(), method.getParameterTypes());
        MethodHandler cancelMethodHandler = new DefaultMethodHandler(object, cancelMethod);
        methodHandlerManager.register(MethodType.BRANCH_TCC_CANCEL, buildRootId(clazz, method), cancelMethodHandler);

        // COMMIT
        Method commitMethod = clazz.getMethod(branchTccAction.commitMethod(), method.getParameterTypes());
        MethodHandler commitMethodHandler = new DefaultMethodHandler(object, commitMethod);
        methodHandlerManager.register(MethodType.BRANCH_TCC_COMMIT, buildRootId(clazz, method), commitMethodHandler);
    }

    // TODO 封装 对象体
    private void registerToTc() {
        LOGGER.debug("Branch Tcc register to TC. IP: " + getLocalHost());
    }

    public void reportStarted(Object[] objects) {
        TransactionContext transactionContext = transactionManager.getCurrentTransactionContext();
        RmToTcReportRequest rmToTcReportRequest = new RmToTcReportRequest(transactionContext.getXid(), transactionContext.getParentId(), transactionContext.getSpanId());
        List<Object> arguments = new ArrayList<>();
        arguments.addAll(Arrays.asList(objects));
        rmToTcReportRequest.setArguments(arguments);
        LOGGER.debug("Branch Tcc begin. TransactionContext: {}", transactionContext);
        LOGGER.debug("to TC json: {}", JSON.toJSONString(rmToTcReportRequest));
    }

    public void reportFinish() {
        TransactionContext transactionContext = transactionManager.getCurrentTransactionContext();
        LOGGER.debug("Branch Tcc finish. TransactionContext: {}", transactionContext);
    }

    public void reportError(Throwable throwable) {
        TransactionContext transactionContext = transactionManager.getCurrentTransactionContext();
        LOGGER.debug("Branch Tcc Error. TransactionContext: {}, Error info : {}", transactionContext, throwable);
    }

    public Object proceed(BusinessHandler businessHandler) throws Throwable {
        LOGGER.debug("Branch Tcc execute.");
        return businessHandler.proceed();
    }

}
