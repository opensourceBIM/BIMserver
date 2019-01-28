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

import java.io.File;

public class TempUtils {
	private static final String tmpDirName = System.getProperty("java.io.tmpdir");
	
	public static File makeTempDir(String name) {
		File tempDir = new File(tmpDirName);
		if (!tempDir.isDirectory()) {
			throw new RuntimeException("Temp dir " + tmpDirName + " does not exist");
		}
		File subDir = new File(tempDir, name);
		if (!subDir.exists()) {
			subDir.mkdir();
		}
		return subDir;
	}

	public static File makeTempFile(File baseDir, String name) {
		return new File(baseDir, name);
	}
}