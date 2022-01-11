package com.example.Utils;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class webServletUtil {
    public static ApplicationContext getApplicationContext(ServletContext serv) {
        String applicationContext = serv.getInitParameter("applicationContext");
        return (ApplicationContext) serv.getAttribute(applicationContext);
    }
}
