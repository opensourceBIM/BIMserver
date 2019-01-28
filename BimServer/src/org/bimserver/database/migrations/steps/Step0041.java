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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0041 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass revision = schema.getEClass("store", "Revision");
		EClass concreteRevision = schema.getEClass("store", "ConcreteRevision");

		EClass densityCollection = schema.createEClass("store", "DensityCollection");
		
		EClass density = schema.createEClass("store", "Density");
		schema.createEAttribute(density, "type", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(density, "geometryInfoId", EcorePackage.eINSTANCE.getELong());
		schema.createEAttribute(density, "trianglesBelow", EcorePackage.eINSTANCE.getELong());
		schema.createEAttribute(density, "trianglesAbove", EcorePackage.eINSTANCE.getELong());
		schema.createEAttribute(density, "volume", EcorePackage.eINSTANCE.getEFloat());
		schema.createEAttribute(density, "density", EcorePackage.eINSTANCE.getEFloat());
		
		EReference densities = schema.createEReference(densityCollection, "densities", density, Multiplicity.MANY);
		densities.setUnique(false);
		
		densities.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		densities.getEAnnotations().add(createEmbedsReferenceAnnotation());
		densities.getEAnnotations().add(createHiddenAnnotation());
		
		schema.createEReference(revision, "densityCollection", densityCollection);
		schema.createEReference(concreteRevision, "densityCollection", densityCollection);
		
		schema.createEAttribute(revision, "nrPrimitives", EcorePackage.eINSTANCE.getELong());
		
		EClass bounds = schema.getEClass("geometry", "Bounds");
		EClass geometryInfo = schema.getEClass("geometry", "GeometryInfo");
		EClass geometryData = schema.getEClass("geometry", "GeometryData");
		
		schema.createEAttribute(geometryInfo, "density", EcorePackage.eINSTANCE.getEFloat());
		
		EReference boundsMm = schema.createEReference(geometryInfo, "boundsMm", bounds);
		boundsMm.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		boundsMm.getEAnnotations().add(createEmbedsReferenceAnnotation());
		boundsMm.getEAnnotations().add(createHiddenAnnotation());

		EReference boundsMmGeometryData = schema.createEReference(geometryData, "boundsMm", bounds);
		boundsMmGeometryData.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		boundsMmGeometryData.getEAnnotations().add(createEmbedsReferenceAnnotation());
		boundsMmGeometryData.getEAnnotations().add(createHiddenAnnotation());
		
		EReference boundsMmUntransformed = schema.createEReference(geometryInfo, "boundsUntransformedMm", bounds);
		boundsMmUntransformed.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		boundsMmUntransformed.getEAnnotations().add(createEmbedsReferenceAnnotation());
		boundsMmUntransformed.getEAnnotations().add(createHiddenAnnotation());
		
		schema.createEAttribute(geometryData, "saveableTriangles", EcorePackage.eINSTANCE.getEInt());
	}

	@Override
	public String getDescription() {
		return "Add density info";
	}
}