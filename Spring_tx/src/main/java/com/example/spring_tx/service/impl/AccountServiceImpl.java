package com.example.spring_tx.service.impl;

import com.example.spring_tx.dao.AccountDao;
import com.example.spring_tx.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outMan, String inMan, double moneyIn) {
        accountDao.out(outMan, moneyIn);
        int i = 2 / 0;
        accountDao.in(inMan, moneyIn);
    }
}
