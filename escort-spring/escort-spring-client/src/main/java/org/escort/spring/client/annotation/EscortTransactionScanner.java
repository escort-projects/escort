package org.escort.spring.client.annotation;

import org.escort.client.core.*;
import org.escort.spring.client.annotation.pattern.BranchTccActionInterceptor;
import org.escort.spring.client.annotation.pattern.GlobalTccInterceptor;
import org.escort.spring.client.util.EscortBeanParserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 21:19
 */
public class EscortTransactionScanner extends AbstractAutoProxyCreator implements InitializingBean, ApplicationContextAware, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(EscortTransactionScanner.class);

    private static Set<Class<? extends Annotation>> annotationClasses = new HashSet<>();

    static {
        annotationClasses.add(BranchSagaAction.class);
        annotationClasses.add(BranchTccAction.class);
        annotationClasses.add(GlobalTccTransaction.class);
        annotationClasses.add(GlobalSagaTransaction.class);
        annotationClasses.add(GlobalHybridTransaction.class);
    }

    public EscortTransactionScanner() {
    }

    @Override
    protected Object wrapIfNecessary(Object bean, String beanName, Object cacheKey) {
        return super.wrapIfNecessary(bean, beanName, cacheKey);
    }

    @Override
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> clazz, String beanName, TargetSource targetSource) throws BeansException {
        LOGGER.info("getAdvicesAndAdvisorsForBean: {},{}", clazz.getName(), beanName);
        if (EscortBeanParserUtils.isProxyTargetBean(clazz, GlobalTccTransaction.class)) {
            return new Object[]{new GlobalTccInterceptor()};
        } else if (EscortBeanParserUtils.isProxyTargetBean(clazz, BranchTccAction.class)) {
            return new Object[]{new BranchTccActionInterceptor()};
        }
        return null;
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
