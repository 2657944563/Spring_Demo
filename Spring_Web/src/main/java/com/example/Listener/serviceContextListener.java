package com.example.Listener;

import com.example.Utils.webServletUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class serviceContextListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(com.example.SpringConfig.Configuration.class);
       //通过servletContext配置全局Applicationcontext以供使用
        ServletContext servletContext = sce.getServletContext();
//        servletContext.setAttribute("app", app);
        servletContext.setAttribute(servletContext.getInitParameter("applicationContext"), app);

        System.out.println(servletContext.getInitParameter("contextConfigLocation"));
    }

}
