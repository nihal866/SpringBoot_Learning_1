package com.nihal.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nihal.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // no code to write
}
