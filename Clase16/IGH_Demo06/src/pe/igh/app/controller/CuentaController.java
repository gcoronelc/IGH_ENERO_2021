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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.igh.app.service.ConsultasService;

/**
 * Servlet implementation class CuentaController
 */
@WebServlet({ "/Movimientos", "/MovimientosExcel" })
public class CuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();

		switch (path) {
		case "/Movimientos":
			movimientos(request, response);
			break;
		case "/MovimientosExcel":
			movimientosExcel(request, response);
			break;
		}

	}

	private void movimientosExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			// Captura de datos
			String cuenta = request.getParameter("cuenta");
			// Proceso
			ConsultasService service = new ConsultasService();
			List<Map<String, ?>> lista = service.getMovimientos(cuenta);
			// Crear el Excel
			// Creación del libro
			String plantilla = "/pe/igh/app/plantillas/MOVIMIENTOS.xls";
			InputStream isPlantilla = CuentaController.class.getResourceAsStream(plantilla);
			POIFSFileSystem fs = new POIFSFileSystem(isPlantilla);
			HSSFWorkbook objLibro = new HSSFWorkbook(fs, true);
			// Crea la hoja
			HSSFSheet hoja = objLibro.getSheetAt(0);
			// Cargar los datos a la hoja
			int numFila = 1;
			HSSFRow objFila;
			for (Map<String, ?> map : lista) {
				numFila++;
				objFila = hoja.createRow(numFila);
				crearCeldaCadena(objFila, 0, map.get("CUENCODIGO").toString());
				crearCeldaEntera(objFila, 1, Integer.parseInt(map.get("MOVINUMERO").toString()));
				crearCeldaCadena(objFila, 2, map.get("MOVIFECHA").toString());
				crearCeldaCadena(objFila, 3, map.get("TIPONOMBRE").toString());
				crearCeldaDecimal(objFila, 4, Double.parseDouble(map.get("MOVIIMPORTE").toString()));
			}
			// Preparar el reporte
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=movimientos.xls");
			ServletOutputStream out = response.getOutputStream();
			objLibro.write(out); 
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

	private void movimientos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			// Captura de datos
			String cuenta = request.getParameter("cuenta");
			// Proceso
			ConsultasService service = new ConsultasService();
			List<Map<String, ?>> lista = service.getMovimientos(cuenta);
			// Reporte
			ServletConfig config = getServletConfig();
			ServletContext sc = config.getServletContext();
			JRMapCollectionDataSource data = new JRMapCollectionDataSource(lista);
			Map<String, Object> pars = new HashMap<>();
			String reporte = "/pe/igh/app/reportes/repoMovimientos.jasper";
			InputStream is = CuentaController.class.getResourceAsStream(reporte);
			if (is == null) {
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
	
	private void crearCeldaCadena(HSSFRow fila, int columna, String dato) {
		HSSFCell celda = fila.createCell(columna, HSSFCell.CELL_TYPE_STRING);
		celda.setCellValue(dato);
	}

	private void crearCeldaEntera(HSSFRow fila, int columna, int dato) {
		HSSFCell celda = fila.createCell(columna, HSSFCell.CELL_TYPE_NUMERIC);
		HSSFCellStyle style = fila.getSheet().getWorkbook().createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
		celda.setCellStyle(style);
		celda.setCellValue(dato);
	}

	private void crearCeldaDecimal(HSSFRow fila, int columna, double dato) {
		HSSFCell celda = fila.createCell(columna, HSSFCell.CELL_TYPE_NUMERIC);
		HSSFCellStyle style = fila.getSheet().getWorkbook().createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
		celda.setCellStyle(style);
		celda.setCellValue(dato);
	}
	
}
