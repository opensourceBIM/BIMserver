package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0004 extends Migration {

	@Override
	public void migrate(Schema schema) {
		// Model checker results
		EClass modelCheckerResultItem = schema.createEClass("store", "ModelCheckerResultItem");
		
		EClass modelCheckerResultHeader = schema.createEClass("store", "ModelCheckerResultHeader", modelCheckerResultItem);
		schema.createEAttribute(modelCheckerResultHeader, "text", EcorePackage.eINSTANCE.getEString());
		
		EEnum modelCheckerResultType = schema.createEEnum("store", "ModelCheckerResultType");
		schema.createEEnumLiteral(modelCheckerResultType, "ERROR");
		schema.createEEnumLiteral(modelCheckerResultType, "SUCCESS");
		
		EClass modelCheckerResultLine = schema.createEClass("store", "ModelCheckerResultLine", modelCheckerResultItem);
		schema.createEAttribute(modelCheckerResultLine, "fieldOrClass", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(modelCheckerResultLine, "value", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(modelCheckerResultLine, "shouldBe", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(modelCheckerResultLine, "type", modelCheckerResultType);
		schema.createEAttribute(modelCheckerResultLine, "objectId", EcorePackage.eINSTANCE.getELong());
		
		EClass modelCheckerResult = schema.createEClass("store", "ModelCheckerResult");
		schema.createEAttribute(modelCheckerResult, "valid", EcorePackage.eINSTANCE.getEBoolean());
		schema.createEReference(modelCheckerResult, "items", modelCheckerResultItem, Multiplicity.MANY);
		
		// ModelChecker plugin
		EClass pluginConfiguration = schema.getEClass("store", "PluginConfiguration");
		EClass modelCheckerPluginConfiguration = schema.createEClass("store", "ModelCheckerPluginConfiguration", pluginConfiguration);

		EClass modelCheckerInstance = schema.createEClass("store", "ModelCheckerInstance");
		schema.createEAttribute(modelCheckerInstance, "code", EcorePackage.eINSTANCE.getEString());
		schema.createEReference(modelCheckerInstance, "modelChecker", modelCheckerPluginConfiguration, Multiplicity.SINGLE);
		
		// References to plugin
		EClass service = schema.getEClass("store", "Service");
		schema.createEReference(service, "modelCheckers", modelCheckerInstance, Multiplicity.MANY);
		
		EClass project = schema.getEClass("store", "Project");
		schema.createEReference(project, "modelCheckers", modelCheckerInstance, Multiplicity.MANY);
		
		EEnum primitiveEnum = schema.getEEnum("store", "PrimitiveEnum");
		schema.createEEnumLiteral(primitiveEnum, "CODE");
		
		EClass userSettings = schema.getEClass("store", "UserSettings");
		EReference userSettingsModelCheckers = schema.createEReference(userSettings, "modelCheckers", modelCheckerPluginConfiguration, Multiplicity.MANY);
		EReference modelCheckerUserSettings = schema.createEReference(modelCheckerPluginConfiguration, "userSettings", userSettings, Multiplicity.SINGLE);
		
		link(userSettingsModelCheckers, modelCheckerUserSettings);
		userSettingsModelCheckers.setEOpposite(modelCheckerUserSettings);
		modelCheckerUserSettings.setEOpposite(userSettingsModelCheckers);
		
		schema.createEClass("store", "ModelCheckerPluginDescriptor", schema.getEClass("store", "PluginDescriptor"));
	}

	@Override
	public String getDescription() {
		return "ModelChecker objects";
	}
}