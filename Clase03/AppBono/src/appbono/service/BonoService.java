/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbono.service;

/**
 *
 * @author dondo
 */
public class BonoService {
    
    public double calcComision(String  meses,double ventas){
          
        double comision=0;
          int mes;
          int i;
          String[] arrayMeses = new String[] {
            "Enero",
            "Febrero",
            "Marzo", 
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre"
    };
       for (  i= 0; i < arrayMeses.length; i++) {
            if (meses.equals(arrayMeses[i])) {
             mes=i;
    if (mes>=0 && mes<3 ){
    comision=ventas*10/100;
    }
    if (mes>=3 && mes<7 ){
    comision=ventas*12/100;
    }
    if (mes>=7 && mes<9 ){
    comision=ventas*15/100;
    }
    if (mes>=10 && mes<12 ){
    comision=ventas*16/100;    
    }   
            }
        }       
    return(comision);
    } 
    public double calcBono(String  meses,double ventas){
          
        double bono=0;
          int mes;
          int i;
          String[] arrayMeses = new String[] {
            "Enero",
            "Febrero",
            "Marzo", 
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre"
    };
       for (  i= 0; i < arrayMeses.length; i++) {
            if (meses.equals(arrayMeses[i])) {
             mes=i+1;
    if (mes>=1 && mes<4 && ventas>80000 ){
    bono=(ventas-80000)*3/100;
    }
    
    
    if (mes>=4 && mes<8 && ventas>60000  ){
    bono=(ventas-60000)*5/100;
    }
   
   
    if (mes>=8 && mes<10 && ventas>70000 ){
    bono=(ventas-70000)*7/100;
    }
    
    if (mes>=11 && mes<13 && ventas>100000 ){
    bono=(ventas-100000)*8/100;    
    }  
   
            }
        }       
    return(bono);
    } 
    
    public double calcPagoTotal(double bono,double comision){ 
    double pagoTotal;
    pagoTotal=bono+comision;
    
    return (pagoTotal);
    }
    
    
}
