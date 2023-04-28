package com.nagarro.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

import com.nagarro.constants.Constant;
import com.nagarro.dao.TshirtDao;
import com.nagarro.entities.Tshirt;
import com.nagarro.enums.Gender;
import com.nagarro.enums.Size;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVFileReader {
	TshirtDao tshirtDao = new TshirtDao();

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
				tshirt.setColor(dataRow[2]);
				tshirt.setGender(Gender.valueOf(dataRow[3].toUpperCase()));
				tshirt.setSize(Size.valueOf(dataRow[4].toUpperCase()));
				tshirt.setPrice(Double.parseDouble(dataRow[5]));
				tshirt.setRating(Double.parseDouble(dataRow[6]));
				tshirt.setAvalibilty(dataRow[7]);
				tshirtDao.storeInDatabase(tshirt);
			});
		} catch (FileNotFoundException exception) {
			System.out.println(exception.getMessage());
		}
	}
}
