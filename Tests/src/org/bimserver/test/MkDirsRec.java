package org.bimserver.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MkDirsRec {
	public static void main(String[] args) {
		Path base = Paths.get("D:\\Dropbox\\Shared\\Organized IFC Files\\NUC - kvdeursen");
		try {
			DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(base);
			for (Path p : newDirectoryStream) {
				String filename = p.getFileName().toString();
				filename = filename.replaceAll(" \\_", "\\_");
				if (filename.endsWith(".ifc") || filename.endsWith(".ifczip")) {
					filename = filename.replaceAll("\\_", "\\\\");
					filename = filename.substring(0, filename.lastIndexOf("."));
					Path newPath = base.resolve(filename);
					Files.createDirectories(newPath);
					
					Files.move(p, newPath.resolve(p.getFileName().toString()));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
