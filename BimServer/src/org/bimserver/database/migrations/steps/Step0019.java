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

public class Step0019 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass userClass = schema.getEClass("store", "User");
		schema.addIndex(userClass.getEStructuralFeature("username"));
		
		EClass projectClass = schema.getEClass("store", "Project");
		schema.addIndex(projectClass.getEStructuralFeature("id"));

		EClass pluginDescriptor = schema.getEClass("store", "PluginDescriptor");
		schema.createEAttribute(pluginDescriptor, "identifier", EcorePackage.eINSTANCE.getEString());
		schema.addIndex(pluginDescriptor.getEStructuralFeature("pluginClassName"));
		schema.addIndex(pluginDescriptor.getEStructuralFeature("identifier"));
	}

	@Override
	public String getDescription() {
		return "Adding initial indices";
	}
}