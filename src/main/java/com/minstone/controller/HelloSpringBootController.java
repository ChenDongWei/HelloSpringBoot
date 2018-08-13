package com.minstone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBootController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello SpringBoot,你好世界！";
	}
}
