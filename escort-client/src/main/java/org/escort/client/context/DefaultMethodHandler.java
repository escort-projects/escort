package org.escort.client.context;


import org.escort.client.MethodHandler;

import java.lang.invoke.MethodHandle;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 16:00
 */
public class DefaultMethodHandler implements MethodHandler {

    private MethodHandle handle;

    public DefaultMethodHandler(MethodHandle handle) {
        this.handle = handle;
    }

    @Override
    public Object invoke(Object[] argv) throws Throwable {
        return null;
    }
}
