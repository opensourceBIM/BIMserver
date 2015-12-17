package org.bimserver.cache;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.bimserver.plugins.serializers.RemovableFileOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewDiskCacheOutputStream extends RemovableFileOutputStream {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewDiskCacheOutputStream.class);
	private NewDiskCacheManager diskCacheManager;
	private Path file;
	private Path tempFile;
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
}