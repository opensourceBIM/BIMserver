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

/*
 * Adds classes and fields for the extended serializer/ignore file model
 */
public class Step0004 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass serializerClass = schema.createEClass(schema.getEPackage("store"), "Serializer");
		EClass guidanceProviderClass = schema.createEClass(schema.getEPackage("store"), "GuidanceProvider");
		EClass settingsClass = schema.getEClass("store", "Settings");

		schema.createEAttribute(serializerClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerClass, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerClass, "extension", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerClass, "contentType", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerClass, "className", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerClass, "enabled", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerClass, "defaultSerializer", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		EReference serializerGuidanceProviderReference = schema.createEReference(serializerClass, "guidanceProvider", guidanceProviderClass, Multiplicity.SINGLE);
		EReference serializerSettingsReference = schema.createEReference(serializerClass, "settings", settingsClass, Multiplicity.SINGLE);
		
		schema.createEAttribute(guidanceProviderClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(guidanceProviderClass, "className", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(guidanceProviderClass, "enabled", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		EReference guidanceProviderSerializers = schema.createEReference(guidanceProviderClass, "serializers", serializerClass, Multiplicity.MANY);
		EReference guidanceProviderSettingsReference = schema.createEReference(guidanceProviderClass, "settings", settingsClass, Multiplicity.SINGLE);
		
		EReference settingsSerializersReference = schema.createEReference(settingsClass, "serializers", serializerClass, Multiplicity.MANY);
		EReference settingsGuidanceProviderReference = schema.createEReference(settingsClass, "guidanceProviders", guidanceProviderClass, Multiplicity.MANY);
		
		serializerSettingsReference.setEOpposite(settingsSerializersReference);
		guidanceProviderSettingsReference.setEOpposite(settingsGuidanceProviderReference);

		settingsSerializersReference.setEOpposite(serializerSettingsReference);
		settingsGuidanceProviderReference.setEOpposite(guidanceProviderSettingsReference);
		
		guidanceProviderSerializers.setEOpposite(serializerGuidanceProviderReference);
		serializerGuidanceProviderReference.setEOpposite(guidanceProviderSerializers);
	}

	@Override
	public String getDescription() {
		return "Adds classes and fields for the extended serializer/ignore file model";
	}
}