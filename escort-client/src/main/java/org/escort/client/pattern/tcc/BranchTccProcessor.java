package org.escort.client.pattern.tcc;

import org.escort.client.MethodType;
import org.escort.client.context.DefaultMethodHandler;
import org.escort.client.context.MethodHandlerManager;
import org.escort.client.core.BranchTccAction;
import org.escort.client.pattern.AbstractPatternProcessor;
import org.escort.client.pattern.BusinessHandler;
import org.escort.client.pattern.PatternProcessor;
import org.escort.remote.RemoteClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import static org.escort.utils.NetUtils.getLocalHost;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/12 14:20
 */
public class BranchTccProcessor extends AbstractPatternProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BranchTccProcessor.class);

    // TODO init
    private RemoteClient remoteClient;
    // TODO init
    private MethodHandlerManager methodHandlerManager;

    public BranchTccProcessor(RemoteClient remoteClient, MethodHandlerManager methodHandlerManager) {
        this.remoteClient = remoteClient;
        this.methodHandlerManager = methodHandlerManager;
    }

    @Override
    public Class<? extends Annotation> getAnnotation() {
        return BranchTccAction.class;
    }

    @Override
    public void init(final Annotation annotation, final Class clazz, final Method method) throws NoSuchMethodException, IllegalAccessException {
        LOGGER.debug("BranchTccProcessor init. Annotation: {}, Class:{}, Method:{}", annotation, clazz, method);
        BranchTccAction branchTccAction = (BranchTccAction) annotation;
        MethodHandle methodHandle = MethodHandles.lookup().unreflect(method);
        methodHandlerManager.register(MethodType.BRANCH_TCC_ROOT, buildRootId(clazz, method), new DefaultMethodHandler(methodHandle));

        Method cancelMethod = clazz.getMethod(branchTccAction.cancelMethod());
        methodHandlerManager.register(MethodType.BRANCH_TCC_CANCEL, buildRootId(clazz, cancelMethod), new DefaultMethodHandler(MethodHandles.lookup().unreflect(cancelMethod)));

        Method commitMethod = clazz.getMethod(branchTccAction.commitMethod());
        methodHandlerManager.register(MethodType.BRANCH_TCC_CANCEL, buildRootId(clazz, commitMethod), new DefaultMethodHandler(MethodHandles.lookup().unreflect(commitMethod)));

        registerToTc();
    }

    // TODO 封装 对象体
    private void registerToTc() {
        LOGGER.debug("Branch Tcc register to TC. IP: " + getLocalHost());
        // TODO register to TC
    }

    public void reportStarted() {
        // TODO 需要 XID 和 各种参数
        LOGGER.debug("Branch Tcc begin.");
    }

    public void reportFinish() {
        // TODO 需要 XID 和 各种参数、执行结果（是否成功、异常信息）
        LOGGER.debug("Branch Tcc Finish.");
    }

    public void reportError(Throwable throwable) {
        // TODO 需要 XID 和 各种参数、执行结果（是否成功、异常信息）
        LOGGER.debug("Branch Tcc Error.");
    }

    public Object proceed(BusinessHandler businessHandler) throws Throwable {
        // TODO 调用业务方法，执行页面代码
        LOGGER.debug("Branch Tcc execute.");
        return businessHandler.proceed();
    }

}
