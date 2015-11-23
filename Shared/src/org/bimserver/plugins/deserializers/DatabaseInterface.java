package org.bimserver.plugins.deserializers;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.shared.VirtualObject;
import org.eclipse.emf.ecore.EClass;

public interface DatabaseInterface {

	EClass getEClassForOid(long oid) throws BimserverDatabaseException;
	short getCidOfEClass(EClass eClass);
	long newOid(EClass eClass);
	int save(VirtualObject virtualObject) throws BimserverDatabaseException;
	int saveOverwrite(VirtualObject virtualObject) throws BimserverDatabaseException;
}