package org.escort.client.context;

import java.io.Serializable;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 14:04
 */
public class TransactionContext implements Serializable {

    private static Integer GLOBAL = 0;

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
    private Object body;

    public boolean isGlobal() {
        return GLOBAL.equals(parentId);
    }

}
