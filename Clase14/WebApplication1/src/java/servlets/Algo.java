package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Algo", urlPatterns = {"/Algo"})
public class Algo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] paises = request.getParameterValues("pais");

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Algo</title>");
			out.println("</head>");
			out.println("<body>");
			for (String s : paises) {
				out.println("<h1> " + s + " </h1>");
			}
			out.println("</body>");
			out.println("</html>");
		}
	}

}
