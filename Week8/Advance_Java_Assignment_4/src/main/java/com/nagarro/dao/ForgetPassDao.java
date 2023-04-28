package com.nagarro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.entities.User;

public class ForgetPassDao {

	public boolean forgetPass(String uname, String pass) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Query query;
		query = session.createQuery("update User set password=:pass where username=:uname");

		query.setParameter("uname", uname);
		query.setParameter("pass", pass);

		int flag = query.executeUpdate();
		session.getTransaction().commit();
		session.close();

		if (flag == 1) {
			return true;
		}

		return false;
	}

}
