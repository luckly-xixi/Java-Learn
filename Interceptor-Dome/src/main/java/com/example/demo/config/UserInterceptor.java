package com.example.demo.config;


import com.example.demo.common.AppVar;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义拦截器
 */
@Component

public class UserInterceptor implements HandlerInterceptor {

    /**
     * 返回 true -> 拦截器验证成功，继续执行后续的方法
     *     false -> 拦截器验证失败，不会执行后续的目标方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("do UserInterceptor");
        //业务代码
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute(AppVar.SESSION_KEY) != null) {
            //用户已经登陆
            return true;
        }
        return false;
    }
}
