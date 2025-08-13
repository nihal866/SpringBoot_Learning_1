package com.nihal.springboot.demo.demoapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

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

    // expose new api for getting team info
    @GetMapping("/team-info")
    public String getTeamInfo() {
        return "Team: " + teamName + ", Coach: " + coachName;
    }
}
