package com.example.Web;

import com.example.Service.userService;
import com.example.Utils.webServletUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Spring_web1", value = "/Spring_web1")
public class Spring_web1 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("SpringWeb初始化");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(com.example.SpringConfig.Configuration.class);
//        ApplicationContext app = (ApplicationContext)request.getServletContext().getAttribute("app");
        ApplicationContext app = webServletUtil.getApplicationContext(this.getServletContext());
//        ServletContext sc = this.getServletContext();
//        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(sc);
        userService service = (userService)app.getBean("userService");
        service.show();
    }
}
