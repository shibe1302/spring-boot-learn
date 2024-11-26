package com.examplesecu.secu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "plain-login";
    }

    @GetMapping("/leader")
    public String showLeader(){
        return "leaders";
    }

    @GetMapping("/systems")
    public String showAdmin(){
        return "system";
    }

    @GetMapping("/access-denied")
    public String accessDeniedPage(){
        return "access-denied";
    }
}
