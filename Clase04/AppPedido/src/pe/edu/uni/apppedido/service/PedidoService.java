package pe.edu.uni.apppedido.service;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class PedidoService {

	public PedidoService() {
		System.out.println("Objeto creado");
	}

	@Override
	protected void finalize() throws Throwable {
		System.err.println("Memoria liberada");
	}
	
	public double calcImpuesto(double importe){
		double impuesto;
		impuesto = importe * 0.18;
		return impuesto;
	}

	public double calcTotal(double importe){
		double total;
		total = importe + calcImpuesto(importe);
		return total;
	}
	
}
