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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0034 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass vector4f = schema.createEClass("geometry", "Vector4f");
		schema.createEAttribute(vector4f, "x", EcorePackage.eINSTANCE.getEFloat());
		schema.createEAttribute(vector4f, "y", EcorePackage.eINSTANCE.getEFloat());
		schema.createEAttribute(vector4f, "z", EcorePackage.eINSTANCE.getEFloat());
		schema.createEAttribute(vector4f, "w", EcorePackage.eINSTANCE.getEFloat());
		
		EClass geometryData = schema.getEClass("geometry", "GeometryData");

		EReference reference = schema.createEReference(geometryData, "color", vector4f);
		reference.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		reference.getEAnnotations().add(createEmbedsReferenceAnnotation());
		reference.getEAnnotations().add(createHiddenAnnotation());
	}

	@Override
	public String getDescription() {
		return "Add ability to store just one color for all geometry in GeometryInfo";
	}
}