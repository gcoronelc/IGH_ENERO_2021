package com.desarrollasoftware.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollasoftware.app.repository.VentaRepository;

@Service
public class VentaService {

	@Autowired(required = false)
	private VentaRepository ventaRepository;
	
	/*
	@Autowired
	public void inyecta(VentaRepository ventaRepository) {
		System.out.println("Repository inyectado por metodo.");
		this.ventaRepository = ventaRepository;
	}
	*/
	
	/*
	@Autowired
	public VentaService(VentaRepository ventaRepository) {
		System.out.println("Repository inyectado por constructor.");
		this.ventaRepository = ventaRepository;
	}
	*/
	
	/*
	@Autowired
	public void setVentaRepository(VentaRepository ventaRepository) {
		System.out.println("Repository inyectado por metodo set.");
		this.ventaRepository = ventaRepository;
	}
	*/
	
	public void registrarVenta() {
		if( ventaRepository == null) {
			System.out.println("Hoy día no hay ventas.");
		} else { 
			ventaRepository.registrarVenta();
		}
	}
	
}

