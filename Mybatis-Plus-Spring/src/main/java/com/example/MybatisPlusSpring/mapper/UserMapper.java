package com.example.MybatisPlusSpring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.MybatisPlusSpring.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from mybatis.user")
    public List<User> findAll();
}
