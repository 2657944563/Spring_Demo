package com.example.MybatisPlusSpring.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User extends Model<User> {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("name")//指定数据库字段名
    private String name;
    private Integer age;
    private String email;
    @TableField(exist = false,select = false)//exits:指定属性不存在数据库中,select:指定不能被查询
    private String address;
}
