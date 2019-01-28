package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0002 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
//		EClass geometry = schema.createEClass("ifc2x3tc1", "GeometryInfo");
//		EClass vector3f = schema.createEClass("ifc2x3tc1", "Vector3f");
//		schema.createEAttribute(vector3f, "x", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
//		schema.createEAttribute(vector3f, "y", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
//		schema.createEAttribute(vector3f, "z", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
//		EReference min = schema.createEReference(geometry, "minBounds", vector3f, Multiplicity.SINGLE);
//		min.getEAnnotations().add(createEmbedsReferenceAnnotation());
//		min.getEAnnotations().add(createHiddenAnnotation());
//		EReference max = schema.createEReference(geometry, "maxBounds", vector3f, Multiplicity.SINGLE);
//		max.getEAnnotations().add(createEmbedsReferenceAnnotation());
//		max.getEAnnotations().add(createHiddenAnnotation());
//		vector3f.getEAnnotations().add(createHiddenAnnotation());
//		geometry.getEAnnotations().add(createHiddenAnnotation());
//		schema.createEAttribute(geometry, "startVertex", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
//		schema.createEAttribute(geometry, "startIndex", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
//		schema.createEAttribute(geometry, "primitiveCount", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
//		
//		EClass geometryData = schema.createEClass("ifc2x3tc1", "GeometryData");
//		schema.createEAttribute(geometryData, "indices", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
//		schema.createEAttribute(geometryData, "vertices", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
//		schema.createEAttribute(geometryData, "normals", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
//		geometryData.getEAnnotations().add(createNoLazyLoadAnnotation());
//		geometryData.getEAnnotations().add(createHiddenAnnotation());
//
//		schema.createEReference(geometry, "data", geometryData, Multiplicity.SINGLE).getEAnnotations().add(createNoLazyLoadAnnotation());
//
		EClass revision = schema.getEClass("store", "Revision");
		schema.createEAttribute(revision, "hasGeometry", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
//
//		EClass ifcProduct = schema.getEClass("ifc2x3tc1", "IfcProduct");
//		schema.createEReference(ifcProduct, "geometry", geometry, Multiplicity.SINGLE).getEAnnotations().add(createHiddenAnnotation());
	}

	@Override
	public String getDescription() {
		return "A few additions to the IFC2x3tc1 schema";
	}
}