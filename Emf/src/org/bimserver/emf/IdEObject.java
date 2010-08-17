package org.bimserver.emf;

import org.eclipse.emf.ecore.EObject;

public interface IdEObject extends EObject {
	void setOid(long oid);
	long getOid();
}