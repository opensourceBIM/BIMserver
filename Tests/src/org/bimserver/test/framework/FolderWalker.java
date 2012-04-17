package org.bimserver.test.framework;

import java.io.File;

public class FolderWalker implements TestFileProvider {

	private int current = 0;
	private File[] listFiles;

	public FolderWalker(File folder) {
		listFiles = folder.listFiles();
	}

	@Override
	public synchronized File getNewFile() {
		if (current >= listFiles.length) {
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
