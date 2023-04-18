package com.nagarro.csvfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.nagarro.tshirtdetails.Tshirt;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.nagarro.constants.Constant;
import com.nagarro.database.TshirtStore;
import com.nagarro.enums.*;

public class CSVFileReader {
	TshirtStore store = new TshirtStore();

	public void readFilesAndStoreInDatabase() {
		File folder = new File(Constant.DIRECTORY_PATH);
		File[] files = folder.listFiles((dir, name) -> name.endsWith(".csv"));
		Arrays.stream(files).map(File::getAbsolutePath).forEach(this::readFiles);
	}

	public void readFiles(String file) {
		try {
			CSVParser parser = new CSVParserBuilder().withSeparator('|').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(parser).withSkipLines(1)
					.build();
			csvReader.forEach(dataRow -> {
				Tshirt tshirt = new Tshirt();
				tshirt.setId(dataRow[0]);
				tshirt.setName(dataRow[1]);
				tshirt.setColor(Color.valueOf(dataRow[2].toUpperCase()));
				tshirt.setGender(Gender.valueOf(dataRow[3].toUpperCase()));
				tshirt.setSize(Size.valueOf(dataRow[4].toUpperCase()));
				tshirt.setPrice(Double.parseDouble(dataRow[5]));
				tshirt.setRating(Double.parseDouble(dataRow[6]));
				tshirt.setAvalibilty(dataRow[7]);
				store.storeInDatabase(tshirt);
			});
		} catch (FileNotFoundException exception) {
			System.out.println(exception.getMessage());
		}
	}
}
