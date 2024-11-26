package com.shibe.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String GetDailyWorkout() {
        return "---- Tennis ------";
    }
}
