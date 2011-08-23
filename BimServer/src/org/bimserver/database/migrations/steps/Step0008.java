package org.bimserver.database.migrations.steps;

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
		schema.createEAttribute(deserializerClass, "enabled", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(deserializerClass, "defaultDeserializer", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
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