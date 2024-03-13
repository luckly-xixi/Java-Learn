package org.example.web;

import com.alibaba.fastjson.JSON;
import org.example.pojo.Brand;
import org.example.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/selectAllByAxiosServlet")
public class SelectAllByAxiosServlet extends HttpServlet {
        BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用 service 查询
        List<Brand> brands = service.selectAll();
        // 将集合转换为 JSON 数据（序列化）
        String jsonString = JSON.toJSONString(brands);

        // 响应数据
        resp.setContentType("text/json;charset=utf-8");//处理中文转码
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
