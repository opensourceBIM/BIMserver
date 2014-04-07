package org.bimserver.schemaconverter;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.Schema;

public class Ifc4ToIfc2x3tc1SchemaConverterFactory implements SchemaConverterFactory {

	@Override
	public SchemaConverter create(IfcModelInterface sourceModel, IfcModelInterface targetModel) {
		return new Ifc4ToIfcIfc2x3tc1Converter(sourceModel, targetModel);
	}

	@Override
	public Schema getSourceSchema() {
		return Schema.IFC4;
	}

	@Override
	public Schema getTargetSchema() {
		return Schema.IFC2X3TC1;
	}
}