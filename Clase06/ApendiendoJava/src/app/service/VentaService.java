package app.service;

import app.spec.VentaSpec;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class VentaService implements VentaSpec{

	@Override
	public double calcVenta() {
		return 1000.0;
	}

	public String obtenerNombre(){
		return "Gustavo";
	}

	@Override
	public void grabar() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
