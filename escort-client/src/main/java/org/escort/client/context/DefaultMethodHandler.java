package org.escort.client.context;


import com.alibaba.fastjson.JSON;
import org.escort.client.MethodHandler;
import org.escort.exception.EscortRuntimeException;
import org.jvnet.animal_sniffer.IgnoreJRERequirement;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 16:00
 */
@IgnoreJRERequirement
public class DefaultMethodHandler implements MethodHandler {

    private Object object;
    private Method method;

    public DefaultMethodHandler(Object object, Method method) {
        this.object = object;
        this.method = method;
    }

    @Override
    public Object invoke(List<String> arguments) throws Throwable {
        Object[] args = decodeArguments(arguments);
        return method.invoke(object, args);
    }

    private Object[] decodeArguments(List<String> arguments) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != arguments.size()) {
            throw new EscortRuntimeException("method " + method.getName() + " arguments count not consistent");
        }
        List<Object> result = new ArrayList<>();
        for (int i = 0; i < arguments.size(); i++) {
            result.add(JSON.parseObject(arguments.get(i), parameterTypes[i]));
        }
        return result.toArray();
    }
}
