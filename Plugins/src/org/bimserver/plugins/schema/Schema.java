package org.bimserver.plugins.schema;

public interface Schema {

	EntityDefinition getEntityBNNoCaseConvert(String string);

	EntityDefinition getEntityBN(String name);
}