package org.bimserver;

import org.bimserver.shared.HashMapVirtualObject;

public class ProductDef {

	private long oid;
	private double[] matrix;
	private HashMapVirtualObject object;
	private long masterOid;

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
}
