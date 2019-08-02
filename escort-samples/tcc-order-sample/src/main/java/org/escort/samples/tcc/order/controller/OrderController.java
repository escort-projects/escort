package org.escort.samples.tcc.order.controller;

import org.escort.sample.tcc.common.OrderDTO;
import org.escort.sample.tcc.common.ProductStockDTO;
import org.escort.samples.tcc.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 11:00
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Boolean deduct(@RequestBody OrderDTO order) {
        return orderService.order(order);
    }

}
