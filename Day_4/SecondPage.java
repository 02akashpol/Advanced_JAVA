package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecondPage")
public class SecondPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		
		String recv1 = (String)request.getAttribute("msg1");
		String recv2 = (String)session.getAttribute("msg2");
		
		ServletContext contx = request.getServletContext();
		String recv3 = (String)contx.getAttribute("msg3");
		
		PrintWriter out = response.getWriter();
		out.print("text/html");
		out.println("Session obj : "+recv1);
		out.println("ServletConfig obj : "+recv2);
		out.println("ServletContex obj : "+recv3);
		
		out.flush();
		out.close();	
	}

}
