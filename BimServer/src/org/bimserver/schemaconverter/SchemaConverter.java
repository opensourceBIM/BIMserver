package org.bimserver.schemaconverter;

import org.bimserver.emf.Schema;

public interface SchemaConverter {
	Schema getSourceSchema();
	Schema getTargetSchema();
}
