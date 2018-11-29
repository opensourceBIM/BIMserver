package org.bimserver.geometry.accellerator;

import org.eclipse.emf.ecore.EClass;

public class GeometryObject implements Comparable<GeometryObject> {

	private final long oid;
	private final long croid;
	private final int saveableTriangles;
	private final float density;
	private final EClass eClass;
	private final int triangles;
	private final float biggestFace;

	private int tileId;
	private int tileLevel;

	public GeometryObject(long oid, EClass eClass, long croid, int saveableTriangles, int triangles, float density) {
		this.oid = oid;
		this.eClass = eClass;
		this.croid = croid;
		this.saveableTriangles = saveableTriangles;
		this.triangles = triangles;
		this.density = density;
		this.biggestFace = triangles / density;
	}
	
	public void setTileId(int tileId) {
		this.tileId = tileId;
	}
	
	public int getTriangles() {
		return triangles;
	}
	
	public EClass geteClass() {
		return eClass;
	}
	
	public long getOid() {
		return oid;
	}
	
	public long getCroid() {
		return croid;
	}
	
	public int getSaveableTriangles() {
		return saveableTriangles;
	}

	@Override
	public int compareTo(GeometryObject o) {
		return Float.compare(o.biggestFace, biggestFace);
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

	public float getOrder() {
		// The idea is that later on the determinator for ordering can be changed to something else
		return biggestFace;
	}

	public int getTileLevel() {
		return tileLevel;
	}
	
	public void setTileLevel(int tileLevel) {
		this.tileLevel = tileLevel;
	}
}
