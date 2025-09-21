package com.nihal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(public void addAccount())")
    public void beforeAddAccountMethod() {
        System.out.println("\n\n============> Executing before addAccount() method <================\n\n");
    }

    @Before("execution(public void add*())")
    public void beforeAddMethod() {
        System.out.println("\n\n============> Executing before method call <================\n\n");
    }
}
