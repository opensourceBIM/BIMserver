package org.bimserver.shared.meta;

import java.util.HashMap;
import java.util.Map;

public class SClass {
	private final Map<String, SField> fields = new HashMap<String, SField>();
	private final String name;
	
	public SClass(String name) {
		this.name = name;
	}
	
	public void addField(SField sField) {
		fields.put(sField.getName(), sField);
	}
	
	public String getName() {
		return name;
	}
	
	public SField getField(String name) {
		return fields.get(name);
	}
}
