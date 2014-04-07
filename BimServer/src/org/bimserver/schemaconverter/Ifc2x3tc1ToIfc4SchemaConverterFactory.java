package org.bimserver.schemaconverter;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.Schema;

public class Ifc2x3tc1ToIfc4SchemaConverterFactory implements SchemaConverterFactory {

	@Override
	public SchemaConverter create(IfcModelInterface sourceModel, IfcModelInterface targetModel) {
		return new Ifc2x3tc1ToIfc4Converter(sourceModel, targetModel);
	}

	@Override
	public Schema getSourceSchema() {
		return Schema.IFC2X3TC1;
	}

	@Override
	public Schema getTargetSchema() {
		return Schema.IFC4;
	}
}