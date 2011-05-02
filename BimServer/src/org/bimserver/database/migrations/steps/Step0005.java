package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0005 extends Migration {

	@Override
	public String getDescription() {
		return "New header/footer settings";
	}

	@Override
	public void migrate(Schema schema) {
		EClass settingsClass = schema.getEClass("store", "Settings");
		schema.createEAttribute(settingsClass, "headerAddition", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "footerAddition", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
	}
}