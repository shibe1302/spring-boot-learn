package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funrest {

	@Value("${lam.name}")
	private String cc;


	@GetMapping("/")
	public String sayhello() {
		return "<h1>hello world 99 !</h1>";
	}

	@GetMapping("/lam")
	public String shiba() {
		return "<h1>hello shiba 999 !</h1>";
	}

	@GetMapping("/shiba")
	public String shiba2() {
		return "<h1>hello shiba 999 !</h1> "+cc;
	}

}
