package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0009 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass userClass = schema.getEClass("store", "User");
		schema.createEAttribute(userClass, "notificationUrl", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Adds notification stuff";
	}
}