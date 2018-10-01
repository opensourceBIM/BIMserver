package org.bimserver.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RemoveEmpty {
	public static void main(String[] args) {
		new RemoveEmpty().start();
	}

	private void start() {
		Path base = Paths.get("C:\\Users\\Ruben de Laat\\Downloads\\debug");
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
