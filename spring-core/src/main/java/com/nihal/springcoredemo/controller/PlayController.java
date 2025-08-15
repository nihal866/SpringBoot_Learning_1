package com.nihal.springcoredemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nihal.springcoredemo.components.Coach;

@RestController
public class PlayController {

    private Coach myCoach;

    // use of qualifier annotation
    // @Autowired
    // public PlayController(@Qualifier("volleyballCoach") Coach thisCoach) {
    // myCoach = thisCoach;
    // }

    @Autowired
    public PlayController(Coach thisCoach) {
        myCoach = thisCoach;
    }

    @GetMapping("/workout-detail")
    public String getWorkoutDetails() {
        return myCoach.getWorkoutDetails();
    }
}
