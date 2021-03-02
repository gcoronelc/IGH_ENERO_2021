package pe.egcc.dto;

import java.io.Serializable;

public class ArticuloDto implements Serializable {

  private static final long serialVersionUID = -5981084192954945623L;

  private String nombre;
  private double precio;

  public ArticuloDto() {
  }

  public ArticuloDto(String nombre, double precio) {
    this.nombre = nombre;
    this.precio = precio;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

}
