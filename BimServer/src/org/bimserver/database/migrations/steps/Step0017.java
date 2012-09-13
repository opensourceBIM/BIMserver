package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0017 extends Migration {

	@Override
	public void migrate(Schema extendedDataSschema) {
		EEnum extendedDataSchemaType = extendedDataSschema.createEEnum(extendedDataSschema.getEPackage("store"), "ExtendedDataSchemaType");
		extendedDataSschema.createEEnumLiteral(extendedDataSchemaType, "XSD");
		
		EClass extendedDataSchemaClass = extendedDataSschema.createEClass(extendedDataSschema.getEPackage("store"), "ExtendedDataSchema");
		extendedDataSschema.createEAttribute(extendedDataSchemaClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		extendedDataSschema.createEAttribute(extendedDataSchemaClass, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		extendedDataSschema.createEAttribute(extendedDataSchemaClass, "data", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		extendedDataSschema.createEAttribute(extendedDataSchemaClass, "validate", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		extendedDataSschema.createEAttribute(extendedDataSchemaClass, "type", extendedDataSchemaType, Multiplicity.SINGLE);
		
		EClass extendedDataClass = extendedDataSschema.createEClass(extendedDataSschema.getEPackage("store"), "ExtendedData");
		extendedDataSschema.createEAttribute(extendedDataClass, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		extendedDataSschema.createEAttribute(extendedDataClass, "data", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		extendedDataSschema.createEAttribute(extendedDataClass, "title", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		extendedDataSschema.createEAttribute(extendedDataClass, "added", EcorePackage.eINSTANCE.getEDate(), Multiplicity.SINGLE);
		
		EClass serverSettingsClass = extendedDataSschema.getEClass("store", "ServerSettings");
		EReference settingsToExtendedDataSchema = extendedDataSschema.createEReference(serverSettingsClass, "schemas", extendedDataSchemaClass, Multiplicity.MANY);
		EReference extendedDataSchemaToSettings = extendedDataSschema.createEReference(extendedDataSchemaClass, "settings", serverSettingsClass, Multiplicity.SINGLE);
		settingsToExtendedDataSchema.setEOpposite(extendedDataSchemaToSettings);
		extendedDataSchemaToSettings.setEOpposite(settingsToExtendedDataSchema);
		
		EClass userClass = extendedDataSschema.getEClass("store", "User");
		EReference userToExtendedDataSchema = extendedDataSschema.createEReference(userClass, "schemas", extendedDataSchemaClass, Multiplicity.MANY);
		EReference extendedDataSchemaToUser = extendedDataSschema.createEReference(extendedDataSchemaClass, "users", userClass, Multiplicity.MANY);
		userToExtendedDataSchema.setEOpposite(extendedDataSchemaToUser);
		extendedDataSchemaToUser.setEOpposite(userToExtendedDataSchema);

		EReference extendedDataToUser = extendedDataSschema.createEReference(extendedDataClass, "user", userClass, Multiplicity.SINGLE);
		EReference userToExtendedData = extendedDataSschema.createEReference(userClass, "extendedData", extendedDataClass, Multiplicity.MANY);
		extendedDataToUser.setEOpposite(userToExtendedData);
		userToExtendedData.setEOpposite(extendedDataToUser);
		
		EReference extendedDataToExtendedDataSchema = extendedDataSschema.createEReference(extendedDataClass, "schema", extendedDataSchemaClass, Multiplicity.SINGLE);
		EReference extendedDataSchemaToExtendedData = extendedDataSschema.createEReference(extendedDataSchemaClass, "extendedData", extendedDataClass, Multiplicity.MANY);
		extendedDataToExtendedDataSchema.setEOpposite(extendedDataSchemaToExtendedData);
		extendedDataSchemaToExtendedData.setEOpposite(extendedDataToExtendedDataSchema);
		
		EClass revisionClass = extendedDataSschema.getEClass("store", "Revision");
		extendedDataSschema.createEReference(revisionClass, "extendedData", extendedDataClass, Multiplicity.MANY);
		
		EClass projectClass = extendedDataSschema.getEClass("store", "Project");
		extendedDataSschema.createEReference(projectClass, "extendedData", extendedDataClass, Multiplicity.MANY);
	}

	@Override
	public String getDescription() {
		return "Adding classes for extended data";
	}
}