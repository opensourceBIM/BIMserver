package org.bimserver.schemaconverter;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.ObjectFactory;
import org.bimserver.emf.Schema;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.plugins.ModelHelper;
import org.eclipse.emf.ecore.EClass;

public class Ifc2x3tc1ToIfc4Converter implements SchemaConverter {
	public void convert(IfcModelInterface source, final IfcModelInterface target) throws SchemaConverterException, IfcModelInterfaceException {
		if (source.getPackageMetaData().getEPackage() != Ifc2x3tc1Package.eINSTANCE) {
			throw new SchemaConverterException("Source model should be Ifc2x3tc1");
		}
		if (target.getPackageMetaData().getEPackage() != Ifc4Package.eINSTANCE) {
			throw new SchemaConverterException("Target model should be Ifc4");
		}
		ModelHelper modelHelper = new ModelHelper(target);
		modelHelper.setObjectFactory(new ObjectFactory() {
			@Override
			public <T extends IdEObject> T create(EClass eClass) throws IfcModelInterfaceException {
				return (T) target.getPackageMetaData().create(eClass);
			}
			
			@Override
			public <T extends IdEObject> T create(Class<T> clazz) throws IfcModelInterfaceException {
				return (T) target.getPackageMetaData().create(clazz);
			}
		});

		for (IdEObject idEObject : source.getValues()) {
			modelHelper.copy(idEObject);
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
