package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0013 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		schema.loadEcore("ifc4.ecore", getClass().getResourceAsStream("IFC4.ecore"));
		EClass project = schema.getEClass("store", "Project");
		schema.createEAttribute(project, "schema", EcorePackage.eINSTANCE.getEString());
		EClass revisionSummaryType = schema.getEClass("store", "RevisionSummaryType");
		schema.createEAttribute(revisionSummaryType, "schema", EcorePackage.eINSTANCE.getEString());
		EClass projectSmall = schema.getEClass("store", "ProjectSmall");
		schema.createEAttribute(projectSmall, "schema", EcorePackage.eINSTANCE.getEString());
		
		schema.createEPackage("geometry");
		
		EClass geometryInfo = schema.createEClass("geometry", "GeometryInfo");
		EClass vector3f = schema.createEClass("geometry", "Vector3f");
		schema.createEAttribute(vector3f, "x", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
		schema.createEAttribute(vector3f, "y", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
		schema.createEAttribute(vector3f, "z", EcorePackage.eINSTANCE.getEFloat(), Multiplicity.SINGLE);
		EReference min = schema.createEReference(geometryInfo, "minBounds", vector3f, Multiplicity.SINGLE);
		min.getEAnnotations().add(createEmbedsReferenceAnnotation());
		min.getEAnnotations().add(createHiddenAnnotation());
		EReference max = schema.createEReference(geometryInfo, "maxBounds", vector3f, Multiplicity.SINGLE);
		max.getEAnnotations().add(createEmbedsReferenceAnnotation());
		max.getEAnnotations().add(createHiddenAnnotation());
		vector3f.getEAnnotations().add(createHiddenAnnotation());
		geometryInfo.getEAnnotations().add(createHiddenAnnotation());
		schema.createEAttribute(geometryInfo, "startVertex", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInfo, "startIndex", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInfo, "primitiveCount", EcorePackage.eINSTANCE.getEIntegerObject(), Multiplicity.SINGLE);
		
		EClass geometryData = schema.createEClass("geometry", "GeometryData");
		schema.createEAttribute(geometryData, "indices", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryData, "vertices", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(geometryData, "normals", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		geometryData.getEAnnotations().add(createNoLazyLoadAnnotation());
		geometryData.getEAnnotations().add(createHiddenAnnotation());

		schema.createEReference(geometryInfo, "data", geometryData, Multiplicity.SINGLE).getEAnnotations().add(createNoLazyLoadAnnotation());

		EClass ifcProductIfc2x3tc1 = schema.getEClass("ifc2x3tc1", "IfcProduct");
		EClass ifcProductIfc4 = schema.getEClass("ifc4", "IfcProduct");
		schema.createEReference(ifcProductIfc2x3tc1, "geometry", geometryInfo, Multiplicity.SINGLE).getEAnnotations().add(createHiddenAnnotation());
		schema.createEReference(ifcProductIfc4, "geometry", geometryInfo, Multiplicity.SINGLE).getEAnnotations().add(createHiddenAnnotation());
		
		EClass geometryInstance = schema.createEClass("geometry", "GeometryInstance");
		schema.createEReference(geometryInstance, "data", schema.getEClass("geometry", "GeometryData"), Multiplicity.SINGLE);
		schema.createEAttribute(geometryInstance, "transformation", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		geometryInstance.getEAnnotations().add(createHiddenAnnotation());
		
		schema.createEReference(schema.getEClass("geometry", "GeometryInfo"), "instance", geometryInstance, Multiplicity.SINGLE);
		schema.createEAttribute(geometryData, "materials", EcorePackage.eINSTANCE.getEByteArray());
		schema.createEAttribute(geometryData, "materialIndices", EcorePackage.eINSTANCE.getEByteArray());
		schema.createEAttribute(geometryInfo, "transformation", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Initial IFC4 model";
	}
}