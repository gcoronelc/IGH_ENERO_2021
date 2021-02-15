package prueba;

import java.util.List;
import java.util.Map;
import pe.igh.app.service.impl.ConsultasImpl;
import pe.igh.app.service.impl.CuentaImpl;
import pe.igh.app.service.spec.ConsultasSpec;
import pe.igh.app.service.spec.CuentaSpec;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba09 {
	
	public static void main(String[] args) {
		try {
			CuentaSpec cuentaService = new CuentaImpl();
			cuentaService.registrarMovimiento("00100001", 200.0, "0005");
			System.out.println("PRoceso ok.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
