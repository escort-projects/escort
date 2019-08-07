package org.escort.client.core;

import java.lang.annotation.*;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/1 17:20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Inherited
public @interface BranchSagaAction {

    // TODO Saga 可能分为 Remote 和 local

    /**
     * compensable method name
     *
     * @return the string
     */
    String compensableMethod() default "compensable";

    /**
     * 是否支持异步 compensable
     *
     * @return asynchronous
     */
    boolean asyncCompensable() default false;

}
