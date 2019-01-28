package org.bimserver.utils;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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