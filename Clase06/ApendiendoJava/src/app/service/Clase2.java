package app.service;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Clase2 extends Clase1{
	
	protected String mensaje = "Java-Oracle la mejor solución.";

	public Clase2() {
		super("Gustavo");
	}

	public String obtenerMensaje(){
		return mensaje;
	}

	@Override
	public int sumar(int n1, int n2) {
		return ((n1+n2) * (n1-n2));
	}

	@Override
	public String obtenerCiudad() {
		return "Lima";
	}
	
	
}
