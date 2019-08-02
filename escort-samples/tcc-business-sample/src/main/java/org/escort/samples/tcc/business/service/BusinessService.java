package org.escort.samples.tcc.business.service;

import org.escort.client.core.GlobalTccTransaction;
import org.escort.sample.tcc.common.OrderDTO;
import org.escort.sample.tcc.common.ProductStockDTO;
import org.escort.samples.tcc.business.bo.BuildOrderBO;
import org.escort.samples.tcc.business.feign.OrderFeignClient;
import org.escort.samples.tcc.business.feign.StockFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 11:16
 */
@Service
public class BusinessService {

    @Autowired
    private OrderFeignClient orderFeignClient;
    @Autowired
    private StockFeignClient stockFeignClient;

    @GlobalTccTransaction
    public void execute(BuildOrderBO buildOrder) {
        if (stockFeignClient.deduct(ProductStockDTO.builder().productId(buildOrder.getProductId()).stock(buildOrder.getStock()).build())) {
            System.out.println("deduct stock success");
            if (orderFeignClient.order(OrderDTO.builder().balance(buildOrder.getBalance()).productId(buildOrder.getProductId()).stock(buildOrder.getStock()).userId(buildOrder.getUserId()).build())) {
                System.out.println("create order success");
            } else {
                System.out.println("create order fail");
            }
        } else {
            System.out.println("deduct stock fail");
        }

    }
}
