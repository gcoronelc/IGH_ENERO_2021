package app.prueba;

import app.service.Clase1;
import app.service.Clase2;
import app.service.Clase3;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba03 {

	public static void main(String[] args) {
		Clase2 obj2 = new Clase2();
		Clase3 obj3;
		//obj3 = obj2;	
		verObjeto2(new Clase3());
	}
	
	public static void verObjeto(Clase1 obj){
		Clase3 objx;
		if( !(obj instanceof Clase3) ){
			System.err.println("No son compatibles");
		} else {
			objx= (Clase3) obj;
			System.out.println(obj.toString());
		}
	}
	
	public static void verObjeto2(Clase1 obj){
		Clase3 objx;
		if( !(Clase3.class.isInstance(obj) ) ){
			System.err.println("No son compatibles");
		} else {
			objx= (Clase3) obj;
			System.out.println(obj.toString());
		}
	}

}
