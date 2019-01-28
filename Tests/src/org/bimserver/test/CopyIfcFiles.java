package org.bimserver.test;

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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyIfcFiles {
	public static void main(String[] args) {
		Path sourceDirectory = Paths.get(args[0]);
		Path targetDirectory = Paths.get(args[1]);
		processPath(sourceDirectory, targetDirectory);
	}

	private static void processPath(Path sourceDirectory, Path targetDirectory) {
		try {
			for (Path path : Files.newDirectoryStream(sourceDirectory)) {
				if (Files.isDirectory(path)) {
					processPath(path, targetDirectory);
				} else {
					String filename = path.getFileName().toString().toLowerCase();
					if (filename.endsWith(".ifc") || filename.endsWith(".ifcxml")) {
						Files.copy(path, targetDirectory.resolve(filename));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
