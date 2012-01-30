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

public class Step0008 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass deserializerClass = schema.createEClass(schema.getEPackage("store"), "Deserializer");
		EClass settingsClass = schema.getEClass("store", "Settings");

		schema.createEAttribute(deserializerClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(deserializerClass, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(deserializerClass, "className", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(deserializerClass, "enabled", EcorePackage.eINSTANCE.getEBooleanObject(), Multiplicity.SINGLE);
		schema.createEAttribute(deserializerClass, "defaultDeserializer", EcorePackage.eINSTANCE.getEBooleanObject(), Multiplicity.SINGLE);
		EReference deserializerSettingsReference = schema.createEReference(deserializerClass, "settings", settingsClass, Multiplicity.SINGLE);
		EReference settingsDeserializersReference = schema.createEReference(settingsClass, "deserializers", deserializerClass, Multiplicity.MANY);
		
		deserializerSettingsReference.setEOpposite(settingsDeserializersReference);
		settingsDeserializersReference.setEOpposite(deserializerSettingsReference);
	}

	@Override
	public String getDescription() {
		return "Adds Deserializer class";
	}
}