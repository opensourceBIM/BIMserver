package org.bimserver.geometry;

public class SimpleMatrix {

	public static void multiplyMV(double[] output, double[] transformation, double[] inputVertex) {
		Matrix.multiplyMV(output, 0, transformation, 0, inputVertex, 0);
	}
}
