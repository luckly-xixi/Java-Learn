package com.example.demo.dao;


import com.example.demo.model.Userinfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //数据持久层标志
public interface UserMapper {
    //查询所有信息
    List<Userinfo> getAll();

//    根据Id查询信息
    Userinfo getUserById(@Param("id") Integer uid); //最好加上 Param 不然会有问题

//    SQL注入
    Userinfo login(@Param("name")String username,@Param("word")String password);

//    删除操作
    int delById(@Param("id")Integer id);

//    定义resultMap,将属性名和字段名手动映射
    Userinfo gatAllByOrder(@Param("myorder")String myorder);

//    修改操作
    int update(Userinfo userinfo);

//    新增操作
    int add(Userinfo userinfo);

//    获取新增ID
    int insert(Userinfo userinfo);

//    like查询
     List<Userinfo> getLikeList(@Param("username")String username);

//     联合查询组件，混合使用注解和插件
    @Select("select * from userinfo where id=#{id}")
    Userinfo getUserById2(@Param("id")Integer id);

//    动态 <if>标签
    int add2(Userinfo userinfo);

//    动态 <trim> 标签
    int add3(Userinfo userinfo);

//    动态 <where> 标签
    List<Userinfo> getListByWhere(Userinfo userinfo);

//    动态 <set> 标签
    int update2(Userinfo userinfo);

//    动态 <foreach> 标签
    int delByIds(List<Integer> ids);
}
