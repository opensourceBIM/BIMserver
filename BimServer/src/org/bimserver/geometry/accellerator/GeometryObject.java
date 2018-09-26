package org.bimserver.geometry.accellerator;

import org.eclipse.emf.ecore.EClass;

public class GeometryObject implements Comparable<GeometryObject> {

	private long oid;
	private long roid;
	private int saveableTriangles;
	private float density;
	private EClass eClass;
	private int tileId;

	public GeometryObject(long oid, EClass eClass, long roid, int saveableTriangles, float density) {
		this.oid = oid;
		this.eClass = eClass;
		this.roid = roid;
		this.saveableTriangles = saveableTriangles;
		this.density = density;
	}
	
	public void setTileId(int tileId) {
		this.tileId = tileId;
	}
	
	public EClass geteClass() {
		return eClass;
	}
	
	public long getOid() {
		return oid;
	}
	
	public long getRoid() {
		return roid;
	}
	
	public int getSaveableTriangles() {
		return saveableTriangles;
	}

	@Override
	public int compareTo(GeometryObject o) {
		return Float.compare(density, o.density);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (oid ^ (oid >>> 32));
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
		GeometryObject other = (GeometryObject) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
	
	public float getDensity() {
		return density;
	}

	public int getTileId() {
		return tileId;
	}
}
