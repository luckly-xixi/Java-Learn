package org.example.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载资源
        System.out.println("ContextLoadListener……");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //释放资源
    }
}
