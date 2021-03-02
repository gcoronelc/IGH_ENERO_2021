package pe.egcc.controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import pe.egcc.dto.VentaDto;
import pe.egcc.ejb.ModuloBeanRemote;

@Model
public class AppController implements Serializable {

  @EJB
  private ModuloBeanRemote moduloBean;

  private static final long serialVersionUID = 1249872503787378565L;

  private double precio;
  private int cantidad;
  private VentaDto ventaDto;

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public VentaDto getVentaDto() {
    return ventaDto;
  }

  public void setVentaDto(VentaDto ventaDto) {
    this.ventaDto = ventaDto;
  }

  public void doProcesar(){
    ventaDto = moduloBean.procesarVenta(precio, cantidad);
    precio = 0.0;
    cantidad = 0;
  }
}
