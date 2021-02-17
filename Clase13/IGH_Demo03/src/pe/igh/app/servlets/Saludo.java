package pe.igh.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/Saludo", "/Hola", "/Hi" })
public class Saludo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("nombre", nombre);
		session.setAttribute("programador", "Gustavo");
		
		response.sendRedirect("MostrarSaludo");
			
	}

}
