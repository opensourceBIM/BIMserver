package org.bimserver.servlets;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;
import org.slf4j.LoggerFactory;

public class TriggerOnCloseInputStream extends InputStream {
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TriggerOnCloseInputStream.class);
	private int id;
	private static AtomicInteger COUNTER = new AtomicInteger();
	private final CountDownLatch latch = new CountDownLatch(1);
	private InputStream inputStream;

	public TriggerOnCloseInputStream(InputStream inputStream) {
		this.id = COUNTER.incrementAndGet();
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
		if (latch.getCount() == 0) {
			throw new IOException("Stream closed " + id);
		}
		int read = inputStream.read(b, off, len);
		return read;
	}
	
	@Override
	public void close() throws IOException {
//		LOGGER.error("Closing " + id, new Exception());

		// Read the rest of the inputstream
		try {
			IOUtils.copy(inputStream, new NullOutputStream());
		} catch (EOFException e) {
			// Skip, not a problem
		}
		latch.countDown();
		inputStream.close();
	}
	
	public void await() throws InterruptedException {
		latch.await();
	}
}
