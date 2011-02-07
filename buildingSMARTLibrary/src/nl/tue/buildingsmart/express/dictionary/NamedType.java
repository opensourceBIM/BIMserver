package nl.tue.buildingsmart.express.dictionary;


public abstract class NamedType implements nl.tue.buildingsmart.express.dictionary.BaseType, nl.tue.buildingsmart.express.dictionary.TypeOrRule {
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
