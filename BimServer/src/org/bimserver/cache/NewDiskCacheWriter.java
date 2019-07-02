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

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.bimserver.plugins.serializers.MessagingStreamingSerializer;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewDiskCacheWriter implements Writer, DiskCacheItem, Closeable {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewDiskCacheWriter.class);
	private NewDiskCacheManager newDiskCacheManager;
	private Path file;
	private DownloadDescriptor downloadDescriptor;
	private DataOutputStream outputStream;
	private MessagingStreamingSerializer messagingStreamingSerializer;
	private final CountDownLatch latch = new CountDownLatch(1);
	private Path tempFile;
	
	public NewDiskCacheWriter(NewDiskCacheManager newDiskCacheManager, Path file, DownloadDescriptor downloadDescriptor, MessagingStreamingSerializer messagingStreamingSerializer) throws FileNotFoundException {
		this.newDiskCacheManager = newDiskCacheManager;
		this.file = file;
		this.downloadDescriptor = downloadDescriptor;
		this.tempFile = file.getParent().resolve(file.getFileName().toString() + ".__tmp");
		this.messagingStreamingSerializer = messagingStreamingSerializer;
		try {
			this.outputStream = new DataOutputStream(Files.newOutputStream(tempFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean writeMessage(OutputStream outputStream, ProgressReporter progressReporter) throws IOException, SerializerException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		boolean result = messagingStreamingSerializer.writeMessage(baos, progressReporter);
		this.outputStream.writeInt(baos.size());
		this.outputStream.write(baos.toByteArray());
		outputStream.write(baos.toByteArray());
		return result;
	}

	@Override
	public void close() throws IOException {
//		LOGGER.info("Renaming temp file " + tempFile.getFileName().toString() + " to " + file.getFileName().toString());
		outputStream.writeInt(-1);
		outputStream.close();
		if (Files.exists(tempFile)) {
			Files.move(tempFile, file);
		}
		newDiskCacheManager.doneGenerating(this);
		latch.countDown();
	}

	@Override
	public void waitForFinish() throws InterruptedException {
		latch.await(30, TimeUnit.MINUTES);
	}

	@Override
	public DownloadDescriptor getDownloadDescriptor() {
		return downloadDescriptor;
	}
}
