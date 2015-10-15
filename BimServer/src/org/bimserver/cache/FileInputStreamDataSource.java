package org.bimserver.cache;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.activation.DataSource;

public class FileInputStreamDataSource implements DataSource {

	private final Path file;
	private String name;
	private InputStream inputStream;
	
	public FileInputStreamDataSource(Path file) {
		this.file = file;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		if (inputStream != null) {
			inputStream.close();
		}
		inputStream = Files.newInputStream(file);
		return inputStream;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long size() {
		try {
			return Files.size(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
}