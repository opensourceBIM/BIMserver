package org.bimserver.test.framework;

import java.io.File;

public class FolderWalker implements TestFileProvider {

	private int current = 0;
	private File[] listFiles;
	private final TestFramework testFramework;

	public FolderWalker(File folder, TestFramework testFramework) {
		this.testFramework = testFramework;
		listFiles = folder.listFiles();
	}

	@Override
	public synchronized File getNewFile() {
		if (current >= listFiles.length) {
			testFramework.stop();
			return null;
		}
		File next = listFiles[current++];
		if (next.getName().contains(".svn")) {
			return getNewFile();
		}
		if (!next.isFile()) {
			return getNewFile();
		}
		return next;
	}
}
