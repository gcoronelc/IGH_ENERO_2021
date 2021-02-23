package com.desarrollasoftware.app.repository;

import org.springframework.stereotype.Repository;

@Repository("ClienteOracle")
public class ClienteCrudOracle implements IClienteCrud{

	@Override
	public void insertar() {
		System.out.println("Cliente registrado en Oracle.");
	}

}

