package org.example.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 替换 HttpServlet，根据请求的最后一段路径来进行方法的分发
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求路径
        String uri = req.getRequestURI();//注意：这里面的路径开头就是"/"，/brand-case/brand/……
        // 获取最后一段路径，方法名
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index + 1);//这里面的路径包含了"/"，/add（……）

        //System.out.println(methodName);

        // 执行方法
            // 获取 对应的Servlet字节码 Class 对象
        Class<? extends BaseServlet> cls = this.getClass();
            // 获取方法 Method 对象
        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 执行方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }
}
