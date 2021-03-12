package com.desarrollasoftware.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Cliente nuevoCliente(Cliente bean) {
		// Actualizar contador
		String sql = "update contador set int_contitem = int_contitem + 1 where vch_conttabla = 'Cliente' ";
		int filas = jdbcTemplate.update(sql);
		if (filas == 0) {
			throw new RuntimeException("El contador de la tabla CLIENTE no existe.");
		}
		// Leer datos para la generación del codigo
		sql = "select int_contitem, int_contlongitud from contador where vch_conttabla = 'Cliente' ";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		int cont = Integer.parseInt(map.get("int_contitem").toString());
		int size = Integer.parseInt(map.get("int_contlongitud").toString());
		// Generar el nuevo código
		String formato = "%0" + size + "d";
		String codigo = String.format(formato, cont);
		// Insertar el nuevo cliente
		sql = "insert into cliente(chr_cliecodigo, vch_cliepaterno, "
		+ "vch_cliematerno, vch_clienombre, chr_cliedni, "
		+ "vch_clieciudad, vch_cliedireccion, vch_clietelefono,"
		+ "vch_clieemail) values(?,?,?,?,?,?,?,?,?)";
		Object[] args = { codigo, bean.getPaterno(), bean.getMaterno(),
		bean.getNombre(), bean.getDni(), bean.getCiudad(),
		bean.getDireccion(), bean.getTelefono(),
		bean.getEmail() };
		jdbcTemplate.update(sql, args);
		// Retornar el codigo
		bean.setCodigo(codigo);
		return bean;
	}
	
}

