package com.nihal.demo.service;

import java.util.List;

import com.nihal.demo.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
