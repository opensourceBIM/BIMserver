package org.bimserver.utils;

import java.io.IOException;
import java.io.InputStream;

public class FakeClosingInputStream extends InputStream {

	private final InputStream delegateStream;

	public FakeClosingInputStream(InputStream delegateStream) {
		this.delegateStream = delegateStream;
	}

	@Override
	public int read() throws IOException {
		return delegateStream.read();
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		return delegateStream.read(b, off, len);
	}
	
	@Override
	public void close() throws IOException {
		// Do nothing
	}
}