package org.bimserver.database.queries;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.ObjectIdentifier;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.plugins.deserializers.DatabaseInterface;
import org.bimserver.shared.QueryContext;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.google.common.base.Charsets;

public class QueryNamesAndTypesStackFrame extends DatabaseReadingStackFrame {

	private EClass eClass;
	private QueryObjectProvider queryObjectProvider;
	private Set<Long> oids;
	private QueryContext reusable;
	private QueryPart jsonQuery;
	private boolean converted;

	public QueryNamesAndTypesStackFrame(QueryObjectProvider queryObjectProvider, EClass eClass, QueryPart jsonQuery, QueryContext reusable, Set<String> names) throws BimserverDatabaseException {
		super(reusable, queryObjectProvider, null);
		this.queryObjectProvider = queryObjectProvider;
		this.eClass = eClass;
		this.jsonQuery = jsonQuery;
		this.reusable = reusable;
		
		oids = new HashSet<>();
		for (String name : names) {
			EAttribute nameFeature = (EAttribute) eClass.getEStructuralFeature("Name");
			if (nameFeature == null) {
				converted = true;
//				throw new BimserverDatabaseException(eClass.getName() + " does not have a GlobalId feature");
			} else {
				ObjectIdentifier oidOfName = getOidOfGuidAlternative(eClass, nameFeature, name, reusable.getDatabaseInterface(), reusable.getPid(), reusable.getRid());
				if (oidOfName != null) {
					oids.add(oidOfName.getOid());
				}
			}
		}
		if (oids.isEmpty()) {
			converted = true;
		}
	}

	public ObjectIdentifier getOidOfGuidAlternative(EClass eClass, EAttribute attribute, Object value, DatabaseInterface databaseInterface, int pid, int rid) throws BimserverDatabaseException {
		if (attribute.getEAnnotation("singleindex") != null) {
			String indexTableName = attribute.getEContainingClass().getEPackage().getName() + "_" + eClass.getName() + "_" + attribute.getName();
			byte[] queryBytes = null;
			if (value instanceof String) {
				queryBytes = ((String)value).getBytes(Charsets.UTF_8);
			} else if (value instanceof Integer) {
				queryBytes = BinUtils.intToByteArray((Integer)value);
			} else {
				throw new BimserverDatabaseException("Unsupported type " + value);
			}
			ByteBuffer valueBuffer = ByteBuffer.allocate(queryBytes.length + 8);
			valueBuffer.putInt(pid);
			valueBuffer.putInt(-rid);
			valueBuffer.put(queryBytes);
			byte[] firstDuplicate = databaseInterface.get(indexTableName, valueBuffer.array());
			if (firstDuplicate != null) {
				ByteBuffer buffer = ByteBuffer.wrap(firstDuplicate);
				buffer.getInt(); // pid
				long oid = buffer.getLong();
				
				return new ObjectIdentifier(oid, (short)oid);
			}
		} else {
			throw new BimserverDatabaseException("Name queries are not implemented yet");
		}
		return null;
	}
	
//	public ObjectIdentifier getOidOfName(String schema, String name, int pid, int rid) throws BimserverDatabaseException {
//		for (EClass eClass : reusable.getPackageMetaData().getAllSubClasses(reusable.getPackageMetaData().getEClass("IfcRoot"))) {
//			RecordIterator recordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(eClass.getEPackage().getName() + "_" + eClass.getName(), BinUtils.intToByteArray(pid),
//					BinUtils.intToByteArray(pid), queryObjectProvider.getDatabaseSession());
//			try {
//				Record record = recordIterator.next();
//				while (record != null) {
//					queryObjectProvider.incReads();
//					ByteBuffer buffer = ByteBuffer.wrap(record.getKey());
//					int pidOfRecord = buffer.getInt();
//					long oid = buffer.getLong();
//					int ridOfRecord = -buffer.getInt();
//					if (ridOfRecord == rid && pid == pidOfRecord) {
//						ByteBuffer value = ByteBuffer.wrap(record.getValue());
//
//						// Skip the unsettable part
//						value.position(value.position() + reusable.getPackageMetaData().getUnsettedLength(eClass));
//
//						if (value.capacity() > 1) {
//							int stringLength = value.getInt();
//							if (stringLength == -1) {
//								return null;
//							} else {
//								String s = BinUtils.readString(value, stringLength);
//								if (s.equals(name)) {
//									return new ObjectIdentifier(oid, queryObjectProvider.getDatabaseSession().getCid(eClass));
//								}
//							}
//						}
//					}
//					record = recordIterator.next();
//				}
//			} finally {
//				recordIterator.close();
//			}
//		}
//		return null;
//	}
	
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