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

public class Step0033 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass runServiceAuthorization = schema.createEClass("store", "RunServiceAuthorization", schema.getEClass("store", "Authorization"));
		schema.createEReference(runServiceAuthorization, "service", schema.getEClass("store", "InternalServicePluginConfiguration"));
		
		schema.createEAttribute(schema.getEClass("store", "ServerSettings"), "storeServiceRuns", EcorePackage.eINSTANCE.getEBoolean());
	}

	@Override
	public String getDescription() {
		return "Added class to store RunService auth";
	}
}