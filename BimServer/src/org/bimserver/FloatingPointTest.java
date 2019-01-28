package org.bimserver;

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
import java.util.Map;
import java.util.TreeMap;

public class FloatingPointTest {
	
	public static class ByteArray implements Comparable<ByteArray> {

		private float f;
		private byte[] bytes;

		public ByteArray(float f) {
			this.f = f;
			ByteBuffer buffer = ByteBuffer.allocate(4);
			buffer.putFloat(f);
			bytes = buffer.array();
		}
		
		@Override
		public String toString() {
			return "" + f;
		}

		@Override
		public int compareTo(ByteArray o) {
			for (byte i=0; i<32; i++) {
				byte a = o.bytes[i / 8];
				byte b = bytes[i / 8];
				int x = a & (i % 8);
				int y = b & (i % 8);
				if (x > y) {
					return 1;
				} else if (x < y) {
					return -1;
				}
			}
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Map<ByteArray, Float> floats = new TreeMap<>();

		floats.put(new ByteArray(1000000.5f), 1000000.5f);
		floats.put(new ByteArray(0.5f), 0.5f);
		floats.put(new ByteArray(1.5f), 1.5f);
		floats.put(new ByteArray(0.000005f), 0.000005f);
		floats.put(new ByteArray(0.005f), 0.005f);
		
		for (ByteArray f : floats.keySet()) {
			System.out.println(f);
		}
	}
}
