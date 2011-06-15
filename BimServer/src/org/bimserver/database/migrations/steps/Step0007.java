package org.bimserver.database.migrations.steps;

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