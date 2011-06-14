package org.bimserver.plugins.serializers;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.ecore.EObject;

public interface IfcModelInterface {

	void add(long oid, IdEObject newObject);
	Map<Long, IdEObject> getObjects();
	EObject getMainObject();
	<T extends EObject> List<T> getAll(Class<T> clazz);
	Set<Long> keySet();
	EObject get(long key);
	boolean contains(IdEObject referencedObject);
	long get(IdEObject referencedObject);
	String getAuthorizedUser();
	String getName();
	long size();
	int getSize();
	byte[] getChecksum();
	void fixOids(OidProvider oidProvider);
	void setObjectOids();
	void indexGuids();
	void setDate(Date date);
	Collection<IdEObject> getValues();
}