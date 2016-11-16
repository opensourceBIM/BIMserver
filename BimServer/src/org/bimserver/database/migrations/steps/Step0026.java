package org.bimserver.database.migrations.steps;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0026 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		schema.createEAttribute(schema.getEClass("store", "DownloadResult"), "serializerOid", EcorePackage.eINSTANCE.getELong());
	}

	@Override
	public String getDescription() {
		return "Added serializerOid to DownloadResult";
	}
}