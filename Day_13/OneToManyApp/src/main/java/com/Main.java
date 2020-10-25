package com;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dto.Category;
import com.dto.Item;

public class Main {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr = ssrb.build();
		SessionFactory sf = cfg.buildSessionFactory(ssr);
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		
		Item item1 = new Item(1, "Fan");
		Item item2 = new Item(2, "Cooler");
		Item item3 = new Item(3, "Mixer");
		
		Category catg = new Category(10, "Electrical");
		
		Set<Item> item = catg.getItem();
		item.add(item1);
		item.add(item2);
		item.add(item3);
		
		s.save(catg);
		//s.save(item);
		s.save(item1);
		s.save(item2);
		s.save(item3);
		
		tr.commit();
		s.close();
		sf.close();
	}

}
