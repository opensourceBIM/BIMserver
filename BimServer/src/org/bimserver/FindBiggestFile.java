package org.bimserver;

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
