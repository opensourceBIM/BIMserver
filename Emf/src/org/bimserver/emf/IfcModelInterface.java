package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.store.Geometry;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.BiMap;

public interface IfcModelInterface extends Iterable<IdEObject> {

	void add(long oid, IdEObject newObject) throws IfcModelInterfaceException;
	void addAllowMultiModel(long oid, IdEObject newObject) throws IfcModelInterfaceException;
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
	long add(IdEObject eObject) throws IfcModelInterfaceException;
	IfcRoot get(String guid);
	void fixOidCounter();
	void setUseDoubleStrings(boolean useDoubleStrings);
	boolean isUseDoubleStrings();
	int count(EClass eClass);
	Geometry getGeometry();
	void setGeometry(Geometry geometry);
	void changeOid(IdEObject object);
	void fixOids();
}