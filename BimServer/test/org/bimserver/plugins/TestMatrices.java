package org.bimserver.plugins;

import org.bimserver.geometry.Matrix;
import org.bimserver.geometry.SimpleMatrix;
import org.bimserver.geometry.Vector;

public class TestMatrices {
	public static void main(String[] args) {
		double[] transformation = Matrix.identity();
		Matrix.translateM(transformation, 0, 2000, 1000, 500);
		Matrix.rotateM(transformation, 0, 1, 100, 0, 0);
		Matrix.scaleM(transformation, 0, 100, 100, 100);
		Matrix.dump("Transformation: ", transformation);
		
		double[] inverseTransformation = Matrix.identity();
		
		Matrix.invertM(inverseTransformation, 0, transformation, 0);
		Matrix.dump("Inverse transformation", inverseTransformation);
		
		double[] inputVertex = new double[]{1, 1, 1, 1};
		double[] output = new double[4];
		SimpleMatrix.multiplyMV(output, transformation, inputVertex);
		Vector.dump("Input vertex", inputVertex);
		Vector.dump("Output vertex", output);
		double[] newOutput = new double[4];
		SimpleMatrix.multiplyMV(newOutput, inverseTransformation, output);
		Vector.dump("New output vertex", newOutput);
	}
}
