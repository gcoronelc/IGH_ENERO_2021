package pe.igh.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Suma", "/Resta" })
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();

		switch (path) {
		case "/Suma":
			suma(request,response);
			break;
		case "/Resta":
			resta(request,response);
			break;
		}

	}

	private void resta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Captura de datos
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		// Proceso
		int rpta = n1 - n2;
		// Reporte
		request.setAttribute("titulo", "RESTA");
		request.setAttribute("n1", n1);
		request.setAttribute("n2", n2);
		request.setAttribute("rpta", rpta);
		ServletUtil.forward(request, response, "calculadora.jsp");
	}

	private void suma(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Captura de datos
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		// Proceso
		int rpta = n1 + n2;
		// Reporte
		request.setAttribute("titulo", "SUMA");
		request.setAttribute("n1", n1);
		request.setAttribute("n2", n2);
		request.setAttribute("rpta", rpta);
		ServletUtil.forward(request, response, "calculadora.jsp");
	}

}
