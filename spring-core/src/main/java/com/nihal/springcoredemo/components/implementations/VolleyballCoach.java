package com.nihal.springcoredemo.components.implementations;

import org.springframework.stereotype.Component;

import com.nihal.springcoredemo.components.Coach;

@Component
public class VolleyballCoach implements Coach {

    public VolleyballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getWorkoutDetails() {
        return "Practice your volleyball serves for 30 minutes.";
    }
}
