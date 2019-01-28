package org.bimserver.utils;

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

import java.nio.ByteBuffer;

public class GrowingByteBuffer {
	private ByteBuffer byteBuffer;

	public GrowingByteBuffer(int initialCapacity) {
		byteBuffer = ByteBuffer.allocate(initialCapacity);
	}
	
	public int usedSize() {
		return byteBuffer.position();
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
			byteBuffer = ByteBuffer.allocate(Math.max(oldBuffer.position() * 2, byteBuffer.position() + nrExtraBytes));
			int oldPos = oldBuffer.position();
			oldBuffer.position(0);
			byteBuffer.put(oldBuffer.array(), 0, oldPos);
			byteBuffer.position(oldPos);
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

	public void put(byte[] b, int off, int len) {
		ensureExtraCapacity(len);
		byteBuffer.put(b, off, len);
	}

	public void putNoCheck(byte[] b, int off, int len) {
		byteBuffer.put(b, off, len);
	}

	public void putNoCheck(byte b) {
		byteBuffer.put(b);
	}
	
	public ByteBuffer getByteBuffer() {
		return byteBuffer;
	}
}