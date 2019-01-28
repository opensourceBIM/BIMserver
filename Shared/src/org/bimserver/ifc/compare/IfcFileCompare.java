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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcFileCompare {
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcFileCompare.class);

	public void compare(File src, File dest) throws Exception {
		File compareFile = new File("compare.txt");
		PrintWriter out = new PrintWriter(compareFile);
		try {
			InputStream srcStream = new FileInputStream(src);
			InputStream destStream = new FileInputStream(dest);
			int diffs = 0;

			FileReader srcReader = new FileReader(srcStream);
			FileReader destReader = new FileReader(destStream);
			
			String nextSourceLine = srcReader.getNextLine();
			String nextDestLine = destReader.getNextLine();
			while (nextSourceLine != null) {
				if (nextDestLine == null) {
					out.close();
					LOGGER.info("Diffs: " + diffs);
					throw new Exception("Line count not equal");
				}
				if (!nextSourceLine.equals(nextDestLine)) {
					out.println(nextSourceLine);
					out.println(nextDestLine);
					out.println();
					diffs++;
				}
//				if (i % 100 == 0) {
//					LOGGER.info("id: " + i + " (" + diffs + ")");
//				}
				nextSourceLine = srcReader.getNextLine();
				nextDestLine = destReader.getNextLine();
			}
			srcStream.close();
			destStream.close();
			out.close();
			LOGGER.info("Diffs: " + diffs);
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
	}
}