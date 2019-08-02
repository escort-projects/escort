package org.escort.samples.tcc.stock.controller;

import org.escort.sample.tcc.common.ProductStockDTO;
import org.escort.samples.tcc.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 10:11
 */
@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/deduct", method = RequestMethod.POST)
    public Boolean deduct(@RequestBody ProductStockDTO productStock) {
        return stockService.deduct(productStock);
    }

}
