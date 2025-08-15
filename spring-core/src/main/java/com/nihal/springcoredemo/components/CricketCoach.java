package com.nihal.springcoredemo.components;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getWorkoutDetails() {
        return "Bowling for 15 minutes!!!";
    }
}
