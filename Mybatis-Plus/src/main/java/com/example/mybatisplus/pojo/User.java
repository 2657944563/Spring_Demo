package com.example.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 2657944563
 */
@Data
@NoArgsConstructor//无参构造
@AllArgsConstructor//全参构造
@TableName("user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}