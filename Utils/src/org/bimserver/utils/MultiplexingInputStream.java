package org.bimserver.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MultiplexingInputStream extends InputStream {

	private final OutputStream out;
	private final InputStream in;

	public MultiplexingInputStream(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}
	
	@Override
	public int read() throws IOException {
		int read = in.read();
		out.write(read);
		return read;
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int read = in.read(b, off, len);
		if (read != -1) {
			out.write(b, off, len);
		}
		return read;
	}
	
	@Override
	public void close() throws IOException {
		in.close();
		out.close();
		super.close();
	}
}