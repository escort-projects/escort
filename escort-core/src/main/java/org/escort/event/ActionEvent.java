package org.escort.event;

import lombok.Builder;
import lombok.Data;

/**
 * TC call RM / TM
 *
 * @Author: Shoukai Huang
 * @Date: 2019/8/1 19:16
 */
@Data
@Builder
public class ActionEvent {

    /**
     * 调用参数
     */
    private Object body;
}
