package com.example.spring_aop.aopTest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Myaspectj {
    public void before() {
        System.out.println("前置增强");
    }

    public void after() throws Throwable {
        System.out.println("后置增强");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后");
        return proceed;
    }
}
