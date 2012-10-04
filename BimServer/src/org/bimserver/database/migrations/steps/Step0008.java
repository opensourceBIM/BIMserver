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

public class Step0008 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass deserializerPluginClass = schema.createEClass(schema.getEPackage("store"), "DeserializerPluginConfiguration", schema.getEClass("store", "PluginConfiguration"));
		EClass userSettingsClass = schema.getEClass("store", "UserSettings");

		EReference deserializerSettingsReference = schema.createEReference(deserializerPluginClass, "userSettings", userSettingsClass, Multiplicity.SINGLE);
		EReference settingsDeserializersReference = schema.createEReference(userSettingsClass, "deserializers", deserializerPluginClass, Multiplicity.MANY);
		
		deserializerSettingsReference.setEOpposite(settingsDeserializersReference);
		settingsDeserializersReference.setEOpposite(deserializerSettingsReference);
	}

	@Override
	public String getDescription() {
		return "Adds Deserializer class";
	}
}