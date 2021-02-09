package aprendiendojava.prueba;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba02 {

    public static void main(String[] args) {
		 
       List<Integer> lista = new ArrayList<>();
		 
		 lista.add(456);
		 lista.add(4356);
		 lista.add(987);
		 lista.add(1546);
		 lista.add(3481);
		 
		 for (Integer dato : lista) {
			 System.out.println(dato);
		 }
		 
    }

}
