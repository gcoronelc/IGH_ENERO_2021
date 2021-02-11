package pe.igh.app.service.spec;

import java.util.List;
import pe.igh.app.model.Cliente;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public interface ClienteSpec {
	
	Cliente traer(String idCliente);
	
	List<Cliente> traer(String paterno, String Materno, String nombre);
	
	void inertar(Cliente cliente);
	
	void actualizar(Cliente cliente);
	
	void eliminar(String idCliente);

}
