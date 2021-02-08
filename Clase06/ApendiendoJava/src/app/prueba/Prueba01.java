package app.prueba;

import app.service.Clase4;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba01 {

    public static void main(String[] args) {
        Clase4 obj = new Clase4();
		  System.out.println("Suma: " + obj.sumar(5, 3));
		  System.out.println("Mensaje: " + obj.obtenerMensaje());
    }

}
