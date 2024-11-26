package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funrest {
	@GetMapping("/")
	public String sayhello() {
		return "<h1>hello world 99 !</h1>";
	}

	@GetMapping("/lam")
	public String shiba() {
		return "<h1>hello shiba 999 !</h1>";
	}

}
