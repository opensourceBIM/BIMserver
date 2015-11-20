package org.bimserver.database.queries;

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.actions.ObjectProvidingStackFrame;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.QueryInterface;
import org.bimserver.shared.Reusable;
import org.eclipse.emf.ecore.EClass;

public class FollowReferenceStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private long oid;
	private QueryInterface query;
	private boolean hasRun = false;
	private EClass previousType;
	private Include include;
	
	public FollowReferenceStackFrame(QueryObjectProvider queryObjectProvider, Long oid, PackageMetaData packageMetaData, Reusable reusable, QueryInterface query, EClass previousType, QueryPart queryPart, Include include) {
		super(packageMetaData, reusable, queryObjectProvider, query, queryPart);
		this.oid = oid;
		this.query = query;
		this.previousType = previousType;
		this.include = include;
	}

	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
//		if (getQueryObjectProvider().hasRead(oid)) {
//			processPossibleIncludes(previousType, queryPart);
//			return true;
//		}
		
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
					if (include.hasIncludes()) {
						for (Include include : include.getIncludes()) {
							processPossibleInclude(include);
						}
					}
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