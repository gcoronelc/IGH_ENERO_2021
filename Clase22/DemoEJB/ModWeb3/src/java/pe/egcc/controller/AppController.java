package pe.egcc.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pe.egcc.dto.ArticuloDto;
import pe.egcc.dto.VentaDto;
import pe.egcc.ejb.ModuloBeanRemote;

@Model
public class AppController implements Serializable {

  @EJB
  private ModuloBeanRemote moduloBean;

  private static final long serialVersionUID = 1249872503787378565L;

  private List<ArticuloDto> listaArticulos;
  private String articulo;
  private double precio;
  private int cantidad;
  private VentaDto ventaDto;

  @PostConstruct
  public void reset() {
    try {
      listaArticulos = moduloBean.obtenerArticulos();
      listaArticulos.add(0, new ArticuloDto("Selecciones uno", 0.0));
    } catch (Exception e) {
      e.printStackTrace();
      FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error encontrado.", e.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, fm);
    }
  }

  public List<ArticuloDto> getListaArticulos() {
    return listaArticulos;
  }

  public void setArticulo(String articulo) {
    this.articulo = articulo;
    actualizarPrecio();
  }

  public String getArticulo() {
    return articulo;
  }

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

  public void doProcesar() {
    ventaDto = moduloBean.procesarVenta(precio, cantidad);
    precio = 0.0;
    cantidad = 0;
    articulo = "";
  }

  private void actualizarPrecio() {
    precio = 0.0;
    for (ArticuloDto dto : listaArticulos) {
      if (dto.getNombre().equals(articulo)) {
        precio = dto.getPrecio();
        break;
      }
    }
  }
}
