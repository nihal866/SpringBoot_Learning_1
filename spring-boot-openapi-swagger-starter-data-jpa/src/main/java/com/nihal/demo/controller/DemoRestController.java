package com.nihal.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nihal.demo.entity.Employee;
import com.nihal.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public DemoRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found.");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        // set id to 0, in order to insert this record into the database
        // in case any input have id set, it will override to id: 0 to insert the
        // employee obj
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteById(employeeId);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee partialUpdateEmployee(@PathVariable int employeeId,
            @RequestBody Map<String, Object> patchVariable) {

        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found.");
        }

        if (patchVariable.containsKey("id")) {
            throw new RuntimeException("Can not pass id with the body.");
        }

        Employee employee = mergePatchChanges(tempEmployee, patchVariable);
        return employeeService.save(employee);
    }

    private Employee mergePatchChanges(Employee tempEmployee, Map<String, Object> patchVariable) {
        ObjectNode employeeData = objectMapper.convertValue(tempEmployee, ObjectNode.class);

        ObjectNode patchEmployeeData = objectMapper.convertValue(patchVariable, ObjectNode.class);

        employeeData.setAll(patchEmployeeData);
        return objectMapper.convertValue(employeeData, Employee.class);
    }
}
