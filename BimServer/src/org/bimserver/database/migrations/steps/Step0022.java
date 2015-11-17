package org.bimserver.database.migrations.steps;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.eclipse.emf.ecore.EClass;

public class Step0022 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass ifcRootClass = schema.getEClass("ifc2x3tc1", "IfcRoot");
		schema.addIndex(ifcRootClass.getEStructuralFeature("GlobalId"));
		schema.addIndex(ifcRootClass.getEStructuralFeature("Name"));
	}

	@Override
	public String getDescription() {
		return "More indices";
	}
}