package org.bimserver;

public class ProductDef {

	private long oid;
	private double[] matrix;

	public ProductDef(long oid) {
		this.oid = oid;
	}

	public void setMatrix(double[] matrix) {
		this.matrix = matrix;
	}
	
	public double[] getMatrix() {
		return matrix;
	}

	public long getOid() {
		return oid;
	}
}
