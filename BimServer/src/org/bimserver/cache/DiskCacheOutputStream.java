package org.bimserver.cache;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.bimserver.longaction.DownloadParameters;
import org.bimserver.plugins.serializers.RemovableFileOutputStream;

public class DiskCacheOutputStream extends RemovableFileOutputStream {

	private DiskCacheManager diskCacheManager;
	private File file;
	private final CountDownLatch latch = new CountDownLatch(1);
	private DownloadParameters downloadParameters;

	public DiskCacheOutputStream(DiskCacheManager diskCacheManager, File file, DownloadParameters downloadParameters) throws FileNotFoundException {
		super(file);
		this.diskCacheManager = diskCacheManager;
		this.file = file;
		this.downloadParameters = downloadParameters;
	}
	
	public DownloadParameters getDownloadParameters() {
		return downloadParameters;
	}
	
	public void waitForFinish() throws InterruptedException {
		latch.await(30, TimeUnit.MINUTES);
	}
	
	@Override
	public void close() throws IOException {
		super.close();
		diskCacheManager.doneGenerating(this);
		latch.countDown();
	}
	
	@Override
	public void remove() {
		super.remove();
		diskCacheManager.remove(this);
	}

	public String getName() {
		return file.getName();
	}
}