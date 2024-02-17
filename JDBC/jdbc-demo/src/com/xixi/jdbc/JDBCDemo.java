package com.xixi.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCDemo {


    //德鲁伊数据库连接池
    public static void main(String[] args) throws Exception {
        // 1. 导入jar包
        // 2.定义配置文件（druid。properties）
        // 3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
//        System.out.println(System.getProperty("user.dir"));
        // 4.获取数据库连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        // 5. 获取链接
        Connection connection = dataSource.getConnection();
    }



    // JDBC快速入门与API详解
    public static void main1(String[] args) throws Exception {
        // 1.注册驱动
        Class.forName("com.xixi.jdbc.JDBCDemo");
        // 2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/数据库名称";
        String username = "";
        String password = "";

        Connection connection = DriverManager.getConnection(url, username, password);
        // 3. 定义sql语句
        String sql = "select * from ……";
        // 4. 获取执行sql对象
        Statement statement = connection.createStatement(); //普通对象
        //PreparedStatement preparedStatement = connection.prepareStatement(sql); // 预编译对象


        try{
            connection.setAutoCommit(false);// 开启事务
        // 5. 执行sql
            int count = statement.executeUpdate(sql); // 返回值为受影响的行数,正常执行
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                //int id = resultSet.getInt(1); // 列编号写法
                int id = resultSet.getInt("id"); // 列名写法
            }
            //……
        // 6. 处理结果

            connection.commit();//提交事务
                } catch (Exception  throwables) {
            connection.rollback();//回滚事务
        }

        // 7. 释放资源
        statement.close();
        connection.close();
    }
}
