package org.bimserver.shared.reflector;

public class KeyValuePair {
	private String fieldName;
	private Object value;

	public KeyValuePair(String fieldName, Object value) {
		this.fieldName = fieldName;
		this.value = value;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public Object getValue() {
		return value;
	}
}
