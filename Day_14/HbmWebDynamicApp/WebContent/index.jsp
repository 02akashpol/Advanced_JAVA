<%@page import="java.util.Date"%>
<%@page import="com.dto.Employee"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistry"%>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.Transaction"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	
	Configuration cfg = new Configuration().configure();
	StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
	ssrb.applySettings(cfg.getProperties());
	StandardServiceRegistry ssr = ssrb.build();
	SessionFactory sf = cfg.buildSessionFactory(ssr);
	Session s = sf.openSession();
	Transaction tr = s.beginTransaction();
	
	Employee emp1 = new Employee("Akash Pol", 60000.23F, "CDAC", new Date());
	Employee emp2 = new Employee("Pol Akash", 60000.23F, "DAC", new Date());
	
	s.save(emp1);
	s.save(emp2);
	
	tr.commit();
	s.close();
	//sf.close();
	
%>

<%
    //Configuration cfg1 = new Configuration().configure();
	//StandardServiceRegistryBuilder ssrb1 = new StandardServiceRegistryBuilder();
	//ssrb.applySettings(cfg1.getProperties());
	//StandardServiceRegistry ssr1 = ssrb.build();
	//SessionFactory sf1 = cfg1.buildSessionFactory(ssr);
	Session s1 = sf.openSession();
	Transaction tr1 = s1.beginTransaction();
	Query q = s1.createQuery("from Employee");
	List<Employee> list = q.list();
	System.out.println(list); 
	tr1.commit();
	s1.close();
	sf.close();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HbmDynamicWebApp</title>
</head>
<body>

	<table align="center" >
		
			
	
	<%
		for(Employee trav : list){
	%>
	<tr>
		<td>
			<%=trav%>
		</td>
	</tr>
	<%
		}
	%>
	</table>

</body>
</html>