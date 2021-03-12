package com.desarrollasoftware.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollasoftware.app.dto.ResponseDto;
import com.desarrollasoftware.app.model.Cliente;
import com.desarrollasoftware.app.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin("http://127.0.0.1:5500")
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
	public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
		try {
			cliente = clienteService.nuevoCliente(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(cliente);
		}
	}
	
	@PostMapping("/crear2")
	public ResponseEntity<?> crear2(@RequestBody Cliente cliente) {
		ResponseDto dto;
		try {
			cliente = clienteService.nuevoCliente(cliente);
			dto = new ResponseDto(1, "Proceso ok.", cliente.getCodigo());
		} catch (Exception e) {
			dto = new ResponseDto(-1, "Error en el proceso.", e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
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

