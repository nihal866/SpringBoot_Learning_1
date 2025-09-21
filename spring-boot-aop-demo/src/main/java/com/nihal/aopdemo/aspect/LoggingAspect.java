package com.nihal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // @Before("execution(public void
    // com.nihal.aopdemo.dao.AccountDAO.addAccount())")

    // @Before("execution(public void add*())")

    @Before("execution(* add*())")
    public void beforeAddMethod() {
        System.out.println("\n\n============> Executing before method call <================\n\n");
    }
}
