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
import org.eclipse.emf.ecore.EcorePackage;

public class Step0052 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass tile = schema.createEClass("store", "Tile");
		EClass bounds = schema.getEClass("geometry", "Bounds");
		
		schema.createEAttribute(tile, "tileId", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(tile, "nrObjects", EcorePackage.eINSTANCE.getEInt());
		schema.createEReference(tile, "minBounds", bounds).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEReference(tile, "bounds", bounds).getEAnnotations().add(createEmbedsReferenceAnnotation());
	}

	@Override
	public String getDescription() {
		return "Added Tile object";
	}
}