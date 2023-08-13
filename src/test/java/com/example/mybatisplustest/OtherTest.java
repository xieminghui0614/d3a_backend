package com.example.mybatisplustest;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class OtherTest {
    @Test
    public void jsondataTest(){
        String jsonStr = JsonUtil.readJsonFile("src/main/resources/json/treedata.json");
        JSONObject result = JSONObject.parseObject(jsonStr);
        System.out.println(result);
    }
}
