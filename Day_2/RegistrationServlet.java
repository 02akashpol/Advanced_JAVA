package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Advanced_JAVA?useSSL=FALSE", "root", "Akashpol@123");
			PreparedStatement stat = conn.prepareStatement(
					"insert into user_table values(?, ?)");
			stat.setString(1, userName);
			stat.setString(2, password);
			
			int recv = stat.executeUpdate();
			
			if(recv == 1) {
				
				PrintWriter out = response.getWriter();
				out.print("Registration has been done successfully.");
				out.flush();
				out.close();
			}
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}	
}
