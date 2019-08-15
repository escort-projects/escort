package org.escort.samples.tcc.business.controller;

import org.escort.samples.tcc.business.bo.BuildOrderBO;
import org.escort.samples.tcc.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 10:11
 */
@RestController
public class StockController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    public Boolean deduct() {
        businessService.execute(new BuildOrderBO(1, 2, 3, new BigDecimal(4)));
        return true;
    }

}
