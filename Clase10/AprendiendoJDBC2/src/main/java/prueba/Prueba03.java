package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class Prueba03 {

	public static void main(String[] args) {
		try {
			ClienteSpec clienteService = new ClienteImpl();
			Cliente obj = clienteService.traer("00001");
			if(obj == null){
				System.out.println("No existe.");
			} else {
				System.out.println("Codigo: " + obj.getCodigo());
				System.out.println("Paterno: " + obj.getPaterno());
				System.out.println("Materno: " + obj.getMaterno());
				System.out.println("Nombre: " + obj.getNombre());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
