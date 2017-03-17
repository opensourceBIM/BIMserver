package org.bimserver.database.migrations.steps;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.eclipse.emf.ecore.EEnum;

public class Step0031 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EEnum serviceStatus = schema.getEEnum("store", "ServiceStatus");
		schema.createEEnumLiteral(serviceStatus, "NO_AUTHENTICATION");
		
		EEnum pluginBundleType = schema.getEEnum("store", "PluginBundleType");
		schema.createEEnumLiteral(pluginBundleType, "LOCAL_DEV");
	}

	@Override
	public String getDescription() {
		return "Added enum constants";
	}
}