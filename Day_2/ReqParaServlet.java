package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReqPara")
public class ReqParaServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName = request.getParameter("userName");
		String pass = request.getParameter("password");
		String gen = request.getParameter("gender");
		String lang[] = request.getParameterValues("languages");
		String add = request.getParameter("address");
		String city = request.getParameter("city");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Name : "+userName+"<br>");
		out.print("Password : "+pass+"<br>");
		out.print("Gender : "+gen+"<br>");
		out.print("Languages : "+"<br>");
		
		for(String trav : lang) {
			out.print(trav+"<br>");
		}
		
		out.print("Address : "+add+"<br>");
		out.print("City : "+city+"<br>");
		
		out.flush();
		out.close();
	}

}
