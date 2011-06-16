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
		EClass ignoreFileClass = schema.createEClass(schema.getEPackage("store"), "IgnoreFile");
		EClass settingsClass = schema.getEClass("store", "Settings");

		schema.createEAttribute(serializerClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerClass, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerClass, "extension", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerClass, "contentType", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerClass, "className", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerClass, "enabled", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerClass, "defaultSerializer", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		EReference serializerIgnoreFileReference = schema.createEReference(serializerClass, "ignoreFile", ignoreFileClass, Multiplicity.SINGLE);
		EReference serializerSettingsReference = schema.createEReference(serializerClass, "settings", settingsClass, Multiplicity.SINGLE);
		
		schema.createEAttribute(ignoreFileClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(ignoreFileClass, "data", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		EReference ignoreFileSerializers = schema.createEReference(ignoreFileClass, "serializers", serializerClass, Multiplicity.MANY);
		EReference ignoreFileSettingsReference = schema.createEReference(ignoreFileClass, "settings", settingsClass, Multiplicity.SINGLE);
		
		EReference settingsSerializersReference = schema.createEReference(settingsClass, "serializers", serializerClass, Multiplicity.MANY);
		EReference settingsIgnoreFilesReference = schema.createEReference(settingsClass, "ignoreFiles", ignoreFileClass, Multiplicity.MANY);
		
		serializerSettingsReference.setEOpposite(settingsSerializersReference);
		ignoreFileSettingsReference.setEOpposite(settingsIgnoreFilesReference);

		settingsSerializersReference.setEOpposite(serializerSettingsReference);
		settingsIgnoreFilesReference.setEOpposite(ignoreFileSettingsReference);
		
		ignoreFileSerializers.setEOpposite(serializerIgnoreFileReference);
		serializerIgnoreFileReference.setEOpposite(ignoreFileSerializers);
	}

	@Override
	public String getDescription() {
		return "Adds classes and fields for the extended serializer/ignore file model";
	}
}