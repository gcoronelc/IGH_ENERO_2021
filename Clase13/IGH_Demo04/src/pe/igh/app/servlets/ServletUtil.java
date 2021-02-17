package pe.igh.app.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtil {
	
	private ServletUtil() {
	}

	static void forward(HttpServletRequest request, HttpServletResponse response, String destino) throws ServletException, IOException{
		
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
		
	}
}
