package org.bimserver.geometry;

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
	
	private byte[] lastColor;
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
			if (lastColor == null) {
				lastColor = new byte[4];
			}
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
