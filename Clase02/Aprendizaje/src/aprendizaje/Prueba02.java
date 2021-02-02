package aprendizaje;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba02 {

	public static void main(String[] args) {
		String[][] datos = new String[5][3];

		for (int i = 0; i < datos.length; i++) {
			String fila = "";
			for (int j = 0; j < datos[i].length; j++) {
				fila += "" + datos[i][j] + "\t";
			}
			System.out.println(fila);
		}
	}
	
}
