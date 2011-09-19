package org.bimserver.shared.meta;

public interface SBase {
	SClass getSClass();
	long getOid();
	void setOid(long oid);
	Object sGet(SField sField);
}
