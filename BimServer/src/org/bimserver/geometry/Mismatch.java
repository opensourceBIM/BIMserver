package org.bimserver.geometry;

public class Mismatch {

	private float[] transformedNew;
	private double[] productTranformationMatrix;
	private double[] totalTranformationMatrix;
	private float[] transformedOriginal;

	public Mismatch(float[] transformedOriginal, float[] transformedNew, double[] productTranformationMatrix, double[] totalTranformationMatrix) {
		this.transformedOriginal = transformedOriginal;
		this.transformedNew = transformedNew;
		this.productTranformationMatrix = productTranformationMatrix;
		this.totalTranformationMatrix = totalTranformationMatrix;
	}
}
