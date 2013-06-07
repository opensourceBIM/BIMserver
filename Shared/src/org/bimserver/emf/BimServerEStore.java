package org.bimserver.emf;

import org.eclipse.emf.ecore.InternalEObject.EStore;

public interface BimServerEStore extends EStore {
	void load(IdEObject object);
	void remove(IdEObject object);
}
