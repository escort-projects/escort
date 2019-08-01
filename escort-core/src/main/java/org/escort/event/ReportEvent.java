package org.escort.event;

import lombok.Builder;
import lombok.Data;

/**
 * RM report to TC
 *
 * @Author: Shoukai Huang
 * @Date: 2019/8/1 19:04
 */
@Data
@Builder
public class ReportEvent {

    private int xid;
    private int parentId;
    private int spanId;

    /**
     * 调用参数
     */
    private Object body;

}
