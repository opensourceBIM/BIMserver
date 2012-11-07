package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0026 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass bounds = schema.createEClass("store", "Bounds");
		EClass vector3f = schema.createEClass("store", "Vector3f");
		schema.createEAttribute(vector3f, "x", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
		schema.createEAttribute(vector3f, "y", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
		schema.createEAttribute(vector3f, "z", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
		schema.createEReference(bounds, "min", vector3f, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEReference(bounds, "max", vector3f, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		bounds.getEAnnotations().add(createHiddenAnnotation());

		EClass geometry = schema.createEClass("store", "Geometry");
		schema.createEAttribute(geometry, "indices", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.MANY).setUnique(false);
		schema.createEAttribute(geometry, "vertices", EcorePackage.eINSTANCE.getEFloatObject(), Multiplicity.MANY).setUnique(false);
		schema.createEAttribute(geometry, "normals", EcorePackage.eINSTANCE.getEFloatObject(), Multiplicity.MANY).setUnique(false);
		geometry.getEAnnotations().add(createHiddenAnnotation());

		EClass geometryInstance = schema.createEClass("ifc2x3tc1", "GeometryInstance");
		schema.createEAttribute(geometryInstance, "startVertex", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "startIndex", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "primitiveCount", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "indices", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "vertices", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "normals", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		geometryInstance.getEAnnotations().add(createHiddenAnnotation());

		EClass revision = schema.getEClass("store", "Revision");
		schema.createEReference(revision, "geometry", geometry, Multiplicity.SINGLE).getEAnnotations().add(createHiddenAnnotation());
		schema.createEReference(revision, "bounds", bounds, Multiplicity.SINGLE).getEAnnotations().add(createHiddenAnnotation());

		EClass ifcProduct = schema.getEClass("ifc2x3tc1", "IfcProduct");
		schema.createEReference(ifcProduct, "geometryInstance", geometryInstance, Multiplicity.SINGLE).getEAnnotations().add(createHiddenAnnotation());
		schema.createEReference(ifcProduct, "bounds", bounds, Multiplicity.SINGLE).getEAnnotations().add(createHiddenAnnotation());
	}

	@Override
	public String getDescription() {
		return "Caching geometry";
	}
}