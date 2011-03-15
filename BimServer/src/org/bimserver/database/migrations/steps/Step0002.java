package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;

/*
 * This step creates the Ifc2x3 model
 */
public class Step0002 extends Migration {

	@Override
	public void migrate(Schema schema) {
		schema.loadEcore(getClass().getResourceAsStream("IFC2X3.ecore"));
	}

	@Override
	public String getDescription() {
		return "Initial Ifc2x3 model";
	}
}