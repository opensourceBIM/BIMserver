package org.bimserver.database.migrations.steps;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0028 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass pluginBundleVersion = schema.getEClass("store", "PluginBundleVersion");
		schema.createEAttribute(pluginBundleVersion, "date", EcorePackage.eINSTANCE.getEDate());
	}

	@Override
	public String getDescription() {
		return "Add date field to PluginBundleVersion";
	}
}
