package com.nagarro.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.tshirtdetails.Tshirt;

public class TshirtStore {
	public void storeInDatabase(Tshirt tshirt) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Tshirt.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(tshirt);
		session.getTransaction().commit();
		session.close();
	}
}
