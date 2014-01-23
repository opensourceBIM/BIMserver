package org.bimserver.test.framework;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FolderWalker implements TestFileProvider {

	private static final Logger LOGGER = LoggerFactory.getLogger(FolderWalker.class);
	private volatile int current = 0;
	private final File[] listFiles;
	private final TestFramework testFramework;
	private int lastPerc;

	public FolderWalker(File folder, TestFramework testFramework) {
		this.testFramework = testFramework;
		this.listFiles = folder.listFiles();
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
		int percentage = current / listFiles.length;
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
