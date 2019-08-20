package org.escort.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 18:41
 */
@Data
public class BaseEvent implements Serializable {

    // 消息对象
    private BaseData message;
    // 处理器标识
    private String processorId;

    public BaseEvent(String processorId, BaseData message) {
        this.processorId = processorId;
        this.message = message;
    }

    public <T> T caseData(Class<T> clazz) {
        if (message == null) {
            return null;
        }
        return (T) message;
    }
}
