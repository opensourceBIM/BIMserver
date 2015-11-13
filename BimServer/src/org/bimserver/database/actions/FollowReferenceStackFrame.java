package org.bimserver.database.actions;

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.queries.QueryException;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.StackFrame;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.Reusable;
import org.eclipse.emf.ecore.EClass;

public class FollowReferenceStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private long oid;
	private QueryInterface query;
	private HashMapVirtualObject object;
	
	public FollowReferenceStackFrame(QueryObjectProvider queryObjectProvider, Long oid, PackageMetaData packageMetaData, Reusable reusable, QueryInterface query) {
		super(packageMetaData, reusable, queryObjectProvider);
		this.oid = oid;
		this.query = query;
	}

	@Override
	public StackFrame process() throws BimserverDatabaseException, QueryException {
		object = get();
		return null;
	}
	
	public HashMapVirtualObject get() throws BimserverDatabaseException {
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
//			reads++;
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
					HashMapVirtualObject convertByteArrayToObject = convertByteArrayToObject(eClass, eClass, keyOid, valueBuffer, keyRid, query);
					return convertByteArrayToObject;
				}
			} else {
				return null;
			}
		} finally {
			recordIterator.close();
		}
	}

	@Override
	public HashMapVirtualObject getCurrentObject() {
		return object;
	}
}