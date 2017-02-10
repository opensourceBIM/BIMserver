package org.bimserver.plugins;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.google.common.base.Charsets;
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
