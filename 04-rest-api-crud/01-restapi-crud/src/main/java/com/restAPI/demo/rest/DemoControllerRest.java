package com.restAPI.demo.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoControllerRest {
    @GetMapping("/helo")
    public String Hello(){
        return "hello";
    }
}
