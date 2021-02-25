package com.desarrollasoftware.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctrl2")
public class Controller2 {

	@RequestMapping({"/hello2"})
	public String saludo() {
		
		return "index";
	}
}

