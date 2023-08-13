package com.example.mybatisplustest.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplustest.entity.City;
import com.example.mybatisplustest.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMappper extends BaseMapper<User> {

    // 1.继承BaseMapper后，几乎实现了所有的CRUD操作

    // 2. 也可以自定义CRUD操作
//    自定义根据name查询数据
    @Select("select * from user where name = #{name}")
    List<User> selectbyname(String name);

    @Select("SELECT id,name FROM codec_area WHERE parent_id = #{area_id}")
    List<City> selectsonbyparent(Integer area_id);
}
