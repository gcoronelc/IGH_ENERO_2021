package com.desarrollasoftware.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	private Environment environment;
	
	@Value("${app.saludo}")
	private String mensaje;
	
	@RequestMapping({"/","/index","/hello"})
	public String hello(Model model) {
		model.addAttribute("nombre", "Gustavo");
		return "index";
	}
	
	
	@RequestMapping({"/hello2"})
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView("hello2");
		mav.addObject("nombre", "Karla");
		mav.addObject("saludo", environment.getProperty("app.saludo"));
		mav.addObject("path", environment.getProperty("path"));
		mav.addObject("saludo2", mensaje);
		return mav;
	}
	
	
	

}

