package org.bimserver.database.migrations.steps;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/*
 * This step creates the store model
 */
public class Step0000 extends Migration {

	private EPackage storePackage;
	private EcorePackage ecorePackage = EcorePackage.eINSTANCE;
	private EClass revisionClass;
	private EClass clashClass;
	private EEnum objectStateEnum;
	private EEnum siPrefixEnum;
	private EClass userClass;
	private EClass checkoutClass;
	private EEnum userTypeEnum;
	private EClass geoTagClass;
	private EClass concreteRevisionClass;
	private EClass guidClashClass;
	private EClass clashDetectionsSettingsClass;
	private EClass eidClashClass;
	private EEnum checkinStateEnum;
	private EClass projectClass;
	private EReference projectHasAuthorizedUsers;
	private EReference projectConcreteRevisions;
	private EReference projectRevisions;
	private EReference projectCheckouts;
	private EReference projectGeoTag;
	private EReference projectSubProjects;
	private EReference projectParentProject;
	private EReference projectClashDetectionSettings;
	private EReference userHasRightsOn;
	private EReference concreteRevisionProject;
	private EReference concreteRevisionRevisions;
	private EReference revisionConcreteRevisions;
	private EReference revisionCheckouts;
	private EReference revisionProject;
	private EReference checkoutRevision;
	private EReference checkoutProject;
	private EReference clashDetectionSettingsProjects;
	private EReference geoTagProjects;
	private Schema schema;
	private EClass settingsClass;

	@Override
	public void migrate(Schema schema) {
		this.schema = schema;
		storePackage = schema.createEPackage("store");
		
		createUserTypeEnum();
		createCheckinStateEnum();
		createSIPrefixEnum();
		createObjectStateEnum();

		projectClass = schema.createEClass(storePackage, "Project");
		userClass = schema.createEClass(storePackage, "User");
		clashClass = schema.createEClass(storePackage, "Clash");
		eidClashClass = schema.createEClass(storePackage, "EidClash", clashClass);
		guidClashClass = schema.createEClass(storePackage, "GuidClash", clashClass);
		clashDetectionsSettingsClass = schema.createEClass(storePackage, "ClashDetectionSettings");
		revisionClass = schema.createEClass(storePackage, "Revision");
		concreteRevisionClass = schema.createEClass(storePackage, "ConcreteRevision");
		geoTagClass = schema.createEClass(storePackage, "GeoTag");
		checkoutClass = schema.createEClass(storePackage, "Checkout");
		settingsClass = schema.createEClass(storePackage, "Settings");

		createProjectClass();
		createUserClass();
		createCheckoutClass();
		createGeoTagClass();
		createConcreteRevisionClass();
		createRevisionClass();
		createClashDetectionSettingsClass();
		createClashClass();
		createGuidClashClass();
		createEidClashClass();
		createSettingsClass();
		
		userHasRightsOn.setEOpposite(projectHasAuthorizedUsers);
		projectHasAuthorizedUsers.setEOpposite(userHasRightsOn);
		
		revisionProject.setEOpposite(projectRevisions);
		projectRevisions.setEOpposite(revisionProject);
		
		checkoutProject.setEOpposite(projectCheckouts);
		projectCheckouts.setEOpposite(checkoutProject);
		
		checkoutRevision.setEOpposite(revisionCheckouts);
		revisionCheckouts.setEOpposite(checkoutRevision);
		
		revisionConcreteRevisions.setEOpposite(concreteRevisionRevisions);
		concreteRevisionRevisions.setEOpposite(revisionConcreteRevisions);
		
		concreteRevisionProject.setEOpposite(projectConcreteRevisions);
		projectConcreteRevisions.setEOpposite(concreteRevisionProject);
		
		projectClashDetectionSettings.setEOpposite(clashDetectionSettingsProjects);
		clashDetectionSettingsProjects.setEOpposite(projectClashDetectionSettings);
		
		projectGeoTag.setEOpposite(geoTagProjects);
		geoTagProjects.setEOpposite(projectGeoTag);
		
		projectParentProject.setEOpposite(projectSubProjects);
		projectSubProjects.setEOpposite(projectParentProject);
	}
	
	private void createCheckinStateEnum() {
		checkinStateEnum = schema.createEEnum(storePackage, "CheckinState");
		schema.createEEnumLiteral(checkinStateEnum, "UPLOADING");
		schema.createEEnumLiteral(checkinStateEnum, "PARSING");
		schema.createEEnumLiteral(checkinStateEnum, "STORING");
		schema.createEEnumLiteral(checkinStateEnum, "SEARCHING_CLASHES");
		schema.createEEnumLiteral(checkinStateEnum, "DONE");
		schema.createEEnumLiteral(checkinStateEnum, "ERROR");
		schema.createEEnumLiteral(checkinStateEnum, "CLASHES_ERROR");
	}

	private void createSIPrefixEnum() {
		siPrefixEnum = schema.createEEnum(storePackage, "SIPrefix");
		schema.createEEnumLiteral(siPrefixEnum, "meter", 0);
		schema.createEEnumLiteral(siPrefixEnum, "attometer", -18);
		schema.createEEnumLiteral(siPrefixEnum, "femtometer", -15);
		schema.createEEnumLiteral(siPrefixEnum, "picometer", -12);
		schema.createEEnumLiteral(siPrefixEnum, "nanometer", -9);
		schema.createEEnumLiteral(siPrefixEnum, "micrometer", -6);
		schema.createEEnumLiteral(siPrefixEnum, "millimeter", -3);
		schema.createEEnumLiteral(siPrefixEnum, "centimeter", -2);
		schema.createEEnumLiteral(siPrefixEnum, "decimeter", -1);
		schema.createEEnumLiteral(siPrefixEnum, "decameter", 1);
		schema.createEEnumLiteral(siPrefixEnum, "hectometer", 2);
		schema.createEEnumLiteral(siPrefixEnum, "kilometer", 3);
		schema.createEEnumLiteral(siPrefixEnum, "megameter", 6);
		schema.createEEnumLiteral(siPrefixEnum, "gigameter", 9);
		schema.createEEnumLiteral(siPrefixEnum, "terameter", 12);
		schema.createEEnumLiteral(siPrefixEnum, "petameter", 15);
		schema.createEEnumLiteral(siPrefixEnum, "exameter", 18);
	}

	private void createUserTypeEnum() {
		userTypeEnum = schema.createEEnum(storePackage, "UserType");
		schema.createEEnumLiteral(userTypeEnum, "SYSTEM");
		schema.createEEnumLiteral(userTypeEnum, "ADMIN");
		schema.createEEnumLiteral(userTypeEnum, "USER");
		schema.createEEnumLiteral(userTypeEnum, "ANONYMOUS");
	}

	private void createObjectStateEnum() {
		objectStateEnum = schema.createEEnum(storePackage, "ObjectState");
		schema.createEEnumLiteral(objectStateEnum, "ACTIVE");
		schema.createEEnumLiteral(objectStateEnum, "DELETED");
	}

	private void createEidClashClass() {
		schema.createEAttribute(eidClashClass, "eid1", ecorePackage.getELong(), Multiplicity.SINGLE);
		schema.createEAttribute(eidClashClass, "eid2", ecorePackage.getELong(), Multiplicity.SINGLE);
	}

	private void createClashClass() {
		schema.createEAttribute(clashClass, "name1", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(clashClass, "name2", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(clashClass, "type1", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(clashClass, "type2", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEReference(clashClass, "revision1", revisionClass, Multiplicity.SINGLE);
		schema.createEReference(clashClass, "revision2", revisionClass, Multiplicity.SINGLE);
	}

	private void createClashDetectionSettingsClass() {
		schema.createEAttribute(clashDetectionsSettingsClass, "enabled", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		clashDetectionSettingsProjects = schema.createEReference(clashDetectionsSettingsClass, "projects", projectClass, Multiplicity.MANY);
		schema.createEAttribute(clashDetectionsSettingsClass, "margin", ecorePackage.getEFloat(), Multiplicity.SINGLE);
		schema.createEReference(clashDetectionsSettingsClass, "revisions", revisionClass, Multiplicity.MANY);
		schema.createEAttribute(clashDetectionsSettingsClass, "ignoredClasses", ecorePackage.getEString(), Multiplicity.MANY);
	}

	private void createGuidClashClass() {
		schema.createEAttribute(guidClashClass, "guid1", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(guidClashClass, "guid2", ecorePackage.getEString(), Multiplicity.SINGLE);
	}

	private void createRevisionClass() {
		schema.createEAttribute(revisionClass, "id", ecorePackage.getEInt(), Multiplicity.SINGLE);
		schema.createEReference(revisionClass, "user", userClass, Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "date", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "comment", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "size", ecorePackage.getELong(), Multiplicity.SINGLE);
		revisionConcreteRevisions = schema.createEReference(revisionClass, "concreteRevisions", concreteRevisionClass, Multiplicity.MANY);
		schema.createEReference(revisionClass, "lastConcreteRevision", concreteRevisionClass, Multiplicity.SINGLE);
		revisionCheckouts = schema.createEReference(revisionClass, "checkouts", checkoutClass, Multiplicity.MANY);
		revisionProject = schema.createEReference(revisionClass, "project", projectClass, Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "state", checkinStateEnum, Multiplicity.SINGLE);
		schema.createEReference(revisionClass, "lastClashes", clashClass, Multiplicity.MANY);
		schema.createEAttribute(revisionClass, "tag", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "lastError", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "bmi", ecorePackage.getEInt(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "nrClashes", ecorePackage.getEInt(), Multiplicity.SINGLE);
	}

	private void createConcreteRevisionClass() {
		schema.createEAttribute(concreteRevisionClass, "id", ecorePackage.getEInt(), Multiplicity.SINGLE);
		concreteRevisionProject = schema.createEReference(concreteRevisionClass, "project", projectClass, Multiplicity.SINGLE);
		schema.createEAttribute(concreteRevisionClass, "state", checkinStateEnum, Multiplicity.SINGLE);
		schema.createEAttribute(concreteRevisionClass, "checksum", ecorePackage.getEByteArray(), Multiplicity.SINGLE);
		concreteRevisionRevisions = schema.createEReference(concreteRevisionClass, "revisions", revisionClass, Multiplicity.MANY);
		schema.createEAttribute(concreteRevisionClass, "size", ecorePackage.getELong(), Multiplicity.SINGLE);
		schema.createEAttribute(concreteRevisionClass, "date", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(concreteRevisionClass, "lastError", ecorePackage.getEString(), Multiplicity.SINGLE);
	}

	private void createGeoTagClass() {
		schema.createEAttribute(geoTagClass, "enabled", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		geoTagProjects = schema.createEReference(geoTagClass, "projects", projectClass, Multiplicity.MANY);
		schema.createEAttribute(geoTagClass, "x", ecorePackage.getEFloat(), Multiplicity.SINGLE);
		schema.createEAttribute(geoTagClass, "y", ecorePackage.getEFloat(), Multiplicity.SINGLE);
		schema.createEAttribute(geoTagClass, "z", ecorePackage.getEFloat(), Multiplicity.SINGLE);
		schema.createEAttribute(geoTagClass, "epsg", ecorePackage.getEInt(), Multiplicity.SINGLE);
		schema.createEAttribute(geoTagClass, "directionAngle", ecorePackage.getEFloat(), Multiplicity.SINGLE);
	}

	private void createCheckoutClass() {
		schema.createEReference(checkoutClass, "user", userClass, Multiplicity.SINGLE);
		checkoutRevision = schema.createEReference(checkoutClass, "revision", revisionClass, Multiplicity.SINGLE);
		checkoutProject = schema.createEReference(checkoutClass, "project", projectClass, Multiplicity.SINGLE);
		schema.createEAttribute(checkoutClass, "date", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEReference(checkoutClass, "checkin", revisionClass, Multiplicity.SINGLE);
		schema.createEAttribute(checkoutClass, "active", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
	}

	private void createUserClass() {
		schema.createEAttribute(userClass, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "password", ecorePackage.getEString(), Multiplicity.SINGLE);
		userHasRightsOn = schema.createEReference(userClass, "hasRightsOn", projectClass, Multiplicity.MANY);
		schema.createEReference(userClass, "revisions", revisionClass, Multiplicity.MANY);
		schema.createEAttribute(userClass, "state", objectStateEnum, Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "createdOn", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEReference(userClass, "createdBy", userClass, Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "userType", userTypeEnum, Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "username", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "lastSeen", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "validationToken", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "validationTokenCreated", ecorePackage.getEDate(), Multiplicity.SINGLE);
	}

	private void createSettingsClass() {
		schema.createEAttribute(settingsClass, "showVersionUpgradeAvailable", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "sendConfirmationEmailAfterRegistration", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "useCaching", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "allowSelfRegistration", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "autoTestClashes", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "intelligentMerging", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "allowUsersToCreateTopLevelProjects", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "checkinMergingEnabled", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "registrationAddition", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "smtpServer", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "emailSenderAddress", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "enabledExportTypes", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "customLogoAddress", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(settingsClass, "siteAddress", ecorePackage.getEString(), Multiplicity.SINGLE);
	}
	
	private void createProjectClass() {
		schema.createEAttribute(projectClass, "id", ecorePackage.getEInt(), Multiplicity.SINGLE);
		schema.createEAttribute(projectClass, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		projectHasAuthorizedUsers = schema.createEReference(projectClass, "hasAuthorizedUsers", userClass, Multiplicity.MANY);
		projectConcreteRevisions = schema.createEReference(projectClass, "concreteRevisions", concreteRevisionClass, Multiplicity.MANY);
		projectRevisions = schema.createEReference(projectClass, "revisions", revisionClass, Multiplicity.MANY);
		schema.createEReference(projectClass, "lastConcreteRevision", concreteRevisionClass, Multiplicity.SINGLE);
		schema.createEReference(projectClass, "lastRevision", revisionClass, Multiplicity.SINGLE);
		projectCheckouts = schema.createEReference(projectClass, "checkouts", checkoutClass, Multiplicity.MANY);
		schema.createEAttribute(projectClass, "state", objectStateEnum, Multiplicity.SINGLE);
		schema.createEAttribute(projectClass, "createdDate", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEReference(projectClass, "createdBy", userClass, Multiplicity.SINGLE);
		projectGeoTag = schema.createEReference(projectClass, "geoTag", geoTagClass, Multiplicity.SINGLE);
		projectSubProjects = schema.createEReference(projectClass, "subProjects", projectClass, Multiplicity.MANY);
		projectParentProject = schema.createEReference(projectClass, "parent", projectClass, Multiplicity.SINGLE);
		schema.createEAttribute(projectClass, "description", ecorePackage.getEString(), Multiplicity.SINGLE);
		projectClashDetectionSettings = schema.createEReference(projectClass, "clashDetectionSettings", clashDetectionsSettingsClass, Multiplicity.SINGLE);
		schema.createEAttribute(projectClass, "exportLengthMeasurePrefix", siPrefixEnum, Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Initial store model";
	}
}