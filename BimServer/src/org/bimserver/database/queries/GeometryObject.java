package org.bimserver.database.queries;

public class GeometryObject implements Comparable<GeometryObject> {

	private long oid;
	private long roid;
	private int saveableTriangles;
	private float density;

	public GeometryObject(long oid, long roid, int saveableTriangles, float density) {
		this.oid = oid;
		this.roid = roid;
		this.saveableTriangles = saveableTriangles;
		this.density = density;
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
}
