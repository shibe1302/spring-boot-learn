package com.shibe.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String GetDailyWorkout() {
        return "An dau buoi con cac tao ne` !!!!!!!!!!";
    }
}
