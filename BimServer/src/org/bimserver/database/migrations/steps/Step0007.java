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

public class Step0007 extends Migration {

	@Override
	public String getDescription() {
		return "Settings to store used ifc engine";
	}

	@Override
	public void migrate(Schema schema) {
		EClass ifcEngineClass = schema.createEClass(schema.getEPackage("store"), "IfcEngine", schema.getEClass("store", "Plugin"));
		EClass userSettingsClass = schema.getEClass("store", "UserSettings");

		EReference ifcEngineSerializersReference = schema.createEReference(ifcEngineClass, "serializers", schema.getEClass("store", "Serializer"), Multiplicity.MANY);
		EReference serializerIfcEngineReference = schema.createEReference(schema.getEClass("store", "Serializer"), "ifcEngine", ifcEngineClass, Multiplicity.SINGLE);
		
		serializerIfcEngineReference.setEOpposite(ifcEngineSerializersReference);
		ifcEngineSerializersReference.setEOpposite(serializerIfcEngineReference);
		
		EReference ifcEngineSettings = schema.createEReference(ifcEngineClass, "settings", userSettingsClass, Multiplicity.SINGLE);

		EReference settingsIfcEngines = schema.createEReference(userSettingsClass, "ifcEngines", ifcEngineClass, Multiplicity.MANY);

		settingsIfcEngines.setEOpposite(ifcEngineSettings);
		ifcEngineSettings.setEOpposite(settingsIfcEngines);
	}
}