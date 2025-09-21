package com.nihal.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(String value1, String value2) {
        System.out.println("Doing DB work by " + getClass());
    }

    @Override
    public void addString() {
        System.out.println("Doing DB work by " + getClass());
    }

}
