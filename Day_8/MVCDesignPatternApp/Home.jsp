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
<title>Home Page</title>
</head>
<body>

	<h2> <a href="ExpenseAddForm.jsp">Add Expenses</a> </h2> <br> 
	
	<h2> <a href="ExpenseList.jsp">Expenses List</a> </h2> 
	

</body>
</html>