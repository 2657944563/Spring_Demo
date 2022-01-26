package com.example.spring_boot_mybatis.Dao;

import com.example.spring_boot_mybatis.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from mybatis.user")
    public List<User> findALl();
}
