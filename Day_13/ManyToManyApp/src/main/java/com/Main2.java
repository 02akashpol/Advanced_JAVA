package com;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dto.Course;
import com.dto.Subject;

public class Main2 {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr = ssrb.build();
		SessionFactory sf = cfg.buildSessionFactory(ssr);
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		Query q = s.createQuery("from Course");
		
		List<Course> list = q.list();
		
		for(Course trav : list) {
		
			System.out.println(trav);
			Set<Subject> sub = trav.getSubject();
			for(Subject trav1 : sub) {
				
				System.out.println(trav1);
			}	
		}
			
		tr.commit();
		s.close();
		sf.close();
	}

}
