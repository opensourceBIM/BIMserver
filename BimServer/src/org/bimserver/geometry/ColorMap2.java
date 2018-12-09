package org.bimserver.geometry;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorMap2 {
	private static class A {

		private byte[] color;
		public int count = 4;

		public A(byte[] color) {
			this.color = color;
		}
	}
	
	private byte[] lastColor;
	private final List<A> list = new ArrayList<>();
	
	private A lastA;
	
	public void addColor(byte[] color) {
		if (lastColor == null || !Arrays.equals(lastColor, color)) {
			lastA = new A(color);
			list.add(lastA);
			lastColor = color;
		} else {
			lastA.count += 4;
		}
	}
	
	public byte[] toByteArray() {
		ByteBuffer buffer = ByteBuffer.allocate(list.size() * 8).order(ByteOrder.LITTLE_ENDIAN);
		for (A a : list) {
			byte[] color = a.color;
			int count = a.count;
			buffer.putInt(count);
			buffer.put(color);
		}
		return buffer.array();
	}
}
