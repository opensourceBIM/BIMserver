package org.bimserver.ifc.compare;

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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewIfcFileCompare {
	private static final Logger LOGGER = LoggerFactory.getLogger(NewIfcFileCompare.class);
	private final File sourceFile;
	private final File destFile;
	private List<String> sortFile1;
	private List<String> sortFile2;

	public NewIfcFileCompare(File sourceFile, File destFile) {
		this.sourceFile = sourceFile;
		this.destFile = destFile;
	}

	public List<String> sortFile(File sourceFile) {
		List<String> lines = new LinkedList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
			String line = reader.readLine();
			while (line != null) {
				line = line.replace(" ", "").trim();
				while (!line.endsWith(";")) {
					line += reader.readLine();
				}
				if (!line.equals("") && line.startsWith("#") && line.endsWith(";") && line.contains("=")) {
					lines.add(line);
				}
				line = reader.readLine();
			}
			reader.close();
			Collections.sort(lines, new Comparator<String>(){
				@Override
				public int compare(String o1, String o2) {
					if (o1.startsWith("#")) {
						if (o2.startsWith("#")) {
							if (o1.indexOf("=") != -1 && o2.indexOf("=") != -1) {
								int diff = o1.substring(o1.indexOf("=")).compareTo(o2.substring(o2.indexOf("=")));
								diff += 100 * (Integer.parseInt(o1.substring(1, o1.indexOf("="))) - Integer.parseInt(o2.substring(1, o2.indexOf("="))));
								return diff;
							}
						}
					}
					return o1.compareTo(o2);
				}});
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return lines;
	}

	public boolean compare() {
		sortFile1 = sortFile(sourceFile);
		sortFile2 = sortFile(destFile);
		if (sortFile1.size() != sortFile2.size()) {
			return returnFalse();
		}
		for (int i=0; i<sortFile1.size(); i++) {
			if (!sortFile1.get(i).equals(sortFile2.get(i))) {
				return returnFalse();
			}
		}
		return true;
	}
	
	private boolean returnFalse() {
		return false;
	}

	public void dumpSource(File file) {
		dumpFile(sortFile1, file);
	}
	
	public void dumpGenerated(File file) {
		dumpFile(sortFile2, file);
	}
	
	private void dumpFile(List<String> lines, File file) {
		try {
			PrintWriter out = new PrintWriter(file);
			for (String line : lines) {
				out.println(line);
			}
			out.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
	}
}