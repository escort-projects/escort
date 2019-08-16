package org.escort.samples.tcc.stock.service;

import org.escort.client.core.BranchTccAction;
import org.escort.sample.tcc.common.ProductStockDTO;
import org.springframework.stereotype.Service;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 10:11
 */
@Service
public class StockService {

    @BranchTccAction(commitMethod = "commit", cancelMethod = "cancel", asyncConfirm = true, asyncCancel = true, retryMaxAttempts = 3, retryPeriod = 100L, retryMaxPeriod = 1000L)
    public boolean deduct(ProductStockDTO productStock) {
        System.out.println("Product deduct stock: " + productStock);
        return true;
    }

    public void commit(ProductStockDTO productStock) {
        System.out.println("StockService commit 方法执行");
    }

    public void cancel(ProductStockDTO productStock) {
        System.out.println("StockService cancel 方法执行");
    }
}
