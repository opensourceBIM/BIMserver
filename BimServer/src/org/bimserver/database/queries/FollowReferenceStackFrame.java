package org.bimserver.database.queries;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.actions.DatabaseReadingStackFrame;
import org.bimserver.database.actions.ObjectProvidingStackFrame;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.Reusable;
import org.eclipse.emf.ecore.EClass;

import com.google.gson.JsonObject;

public class FollowReferenceStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private long oid;
	private QueryInterface query;
	private HashMapVirtualObject object;
	private JsonObject include;
	private JsonObject jsonQuery;
	private boolean hasRun = false;
	
	public FollowReferenceStackFrame(QueryObjectProvider queryObjectProvider, Long oid, PackageMetaData packageMetaData, Reusable reusable, QueryInterface query, JsonObject include, JsonObject jsonQuery) {
		super(packageMetaData, reusable, queryObjectProvider);
		this.oid = oid;
		this.query = query;
		this.include = include;
		this.jsonQuery = jsonQuery;
	}

	@Override
	public Set<StackFrame> process() throws BimserverDatabaseException, QueryException {
		StackFrame stackFrame = get();
		if (stackFrame != null) {
			return Collections.singleton(stackFrame);
		}
		return null;
	}
	
	public StackFrame get() throws BimserverDatabaseException, QueryException {
		if (hasRun) {
			return null;
		}
		hasRun = true;
		if (oid == -1) {
			throw new BimserverDatabaseException("Cannot get object for oid " + oid);
		}
		EClass eClass = getQueryObjectProvider().getDatabaseSession().getEClassForOid(oid);
		ByteBuffer mustStartWith = ByteBuffer.wrap(new byte[12]);
		mustStartWith.putInt(query.getPid());
		mustStartWith.putLong(oid);
		ByteBuffer startSearchWith = ByteBuffer.wrap(new byte[16]);
		startSearchWith.putInt(query.getPid());
		startSearchWith.putLong(oid);
		startSearchWith.putInt(-query.getRid());

		SearchingRecordIterator recordIterator = getQueryObjectProvider().getDatabaseSession().getKeyValueStore().getRecordIterator(eClass.getEPackage().getName() + "_" + eClass.getName(), mustStartWith.array(),
				startSearchWith.array(), getQueryObjectProvider().getDatabaseSession());
		try {
			Record record = recordIterator.next();
			if (record == null) {
				return null;
			}
			getQueryObjectProvider().incReads();
			ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
			ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
			keyBuffer.getInt(); // pid
			long keyOid = keyBuffer.getLong();
			int keyRid = -keyBuffer.getInt();
			if (keyRid <= query.getRid()) {
				if (valueBuffer.capacity() == 1 && valueBuffer.get(0) == -1) {
					valueBuffer.position(valueBuffer.position() + 1);
					return null;
					// deleted entity
				} else {
					object = convertByteArrayToObject(eClass, eClass, keyOid, valueBuffer, keyRid, query);
					if (include != null) {
						return new QueryIncludeStackFrame(getQueryObjectProvider(), query, jsonQuery, getPackageMetaData(), getReusable(), include, object);
					}
				}
			} else {
				return null;
			}
		} finally {
			recordIterator.close();
		}
		return null;
	}

	@Override
	public HashMapVirtualObject getCurrentObject() {
		return object;
	}
}