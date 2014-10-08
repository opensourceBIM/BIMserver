package org.bimserver.ifcengine.jvm;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConvertingInputStream extends InputStream {

	private DataInputStream in;
	private byte[] buffer = new byte[0];
	private int pos;
	private boolean end = false;

	public ConvertingInputStream(DataInputStream in) {
		this.in = in;
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		if (end) {
			int min = Math.min(buffer.length - pos, len);
			if (min == 0) {
				return -1;
			}
			System.arraycopy(buffer, pos, b, off, min);
			return min;
		}
		while (buffer.length - pos < len) {
			// We need to read some more data
			int size = in.readInt();
			if (size == -1) {
				// No more data, just return whatever we have left
				end = true;
				int min = Math.min(buffer.length - pos, len);
				System.arraycopy(buffer, pos, b, off, min);
				pos += min;
				return min;
			} else {
				byte[] tmp = buffer;
				buffer = new byte[buffer.length + size];
				System.arraycopy(tmp, 0, buffer, 0, tmp.length);
				in.readFully(buffer, tmp.length, size);
			}
		}
		// We have enough data
		System.arraycopy(buffer, pos, b, off, len);
		pos += len;
		return len;
	}
	
	@Override
	public int read() throws IOException {
		return 0;
	}
}