package com.desarrollasoftware.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollasoftware.app.dto.CuentaDto;
import com.desarrollasoftware.app.dto.ResponseDto;
import com.desarrollasoftware.app.service.CuentaService;

@RestController
@RequestMapping("/api/v1/cuentas")
@CrossOrigin("http://127.0.0.1:5500")
public class CuentaController {
	
	@Autowired
	private CuentaService cuentaService;
	
	@PostMapping("/retiro")
	public ResponseEntity<?> retiro(@RequestBody CuentaDto cuenta){
		ResponseDto dto;
		try {
			cuentaService.retiro(cuenta.getCuenta(), cuenta.getImporte(), cuenta.getClave(), cuenta.getEmpleado());
			dto = new ResponseDto(1, "Proceso ok.", "");
		} catch (Exception e) {
			dto = new ResponseDto(-1, "Error en el proceso.", e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);		
	}

}

