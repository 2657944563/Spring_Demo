package com.example.MybatisPlusSpring;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.MybatisPlusSpring.mapper.UserMapper;
import com.example.MybatisPlusSpring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试查询
     */
    @Test
    public void test1() {
        System.out.println(userMapper.findAll());
        System.out.println(userMapper.selectList(null));
    }

    /**
     * 条件查询
     */
    @Test
    public void test4() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("id", 1);
        System.out.println(userMapper.selectList(wrapper));
    }
    /**
     * 分页查询测试
     */
    @Test
    public void test6() {
        IPage<User> userIPage = new Page<>(2, 10);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "mbr");
        IPage<User> page = userMapper.selectPage(userIPage, wrapper);
        System.out.println(page.getPages()+"__________________");
        final List<User> records = page.getRecords();
        System.out.println(records);
    }

    /**
     * 测试插入
     */
    @Test
    public void test2() {

//        user.setId(19L);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setAge(123);
            user.setEmail("123@.123.com");
            user.setName("mbr");
            user.setAge(i);
            userMapper.insert(user);
            sum++;
            System.out.println("id: "+user.getId());
        }
            System.out.println("插入了: " + sum + " 条语句");
    }

    /**
     * 更新测试
     */
    @Test
    public void test3() {
        User user = new User();
        user.setId(7L);
        user.setName("xxx");
//        userMapper.updateById(user);//根据id更新
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("name", "zhangsan").ge("id", 6);
        userMapper.update(user, wrapper);//根据条件更新
    }

    /**
     * 删除测试
     */
    @Test
    public void test5() {
//        userMapper.deleteById(9);//根据id删除

/*        Map<String, Object> map = new HashMap<>();
        map.put("id", 8);
        map.put("name", "zhangsan");
        userMapper.deleteByMap(map);//根据Map删除,条件关系为AND
        */


/*        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("id", 4);//条件设置,id大于4
        userMapper.delete(wrapper);//条件删除
        */

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            linkedList.add(i + 10);
        }
        userMapper.deleteBatchIds(linkedList);//使用集合作为id条件删除
    }

    @Test
    public void test7() {
        System.out.println(userMapper.findAll());
    }
}
