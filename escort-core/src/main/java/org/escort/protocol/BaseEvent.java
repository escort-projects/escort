package org.escort.protocol;

import lombok.Data;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 18:41
 */
@Data
public class BaseEvent {

    private Integer typeCode;

    private Object data;


    public BaseEvent() {
    }

    public BaseEvent(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public BaseEvent(Integer typeCode, Object data) {
        this.typeCode = typeCode;
        this.data = data;
    }
}
