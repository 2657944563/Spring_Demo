package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.pojo.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    public List<User> findAll();
}

