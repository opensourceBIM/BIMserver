package org.bimserver.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;

public class TriggerOnCloseInputStream extends InputStream {

	private final CountDownLatch latch = new CountDownLatch(1);
	private InputStream inputStream;

	public TriggerOnCloseInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	@Override
	public int read() throws IOException {
		int read = inputStream.read();
		if (read == -1) {
			latch.countDown();
		}
		return read;
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int read = inputStream.read(b, off, len);
		if (read == -1) {
			latch.countDown();
		}
		return read;
	}
	
	@Override
	public void close() throws IOException {
		latch.countDown();
		inputStream.close();
	}
	
	public void await() throws InterruptedException {
		latch.await();
	}
}
