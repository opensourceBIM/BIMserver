package org.bimserver.test.framework;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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
