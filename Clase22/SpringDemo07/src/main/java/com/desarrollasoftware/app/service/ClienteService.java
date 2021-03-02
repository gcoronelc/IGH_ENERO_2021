package com.desarrollasoftware.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.desarrollasoftware.app.model.Cliente;

@Service
public class ClienteService {
	

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Cliente> traerTodos(){
		String sql = "SELECT "
				+ "CHR_CLIECODIGO    CODIGO,"
				+ "VCH_CLIEPATERNO   PATERNO,"
				+ "VCH_CLIEMATERNO   MATERNO,"
				+ "VCH_CLIENOMBRE    NOMBRE,"
				+ "CHR_CLIEDNI       DNI,"
				+ "VCH_CLIECIUDAD    CIUDAD,"
				+ "VCH_CLIEDIRECCION DIRECCION,"
				+ "VCH_CLIETELEFONO  TELEFONO,"
				+ "VCH_CLIEEMAIL     EMAIL "
				+ "FROM CLIENTE";
		List<Cliente> lista;
		lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Cliente.class) );
		return lista;
	}
	
}

