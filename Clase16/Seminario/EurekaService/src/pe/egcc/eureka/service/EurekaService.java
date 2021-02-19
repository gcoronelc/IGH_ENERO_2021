package pe.egcc.eureka.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import pe.egcc.eureka.db.AccesoDB;
import pe.egcc.eureka.model.ClienteModel;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class EurekaService {

   public List<ClienteModel> leerClientes(String nombre) {
      List<ClienteModel> lista = new ArrayList<>();
      Connection cn = null;
      try {
         cn = AccesoDB.getConnection();
         // Proceso
         String sql = "{call eureka.usp_egcc_clientes(?,?)}";
         CallableStatement cstm = cn.prepareCall(sql);
         cstm.setString(1, nombre);
         cstm.registerOutParameter(2, OracleTypes.CURSOR);
         cstm.executeUpdate();
         ResultSet rs = (ResultSet) cstm.getObject(2);
         while (rs.next()) {
            ClienteModel model = new ClienteModel();
            model.setCodigo(rs.getString("CHR_CLIECODIGO"));
            model.setPaterno(rs.getString("VCH_CLIEPATERNO"));
            model.setMaterno(rs.getString("VCH_CLIEMATERNO"));
            model.setNombre(rs.getString("VCH_CLIENOMBRE"));
            model.setDni(rs.getString("CHR_CLIEDNI"));
            model.setCiudad(rs.getString("VCH_CLIECIUDAD"));
            model.setDireccion(rs.getString("VCH_CLIEDIRECCION"));
            model.setTelefono(rs.getString("VCH_CLIETELEFONO"));
            model.setEmail(rs.getString("VCH_CLIEEMAIL"));
            lista.add(model);
         }
         rs.close();
         cstm.close();
      } catch (Exception e) {
         throw new RuntimeException(e.getMessage());
      } finally {
         try {
            cn.close();
         } catch (Exception e) {
         }
      }
      return lista;
   }


   public void procesoDeposito(String cuenta, double importe, String empleado){
      Connection cn = null;
      try {
         cn = AccesoDB.getConnection();
         // Proceso
         String sql = "{call eureka.usp_egcc_deposito(?,?,?)}";
         CallableStatement cstm = cn.prepareCall(sql);
         cstm.setString(1, cuenta);
         cstm.setDouble(2, importe);
         cstm.setString(3, empleado);
         cstm.executeUpdate();
         cstm.close();
      } catch (Exception e) {
         throw new RuntimeException(e.getMessage());
      } finally {
         try {
            cn.close();
         } catch (Exception e) {
         }
      } 
   }

}
