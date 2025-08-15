package com.nihal.springcoredemo.components.implementations;

import org.springframework.stereotype.Component;

import com.nihal.springcoredemo.components.Coach;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getWorkoutDetails() {
        return "Bowling for 15 minutes!!!";
    }
}
