package org.bimserver.tools.psetschema;

public class ListValue extends PropertyTypeDefinition {

	private org.bimserver.tools.ifctocsv.PropertyType.TypePropertyListValue.ListValue listValue;

	public ListValue(org.bimserver.tools.ifctocsv.PropertyType.TypePropertyListValue.ListValue listValue) {
		this.listValue = listValue;
	}

	@Override
	public String toString() {
		return "list: " + listValue.getDataType().getType();
	}
}
