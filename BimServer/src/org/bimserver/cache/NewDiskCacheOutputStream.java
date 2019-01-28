package org.bimserver.cache;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.bimserver.plugins.serializers.RemovableFileOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewDiskCacheOutputStream extends RemovableFileOutputStream implements DiskCacheItem {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewDiskCacheOutputStream.class);
	private final NewDiskCacheManager diskCacheManager;
	private final Path file;
	private final Path tempFile;
	private final CountDownLatch latch = new CountDownLatch(1);
	private final DownloadDescriptor downloadDescriptor;

	public NewDiskCacheOutputStream(NewDiskCacheManager diskCacheManager, Path file, DownloadDescriptor downloadDescriptor) throws FileNotFoundException {
		super(file.getParent().resolve(file.getFileName().toString() + ".__tmp"));
		this.tempFile = file.getParent().resolve(file.getFileName().toString() + ".__tmp");
		this.diskCacheManager = diskCacheManager;
		this.file = file;
		this.downloadDescriptor = downloadDescriptor;
	}
	
	public DownloadDescriptor getDownloadDescriptor() {
		return downloadDescriptor;
	}
	
	public void waitForFinish() throws InterruptedException {
		latch.await(30, TimeUnit.MINUTES);
	}
	
	@Override
	public void close() throws IOException {
		super.close();
		LOGGER.info("Renaming temp file " + tempFile.getFileName().toString() + " to " + file.getFileName().toString());
		Files.move(tempFile, file);
		diskCacheManager.doneGenerating(this);
		latch.countDown();
	}
	
	@Override
	public void remove() throws IOException {
		super.remove();
		if (Files.exists(this.tempFile)) {
			Files.delete(this.tempFile);
		}
		diskCacheManager.remove(this);
		latch.countDown();
	}

	public String getName() {
		return file.getFileName().toString();
	}

	@Override
	public void cancel() throws IOException {
		super.close();
		remove();
	}
}