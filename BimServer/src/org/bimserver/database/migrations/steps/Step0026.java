package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0026 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass bounds = schema.createEClass("ifc2x3tc1", "Bounds");
		EClass vector3f = schema.createEClass("ifc2x3tc1", "Vector3f");
		schema.createEAttribute(vector3f, "x", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
		schema.createEAttribute(vector3f, "y", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
		schema.createEAttribute(vector3f, "z", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
		EReference min = schema.createEReference(bounds, "min", vector3f, Multiplicity.SINGLE);
		min.getEAnnotations().add(createEmbedsReferenceAnnotation());
		min.getEAnnotations().add(createHiddenAnnotation());
		EReference max = schema.createEReference(bounds, "max", vector3f, Multiplicity.SINGLE);
		max.getEAnnotations().add(createEmbedsReferenceAnnotation());
		max.getEAnnotations().add(createHiddenAnnotation());
		vector3f.getEAnnotations().add(createHiddenAnnotation());
		bounds.getEAnnotations().add(createHiddenAnnotation());
		
		EClass geometryInstance = schema.createEClass("ifc2x3tc1", "GeometryInstance");
		schema.createEAttribute(geometryInstance, "startVertex", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "startIndex", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "primitiveCount", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "indices", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "vertices", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "normals", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		geometryInstance.getEAnnotations().add(createHiddenAnnotation());

		EClass revision = schema.getEClass("store", "Revision");
		schema.createEAttribute(revision, "hasGeometry", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);

		EClass ifcProduct = schema.getEClass("ifc2x3tc1", "IfcProduct");
		schema.createEReference(ifcProduct, "geometryInstance", geometryInstance, Multiplicity.SINGLE).getEAnnotations().add(createHiddenAnnotation());
		schema.createEReference(ifcProduct, "bounds", bounds, Multiplicity.SINGLE).getEAnnotations().add(createHiddenAnnotation());
	}

	@Override
	public String getDescription() {
		return "Caching geometry";
	}
}