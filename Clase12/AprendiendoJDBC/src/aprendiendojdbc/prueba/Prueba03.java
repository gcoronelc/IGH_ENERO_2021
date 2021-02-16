package aprendiendojdbc.prueba;

import aprendiendojdbc.db.AccesoDB;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class Prueba03 {

	public static void main(String[] args) {
		try {

			// Usando el archivo JRXML y el objeto Connection
			Connection cn = AccesoDB.getConnection();
			Map<String,Object> pars = new HashMap();
			pars.put("PATERNO", "%E%");
			String reporte = "/aprendiendojdbc/reports/clientes.jrxml";
			InputStream ioReporte = Class.class.getResourceAsStream(reporte);
			JasperReport rep = JasperCompileManager.compileReport(ioReporte);
			JasperPrint print = JasperFillManager.fillReport(rep, pars, cn);

			// Visualizando el Reporte
			JasperViewer viewer = new JasperViewer(print, false);
			viewer.setTitle("Mi Reporte");
			viewer.setVisible(true);

			//JasperViewer.viewReport(print);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRORE", JOptionPane.ERROR_MESSAGE);
		}
	}

}
