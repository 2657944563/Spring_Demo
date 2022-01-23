package com.example.spring_ssm.controller;

import com.example.spring_ssm.domain.Account;
import com.example.spring_ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @author 2657944563
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //保存
    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account) throws IOException {
        accountService.save(account);
        return "保存成功";
    }

    //查询

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws IOException {
        List<Account> accountList = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/pages/accountList.jsp");
        modelAndView.addObject("accountList", accountList);
        return modelAndView;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }
}
