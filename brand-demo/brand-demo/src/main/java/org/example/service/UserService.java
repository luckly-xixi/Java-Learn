package org.example.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.util.SqlSessionFactoryUtils;

public class UserService {

    //获取连接
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        //获取SqlSession
        SqlSession sqlSession = factory.openSession();

        // 获取 Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 调用方法
        User user = mapper.select(username, password);

        // 释放资源
        sqlSession.close();

        return user;
    }


    /**
     * 注册功能
     * @param user
     * @return
     */
    public boolean register(User user) {
        //获取SqlSession
        SqlSession sqlSession = factory.openSession();

        // 获取 Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 调用方法,判断用户是否存在
        User u = mapper.selectByUsername(user.getUsername());

        if(u == null) {
            //用户不存在
            mapper.add(user);
            sqlSession.commit();
        }

        // 释放资源
        sqlSession.close();

        return u == null;
    }
}
