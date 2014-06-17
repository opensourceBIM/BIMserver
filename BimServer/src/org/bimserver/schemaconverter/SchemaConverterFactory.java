package org.bimserver.schemaconverter;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.Schema;

public interface SchemaConverterFactory {
	SchemaConverter create(IfcModelInterface sourceModel, IfcModelInterface targetModel);

	Schema getSourceSchema();

	Schema getTargetSchema();
}