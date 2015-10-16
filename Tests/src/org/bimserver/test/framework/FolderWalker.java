package org.bimserver.test.framework;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.bimserver.utils.PathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FolderWalker implements TestFileProvider {

	private static final Logger LOGGER = LoggerFactory.getLogger(FolderWalker.class);
	private volatile int current = 0;
	private List<Path> listFiles;
	private final TestFramework testFramework;
	private int lastPerc;

	public FolderWalker(Path folder, TestFramework testFramework) {
		this.testFramework = testFramework;
		try {
			this.listFiles = PathUtils.list(folder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized Path getNewFile() {
		if (current >= listFiles.size()) {
			testFramework.stop();
			return null;
		}
		Path next = listFiles.get(current++);
//		if (!next.isFile()) {
//			return getNewFile();
//		}
		int percentage = current / listFiles.size();
		if (percentage > lastPerc) {
			LOGGER.info("");
			LOGGER.info("");
			LOGGER.info(percentage + "%");
			LOGGER.info("");
			LOGGER.info("");
			lastPerc = percentage;
		}
		return next;
	}
}
