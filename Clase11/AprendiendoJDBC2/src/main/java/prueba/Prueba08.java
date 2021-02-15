package prueba;

import java.util.List;
import java.util.Map;
import pe.igh.app.service.impl.ConsultasImpl;
import pe.igh.app.service.spec.ConsultasSpec;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba08 {
	
	public static void main(String[] args) {
		try {
			ConsultasSpec consultasService = new ConsultasImpl();
			List<Map<String,?>> lista = consultasService.traerMovimientoCuenta2("00100001");
			for(Map<String,?> rec: lista) {
				System.out.println(
					rec.get("NROMOV").toString() + " - " 
					+ rec.get("FECHA").toString() + " - "
					+ rec.get("IMPORTE").toString() + " - ");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
