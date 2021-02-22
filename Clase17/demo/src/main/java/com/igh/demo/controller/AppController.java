package com.igh.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hola amigos de Spring";
	}

}

