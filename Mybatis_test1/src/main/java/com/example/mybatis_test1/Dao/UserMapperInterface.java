package com.example.mybatis_test1.Dao;

import com.example.mybatis_test1.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 2657944563
 */
public interface UserMapperInterface {
    public List<User> findAll();

    public List<User> findId(int id);

    public List<User> findUser(User user);

    public List<User> findIds(List<Integer> list);

    @Insert("insert into mybatis.user values (#{id}, #{name}, #{password}, #{brithDay})")
    public int insertUser(User user);

    @Update("update mybatis.user set name = #{name},password = #{password} where id = #{id}")
    public int updateUser(User user);

    @Delete("delete from mybatis.user where id = #{id}")
    public int deleteUser(int id);

    @Select("select * from mybatis.user where id = #{id}")
    public User findByUserId(int id);

}
