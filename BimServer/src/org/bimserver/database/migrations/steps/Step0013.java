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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0013 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		schema.loadEcore("ifc4.ecore", getClass().getResourceAsStream("IFC4_ADD2.ecore"));
		
		for (EClassifier eClassifier : schema.getEPackage("ifc4").getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
					// A hack because unfortunately not every "Name" field inherits from IfcRoot.Name, same could be true for GlobalId
					if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
						if (eStructuralFeature.getName().equals("Name") || eStructuralFeature.getName().equals("GlobalId")) {
							schema.addIndex(eStructuralFeature);
						}
					}
				}
			}
		}
		
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

		EReference revisionBounds = schema.createEReference(revisionClass, "bounds", bounds);
		revisionBounds.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		revisionBounds.getEAnnotations().add(createEmbedsReferenceAnnotation());
		revisionBounds.getEAnnotations().add(createHiddenAnnotation());

		EReference revisionBoundsUntransformed = schema.createEReference(revisionClass, "boundsUntransformed", bounds);
		revisionBoundsUntransformed.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		revisionBoundsUntransformed.getEAnnotations().add(createEmbedsReferenceAnnotation());
		revisionBoundsUntransformed.getEAnnotations().add(createHiddenAnnotation());

		EReference revisionBoundsMm = schema.createEReference(revisionClass, "boundsMm", bounds);
		revisionBoundsMm.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		revisionBoundsMm.getEAnnotations().add(createEmbedsReferenceAnnotation());
		revisionBoundsMm.getEAnnotations().add(createHiddenAnnotation());
		
		EReference revisionBoundsUntransformedMm = schema.createEReference(revisionClass, "boundsUntransformedMm", bounds);
		revisionBoundsUntransformedMm.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		revisionBoundsUntransformedMm.getEAnnotations().add(createEmbedsReferenceAnnotation());
		revisionBoundsUntransformedMm.getEAnnotations().add(createHiddenAnnotation());

		vector3f.getEAnnotations().add(createHiddenAnnotation());
		geometryInfo.getEAnnotations().add(createHiddenAnnotation());
		schema.createEAttribute(geometryInfo, "startVertex", EcorePackage.eINSTANCE.getEIntegerObject());
		schema.createEAttribute(geometryInfo, "startIndex", EcorePackage.eINSTANCE.getEIntegerObject());
		schema.createEAttribute(geometryInfo, "primitiveCount", EcorePackage.eINSTANCE.getEIntegerObject());
		
		EClass buffer = schema.createEClass("geometry", "Buffer");
		schema.createEAttribute(buffer, "data", EcorePackage.eINSTANCE.getEByteArray());
		
		EClass geometryData = schema.createEClass("geometry", "GeometryData");
		schema.createEAttribute(geometryData, "nrIndices", EcorePackage.eINSTANCE.getEInt()).setDefaultValueLiteral("0");
		schema.createEAttribute(geometryData, "nrVertices", EcorePackage.eINSTANCE.getEInt()).setDefaultValueLiteral("0");
		schema.createEAttribute(geometryData, "nrNormals", EcorePackage.eINSTANCE.getEInt()).setDefaultValueLiteral("0");
		schema.createEAttribute(geometryData, "nrColors", EcorePackage.eINSTANCE.getEInt()).setDefaultValueLiteral("0");
		
		schema.createEReference(geometryData, "indices", buffer);
		schema.createEReference(geometryData, "vertices", buffer);
		schema.createEReference(geometryData, "verticesQuantized", buffer);
		schema.createEReference(geometryData, "normals", buffer);
		schema.createEReference(geometryData, "normalsQuantized", buffer);
		schema.createEReference(geometryData, "colorsQuantized", buffer);
		schema.createEAttribute(geometryInfo, "transformation", EcorePackage.eINSTANCE.getEByteArray());

		schema.createEReference(geometryInfo, "data", geometryData).getEAnnotations();

		EClass ifcProductIfc2x3tc1 = schema.getEClass("ifc2x3tc1", "IfcProduct");
		EClass ifcProductIfc4 = schema.getEClass("ifc4", "IfcProduct");
		EReference ifc2x3Geometry = schema.createEReference(ifcProductIfc2x3tc1, "geometry", geometryInfo);
		ifc2x3Geometry.setUnsettable(true);
		ifc2x3Geometry.getEAnnotations().add(createHiddenAnnotation());
		EReference ifc4Geometry = schema.createEReference(ifcProductIfc4, "geometry", geometryInfo);
		ifc4Geometry.setUnsettable(true);
		ifc4Geometry.getEAnnotations().add(createHiddenAnnotation());
	}

	@Override
	public String getDescription() {
		return "Initial IFC4 model";
	}
}