package org.bimserver.utils;

import java.io.IOException;
import java.io.OutputStream;

public class MultiplexingOutputStream extends OutputStream {

	private OutputStream a;
	private OutputStream b;

	public MultiplexingOutputStream(OutputStream a, OutputStream b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void write(int b) throws IOException {
		this.a.write(b);
		this.b.write(b);
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		this.a.write(b, off, len);
		this.b.write(b, off, len);
	}
	
	@Override
	public void close() throws IOException {
		a.close();
		b.close();
	}
	
	@Override
	public void flush() throws IOException {
		a.flush();
		b.flush();
	}
}