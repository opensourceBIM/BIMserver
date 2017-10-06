package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.google.common.primitives.Longs;

public class LittleEndianSerializerDataOutputStream extends SerializerDataOutputStream {
	
	private OutputStream outputStream;

	public LittleEndianSerializerDataOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	
	public LittleEndianSerializerDataOutputStream() {
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		outputStream.write(b, off, len);
	}

	/**
	 * Writes a {@code double} as specified by
	 * {@link DataOutputStream#writeDouble(double)}, except using little-endian
	 * byte order.
	 *
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	public void writeDouble(double v) throws IOException {
		writeLong(Double.doubleToLongBits(v));
	}

	/**
	 * Writes a {@code float} as specified by
	 * {@link DataOutputStream#writeFloat(float)}, except using little-endian
	 * byte order.
	 *
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	public void writeFloat(float v) throws IOException {
		writeInt(Float.floatToIntBits(v));
	}

	/**
	 * Writes an {@code int} as specified by
	 * {@link DataOutputStream#writeInt(int)}, except using little-endian byte
	 * order.
	 *
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	public void writeInt(int v) throws IOException {
		outputStream.write(0xFF & v);
		outputStream.write(0xFF & (v >> 8));
		outputStream.write(0xFF & (v >> 16));
		outputStream.write(0xFF & (v >> 24));
	}

	/**
	 * Writes a {@code long} as specified by
	 * {@link DataOutputStream#writeLong(long)}, except using little-endian byte
	 * order.
	 *
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	public void writeLong(long v) throws IOException {
		byte[] bytes = Longs.toByteArray(Long.reverseBytes(v));
		write(bytes, 0, bytes.length);
	}

	/**
	 * Writes a {@code short} as specified by
	 * {@link DataOutputStream#writeShort(int)}, except using little-endian byte
	 * order.
	 *
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	public void writeShort(short v) throws IOException {
		outputStream.write(0xFF & v);
		outputStream.write(0xFF & (v >> 8));
	}

	@Override
	public void writeUTF(String str) throws IOException {
		new DataOutputStream(outputStream).writeUTF(str);
	}

	@Override
	public void write(int b) throws IOException {
		outputStream.write(b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		outputStream.write(b);
	}

	public void reset() {
	}

	@Override
	public void writeByte(byte val) throws IOException {
		outputStream.write((byte)val);
	}
}
