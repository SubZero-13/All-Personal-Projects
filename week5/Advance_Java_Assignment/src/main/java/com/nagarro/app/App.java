package com.nagarro.app;

import java.util.List;

import com.nagarro.csvfiles.CSVFolderWatcher;
import com.nagarro.io.*;
import com.nagarro.searching.Search;
import com.nagarro.tshirtdetails.*;

public class App {
	public static void main(String[] args) {
		Thread csvWatcherThread = new Thread(new CSVFolderWatcher());
		csvWatcherThread.start();
		while (true) {
			try {
				Input input = new Input();
				TshirtInput tshirtIp = input.getInput();
				Search search = new Search();
				List<Tshirt> result = search.searchTshirt(tshirtIp);
				OutputResult output = new OutputResult();
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
