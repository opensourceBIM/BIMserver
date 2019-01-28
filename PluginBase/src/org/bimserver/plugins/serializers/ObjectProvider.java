package org.bimserver.plugins.serializers;

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

import java.io.IOException;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.shared.HashMapVirtualObject;
import org.eclipse.emf.ecore.EClass;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface ObjectProvider {

	/**
	 * @return Will return new objects as long as the query finds more. Will never return the same object twice. Returns @null when no more objects can be found.
	 * @throws BimserverDatabaseException
	 */
	HashMapVirtualObject next() throws BimserverDatabaseException;

	ObjectProvider copy() throws IOException, QueryException;
	
	HashMapVirtualObject getByOid(long oid);

	EClass getEClassForOid(long oid);

	EClass getEClassForCid(short cid);
	
	ObjectNode getQueryNode();

	void cache(HashMapVirtualObject object);
}
