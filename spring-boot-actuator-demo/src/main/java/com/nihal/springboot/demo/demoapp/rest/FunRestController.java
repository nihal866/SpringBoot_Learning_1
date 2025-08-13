package com.nihal.springboot.demo.demoapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    // exposing a new endpoint, save and see the application restarts by itself or
    // not?
    @GetMapping("/check")
    public String sayCheck() {
        return "Checked for restart by itself";
    }
    // result: it worked
}
