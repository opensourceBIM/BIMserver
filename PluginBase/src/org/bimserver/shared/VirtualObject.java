package org.bimserver.shared;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface VirtualObject extends MinimalVirtualObject {

	EClass eClass();
	Object eGet(EStructuralFeature feature);
	Object get(String name);
	long getOid();
	void setOid(long oid);
	void set(String name, Object val) throws BimserverDatabaseException;
	void setAttribute(EAttribute eAttribute, Object val) throws BimserverDatabaseException;
	void setReference(EReference eReference, long referenceOid, int bufferPosition) throws BimserverDatabaseException;
	void setReference(EReference eReference, long referenceOid) throws BimserverDatabaseException;
	void save() throws BimserverDatabaseException;
	void saveOverwrite() throws BimserverDatabaseException;
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
	void setReference(EReference eReference, WrappedVirtualObject wrappedVirtualObject) throws BimserverDatabaseException;
}