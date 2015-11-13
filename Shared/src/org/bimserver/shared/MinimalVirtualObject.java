package org.bimserver.shared;

import java.nio.ByteBuffer;
import java.util.List;

import org.bimserver.BimserverDatabaseException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface MinimalVirtualObject {
	EClass eClass();
	void setAttribute(EStructuralFeature eStructuralFeature, Object value) throws BimserverDatabaseException;
	ByteBuffer write() throws BimserverDatabaseException;
	Object eGet(EStructuralFeature feature);
}
