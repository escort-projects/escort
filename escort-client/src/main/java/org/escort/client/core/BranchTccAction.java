package org.escort.client.core;

import java.lang.annotation.*;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/1 17:20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Inherited
public @interface BranchTccAction {

    // TODO TCC 可能分为 Remote 和 local

    /**
     * commit methed name
     *
     * @return the string
     */
    String commitMethod() default "commit";

    /**
     * cancel method name
     *
     * @return the string
     */
    String cancelMethod() default "cancel";

    /**
     * 是否支持异步 commit
     *
     * @return asynchronous
     */
    boolean asyncConfirm() default false;

    /**
     * 是否支持异步 cancel
     *
     * @return asynchronous
     */
    boolean asyncCancel() default false;
}
