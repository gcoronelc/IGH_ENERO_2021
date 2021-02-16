package pe.uni.eurekaapp.view;

import java.awt.BorderLayout;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import pe.uni.eurekaapp.controller.CuentaController;
import pe.uni.eurekaapp.util.Mensaje;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class RepoMovimientosView extends javax.swing.JInternalFrame {

	private List<Map<String, ?>> lista = null;

	/**
	 * Creates new form ConsultaMovimientos
	 */
	public RepoMovimientosView() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      txtCuenta = new javax.swing.JTextField();
      btnExcel = new javax.swing.JButton();
      btnConsultar = new javax.swing.JButton();
      panelReporte = new javax.swing.JPanel();

      setTitle("CONSULTA DE MOVIMIENTOS");

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTROL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 153, 255))); // NOI18N

      jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      jLabel1.setText("Cuenta");

      txtCuenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

      btnExcel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
      btnExcel.setText("Excel");
      btnExcel.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnExcelActionPerformed(evt);
         }
      });

      btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
      btnConsultar.setText("Consultar");
      btnConsultar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnConsultarActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
               .addComponent(btnExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(23, Short.MAX_VALUE))
      );

      panelReporte.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPORTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 153, 255))); // NOI18N

      javax.swing.GroupLayout panelReporteLayout = new javax.swing.GroupLayout(panelReporte);
      panelReporte.setLayout(panelReporteLayout);
      panelReporteLayout.setHorizontalGroup(
         panelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 936, Short.MAX_VALUE)
      );
      panelReporteLayout.setVerticalGroup(
         panelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 473, Short.MAX_VALUE)
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(panelReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(panelReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
		try {
			// Datos
			String cuenta = txtCuenta.getText();
			// Proceso
			CuentaController control = new CuentaController();
			lista = control.getMovimientos(cuenta);
			// Preparar reporte
			JRMapCollectionDataSource data = new JRMapCollectionDataSource(lista);
			Map pars = new HashMap();
			String reporte = "/pe/uni/eurekaapp/reportes/repoMovimientos.jrxml";
			InputStream is = Class.class.getResourceAsStream(reporte);
			JasperReport rep = JasperCompileManager.compileReport(is);
			JasperPrint print = JasperFillManager.fillReport(rep, pars, data);
			// Mostrar Reporte - Caso 1
			/*
			JasperViewer viewer = new JasperViewer(print, false);
			viewer.setTitle("Mi Reporte");
			viewer.setVisible(true);
			 */
			// Mostrar Reporte - Caso 2
			// Se crea el visor del reporte
			JRViewer jRViewer = new JRViewer(print);
			//se elimina elementos del contenedor JPanel
			panelReporte.removeAll();
			//para el tamaño del reporte se agrega un BorderLayout
			panelReporte.setLayout(new BorderLayout());
			panelReporte.add(jRViewer,BorderLayout.CENTER);
			jRViewer.setVisible(true);
			panelReporte.repaint();
			panelReporte.revalidate();
		} catch (Exception e) {
			Mensaje.error(this, e.getMessage());
		}
   }//GEN-LAST:event_btnConsultarActionPerformed

   private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
		try {
			// Creación del libro
			String plantilla = "/pe/uni/eurekaapp/plantillas/MOVIMIENTOS.xls";
			InputStream isPlantilla = Class.class.getResourceAsStream(plantilla);
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
			// Se vuelca la información a un archivo.
			FileOutputStream fileOut = new FileOutputStream("E://MOVIMIENTOS.xls");
			objLibro.write(fileOut);
			fileOut.close();
			System.out.println("Todo ok.");
		} catch (Exception e) {
			e.printStackTrace();
		}
   }//GEN-LAST:event_btnExcelActionPerformed

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


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnConsultar;
   private javax.swing.JButton btnExcel;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel panelReporte;
   private javax.swing.JTextField txtCuenta;
   // End of variables declaration//GEN-END:variables

}
