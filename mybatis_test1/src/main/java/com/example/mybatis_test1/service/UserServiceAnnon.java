package com.example.mybatis_test1.service;

import com.example.mybatis_test1.Dao.UserMapperInterface;
import com.example.mybatis_test1.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserServiceAnnon {
    UserMapperInterface mapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
       mapper = sqlSession.getMapper(UserMapperInterface.class);
    }
    /**
     * 注解开发测试
     */
    @Test
    public void test1() throws IOException {
        mapper.deleteUser(1);
    }

    @Test
    public void test2() throws IOException {
        User user = new User();
        user.setId(3);
        user.setName("123123");
        user.setPassword("3333333333333333");
        mapper.updateUser(user);
    }

    @Test
    public void test3() {
        User byUserId = mapper.findByUserId(3);
        System.out.println(byUserId);
    }


}
