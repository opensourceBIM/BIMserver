package org.bimserver.database.queries;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession.GetResult;
import org.bimserver.database.actions.DatabaseReadingStackFrame;
import org.bimserver.database.actions.ObjectProvidingStackFrame;
import org.bimserver.database.Query;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.Reusable;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class QueryTypeStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private EClass eClass;
	private SearchingRecordIterator typeRecordIterator;
	private Record record;
	private Query currentDatabaseQuery;
	private HashMapVirtualObject currentObject;
	private JsonObject jsonQuery;

	public QueryTypeStackFrame(QueryObjectProvider queryObjectProvider, EClass eClass, Query currentDatabaseQuery, JsonObject jsonQuery, PackageMetaData packageMetaData, Reusable reusable) throws BimserverLockConflictException, BimserverDatabaseException {
		super(packageMetaData, reusable, queryObjectProvider);
		this.eClass = eClass;
		this.currentDatabaseQuery = currentDatabaseQuery;
		this.jsonQuery = jsonQuery;
		
		String tableName = eClass.getEPackage().getName() + "_" + eClass.getName();
		if (currentDatabaseQuery.getOidCounters() != null) {
			if (!currentDatabaseQuery.getOidCounters().containsKey(eClass)) {
				return; // will skip to next one
			}
			long startOid = currentDatabaseQuery.getOidCounters().get(eClass);
			ByteBuffer tmp = ByteBuffer.allocate(12);
			tmp.putInt(currentDatabaseQuery.getPid());
			tmp.putLong(startOid + 1);
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(currentDatabaseQuery.getPid()), tmp.array(), queryObjectProvider.getDatabaseSession());
			record = typeRecordIterator.next();
		} else {
//			LOGGER.warn("Potential too-many-reads");
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(currentDatabaseQuery.getPid()), BinUtils.intToByteArray(currentDatabaseQuery.getPid()), queryObjectProvider.getDatabaseSession());
			record = typeRecordIterator.next();
		}
	}

	@Override
	public Set<StackFrame> process() throws BimserverDatabaseException, QueryException {
		if (typeRecordIterator == null) {
			return null;
		}
		if (record == null) {
			currentObject = null;
			typeRecordIterator.close();
			return null;
		}

		currentObject = null;
		
		ByteBuffer nextKeyStart = ByteBuffer.allocate(12);
		getQueryObjectProvider().incReads();
		ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
		int keyPid = keyBuffer.getInt();
		long keyOid = keyBuffer.getLong();
		int keyRid = -keyBuffer.getInt();
		ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
		GetResult map = getMap(eClass, eClass, valueBuffer, keyPid, keyOid, keyRid, currentDatabaseQuery);
		if (map == GetResult.CONTINUE_WITH_NEXT_OID) {
			nextKeyStart.position(0);
			nextKeyStart.putInt(currentDatabaseQuery.getPid());
			nextKeyStart.putLong(keyOid + 1);
			record = typeRecordIterator.next(nextKeyStart.array());
		} else {
			record = typeRecordIterator.next();
		}

		if (currentObject != null) {
			 if (jsonQuery.has("include")) {
				 JsonObject include = jsonQuery.getAsJsonObject("include");
				 return Collections.<StackFrame>singleton(new QueryIncludeStackFrame(getQueryObjectProvider(), currentDatabaseQuery, jsonQuery, getPackageMetaData(), getReusable(), include, currentObject));
			 } else if (jsonQuery.has("includes")) {
				 JsonArray includes = jsonQuery.get("includes").getAsJsonArray();
				 Set<StackFrame> result = new HashSet<>();
				 for (int i=0; i<includes.size(); i++) {
					 result.add(new QueryIncludeStackFrame(getQueryObjectProvider(), currentDatabaseQuery, jsonQuery, getPackageMetaData(), getReusable(), includes.get(i).getAsJsonObject(), currentObject));
				 }
				 if (result.size() > 0) {
					 return result;
				 }
			 }
		}
		
		return Collections.<StackFrame>singleton(this);
	}
	
	public HashMapVirtualObject getCurrentObject() {
		return currentObject;
	}
	
	private GetResult getMap(EClass originalQueryClass, EClass eClass, ByteBuffer buffer, int keyPid, long keyOid, int keyRid, QueryInterface query) throws BimserverDatabaseException {
		if (keyPid == query.getPid()) {
			if (keyRid <= query.getRid() && keyRid >= query.getStopRid()) {
				if (!getQueryObjectProvider().hasRead(keyOid)) {
					if (buffer.capacity() == 1 && buffer.get(0) == -1) {
						buffer.position(buffer.position() + 1);
						return GetResult.CONTINUE_WITH_NEXT_OID;
						// deleted entity
					} else {
						 currentObject = convertByteArrayToObject(originalQueryClass, eClass, keyOid, buffer, keyRid, query);
					}
				}
				return GetResult.CONTINUE_WITH_NEXT_OID;
			} else {
				return GetResult.CONTINUE_WITH_NEXT_RECORD;
			}
		} else {
			return GetResult.STOP;
		}
	}
}