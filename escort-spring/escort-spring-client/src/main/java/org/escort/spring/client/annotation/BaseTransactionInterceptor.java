package org.escort.spring.client.annotation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.escort.client.pattern.AnnotationDefine;
import org.escort.client.pattern.BusinessHandler;
import org.escort.client.pattern.PatternProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/7 11:28
 */
public abstract class BaseTransactionInterceptor implements MethodInterceptor  {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTransactionInterceptor.class);

    public abstract PatternProcessor getPatternProcessor();

    public class WrapperBusinessHandler implements BusinessHandler {
        private MethodInvocation invocation;

        public WrapperBusinessHandler(MethodInvocation invocation) {
            this.invocation = invocation;
        }

        @Override
        public Object proceed() throws Throwable {
            return invocation.proceed();
        }
    }
}
