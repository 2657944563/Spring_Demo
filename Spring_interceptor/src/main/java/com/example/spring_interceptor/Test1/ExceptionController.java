package com.example.spring_interceptor.Test1;

import com.google.protobuf.MessageOrBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

    @RequestMapping("/err1")
    public void e1() {
        System.out.println("访问异常页面");
        int i = 1 ;
        i = i / 0;
    }
    @RequestMapping("/err2")
    public void e2() {
        System.out.println("访问异常页面");
        String str = null;
        str.length();
    }

    @RequestMapping("/error")
    public ModelAndView err1(ModelAndView modelAndView) {
        modelAndView.setViewName("Error.jsp");
        return modelAndView;
    }
}
