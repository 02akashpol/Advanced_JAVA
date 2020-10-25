<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%

	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	
	//Class.forName("com.mysql.cj.jdbc.Driver");
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/Advanced_JAVA?useSSL=FALSE", "root", "Akashpol@123");
	PreparedStatement stat = conn.prepareStatement(
			"insert into user(userName, password) values(?, ?)");
	
	stat.setString(1, userName);
	stat.setString(2, password);
	int recv = stat.executeUpdate();
	//stat.executeUpdate();
	conn.close();
	if(recv == 1)
		response.sendRedirect("LogIn.jsp");
%>