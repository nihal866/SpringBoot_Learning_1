package com.nihal.springcoredemo.components.implementations;

import org.springframework.stereotype.Component;

import com.nihal.springcoredemo.components.Coach;

@Component
public class FootballCoach implements Coach {

    public FootballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getWorkoutDetails() {
        return "Make a circle of the ground";
    }

}
