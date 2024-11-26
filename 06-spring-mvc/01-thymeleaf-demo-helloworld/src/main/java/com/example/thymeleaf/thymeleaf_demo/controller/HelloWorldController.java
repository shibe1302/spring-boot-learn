package com.example.thymeleaf.thymeleaf_demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {


    @RequestMapping("showform")
    public String showForm(){
        return "helloworld-from";
    }
}
