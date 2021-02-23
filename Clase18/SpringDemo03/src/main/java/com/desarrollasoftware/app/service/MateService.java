package com.desarrollasoftware.app.service;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class MateService {
	
	private int sueldo;
	
	@PostConstruct
	public void initBean() {
		Random rnd = new Random();
		this.sueldo = rnd.nextInt(1000) + 5000;
		System.out.println("Sueldo asignado: " + this.sueldo);
	}
	
	public void mostrarSueldo() {
		System.out.println("Sueldo: " + sueldo);
	}

}

