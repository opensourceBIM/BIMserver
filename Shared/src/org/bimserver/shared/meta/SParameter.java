package org.bimserver.shared.meta;

public class SParameter {

	private final Class<?> type;

	public SParameter(Class<?> type) {
		this.type = type;
	}

	public Class<?> getType() {
		return type;
	}

	public SClass getObjectType() {
		return null;
	}
}
