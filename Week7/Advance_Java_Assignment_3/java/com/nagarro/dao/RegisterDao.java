package com.nagarro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.models.User;

public class RegisterDao {

	public boolean registerUser(String uname, String pass) {

		if (uname == null || pass == null || uname.length() <= 4 || pass.length() < 8) {
			return false;
		}

		User user = new User(uname, pass);
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
		return flag;

	}

}
