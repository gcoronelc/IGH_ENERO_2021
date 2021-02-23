package com.desarrollasoftware.app;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desarrollasoftware.app.service.AppService;
import com.desarrollasoftware.app.service.ClienteService;
import com.desarrollasoftware.app.service.MateService;
import com.desarrollasoftware.app.service.VentaService;

@SpringBootApplication
public class SpringDemo02Application implements CommandLineRunner{
	
	@Inject
	private AppService appService;
	
	@Inject
	private VentaService ventaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MateService mateService1;
	
	@Autowired
	private MateService mateService2;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringDemo02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola todos");
		System.out.println("7 + 8 = " + appService.sumar(7, 8));
		ventaService.registrarVenta();
		clienteService.insertar();
		mateService1.mostrarSueldo();
		mateService2.mostrarSueldo();
	}

}
