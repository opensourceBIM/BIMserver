package org.bimserver.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

public class InputStreamDataSource implements DataSource {

	private final InputStream realStream;
	private String name;

	public InputStreamDataSource(InputStream realStream) {
		this.realStream = realStream;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return realStream;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}
}