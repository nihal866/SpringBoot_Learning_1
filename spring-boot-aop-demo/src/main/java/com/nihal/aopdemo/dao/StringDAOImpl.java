package com.nihal.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class StringDAOImpl implements StringDAO {

    @Override
    public boolean addAccount() {
        System.out.println("Doing DB Operation: " + getClass());
        return true;
    }

}
