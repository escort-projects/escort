package org.escort.serializer;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 17:49
 */
public class JdkSerializer
//        implements ObjectSerializer
{

//    @Override
    public <T extends Serializable> byte[] serialize(T o) {
        return SerializationUtils.serialize(o);
    }

//    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        return (T) SerializationUtils.deserialize(bytes);
    }
}
