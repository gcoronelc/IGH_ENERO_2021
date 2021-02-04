/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbono.prueba;
import appbono.service.BonoService;
/**
 *
 * @author dondo
 */
public class BonoPrueba01 {
    public static void main(String[] args) {
        //Datos
        String meses = "Septiembre";
        double ventas = 95000;
        BonoService service= new BonoService();
        //Proceso
        double bono= service.calcBono(meses, ventas);
        double comision= service.calcComision(meses, ventas);
        double pagoTotal= service.calcPagoTotal(bono, comision);
        //Reporte
        System.out.println("El bono que recibirá el empleado es: "+bono);
        System.out.println("El  que recibirá el empleado es: "+comision);
        System.out.println("El bono que recibirá el empleado es: "+pagoTotal);
    }
          
    
}
