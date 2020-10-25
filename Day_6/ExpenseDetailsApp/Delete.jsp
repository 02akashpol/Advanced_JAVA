<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>

<% 

	int expenseId = Integer.parseInt(request.getParameter("expenseId"));

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/Advanced_JAVA?useSSL=FALSE", "root", "Akashpol@123");
	PreparedStatement stat = conn.prepareStatement(
			"delete from expense where expenseId = ?");
	stat.setInt(1, expenseId);
	
	int recv = stat.executeUpdate();
	
	if(recv == 1)	
		response.sendRedirect("ExpenseList.jsp");
	
%>