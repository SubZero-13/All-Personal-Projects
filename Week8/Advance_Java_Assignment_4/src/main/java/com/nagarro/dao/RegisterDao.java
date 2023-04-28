package com.nagarro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.entities.Tshirt;
import com.nagarro.entities.User;

public class RegisterDao {

	public boolean registerUser(String username, String password) {

		if (username == null || password == null || username.length() <= 4 || password.length() < 8) {
			return false;
		}

		User user = new User(username, password);
		boolean flag = false;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		if (user != null) {
			session.save(user);
			flag = true;
		}
		session.getTransaction().commit();
		session.close();
		return flag;

	}

}
