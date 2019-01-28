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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.DatabaseSession.GetResult;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.queries.om.Properties;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryPropertiesAndTypesStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private static final Logger LOGGER = LoggerFactory.getLogger(QueryPropertiesAndTypesStackFrame.class);
	private EClass eClass;
	private SearchingRecordIterator typeRecordIterator;
	private Record record;
	private Map<String, Properties> properties;

	public QueryPropertiesAndTypesStackFrame(QueryObjectProvider queryObjectProvider, EClass eClass, QueryPart queryPart, QueryContext reusable, Map<String, Properties> properties) throws BimserverDatabaseException {
		super(reusable, queryObjectProvider, queryPart);
		this.eClass = eClass;
		this.properties = properties;

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
//			LOGGER.warn("Potential too-many-reads");
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(getReusable().getPid()), BinUtils.intToByteArray(getReusable().getPid()), queryObjectProvider.getDatabaseSession());
			record = typeRecordIterator.next();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
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
			DatabaseSession databaseSession = getQueryObjectProvider().getDatabaseSession();
			List<Long> isDefinedByOids = (List<Long>) currentObject.get("IsDefinedBy");
			int totalQueryProperties = 0;
			for (String key : this.properties.keySet()) {
				totalQueryProperties += this.properties.get(key).count();
			}
			if (isDefinedByOids != null) {
				Set<String> propertyKeysMatched = new HashSet<>();
				for (Long definedByOid : isDefinedByOids) {
					EClass eClass = databaseSession.getEClassForOid(definedByOid);
					if (getPackageMetaData().getEClass("IfcRelDefinesByProperties").isSuperTypeOf(eClass)) {
						HashMapVirtualObject ifcRelDefinesByProperties = getByOid(definedByOid);
						Long ifcPropertySetDefinition = (Long) ifcRelDefinesByProperties.get("RelatingPropertyDefinition");
						processPropertySet(databaseSession, propertyKeysMatched, ifcPropertySetDefinition);
					} else if (getPackageMetaData().getEClass("IfcRelDefinesByType").isSuperTypeOf(eClass)){
						HashMapVirtualObject ifcRelDefinesByType = getByOid(definedByOid);
						Long relatingTypeId = (Long) ifcRelDefinesByType.get("RelatingType");
						EClass eClassForOid = databaseSession.getEClassForOid(relatingTypeId);
						if (getPackageMetaData().getEClass("IfcTypeObject").isSuperTypeOf(eClassForOid)) {
							HashMapVirtualObject ifcTypeObject = getByOid(relatingTypeId);
							List<Long> propertySets = (List<Long>) ifcTypeObject.get("HasPropertySets");
							if (propertySets != null) {
								for (Long propertySetId : propertySets) {
									processPropertySet(databaseSession, propertyKeysMatched, propertySetId);
								}
							}
						}
					} else {
						LOGGER.info(eClass.getName());
					}
				}
				if (propertyKeysMatched.size() != totalQueryProperties) {
					// All properties should have matched, atm all properties provided in the query are evaluated as AND
					currentObject = null;
				}
			}
		}
		
		processPossibleIncludes(currentObject, eClass, getQueryPart());
		
		return false;
	}

	@SuppressWarnings("unchecked")
	private void processPropertySet(DatabaseSession databaseSession, Set<String> propertyKeysMatched, Long ifcPropertySetDefinition) throws BimserverDatabaseException {
		EClass eClassForOid = databaseSession.getEClassForOid(ifcPropertySetDefinition);
		if (getPackageMetaData().getEClass("IfcPropertySet").isSuperTypeOf(eClassForOid)) {
			HashMapVirtualObject ifcPropertySet = getByOid(ifcPropertySetDefinition);
			String propertySetName = (String) ifcPropertySet.get("Name");
			Properties propertiesObject = (Properties)properties.get(propertySetName);
			if (propertiesObject != null) {
				List<Long> properties = (List<Long>) ifcPropertySet.get("HasProperties");
				for (long propertyOid : properties) {
					if (getPackageMetaData().getEClass("IfcPropertySingleValue").isSuperTypeOf(databaseSession.getEClassForOid(propertyOid))) {
						HashMapVirtualObject property = getByOid(propertyOid);
						String name = (String) property.get("Name");
						HashMapWrappedVirtualObject value = (HashMapWrappedVirtualObject) property.get("NominalValue");
						if (propertiesObject.has(name)) {
							Object queryPropertyValue = propertiesObject.get(name);
							
							Object wrappedValue = value.eGet(value.eClass().getEStructuralFeature("wrappedValue"));
							if (value.eClass().getName().equals("IfcBoolean")) {
								Enumerator tristate = (Enumerator)wrappedValue;
								if (tristate.getName().toLowerCase().equals(queryPropertyValue.toString())) {
									propertyKeysMatched.add(propertySetName + "___" + name);
								}
							} else if (wrappedValue.equals(queryPropertyValue)) {
								propertyKeysMatched.add(propertySetName + "___" + name);
							}
						}
					}
				}
			}
		} else if (getPackageMetaData().getEClass("IfcPropertySetDefinition").isSuperTypeOf(eClassForOid)) {
			HashMapVirtualObject ifcPropertySet = getByOid(ifcPropertySetDefinition);
			Properties propertiesObject = (Properties)properties.get(ifcPropertySet.eClass().getName());
			if (propertiesObject != null) {
				for (String key : propertiesObject.keys()) {
					if (ifcPropertySet.has(key)) {
						if (ifcPropertySet.get(key).toString().equals(propertiesObject.get(key))) {
							propertyKeysMatched.add(ifcPropertySet.eClass().getName() + "___" + key);
						}
					}
				}
			}
		} else {
			LOGGER.info(eClassForOid.getName());
		}
	}
}

