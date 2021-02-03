package pe.igh.appventa.prueba;

import pe.igh.appventa.dto.VentaDto;
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
		VentaDto dto = new VentaDto(80.56, 100);
		// Proceso
		VentaService service = new VentaService();
		dto = service.procesar(dto);
		// Reporte
		System.out.println("Importe: " + dto.getImporte());
		System.out.println("Impuesto: " + dto.getImpuesto());
		System.out.println("Total: " + dto.getTotal());
	}

}
