<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style type="text/css">

	h2{
	
		background-color: grey;
		color: white;
		width: 20vw;
	}

</style>
</head>
<body>

	<form action="Registration.jsp">
	
		<table align="center">
		
			<tr>
			
				<td><h2>Registration Page</h2> </td>
			
			</tr>
		
			<tr>
			
				<td>User Name : <input type="text" name="userName" placeholder="Enter your user name :" > </td>
			
			</tr>
			
			<tr>
			
				<td>Password : <input type="password" name="password" placeholder="Enter your user name :" > </td>
			
			</tr>
			
			<tr>
			
				<td><input type="submit" value="Register" > </td>
			
			</tr>
			
			<tr>
			
				<td style="color: red; font-size: 15px;"> 
				
					<%= (request.getParameter("errorMsg")) != null ? request.getParameter("errorMsg") : "" %> 
					
				</td>
			
			</tr>
			
			<tr>
			
				<td> <a href="LogIn.jsp">Back To LogIn</a> </td>
			
			</tr>
			
		</table>
	
	</form>

</body>
</html>