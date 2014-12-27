package org.bimserver.schemaconverter;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.Schema;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;

public class Ifc4ToIfcIfc2x3tc1Converter extends AbstractSchemaConverter implements SchemaConverter {

	public Ifc4ToIfcIfc2x3tc1Converter(IfcModelInterface source, IfcModelInterface target) {
		super(source, target);
	}

	public void convert() throws SchemaConverterException, IfcModelInterfaceException {
		if (getSource().getPackageMetaData().getEPackage() != Ifc4Package.eINSTANCE) {
			throw new SchemaConverterException("Source model should be Ifc4");
		}
		if (getTarget().getPackageMetaData().getEPackage() != Ifc2x3tc1Package.eINSTANCE) {
			throw new SchemaConverterException("Target model should be Ifc2x3tc1");
		}

		for (IdEObject idEObject : getSource().getValues()) {
			copy(idEObject);
		}
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
