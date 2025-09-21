package com.nihal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class TransactionAspect {

    @Before("execution(* addAccount())")
    public void fun() {
        System.out.println("\n====================" + getClass());
    }
}
