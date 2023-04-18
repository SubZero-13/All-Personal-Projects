package com.nagarro.app;

import java.util.List;

import com.nagarro.csvfiles.CSVFolderWatcher;
import com.nagarro.io.*;
import com.nagarro.searching.Search;
import com.nagarro.tshirtdetails.*;

public class App {
	public static void main(String[] args) {
		Thread csvWatcherThread = new Thread(new CSVFolderWatcher());
		Input input = new Input();
		Search search = new Search();
		OutputResult output = new OutputResult();
		csvWatcherThread.start();
		while (true) {
			try {
				TshirtInput tshirtIp = input.getInput();
				List<Tshirt> result = search.searchTshirt(tshirtIp);
				output.printData(result);
				String yesOrNo = input.getYesOrNoInput();
				if (yesOrNo.equalsIgnoreCase("N")) {
					System.out.println("Thank You For Using our Application :)");
					break;
				}
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}
}
