package com.example.demo.dao;

import com.example.demo.model.Articleinfo;
import com.example.demo.model.Userinfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@SpringBootTest  //不能省略，告诉当前的测试程序，目前项目是运行在 Spring Boot 容器中
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void getAll() {
        List<Userinfo> list = userMapper.getAll();
        System.out.println(list);
    }

    @Test
    void getUserById() {
        Userinfo userinfo = userMapper.getUserById(1);
        System.out.println(userinfo.toString());
    }

    @Transactional //测试删除会自动回滚
    @Test
    void delById() {
        int id = 2;
        int result = userMapper.delById(id);
        System.out.println("受影响的行数" + result);
    }

    @Test
    void login() {
        String username = "admin";
        String password = "' or 1='1";
        Userinfo userinfo = userMapper.login(username,password);
        System.out.println(userinfo);
    }

    @Test
    void gatAllByOrder() {
        String myorder = "desc";
        Userinfo userinfo = userMapper.gatAllByOrder(myorder);
        System.out.println(userinfo);
    }

    @Transactional
    @Test
    void update() {
        Userinfo userinfo = new Userinfo();
        userinfo.setId(1);
        userinfo.setUsername("超级管理员");
        int result =  userMapper.update(userinfo);
        System.out.println("受影响的行数:" + result);
    }

    @Test
    void add() {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("法外狂徒");
        userinfo.setPassword("123");
        userinfo.setPhoto("/image/default.png");
        int result = userMapper.add(userinfo);
        System.out.println("受影响的行数:" + result);
    }

    @Test
    void insert() {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("黑猫警长");
        userinfo.setPassword("123");
        userinfo.setPhoto("");
        int result = userMapper.insert(userinfo);
        System.out.println("受影响的行数:" + result + "  | ID:" + userinfo.getId());
    }

    @Test
    void getLikeList() {
        String username = "三";
        List<Userinfo> list = userMapper.getLikeList(username);
        System.out.println(list);
    }


    @Test
    void getUserList() {
        int uid = 1;


//        单线程
//        //1.根据 uid 查询 userinfo
//        Userinfo userinfo = userMapper.getUserById2(uid);
////        System.out.println(userinfo);
//        //2.根据 uid 查询文章列表
//        List<Articleinfo> list = articleMapper.getListByUid(uid);
////        System.out.println(list);
//        userinfo.setAList(list);
//        System.out.println(userinfo);


//        多线程

        ThreadPoolExecutor threadPool =
                new ThreadPoolExecutor(5,10,100,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(100));

        final Object[] resultArray = new Object[2];

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                resultArray[0] = userMapper.getUserById2(uid);
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                resultArray[1] = articleMapper.getListByUid(uid);
            }
        });

        while (threadPool.getTaskCount() !=threadPool.getCompletedTaskCount()){

        }

        Userinfo userinfo = (Userinfo) resultArray[0];
        userinfo.setAList((List<Articleinfo>) resultArray[1]);
        System.out.println(userinfo);
    }


    @Test
    void add2() {
        Userinfo userinfo = new Userinfo();
//        userinfo.setUsername("坤坤");
//        userinfo.setPassword("123");
//        userinfo.setPhoto("cat.png");
        userinfo.setUsername("QWQ");
        userinfo.setPassword("123");
        int result = userMapper.add2(userinfo);
        System.out.println("执行结果:" + result);
    }

    @Test
    void add3() {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("嘤嘤怪");
        userinfo.setPassword("123");
        int result = userMapper.add3(userinfo);
        System.out.println("执行结果:" + result);
    }

    @Test
    void getListByWhere() {
        Userinfo userinfo = new Userinfo();
//        userinfo.setId(1);
        List<Userinfo> list = userMapper.getListByWhere(userinfo);
        System.out.println(list);
    }

    @Test
    void update2() {
        Userinfo userinfo = new Userinfo();
                userinfo.setId(2);
        userinfo.setUsername("嘤嘤怪");
//        userinfo.setPassword("123");
        int result = userMapper.update2(userinfo);
        System.out.println("执行结果:" + result);
    }

    @Test
    void delByIds() {
        List<Integer>  list = new ArrayList<Integer>(){{
            add(4);
            add(5);
            add(6);
        }};
        int result = userMapper.delByIds(list);
        System.out.println("执行结果:" + result);
    }
}