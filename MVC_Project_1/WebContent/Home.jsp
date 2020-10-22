<%@page import="com.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="user" class="com.dto.User" scope="session" ></jsp:useBean>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="CacheControl.jsp"></jsp:include>

<%

	String recv = user.getFullName();
	
	if(user != null && user.getFullName() != null) {

%>
    
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

	h1{
	
		color: red;
		font-size: 45px;
		text-align: center;
		align-content: center;
		align-items: center;
	}

</style>

<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>

<body>

	<h1> Welcome <%= recv %> to our web site. </h1>

</body>
</html>

<%
	
	} else {
		
		response.sendRedirect("LogIn.jsp");
	}

%>