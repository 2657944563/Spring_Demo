package com.example.spring_boot_mybatisplus;


import com.example.spring_boot_mybatisplus.Dao.UserMapper;
import com.example.spring_boot_mybatisplus.Pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(userMapper.selectById(1));
        System.out.println(userMapper.findAll());
        User user = new User();
        user.setId(1L);
        System.out.println(user.selectById());
    }

}
