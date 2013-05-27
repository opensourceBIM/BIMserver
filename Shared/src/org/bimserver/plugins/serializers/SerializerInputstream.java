package org.bimserver.plugins.serializers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerializerInputstream extends InputStream {
	private static final Logger LOGGER = LoggerFactory.getLogger(SerializerInputstream.class);
	
	final ByteArrayOutputStream out = new ByteArrayOutputStream();
	int pos = 0;
	byte[] buffer;

	private EmfSerializer emfSerializer;

	public SerializerInputstream(EmfSerializer emfSerializer) {
		this.emfSerializer = emfSerializer;
	}
	
	public EmfSerializer getEmfSerializer() {
		return emfSerializer;
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int read = 0;
		if (buffer != null && pos < buffer.length) {
			int nrToCopy = Math.min(buffer.length - pos, len);
			System.arraycopy(buffer, pos, b, off, nrToCopy);
			pos += nrToCopy;
			read += nrToCopy;
		}
		while (read < len) {
			out.reset();
			buffer = null;
			pos = 0;
			try {
				boolean write = emfSerializer.write(out);
				if (write) {
					buffer = out.toByteArray();
					if (buffer.length > 0) {
						int nrToCopy = Math.min(buffer.length, len - read);
						System.arraycopy(buffer, pos, b, off + read, nrToCopy);
						pos += nrToCopy;
						read += nrToCopy;
					}
				} else {
					if (read != 0) {
						return read;
					} else {
						return -1;
					}
				}
			} catch (SerializerException e) {
				LOGGER.error("", e);
			}
		}
		return read;
	}

	@Override
	public int read() throws IOException {
		try {
			if (buffer != null && pos < buffer.length) {
				return buffer[pos++];
			} else {
				buffer = null;
				while (buffer == null) {
					out.reset();
					boolean write = emfSerializer.write(out);
					byte[] newBuffer = out.toByteArray();
					if (newBuffer.length > 0) {
						buffer = newBuffer;
						pos = 1;
						return buffer[0];
					}
					if (!write) {
						return -1;
					}
				}
			}
		} catch (SerializerException e) {
			LOGGER.error("", e);
		}
		return 0;
	}
}