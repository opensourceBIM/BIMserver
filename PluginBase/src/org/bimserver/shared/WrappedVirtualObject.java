package org.bimserver.shared;

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface WrappedVirtualObject extends MinimalVirtualObject {

	EClass eClass();
	void setAttribute(EStructuralFeature eStructuralFeature, Object value) throws BimserverDatabaseException;
	ByteBuffer write() throws BimserverDatabaseException;
	void set(String name, Object value) throws BimserverDatabaseException;
	int getSize();
}
