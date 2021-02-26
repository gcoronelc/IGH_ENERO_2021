package com.desarrollasoftware.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.desarrollasoftware.app.mappers.ClienteMapper;
import com.desarrollasoftware.app.model.ClienteModel;

@Repository
public class DemoRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getNroCuentas() {
		String sql = "select count(*) from cuenta";
		int rowCount = jdbcTemplate.queryForObject(sql, Integer.class);
		return rowCount;
	}

	public double getSaldoSoles() {
		String sql = "select sum(dec_cuensaldo) from cuenta where chr_monecodigo = '01'";
		Double saldo = jdbcTemplate.queryForObject(sql, Double.class);
		return saldo;
	}

	public String getNombreCliente(String codigo) {
		String nombre;
		try {
			String sql = "select vch_clienombre from cliente where chr_cliecodigo = ?";
			nombre = jdbcTemplate.queryForObject(sql, String.class, codigo);
		} catch (EmptyResultDataAccessException e) {
			nombre = "";
		}
		return nombre;
	}

	public ClienteModel getCliente(String codigo) {
		ClienteModel bean = null;
		try {
			String sql = "select chr_cliecodigo, vch_cliepaterno, vch_cliematerno, "
					+ "vch_clienombre, chr_cliedni, vch_clieciudad, vch_cliedireccion, "
					+ "vch_clietelefono, vch_clieemail " + "from cliente where chr_cliecodigo = ?";
			bean = jdbcTemplate.queryForObject(sql, new ClienteMapper(), codigo);
		} catch (EmptyResultDataAccessException e) {
		}
		return bean;
	}

	public List<ClienteModel> getClientes(String paterno, String materno) {
		List<ClienteModel> lista = null;
		paterno = "%" + paterno + "%";
		materno = "%" + materno + "%";
		try {
			String sql = "select chr_cliecodigo, vch_cliepaterno, vch_cliematerno, "
					+ "vch_clienombre, chr_cliedni, vch_clieciudad, vch_cliedireccion, "
					+ "vch_clietelefono, vch_clieemail " + "from cliente "
					+ "where upper(vch_cliepaterno) like upper(?) and upper(vch_cliematerno) like upper(?) ";
			lista = jdbcTemplate.query(sql, new ClienteMapper(), paterno, materno);
		} catch (EmptyResultDataAccessException e) {
			lista = new ArrayList<>();
		}
		return lista;
	}

	public List<Map<String, Object>> getMovimientos(String cuenta) {
		String sql = "select int_movinumero nromov, dtt_movifecha fecha, "
				+ "chr_tipocodigo tipo, dec_moviimporte importe " + "from movimiento where chr_cuencodigo = ?";
		List<Map<String, Object>> lista = jdbcTemplate.queryForList(sql, cuenta);
		return lista;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void ejmTX(ClienteModel bean) {
		// Actualizar contador y bloquea la fila
		String sql = "update contador set int_contitem = int_contitem + 1 " 
				+ "where vch_conttabla = 'Cliente' ";
		int filas = jdbcTemplate.update(sql);
		if (filas == 0) {
			throw new RuntimeException("El contador de la tabla CLIENTE no existe.");
		}
		// Leer datos para la generación del codigo
		sql = "select int_contitem, int_contlongitud from contador " 
		+ " where vch_conttabla = 'Cliente' ";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		int cont = Integer.parseInt(map.get("int_contitem").toString());
		int size = Integer.parseInt(map.get("int_contlongitud").toString());
		// Generar el nuevo código
		String formato = "%0" + size + "d";
		String codigo = String.format(formato, cont);
		System.out.println("Código: " + codigo);
		// Insertar el nuevo cliente
		sql = "insert into cliente(chr_cliecodigo, vch_cliepaterno, " 
				+ "vch_cliematerno, vch_clienombre, chr_cliedni, "
				+ "vch_clieciudad, vch_cliedireccion, vch_clietelefono," 
				+ "vch_clieemail) values(?,?,?,?,?,?,?,?,?)";
		Object[] args = { codigo, bean.getPaterno(), bean.getMaterno(), bean.getNombre(), bean.getDni(),
				bean.getCiudad(), bean.getDireccion(), bean.getTelefono(), bean.getEmail() };
		jdbcTemplate.update(sql, args);
		// Retornar el codigo
		bean.setCodigo(codigo);
	}

}
