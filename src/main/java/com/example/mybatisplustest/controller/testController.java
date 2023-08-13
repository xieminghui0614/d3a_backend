package com.example.mybatisplustest.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatisplustest.JsonUtil;
import com.example.mybatisplustest.Mapper.UserMappper;
import com.example.mybatisplustest.entity.City;
import com.example.mybatisplustest.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/test")
public class testController {
    @Autowired
    private UserMappper userMappper;

    @GetMapping("/sub_regions")
    public R getSubregions(int area_id){
        List<City> res = userMappper.selectsonbyparent(area_id);
        return R.success(res);
    }

    @PostMapping("/gettree")
    public R getTree(){
        String jsonStr = JsonUtil.readJsonFile("src/main/resources/json/treedata.json");
        JSONObject result = JSONObject.parseObject(jsonStr);
        return R.success(result);
    }

}
