package org.escort.client.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * process transaction context
 *
 * @Author: Shoukai Huang
 * @Date: 2019/8/8 14:02
 */
public class TransactionManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionManager.class);

    private static final ThreadLocal<TransactionContext> CURRENT = new ThreadLocal<>();

    public void start(TransactionContext context) {
        LOGGER.debug("start a transaction. {}", context);
    }

    public void end() {
        LOGGER.debug("end a transaction. {}", getCurrent());
        CURRENT.remove();
    }

    public TransactionContext getCurrent() {
        return CURRENT.get();
    }

}
