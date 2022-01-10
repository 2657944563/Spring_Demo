package com.example.spring_demo.Demo1;



import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    private int age;
    private String name;
    private List<String> md;
    private Map<String,String> mp;
    private Properties properties;


    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setMd(List md) {
        this.md = md;
    }

    public void setMp(Map mp) {
        this.mp = mp;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDaoImpl() {
//        System.out.println("无参构造.....");
    }

    public void init() {
//        System.out.println("初始化方法.....");
    }

    public void destroy() {
        System.out.println("销毁方法.....");
    }

    @Override
    public void save() {
        System.out.println("age:" + age);
        System.out.println("name:" + name);
        System.out.println("mp:" + mp);
        System.out.println("md:" + md);
        System.out.println("properties:" + properties);
        System.out.println("save.....");
    }
}
