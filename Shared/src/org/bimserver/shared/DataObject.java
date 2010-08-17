package org.bimserver.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataObject {

	private final String type;
	private final long oid;
	private final String guid;
	private final Map<String, DataValue> values = new TreeMap<String, DataValue>();
	private final String name;

	public DataObject(String className, long oid, String guid, String name) {
		this.type = className;
		this.oid = oid;
		this.guid = guid;
		this.name = name;
	}

	public static class DataValue {
	}

	public static class ReferenceDataValue extends DataValue {
		private final String typeName;
		private final long oid;
		private final String guid;

		public ReferenceDataValue(String typeName, long oid, String guid) {
			this.typeName = typeName;
			this.oid = oid;
			this.guid = guid;
		}

		public String getTypeName() {
			return typeName;
		}

		public long getOid() {
			return oid;
		}

		public String getGuid() {
			return guid;
		}
	}
	
	public static class ListDataValue extends DataValue {

		private final List<DataValue> values = new ArrayList<DataValue>();
		
		public void addValue(String typeName, long oid, String guid) {
			getValues().add(new ReferenceDataValue(typeName, oid, guid));
		}

		public void addValue(Object value) {
			getValues().add(new SimpleDataValue(value));
		}

		public List<DataValue> getValues() {
			return values;
		}
	}

	public static class SimpleDataValue extends DataValue {
		private String stringValue;

		public SimpleDataValue(Object value) {
			if (value instanceof String) {
				stringValue = (String) value;
			} else if (value != null) {
				stringValue = value.toString();
			} else {
				stringValue = "";
			}
		}

		public String toString() {
			return stringValue;
		}
	}

	public void addField(String name, DataValue dataValue) {
		values.put(name, dataValue);
	}

	public String getType() {
		return type;
	}

	public Map<String, DataValue> getFields() {
		return values;
	}

	public long getOid() {
		return oid;
	}

	public String getGuid() {
		return guid;
	}

	public String getName() {
		return name;
	}
}