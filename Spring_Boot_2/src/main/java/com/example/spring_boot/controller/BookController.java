package com.example.spring_boot.controller;

import com.example.spring_boot.pojo.MyDataSourece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//rest风格
@RestController
@RequestMapping("/book")
public class BookController {

//    @Value("${count}")//    读取配置文件中的数据
//    String ct;

    @Autowired
    Environment environment;
    @Autowired
    MyDataSourece myDataSourece;

    @GetMapping
    public String getById() {
        System.out.println("getById");
        System.out.println(myDataSourece.getUsername());
        return "getById.....好";
    }
}
