<%@page import="servlet.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Record Page</title>
</head>
<body>

	<%
	
		Student student = (Student)session.getAttribute("student");
	
	%>

	<table align="center">
	
		<tr>
		
			<td><%= student.getStdNo() %> </td>
			<td><%= student.getStdName() %> </td>
			<td><%= student.getFee() %> </td>
			<td><%= student.getCourse() %> </td>
		
		</tr>
	
	</table>

</body>
</html>