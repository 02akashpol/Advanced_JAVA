<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense List Page</title>
</head>
<body>

	<table>
		
		<%
			
			int currUserId = (Integer)session.getAttribute("currUserId");
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Advanced_JAVA?useSSL=FALSE", "root", "Akashpol@123");
			
			PreparedStatement stat = conn.prepareStatement(
					"select * from expense where userId = ?");
			stat.setInt(1, currUserId);
			
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
%>				
				<tr>
				
					<td><%=rs.getString("itemName") %></td>
					<td><%=rs.getFloat("price") %></td>
					<td><%=rs.getString("date") %></td>
					<td><a href="Delete.jsp?expenseId=<%=rs.getInt("expenseId") %>">Delete</a> </td>
					<td><a href="UpdateForm.jsp?expenseId=<%=rs.getInt("expenseId") %>">Update</a> </td>				
				
				</tr>

<%			}
			conn.close();
		
		%>
	
	</table>

</body>
</html>