package org.escort.client.core;

import org.escort.client.handler.DefaultExceptionHandler;

import java.lang.annotation.*;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 20:44
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
public @interface GlobalTccTransaction {

    // 无异常处理类，统一记录日志，不影响当前方法执行

    /**
     * 可选，统一处理类
     *
     * @return DefaultExceptionHandler
     */
    Class exceptionHandlerClass() default DefaultExceptionHandler.class;

    /**
     * 可选，Commit失败处理
     *
     * @return DefaultExceptionHandler
     */
    Class exceptionCommitHandlerClass() default DefaultExceptionHandler.class;

    /**
     * 可选，Cancel失败处理
     *
     * @return DefaultExceptionHandler
     */
    Class exceptionCancelHandlerClass() default DefaultExceptionHandler.class;

    // TODO 以下部分后续移植到 spring 包中

    /**
     * 可选，统一处理Bean，需要Spring支持，无 Spring 环境忽略
     *
     * @return beanName
     */
    String exceptionHandlerBeanName() default "";

    /**
     * 可选，Commit失败处理Bean，需要Spring支持，无Spring环境忽略
     *
     * @return beanName
     */
    String exceptionCommitHandlerBeanName() default "";

    /**
     * 可选，Cancel失败处理Bean，需要Spring支持，无Spring环境忽略
     *
     * @return beanName
     */
    String exceptionCancelHandlerBeanName() default "";
}
