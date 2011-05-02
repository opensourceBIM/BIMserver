package org.bimserver.utils;

import java.nio.ByteBuffer;

public class GrowingByteBuffer {
	private ByteBuffer byteBuffer;

	public GrowingByteBuffer(int initialCapacity) {
		byteBuffer = ByteBuffer.allocate(initialCapacity);
	}
	
	public GrowingByteBuffer(ByteBuffer buffer) {
		byteBuffer = ByteBuffer.wrap(buffer.array());
		buffer.position(0);
	}
	
	public void put(ByteBuffer buffer) {
		ensureExtraCapacity(buffer.limit());
		byteBuffer.put(buffer);
	}

	public void putInt(int value) {
		ensureExtraCapacity(4);
		byteBuffer.putInt(value);
	}

	public void ensureExtraCapacity(int nrExtraBytes) {
		if (byteBuffer.capacity() <= byteBuffer.position() + nrExtraBytes) {
			ByteBuffer oldBuffer = byteBuffer;
			byteBuffer = ByteBuffer.allocate(oldBuffer.position() + 1 + nrExtraBytes);
			int oldPos = oldBuffer.position();
			oldBuffer.position(0);
			byteBuffer.put(oldBuffer.array(), 0, oldPos);
		}
	}

	public int position() {
		return byteBuffer.position();
	}

	public void putDouble(Double value) {
		ensureExtraCapacity(8);
		byteBuffer.putDouble(value);
	}

	public void putFloat(Float value) {
		ensureExtraCapacity(4);
		byteBuffer.putFloat(value);
	}

	public void putLong(Long value) {
		ensureExtraCapacity(8);
		byteBuffer.putLong(value);
	}

	public void put(byte[] bs) {
		ensureExtraCapacity(bs.length);
		byteBuffer.put(bs);
	}

	public void put(byte b) {
		ensureExtraCapacity(1);
		byteBuffer.put(b);
	}

	public void putShort(short value) {
		ensureExtraCapacity(2);
		byteBuffer.putShort(value);
	}

	public byte[] array() {
		return byteBuffer.array();
	}

	public int capacity() {
		return byteBuffer.capacity();
	}

	public void position(int i) {
		byteBuffer.position(i);
	}
}