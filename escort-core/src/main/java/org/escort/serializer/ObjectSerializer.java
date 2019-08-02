package org.escort.serializer;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 19:31
 */
public interface ObjectSerializer<T> {

    byte[] serialize(T t);

    T deserialize(byte[] bytes);
}
