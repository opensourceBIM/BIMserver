package org.bimserver.database.queries;

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.actions.ObjectProvidingStackFrame;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.shared.Reusable;
import org.eclipse.emf.ecore.EClass;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FollowReferenceStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private long oid;
	private QueryInterface query;
	private ObjectNode queryPart;
	private boolean hasRun = false;
	
	public FollowReferenceStackFrame(QueryObjectProvider queryObjectProvider, Long oid, PackageMetaData packageMetaData, Reusable reusable, QueryInterface query, ObjectNode queryPart, ObjectNode jsonQuery) {
		super(packageMetaData, reusable, queryObjectProvider, query, jsonQuery);
		this.oid = oid;
		this.query = query;
		this.queryPart = queryPart;
	}

	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (getQueryObjectProvider().hasRead(oid)) {
			processPossibleIncludes(queryPart);
			return true;
		}
		
		if (hasRun) {
			return true;
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
				return true;
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
					return true;
					// deleted entity
				} else {
					currentObject = convertByteArrayToObject(eClass, eClass, keyOid, valueBuffer, keyRid, query);
					processPossibleIncludes(queryPart);
				}
			} else {
				return true;
			}
		} finally {
			recordIterator.close();
		}
		return true;
	}
}