package com.example.nihal.thymleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @GetMapping("/form")
    public String inputForm() {
        return "hellowworld-form";
    }

    @PostMapping("/process")
    public String processForm(Model model, @RequestParam(name = "studentName") String studName) {
        System.out.println("Entered name: " + studName);
        model.addAttribute("studName", studName);
        return "process";
    }

    @PostMapping("/processSecond")
    public String processV2Form(HttpServletRequest request, Model model) {
        String studName = request.getParameter("studentName");
        studName = studName.toUpperCase();
        String message = "Hello " + studName;
        model.addAttribute("message", message);
        return "process-beta";
    }
}
