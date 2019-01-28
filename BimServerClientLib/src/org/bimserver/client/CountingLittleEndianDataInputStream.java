package org.bimserver.client;

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

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.base.Charsets;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;

public final class CountingLittleEndianDataInputStream extends FilterInputStream implements DataInput {

	private int pos = 0;
	
	protected CountingLittleEndianDataInputStream(InputStream in) {
		super(in);
	}

	public void align8() throws IOException {
		int skip = 8 - (this.pos % 8);
		if(skip > 0 && skip != 8) {
			readFully(new byte[skip]);
		}
	}

	public void align4() throws IOException {
		int skip = 4 - (this.pos % 4);
		if(skip > 0 && skip != 4) {
			readFully(new byte[skip]);
		}
	}
	
	public int getPos() {
		return pos;
	}

	/**
	 * This method will throw an {@link UnsupportedOperationException}.
	 */
	@Override
	public String readLine() {
		throw new UnsupportedOperationException("readLine is not supported");
	}

	@Override
	public void readFully(byte[] b) throws IOException {
		ByteStreams.readFully(this, b);
		pos += b.length;
	}

	@Override
	public void readFully(byte[] b, int off, int len) throws IOException {
		ByteStreams.readFully(this, b, off, len);
		pos += len;
	}

	@Override
	public int skipBytes(int n) throws IOException {
		int skip = (int) in.skip(n);
		pos += skip;
		return skip;
	}

	@Override
	public int readUnsignedByte() throws IOException {
		int b1 = in.read();
		if (0 > b1) {
			throw new EOFException();
		}

		pos += 1;
		return b1;
	}

	/**
	 * Reads an unsigned {@code short} as specified by
	 * {@link DataInputStream#readUnsignedShort()}, except using little-endian
	 * byte order.
	 *
	 * @return the next two bytes of the input stream, interpreted as an
	 *         unsigned 16-bit integer in little-endian byte order
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	public int readUnsignedShort() throws IOException {
		byte b1 = readAndCheckByte();
		byte b2 = readAndCheckByte();

		return Ints.fromBytes((byte) 0, (byte) 0, b2, b1);
	}

	/**
	 * Reads an integer as specified by {@link DataInputStream#readInt()},
	 * except using little-endian byte order.
	 *
	 * @return the next four bytes of the input stream, interpreted as an
	 *         {@code int} in little-endian byte order
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	public int readInt() throws IOException {
		byte b1 = readAndCheckByte();
		byte b2 = readAndCheckByte();
		byte b3 = readAndCheckByte();
		byte b4 = readAndCheckByte();

		return Ints.fromBytes(b4, b3, b2, b1);
	}

	/**
	 * Reads a {@code long} as specified by {@link DataInputStream#readLong()},
	 * except using little-endian byte order.
	 *
	 * @return the next eight bytes of the input stream, interpreted as a
	 *         {@code long} in little-endian byte order
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	public long readLong() throws IOException {
		byte b1 = readAndCheckByte();
		byte b2 = readAndCheckByte();
		byte b3 = readAndCheckByte();
		byte b4 = readAndCheckByte();
		byte b5 = readAndCheckByte();
		byte b6 = readAndCheckByte();
		byte b7 = readAndCheckByte();
		byte b8 = readAndCheckByte();

		return Longs.fromBytes(b8, b7, b6, b5, b4, b3, b2, b1);
	}

	/**
	 * Reads a {@code float} as specified by
	 * {@link DataInputStream#readFloat()}, except using little-endian byte
	 * order.
	 *
	 * @return the next four bytes of the input stream, interpreted as a
	 *         {@code float} in little-endian byte order
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	public float readFloat() throws IOException {
		return Float.intBitsToFloat(readInt());
	}

	/**
	 * Reads a {@code double} as specified by
	 * {@link DataInputStream#readDouble()}, except using little-endian byte
	 * order.
	 *
	 * @return the next eight bytes of the input stream, interpreted as a
	 *         {@code double} in little-endian byte order
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	public double readDouble() throws IOException {
		return Double.longBitsToDouble(readLong());
	}

	@Override
	public String readUTF() throws IOException {
		String readUTF = new DataInputStream(in).readUTF();
		pos += 2 + readUTF.getBytes(Charsets.UTF_8).length;
		return readUTF;
	}

	/**
	 * Reads a {@code short} as specified by
	 * {@link DataInputStream#readShort()}, except using little-endian byte
	 * order.
	 *
	 * @return the next two bytes of the input stream, interpreted as a
	 *         {@code short} in little-endian byte order.
	 * @throws IOException
	 *             if an I/O error occurs.
	 */
	@Override
	public short readShort() throws IOException {
		return (short) readUnsignedShort();
	}

	/**
	 * Reads a char as specified by {@link DataInputStream#readChar()}, except
	 * using little-endian byte order.
	 *
	 * @return the next two bytes of the input stream, interpreted as a
	 *         {@code char} in little-endian byte order
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	public char readChar() throws IOException {
		return (char) readUnsignedShort();
	}

	@Override
	public byte readByte() throws IOException {
		return (byte) readUnsignedByte();
	}

	@Override
	public boolean readBoolean() throws IOException {
		return readUnsignedByte() != 0;
	}

	/**
	 * Reads a byte from the input stream checking that the end of file (EOF)
	 * has not been encountered.
	 * 
	 * @return byte read from input
	 * @throws IOException
	 *             if an error is encountered while reading
	 * @throws EOFException
	 *             if the end of file (EOF) is encountered.
	 */
	private byte readAndCheckByte() throws IOException, EOFException {
		int b1 = in.read();
		pos++;

		if (-1 == b1) {
			throw new EOFException();
		}

		return (byte) b1;
	}
}