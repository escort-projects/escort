package org.escort.samples.tcc.order.service;

import org.escort.sample.tcc.common.AccountBalanceDTO;
import org.escort.sample.tcc.common.OrderDTO;
import org.escort.samples.tcc.order.feign.AccountFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 11:01
 */
@Service
public class OrderService {

    @Autowired
    private AccountFeignClient accountFeignClient;

    public boolean order(OrderDTO order) {
        if (accountFeignClient.deduct(AccountBalanceDTO.builder().balance(order.getBalance()).userId(order.getUserId()).build())) {
            System.out.println("Order create success: " + order);
            return true;
        }
        System.out.println("Order create fail: " + order);
        return false;
    }
}
