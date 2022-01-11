package com.example.Web;

import com.example.Service.userService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Spring_web1", value = "/Spring_web1")
public class Spring_web1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(com.example.SpringConfig.Configuration.class);
        userService service = (userService)app.getBean("userService");
        service.show();
        app.close();
    }
}
