package org.bimserver.tests;

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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

public class Bla {
	public static void main(String[] args) {
		new Bla().start();
	}

	private void start() {
		sortFile(TestFile.MERGE_TEST_SOURCE_FILE.getFile(), Paths.get("1.ifc"));
		sortFile(Paths.get("in.ifc"), Paths.get("2.ifc"));
	}

	public static void sortFile(Path sourceFile, Path destFile) {
		try {
			System.out.println(sourceFile);
			BufferedReader reader = new BufferedReader(new FileReader(sourceFile.toFile()));
			String line = reader.readLine();
			Set<String> lines = new TreeSet<String>();
			while (line != null) {
				line = line.replace(" ", "");
				if (line.indexOf("=") != -1) {
					line = line.substring(line.indexOf("="));
				}
				lines.add(line);
				line = reader.readLine();
			}
			reader.close();
			PrintWriter out = new PrintWriter(destFile.toFile());
			for (String r : lines) {
				out.write(r + "\n");
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}