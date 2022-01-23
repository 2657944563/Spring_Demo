package com.example.mybatis_test1.service;

import com.example.mybatis_test1.Dao.UserMapper;
import com.example.mybatis_test1.Dao.UserMapperInterface;
import com.example.mybatis_test1.domain.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {
    /**
     * 原始Dao写法
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        System.out.println(new UserMapper().findAll());
        System.out.println(new UserMapper().findId(1));
    }

    /**
     * 注解代理模式写法
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        System.out.println(mapper.findAll());
        System.out.println(mapper.findId(3));
    }

    /**
     * 测试动态sql
     */
    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        User user = new User();
        user.setId(1);
//        user.setName("zhangsan");
//        user.setPassword("123");
        System.out.println(mapper.findUser(user));
    }

    @Test
    public void test4() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(mapper.findIds(integers));
    }

    /**
     * 自定义类型转换器测试，存入
     *
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        User user = new User();
        user.setPassword("123");
        user.setName("test1");
        user.setBrithDay(new Date());
        System.out.println(mapper.insertUser(user));
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 自定义类型转换器测试,取出
     *
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        List<User> userList = mapper.findId(8);
        System.out.println(userList);
        sqlSession.close();
    }

    /**
     * 查询全部用于分页插件的测试
     */
    @Test
    public void test7() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        PageHelper.startPage(1, 3);
        List<User> userList = mapper.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println(pageInfo.isIsFirstPage());
        System.out.println(pageInfo.isIsLastPage());
        System.out.println(pageInfo);
        System.out.println(userList);
        sqlSession.close();
    }
}
