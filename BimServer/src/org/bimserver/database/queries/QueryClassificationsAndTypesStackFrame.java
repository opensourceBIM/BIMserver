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

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.DatabaseSession.GetResult;
import org.bimserver.database.ObjectIdentifier;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.plugins.deserializers.DatabaseInterface;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.base.Charsets;

public class QueryClassificationsAndTypesStackFrame extends DatabaseReadingStackFrame {

	private EClass eClass;
	private SearchingRecordIterator typeRecordIterator;
	private Record record;
	private Set<Long> allowedOids = new HashSet<>();

	@SuppressWarnings("unchecked")
	public QueryClassificationsAndTypesStackFrame(QueryObjectProvider queryObjectProvider, EClass eClass, QueryPart partialQuery, QueryContext reusable, Set<String> classifications) throws BimserverDatabaseException {
		super(reusable, queryObjectProvider, partialQuery);
		this.eClass = eClass;

		DatabaseSession databaseSession = getQueryObjectProvider().getDatabaseSession();
		String schemaName = eClass.getEPackage().getName();
		EClass classificationReferenceClass = databaseSession.getEClass(schemaName, "IfcClassificationReference");
		EClass relAssociatesClassificationReferenceClass = databaseSession.getEClass(schemaName, "IfcRelAssociatesClassification");
		EStructuralFeature classificationKeyFeature = classificationReferenceClass.getEStructuralFeature(1); // renamed from "ItemReference" in IFC2x3 to "Identification" in IFC4
		for (String classification : classifications) {
			List<ObjectIdentifier> objectIdentifiers = getOids(classificationReferenceClass, classificationKeyFeature, classification, databaseSession, reusable.getPid(), reusable.getRid());
			for (ObjectIdentifier objectIdentifier : objectIdentifiers) {
				// Now we need to get all the IfcRelAssociatesClassification objects referencing this one
				List<ObjectIdentifier> relAssociates = getOids(relAssociatesClassificationReferenceClass, relAssociatesClassificationReferenceClass.getEStructuralFeature("RelatingClassification"), objectIdentifier.getOid(), databaseSession, reusable.getPid(), reusable.getRid());
				for (ObjectIdentifier objectIdentifier2 : relAssociates) {
					HashMapVirtualObject relAssociatesClassification = getByOid(objectIdentifier2.getOid());
					List<Long> relatedObjects = (List<Long>) relAssociatesClassification.eGet(relAssociatesClassificationReferenceClass.getEStructuralFeature("RelatedObjects"));
					
					allowedOids.addAll(relatedObjects);
				}
			}
		}
		
		String tableName = eClass.getEPackage().getName() + "_" + eClass.getName();
		if (getReusable().getOidCounters() != null) {
			if (!getReusable().getOidCounters().containsKey(eClass)) {
				return; // will skip to next one
			}
			long startOid = getReusable().getOidCounters().get(eClass);
			ByteBuffer tmp = ByteBuffer.allocate(12);
			tmp.putInt(getReusable().getPid());
			tmp.putLong(startOid + 1);
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(getReusable().getPid()), tmp.array(), queryObjectProvider.getDatabaseSession());
			record = typeRecordIterator.next();
		} else {
			// LOGGER.warn("Potential too-many-reads");
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(getReusable().getPid()), BinUtils.intToByteArray(getReusable().getPid()),
					queryObjectProvider.getDatabaseSession());
			record = typeRecordIterator.next();
		}
	}

	public ObjectIdentifier getOid(EClass eClass, EAttribute attribute, Object value, DatabaseInterface databaseInterface, int pid, int rid) throws BimserverDatabaseException {
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
			throw new UnsupportedOperationException(eClass.getName() + "." + attribute.getName() + " does not have a singleindex");
		}
		return null;
	}

	public List<ObjectIdentifier> getOids(EClass eClass, EStructuralFeature eStructuralFeature, Object value, DatabaseInterface databaseInterface, int pid, int rid) throws BimserverDatabaseException {
		if (eStructuralFeature.getEAnnotation("singleindex") != null) {
			List<ObjectIdentifier> result = new ArrayList<>();
			String indexTableName = eStructuralFeature.getEContainingClass().getEPackage().getName() + "_" + eClass.getName() + "_" + eStructuralFeature.getName();
			byte[] queryBytes = null;
			if (value instanceof String) {
				queryBytes = ((String)value).getBytes(Charsets.UTF_8);
			} else if (value instanceof Integer) {
				queryBytes = BinUtils.intToByteArray((Integer)value);
			} else if (value instanceof Long) {
				queryBytes = BinUtils.longToByteArray((Long)value);
			} else {
				throw new BimserverDatabaseException("Unsupported type " + value);
			}
			ByteBuffer valueBuffer = ByteBuffer.allocate(queryBytes.length + 8);
			valueBuffer.putInt(pid);
			valueBuffer.putInt(-rid);
			valueBuffer.put(queryBytes);
			List<byte[]> duplicates = databaseInterface.getDuplicates(indexTableName, valueBuffer.array());
			for (byte[] duplicate : duplicates) {
				ByteBuffer buffer = ByteBuffer.wrap(duplicate);
				buffer.getInt(); // pid
				long oid = buffer.getLong();
				
				result.add(new ObjectIdentifier(oid, (short)oid));
			}
			return result;
		} else {
			throw new UnsupportedOperationException();
		}
	}
	
	@Override
	boolean process() throws BimserverDatabaseException, QueryException, JsonParseException, JsonMappingException, IOException {
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
		GetResult map = getMap(eClass, eClass, valueBuffer, keyPid, keyOid, keyRid);
		if (map == GetResult.CONTINUE_WITH_NEXT_OID) {
			nextKeyStart.position(0);
			nextKeyStart.putInt(getReusable().getPid());
			nextKeyStart.putLong(keyOid + 1);
			record = typeRecordIterator.next(nextKeyStart.array());
		} else {
			record = typeRecordIterator.next();
		}

		if (currentObject != null) {
			if (!allowedOids.contains(currentObject.getOid())) {
				currentObject = null;
			}
		}

		processPossibleIncludes(currentObject, eClass, getQueryPart());

		return false;
	}
}
