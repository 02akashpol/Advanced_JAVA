<%@page import="com.dto.Expense"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.service.ExpenseService"%>
<%@page import="com.service.ExpenseServiceImple"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="user" class="com.dto.User" scope="session"></jsp:useBean>

<%

	ExpenseService expenseService = new ExpenseServiceImple();
	
	ArrayList<Expense> al = expenseService.expenseList(user.getUserId());
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense List</title>
</head>
<body>

	<table align="center">
	
		<tr>
		
			<td>Item Name </td>
			<td>Price </td>
			<td>Purchase Date </td>
		
		</tr>
		
		<%
		
			for(Expense trav : al) {
		
		%>
		
		<tr>
			
			<td><%= trav.getItemName() %></td>
			<td><%= trav.getPrice() %></td>
			<td><%= trav.getDate() %></td>
			<td><a href="ExpenseDelete.jsp?expenseId=<%= trav.getExpenseId() %>">Delete</a></td>
			<td><a href="ExpenseUpdateForm.jsp?expenseId=<%= trav.getExpenseId() %>">Update</a></td> 			
		
		</tr>
		
		<%
			}
		%>
		
	
	</table>

</body>
</html>