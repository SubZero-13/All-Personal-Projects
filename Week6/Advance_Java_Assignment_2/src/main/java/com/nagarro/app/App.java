package com.nagarro.app;

import java.util.List;

import com.nagarro.csvfiles.CSVFileReader;
import com.nagarro.csvfiles.CSVFolderWatcher;
import com.nagarro.io.*;
import com.nagarro.searching.Search;
import com.nagarro.tshirtdetails.*;

public class App {
	public static void main(String[] args) {
		try {
			CSVFolderWatcher csvWatcherThread = new CSVFolderWatcher();
			Thread thread = new Thread(csvWatcherThread);
			thread.start();
			Input input = new Input();
			Search search = new Search();
			OutputResult output = new OutputResult();
			CSVFileReader csv = new CSVFileReader();
//			csv.readFilesAndStoreInDatabase();
			while (true) {
				try {
					TshirtInput tshirtIp = input.getInput();
					List<Tshirt> result = search.searchTshirt(tshirtIp);
					output.printData(result);

				} catch (Exception exception) {
					System.out.println(exception.getMessage());
				}
				try {
					String yesOrNo = input.getYesOrNoInput();
					if (yesOrNo.equalsIgnoreCase("N")) {
						System.out.println("Thank You For Using our Application :)");
						System.exit(0);
					}
				} catch (Exception exception) {
					System.out.println(exception.getMessage());
				}
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
