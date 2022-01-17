package com.example.spring_tx_anno.service.impl;

import com.example.spring_tx_anno.dao.AccountDao;
import com.example.spring_tx_anno.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountService")
@Transactional(isolation = Isolation.READ_COMMITTED)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public void transfer(String outMan, String inMan, double moneyIn) {
            accountDao.out(outMan, moneyIn);
            int i = 2 / 0;
            accountDao.in(inMan, moneyIn);
    }
}
