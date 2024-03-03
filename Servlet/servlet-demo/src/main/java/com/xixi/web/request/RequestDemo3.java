package com.xixi.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 中文乱码：
 *      POST 方式
 *      GET 方式
 */

@WebServlet("/req3")
public class RequestDemo3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET ，获取参数方式：getQueryString
        // 乱码原因，tomcat进行URL解码，默认字符集是 ISO-8859-1

        // 1. 先对乱码数据进行编码：转为字节数组
        String username = "张三";


        //byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        // 2. 字节数组解码
        //username = new String(bytes, StandardCharsets.UTF_8);
        //替换上方两行代码
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.解决中文乱码：POST方式：getReader()
        req.setCharacterEncoding("UTF-8");

        //2.获取 username
        String username = req.getParameter("username");
        System.out.println(username);
        this.doGet(req, resp);
    }
}
