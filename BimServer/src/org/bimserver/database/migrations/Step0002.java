package org.bimserver.database.migrations;

import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;

public class Step0002 extends Migration {

	@Override
	void migrate(Schema schema) {
		EClass userClass = schema.getEClass("store", "User");
		schema.createEAttribute(userClass, "testje", ecorePackage.getEString(), Multiplicity.SINGLE);
	}
}