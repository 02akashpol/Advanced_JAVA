package com;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dto.Department;
import com.dto.Manager;

public class Main1 {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr = ssrb.build();
		SessionFactory sf = cfg.buildSessionFactory(ssr);
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		Query q = s.createQuery("from Department");
		List<Department> list = q.list();
		
		for(Department trav : list) {
			
			System.out.println(trav);
		}
		
		tr.commit();
		s.close();
		sf.close();
	}

}
