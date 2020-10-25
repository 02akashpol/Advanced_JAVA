package com;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dto.Course;
import com.dto.Subject;

public class Main {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr = ssrb.build();
		SessionFactory sf = cfg.buildSessionFactory(ssr);
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		Course c1 = new Course(10, "DAC");
		Course c2 = new Course(20, "DBDA");
		
		Subject s1 = new Subject(1, "C");
		Subject s2 = new Subject(2, "CPP");
		Subject s3 = new Subject(3, "JAVA");
		
		c1.getSubject().add(s1);
		c1.getSubject().add(s2);
		
		c2.getSubject().add(s2);
		c2.getSubject().add(s3);
		
		s1.getCourse().add(c1);
		s2.getCourse().add(c1);
		s2.getCourse().add(c2);
		s3.getCourse().add(c2);
		
		s.save(c1);
		s.save(c2);
		s.save(s1);
		s.save(s2);
		s.save(s3);
		
		tr.commit();
		s.close();
		sf.close();
	}

}
