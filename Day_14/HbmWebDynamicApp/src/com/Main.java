package com;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dto.Employee;


public class Main {

	public static void main(String[] args) {
		
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
		sf.close();
	}

}
