package pe.egcc.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import pe.egcc.dto.ArticuloDto;
import pe.egcc.dto.VentaDto;

@Stateless
public class ModuloBean implements ModuloBeanRemote, Serializable {

  private static final long serialVersionUID = 732969423671748188L;

  @Override
  public int sumar(int num1, int num2) {
    int suma;
    suma = num1 + num2;
    return suma;
  }

  @Override
  public VentaDto procesarVenta(double precio, int cantidad) {
    // Calculos
    double total = redondear(precio * cantidad);
    double importe = redondear(total / 1.18);
    double impuesto = redondear(total - importe);
    // Retorno
    VentaDto dto = new VentaDto();
    dto.setPrecio(precio);
    dto.setCantidad(cantidad);
    dto.setImporte(importe);
    dto.setImpuesto(impuesto);
    dto.setTotal(total);
    return dto;
  }

  private double redondear(double importe) {
    importe = importe * 100;
    importe = Math.round(importe);
    importe = importe / 100;
    return importe;
  }

  @Override
  public List<ArticuloDto> obtenerArticulos() {
    List<ArticuloDto> lista = new ArrayList<>();
    lista.add(new ArticuloDto("Articulo 1", 456.78));
    lista.add(new ArticuloDto("Articulo 2", 234.65));
    lista.add(new ArticuloDto("Articulo 3", 67.45));
    lista.add(new ArticuloDto("Articulo 4", 45.36));
    lista.add(new ArticuloDto("Articulo 5", 865.12));
    lista.add(new ArticuloDto("Articulo 6", 754.26));
    lista.add(new ArticuloDto("Articulo 7", 863.45));
    lista.add(new ArticuloDto("Articulo 8", 145.26));
    lista.add(new ArticuloDto("Articulo 9", 458.69));
    return lista;
  }

  
  
}
