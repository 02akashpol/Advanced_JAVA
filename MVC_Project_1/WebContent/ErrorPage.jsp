<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>

	<h3 style="color: red;">	
		Error Occurred. <br>
		404! 
		
 	</h3>
		
		<%-- include login page --%>
	
		Hi There, error code is <%=response.getStatus() %><br>
		Please go to <a href="/LogIn.jsp">LogIn Page</a>

</body>
</html>