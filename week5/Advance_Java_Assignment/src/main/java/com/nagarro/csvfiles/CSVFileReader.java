package com.nagarro.csvfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.nagarro.tshirtdetails.Tshirt;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.nagarro.enums.*;

public class CSVFileReader {
	private final Map<String, List<Tshirt>> data = new HashMap<>();

	public Map<String, List<Tshirt>> getData() {
		File folder = new File(
				"C:\\Users\\aniketkumar01\\Desktop\\aniket-kumar\\week5\\Advance_Java_Assignment\\src\\main\\resources\\csvfiles");
		File[] files = folder.listFiles((dir, name) -> name.endsWith(".csv"));
		Arrays.stream(files).map(File::getAbsolutePath).forEach(this::readFiles);
		return data;
	}

	public void readFiles(String file) {
		try {
			CSVParser parser = new CSVParserBuilder().withSeparator('|').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(parser).withSkipLines(1)
					.build();
			List<Tshirt> list = new ArrayList<>();
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
				list.add(tshirt);
			});
			data.put(file, list);
		} catch (FileNotFoundException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public void deleteCsvFileData(String file) {
		data.remove(file);
	}
}
