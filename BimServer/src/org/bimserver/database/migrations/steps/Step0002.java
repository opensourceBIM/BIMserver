package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0002 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass geometry = schema.createEClass("ifc2x3tc1", "GeometryInfo");
		EClass vector3f = schema.createEClass("ifc2x3tc1", "Vector3f");
		schema.createEAttribute(vector3f, "x", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
		schema.createEAttribute(vector3f, "y", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
		schema.createEAttribute(vector3f, "z", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
		EReference min = schema.createEReference(geometry, "minBounds", vector3f, Multiplicity.SINGLE);
		min.getEAnnotations().add(createEmbedsReferenceAnnotation());
		min.getEAnnotations().add(createHiddenAnnotation());
		EReference max = schema.createEReference(geometry, "maxBounds", vector3f, Multiplicity.SINGLE);
		max.getEAnnotations().add(createEmbedsReferenceAnnotation());
		max.getEAnnotations().add(createHiddenAnnotation());
		vector3f.getEAnnotations().add(createHiddenAnnotation());
		geometry.getEAnnotations().add(createHiddenAnnotation());
		schema.createEAttribute(geometry, "startVertex", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geometry, "startIndex", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geometry, "primitiveCount", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		
		EClass geometryData = schema.createEClass("ifc2x3tc1", "GeometryData");
		schema.createEAttribute(geometryData, "indices", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryData, "vertices", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryData, "normals", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		geometryData.getEAnnotations().add(createHiddenAnnotation());

		schema.createEReference(geometry, "data", geometryData, Multiplicity.SINGLE);

		EClass revision = schema.getEClass("store", "Revision");
		schema.createEAttribute(revision, "hasGeometry", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);

		EClass ifcProduct = schema.getEClass("ifc2x3tc1", "IfcProduct");
		schema.createEReference(ifcProduct, "geometry", geometry, Multiplicity.SINGLE).getEAnnotations().add(createHiddenAnnotation());
	}

	@Override
	public String getDescription() {
		return "A few additions to the IFC2x3tc1 schema";
	}
}
