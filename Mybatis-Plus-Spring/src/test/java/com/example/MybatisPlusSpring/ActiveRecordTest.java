package com.example.MybatisPlusSpring;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.MybatisPlusSpring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ActiveRecordTest {
    @Test
    public void test1() {
        User user = new User();
        user.setId(2L);
        System.out.println(user.selectById());
    }

    @Test
    public void test2() {
        User user = new User();
//        user.setEmail("233@23.com");
        user.setId(112L);
//        user.setName("liubei");
//        System.out.println(user.insert());
        user.deleteById();
    }

    @Test
    public void test3() {
        User user = new User();
        user.setName("liubei");
        System.out.println(user.selectList(new QueryWrapper<User>().gt("id", 100)));
    }
}
