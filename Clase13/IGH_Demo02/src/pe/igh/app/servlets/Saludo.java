package pe.igh.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Saludo", "/Hola", "/Hi" })
public class Saludo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("programador", "Gustavo");
		
		RequestDispatcher rd = request.getRequestDispatcher("MostrarSaludo");
		rd.forward(request, response);

			
	}

}
