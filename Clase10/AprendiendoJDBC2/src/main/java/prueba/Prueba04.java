package prueba;

import java.util.List;
import pe.igh.app.model.Cliente;
import pe.igh.app.service.impl.ClienteImpl;
import pe.igh.app.service.spec.ClienteSpec;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba04 {

	public static void main(String[] args) {
		try {
			ClienteSpec clienteService = new ClienteImpl();
			List<Cliente> lista = clienteService.traer("","","Ca");
			for(Cliente obj: lista) {
				System.out.println(obj.getCodigo()+ " - " + obj.getPaterno() + " - " + obj.getMaterno() + "- " + obj.getNombre());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
