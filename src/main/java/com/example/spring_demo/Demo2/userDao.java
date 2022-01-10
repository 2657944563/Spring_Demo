package com.example.spring_demo.Demo2;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository("userDao1")
public class userDao {


    @Resource(name = "druid")
    private DruidDataSource ds;
    @Value("${user}")
    private String name;
    @Value("${driver}")
    private String driver;

    public void setDs(DruidDataSource ds) {
        this.ds = ds;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "userDao{" +
                "ds=" + ds +
                ", name='" + name + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
