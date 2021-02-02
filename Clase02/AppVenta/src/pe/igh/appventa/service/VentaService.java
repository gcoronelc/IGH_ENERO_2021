package pe.igh.appventa.service;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class VentaService {

	public double calcTotal(double precio, int cantidad){
		double total;
		total = precio * cantidad;
		return (total);
	}
	
	public double calcImporte(double total){
		double importe;
		importe = total / 1.18;
		return (importe);
	}
	
	public double calcImpuesto(double total, double importe){
		double impuesto;
		impuesto = total - importe;
		return (impuesto);
	}

}
