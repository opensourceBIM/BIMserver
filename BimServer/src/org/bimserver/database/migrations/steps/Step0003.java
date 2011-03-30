package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;

/*
 * Adds the "laid" field to Revision class
 */
public class Step0003 extends Migration {

	@Override
	public void migrate(Schema schema) {
		schema.createEAttribute(schema.getEClass("store", "Revision"), "laid", ecorePackage.getELong(), Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Add \"laid\" field to Revision class";
	}
}