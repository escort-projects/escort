package org.escort.spring.client.annotation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.escort.client.core.GlobalTccTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/7 11:28
 */
public class BaseTransactionInterceptor implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTransactionInterceptor.class);

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
