package app.service.oracle;

import app.spec.VentaSpec;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class OracleVentaService implements VentaSpec{

	@Override
	public double calcVenta() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void grabar() {
		System.out.println("Venta registrada en Oracle.");
	}

}
