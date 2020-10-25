<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>

<% 

	String userName = request.getParameter("userName");
	String password = request.getParameter("password");

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/Advanced_JAVA?useSSL=FALSE", "root", "Akashpol@123");
	PreparedStatement stat = conn.prepareStatement(
			"select * from user where userName = ? and password = ?");
	
	stat.setString(1, userName);
	stat.setString(2, password);
	
	ResultSet rs = stat.executeQuery();
	
	if(rs.next()) {
		
		int userId = rs.getInt("userId");
		session.setAttribute("currUserId", userId);
		response.sendRedirect("Home.jsp");
		
	} else 
		response.sendRedirect("LogIn.jsp");
%>