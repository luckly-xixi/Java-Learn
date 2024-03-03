package com.xixi.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 重定向
 */


@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("resp1");

        // 设置重定向
//        resp.setStatus(302);//1.设置响应状态码302
//        resp.setHeader("Location", "/Servlet/resp2");//2.设置响应头Location
        //简化
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
