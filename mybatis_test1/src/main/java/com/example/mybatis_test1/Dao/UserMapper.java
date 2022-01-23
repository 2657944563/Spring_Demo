package com.example.mybatis_test1.Dao;

import com.example.mybatis_test1.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapper{
    static private SqlSession sqlSession;
    static private SqlSessionFactory build;
    static {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

    }
    public List<User> findAll() {
        sqlSession = build.openSession();
        return sqlSession.selectList("userMapper.findAll");
    }

    public List<User> findId(int id) {
        sqlSession = build.openSession();
        return sqlSession.selectList("userMapper.findId",id);
    }

    public List<User> findUser(User user) {
        sqlSession = build.openSession();
        return sqlSession.selectList("userMapper.findUser",user);
    }
}
