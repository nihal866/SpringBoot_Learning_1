package com.nihal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LoggingAspect {
    // @Before("execution(public void
    // com.nihal.aopdemo.dao.AccountDAO.addAccount())")

    // @Before("execution(public void add*())")

    // @Before("execution(* add*())")

    // @Pointcut("execution(* add*())")
    // private void forDaoPackages() {
    // }

    // @Before("forDaoPackages()")
    // public void fun1() {
    // System.out.println("\n\n============> Executing fun1() method call
    // <================\n\n");
    // }

    // @Before("forDaoPackages()")
    // public void kjfeiufbebfkwebgbefbjebrbekjrb() {
    // for (int i = 0; i < 10; i++) {
    // }
    // System.out.println("\n\n============> Executing fun2() method call
    // <================\n\n");
    // }

    // @Before("forDaoPackages()")
    // public void fun3() {
    // System.out.println("\n\n============> Executing fun3() method call
    // <================\n\n");
    // }

    /*
     * pointcut combinations
     * pointcut1()
     * pointcut2()
     * 
     * combinations with ||, && and !
     * pointcut1() || pointcut2()
     */

    @Before("execution(* addAccount())")
    public void fun() {
        System.out.println("\n====================" + getClass());
    }
}
