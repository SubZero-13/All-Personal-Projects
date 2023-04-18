package com.nagarro.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.tshirtdetails.Tshirt;
import com.nagarro.tshirtdetails.TshirtInput;
import com.nagarro.enums.*;
import com.nagarro.exceptions.ItemNotPresentException;
import com.nagarro.comparator.*;
import com.nagarro.csvfiles.*;

public class Search {
	public List<Tshirt> searchTshirt(TshirtInput tshirtIp) throws ItemNotPresentException {
		List<Tshirt> result = new ArrayList<Tshirt>();

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Tshirt.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Comparator<Tshirt> pricecompare = new PriceComparator();
		Comparator<Tshirt> ratingcompare = new RatingComparator();
		Comparator<Tshirt> bothcompare = new BothComparator();

		String color = tshirtIp.getColor().toString();
		String gender = tshirtIp.getGender().toString();
		String size = tshirtIp.getSize().toString();
		OutputPreference preference = tshirtIp.getOutputPreference();

		Query<Tshirt> query = session.createQuery("FROM Tshirt", Tshirt.class);
		ArrayList<Tshirt> tshirtList = (ArrayList<Tshirt>) query.getResultList();

		for (Tshirt tshirt : tshirtList) {
			if (tshirt.getColor().toString().equalsIgnoreCase(color)
					&& tshirt.getGender().toString().equalsIgnoreCase(gender)
					&& tshirt.getSize().toString().equalsIgnoreCase(size)
					&& tshirt.getAvalibilty().equalsIgnoreCase("Y")) {
				result.add(tshirt);
			}
		}

		if (result.size() == 0) {
			throw new ItemNotPresentException(
					"Oh no, it seems we're all out of T-shirts that match your search. Time to change up your style!");
		}

		switch (preference) {
		case PRICE:
			Collections.sort(result, pricecompare);
			break;
		case RATING:
			Collections.sort(result, ratingcompare);
			break;
		case BOTH:
			Collections.sort(result, bothcompare);
			break;
		}
		session.getTransaction().commit();
		session.close();
		return result;
	}
}
