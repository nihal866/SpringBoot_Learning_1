package com.nihal.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MessagingAspect {

    @Before("execution(* addAccount(..))")
    public void fun(JoinPoint joinPoint) {
        System.out.println("\n====================" + getClass());

        // get method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // print method signature
        System.out.println("Method: " + methodSignature);

        // get arguments
        Object[] args = joinPoint.getArgs();
        // print arguments
        System.out.println("Printing arguments: ");
        for (Object arg : args) {
            System.out.println(arg);
        }
    }
}
