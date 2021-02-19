package pe.egcc.eureka.prueba;

import java.util.List;
import pe.egcc.eureka.model.ClienteModel;
import pe.egcc.eureka.service.EurekaService;

/**
 *
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 * @email  gcoronelc@gmail.com
 */
public class Prueba03 {
public static void main(String[] args) {
   try {
      EurekaService service = new EurekaService();
      service.procesoDeposito("00100001", 90, "0004");
      System.out.println("Proceso ok.");
   } catch (Exception e) {
      System.err.println(e.getMessage());
   }
   }
}
