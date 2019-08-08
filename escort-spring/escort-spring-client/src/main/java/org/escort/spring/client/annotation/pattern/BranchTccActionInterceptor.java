package org.escort.spring.client.annotation.pattern;

import org.aopalliance.intercept.MethodInvocation;
import org.escort.client.core.BranchTccAction;
import org.escort.spring.client.annotation.BaseTransactionInterceptor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 16:39
 */
@Service
public class BranchTccActionInterceptor extends BaseTransactionInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        BranchTccAction branchTccAction = method.getAnnotation(BranchTccAction.class);
        if (branchTccAction != null) {
            System.out.println("this is @BranchTccAction");
        }
        return invocation.proceed();
    }
}
