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

public class Step0030 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass geometryInfo = schema.getEClass("geometry", "GeometryInfo");
		EClass vector3f = schema.getEClass("geometry", "Vector3f");
		
		EReference geometryInfoMinBounds = schema.createEReference(geometryInfo, "minBoundsUntranslated", vector3f, Multiplicity.SINGLE);
		geometryInfoMinBounds.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		geometryInfoMinBounds.getEAnnotations().add(createEmbedsReferenceAnnotation());
		geometryInfoMinBounds.getEAnnotations().add(createHiddenAnnotation());
		
		EReference geometryInfoMaxBounds = schema.createEReference(geometryInfo, "maxBoundsUntranslated", vector3f, Multiplicity.SINGLE);
		geometryInfoMaxBounds.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		geometryInfoMaxBounds.getEAnnotations().add(createEmbedsReferenceAnnotation());
		geometryInfoMaxBounds.getEAnnotations().add(createHiddenAnnotation());
	}

	@Override
	public String getDescription() {
		return "Add untranslated bounds";
	}
}
