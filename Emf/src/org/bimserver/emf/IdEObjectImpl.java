package org.bimserver.emf;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class IdEObjectImpl extends MinimalEObjectImpl implements IdEObject {

	private long oid = -1;
	
	@Override
	public long getOid() {
		return oid;
	}

	@Override
	public void setOid(long oid) {
		this.oid = oid;
	}
}