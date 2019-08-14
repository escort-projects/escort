package org.escort.serializer;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/14 17:49
 */
public class JdkSerializer<T extends Serializable> implements ObjectSerializer<T> {

    @Override
    public byte[] serialize(T o) {
        return SerializationUtils.serialize(o);
    }

    @Override
    public T deserialize(byte[] bytes) {
        return (T) SerializationUtils.deserialize(bytes);
    }
}
