package com.example.nihal.thymleafDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.nihal.thymleafDemo.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${hobbies}")
    private List<String> hobbies;

    @GetMapping("/showForm")
    public String showStudentForm(Model model) {
        Student newStudent = new Student();
        model.addAttribute("student", newStudent);
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);
        model.addAttribute("hobbies", hobbies);
        return "student-show-form";
    }

    @PostMapping("/processForm")
    public String processStudentForm(@ModelAttribute("student") Student student) {
        System.out.println(student.toString());
        return "student-process";
    }
}
