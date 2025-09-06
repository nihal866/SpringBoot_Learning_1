package com.example.nihal.thymleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/form")
    public String inputForm() {
        return "hellowworld-form";
    }

    @GetMapping("/process")
    public String processForm(Model model, @RequestParam(name = "studentName") String studName) {
        System.out.println("Entered name: " + studName);
        model.addAttribute("studName", studName);
        return "process";
    }
}
