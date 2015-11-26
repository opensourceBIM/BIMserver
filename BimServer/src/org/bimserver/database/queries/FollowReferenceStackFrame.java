package org.bimserver.database.queries;

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.actions.ObjectProvidingStackFrame;
import org.bimserver.database.queries.om.CanInclude;
import org.bimserver.database.queries.om.Include;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.QueryException;
import org.bimserver.shared.QueryContext;
import org.eclipse.emf.ecore.EClass;

public class FollowReferenceStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private long oid;
	private boolean hasRun = false;
	private Include include;
	private CanInclude previousInclude;
	
	public FollowReferenceStackFrame(QueryObjectProvider queryObjectProvider, Long oid, QueryContext reusable, QueryPart queryPart, CanInclude previousInclude, Include include) {
		super(reusable, queryObjectProvider, queryPart);
		this.oid = oid;
		this.previousInclude = previousInclude;
		this.include = include;
	}

	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (getQueryObjectProvider().hasRead(oid)) {
			processPossibleIncludes(null, include);
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
		mustStartWith.putInt(getReusable().getPid());
		mustStartWith.putLong(oid);
		ByteBuffer startSearchWith = ByteBuffer.wrap(new byte[16]);
		startSearchWith.putInt(getReusable().getPid());
		startSearchWith.putLong(oid);
		startSearchWith.putInt(-getReusable().getRid());

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
			if (keyRid <= getReusable().getRid()) {
				if (valueBuffer.capacity() == 1 && valueBuffer.get(0) == -1) {
					valueBuffer.position(valueBuffer.position() + 1);
					return true;
					// deleted entity
				} else {
					currentObject = convertByteArrayToObject(eClass, eClass, keyOid, valueBuffer, keyRid);
					
					if (currentObject.eClass().getName().toUpperCase().equals("IFCBOOLEANCLIPPINGRESULT")) {
						System.out.println();
					}
					
					processPossibleIncludes(null, include);
					
//					if (include.hasFields()) {
//						for (EReference eReference : include.getFields()) {
//							EReference inverseOrOpposite = getPackageMetaData().getInverseOrOpposite(currentObject.eClass(), eReference);
//							if (inverseOrOpposite != null) {
//								currentObject.addUseForSerialization(inverseOrOpposite);
//							}
//						}
//					}
					
//					if (currentObject != null) {
//						if (getQueryPart().isIncludeAllFields()) {
//							for (EReference eReference : currentObject.eClass().getEAllReferences()) {
//								currentObject.addUseForSerialization(eReference);
//							}
//						}
//					}
//					
//					if (include.hasIncludes()) {
//						for (Include include : include.getIncludes()) {
//							processPossibleInclude(include);
//						}
//					}
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