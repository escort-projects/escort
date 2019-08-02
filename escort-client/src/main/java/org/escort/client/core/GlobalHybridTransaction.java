package org.escort.client.core;

import java.lang.annotation.*;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 20:54
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Inherited
public @interface GlobalHybridTransaction {
}
