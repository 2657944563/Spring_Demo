package com.example.spring_demo.Demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//@Scope("singleton")
@Scope("prototype")
@Component("userService1")
public class userService {
//    @Autowired
//    @Qualifier("userDao1")
    @Resource(name = "userDao1")
    private userDao userDao;
    public void save() {
        System.out.println(userDao);
    }
    @PostConstruct
    public void init() {
        System.out.println("service的初始化");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("service的销毁方法");
    }

}
