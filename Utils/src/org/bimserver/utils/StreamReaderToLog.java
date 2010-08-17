package org.bimserver.utils;

import java.io.InputStream;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamReaderToLog extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(StreamReaderToLog.class);
	private final Scanner scanner;

	public StreamReaderToLog(String name, InputStream inputStream) {
		this.scanner = new Scanner(inputStream);
		setDaemon(true);
		setName(name);
	}

	@Override
	public void run() {
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line != null) {
				LOGGER.info(line);
			}
		}
	}
}