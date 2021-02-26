package com.desarrollasoftware.app.repository;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

@Repository
public class ProcedureSaldoCuenta extends StoredProcedure {

	private static final String PROC_NAME = "usp_egcc_saldo_cuenta";

	public ProcedureSaldoCuenta(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, PROC_NAME);
		setFunction(false);
		declareParameter(new SqlParameter("p_cuenta", Types.VARCHAR));
		declareParameter(new SqlOutParameter("p_saldo", Types.DECIMAL));
		compile();
	}
	
	public double ejecutar(String cuenta) {
		Map<String, Object> rec = super.execute(cuenta);
		double saldo = Double.parseDouble(rec.get("p_saldo").toString());
		return saldo;
	}

}
