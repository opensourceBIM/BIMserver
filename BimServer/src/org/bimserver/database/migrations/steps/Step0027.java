package org.bimserver.database.migrations.steps;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class Step0027 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass ifcClassificationReference = schema.getEClass("ifc2x3tc1", "IfcClassificationReference");
		EClass ifcRelAssociatesClassification = schema.getEClass("ifc2x3tc1", "IfcRelAssociatesClassification");
//		
//		// This opposite/inverse is obviously missing from ifc2x3tc1
//		// We can however not call this an opposite because of a mismatch
//		EReference associatesClassification = schema.createEReference(ifcClassificationReference, "associatesClassification", ifcRelAssociatesClassification);
//		associatesClassification.getEAnnotations().add(createHiddenAnnotation());

		schema.addIndex(ifcClassificationReference.getEStructuralFeature("ItemReference"));
		schema.addIndex(ifcRelAssociatesClassification.getEStructuralFeature("RelatingClassification"));
	}

	@Override
	public String getDescription() {
		return null;
	}
}
