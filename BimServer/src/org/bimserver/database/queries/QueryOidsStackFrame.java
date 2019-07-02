package org.bimserver.database.queries;

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
import java.util.Iterator;
import java.util.List;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EClass;

public class QueryOidsStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private SearchingRecordIterator typeRecordIterator;
	private Record record;
	private Iterator<Long> oidIterator;
	private Iterator<Long> oidsIterator;

	public QueryOidsStackFrame(QueryObjectProvider queryObjectProvider, QueryPart queryPart, QueryContext reusable, List<Long> oids) throws BimserverLockConflictException, BimserverDatabaseException, QueryException {
		super(reusable, queryObjectProvider, queryPart);

		oidsIterator = oids.iterator();
		prepareNext();
	}

	public void prepareNext() throws BimserverDatabaseException {
		if (!oidsIterator.hasNext()) {
			record = null;
			return;
		}
		Long oid = oidsIterator.next();
		EClass eClass = getReusable().getDatabaseInterface().getEClassForOid(oid);
		String tableName = eClass.getEPackage().getName() + "_" + eClass.getName();
		if (getReusable().getOidCounters() != null) {
			ByteBuffer tmp = ByteBuffer.allocate(12);
			tmp.putInt(getReusable().getPid());
			tmp.putLong(oid);
			typeRecordIterator = getQueryObjectProvider().getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(getReusable().getPid()), tmp.array(), getQueryObjectProvider().getDatabaseSession());
			record = typeRecordIterator.next();
		}
	}
	
	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (record == null) {
			currentObject = null;
			return true;
		}

		currentObject = null;
		
		ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
		int keyPid = keyBuffer.getInt();
		long keyOid = keyBuffer.getLong();
		int keyRid = -keyBuffer.getInt();
		ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
		EClass eClass = getReusable().getDatabaseInterface().getEClassForOid(keyOid);
		
		getMap(eClass, eClass, valueBuffer, keyPid, keyOid, keyRid);

		processPossibleIncludes(currentObject, eClass, getQueryPart());
		
		if (record == null) {
			typeRecordIterator.close();
		}
		prepareNext();
		return record == null;
	}

	public HashMapVirtualObject getCurrentObject() {
		return currentObject;
	}
}