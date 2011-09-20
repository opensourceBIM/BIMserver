package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;

public class Step0011 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass notificationClass = schema.createEClass(schema.getEPackage("store"), "Notification");
		
		EClass newProjectNotificationClass = schema.createEClass(schema.getEPackage("store"), "NewProjectNotification", notificationClass);
		schema.createEReference(newProjectNotificationClass, "project", schema.getEClass("store", "Project"), Multiplicity.SINGLE);

		EClass newRevisionNotificationClass = schema.createEClass(schema.getEPackage("store"), "NewRevisionNotification", notificationClass);
		schema.createEReference(newRevisionNotificationClass, "revision", schema.getEClass("store", "Revision"), Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Adds notification stuff";
	}
}