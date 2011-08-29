package org.bimserver.plugins.serializers;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.BiMap;

public interface IfcModelInterface {

	void add(long oid, IdEObject newObject);
	Map<Long, IdEObject> getObjects();
	EObject getMainObject();
	<T extends EObject> List<T> getAll(Class<T> clazz);
	Set<Long> keySet();
	IdEObject get(long key);
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
	long getHighestOid();
	boolean contains(String referredGuid);
	IdEObject get(Class<?> class1);
	Date getDate();
	void remove(IdEObject objectToRemove);
	void resetOids();
	void setName(String string);
	void setRevisionNr(int i);
	void setAuthorizedUser(String name);
	BiMap<? extends Long, ? extends EObject> getMap();
	Set<String> getGuids(EClass eClass);
	IdEObject getByGuid(EClass eClass, String guid);
	Set<String> getNames(EClass eClass);
	IdEObject getByName(EClass eClass, String name);
	int getRevisionNr();
	boolean isValid();
	void checkDoubleOidsPlusReferences();
	<T extends EObject> List<T> getAllWithSubTypes(Class<T> interfaceClass);
	void setChecksum(byte[] digest);
	boolean contains(long oid);
}