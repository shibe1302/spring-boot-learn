package com.shibe.springCoreDemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String GetDailyWorkout() {
        return "An dau buoi con cac tao ne` !!!!!!!!!!";
    }
}
