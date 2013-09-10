package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0004 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass modelCheckerResultItem = schema.createEClass("store", "ModelCheckerResultItem");
		
		EClass modelCheckerResultHeader = schema.createEClass("store", "ModelCheckerResultHeader", modelCheckerResultItem);
		schema.createEAttribute(modelCheckerResultHeader, "text", EcorePackage.eINSTANCE.getEString());
		
		EEnum modelCheckerResultType = schema.createEEnum("store", "ModelCheckerResultType");
		schema.createEEnumLiteral(modelCheckerResultType, "ERROR");
		schema.createEEnumLiteral(modelCheckerResultType, "SUCCESS");
		
		EClass modelCheckerResultLine = schema.createEClass("store", "ModelCheckerResultLine", modelCheckerResultItem);
		schema.createEAttribute(modelCheckerResultLine, "fieldOrClass", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(modelCheckerResultLine, "value", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(modelCheckerResultLine, "shouldBe", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(modelCheckerResultLine, "type", modelCheckerResultType);
		schema.createEAttribute(modelCheckerResultLine, "objectId", EcorePackage.eINSTANCE.getELong());
		
		EClass modelCheckerResult = schema.createEClass("store", "ModelCheckerResult");
		schema.createEAttribute(modelCheckerResult, "valid", EcorePackage.eINSTANCE.getEBoolean());
		schema.createEReference(modelCheckerResult, "items", modelCheckerResultItem, Multiplicity.MANY);
	}

	@Override
	public String getDescription() {
		return "ModelChecker objects";
	}
}