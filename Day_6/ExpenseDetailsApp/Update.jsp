<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<% 

	String itemName = request.getParameter("itemName");
	float price = Float.parseFloat(request.getParameter("price"));
	String date = request.getParameter("date");
	
	int expenseId = (Integer)session.getAttribute("expenseId");
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/Advanced_JAVA?useSSL=FALSE", "root", "Akashpol@123");
	PreparedStatement stat = conn.prepareStatement(
			"update expense set itemName = ?, price = ?, date = ? where expenseId = ?");
	
	stat.setString(1, itemName);
	stat.setFloat(2, price);
	stat.setString(3, date);
	stat.setInt(4, expenseId);
	
	int recv = stat.executeUpdate();
	
	if(recv == 1)
		response.sendRedirect("ExpenseList.jsp");
	else {
%>
		<%= "Please check your inputs." %>
	<% } 
	
	conn.close();
%>