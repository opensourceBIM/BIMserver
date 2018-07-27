package org.bimserver.database.queries;

public class GeometryObject {

	private long oid;
	private long roid;
	private int saveableTriangles;

	public GeometryObject(long oid, long roid, int saveableTriangles) {
		this.oid = oid;
		this.roid = roid;
		this.saveableTriangles = saveableTriangles;
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
}
