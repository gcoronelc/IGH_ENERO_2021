package pe.igh.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MostrarSaludo
 */
@WebServlet("/MostrarSaludo")
public class MostrarSaludo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
				
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Clasico Hola mundo!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hola " + session.getAttribute("nombre").toString() + " desde el mundo de servlets!</h1>");
		out.println("<h3>Programado por " + session.getAttribute("programador").toString() + ".</h3>");
		out.println("</body>");
		out.println("</html>");

	}

}
