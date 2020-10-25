package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dto.Clerk;
import com.dto.Manager;

public class Main {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr = ssrb.build();
		SessionFactory sf = cfg.buildSessionFactory(ssr);
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		Manager mgr = new Manager(101, "Akash Pol", 60000, 9000, 7525);
		Clerk clr = new Clerk(102, "Pol Akash", 50000, 5225);
		
		s.save(mgr);
		s.save(clr);
		
		tr.commit();
		s.close();
		sf.close();
	}

}
