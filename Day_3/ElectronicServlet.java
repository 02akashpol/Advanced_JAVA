package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ElectronicServlet")
public class ElectronicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		
		String tShirt = request.getParameter("tShirt");
		if(tShirt!=null)
			session.setAttribute("tShirt", tShirt);
		
		String jeans = request.getParameter("jeans");
		if(jeans!=null)
			session.setAttribute("jeans", jeans);
			
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<header>");
		out.print("<title>");
		out.print("Electronic section");
		out.print("</title>");
		out.print("</header>");
		out.print("<body>");		
		out.print("Electronic section...");
		out.print("<form action='SportsServlet'>");
		out.print("<input type='checkbox' name='mobile' value='Mobile'>Mobile<br>");
		out.print("<input type='checkbox' name='laptop' value='Laptop'>Laptop<br>");
		out.print("<input type='submit' value='Add'>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

}
