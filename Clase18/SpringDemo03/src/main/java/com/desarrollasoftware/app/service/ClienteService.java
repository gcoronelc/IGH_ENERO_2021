package com.desarrollasoftware.app.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollasoftware.app.repository.IClienteCrud;

@Service
public class ClienteService {

	@Autowired
	@Resource(name="ClienteOracle")
	private IClienteCrud clienteCrud;
	
	public void insertar() {
		clienteCrud.insertar();
	}
	
	
	
	
}

