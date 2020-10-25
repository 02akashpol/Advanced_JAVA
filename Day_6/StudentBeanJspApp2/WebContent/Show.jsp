<%@page import="servlet.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="student" class="servlet.Student" scope="session"></jsp:useBean>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Record Page</title>
</head>
<body>


	<table align="center">
	
		<tr>
		
			<jsp:getProperty property="stdNo" name="student"/>
			<jsp:getProperty property="stdName" name="student"/>
			<jsp:getProperty property="fee" name="student"/>
			<jsp:getProperty property="course" name="student"/>
		
		</tr>
	
	</table>

</body>
</html>