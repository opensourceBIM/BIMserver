package org.bimserver.shared.meta;

public class SField {
	private String name;
	private final Class<?> type;
	private final boolean many;
	
	public SField(String name, Class<?> type) {
		this(name, type, false);
	}

	public SField(String name, Class<?> type, boolean many) {
		this.name = name;
		this.type = type;
		this.many = many;
	}

	public boolean isMany() {
		return many;
	}
	
	public Class<?> getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
}
