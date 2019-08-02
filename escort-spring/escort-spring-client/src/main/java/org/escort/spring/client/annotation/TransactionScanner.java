package org.escort.spring.client.annotation;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 21:19
 */
public class TransactionScanner extends AbstractAutoProxyCreator implements InitializingBean, ApplicationContextAware, DisposableBean {

    @Override
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> clazz, String beanName, TargetSource targetSource) throws BeansException {
        return new Object[0];
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
