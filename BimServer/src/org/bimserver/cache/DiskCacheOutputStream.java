package org.bimserver.cache;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.bimserver.longaction.DownloadParameters;
import org.bimserver.plugins.serializers.RemovableFileOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiskCacheOutputStream extends RemovableFileOutputStream {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiskCacheOutputStream.class);
	private DiskCacheManager diskCacheManager;
	private Path file;
	private Path tempFile;
	private final CountDownLatch latch = new CountDownLatch(1);
	private final DownloadParameters downloadParameters;

	public DiskCacheOutputStream(DiskCacheManager diskCacheManager, Path file, DownloadParameters downloadParameters) throws FileNotFoundException {
		super(file.getParent().resolve(file.getFileName().toString() + ".__tmp"));
		this.tempFile = file.getParent().resolve(file.getFileName().toString() + ".__tmp");
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
		LOGGER.info("Renaming temp file " + tempFile.getFileName().toString() + " to " + file.getFileName().toString());
		Files.move(tempFile, file);
		diskCacheManager.doneGenerating(this);
		latch.countDown();
	}
	
	@Override
	public void remove() throws IOException {
		super.remove();
		Files.delete(this.tempFile);
		diskCacheManager.remove(this);
		latch.countDown();
	}

	public String getName() {
		return file.getFileName().toString();
	}
}