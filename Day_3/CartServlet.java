package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		
		ArrayList<String> al = new ArrayList<String> ();
		
		String tShirt = (String)session.getAttribute("tShirt");
		if(tShirt!=null)
			al.add(tShirt);
		
		String jeans = (String)session.getAttribute("jeans");
		if(jeans!=null)
			al.add(jeans);
		
		String mobile = (String)session.getAttribute("mobile");
		if(mobile!=null)
			al.add(mobile);
		
		String laptop = (String)session.getAttribute("laptop");
		if(laptop!=null)
			al.add(laptop);
		
		String gloves = request.getParameter("gloves");
		if(gloves!=null)
			al.add(gloves);
		
		String stumps = request.getParameter("stumps");
		if(stumps!=null)
			al.add(stumps);
		
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<header>");
		out.print("<title>");
		out.print("Cart Section");
		out.print("</title>");
		out.print("</header>");
		out.print("<body>");		
		out.print("Cart section...");
		out.print("<form action='get'>");
		out.print("<h3>Items are in cart : </h3>");
		for(String trav : al) {
			
			out.print(trav+"<br>");
		}
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

}
