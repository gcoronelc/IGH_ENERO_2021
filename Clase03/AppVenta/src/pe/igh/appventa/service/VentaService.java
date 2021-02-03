package pe.igh.appventa.service;

import pe.igh.appventa.dto.VentaDto;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class VentaService {
	
	public VentaDto procesar(VentaDto dto){
		// Variables
		double importe, impuesto, total;
		// Proceso
		total = dto.getPrecio() * dto.getCantidad();
		importe = total / 1.18;
		impuesto = total - importe;
		// Retorno
		dto.setImporte(importe);
		dto.setImpuesto(impuesto);
		dto.setTotal(total);
		return dto;
	}

	

}
