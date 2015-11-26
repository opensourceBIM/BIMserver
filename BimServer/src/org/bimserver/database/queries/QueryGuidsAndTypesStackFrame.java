package org.bimserver.database.queries;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.ObjectIdentifier;
import org.bimserver.database.Record;
import org.bimserver.database.RecordIterator;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.QueryException;
import org.bimserver.shared.QueryContext;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EClass;

public class QueryGuidsAndTypesStackFrame extends StackFrame {

	private EClass eClass;
	private QueryObjectProvider queryObjectProvider;
	private Set<Long> oids;
	private QueryContext reusable;
	private QueryPart jsonQuery;
	private boolean converted;

	public QueryGuidsAndTypesStackFrame(QueryObjectProvider queryObjectProvider, EClass eClass, QueryPart jsonQuery, QueryContext reusable, Set<String> guids) throws BimserverDatabaseException {
		this.queryObjectProvider = queryObjectProvider;
		this.eClass = eClass;
		this.jsonQuery = jsonQuery;
		this.reusable = reusable;
		
		oids = new HashSet<>();
		for (String guid : guids) {
			ObjectIdentifier oidOfGuid = getOidOfGuid(reusable.getPackageMetaData().getSchema().name(), guid, reusable.getPid(), reusable.getRid());
			if (oidOfGuid != null) {
				oids.add(oidOfGuid.getOid());
			}
		}
		if (oids.isEmpty()) {
			converted = true;
		}
	}

	public ObjectIdentifier getOidOfGuid(String schema, String guid, int pid, int rid) throws BimserverDatabaseException {
		for (EClass eClass : reusable.getPackageMetaData().getAllSubClasses(reusable.getPackageMetaData().getEClass("IfcRoot"))) {
			RecordIterator recordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(eClass.getEPackage().getName() + "_" + eClass.getName(), BinUtils.intToByteArray(pid),
					BinUtils.intToByteArray(pid), queryObjectProvider.getDatabaseSession());
			try {
				Record record = recordIterator.next();
				while (record != null) {
					queryObjectProvider.incReads();
					ByteBuffer buffer = ByteBuffer.wrap(record.getKey());
					int pidOfRecord = buffer.getInt();
					long oid = buffer.getLong();
					int ridOfRecord = -buffer.getInt();
					if (ridOfRecord == rid && pid == pidOfRecord) {
						ByteBuffer value = ByteBuffer.wrap(record.getValue());

						// Skip the unsettable part
						value.position(value.position() + reusable.getPackageMetaData().getUnsettedLength(eClass));

						if (value.capacity() > 1) {
							int stringLength = value.getInt();
							if (stringLength == -1) {
								return null;
							} else {
								String s = BinUtils.readString(value, stringLength);
								if (s.equals(guid)) {
									return new ObjectIdentifier(oid, queryObjectProvider.getDatabaseSession().getCid(eClass));
								}
							}
						}
					}
					record = recordIterator.next();
				}
			} finally {
				recordIterator.close();
			}
		}
		return null;
	}
	
	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (converted) {
			return true;
		} else {
			converted = true;
			queryObjectProvider.push(new QueryOidsAndTypesStackFrame(queryObjectProvider, eClass, jsonQuery, reusable, new ArrayList<>(oids)));
			return false;
		}
	}
}