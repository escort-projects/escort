package org.escort.samples.tcc.account.service;

import org.escort.sample.tcc.common.AccountBalanceDTO;
import org.springframework.stereotype.Service;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 10:11
 */
@Service
public class AccountService {

    public boolean deduct(AccountBalanceDTO accountBalance) {
        System.out.println("Account deduct balance: " + accountBalance);
        return true;
    }
}
