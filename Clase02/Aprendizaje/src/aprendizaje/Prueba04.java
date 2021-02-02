package aprendizaje;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba04 {

	public static void main(String[] args) {
		int[][] datos = {
			{12,43,56,78},
			{12,43,56,78,54,76,89,23,45,67},
			{12,43,56,78,54,73,45,67},
		};

		for (int[] filaDatos: datos) {
			String fila = "";
			for (int dato: filaDatos) {
				fila += "" + dato + "\t";
			}
			System.out.println(fila);
		}
	}
	
}
