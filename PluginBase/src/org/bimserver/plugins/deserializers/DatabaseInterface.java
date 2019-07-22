package org.bimserver.plugins.deserializers;

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

import java.util.List;
import java.util.UUID;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.shared.VirtualObject;
import org.eclipse.emf.ecore.EClass;

public interface DatabaseInterface {

	EClass getEClassForOid(long oid) throws BimserverDatabaseException;
	short getCidOfEClass(EClass eClass);
	long newOid(EClass eClass);
	int save(VirtualObject virtualObject) throws BimserverDatabaseException;
	int saveOverwrite(VirtualObject virtualObject) throws BimserverDatabaseException;
	byte[] get(String tableName, byte[] key) throws BimserverDatabaseException;
	List<byte[]> getDuplicates(String tableName, byte[] key) throws BimserverDatabaseException;
	UUID newUuid();
}