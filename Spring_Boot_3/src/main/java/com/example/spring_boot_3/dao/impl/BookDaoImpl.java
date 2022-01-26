package com.example.spring_boot_3.dao.impl;

import com.example.spring_boot_3.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao runing...");
    }
}
