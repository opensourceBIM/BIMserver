package org.bimserver.plugins.schema;
import java.util.HashSet;


public class EnumerationType extends DefinedType implements ConstructedType {

private HashSet<String> elements = new HashSet<String>();

public EnumerationType(String name, UnderlyingType domain) {
	super(name, domain);
	// TODO Auto-generated constructor stub
}

public EnumerationType(String name) {
	super(name);
	// TODO Auto-generated constructor stub
}

public void addElement(String e){
	elements.add(e);
}

public HashSet<String> getElements() {
	return elements;
}

public void setElements(HashSet<String> elements) {
	this.elements = elements;
}
}
