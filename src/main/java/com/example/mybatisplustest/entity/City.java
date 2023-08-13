package com.example.mybatisplustest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // 相当于在当前类上提供了 get set equals hascode tostring 等构造方法
@AllArgsConstructor     // 全部参数构造方法
@NoArgsConstructor      // 无参构造方法
public class City {
    private Integer id;
    private String name;
//    private Integer parent_id;
}
