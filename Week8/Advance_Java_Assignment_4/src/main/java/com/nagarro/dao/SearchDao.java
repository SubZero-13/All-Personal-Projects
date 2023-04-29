package com.nagarro.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.comparator.BothComparator;
import com.nagarro.comparator.PriceComparator;
import com.nagarro.comparator.RatingComparator;
import com.nagarro.entities.Tshirt;
import com.nagarro.filereader.CSVFolderWatcher;

public class SearchDao {
	public List<Tshirt> searchTshirt(String color, String gender, String size, String preference) {

//		CSVFileReader csvreader = new CSVFileReader();
//		csvreader.readFilesAndStoreInDatabase();
		Thread thread = new Thread(new CSVFolderWatcher());
		thread.start();

		List<Tshirt> result = new ArrayList<Tshirt>();

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Tshirt.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Comparator<Tshirt> pricecompare = new PriceComparator();
		Comparator<Tshirt> ratingcompare = new RatingComparator();
		Comparator<Tshirt> bothcompare = new BothComparator();

		Query<Tshirt> query = session.createQuery("FROM Tshirt", Tshirt.class);

		ArrayList<Tshirt> tshirtList = (ArrayList<Tshirt>) query.getResultList();

		for (Tshirt tshirt : tshirtList) {
			if (tshirt.getColor().equalsIgnoreCase(color) && tshirt.getGender().toString().equalsIgnoreCase(gender)
					&& tshirt.getSize().toString().equalsIgnoreCase(size)
					&& tshirt.getAvalibilty().equalsIgnoreCase("Y")) {
				result.add(tshirt);
			}
		}

		if (result.size() == 0) {
			return result;
		}

		switch (preference.toUpperCase()) {
		case "PRICE":
			Collections.sort(result, pricecompare);
			break;
		case "RATING":
			Collections.sort(result, ratingcompare);
			break;
		case "BOTH":
			Collections.sort(result, bothcompare);
			break;
		}

		session.getTransaction().commit();
		session.close();
		return result;
	}
}
