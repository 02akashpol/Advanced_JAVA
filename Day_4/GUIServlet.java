package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GUIServlet")
public class GUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.print("<style>");
		out.print("h3{");
		out.print("color: red");
		out.print("</style>");
		out.print("<h3>“CREATING GUI IS COMPLEX USING SERVLET”</h3>");
		out.println("</body></html>");		
	}

}
