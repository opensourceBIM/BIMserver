package org.bimserver.database;

public class ObjectIdentifier {
	private final long oid;
	private final short cid;

	public ObjectIdentifier(long oid, short cid) {
		this.oid = oid;
		this.cid = cid;
	}

	public long getOid() {
		return oid;
	}

	public short getCid() {
		return cid;
	}
}