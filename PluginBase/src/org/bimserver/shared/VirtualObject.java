package org.bimserver.shared;

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface VirtualObject extends MinimalVirtualObject {

	EClass eClass();
	Object eGet(EStructuralFeature feature);
	Object get(String name);
	long getOid();
	void setOid(long oid);
	void set(String name, Object val) throws BimserverDatabaseException;
	void setAttribute(EStructuralFeature feature, Object val) throws BimserverDatabaseException;
	void setReference(EStructuralFeature feature, long referenceOid, int bufferPosition) throws BimserverDatabaseException;
	void save() throws BimserverDatabaseException;
	ByteBuffer write() throws BimserverDatabaseException;
	void eUnset(EStructuralFeature feature) throws BimserverDatabaseException;
	int getRid();
	int getPid();
	void setListItem(EStructuralFeature structuralFeature, int index, Object value) throws BimserverDatabaseException;
	void setListItemReference(EStructuralFeature structuralFeature, int index, EClass referenceEClass, Long referencedOid, int bufferPosition) throws BimserverDatabaseException;
	int reserveSpaceForReference(EStructuralFeature feature);
	void startList(EStructuralFeature feature);
	int reserveSpaceForListReference() throws BimserverDatabaseException;
	void endList();
	boolean has(String string);
}