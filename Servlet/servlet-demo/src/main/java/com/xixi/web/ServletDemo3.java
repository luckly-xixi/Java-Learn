package com.xixi.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


//@WebServlet("/demo1")
@WebServlet(urlPatterns = "/demo3", loadOnStartup = 1)
public class ServletDemo3 implements Servlet {

    private ServletConfig config;

    /**
     * 初始化方法
     * 1.调用时机：默认情况下，Servlet 被第一次访问时，调用
     * 2.调用次数：1次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        System.out.println("init……");
    }

    /**
     * 获取ServletConfig对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    /**
     * 提供服务
     * 1.调用时机：每一次Servlet被访问时，调用
     * 2.调用次数：多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet Hello World~");
    }

    /**
     * 销毁方法
     * 1.调用时机：内存释放或者服务器关闭时，Servlet对象会被销毁，调用
     * 2.调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("destroy……");
    }



    /**
     * 获取Servlet信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return "";
    }

}
