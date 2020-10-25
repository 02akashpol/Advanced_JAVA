
<%@page import="com.dto.Expense"%>
<%@page import="com.service.ExpenseServiceImple"%>
<%@page import="com.service.ExpenseService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="CacheControl.jsp"></jsp:include>

<jsp:useBean id="user" class="com.dto.User" scope="session"></jsp:useBean>

<%

	if(user == null || user.getUserId() == 0)
		response.sendRedirect("LogIn.jsp");

%>

<%
	int expenseId = Integer.parseInt(request.getParameter("expenseId"));
	//System.out.println(expenseId);
	ExpenseService expenseService = new ExpenseServiceImple();
	Expense expense = expenseService.getExpense(expenseId);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Update Form</title>
</head>
<body>

	<form action="ExpenseUpdate.jsp">
			
		<table align="center" >
		
			<tr>
			
				<td><input type="hidden" name="expenseId" value="<%= expense.getExpenseId() %>"></td>
			
			</tr>
			
			<tr>
			
				<td>Item Name : <input type="text" name="itemName" value="<%= expense.getItemName() %>"></td>
			
			</tr>
			
			<tr>
			
				<td>Item Price : <input type="text" name="price" value="<%= expense.getPrice() %>"></td>
			
			</tr>
			
			<tr>
			
				<td>Purchase Date : <input type="text" name="date" value="<%= expense.getDate() %>" ></td>
			
			</tr>
			
			<tr>
			
				<td><input type="submit" value="Update"></td>
			
			</tr>
		
		</table>	
				
	</form>

</body>
</html>