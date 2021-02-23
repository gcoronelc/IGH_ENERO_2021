package com.desarrollasoftware.app.repository;

import org.springframework.stereotype.Repository;

@Repository("clienteMySQL")
public class ClienteCrudMySQL implements IClienteCrud{

	@Override
	public void insertar() {
		System.out.println("Cliente registrado con MySQL.");
	}

}

