package prueba;

import java.util.List;
import java.util.Map;
import pe.igh.app.model.Cliente;
import pe.igh.app.service.impl.ClienteImpl;
import pe.igh.app.service.impl.ConsultasImpl;
import pe.igh.app.service.spec.ClienteSpec;
import pe.igh.app.service.spec.ConsultasSpec;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba06 {
	
	public static void main(String[] args) {
		try {
			ClienteSpec clienteService = new ClienteImpl();
			Cliente cliente  = new Cliente();
			cliente.setPaterno("Torres");
			cliente.setMaterno("Sarango");
			cliente.setNombre("Miguel");
			cliente.setCiudad("Lima");
			cliente.setDireccion("Lima");
			cliente.setTelefono("55555555");
			cliente.setEmail("torres@gmail.com");
			cliente.setDni("54679823");
			clienteService.inertar(cliente);
			System.out.println("Proceso ok. Codigo: " + cliente.getCodigo());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
