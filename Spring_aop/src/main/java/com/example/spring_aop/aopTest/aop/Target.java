package com.example.spring_aop.aopTest.aop;


/**
 * @author 2657944563
 */
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("调用了save()");
    }
}
