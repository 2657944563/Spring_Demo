package com.example.spring_tx.dao.impl;

import com.example.spring_tx.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {
    public JdbcTemplate jdbcTemplate;

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void out(String outMan, double money) {
        System.out.println(outMan + " 扣钱： " + money);
        jdbcTemplate.update("update  work3.account set account.money = account.money - ? where name = ?", money, outMan);
        System.out.println("扣钱成功");
    }

    @Override
    public void in(String inMan, double money) {
        System.out.println(inMan + " 加钱： " + money);
        jdbcTemplate.update("update  work3.account set account.money = account.money + ? where name = ?", money, inMan);
        System.out.println("加钱成功");
    }
}
