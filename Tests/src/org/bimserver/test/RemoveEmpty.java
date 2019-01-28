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
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RemoveEmpty {
	public static void main(String[] args) {
		new RemoveEmpty().start(args[0]);
	}

	private void start(String loc) {
		Path base = Paths.get(loc);
		try {
			DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(base);
			for (Path p : newDirectoryStream) {
				DirectoryStream<Path> a = Files.newDirectoryStream(p);
				int c = 0;
				for (Path b : a) {
					c++;
				}
				if (c == 1) {
					org.apache.commons.io.FileUtils.deleteDirectory(p.toFile());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
