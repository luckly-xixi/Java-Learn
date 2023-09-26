package com.example.demo.service;


import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public int add(Userinfo userinfo) {
        int row = userMapper.add(userinfo);
        System.out.println("add row ->" + row);
        insert(userinfo);
        return row;
    }


    @Transactional
    // Propagation.REQUIRED 默认的事务传播级别，如果当前存在事务，则加⼊该事务，当前没有事务，则创建⼀个新的事务；
    // 要么一起提交事务，要么一起回滚事务
    // Propagation.SUPPORTS：如果当前存在事务，则加⼊该事务；如果当前没有事务，则以⾮事务的⽅式继续运⾏
    // Propagation.MANDATORY：（mandatory：强制性）如果当前存在事务，则加⼊该事务；如果当前没有事务，则抛出异常
    // Propagation.REQUIRES_NEW：表示创建⼀个新的事务，如果当前存在事务，则把当前事务挂
    //  起。也就是说不管外部⽅法是否开启事务，Propagation.REQUIRES_NEW 修饰的内部⽅法会新开
    //  启⾃⼰的事务，且开启的事务相互独⽴，互不⼲扰
    //Propagation.NOT_SUPPORTED：以⾮事务⽅式运⾏，如果当前存在事务，则把当前事务挂起
    //Propagation.NEVER：以⾮事务⽅式运⾏，如果当前存在事务，则抛出异常
    //Propagation.NESTED：如果当前存在事务，则创建⼀个事务作为当前事务的嵌套事务来运⾏；如
    //  果当前没有事务，则该取值等价于 PROPAGATION_REQUIRED
    public int insert(Userinfo userinfo) {
        int row = userMapper.add(userinfo);
        System.out.println("insert row ->" + row);
        int num = 10 / 0;
        return row;
    }
}
