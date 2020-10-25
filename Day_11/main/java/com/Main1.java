package com;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dto.Employee;

public class Main1 {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr = ssrb.build();
		SessionFactory sf = cfg.buildSessionFactory(ssr);
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Employee emp = new Employee(102, "Akash", 60000.256f, "CDAC", new Date());
		Employee emp1 = new Employee(103, "Pol", 60000.256f, "CDAC", new Date());
		Employee emp2 = new Employee(104, "Pol Akash", 60000.256f, "CDAC", new Date());
		
		s.save(emp);
		s.save(emp1);
		s.save(emp2);
		//System.out.println(emp);
		//emp.setDept("IT");
		//System.out.println(emp);
		
		tr.commit();
		s.close();
		//emp.setDept("DAC");
		//System.out.println(emp);
		sf.close();
	}

}
