package prueba;

import pe.igh.app.model.Cliente;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba07 {
	
	public static void main(String[] args) {
		
		int edad = 20;
		Cliente obj = new Cliente();
		obj.setNombre("Gustavo");
		String ciudad = new String("Chiclayo");
		
		modificar(obj);
		modificar(edad);
		modificar(ciudad);
		
		System.out.println("Nombre: " + obj.getNombre());
		System.out.println("Edad: " + edad);
		System.out.println("Ciudad: " + ciudad);
		
	}

	private static void modificar(Cliente obj) {
		obj.setNombre("Ricardo");
	}

	private static void modificar(int edad) {
		edad = 30;
	}

	private static void modificar(String ciudad) {
		ciudad = "Trujillo";
	}
	
	

}
