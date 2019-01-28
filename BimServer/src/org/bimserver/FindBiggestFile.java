package org.bimserver;

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

import org.bimserver.utils.Formatters;
import org.bimserver.utils.PathUtils;

public class FindBiggestFile {
	private long max = Long.MIN_VALUE;
	private Path maxFile = null;
	
	public static void main(String[] args) {
		new FindBiggestFile().start();
	}

	private void start() {
		Path base = Paths.get("D:\\Dropbox\\Shared\\IFC files");
		read(base);
		System.out.println(maxFile.toAbsolutePath().toString() + ": " + Formatters.bytesToString(max));
	}

	private void read(Path base) {
		try {
			if (Files.isDirectory(base)) {
				for (Path path : PathUtils.list(base)) {
					read(path);
				}
			} else {
				if (Files.size(base) > max) {
					max = Files.size(base);
					maxFile = base;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
