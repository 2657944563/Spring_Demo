package com.example.spring_aop.aopTest.jdk.Impl;

import com.example.spring_aop.aopTest.jdk.TargetInterface;



/**
 * @author 2657944563
 */
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("调用了save()");
    }
}
