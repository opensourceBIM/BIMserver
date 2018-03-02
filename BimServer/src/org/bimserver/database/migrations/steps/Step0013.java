package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0013 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		schema.loadEcore("ifc4.ecore", getClass().getResourceAsStream("IFC4_ADD2.ecore"));
		EClass project = schema.getEClass("store", "Project");
		schema.createEAttribute(project, "schema", EcorePackage.eINSTANCE.getEString());
		EClass revisionSummaryType = schema.getEClass("store", "RevisionSummaryType");
		schema.createEAttribute(revisionSummaryType, "schema", EcorePackage.eINSTANCE.getEString());
		EClass projectSmall = schema.getEClass("store", "ProjectSmall");
		schema.createEAttribute(projectSmall, "schema", EcorePackage.eINSTANCE.getEString());
		
		schema.createEPackage("geometry");
		
		EClass concreteRevisionClass = schema.getEClass("store", "ConcreteRevision");
		
		EClass geometryInfo = schema.createEClass("geometry", "GeometryInfo");
		EClass vector3f = schema.createEClass("geometry", "Vector3f");
		schema.createEAttribute(vector3f, "x", EcorePackage.eINSTANCE.getEDouble(), Multiplicity.SINGLE);
		schema.createEAttribute(vector3f, "y", EcorePackage.eINSTANCE.getEDouble(), Multiplicity.SINGLE);
		schema.createEAttribute(vector3f, "z", EcorePackage.eINSTANCE.getEDouble(), Multiplicity.SINGLE);

		EReference geometryInfoMinBounds = schema.createEReference(geometryInfo, "minBounds", vector3f, Multiplicity.SINGLE);
		geometryInfoMinBounds.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		geometryInfoMinBounds.getEAnnotations().add(createEmbedsReferenceAnnotation());
		geometryInfoMinBounds.getEAnnotations().add(createHiddenAnnotation());
		
		EReference geometryInfoMaxBounds = schema.createEReference(geometryInfo, "maxBounds", vector3f, Multiplicity.SINGLE);
		geometryInfoMaxBounds.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		geometryInfoMaxBounds.getEAnnotations().add(createEmbedsReferenceAnnotation());
		geometryInfoMaxBounds.getEAnnotations().add(createHiddenAnnotation());

		EReference concreteRevisionMinBounds = schema.createEReference(concreteRevisionClass, "minBounds", vector3f, Multiplicity.SINGLE);
		concreteRevisionMinBounds.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		concreteRevisionMinBounds.getEAnnotations().add(createEmbedsReferenceAnnotation());
		concreteRevisionMinBounds.getEAnnotations().add(createHiddenAnnotation());

		EReference concreteRevisionMaxBounds = schema.createEReference(concreteRevisionClass, "maxBounds", vector3f, Multiplicity.SINGLE);
		concreteRevisionMaxBounds.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		concreteRevisionMaxBounds.getEAnnotations().add(createEmbedsReferenceAnnotation());
		concreteRevisionMaxBounds.getEAnnotations().add(createHiddenAnnotation());
		
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
		EReference ifc2x3Geometry = schema.createEReference(ifcProductIfc2x3tc1, "geometry", geometryInfo, Multiplicity.SINGLE);
		ifc2x3Geometry.setUnsettable(true);
		ifc2x3Geometry.getEAnnotations().add(createHiddenAnnotation());
		EReference ifc4Geometry = schema.createEReference(ifcProductIfc4, "geometry", geometryInfo, Multiplicity.SINGLE);
		ifc4Geometry.setUnsettable(true);
		ifc4Geometry.getEAnnotations().add(createHiddenAnnotation());
		
		schema.createEAttribute(geometryData, "materials", EcorePackage.eINSTANCE.getEByteArray());
		schema.createEAttribute(geometryData, "materialIndices", EcorePackage.eINSTANCE.getEByteArray());
		schema.createEAttribute(geometryInfo, "transformation", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Initial IFC4 model";
	}
}