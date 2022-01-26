package com.example.spring_boot_druid.Dao;

import com.example.spring_boot_druid.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper{

    @Select("select * from mybatis.user")
    public List<User> findAll();
}
