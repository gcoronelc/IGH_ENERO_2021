package aprendiendojava.prueba;

import aprendiendojava.model.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba03 {

    public static void main(String[] args) {
		 
       List<Producto> lista = new ArrayList<>();
		 
		 lista.add(new Producto(100, "Televisor", 5500));
		 lista.add(new Producto(200, "Laptop", 4500));
		 lista.add(new Producto(300, "Impresora", 600));
		 lista.add(new Producto(400, "Parlantes", 300));
		 lista.add(new Producto(100, "Televisor", 5500));
		 lista.add(lista.get(0));

		 lista.get(0).setPrecio(7000);
		 
		 for (Producto dato : lista) {
			 System.out.println(dato.getNombre() + " - " + dato.getPrecio());
		 }
		 
    }

}
