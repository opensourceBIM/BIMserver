package org.bimserver.tools.psetschema;

import org.bimserver.tools.ifctocsv.PropertyType.TypePropertyBoundedValue;

public class BoundedValue extends PropertyTypeDefinition {

	private TypePropertyBoundedValue typePropertyBoundedValue;

	public BoundedValue(TypePropertyBoundedValue typePropertyBoundedValue) {
		this.typePropertyBoundedValue = typePropertyBoundedValue;
	}

	@Override
	public String toString() {
		return "bounded: " + typePropertyBoundedValue.getDataType().getType();
	}
}
