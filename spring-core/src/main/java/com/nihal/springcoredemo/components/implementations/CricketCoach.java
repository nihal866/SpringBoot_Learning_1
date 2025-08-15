package com.nihal.springcoredemo.components.implementations;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.nihal.springcoredemo.components.Coach;

@Lazy
@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getWorkoutDetails() {
        return "Bowling for 15 minutes!!!";
    }
}
