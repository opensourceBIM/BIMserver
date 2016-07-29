package org.bimserver.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

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
}
