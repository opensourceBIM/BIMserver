package org.bimserver.database.migrations;

/*
 * This step creates the Ifc2x3 model
 */
public class Step0002 extends Migration {

	@Override
	void migrate(Schema schema) {
		schema.loadEcore(getClass().getResourceAsStream("IFC2X3.ecore"));
	}
}