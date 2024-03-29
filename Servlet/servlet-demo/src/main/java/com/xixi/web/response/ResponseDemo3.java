package com.xixi.web.response;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符数据：设置字符数据的响应体
 *
 */


@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");//设置响应的数据格式和数据的字符集

        PrintWriter writer = resp.getWriter();//1. 获取字符输出流
        //resp.setHeader("content-type", "text/html");//设置文本的解析类型
        writer.write("你好");//2. 写数据


        //细节：流不需要关闭
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
