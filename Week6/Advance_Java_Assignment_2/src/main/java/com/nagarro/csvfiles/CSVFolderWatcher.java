package com.nagarro.csvfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import com.nagarro.constants.Constant;

public class CSVFolderWatcher implements Runnable {
	private volatile boolean exit = false;
	CSVFileReader csv = new CSVFileReader();
	Service service = new Service();
	final long timeInterval = 10000;

	@Override
	public void run() {
		while (!exit) {
			WatchService watchService = null;
			try {
				watchService = FileSystems.getDefault().newWatchService();
			} catch (IOException exception) {
				System.out.println(exception.getMessage());
			}

			Path path = Paths.get(Constant.DIRECTORY_PATH);

			try {
				path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
						StandardWatchEventKinds.ENTRY_MODIFY);
			} catch (IOException exception) {
				System.out.println(exception.getMessage());
			}

			WatchKey key;
			try {
				while ((key = watchService.take()) != null) {
					for (WatchEvent<?> event : key.pollEvents()) {
						Path filename = (Path) event.context();
						File file = path.resolve(filename).toFile();
						if (file.getName().endsWith(".csv")) {
							if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
								csv.readFiles(file.toString());
							} else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
								service.deleteFilesFromDatabase(file);
							} else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
								service.modifyDatabase(file);
							}
						}
					}
					key.reset();
				}
			} catch (InterruptedException exception) {
				System.out.println(exception.getMessage());
			} catch (IOException exception) {
				System.out.println(exception.getMessage());
			}
			try {
				Thread.sleep(timeInterval);
			} catch (InterruptedException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	public void stop() {
		exit = true;
	}
}
