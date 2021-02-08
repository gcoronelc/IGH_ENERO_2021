package app.prueba;

import app.service.Clase1;
import app.service.Clase2;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba02 {

	public static void main(String[] args) {
		Clase1 obj = new Clase2();
		System.out.println("Suma: " + obj.sumar(5, 3));
		System.out.println("Ciudad: " + obj.obtenerCiudad());
		//System.out.println("Mensaje: " + obj.obtenerMensaje());
	}

}
