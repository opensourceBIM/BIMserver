package org.bimserver.servlets;

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

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.bimserver.plugins.LittleEndianSerializerDataOutputStream;
import org.bimserver.utils.GrowingByteBuffer;

import com.google.common.base.Charsets;
import com.google.common.primitives.Longs;

public class ReusableLittleEndianDataOutputStream extends LittleEndianSerializerDataOutputStream {

	private final GrowingByteBuffer growingByteBuffer = new GrowingByteBuffer(1024 * 1024);
	private final DataOutputStream dataOutputStream;

	public ReusableLittleEndianDataOutputStream() {
		dataOutputStream = new DataOutputStream(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				growingByteBuffer.putNoCheck((byte) b);
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				growingByteBuffer.putNoCheck(b, off, len);
			}
		});
	}
	
	public GrowingByteBuffer getGrowingByteBuffer() {
		return growingByteBuffer;
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		growingByteBuffer.ensureExtraCapacity(len);
		dataOutputStream.write(b, off, len);
	}

	public int pos() {
		return growingByteBuffer.position();
	}
	
	@Override
	public void align4() throws IOException {
		int extra = 4 - (growingByteBuffer.position() % 4);
		if (extra > 0 && extra != 4) {
			growingByteBuffer.ensureExtraCapacity(extra);
			dataOutputStream.write(new byte[extra]);
		}
	}
	
	@Override
	public void align8() throws IOException {
		int extra = 8 - (growingByteBuffer.position() % 8);
		if (extra > 0 && extra != 8) {
			growingByteBuffer.ensureExtraCapacity(extra);
			dataOutputStream.write(new byte[extra]);
		}
	}
	
	@Override
	public void writeUnchecked(byte[] b, int off, int len) throws IOException {
		dataOutputStream.write(b, off, len);
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
		growingByteBuffer.ensureExtraCapacity(4);
		dataOutputStream.write(0xFF & v);
		dataOutputStream.write(0xFF & (v >> 8));
		dataOutputStream.write(0xFF & (v >> 16));
		dataOutputStream.write(0xFF & (v >> 24));
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
		growingByteBuffer.ensureExtraCapacity(2);
		dataOutputStream.write(0xFF & v);
		dataOutputStream.write(0xFF & (v >> 8));
	}

	@Override
	public void writeUTF(String str) throws IOException {
		growingByteBuffer.ensureExtraCapacity(2 + str.getBytes(Charsets.UTF_8).length);
		dataOutputStream.writeUTF(str);
	}

	@Override
	public void write(int b) throws IOException {
		growingByteBuffer.ensureExtraCapacity(1);
		dataOutputStream.write(b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		growingByteBuffer.ensureExtraCapacity(b.length);
		dataOutputStream.write(b);
	}

	public void reset() {
		growingByteBuffer.position(0);
	}

	@Override
	public void writeByte(byte val) throws IOException {
		growingByteBuffer.ensureExtraCapacity(1);
		dataOutputStream.write((byte)val);
	}

	@Override
	public void writeByte(int val) throws IOException {
		growingByteBuffer.ensureExtraCapacity(1);
		dataOutputStream.writeByte(val);
	}

	@Override
	public void writeByteUnchecked(int val) throws IOException {
		growingByteBuffer.ensureExtraCapacity(1);
		dataOutputStream.writeByte(val);
	}
	
	@Override
	public void ensureExtraCapacity(int length) {
		growingByteBuffer.ensureExtraCapacity(length);
	}
	
	@Override
	public void writeDoubleUnchecked(double value) throws IOException {
		writeLongUnchecked(Double.doubleToLongBits(value));
	}
	
	@Override
	public void writeFloatUnchecked(float v) throws IOException {
		writeIntUnchecked(Float.floatToIntBits(v));
	}
	
	@Override
	public void writeIntUnchecked(int v) throws IOException {
		dataOutputStream.write(0xFF & v);
		dataOutputStream.write(0xFF & (v >> 8));
		dataOutputStream.write(0xFF & (v >> 16));
		dataOutputStream.write(0xFF & (v >> 24));
	}
	
	@Override
	public void writeLongUnchecked(long value) throws IOException {
		byte[] bytes = Longs.toByteArray(Long.reverseBytes(value));
		dataOutputStream.write(bytes, 0, bytes.length);
	}
	
	@Override
	public void writeShortUnchecked(short v) throws IOException {
		dataOutputStream.write(0xFF & v);
		dataOutputStream.write(0xFF & (v >> 8));
	}
}