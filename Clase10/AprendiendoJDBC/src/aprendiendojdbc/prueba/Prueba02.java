package aprendiendojdbc.prueba;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba02 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.OracleDriver";
		String urlDB = "jdbc:oracle:thin:@localhost:1521/XE";
		String user = "eureka";
		String pass = "admin";
		try {
			Class.forName(driver).newInstance();
			Connection cn = DriverManager.getConnection(urlDB, user, pass);
			System.out.println("Conexión ok.");
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
