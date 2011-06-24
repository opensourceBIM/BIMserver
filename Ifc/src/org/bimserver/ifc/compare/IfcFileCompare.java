package org.bimserver.ifc.compare;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
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