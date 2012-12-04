package org.bimserver.cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DiskCacheOutputStream extends FileOutputStream {

	private DiskCacheManager diskCacheManager;
	private File file;
	private final CountDownLatch latch = new CountDownLatch(1);

	public DiskCacheOutputStream(DiskCacheManager diskCacheManager, File file) throws FileNotFoundException {
		super(file);
		this.diskCacheManager = diskCacheManager;
		this.file = file;
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

	public String getName() {
		return file.getName();
	}
}