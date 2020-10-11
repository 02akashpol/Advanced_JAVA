package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Advanced_JAVA?useSSL=FALSE", "root", "Akashpol@123");
			PreparedStatement stat = conn.prepareStatement(
					"select `user_name` from `user_table`"
							+ "where `user_name` = ? and `password` = ?");
			stat.setString(1, userName);
			stat.setString(2, password);
			
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				
				response.sendRedirect("Home.html");
			} else {
				
				PrintWriter out = response.getWriter();
				out.print("No such a data available on our server for requested user, please check your inputs.");
				out.flush();
				out.close();
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
