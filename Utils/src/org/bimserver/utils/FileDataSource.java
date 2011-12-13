package org.bimserver.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

public class FileDataSource implements DataSource {

	private final File file;

	public FileDataSource(File file) {
		this.file = file;
	}
	
	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(file);
	}

	@Override
	public String getName() {
		return file.getName();
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}
}