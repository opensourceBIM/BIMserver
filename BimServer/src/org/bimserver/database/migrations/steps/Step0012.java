package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;

public class Step0012 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EEnum serverState = schema.createEEnum(schema.getEPackage("store"), "ServerState");
		schema.createEEnumLiteral(serverState, "UNDEFINED");
		schema.createEEnumLiteral(serverState, "NOT_SETUP");
		schema.createEEnumLiteral(serverState, "MIGRATION_REQUIRED");
		schema.createEEnumLiteral(serverState, "MIGRATION_IMPOSSIBLE");
		schema.createEEnumLiteral(serverState, "FATAL_ERROR");
		schema.createEEnumLiteral(serverState, "RUNNING");
		
		EClass serverInfoClass = schema.createEClass(schema.getEPackage("store"), "ServerInfo");
		schema.createEAttribute(serverInfoClass, "serverState", serverState, Multiplicity.SINGLE);
		schema.createEAttribute(serverInfoClass, "errorMessage", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EClass versionInfoClass = schema.createEClass(schema.getEPackage("store"), "Version");
		schema.createEAttribute(versionInfoClass, "major", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "minor", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "revision", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "date", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "downloadUrl", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "supportUrl", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "supportEmail", ecorePackage.getEString(), Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Advanced queries in Service Interface";
	}
}