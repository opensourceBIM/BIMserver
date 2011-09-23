package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

public class Step0007 extends Migration {

	@Override
	public String getDescription() {
		return "Settings to store used ifc engine";
	}

	@Override
	public void migrate(Schema schema) {
		EClass ifcEngineClass = schema.createEClass(schema.getEPackage("store"), "IfcEngine");
		EClass settingsClass = schema.getEClass("store", "Settings");

		schema.createEAttribute(ifcEngineClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(ifcEngineClass, "active", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		EReference ifcEngineSettings = schema.createEReference(ifcEngineClass, "settings", settingsClass, Multiplicity.SINGLE);

		EReference settingsIfcEngines = schema.createEReference(settingsClass, "ifcEngines", ifcEngineClass, Multiplicity.MANY);

		settingsIfcEngines.setEOpposite(ifcEngineSettings);
		ifcEngineSettings.setEOpposite(settingsIfcEngines);
		
		EClass pluginClass = schema.createEClass(schema.getEPackage("store"), "Plugin");
		schema.createEAttribute(pluginClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginClass, "enabled", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		EReference pluginSettings = schema.createEReference(pluginClass, "settings", settingsClass, Multiplicity.SINGLE);
		
		EReference settingsPlugins = schema.createEReference(settingsClass, "plugins", pluginClass, Multiplicity.MANY);
		
		pluginSettings.setEOpposite(settingsPlugins);
		settingsPlugins.setEOpposite(pluginSettings);
	}
}