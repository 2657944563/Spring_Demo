package com.example.spring_ssm.service.Impl;

import com.example.spring_ssm.domain.Account;
import com.example.spring_ssm.mapper.AccountMapper;
import com.example.spring_ssm.service.AccountService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private SqlSessionFactory accountSqlSessionFactory;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public void save(Account account) throws IOException {
//        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSession sqlSession  = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession(true);
//        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
//        mapper.save(account);
//        sqlSession.close();
        accountMapper.save(account);
    }

    @Override
    @Transactional
    public List<Account> findAll() throws IOException {
//        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession(true);
//        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
//        List<Account> accountList = mapper.findAll();
//        sqlSession.close();
        SqlSession sqlSession = accountSqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        return mapper.findAll();
    }
}
