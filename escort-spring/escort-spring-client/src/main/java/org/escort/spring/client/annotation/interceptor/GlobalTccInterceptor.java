package org.escort.spring.client.annotation.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.escort.client.core.GlobalTccTransaction;
import org.escort.client.pattern.PatternProcessor;
import org.escort.client.pattern.tcc.GlobalTccProcessor;
import org.escort.spring.client.annotation.BaseTransactionInterceptor;

import java.lang.reflect.Method;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 16:41
 */
public class GlobalTccInterceptor extends BaseTransactionInterceptor {

    private GlobalTccProcessor globalTccProcessor;

    public GlobalTccInterceptor(GlobalTccProcessor globalTccProcessor) {
        this.globalTccProcessor = globalTccProcessor;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        GlobalTccTransaction globalTccTransaction = method.getAnnotation(GlobalTccTransaction.class);
        if (globalTccTransaction != null) {
            System.out.println("this is @GlobalTccTransaction");
        }
        globalTccProcessor.reportStarted();
        try {
            Object result = globalTccProcessor.proceed(new WrapperBusinessHandler(invocation));
            globalTccProcessor.reportFinish();
            return result;
        } catch (Throwable throwable) {
            globalTccProcessor.reportError(throwable);
            throw throwable;
        }
    }

    @Override
    public PatternProcessor getPatternProcessor() {
        return globalTccProcessor;
    }


}
