package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstPage")
public class FirstPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("msg1", "session object scope msg");
		
		HttpSession session = request.getSession(true); 
		session.setAttribute("msg2", "ServletConfig object scope msg");
		
		ServletContext cntx = request.getServletContext();
		cntx.setAttribute("msg3", "ServletContex object scope msg");
		
		response.sendRedirect("SecondPage");
	}

}
