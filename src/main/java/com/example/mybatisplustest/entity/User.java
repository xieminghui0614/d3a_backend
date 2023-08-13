package com.example.mybatisplustest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // 相当于在当前类上提供了 get set equals hascode tostring 等构造方法
@AllArgsConstructor     // 全部参数构造方法
@NoArgsConstructor      // 无参构造方法
public class User {
//    配置表的主键后便可以设置主键生成策略：AUTO自增
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
