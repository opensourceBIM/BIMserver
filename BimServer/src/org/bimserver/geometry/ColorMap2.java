package org.bimserver.geometry;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class ColorMap2 {
	private static class A {

		private byte[] color = new byte[4];
		public int count = 4;

		public A(byte[] color) {
			System.arraycopy(color, 0, this.color, 0, color.length);
		}
	}
	
	private byte[] lastColor = new byte[4];
	private final List<A> list = new ArrayList<>();
	
	private A lastA;
	
	private boolean arrayEquals(byte[] a, byte[] a2) {
        int length = a.length;
        if (a2.length != length)
            return false;

        for (int i=0; i<length; i++)
            if (a[i] != a2[i])
                return false;
        
        return true;
	}
	
	public void addColor(byte[] color) {
		if (lastColor == null || !arrayEquals(lastColor, color)) {
			lastA = new A(color);
			list.add(lastA);
			System.arraycopy(color, 0, lastColor, 0, color.length);
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

	public int size() {
		return list.size();
	}
}
