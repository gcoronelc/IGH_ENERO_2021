package app.service;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public abstract  class Clase1 {
	
	protected String mensaje = "Java es el mejor lenguaje.";

	public Clase1() {
		System.out.println("Hola desde Clase1");
	}
	
	public Clase1(String nombre){
		System.out.println("Hola " + nombre + " desde Clase1");
	}
	
	public int sumar(int n1, int n2){
		return (n1+n2);
	}
	
	public abstract String obtenerCiudad();

}
