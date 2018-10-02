package org.bimserver.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MkDirs {
	public static void main(String[] args) {
		Path base = Paths.get("D:\\Dropbox\\Shared\\Organized IFC Files\\Pontsteiger Full\\Rest");
		try {
			DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(base);
			for (Path p : newDirectoryStream) {
				String filename = p.getFileName().toString();
				
				Path dir = p.getParent().resolve(filename.substring(0, filename.length() - 4));
				Files.createDirectories(dir);
				Files.move(p, dir.resolve(filename));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
