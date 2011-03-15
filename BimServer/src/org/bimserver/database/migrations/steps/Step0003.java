package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;

/*
 * This step creates the Ifc2x3 model
 */
public class Step0003 extends Migration {

	@Override
	public void migrate(Schema schema) {
		schema.createEAttribute(schema.getEClass("store", "User"), "attr1", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(schema.getEClass("store", "User"), "attr2", ecorePackage.getEString(), Multiplicity.MANY);
		schema.createEAttribute(schema.getEClass("store", "User"), "attr3", schema.getEEnum("store", "ObjectState"), Multiplicity.SINGLE);
		schema.createEReference(schema.getEClass("store", "User"), "ref1", schema.getEClass("store", "Project"), Multiplicity.SINGLE);
		schema.createEReference(schema.getEClass("store", "User"), "ref2", schema.getEClass("store", "Project"), Multiplicity.MANY);
	}

	@Override
	public String getDescription() {
		return "Test migration";
	}
}