package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

/*
 * This step creates the log model
 */
public class Step0001 extends Migration {

	private EPackage logPackage;
	private EClass logActionClass;

	@Override
	public void migrate(Schema schema) {
		logPackage = schema.createEPackage("log");
		
		EClass userClass = schema.getEClass("store", "User");
		EClass projectClass = schema.getEClass("store", "Project");
		EClass revisionClass = schema.getEClass("store", "Revision");
		EClass checkoutClass = schema.getEClass("store", "Checkout");
		
		EEnum accessMethodEnum = schema.createEEnum(logPackage, "AccessMethod");
		schema.createEEnumLiteral(accessMethodEnum, "SOAP");
		schema.createEEnumLiteral(accessMethodEnum, "WEB_INTERFACE");
		schema.createEEnumLiteral(accessMethodEnum, "INTERNAL");
		schema.createEEnumLiteral(accessMethodEnum, "REST");
		schema.createEEnumLiteral(accessMethodEnum, "SYNDICATION");
		
		logActionClass = schema.createEClass(logPackage, "LogAction");
		schema.createEAttribute(logActionClass, "date", EcorePackage.eINSTANCE.getEDate(), Multiplicity.SINGLE);
		schema.createEReference(logActionClass, "executor", userClass, Multiplicity.SINGLE);
		schema.createEAttribute(logActionClass, "accessMethod", accessMethodEnum, Multiplicity.SINGLE);

		EClass serverLogClass = schema.createEClass(logPackage, "ServerLog");
		schema.createEReference(serverLogClass, "actions", logActionClass, Multiplicity.MANY);
		
		EClass newUserAddedClass = schema.createEClass(logPackage, "NewUserAdded", logActionClass);
		schema.createEReference(newUserAddedClass, "user", userClass, Multiplicity.SINGLE);
		
		EClass newProjectAddedClass = schema.createEClass(logPackage, "NewProjectAdded", logActionClass);
		schema.createEReference(newProjectAddedClass, "project", projectClass, Multiplicity.SINGLE);
		schema.createEReference(newProjectAddedClass, "parentProject", projectClass, Multiplicity.SINGLE);

		EClass newRevisionAddedClass = schema.createEClass(logPackage, "NewRevisionAdded", logActionClass);
		schema.createEReference(newRevisionAddedClass, "revision", revisionClass, Multiplicity.SINGLE);
		
		EClass newCheckoutAddedClass = schema.createEClass(logPackage, "NewCheckoutAdded", logActionClass);
		schema.createEReference(newCheckoutAddedClass, "checkout", checkoutClass, Multiplicity.SINGLE);
		
		schema.createEClass(logPackage, "SettingsSaved", logActionClass);
		
		EClass userAddedToProjectClass = schema.createEClass(logPackage, "UserAddedToProject", logActionClass);
		schema.createEReference(userAddedToProjectClass, "user", userClass, Multiplicity.SINGLE);
		schema.createEReference(userAddedToProjectClass, "project", projectClass, Multiplicity.SINGLE);
		
		schema.createEClass(logPackage, "NewGuidanceProviderUploaded", logActionClass);
		
		schema.createEClass(logPackage, "Download", logActionClass);
		
		EClass userRemovedFromProjectClass = schema.createEClass(logPackage, "UserRemovedFromProject", logActionClass);
		schema.createEReference(userRemovedFromProjectClass, "user", userClass, Multiplicity.SINGLE);
		schema.createEReference(userRemovedFromProjectClass, "project", projectClass, Multiplicity.SINGLE);
		
		EClass projectDeletedClass = schema.createEClass(logPackage, "ProjectDeleted", logActionClass);
		schema.createEReference(projectDeletedClass, "project", projectClass, Multiplicity.SINGLE);
		
		EClass userDeletedClass = schema.createEClass(logPackage, "UserDeleted", logActionClass);
		schema.createEReference(userDeletedClass, "user", userClass, Multiplicity.SINGLE);
		
		EClass passwordResetClass = schema.createEClass(logPackage, "PasswordReset", logActionClass);
		schema.createEReference(passwordResetClass, "user", userClass, Multiplicity.SINGLE);
		
		EClass databaseCreatedClass = schema.createEClass(logPackage, "DatabaseCreated", logActionClass);
		schema.createEAttribute(databaseCreatedClass, "path", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(databaseCreatedClass, "version", ecorePackage.getEInt(), Multiplicity.SINGLE);
		
		schema.createEClass(logPackage, "ServerStarted", logActionClass);
		
		EClass projectUpdatedClass = schema.createEClass(logPackage, "ProjectUpdated", logActionClass);
		schema.createEReference(projectUpdatedClass, "project", projectClass, Multiplicity.SINGLE);
		
		EClass userUndeletedClass = schema.createEClass(logPackage, "UserUndeleted", logActionClass);
		schema.createEReference(userUndeletedClass, "user", userClass, Multiplicity.SINGLE);
		
		EClass projectUndeletedClass = schema.createEClass(logPackage, "ProjectUndeleted", logActionClass);
		schema.createEReference(projectUndeletedClass, "project", projectClass, Multiplicity.SINGLE);
		
		EClass revisionUpdatedClass = schema.createEClass(logPackage, "RevisionUpdated", logActionClass);
		schema.createEReference(revisionUpdatedClass, "revision", revisionClass, Multiplicity.SINGLE);
		
		EClass geoTagUpdatedClass = schema.createEClass(logPackage, "GeoTagUpdated", logActionClass);
		schema.createEReference(geoTagUpdatedClass, "geoTag", schema.getEClass("store", "GeoTag"), Multiplicity.SINGLE);
		
		EClass clashDetectionSettingsUpdatedClass = schema.createEClass(logPackage, "ClashDetectionSettingsUpdated", logActionClass);
		schema.createEReference(clashDetectionSettingsUpdatedClass, "clashDetectionSettings", schema.getEClass("store", "ClashDetectionSettings"), Multiplicity.SINGLE);
		
		EClass passwordChangedClass = schema.createEClass(logPackage, "PasswordChanged", logActionClass);
		schema.createEReference(passwordChangedClass, "user", userClass, Multiplicity.SINGLE);
	
		EClass userChangedClass = schema.createEClass(logPackage, "UserChanged", logActionClass);
		schema.createEReference(userChangedClass, "user", userClass, Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Initial log model";
	}
}