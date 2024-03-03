package com.xixi.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 请求对象的使用：
 *      普通方式
 *      简化方式
 */
@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET 请求逻辑
        //System.out.println("get...");

        // 1.获取所有参数的 Map 集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            System.out.print(key + ":");

            // 获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(values + " ");
            }

            System.out.println();
        }

        System.out.println("------");

        // 2. 根据 key 获取参数值，数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        // 3. 根据 key 获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);


        /*    // 1.获取所有参数的 Map 集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            System.out.println(key + ":");

            // 获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.println(values + " ");
            }

            System.out.println();
        }

        System.out.println("------");

        // 2. 根据 key 获取参数值，数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        // 3. 根据 key 获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);
    */
    }
}
