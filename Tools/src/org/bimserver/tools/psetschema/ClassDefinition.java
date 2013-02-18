package org.bimserver.tools.psetschema;

import java.util.ArrayList;
import java.util.List;

public class ClassDefinition {

	private String name;
	private final List<PropertyDefinition> propertyDefinitions = new ArrayList<PropertyDefinition>();

	public ClassDefinition(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void add(PropertyDefinition propertyDefinition) {
		propertyDefinitions.add(propertyDefinition);
	}
	
	public List<PropertyDefinition> getPropertyDefinitions() {
		return propertyDefinitions;
	}
}