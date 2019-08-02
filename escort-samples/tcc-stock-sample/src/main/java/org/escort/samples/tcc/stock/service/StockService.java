package org.escort.samples.tcc.stock.service;

import org.escort.sample.tcc.common.ProductStockDTO;
import org.springframework.stereotype.Service;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 10:11
 */
@Service
public class StockService {

    public boolean deduct(ProductStockDTO productStock) {
        System.out.println("Product deduct stock: " + productStock);
        return true;
    }
}
