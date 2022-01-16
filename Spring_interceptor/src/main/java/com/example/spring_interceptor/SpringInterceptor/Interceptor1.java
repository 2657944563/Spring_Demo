package com.example.spring_interceptor.SpringInterceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@Component("interceptor1")
public class Interceptor1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println(request.getSession());
//        System.out.println(request.getHeader("User-Agent"));
//        System.out.println(request.getCookies()[0].getValue());
//        System.out.println(handler.toString());
//        System.out.println("方法执行前");
//        Cookie cookie1 = new Cookie("name", URLEncoder.encode("麻了", "UTF-8"));
//        response.addCookie(cookie1);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("方法执行后，返回前");
//        if (modelAndView != null) {
//            modelAndView.addObject("name", "明白人——");
//        }
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("方法执行后");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
