package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0003 extends Migration {

	@Override
	public void migrate(Schema schema) {
		schema.createEAttribute(schema.getEClass("store", "User"), "test", EcorePackage.eINSTANCE.getEInt());
	}

	@Override
	public String getDescription() {
		return "Test";
	}
}
