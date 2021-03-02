package com.desarrollasoftware.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollasoftware.app.model.Cliente;
import com.desarrollasoftware.app.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> traerTodos() {
		return clienteService.traerTodos();
	}
	
	@GetMapping("/id/{id}")
	public String traerPorId(@PathVariable String id) {
		return "Datos del cliente " + id;
	}
	
	@GetMapping("/paterno/{paterno}")
	public String traerPorPaterno(@PathVariable String paterno) {
		return "Busqueda de clientes por paterno: " + paterno;
	}
	
	@PostMapping
	public String crear() {
		return "Cliente registrado correctamenete.";
	}
	
	@PutMapping
	public String actualizar() {
		return "Cliente actualizado correctamenete.";
	}
	
	@DeleteMapping("/id/{id}")
	public String eliminar(@PathVariable String id) {
		return "Cliente " + id + " eliminado correctamenete.";
	}

}

