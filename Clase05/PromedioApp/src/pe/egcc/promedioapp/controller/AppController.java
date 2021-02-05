package pe.egcc.promedioapp.controller;

import pe.edutec.app.lib.MateService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @site www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 */
public class AppController {

  public int promediar(int n1, int n2) {
    MateService promedio;
    promedio = new MateService();
    return promedio.promediar(n1, n2);
  }

}
