package org.bimserver.servlets;

import java.io.IOException;
import java.io.OutputStream;

import org.bimserver.utils.GrowingByteBuffer;

public class ReusableByteArrayOutputStream extends OutputStream {

	private final GrowingByteBuffer buffer = new GrowingByteBuffer(262144);
	
	@Override
	public void write(int b) throws IOException {
		buffer.put((byte)b);
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		buffer.put(b, off, len);
	}

	public int usedSize() {
		return buffer.position();
	}

	public byte[] getByteArray() {
		return buffer.array();
	}
	
	public void reset() {
		buffer.position(0);
	}

	public void setPosition(int pos) {
		buffer.position(pos);
	}
}
