package org.escort.spring.client.annotation.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.escort.client.core.BranchTccAction;
import org.escort.client.pattern.PatternProcessor;
import org.escort.client.pattern.tcc.BranchTccProcessor;
import org.escort.spring.client.annotation.BaseTransactionInterceptor;

import java.lang.reflect.Method;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 16:39
 */
public class BranchTccActionInterceptor extends BaseTransactionInterceptor {

    private BranchTccProcessor branchTccProcessor;

    public BranchTccActionInterceptor(BranchTccProcessor branchTccProcessor) {
        this.branchTccProcessor = branchTccProcessor;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        BranchTccAction branchTccAction = method.getAnnotation(BranchTccAction.class);
        if (branchTccAction != null) {
            System.out.println("this is @BranchTccAction");
        }
        branchTccProcessor.reportStarted();
        try {
            Object result = branchTccProcessor.proceed(new WrapperBusinessHandler(invocation));
            branchTccProcessor.reportFinish();
            return result;
        } catch (Throwable throwable) {
            branchTccProcessor.reportError(throwable);
            throw throwable;
        }
    }

    public PatternProcessor getPatternProcessor() {
        return this.branchTccProcessor;
    }

}
