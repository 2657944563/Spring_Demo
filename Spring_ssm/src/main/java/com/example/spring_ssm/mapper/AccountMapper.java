package com.example.spring_ssm.mapper;

import com.example.spring_ssm.domain.Account;

import java.util.List;

public interface AccountMapper {
    public void save(Account account);
    public List<Account> findAll();
}
