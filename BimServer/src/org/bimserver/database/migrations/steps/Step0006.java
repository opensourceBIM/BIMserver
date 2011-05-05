package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0006 extends Migration {

	@Override
	public String getDescription() {
		return "New mergeIdentifier and cacheOutputFiles settings";
	}

	@Override
	public void migrate(Schema schema) {
		EEnum mergeIdentifierEnum = schema.createEEnum(schema.getEPackage("store"), "MergeIdentifier");
		schema.createEEnumLiteral(mergeIdentifierEnum, "NAME");
		schema.createEEnumLiteral(mergeIdentifierEnum, "GUID");
		
		EClass settingsClass = schema.getEClass("store", "Settings");
		schema.createEAttribute(settingsClass, "mergeIdentifier", mergeIdentifierEnum, Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "cacheOutputFiles", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
	}
}