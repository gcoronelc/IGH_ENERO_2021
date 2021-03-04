package com.desarrollasoftware.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void retiro(String cuenta, double importe, String clave, String codEmp) {
		Object[] args = { cuenta, importe, codEmp, clave };
		jdbcTemplate.update("call usp_egcc_retiro(?, ?, ?, ?)", args);
	}
}
