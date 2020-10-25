package com;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dto.Category;
import com.dto.Item;

public class Main4 {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr = ssrb.build();
		SessionFactory sf = cfg.buildSessionFactory(ssr);
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		Item item = new Item(30, "Laptop");
		Item item1 = new Item(40, "PC");
		
		Category catg = new Category(102, "Electroncs");
		
		catg.getItem().add(item);
		catg.getItem().add(item1);
		
		s.save(item);
		s.save(item1);
		s.save(catg);
		
		tr.commit();
		s.close();
		sf.close();
	}

}
