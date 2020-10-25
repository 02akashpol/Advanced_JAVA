<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Expense Page</title>
</head>
<body>

	<form action="Add.jsp">
	
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
			
		</table>
	
	</form>
	

</body>
</html>