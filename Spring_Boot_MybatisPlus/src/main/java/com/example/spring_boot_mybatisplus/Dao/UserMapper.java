package com.example.spring_boot_mybatisplus.Dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spring_boot_mybatisplus.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from mybatis.user")
    public List<User> findAll();
}
