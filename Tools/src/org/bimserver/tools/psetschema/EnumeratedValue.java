package org.bimserver.tools.psetschema;

import org.bimserver.tools.ifctocsv.PropertyType.TypePropertyEnumeratedValue;

public class EnumeratedValue extends PropertyTypeDefinition {

	private TypePropertyEnumeratedValue typePropertyEnumeratedValue;

	public EnumeratedValue(TypePropertyEnumeratedValue typePropertyEnumeratedValue) {
		this.typePropertyEnumeratedValue = typePropertyEnumeratedValue;
	}

	@Override
	public String toString() {
		return "enum: " + typePropertyEnumeratedValue.getEnumList().getName();
	}
}
