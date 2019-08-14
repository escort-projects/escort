package org.escort.spring.client.annotation;

import org.escort.client.pattern.PatternProcessor;
import org.escort.common.utils.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 21:19
 */
public class EscortTransactionScanner extends AbstractAutoProxyCreator implements InitializingBean, ApplicationContextAware, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(EscortTransactionScanner.class);

    @Autowired
    private InterceptorFilter interceptorFilter;

    public EscortTransactionScanner() {
    }

    @Override
    protected Object wrapIfNecessary(Object bean, String beanName, Object cacheKey) {
        return super.wrapIfNecessary(bean, beanName, cacheKey);
    }

    @Override
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> clazz, String beanName, TargetSource targetSource) throws BeansException {
        LOGGER.info("getAdvicesAndAdvisorsForBean: {},{}", clazz.getName(), beanName);
        for (BaseTransactionInterceptor baseTransactionInterceptor : interceptorFilter.getInterceptors()) {
            PatternProcessor patternProcessor = baseTransactionInterceptor.getPatternProcessor();
            if (ReflectionUtils.isProxyTargetBean(clazz, patternProcessor.getAnnotation())) {
                try {
                    Method method = ReflectionUtils.getMethodByAnnotation(clazz, patternProcessor.getAnnotation());
                    patternProcessor.init(method.getAnnotation(patternProcessor.getAnnotation()), clazz, method);
                    return new Object[]{baseTransactionInterceptor};
                } catch (Exception e) {
                    LOGGER.error("init PatternProcessor error. ", e);
                }
            }
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
