package org.escort.spring.client.annotation.pattern;

import org.aopalliance.intercept.MethodInvocation;
import org.escort.client.core.GlobalTccTransaction;
import org.escort.spring.client.annotation.BaseTransactionInterceptor;

import java.lang.reflect.Method;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 16:41
 */
public class GlobalTccInterceptor extends BaseTransactionInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        GlobalTccTransaction globalTccTransaction = method.getAnnotation(GlobalTccTransaction.class);
        if (globalTccTransaction != null) {
            System.out.println("this is @GlobalTccTransaction");
        }
        return invocation.proceed();
    }
}
