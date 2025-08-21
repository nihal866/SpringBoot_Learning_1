package com.nihal.demo.dao;

import java.util.List;

import com.nihal.demo.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();
}
