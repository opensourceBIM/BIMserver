package org.bimserver.database.queries;

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession.GetResult;
import org.bimserver.database.Query;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.actions.ObjectProvidingStackFrame;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.Reusable;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EClass;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class QueryTypeStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private EClass eClass;
	private SearchingRecordIterator typeRecordIterator;
	private Record record;

	public QueryTypeStackFrame(QueryObjectProvider queryObjectProvider, EClass eClass, Query query, PackageMetaData packageMetaData, Reusable reusable, ObjectNode jsonQuery) throws BimserverLockConflictException, BimserverDatabaseException {
		super(packageMetaData, reusable, queryObjectProvider, query, jsonQuery);
		this.eClass = eClass;
		
		String tableName = eClass.getEPackage().getName() + "_" + eClass.getName();
		if (query.getOidCounters() != null) {
			if (!query.getOidCounters().containsKey(eClass)) {
				return; // will skip to next one
			}
			long startOid = query.getOidCounters().get(eClass);
			ByteBuffer tmp = ByteBuffer.allocate(12);
			tmp.putInt(query.getPid());
			tmp.putLong(startOid + 1);
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
			nextKeyStart.position(0);
			nextKeyStart.putInt(getQuery().getPid());
			nextKeyStart.putLong(keyOid + 1);
			record = typeRecordIterator.next(nextKeyStart.array());
		} else {
			record = typeRecordIterator.next();
		}

		processPossibleIncludes(getJsonQuery());
		
		return false;
	}
}