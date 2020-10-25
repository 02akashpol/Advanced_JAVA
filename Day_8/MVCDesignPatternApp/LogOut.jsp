<%

	session.removeAttribute("user");
	session.removeAttribute("expense");
	session.invalidate();
	response.sendRedirect("LogIn.jsp");

%>