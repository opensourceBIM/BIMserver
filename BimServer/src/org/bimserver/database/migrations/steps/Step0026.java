package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0026 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass geometry = schema.createEClass("store", "Geometry");
		EAttribute indices = schema.createEAttribute(geometry, "indices", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.MANY);
		indices.setUnique(false);
		EAttribute vertices = schema.createEAttribute(geometry, "vertices", EcorePackage.eINSTANCE.getEFloatObject(), Multiplicity.MANY);
		vertices.setUnique(false);
		EAttribute normals = schema.createEAttribute(geometry, "normals", EcorePackage.eINSTANCE.getEFloatObject(), Multiplicity.MANY);
		normals.setUnique(false);

		EClass geometryInstance = schema.createEClass("ifc2x3tc1", "GeometryInstance");
		schema.createEAttribute(geometryInstance, "startVertex", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "startIndex", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "primitiveCount", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);

		EClass revision = schema.getEClass("store", "Revision");
		schema.createEReference(revision, "geometry", geometry, Multiplicity.SINGLE);

		EClass ifcProduct = schema.getEClass("ifc2x3tc1", "IfcProduct");
		schema.createEReference(ifcProduct, "geometryInstance", geometryInstance, Multiplicity.SINGLE).getEAnnotations().add(createHiddenReference());
	}

	@Override
	public String getDescription() {
		return "Caching geometry";
	}
}
