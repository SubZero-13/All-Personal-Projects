package com.nagarro.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.entities.Tshirt;
import com.nagarro.enums.Gender;
import com.nagarro.enums.Size;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class TshirtDao {

	Configuration configuration;
	SessionFactory sessionFactory;
	Session session;

	public TshirtDao() {
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Tshirt.class);
		sessionFactory = configuration.buildSessionFactory();
	}

	public void storeInDatabase(Tshirt tshirt) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(tshirt);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteFilesFromDatabase(File file) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		if (file.getName().toString().equals("Nike.csv")) {
			String hql = "DELETE FROM Tshirt WHERE id LIKE 'NIC%'";
			Query query = session.createQuery(hql);
			query.executeUpdate();

		}
		if (file.getName().toString().equals("Puma.csv")) {
			String hql = "DELETE FROM Tshirt WHERE id LIKE 'PU%'";
			Query query = session.createQuery(hql);
			query.executeUpdate();

		}
		if (file.getName().toString().equals("Adidas.csv")) {
			String hql = "DELETE FROM Tshirt WHERE id LIKE 'ADC%'";
			Query query = session.createQuery(hql);
			query.executeUpdate();
		}
		session.getTransaction().commit();
		session.close();
	}

	public void modifyDatabase(File file) throws IOException {
		List<Tshirt> tshirts = new ArrayList<>();
		try {
			CSVParser parser = new CSVParserBuilder().withSeparator('|').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(parser).withSkipLines(1)
					.build();
			csvReader.forEach(dataRow -> {
				Tshirt tshirt = new Tshirt();
				tshirt.setId(dataRow[0]);
				tshirt.setName(dataRow[1]);
				tshirt.setColor(dataRow[2]);
				tshirt.setGender(Gender.valueOf(dataRow[3].toUpperCase()));
				tshirt.setSize(Size.valueOf(dataRow[4].toUpperCase()));
				tshirt.setPrice(Double.parseDouble(dataRow[5]));
				tshirt.setRating(Double.parseDouble(dataRow[6]));
				tshirt.setAvalibilty(dataRow[7]);
				tshirts.add(tshirt);
			});
		} catch (FileNotFoundException exception) {
			System.out.println(exception.getMessage());
		}

		session = sessionFactory.openSession();
		session.beginTransaction();

		for (Tshirt tshirt : tshirts) {
			Tshirt existingTshirt = session.get(Tshirt.class, tshirt.getId());
			if (existingTshirt == null) {
				// Record is Added
				session.save(tshirt);
			} else if (!existingTshirt.equals(tshirt)) {
				// Record exists, but has been modified, so update the record
				existingTshirt.setColor(tshirt.getColor());
				existingTshirt.setName(tshirt.getName());
				existingTshirt.setGender(tshirt.getGender());
				existingTshirt.setSize(tshirt.getSize());
				existingTshirt.setAvalibilty(tshirt.getAvalibilty());
				existingTshirt.setPrice(tshirt.getPrice());
				existingTshirt.setRating(tshirt.getRating());
				session.update(existingTshirt);
			}
		}
		// Delete records that were deleted from the CSV file
		List<String> tshirtIds = tshirts.stream().map(Tshirt::getId).collect(Collectors.toList());

		List<Tshirt> existingTshirts = session.createQuery("FROM Tshirt", Tshirt.class).list();
		for (Tshirt existingTshirt : existingTshirts) {
			if (!tshirtIds.contains(existingTshirt.getId())) {
				session.delete(existingTshirt);
			}
		}
		session.getTransaction().commit();
		session.close();
	}

}
