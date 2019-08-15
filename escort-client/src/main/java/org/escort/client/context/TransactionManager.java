package org.escort.client.context;

import org.escort.client.TransactionContext;

/**
 * 负责分布式事务RM上下文管理（动态信息）
 *
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 14:02
 */
public interface TransactionManager {

    TransactionContext getCurrentTransactionContext();

    TransactionContext startGlobalTransaction();

    void endGlobalTransaction();

    void attachTransaction(TransactionContext transactionContext);

    TransactionContext buildSpanTransactionContext();

    void endAttachTransaction();

}
