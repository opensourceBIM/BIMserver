package org.bimserver.tools.psetschema;

import org.bimserver.tools.ifctocsv.PropertyType.TypePropertyTableValue;

public class TableValue extends PropertyTypeDefinition {

	private TypePropertyTableValue typePropertyTableValue;

	public TableValue(TypePropertyTableValue typePropertyTableValue) {
		this.typePropertyTableValue = typePropertyTableValue;
	}
	
	@Override
	public String toString() {
		return "table: " + typePropertyTableValue.getDefinedValue().getDataType().getType();
	}
}
