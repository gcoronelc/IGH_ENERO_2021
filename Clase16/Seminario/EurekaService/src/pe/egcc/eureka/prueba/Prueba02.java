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
public class Prueba02 {
   
   public static void main(String[] args) {
      try {
         EurekaService service = new EurekaService();
         List<ClienteModel> lista = service.leerClientes("LA");
         for (ClienteModel model : lista) {
            System.out.println(model.getNombre() + " | " 
            + model.getPaterno() + " | " + model.getMaterno());
         }
      } catch (Exception e) {
         System.err.println(e.getMessage());
      }
   }

}
