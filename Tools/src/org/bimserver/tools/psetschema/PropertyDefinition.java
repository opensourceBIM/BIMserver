package org.bimserver.tools.psetschema;

public class PropertyDefinition {

	private String name;
	private String definition;
	private PropertyTypeDefinition type;

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	public String getDefinition() {
		return definition;
	}

	public PropertyTypeDefinition getType() {
		return type;
	}

	public void setType(PropertyTypeDefinition type) {
		this.type = type;
	}
}