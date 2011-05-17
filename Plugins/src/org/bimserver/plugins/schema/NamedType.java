package org.bimserver.plugins.schema;


public abstract class NamedType implements BaseType, TypeOrRule {
 private String name = "";
 //TODO Where Rules

public NamedType(String name) {
	super();
	this.name = name;
}

public String getName() {
 	return name;
}

public void setName(String name) {
	this.name = name;
}
 
}
