package com.example.mybatisplustest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * 测试Redis的常用操作
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    // 1. String 类型数值
    @Test
    public void redistest1(){
        redisTemplate.opsForValue().set("age", 18, 30, TimeUnit.SECONDS);
        Object age =  redisTemplate.opsForValue().get("age");
        System.out.println(age);
    }

    // 2.list类型 lpush rpush lpop rpop lrange
    @Test
    public void redistest2(){
        redisTemplate.opsForList().leftPushAll("list01", "A","B","C","D","E");

        redisTemplate.opsForList().rightPushAll("list01", "X","Y","Z");

        List<Object> objectlist = redisTemplate.opsForList().range("list01", 0L, -1L);
        System.out.println(objectlist);

        Object o = redisTemplate.opsForList().leftPop("list01");
        System.out.println(o);

        Object o1 = redisTemplate.opsForList().rightPop("list01");
        System.out.println(o1);
    }
}
