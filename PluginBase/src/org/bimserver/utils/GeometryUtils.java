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
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class GeometryUtils {
	public static float[] toFloatArray(byte[] data) {
		ByteBuffer buffer = ByteBuffer.wrap(data);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		FloatBuffer floatBuffer = buffer.asFloatBuffer();
		float[] result = new float[data.length / 4];
		for (int i=0; i<data.length / 4; i++) {
			result[i] = floatBuffer.get();
		}
		return result;
	}

	public static int[] toIntegerArray(byte[] data) {
		ByteBuffer buffer = ByteBuffer.wrap(data);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		IntBuffer intBuffer = buffer.asIntBuffer();
		int[] result = new int[data.length / 4];
		for (int i=0; i<data.length / 4; i++) {
			result[i] = intBuffer.get();
		}
		return result;
	}

	public static float[] toFloatArray(double[] doubles) {
		float[] result = new float[doubles.length];
		for (int i=0; i<doubles.length; i++) {
			result[i] = (float) doubles[i];
		}
		return result;
	}
	
	public static double[] toDoubleArray(byte[] data) {
		ByteBuffer buffer = ByteBuffer.wrap(data);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		DoubleBuffer doubleBuffer = buffer.asDoubleBuffer();
		double[] result = new double[data.length / 8];
		for (int i=0; i<data.length / 8; i++) {
			result[i] = doubleBuffer.get();
		}
		return result;
	}
	
	public static byte[] floatArrayToByteArray(float[] vertices) {
		if (vertices == null) {
			return null;
		}
		ByteBuffer buffer = ByteBuffer.wrap(new byte[vertices.length * 4]);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		FloatBuffer asFloatBuffer = buffer.asFloatBuffer();
		for (float f : vertices) {
			asFloatBuffer.put(f);
		}
		return buffer.array();
	}

	public static byte[] doubleArrayToByteArray(double[] vertices) {
		if (vertices == null) {
			return null;
		}
		ByteBuffer buffer = ByteBuffer.wrap(new byte[vertices.length * 4]);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		DoubleBuffer asDoubleBuffer = buffer.asDoubleBuffer();
		for (double d : vertices) {
			asDoubleBuffer.put(d);
		}
		return buffer.array();
	}

	public static byte[] intArrayToByteArray(int[] indices) {
		if (indices == null) {
			return null;
		}
		ByteBuffer buffer = ByteBuffer.wrap(new byte[indices.length * 4]);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		IntBuffer asIntBuffer = buffer.asIntBuffer();
		for (int i : indices) {
			asIntBuffer.put(i);
		}
		return buffer.array();
	}
}