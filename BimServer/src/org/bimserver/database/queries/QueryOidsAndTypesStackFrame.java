package org.bimserver.database.queries;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession.GetResult;
import org.bimserver.database.Query;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.actions.ObjectProvidingStackFrame;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.Reusable;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EClass;

public class QueryOidsAndTypesStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private EClass eClass;
	private SearchingRecordIterator typeRecordIterator;
	private Record record;
	private Iterator<Long> oidIterator;

	public QueryOidsAndTypesStackFrame(QueryObjectProvider queryObjectProvider, EClass eClass, Query query, QueryPart queryPart, PackageMetaData packageMetaData, Reusable reusable, List<Long> oids) throws BimserverLockConflictException, BimserverDatabaseException, QueryException {
		super(packageMetaData, reusable, queryObjectProvider, query, queryPart);
		this.eClass = eClass;
		
		Collections.sort(oids);
		
		String tableName = eClass.getEPackage().getName() + "_" + eClass.getName();
		if (query.getOidCounters() != null) {
			if (!query.getOidCounters().containsKey(eClass)) {
				return; // will skip to next one
			}
			long startOid = query.getOidCounters().get(eClass) + 1;
			oidIterator = oids.iterator();
			long firstOid = oidIterator.next();
			if (firstOid >= startOid) {
				startOid = firstOid;
			} else {
				throw new QueryException("Querying oid " + firstOid + " which cannot be in this revision");
			}
			ByteBuffer tmp = ByteBuffer.allocate(12);
			tmp.putInt(query.getPid());
			tmp.putLong(startOid);
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(query.getPid()), tmp.array(), queryObjectProvider.getDatabaseSession());
			record = typeRecordIterator.next();
		} else {
//			LOGGER.warn("Potential too-many-reads");
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(query.getPid()), BinUtils.intToByteArray(query.getPid()), queryObjectProvider.getDatabaseSession());
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
		GetResult map = getMap(eClass, eClass, valueBuffer, keyPid, keyOid, keyRid, getQuery());
		if (map == GetResult.CONTINUE_WITH_NEXT_OID) {
			if (oidIterator.hasNext()) {
				nextKeyStart.position(0);
				nextKeyStart.putInt(getQuery().getPid());
				nextKeyStart.putLong(oidIterator.next());
				record = typeRecordIterator.next(nextKeyStart.array());
			} else {
				record = null;
			}
		} else {
			record = typeRecordIterator.next();
		}

		processPossibleIncludes(eClass, getQueryPart());
		
		return record == null;
	}

	public HashMapVirtualObject getCurrentObject() {
		return currentObject;
	}
}