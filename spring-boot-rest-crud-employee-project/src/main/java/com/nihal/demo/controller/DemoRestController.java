package com.nihal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nihal.demo.entity.Employee;
import com.nihal.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    private EmployeeService employeeService;

    @Autowired
    public DemoRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
