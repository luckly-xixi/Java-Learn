package com.example.demo.mapper;


import com.example.demo.model.Userinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into userinfo(username,password) values(#{username},#{password}))")
    int add(Userinfo userinfo);
}
