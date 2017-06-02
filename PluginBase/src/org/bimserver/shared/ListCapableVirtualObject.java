package org.bimserver.shared;

import org.bimserver.BimserverDatabaseException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface ListCapableVirtualObject {

	void startList(EStructuralFeature structuralFeature);

	void endList();

	void setListItem(EStructuralFeature doubleStringFeature, int i, Object newObject) throws BimserverDatabaseException;

	int reserveSpaceForListReference() throws BimserverDatabaseException;

	void setListItemReference(EStructuralFeature structuralFeature, int index, EClass referenceEClass, Long referencedOid, int i) throws BimserverDatabaseException;

}
