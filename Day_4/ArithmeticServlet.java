package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ArithmeticServlet")
public class ArithmeticServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		int res;
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String recv1 = request.getParameter("add");
		String recv2 = request.getParameter("subtract");
		String recv3 = request.getParameter("multiply");
		String recv4 = request.getParameter("divide");
		
		if(recv1 != null) {
			
			res = num1 + num2;
			out.println("Sum res : "+res);
		}
		
		if(recv2 != null) {
			
			res = num1 - num2;
			out.println("Subtraction res : "+res);
		}
		
		if(recv3 != null) {
			
			res = num1 * num2;
			out.println("Multiplication res : "+res);
		}
		
		if(recv4 != null) {
			
			res = num1 / num2;
			out.println("Division res : "+res);
		}

		out.flush();
		out.close();
	}

}
