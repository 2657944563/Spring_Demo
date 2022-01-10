package com.example.spring_demo.Demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServse {
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }


    public UserServse(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServse() {
    }

    public void save() {
        userDao.save();
    }

}
