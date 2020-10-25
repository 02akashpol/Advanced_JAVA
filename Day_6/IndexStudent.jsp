<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Index Page</title>
</head>
<body>

	<form action="Add.jsp">
	
		<table align="center">
		
			<tr>
			
				<td>Student Roll No :  <input type="text" name="stdNo" placeholder="Enter the student roll number : "> </td>
			
			</tr>
			
			<tr>
			
				<td>Student Name :  <input type="text" name="stdName" placeholder="Enter the student name : "> </td>
			
			</tr>
			
			<tr>
			
				<td>Student Fee :  <input type="text" name="fee" placeholder="Enter the student fee amount : "> </td>
			
			</tr>
			
			<tr>
			
				<td>Student Course :  <input type="text" name="course" placeholder="Enter the student course name : "> </td>
			
			</tr>
			
			<tr>
			
				<td><input type="submit" value="Submit"> </td>
			
			</tr>
		
		</table>
	
	</form>

</body>
</html>