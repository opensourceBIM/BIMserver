package org.bimserver.schemaconverter;

import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.Schema;

public interface SchemaConverter {
	Schema getSourceSchema();
	Schema getTargetSchema();
	void convert() throws SchemaConverterException, IfcModelInterfaceException;
}
