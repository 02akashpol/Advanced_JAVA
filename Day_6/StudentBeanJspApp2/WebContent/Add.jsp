
<jsp:useBean id="student" class="servlet.Student" scope="session"></jsp:useBean>

<%--
<jsp:setProperty name="student" param="stdNo" property="stdNo" />
<jsp:setProperty name="student" param="stdName" property="stdName" />
<jsp:setProperty name="student" param="fee" property="fee" />
<jsp:setProperty name="student" param="course" property="course" />
--%>

<jsp:setProperty name="student" property="*" />

<% 

	response.sendRedirect("Show.jsp");
		
%>

 