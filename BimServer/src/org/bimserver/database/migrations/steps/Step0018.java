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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0018 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass queryEnginePluginDescriptor = schema.createEClass(schema.getEPackage("store"), "QueryEnginePluginDescriptor");
		schema.createEAttribute(queryEnginePluginDescriptor, "pluginClassName", EcorePackage.eINSTANCE.getEString(),  Multiplicity.SINGLE);
		schema.createEAttribute(queryEnginePluginDescriptor, "defaultName", EcorePackage.eINSTANCE.getEString(),  Multiplicity.SINGLE);
		
		EClass queryEngineClass = schema.createEClass(schema.getEPackage("store"), "QueryEngine");
		EClass settingsClass = schema.getEClass("store", "Settings");

		schema.createEAttribute(queryEngineClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(queryEngineClass, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(queryEngineClass, "className", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(queryEngineClass, "enabled", EcorePackage.eINSTANCE.getEBooleanObject(), Multiplicity.SINGLE);
		EReference queryEngineSettingsReference = schema.createEReference(queryEngineClass, "settings", settingsClass, Multiplicity.SINGLE);
		EReference settingsQueryEnginesReference = schema.createEReference(settingsClass, "queryengines", queryEngineClass, Multiplicity.MANY);
		
		queryEngineSettingsReference.setEOpposite(settingsQueryEnginesReference);
		settingsQueryEnginesReference.setEOpposite(queryEngineSettingsReference);
	}

	@Override
	public String getDescription() {
		return "Add QueryEnginePluginDescriptor + QueryEngine";
	}
}