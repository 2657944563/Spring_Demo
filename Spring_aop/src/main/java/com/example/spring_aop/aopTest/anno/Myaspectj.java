package com.example.spring_aop.aopTest.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myaspectj1")
@Aspect//注释当前类为切面类
public class Myaspectj {
    @Pointcut("execution(* com.example.spring_aop.aopTest.anno.*.*(..))")
    public void myPoint() {
    }

    @Before("myPoint()")
    public void before() {
        System.out.println("前置增强");
    }


    @Around("myPoint()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后");
        return proceed;
    }


    @After("myPoint()")
    public void after() throws Throwable {
        System.out.println("后置增强");
    }
}
