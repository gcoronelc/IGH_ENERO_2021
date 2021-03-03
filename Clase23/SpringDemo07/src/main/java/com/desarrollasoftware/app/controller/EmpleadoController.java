package com.desarrollasoftware.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

	@GetMapping
	public String traerTodos() {
		return "Todos los empleados";
	}
	
	@GetMapping("/id/{id}")
	public String traerPorId(@PathVariable String id) {
		return "Datos del empleado " + id;
	}
	
	@GetMapping("/paterno/{paterno}")
	public String traerPorPaterno(@PathVariable String paterno) {
		return "Busqueda de empleados por paterno: " + paterno;
	}
	
	@PostMapping
	public String crear() {
		return "Empleado registrado correctamenete.";
	}
	
	
	
}

