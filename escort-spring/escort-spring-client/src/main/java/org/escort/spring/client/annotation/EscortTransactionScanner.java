package org.escort.spring.client.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class EscortTransactionScanner extends AbstractAutoProxyCreator implements InitializingBean, ApplicationContextAware, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(EscortTransactionScanner.class);

    public EscortTransactionScanner() {
    }

    @Override
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> clazz, String beanName, TargetSource targetSource) throws BeansException {
        LOGGER.info("getAdvicesAndAdvisorsForBean: {},{}", clazz.getName(), beanName);
        return new Object[]{};
    }

    @Override
    protected Object wrapIfNecessary(Object bean, String beanName, Object cacheKey) {
        LOGGER.debug("wrapIfNecessary: {},{},{}", bean, beanName, cacheKey);
        return bean;
    }

    /**
     * DisposableBean
     */
    @Override
    public void destroy() {
        // TODO 对象销毁
    }

    /**
     * InitializingBean
     */
    @Override
    public void afterPropertiesSet() {
        // TODO 对象初始化
    }

    /**
     * ApplicationContextAware
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.setBeanFactory(applicationContext);
    }
}
