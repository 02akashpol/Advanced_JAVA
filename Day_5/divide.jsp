<%@ page errorPage="error_page.jsp" %>
<%@ include file="header.jsp" %>

<%! 

	int res;
	void divide(int num1, int num2) {
		
		res = num1 / num2;
	}

%>

<%

	String recv1 = request.getParameter("num1");
	String recv2 = request.getParameter("num2");
	
	int num1 = Integer.parseInt(recv1);
	int num2 = Integer.parseInt(recv2);
	
	divide(num1, num2);

%>

<%=res%> 
