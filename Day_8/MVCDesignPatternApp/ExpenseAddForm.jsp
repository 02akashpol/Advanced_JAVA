<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="CacheControl.jsp"></jsp:include>

<jsp:useBean id="user" class="com.dto.User" scope="session"></jsp:useBean>

<%

	if(user == null || user.getUserId() == 0)
		response.sendRedirect("LogIn.jsp");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Expense Page</title>
</head>
<body>

	<form action="ExpenseAdd.jsp">
	
		<table align="center">
	
			<tr>
			
				<td>Item Name : <input type="text" name="itemName" placeholder="Enter the item name : "> <br> </td>
			
			</tr>
			
			<tr>
			
				<td> Price : <input type="text" name="price" placeholder="Enter the item price : "> <br> </td>
			
			</tr>
			
			<tr>
			
				<td> Purchase Date : <input type="date" name="date" value="2020-02-02" min="2001-01-01" max="2020-10-30"> <br> </td>
			
			</tr>
			
			<tr>
			
				<td><input type="submit" value="Add"> </td>
			
			</tr>
			
			<tr>
			
				<td style="color: red; font-size: 15px;">
				
					<%= (request.getParameter("errorMsg")) != null ? request.getParameter("errorMsg") : "" %>
					
				</td>
			
			</tr>
			
		</table>
	
	</form>
	

</body>
</html>