package com.nihal.restDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nihal.restDemo.entity.Student;
import com.nihal.restDemo.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> studentsList;

    // using @PostContruct for loading students list.... only once
    @PostConstruct
    public void createStudentsList() {
        studentsList = new ArrayList<>();

        studentsList.add(new Student("Nihal", "Dwivedi"));
        studentsList.add(new Student("Shubham", "Kumar"));
        studentsList.add(new Student("Chandan", "Kumar"));
        studentsList.add(new Student("Pratik", "Gupta"));
    }

    @GetMapping("/list")
    public List<Student> getStudentLists() {
        return studentsList;
    }

    @GetMapping("/list/{studentId}")
    public Student getStudentDetails(@PathVariable int studentId) {
        if (studentId >= studentsList.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return studentsList.get(studentId);
    }
}
