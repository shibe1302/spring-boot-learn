package com.shibe.springCoreDemo.common;


import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    @Override
    public String GetDailyWorkout() {
        return "BaseBall --------------";
    }
}
