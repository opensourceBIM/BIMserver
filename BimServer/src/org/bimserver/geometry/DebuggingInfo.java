package org.bimserver.geometry;

public class DebuggingInfo {

	private double[] productTranformationMatrix;
	private float[] vertices;
	private int[] indices;

	public DebuggingInfo(double[] productTranformationMatrix, int[] indices, float[] vertices) {
		this.productTranformationMatrix = productTranformationMatrix;
		this.indices = indices;
		this.vertices = vertices;
	}

	public float[] getVertices() {
		return vertices;
	}
	
	public int[] getIndices() {
		return indices;
	}
	
	public double[] getProductTranformationMatrix() {
		return productTranformationMatrix;
	}
}