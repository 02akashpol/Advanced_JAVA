<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense LogIn Page</title>
<style type="text/css">

	h2{
	
		background-color: grey;
		color: white;
		width: 20vw;
	}

</style>
</head>
<body>

	<form action="Validate.jsp">
	
		<table align="center">
		
			<tr>
			
				<td><h2>Log In Page</h2> </td>
			
			</tr>
		
			<tr>
			
				<td>User Name : <input type="text" name="userName" placeholder="Enter your user name :" > </td>
			
			</tr>
			
			<tr>
			
				<td>Password : <input type="password" name="password" placeholder="Enter your user name :" > </td>
			
			</tr>
			
			<tr>
			
				<td><input type="submit" value="LogIn" > </td>
			
			</tr>
			
			<tr>
			
				<td> <a href="RegistrationForm.jsp">SignUp</a> </td>
			
			</tr>
		
		</table>
	
	</form>

</body>
</html>