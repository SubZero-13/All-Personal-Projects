package com.nagarro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.models.User;

public class UserDao {
	public boolean checkLogin(String uname, String pass) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Query query;
		query = session.createQuery("from User where username=:uname AND  password=:pass");

		query.setParameter("uname", uname);
		query.setParameter("pass", pass);

		User user = (User) query.uniqueResult();

		if (user != null) {
			return true;
		}

		return false;
	}

}
