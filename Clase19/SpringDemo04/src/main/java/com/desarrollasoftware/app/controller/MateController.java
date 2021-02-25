package com.desarrollasoftware.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mate")
public class MateController {

	@GetMapping("/suma")
	public String sumarForm() {
		return "suma";
	}
	
	@PostMapping("/suma")
	public String sumaProc(
		@RequestParam("n1")	int num1,
		@RequestParam("n2")	int num2,
		Model model
	) {
		
		int suma = num1 + num2;
		
		model.addAttribute("n1", num1);
		model.addAttribute("n2", num2);
		model.addAttribute("suma", suma);
		
		return "suma";
	}
}

