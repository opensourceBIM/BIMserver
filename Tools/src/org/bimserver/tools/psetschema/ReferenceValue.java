package org.bimserver.tools.psetschema;

import org.bimserver.tools.ifctocsv.ReferenceSelect;

public class ReferenceValue extends PropertyTypeDefinition {

	private ReferenceSelect typePropertyReferenceValue;

	public ReferenceValue(ReferenceSelect typePropertyReferenceValue) {
		this.typePropertyReferenceValue = typePropertyReferenceValue;
	}
	
	@Override
	public String toString() {
		return "reference: " + typePropertyReferenceValue.getReftype();
	}
}