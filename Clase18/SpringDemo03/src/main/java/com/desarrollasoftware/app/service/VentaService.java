package com.desarrollasoftware.app.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.desarrollasoftware.app.repository.VentaRepository;

@Named
public class VentaService {

	@Inject
	private VentaRepository ventaRepository;

	public void registrarVenta() {
		ventaRepository.registrarVenta();
	}

}
