package org.bimserver.database.migrations.steps;

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