package org.bimserver.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

public class FileInputStreamDataSource implements DataSource {

	private final File file;
	private FileInputStream fileInputStream;
	private String name;
	
	public FileInputStreamDataSource(File file) {
		this.file = file;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		if (fileInputStream != null) {
			fileInputStream.close();
		}
		fileInputStream = new FileInputStream(file);
		return fileInputStream;
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
}