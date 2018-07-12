package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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
		EClass revisionClass = schema.getEClass("store", "Revision");
		
		EClass geometryInfo = schema.createEClass("geometry", "GeometryInfo");
		EClass vector3f = schema.createEClass("geometry", "Vector3f");
		schema.createEAttribute(vector3f, "x", EcorePackage.eINSTANCE.getEDouble(), Multiplicity.SINGLE);
		schema.createEAttribute(vector3f, "y", EcorePackage.eINSTANCE.getEDouble(), Multiplicity.SINGLE);
		schema.createEAttribute(vector3f, "z", EcorePackage.eINSTANCE.getEDouble(), Multiplicity.SINGLE);

		EClass bounds = schema.createEClass("geometry", "Bounds");
		EReference minRef = schema.createEReference(bounds, "min", vector3f);
		EReference maxRef = schema.createEReference(bounds, "max", vector3f);
		
		minRef.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		minRef.getEAnnotations().add(createEmbedsReferenceAnnotation());
		minRef.getEAnnotations().add(createHiddenAnnotation());

		maxRef.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		maxRef.getEAnnotations().add(createEmbedsReferenceAnnotation());
		maxRef.getEAnnotations().add(createHiddenAnnotation());
		
		EReference geometryInfoBounds = schema.createEReference(geometryInfo, "bounds", bounds, Multiplicity.SINGLE);
		geometryInfoBounds.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		geometryInfoBounds.getEAnnotations().add(createEmbedsReferenceAnnotation());
		geometryInfoBounds.getEAnnotations().add(createHiddenAnnotation());

		EReference geometryInfoBoundsUntransformed = schema.createEReference(geometryInfo, "boundsUntransformed", bounds, Multiplicity.SINGLE);
		geometryInfoBoundsUntransformed.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		geometryInfoBoundsUntransformed.getEAnnotations().add(createEmbedsReferenceAnnotation());
		geometryInfoBoundsUntransformed.getEAnnotations().add(createHiddenAnnotation());

		EReference concreteRevisionBounds = schema.createEReference(concreteRevisionClass, "bounds", bounds, Multiplicity.SINGLE);
		concreteRevisionBounds.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		concreteRevisionBounds.getEAnnotations().add(createEmbedsReferenceAnnotation());
		concreteRevisionBounds.getEAnnotations().add(createHiddenAnnotation());

		EReference concreteRevisionBoundsUntransformed = schema.createEReference(concreteRevisionClass, "boundsUntransformed", bounds, Multiplicity.SINGLE);
		concreteRevisionBoundsUntransformed.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		concreteRevisionBoundsUntransformed.getEAnnotations().add(createEmbedsReferenceAnnotation());
		concreteRevisionBoundsUntransformed.getEAnnotations().add(createHiddenAnnotation());

		EReference revisionBounds = schema.createEReference(revisionClass, "bounds", bounds, Multiplicity.SINGLE);
		revisionBounds.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		revisionBounds.getEAnnotations().add(createEmbedsReferenceAnnotation());
		revisionBounds.getEAnnotations().add(createHiddenAnnotation());

		EReference revisionBoundsUntransformed = schema.createEReference(revisionClass, "boundsUntransformed", bounds, Multiplicity.SINGLE);
		revisionBoundsUntransformed.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		revisionBoundsUntransformed.getEAnnotations().add(createEmbedsReferenceAnnotation());
		revisionBoundsUntransformed.getEAnnotations().add(createHiddenAnnotation());

		EReference revisionBoundsMm = schema.createEReference(revisionClass, "boundsMm", bounds, Multiplicity.SINGLE);
		revisionBoundsMm.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		revisionBoundsMm.getEAnnotations().add(createEmbedsReferenceAnnotation());
		revisionBoundsMm.getEAnnotations().add(createHiddenAnnotation());
		
		EReference revisionBoundsUntransformedMm = schema.createEReference(revisionClass, "boundsUntransformedMm", bounds, Multiplicity.SINGLE);
		revisionBoundsUntransformedMm.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		revisionBoundsUntransformedMm.getEAnnotations().add(createEmbedsReferenceAnnotation());
		revisionBoundsUntransformedMm.getEAnnotations().add(createHiddenAnnotation());

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