package org.bimserver.emf;

import org.eclipse.emf.ecore.impl.EObjectImpl;

public class IdEObjectImpl extends EObjectImpl implements IdEObject {

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