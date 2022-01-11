package com.example.Service.ServiceImpl;

import com.example.Dao.userDao;
import com.example.Service.userService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class userServiceImpl implements userService {
    @Resource(name = "userDao")
    private userDao userDao;
    @Override
    public void show() {
        System.out.println("service层获取dao层提供的druid进行展示操作");
        userDao.save();
    }
}
