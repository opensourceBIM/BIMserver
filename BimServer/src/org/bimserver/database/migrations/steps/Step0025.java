package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0025 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EEnum notificationResultEnum = schema.createEEnum("store", "NotifictionResultEnum");
		schema.createEEnumLiteral(notificationResultEnum, "ERROR");
		schema.createEEnumLiteral(notificationResultEnum, "SUCCESS");
		schema.createEEnumLiteral(notificationResultEnum, "PROGRESS_UNKNOWN");
		schema.createEEnumLiteral(notificationResultEnum, "PROGRESS_PERCENTAGE");
		
		EClass immediateNotificationResult = schema.createEClass("store", "ImmediateNotificationResult");
		schema.createEAttribute(immediateNotificationResult, "result", notificationResultEnum, Multiplicity.SINGLE);
		schema.createEAttribute(immediateNotificationResult, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		EClass externalServiceCalled = schema.createEClass("log", "ExternalServiceCalled", schema.getEClass("log", "LogAction"));
		schema.createEReference(externalServiceCalled, "service", schema.getEClass("store", "Service"), Multiplicity.SINGLE);
		schema.createEAttribute(externalServiceCalled, "state", notificationResultEnum, Multiplicity.SINGLE);
		schema.createEAttribute(externalServiceCalled, "percentage", EcorePackage.eINSTANCE.getEInt(), Multiplicity.SINGLE);
		schema.createEAttribute(externalServiceCalled, "infos", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(externalServiceCalled, "warnings", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(externalServiceCalled, "errors", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		
		schema.createEReference(schema.getEClass("store", "Project"), "logs", schema.getEClass("log", "LogAction"), Multiplicity.MANY);
		schema.createEReference(schema.getEClass("store", "Revision"), "logs", schema.getEClass("log", "LogAction"), Multiplicity.MANY);
		schema.createEReference(schema.getEClass("store", "User"), "logs", schema.getEClass("log", "LogAction"), Multiplicity.MANY);
		schema.createEReference(schema.getEClass("store", "Checkout"), "logs", schema.getEClass("log", "LogAction"), Multiplicity.MANY);
		
		EClass externalServiceUpdate = schema.createEClass("store", "ExternalServiceUpdate");
		EClass percentageChange = schema.createEClass("store", "PercentageChange", externalServiceUpdate);
		schema.createEAttribute(percentageChange, "percentage", EcorePackage.eINSTANCE.getEInt(), Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "";
	}
}