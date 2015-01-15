package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0014 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass serializerPluginConfiguration = schema.createEClass(schema.getEPackage("store"), "MessagingSerializerPluginConfiguration", schema.getEClass("store", "PluginConfiguration"));
		EClass userSettings = schema.getEClass("store", "UserSettings");
		EReference serializerSettingsReference = schema.createEReference(serializerPluginConfiguration, "userSettings", userSettings, Multiplicity.SINGLE);
		EReference settingsSerializerReference = schema.createEReference(userSettings, "messagingSerializerPlugins", serializerPluginConfiguration, Multiplicity.MANY);
		
		settingsSerializerReference.setEOpposite(serializerSettingsReference);
		serializerSettingsReference.setEOpposite(settingsSerializerReference);
		
		EClass serverSettings = schema.getEClass("store", "ServerSettings");
		schema.createEAttribute(serverSettings, "allowCreateValidatedUser", EcorePackage.eINSTANCE.getEBoolean());
		
		EClass version = schema.getEClass("store", "Version");

		EClass serverInfo = schema.getEClass("store", "ServerInfo");
		EReference versionReference = schema.createEReference(serverInfo, "version", version, Multiplicity.SINGLE);
		versionReference.getEAnnotations().add(createEmbedsReferenceAnnotation());
	}

	@Override
	public String getDescription() {
		return "Initial IFC4 model";
	}
}