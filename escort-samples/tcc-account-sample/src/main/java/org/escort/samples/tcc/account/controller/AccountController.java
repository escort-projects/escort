package org.escort.samples.tcc.account.controller;

import org.escort.sample.tcc.common.AccountBalanceDTO;
import org.escort.samples.tcc.account.service.AccountService;
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
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/deduct", method = RequestMethod.POST)
    public Boolean deduct(@RequestBody AccountBalanceDTO accountBalance) {
        return accountService.deduct(accountBalance);
    }

}
