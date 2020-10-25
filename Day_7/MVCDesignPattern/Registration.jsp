<%@page import="com.service.UserServiceImple"%>
<%@page import="com.service.UserService"%>


<jsp:useBean id="user" class="com.dto.User" scope="page"></jsp:useBean>
<jsp:setProperty name="user" property="*" />

<% 

	UserService userService = new UserServiceImple();
	int recv = userService.registration(user);
	
	if(recv == 1)
		response.sendRedirect("LogIn.jsp");
	else
		response.sendRedirect("RegistrationForm.jsp?errorMsg=Registration failed please provide the correct inputs.");
%>		

<%-- <%="Registration failed. Please provide other inputs." %> --%>