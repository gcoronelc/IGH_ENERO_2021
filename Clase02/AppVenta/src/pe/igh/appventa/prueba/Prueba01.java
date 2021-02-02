package pe.igh.appventa.prueba;

import pe.igh.appventa.service.VentaService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba01 {
	
	public static void main(String[] args) {
		// Datos
		double precio = 80.56;
		int cantidad = 100;
		// Proceso
		VentaService service = new VentaService();
		double total = service.calcTotal(precio, cantidad);
		double importe = service.calcImporte(total);
		double impuesto = service.calcImpuesto(total, importe);
		// Reporte
		System.out.println("Importe: " + importe);
		System.out.println("Impuesto: " + impuesto);
		System.out.println("Total: " + total);
	}

}
