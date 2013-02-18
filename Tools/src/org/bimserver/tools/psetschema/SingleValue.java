package org.bimserver.tools.psetschema;

import org.bimserver.tools.ifctocsv.PropertyType.TypePropertySingleValue;

public class SingleValue extends PropertyTypeDefinition {

	private TypePropertySingleValue typePropertySingleValue;

	public SingleValue(TypePropertySingleValue typePropertySingleValue) {
		this.typePropertySingleValue = typePropertySingleValue;
	}
	
	@Override
	public String toString() {
		return "single: " + typePropertySingleValue.getDataType().getType();
	}
}