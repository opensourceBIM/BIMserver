package org.bimserver.database.queries;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.ObjectIdentifier;
import org.bimserver.database.Query;
import org.bimserver.database.Record;
import org.bimserver.database.RecordIterator;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.shared.Reusable;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EClass;

public class QueryGuidsAndTypesStackFrame extends StackFrame {

	private PackageMetaData packageMetaData;
	private EClass eClass;
	private QueryObjectProvider queryObjectProvider;
	private Set<Long> oids;
	private Reusable reusable;
	private QueryPart jsonQuery;
	private Query query;
	private boolean converted;

	public QueryGuidsAndTypesStackFrame(QueryObjectProvider queryObjectProvider, EClass eClass, Query query, QueryPart jsonQuery, PackageMetaData packageMetaData, Reusable reusable, Set<String> guids) throws BimserverDatabaseException {
		this.queryObjectProvider = queryObjectProvider;
		this.eClass = eClass;
		this.query = query;
		this.jsonQuery = jsonQuery;
		this.packageMetaData = packageMetaData;
		this.reusable = reusable;
		
		oids = new HashSet<>();
		for (String guid : guids) {
			ObjectIdentifier oidOfGuid = getOidOfGuid(packageMetaData.getSchema().name(), guid, reusable.getPid(), reusable.getRid());
			if (oidOfGuid != null) {
				oids.add(oidOfGuid.getOid());
			}
		}
		if (oids.isEmpty()) {
			converted = true;
		}
	}

	public ObjectIdentifier getOidOfGuid(String schema, String guid, int pid, int rid) throws BimserverDatabaseException {
		for (EClass eClass : packageMetaData.getAllSubClasses(packageMetaData.getEClass("IfcRoot"))) {
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
						value.position(value.position() + packageMetaData.getUnsettedLength(eClass));

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
			queryObjectProvider.push(new QueryOidsAndTypesStackFrame(queryObjectProvider, eClass, query, jsonQuery, packageMetaData, reusable, new ArrayList<>(oids)));
			return false;
		}
	}
}