package org.bimserver.plugins.schema;

public class DerivedAttribute2 {
	private String name;
	private BaseType type;
	private String expressCode;
	private final boolean collection;

	public DerivedAttribute2 (String name, BaseType type, String expressCode, boolean collection) {
		this.name = name;
		this.type = type;
		this.expressCode = expressCode;
		this.collection = collection;
	}

	public String getName() {
		return name;
	}
	
	public BaseType getType() {
		return type;
	}

	public String getExpressCode() {
		return expressCode;
	}
	
	public boolean isCollection() {
		return collection;
	}
}