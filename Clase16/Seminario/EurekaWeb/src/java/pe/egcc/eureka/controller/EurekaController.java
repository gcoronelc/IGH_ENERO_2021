package pe.egcc.eureka.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.eureka.model.ClienteModel;
import pe.egcc.eureka.service.EurekaService;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
@WebServlet(name = "EurekaController",
        urlPatterns = {"/Consulta", "/Deposito"})
public class EurekaController extends HttpServlet {

   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

      String path = request.getServletPath();
      switch (path) {
         case "/Consulta":
            consulta(request, response);
            break;
         case "/Deposito":
            deposito(request, response);
            break;
      }

   }

   private void consulta(HttpServletRequest request, 
           HttpServletResponse response) throws IOException {

      // Proceso
      String nombre = request.getParameter("nombre");
      EurekaService service = new EurekaService();
      List<ClienteModel> lista = service.leerClientes(nombre);

      // Constrir la cadena JSON
      Gson gson = new Gson();
      String cadenaJson = gson.toJson(lista);

      // Retornar la cadena JSON
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      response.getWriter().write(cadenaJson);
      response.getWriter().flush();
      response.getWriter().close();
      
   }

   private void deposito(HttpServletRequest request, 
           HttpServletResponse response) throws IOException {
      
      // Variable control
      String estado = "OK";
      
      try {
         // Datos
         String cuenta = request.getParameter("cuenta");
         String empleado = request.getParameter("empleado");
         double importe = Double.parseDouble(request.getParameter("importe"));
         // Proceso
         EurekaService service = new EurekaService();
         service.procesoDeposito(cuenta, importe, empleado);
      } catch (Exception e) {
         estado = e.getMessage();
      }

      // Retornar la cadena JSON
      response.setContentType("text/plain");
      response.setCharacterEncoding("UTF-8");
      response.getWriter().write(estado);
      response.getWriter().flush();
      response.getWriter().close();

   }

}
