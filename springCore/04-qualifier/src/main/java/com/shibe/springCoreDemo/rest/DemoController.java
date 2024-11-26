package com.shibe.springCoreDemo.rest;

import com.shibe.springCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach MyCoach;

    @Autowired
    public void DemoController(@Qualifier("tennisCoach") Coach theCoach){
        MyCoach=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return MyCoach.GetDailyWorkout();
    }
}
