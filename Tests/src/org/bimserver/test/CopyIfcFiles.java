package org.bimserver.test;

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
