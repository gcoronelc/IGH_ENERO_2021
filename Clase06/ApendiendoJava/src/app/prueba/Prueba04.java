package app.prueba;

import app.service.VentaService;
import app.spec.VentaSpec;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba04 {
	
	private static VentaSpec service = new VentaSpec() {
		@Override
		public double calcVenta() {
			return 2000.0;
		}

		@Override
		public void grabar() {
			System.out.println("Grabando ...");
		}
	};
	
	public static void main(String[] args) {
		VentaSpec ventaService = new VentaService();
		System.out.println("Venta: " + ventaService.calcVenta());
		System.out.println("Venta 2: " + service.calcVenta());
	}

}
