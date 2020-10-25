<%@page import="com.service.UserServiceImple"%>
<%@page import="com.service.UserService"%>

<jsp:useBean id="user" class="com.dto.User" scope="session"></jsp:useBean>
<jsp:setProperty name="user" property="*" />

<%

	UserService userService = new UserServiceImple();
	boolean recv = userService.logIn(user);
	
	if(recv)
		response.sendRedirect("Home.jsp");
	else
		response.sendRedirect("LogIn.jsp?errorMsg=LogIn failed. Please provide the correct inputs.");

%>