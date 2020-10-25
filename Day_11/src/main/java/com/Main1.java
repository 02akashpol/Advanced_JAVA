package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.dto.Employee;

public class Main1 {

	private static SessionFactory sf;
	
	static {
		
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr = ssrb.build();
		sf = cfg.buildSessionFactory(ssr);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean flag  = true;
	
		while(flag) {
		
			System.out.println("Enter 0 to exit");
			System.out.println("Enter 1 to sel all");
			System.out.println("Enter 2 to sel order");
			System.out.println("Enter 3 to sel order(where)");
			System.out.println("Enter 4 to sel and(where and)");
			System.out.println("Enter 5 to sel names");
			System.out.println("Enter 6 to sel name salary");
			System.out.println("Enter 7 to sel distinct");
			System.out.println("Enter 8 to sel like");
			System.out.println("Enter 9 to sel sum");
			System.out.println("Enter 10 to sel sum group by dept");
			System.out.println("Enter 11 to sel sub query");
			
			byte choice = sc.nextByte();
			
			switch(choice) {
			
				case 0 :
					flag = false;
				break;
			
				case 1 :
					selectAll();
					break;
				
				case 2 :
					selectOrderBy();
					break;
					
				case 3 :
					selectWhere();
					break;
					
				case 4 :
					selectWhereAnd();
					break;
					
				case 5 :
					selectNames();
					break;
					
				case 6 :
					selectNameSalary();
					break;
					
				case 7 :
					selectDistinct();
					break;
					
				case 8 :
					selectLike();
					break;
					
				case 9 :
					selectSum();
					break;
					
				case 10 :
					selectGroupBy();
					break;
					
				case 11 :
					selectSubQuery();
					break;
					
			}
			
		}
		System.out.println("done ==================== ");
		sf.close();
	}
	
	private static void selectAll() {
		
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Criteria q = s.createCriteria(Employee.class);
		List<Employee> list = q.list();
		for(Employee trav : list) {
			
			System.out.println(trav);
		}
		tr.commit();
		s.close();
	}
	
	private static void selectOrderBy() {
		
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Criteria q = s.createCriteria(Employee.class);
		q.addOrder(Order.desc("basicSalary"));
		List<Employee> list = q.list();
		for(Employee trav : list) {
			
			System.out.println(trav);
		}
		tr.commit();
		s.close();
	}
	
	private static void selectWhere() {
		
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Criteria q = s.createCriteria(Employee.class);
		q.add(Restrictions.eq("dept", "IT"));
		List<Employee> list = q.list();
		for(Employee trav : list) 
			System.out.println(trav);
		
		tr.commit();
		s.close();
	}
	
	private static void selectWhereAnd() {
		
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Criteria q = s.createCriteria(Employee.class);
		q.add(Restrictions.and(Restrictions.eq("dept", "CDAC"), Restrictions.ge("basicSalary", 60000f)));
		List<Employee> list = q.list();
		for(Employee trav : list) 
			System.out.println(trav);
		
		tr.commit();
		s.close();
	}
	
	private static void selectNames() {
		
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Criteria q = s.createCriteria(Employee.class);
		
		ProjectionList plist = Projections.projectionList();
		plist.add(Projections.property("empName"));
		q.setProjection(plist);
		
		List<String> list = q.list();
		for(String trav : list) 
			System.out.println(trav);
		
		tr.commit();
		s.close();
	}
	
	private static void selectNameSalary() {
		
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Criteria q = s.createCriteria(Employee.class);
		
		ProjectionList plist = Projections.projectionList();
		plist.add(Projections.property("empName"));
		plist.add(Projections.property("basicSalary"));
		q.setProjection(plist);
		
		List<Object[]> list = q.list();
		for(Object trav[] : list) 
			System.out.println(trav[0] + " "+ trav[1]);
		
		tr.commit();
		s.close();
	}
	
	private static void selectDistinct() {
		
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		Criteria q = s.createCriteria(Employee.class);
		
		ProjectionList plist = Projections.projectionList();
		plist.add(Projections.distinct(Projections.property("dept")));
		q.setProjection(plist);
		
		List<String> list = q.list();
		for(String trav : list) 
			System.out.println(trav);
		
		tr.commit();
		s.close();
	}
	
	private static void selectLike() {
		
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Criteria q = s.createCriteria(Employee.class);
		
		ProjectionList plist = Projections.projectionList();
		plist.add(Projections.property("empName"));
		q.setProjection(plist);
		
		q.add(Restrictions.like("empName", "p%"));
		
		List<String> list = q.list();
		for(String trav : list) 
			System.out.println(trav);
		
		tr.commit();
		s.close();
	}

	private static void selectSum() {
		
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Criteria q = s.createCriteria(Employee.class);
		
		ProjectionList plist = Projections.projectionList();
		plist.add(Projections.sum("basicSalary"));
		q.setProjection(plist);
		List<Double> list = q.list();
		for(Double trav : list)
			System.out.println(trav);
	}
	
	private static void selectGroupBy() {
		
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Criteria q = s.createCriteria(Employee.class);
		
		ProjectionList plist = Projections.projectionList();
		plist.add(Projections.groupProperty("dept"));
		plist.add(Projections.sum("basicSalary"));
		
		q.setProjection(plist);
		
		List<Object[]> list = q.list();
		for(Object trav[] : list) 
			System.out.println(trav[0] + " "+ trav[1]);
		
		tr.commit();
		s.close();
	}
	
	private static void selectSubQuery() {
		
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		DetachedCriteria dc = DetachedCriteria.forClass(Employee.class);
		ProjectionList plist1 = Projections.projectionList();
		plist1.add(Projections.avg("basicSalary"));
		dc.setProjection(plist1);
		
		Criteria q = s.createCriteria(Employee.class);
		
		ProjectionList plist2 = Projections.projectionList();
		plist2.add(Projections.property("empName"));
		plist2.add(Projections.property("basicSalary"));
		q.setProjection(plist2);
		
		q.add(Property.forName("basicSalary").ge(dc));
		
		List<Object[]> list = q.list();
		for(Object trav[] : list) 
			System.out.println(trav[0] + " "+ trav[1]);
		
		tr.commit();
		s.close();
	}
	
}
