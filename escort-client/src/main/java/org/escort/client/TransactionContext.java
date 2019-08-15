package org.escort.client;

import lombok.Data;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/15 19:43
 */
@Data
public class TransactionContext implements Serializable {

    public static Integer GLOBAL = 0;
    public static Integer ZERO = 0;

    private volatile AtomicInteger spanIncrease = new AtomicInteger(0);

    public TransactionContext() {
    }

    public TransactionContext(Integer xid) {
        this.xid = xid;
        this.parentId = GLOBAL;
        this.spanId = ZERO;
    }

    public TransactionContext(Integer xid, Integer parentId, Integer spanId) {
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

    public boolean isGlobal() {
        return GLOBAL.equals(parentId);
    }

    public Integer addAndGetSpanId() {
        return spanIncrease.addAndGet(1);
    }

}
