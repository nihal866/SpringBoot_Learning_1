package com.nihal.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nihal.demo.model.Customer;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping("/form")
    public String showForm(Model model) {
        System.out.println("Entered form controller.");
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        System.out.println("Entered process form.");
        if (bindingResult.hasErrors())
            return "customer-form";
        return "customer-process";
    }

}
