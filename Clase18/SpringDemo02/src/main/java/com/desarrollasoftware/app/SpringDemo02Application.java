package com.desarrollasoftware.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desarrollasoftware.app.service.AppService;
import com.desarrollasoftware.app.service.VentaService;

@SpringBootApplication
public class SpringDemo02Application implements CommandLineRunner{
	
	@Autowired
	private AppService appService;
	
	@Autowired
	private VentaService ventaService;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringDemo02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola todos");
		System.out.println("7 + 8 = " + appService.sumar(7, 8));
		ventaService.registrarVenta();
	}

}
