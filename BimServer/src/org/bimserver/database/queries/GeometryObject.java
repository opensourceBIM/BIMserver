package org.bimserver.database.queries;

public class GeometryObject {

	private long oid;
	private long roid;

	public GeometryObject(long oid, long roid) {
		this.oid = oid;
		this.roid = roid;
	}
	
	public long getOid() {
		return oid;
	}
	
	public long getRoid() {
		return roid;
	}
}
