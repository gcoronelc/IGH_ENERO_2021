package pe.egcc.controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import pe.egcc.ejb.ModuloBeanRemote;

@Model
public class AppController implements Serializable {

  private static final long serialVersionUID = 3547417908328684319L;

  @EJB
  private ModuloBeanRemote moduloBean;

  private int num1;
  private int num2;
  private int suma;

  public int getNum1() {
    return num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  public int getNum2() {
    return num2;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
  }

  public int getSuma() {
    return suma;
  }

  public void setSuma(int suma) {
    this.suma = suma;
  }

  public void doSumar() {
    suma = moduloBean.sumar(num1, num2);
  }

}
