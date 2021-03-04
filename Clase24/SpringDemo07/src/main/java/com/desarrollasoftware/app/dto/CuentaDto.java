package com.desarrollasoftware.app.dto;

public class CuentaDto {

	private String cuenta;
	private Double importe;
	private String clave;
	private String empleado;
	
	public CuentaDto() {
	}

	public CuentaDto(String cuenta, Double importe, String clave, String empleado) {
		super();
		this.cuenta = cuenta;
		this.importe = importe;
		this.clave = clave;
		this.empleado = empleado;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	
	
}

