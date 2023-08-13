package com.example.mybatisplustest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplustest.Mapper.UserMappper;
import com.example.mybatisplustest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * QueryWrapper：查询构造器：主要用于查询数据库数据
 */
@SpringBootTest
public class WrapperTest {

    @Autowired  // 自动装配
    private UserMappper userMappper;

    // 1. 查询名字不为空且年龄大于等于18的人
    @Test
    public void wrappertest1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name").ge("age", 22);
        List<User> users = userMappper.selectList(wrapper);
        users.forEach(user -> System.out.println(user));
    }

    // 2. 查询名字为qw的人
    @Test
    public void wrappertest2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "qw");
        List<User> users = userMappper.selectList(wrapper);
        users.forEach(user -> System.out.println(user));
    }
    // 3. 查询名字不包含Jurry的人
    @Test
    public void wrappertest3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("name","Jurry");
        List<User> users = userMappper.selectList(wrapper);
        users.forEach(user -> System.out.println(user));
    }

    // 4. 查询名字包含Jurry 且 （年龄 》 26 或 邮箱不为空）的人： 含有多个条件的wrapper，lambda表达式
    @Test
    public void wrappertest4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","Jurry")
                .and(a->a.le("age", 22).or().isNull("email"));
        List<User> users = userMappper.selectList(wrapper);
        users.forEach(user -> System.out.println(user));
    }
}
