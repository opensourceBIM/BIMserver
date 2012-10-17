package org.bimserver.shared.meta;

public interface SDataBase extends SBase {
	long getOid();
	void setOid(long oid);
	int getRid();
	void setRid(int rid);
}
