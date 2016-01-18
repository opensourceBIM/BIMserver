package org.bimserver.database.migrations.steps;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0023 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass pluginVersionClass = schema.createEClass("store", "PluginVersion");
		
		EEnum pluginType = schema.createEEnum("store", "PluginType");
		schema.createEEnumLiteral(pluginType, "MAVEN");
		schema.createEEnumLiteral(pluginType, "GITHUB");
		
		schema.createEAttribute(pluginVersionClass, "version", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(pluginVersionClass, "type", pluginType);
		
		EClass pluginUpdateInformation = schema.createEClass("store", "PluginUpdateInformation");
		schema.createEAttribute(pluginUpdateInformation, "name", EcorePackage.eINSTANCE.getEString());
		schema.createEReference(pluginUpdateInformation, "currentVersion", pluginVersionClass, Multiplicity.SINGLE);
		schema.createEReference(pluginUpdateInformation, "availableVersions", pluginVersionClass, Multiplicity.MANY);
	}

	@Override
	public String getDescription() {
		return "Classes needed for remote plugin system";
	}
}