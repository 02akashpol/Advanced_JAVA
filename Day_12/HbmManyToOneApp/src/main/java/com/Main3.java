package com;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dto.Department;
import com.dto.Employee;

public class Main3 {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr = ssrb.build();
		SessionFactory sf = cfg.buildSessionFactory(ssr);
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		Department dept = new Department(10, "CS"); 
		Employee emp = new Employee(102, "Akash");
		emp.setDept(dept);
		
		s.save(dept);
		s.save(emp);
		
		tr.commit();
		s.close();
		sf.close();
	}

}
