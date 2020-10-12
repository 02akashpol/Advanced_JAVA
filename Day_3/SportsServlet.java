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

@WebServlet("/SportsServlet")
public class SportsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		
		String mobile = request.getParameter("mobile");
		if(mobile!=null)
			session.setAttribute("mobile", mobile);
		
		String laptop = request.getParameter("laptop");
		if(laptop!=null)
			session.setAttribute("laptop", laptop);
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<header>");
		out.print("<title>");
		out.print("Sports section");
		out.print("</title>");
		out.print("</header>");
		out.print("<body>");		
		out.print("Sports section...");
		out.print("<form action='CartServlet'>");
		out.print("<input type='checkbox' name='gloves' value='Gloves'>Gloves<br>");
		out.print("<input type='checkbox' name='stumps' value='Stumps'>Stumps<br>");
		out.print("<input type='submit' value='Add'>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

}
