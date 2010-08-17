package org.bimserver.utils;

import java.nio.ByteBuffer;

public class GrowingByteBuffer {
	private ByteBuffer byteBuffer = ByteBuffer.allocate(0);

	public void putInt(int value) {
		ensureCapacity(4);
		byteBuffer.putInt(value);
	}

	private void ensureCapacity(int nrExtraBytes) {
		if (byteBuffer.capacity() < byteBuffer.position() + nrExtraBytes) {
			ByteBuffer oldBuffer = byteBuffer;
			byteBuffer = ByteBuffer.allocate(byteBuffer.position() + nrExtraBytes);
			oldBuffer.position(0);
			byteBuffer.put(oldBuffer);
		}
	}

	public int position() {
		return byteBuffer.position();
	}

	public void putDouble(Double value) {
		ensureCapacity(8);
		byteBuffer.putDouble(value);
	}

	public void putFloat(Float value) {
		ensureCapacity(4);
		byteBuffer.putFloat(value);
	}

	public void putLong(Long value) {
		ensureCapacity(8);
		byteBuffer.putLong(value);
	}

	public void put(byte[] bs) {
		ensureCapacity(bs.length);
		byteBuffer.put(bs);
	}

	public void put(byte b) {
		ensureCapacity(1);
		byteBuffer.put(b);
	}

	public void putShort(short value) {
		ensureCapacity(2);
		byteBuffer.putShort(value);
	}

	public byte[] array() {
		return byteBuffer.array();
	}
}