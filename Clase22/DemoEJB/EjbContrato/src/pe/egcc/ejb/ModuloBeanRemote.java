package pe.egcc.ejb;

import java.util.List;
import javax.ejb.Remote;
import pe.egcc.dto.ArticuloDto;
import pe.egcc.dto.VentaDto;

@Remote
public interface ModuloBeanRemote {

  int sumar(int num1, int num2);

  VentaDto procesarVenta(double precio, int cantidad);

  List<ArticuloDto> obtenerArticulos();
  
}
