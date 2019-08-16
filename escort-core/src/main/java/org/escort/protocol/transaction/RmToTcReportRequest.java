package org.escort.protocol.transaction;

import lombok.Data;
import org.escort.protocol.TypeCodeDefine;

import java.util.List;

/**
 * RM report to TC
 *
 * @Author: Shoukai Huang
 * @Date: 2019/8/1 19:04
 */
@Data
public class RmToTcReportRequest extends AbstractRequest {

    @Override
    public int getTypeCode() {
        return TypeCodeDefine.TYPE_RM_TC_REPORT;
    }

    public RmToTcReportRequest(Integer xid, Integer parentId, Integer spanId) {
        this.xid = xid;
        this.parentId = parentId;
        this.spanId = spanId;
    }

    /**
     * 全局事务id
     */
    private Integer xid;
    /**
     * 父级id
     */
    private Integer parentId;
    /**
     * span id
     */
    private Integer spanId;
    /**
     * 业务参数
     */
    private List<Object> arguments;


}
