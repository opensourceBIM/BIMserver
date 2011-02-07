package org.bimserver.utils;

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