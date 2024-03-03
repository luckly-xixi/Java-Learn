package com.xixi.web.response;


import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符数据：设置字节数据的响应体
 *
 */


@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 读取文件
        FileInputStream fileInputStream = new FileInputStream("d:a.jpg");
        //2. 获取 response 字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //3. 完成流的 copy
//        byte[] buff = new byte[1024];
//        int len = 0;
//        while((len = fileInputStream.read(buff)) != -1) {
//            outputStream.write(buff, 0, len);
//        }
        // 简化
        IOUtils.copy(fileInputStream, outputStream);

        // 关闭资源
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
