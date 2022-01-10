package com.example.spring_demo.Demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImpl userDao = (UserDaoImpl) app.getBean("userDao");
        userDao.save();
    }
}
