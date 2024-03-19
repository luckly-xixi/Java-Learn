package org.example.web.servlet;


import com.alibaba.fastjson.JSON;
import org.example.pojo.Brand;
import org.example.pojo.PageBean;
import org.example.service.BrandService;
import org.example.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{

    private BrandService brandService = new BrandServiceImpl();


    /**
     * 查询所有
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();

        String jsonString = JSON.toJSONString(brands);

        // 设置字符集
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }


    /**
     * 新增
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void add (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String string = reader.readLine();

        Brand brand = JSON.parseObject(string, Brand.class);

        brandService.add(brand);

        resp.getWriter().write("success");
    }


    /**
     * 批量删除
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String params = br.readLine();

        int[] ids = JSON.parseObject(params, int[].class);

        brandService.deleteByIds(ids);

        resp.getWriter().write("success");
    }

    /**
     * 分页查询
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
        String jsonString = JSON.toJSONString(pageBean);

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }


    /**
     * 分页条件查询
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收 当前页码 和 每页显示条数
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        // 获取查询条件对象
        BufferedReader br = req.getReader();
        String params = br.readLine();
        // 转为 Brand 对象
        Brand brand = JSON.parseObject(params, Brand.class);

        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);
        String jsonString = JSON.toJSONString(pageBean);

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
