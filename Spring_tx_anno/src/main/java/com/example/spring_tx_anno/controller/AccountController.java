package com.example.spring_tx_anno.controller;

import com.example.spring_tx_anno.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountController {
    public static void main(String[] args) {
        Object object;
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = app.getBean(AccountService.class);
        System.out.println(accountService);
        accountService.transfer("zs", "ls", 500);
    }
}
