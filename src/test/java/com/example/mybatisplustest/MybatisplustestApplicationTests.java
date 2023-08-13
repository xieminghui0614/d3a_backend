package com.example.mybatisplustest;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplustest.Mapper.UserMappper;
import com.example.mybatisplustest.entity.City;
import com.example.mybatisplustest.entity.User;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisplustestApplicationTests {
    @Autowired  // 自动装配
    private UserMappper userMappper;

    @Test
    public void queryson() {
        // 根据父名称查询父名称下所有的城市
        List<City> res = userMappper.selectsonbyparent(56);
        res.forEach(r -> System.out.println(r));
    }

    @Test
    public void queralllist() {
        // 1. 查询全部用户
        List<User> users = userMappper.selectList(null);
        users.forEach(user -> System.out.println(user));
    }
    @Test
    public void deletetest() {
        // 2. 根据map删除对应数据
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jone");
        map.put("age", 18);
        int num = userMappper.deleteByMap(map);
        System.out.println("DeletebyMap 函数返回："+num);
    }

    @Test
    public void updatetest() {
        // 3. 修改元素
        User user = new User();
        user.setId(4L);
        user.setName("zhansgan");
        int num = userMappper.updateById(user);
        System.out.println(num);
    }

    @Test
    public void selecttest() {
        // 4. 查询测试
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("id", 4L);
        List<User> users = userMappper.selectByMap(map);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void selectbynametest() {
        // 5. 测试自定义的CRUD方法：根据name查询数据
        String name = "Tom";
        List<User> users = userMappper.selectbyname(name);
        users.forEach(user -> System.out.println(user));
    }
    @Test
    public void inserttest() {
        // 6. 插入数据测试
        for(int i= 0; i< 10;i ++){
            User user = new User();
            user.setName("Jurry" + i);
            user.setAge(20 + i);
            user.setEmail("100000" + i + "@qq.com");
            int res = userMappper.insert(user);
            System.out.println(res);
        }
    }

    @Test
    public void PaginationTest() {
        // 7. 分页测试
        /**
         *
         * current: 当前页
         * size：每页显示的数量
         * 底层就是使用limit的分页：（index-1） * Pagesize
         */
        Page<User> page = new Page<>(3, 3);
        userMappper.selectPage(page, null);

        // 获取记录
        List<User> users = page.getRecords();
        users.forEach(user -> System.out.println(user));
    }

    @Test
    void contextLoads() {
        List<User> users = userMappper.selectList(null);
        users.forEach(user -> System.out.println(user));

    }

}
