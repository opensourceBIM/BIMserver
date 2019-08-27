package org.bimserver.webservices.impl;

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
	private OutputStream outputStream;
	private InputStream originalInputStream;

	public RestartableInputStream(InputStream originalInputStream, Path file) {
		this.originalInputStream = originalInputStream;
		this.cachingFile = file;
		try {
			outputStream = Files.newOutputStream(file);
			currentInputStream = new MultiplexingInputStream(originalInputStream, outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int read = currentInputStream.read(b, off, len);
		if (read == -1) {
			canRestart = true;
		}
		return read;
	}

	@Override
	public int read() throws IOException {
		int read = currentInputStream.read();
		if (read == -1) {
			canRestart = true;
		}
		return read;
	}

	@Override
	public void close() throws IOException {
		originalInputStream.close();
		outputStream.close();
		canRestart = true;
	}
	
	public void restartIfAtEnd() throws IOException {
		if (canRestart) {
			outputStream.close();
			LOGGER.info("Switching to reading from cached file");
			currentInputStream = Files.newInputStream(cachingFile);
			canRestart = false;
		}
	}
}
