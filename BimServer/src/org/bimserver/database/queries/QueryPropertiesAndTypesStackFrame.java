package org.bimserver.database.queries;

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
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.QueryException;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EClass;

public class QueryPropertiesAndTypesStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {

	private EClass eClass;
	private SearchingRecordIterator typeRecordIterator;
	private Record record;
	private Map<String, Object> properties;

	public QueryPropertiesAndTypesStackFrame(QueryObjectProvider queryObjectProvider, EClass eClass, QueryPart queryPart, QueryContext reusable, Map<String, Object> properties) throws BimserverDatabaseException {
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
			Set<String> propertyKeysMatched = new HashSet<>();
			for (Long definedByOid : isDefinedByOids) {
				EClass eClass = databaseSession.getEClassForOid(definedByOid);
				if (getPackageMetaData().getEClass("IfcRelDefinesByProperties").isSuperTypeOf(eClass)) {
					HashMapVirtualObject ifcRelDefinesByProperties = getByOid(definedByOid);
					Long ifcPropertySetDefinition = (Long) ifcRelDefinesByProperties.get("RelatingPropertyDefinition");
					if (getPackageMetaData().getEClass("IfcPropertySet").isSuperTypeOf(databaseSession.getEClassForOid(ifcPropertySetDefinition))) {
						HashMapVirtualObject ifcPropertySet = getByOid(ifcPropertySetDefinition);
						List<Long> properties = (List<Long>) ifcPropertySet.get("HasProperties");
						for (long propertyOid : properties) {
							if (getPackageMetaData().getEClass("IfcPropertySingleValue").isSuperTypeOf(databaseSession.getEClassForOid(propertyOid))) {
								HashMapVirtualObject property = getByOid(propertyOid);
								String name = (String) property.get("Name");
								HashMapWrappedVirtualObject value = (HashMapWrappedVirtualObject) property.get("NominalValue");
								for (String queryPropertyName : this.properties.keySet()) {
									Object queryPropertyValue = this.properties.get(queryPropertyName);
									if (queryPropertyName.equals(name)) {
										Object wrappedValue = value.eGet(value.eClass().getEStructuralFeature("wrappedValue"));
										if (value.eClass().getName().equals("IfcBoolean")) {
											Tristate tristate = (Tristate)wrappedValue;
											if (tristate.name().toLowerCase().equals(queryPropertyValue.toString())) {
												propertyKeysMatched.add(queryPropertyName);
											}
										} else if (wrappedValue.equals(queryPropertyValue)) {
											propertyKeysMatched.add(queryPropertyName);
										}
									}
								}
							}
						}
					}
				}
			}
			if (propertyKeysMatched.size() != this.properties.size()) {
				currentObject = null;
			}
		}
		
		processPossibleIncludes(eClass, getQueryPart());
		
		return false;
	}
}