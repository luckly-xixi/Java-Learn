package org.example.web;

import com.alibaba.fastjson.JSON;
import org.example.pojo.Brand;
import org.example.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addByAxiosServlet")
public class AddByAxiosServlet extends HttpServlet {

    BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String brandName = req.getParameter("brandName");// getParameter 不可以接收 JSON 数据

        // 获取请求体数据（JSON）
        BufferedReader reader = req.getReader();
        String string = reader.readLine();

        // 反序列化
        Brand brand = JSON.parseObject(string, Brand.class);

        // 调用方法
        service.add(brand);

        // 响应成功标识
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
