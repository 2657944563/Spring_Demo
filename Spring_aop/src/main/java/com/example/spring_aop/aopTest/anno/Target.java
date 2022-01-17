package com.example.spring_aop.aopTest.anno;


import org.springframework.stereotype.Component;

/**
 * @author 2657944563
 */
@Component("target1")
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("调用了save()");
    }
}
