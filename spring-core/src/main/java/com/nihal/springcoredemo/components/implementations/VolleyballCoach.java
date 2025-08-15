package com.nihal.springcoredemo.components.implementations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.nihal.springcoredemo.components.Coach;

@Component
@Primary
public class VolleyballCoach implements Coach {

    @Override
    public String getWorkoutDetails() {
        return "Practice your volleyball serves for 30 minutes.";
    }
}
