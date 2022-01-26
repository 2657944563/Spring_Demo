package com.example.spring_boot_mybatis;

import com.example.spring_boot_mybatis.Dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMybatisApplicationTests {

    @Autowired
    UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(userDao.findALl());
    }

}
