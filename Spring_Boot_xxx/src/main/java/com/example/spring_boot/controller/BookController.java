package com.example.spring_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//rest风格
@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping
    public String getById() {
        System.out.println("getById");
        return "getById.....";
    }
}
