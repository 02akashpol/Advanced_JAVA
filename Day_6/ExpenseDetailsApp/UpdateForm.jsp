<%@page import="org.omg.PortableServer.ForwardRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Expense Page</title>
</head>
<body>

	<form action="Update.jsp">
	
		<table align="center">
		
			<%
			
				int expenseId = Integer.parseInt(request.getParameter("expenseId"));
				session.setAttribute("expenseId", expenseId);
			
			%>
			
			<tr>
			
				<td>Item Name : <input type="text" name="itemName" placeholder="Enter the item name : " required> <br> </td>
			
			</tr>
			
			<tr>
			
				<td> Price : <input type="text" name="price" placeholder="Enter the item price : " required> <br> </td>
			
			</tr>
			
			<tr>
			
				<td> Purchase Date : <input type="date" name="date" value="2020-02-02" min="2001-01-01" max="2020-10-30" required> <br> </td>
			
			</tr>
			
			<tr>
			
				<td><input type="submit" value="Update"> </td>
			
			</tr>
			
		</table>
	
	</form>
	

</body>
</html>