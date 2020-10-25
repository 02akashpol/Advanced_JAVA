<%@page import="servlet.Student"%>
<% 

	int stdNo = Integer.parseInt(request.getParameter("stdNo"));
	String stdName = request.getParameter("stdName");
	float fee = Float.parseFloat(request.getParameter("fee"));
	String course = request.getParameter("course");
	
	Student student = new Student();
	
	student.setStdNo(stdNo);
	student.setStdName(stdName);
	student.setFee(fee);
	student.setCourse(course);

	session.setAttribute("student", student);
	response.sendRedirect("Show.jsp");
	
%>