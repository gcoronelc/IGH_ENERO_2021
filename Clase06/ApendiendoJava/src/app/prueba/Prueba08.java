package app.prueba;

import app.service.Clase1;
import app.service.Clase2;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba08 {
	
	public static void main(String[] args) {
		
		Clase2 a = new Clase2();
		Clase1 b = a; // UpCasting
		
		Clase2 c = (Clase2) b; // DownCasting
		
	}

}
