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
import org.bimserver.database.DatabaseSession.GetResult;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EClass;

public class QueryOidsAndTypesStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private EClass eClass;
	private SearchingRecordIterator typeRecordIterator;
	private Record record;
	private Iterator<Long> oidIterator;

	public QueryOidsAndTypesStackFrame(QueryObjectProvider queryObjectProvider, EClass eClass, QueryPart queryPart, QueryContext reusable, List<Long> oids) throws BimserverLockConflictException, BimserverDatabaseException, QueryException {
		super(reusable, queryObjectProvider, queryPart);
		this.eClass = eClass;
		
		// Assumption: oids are sorted
		
		String tableName = eClass.getEPackage().getName() + "_" + eClass.getName();
		if (getReusable().getOidCounters() != null) {
			if (!getReusable().getOidCounters().containsKey(eClass)) {
				return; // will skip to next one
			}
			long startOid = getReusable().getOidCounters().get(eClass);
			oidIterator = oids.iterator();
			long firstOid = oidIterator.next();
			while (firstOid < startOid && oidIterator.hasNext()) {
				firstOid = oidIterator.next();
			}

			if (firstOid >= startOid) {
				// Just an optimization
				startOid = firstOid;
			} else {
				return;
			}
			ByteBuffer tmp = ByteBuffer.allocate(12);
			tmp.putInt(getReusable().getPid());
			tmp.putLong(startOid);
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(getReusable().getPid()), tmp.array(), queryObjectProvider.getDatabaseSession());
			record = typeRecordIterator.next();
		} else {
//			LOGGER.warn("Potential too-many-reads");
			oidIterator = oids.iterator();
			long firstOid = oidIterator.next();
			ByteBuffer tmp = ByteBuffer.allocate(12);
			tmp.putInt(getReusable().getPid());
			tmp.putLong(firstOid);
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(getReusable().getPid()), tmp.array(), queryObjectProvider.getDatabaseSession());
			record = typeRecordIterator.next();
		}
	}

	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (typeRecordIterator == null) {
			return true;
		}
		if (record == null) {
			currentObject = null;
			typeRecordIterator.close();
			return true;
		}

		currentObject = null;
		
		ByteBuffer nextKeyStart = ByteBuffer.allocate(12);
		getQueryObjectProvider().incReads();
		ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
		int keyPid = keyBuffer.getInt();
		long keyOid = keyBuffer.getLong();
		int keyRid = -keyBuffer.getInt();
		ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
		GetResult map = getMap(eClass, eClass, valueBuffer, keyPid, keyOid, keyRid);
		if (map == GetResult.CONTINUE_WITH_NEXT_OID) {
			if (oidIterator.hasNext()) {
				nextKeyStart.position(0);
				nextKeyStart.putInt(getReusable().getPid());
				nextKeyStart.putLong(oidIterator.next());
				record = typeRecordIterator.next(nextKeyStart.array());
			} else {
				record = null;
			}
		} else {
			record = typeRecordIterator.next();
		}

		processPossibleIncludes(currentObject, eClass, getQueryPart());
		
		if (record == null) {
			typeRecordIterator.close();
		}
		return record == null;
	}

	public HashMapVirtualObject getCurrentObject() {
		return currentObject;
	}
}