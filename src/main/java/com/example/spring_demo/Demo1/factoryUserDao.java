package com.example.spring_demo.Demo1;

public class factoryUserDao {
    public static UserDao retUserDao(){
        return new UserDaoImpl();
    }
    public UserDao retUserDao1(){
        return new UserDaoImpl();
    }
}
