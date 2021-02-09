package aprendiendojava.prueba;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba01 {

	public static void main(String[] args) {

		List lista = new ArrayList();

		lista.add(123);
		lista.add("Gustavo");
		lista.add(1234.67);
		lista.add(0123);
		lista.add(0xAB);
		lista.add(new Random());
		lista.add('g');
		
		System.out.println("Tamaño: " + lista.size());
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		

	}

}
