package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClothesServlet")
public class ClothesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<header>");
		out.print("<title>");
		out.print("Clothing section");
		out.print("</title>");
		out.print("</header>");
		out.print("<body>");		
		out.print("Clothing section...");
		out.print("<form action='ElectronicServlet'>");
		out.print("<input type='checkbox' name='tShirt' value='TShirt'>T-Shirt<br>");
		out.print("<input type='checkbox' name='jeans' value='Jeans'>Jeans<br>");
		out.print("<input type='submit' value='Add'>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

}
