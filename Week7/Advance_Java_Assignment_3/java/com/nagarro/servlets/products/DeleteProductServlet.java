package com.nagarro.servlets.products;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.models.Product;

@WebServlet("/DeleteProduct")
public class DeleteProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
				.buildSessionFactory();
		Session ses = factory.openSession();
		ses.beginTransaction();
		String title = request.getParameter("title");
		Query query;

		query = ses.createQuery("delete from Product where title=:title");

		query.setParameter("title", title);

		query.executeUpdate();
		ses.close();
		response.sendRedirect("home.jsp");
	}

}
