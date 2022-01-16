package com.example.spring_interceptor.ExceptionResolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 2657944563
 */
public class ExceptionResolver1 implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView("Error1.jsp");
        modelAndView.addObject("exceptionInfo", "出大事了，皇上驾崩了");

        return modelAndView;
    }
}
