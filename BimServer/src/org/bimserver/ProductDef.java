package org.bimserver;

import org.bimserver.shared.HashMapVirtualObject;

public class ProductDef {

	private long oid;
	private HashMapVirtualObject object;
	private long masterOid;
	private double[] mappingMatrix;
	private double[] productMatrix;

	public ProductDef(long oid) {
		this.oid = oid;
	}

	public long getOid() {
		return oid;
	}

	public void setObject(HashMapVirtualObject object) {
		this.object = object;
	}
	
	public HashMapVirtualObject getObject() {
		return object;
	}

	public void setMasterOid(long masterOid) {
		this.masterOid = masterOid;
	}
	
	public long getMasterOid() {
		return masterOid;
	}

	public void setProductMatrix(double[] productMatrix) {
		this.productMatrix = productMatrix;
	}

	public void setMappingMatrix(double[] mappingMatrix) {
		this.mappingMatrix = mappingMatrix;
	}
	
	public double[] getProductMatrix() {
		return productMatrix;
	}
	
	public double[] getMappingMatrix() {
		return mappingMatrix;
	}
}
