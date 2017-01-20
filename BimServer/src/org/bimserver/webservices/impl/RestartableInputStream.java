package org.bimserver.webservices.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.bimserver.utils.MultiplexingInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestartableInputStream extends InputStream {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestartableInputStream.class);
	private Path cachingFile;
	private InputStream currentInputStream;
	private volatile boolean canRestart = false;

	public RestartableInputStream(InputStream originalInputStream, Path file) {
		this.cachingFile = file;
		try {
			OutputStream outputStream = Files.newOutputStream(file);
			currentInputStream = new MultiplexingInputStream(originalInputStream, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		if (canRestart) {
			LOGGER.info("Switching to reading from cached file");
			currentInputStream = Files.newInputStream(cachingFile);
			canRestart = false;
		}
		int read = currentInputStream.read(b, off, len);
		if (read == -1) {
			canRestart = true;
		}
		return read;
	}

	@Override
	public int read() throws IOException {
		if (canRestart) {
			LOGGER.info("Switching to reading from cached file");
			currentInputStream = Files.newInputStream(cachingFile);
			canRestart = false;
		}
		int read = currentInputStream.read();
		if (read == -1) {
			canRestart = true;
		}
		return read;
	}
}
