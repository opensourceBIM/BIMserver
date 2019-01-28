package org.bimserver.longaction;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.bimserver.plugins.serializers.MessagingStreamingSerializer;
import org.bimserver.plugins.serializers.SerializerException;

public class MessagingSerializerInputstream extends InputStream {
	// TODO remove use of BAOS, does copying
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private int pos = 0;
	private byte[] buffer;
	private MessagingStreamingSerializer messagingStreamingSerializer;

	public MessagingSerializerInputstream(MessagingStreamingSerializer messagingStreamingSerializer) {
		this.messagingStreamingSerializer = messagingStreamingSerializer;
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		try {
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
				boolean write = messagingStreamingSerializer.writeMessage(out, null);
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
			}
			return read;
		} catch (SerializerException e) {
			throw new IOException(e);
		}
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
					boolean write = messagingStreamingSerializer.writeMessage(out, null);
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
			return 0;
		} catch (SerializerException e) {
			throw new IOException(e);
		}
	}
}