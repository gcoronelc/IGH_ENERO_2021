package pe.igh.app.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.igh.app.service.ConsultasService;

/**
 * Servlet implementation class CuentaController
 */
@WebServlet({ "/Movimientos", "/hhh" })
public class CuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();

		switch (path) {
		case "/Movimientos":
			movimientos(request, response);
			break;
		}

	}

	
	private void movimientos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			// Captura de datos
			String cuenta = request.getParameter("cuenta");
			// Proceso
			ConsultasService service = new ConsultasService();
			List<Map<String,?>> lista = service.getMovimientos(cuenta);
			// Reporte
			ServletConfig config = getServletConfig();
			ServletContext sc = config.getServletContext();
			JRMapCollectionDataSource data = new JRMapCollectionDataSource(lista);
			Map<String, Object> pars = new HashMap<>();
			String reporte = "/pe/igh/app/reportes/repoMovimientos.jasper";
			InputStream is = CuentaController.class.getResourceAsStream(reporte);
			if(is == null){
				throw new Exception("Reporte no existe.");
			}
			JasperReport rep = (JasperReport) JRLoader.loadObject(is);
			byte[] bytes = JasperRunManager.runReportToPdf(rep, pars, data);
			// Preparar el reporte
			response.setContentType("application/pdf");
			response.setContentLengthLong(bytes.length);
			ServletOutputStream out = response.getOutputStream();
			out.write(bytes, 0, bytes.length);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("Error: " + e.getMessage());
			out.close();
		}
	}
}
