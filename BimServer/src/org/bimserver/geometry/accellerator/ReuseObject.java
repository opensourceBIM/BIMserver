package org.bimserver.geometry.accellerator;

public class ReuseObject {
	private long geometryDataOid;
	private int reused;
	private int nrPrimitives;
	
	public ReuseObject(long geometryDataOid, int reused, int nrPrimitives) {
		this.geometryDataOid = geometryDataOid;
		this.reused = reused;
		this.nrPrimitives = nrPrimitives;
	}
	
	public int getNrPrimitives() {
		return nrPrimitives;
	}
	
	public int getReused() {
		return reused;
	}
	
	public long getGeometryDataOid() {
		return geometryDataOid;
	}

	public int getSaveablePrimitives() {
		return Math.max(0, (reused - 1) * nrPrimitives);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (geometryDataOid ^ (geometryDataOid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReuseObject other = (ReuseObject) obj;
		if (geometryDataOid != other.geometryDataOid)
			return false;
		return true;
	}

	public void inc() {
		reused++;
	}
}
