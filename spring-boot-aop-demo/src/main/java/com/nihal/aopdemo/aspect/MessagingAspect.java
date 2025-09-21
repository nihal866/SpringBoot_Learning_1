package com.nihal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MessagingAspect {

    @Before("execution(* addAccount())")
    public void fun() {
        for (int i = 0; i < 50; i++) {
        }
        System.out.println("\n====================" + getClass());
    }
}
