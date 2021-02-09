package aprendiendojava.prueba;

import aprendiendojava.model.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba04 {

    public static void main(String[] args) {
		 
       Map<String,Producto> lista = new HashMap<>();
		 
		 lista.put("100", new Producto(100, "Televisor", 5500));
		 lista.put("200", new Producto(200, "Laptop", 4500));
		 lista.put("300", new Producto(300, "Impresora", 600));
		 lista.put("400", new Producto(400, "Parlantes", 300));
		 lista.put("100", new Producto(100, "Mostrador", 8000));
		 
		 for (String key : lista.keySet()) {
			 System.out.println(lista.get(key).getNombre());
		 }
		 
    }

}
