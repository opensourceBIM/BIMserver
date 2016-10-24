package org.bimserver.servlets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.bimserver.plugins.LittleEndianSerializerDataOutputStream;
import org.bimserver.utils.GrowingByteBuffer;

import com.google.common.base.Charsets;
import com.google.common.primitives.Longs;

public class ReusableLittleEndianDataOutputStream extends LittleEndianSerializerDataOutputStream {

	GrowingByteBuffer growingByteBuffer = new GrowingByteBuffer(100000);
	private DataOutputStream dataOutputStream;

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
		growingByteBuffer.ensureExtraCapacity(8);
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
		growingByteBuffer.ensureExtraCapacity(4);
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
		growingByteBuffer.ensureExtraCapacity(8);
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
}
