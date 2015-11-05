package org.bimserver.shared;

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface VirtualObject {

	EClass eClass();
	Object eGet(EStructuralFeature feature);
	long getOid();
	void setOid(long oid);
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
}