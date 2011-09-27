package org.bimserver.shared.meta;

public class SParameter {

	private final Class<?> type;
	private SClass sClassType;

	public SParameter(Class<?> type) {
		this.type = type;
		sClassType = SPackage.getInstance().getSClass(type.getSimpleName());
	}

	public Class<?> getType() {
		return type;
	}

	public SClass getObjectType() {
		return sClassType;
	}
}