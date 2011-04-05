package org.bimserver.shared;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class SDataObject {

	@XmlElement
	private String type;

	@XmlElement
	private long oid;

	@XmlElement
	private String guid;

	@XmlElement
	private List<SDataValue> values = new ArrayList<SDataValue>();

	@XmlElement
	private String name;

	public SDataObject() {
	}

	public SDataObject(String className, long oid, String guid, String name) {
		this.setType(className);
		this.setOid(oid);
		this.setGuid(guid);
		this.setName(name);
	}

	@XmlRootElement
	@XmlAccessorType(XmlAccessType.NONE)
	public static class SDataValue {
		@XmlElement
		private String fieldName;

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getFieldName() {
			return fieldName;
		}
	}

	@XmlRootElement
	@XmlAccessorType(XmlAccessType.NONE)
	public static class SReferenceDataValue extends SDataValue {
		@XmlElement
		private final String typeName;

		@XmlElement
		private final long oid;

		@XmlElement
		private final String guid;

		public SReferenceDataValue(String typeName, long oid, String guid) {
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

	@XmlRootElement
	@XmlAccessorType(XmlAccessType.NONE)
	public static class SListDataValue extends SDataValue {

		public SListDataValue() {
		}
		
		public SListDataValue(String fieldName) {
			setFieldName(fieldName);
		}
		
		@XmlElement
		private final List<SDataValue> values = new ArrayList<SDataValue>();

		public void addValue(String typeName, long oid, String guid) {
			getValues().add(new SReferenceDataValue(typeName, oid, guid));
		}

		public void addValue(Object value) {
			getValues().add(new SSimpleDataValue(value));
		}

		public List<SDataValue> getValues() {
			return values;
		}
	}

	@XmlRootElement
	@XmlAccessorType(XmlAccessType.NONE)
	public static class SSimpleDataValue extends SDataValue {
		@XmlElement
		private String stringValue;

		public SSimpleDataValue(Object value) {
			if (value instanceof String) {
				setStringValue((String) value);
			} else if (value != null) {
				setStringValue(value.toString());
			} else {
				setStringValue("");
			}
		}

		public void setStringValue(String stringValue) {
			this.stringValue = stringValue;
		}

		public String getStringValue() {
			return stringValue;
		}
	}

	public String getType() {
		return type;
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

	public void setValues(List<SDataValue> values) {
		this.values = values;
	}

	public List<SDataValue> getValues() {
		return values;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}
}