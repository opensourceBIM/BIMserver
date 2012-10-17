package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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
	private EEnum objectStateEnum;
	private EEnum siPrefixEnum;
	private EClass userClass;
	private EClass checkoutClass;
	private EEnum userTypeEnum;
	private EClass geoTagClass;
	private EClass concreteRevisionClass;
	private EClass projectClass;
	private EReference projectHasAuthorizedUsers;
	private EReference projectConcreteRevisions;
	private EReference projectRevisions;
	private EReference projectCheckouts;
	private EReference projectGeoTag;
	private EReference projectSubProjects;
	private EReference projectParentProject;
	private EReference userHasRightsOn;
	private EReference concreteRevisionProject;
	private EReference concreteRevisionRevisions;
	private EReference revisionConcreteRevisions;
	private EReference revisionCheckouts;
	private EReference revisionProject;
	private EReference checkoutRevision;
	private EReference checkoutProject;
	private EReference geoTagProjects;
	private Schema schema;
	private EClass serverSettingsClass;
	private EClass userSettings;
	private EReference revisionUser;
	private EReference userRevisions;

	@Override
	public void migrate(Schema schema) {
		this.schema = schema;
		storePackage = schema.createEPackage("store");
		
		createUserTypeEnum();
		createSIPrefixEnum();
		createObjectStateEnum();

		projectClass = schema.createEClass(storePackage, "Project");
		userClass = schema.createEClass(storePackage, "User");
		revisionClass = schema.createEClass(storePackage, "Revision");
		concreteRevisionClass = schema.createEClass(storePackage, "ConcreteRevision");
		geoTagClass = schema.createEClass(storePackage, "GeoTag");
		checkoutClass = schema.createEClass(storePackage, "Checkout");
		serverSettingsClass = schema.createEClass(storePackage, "ServerSettings");
		userSettings = schema.createEClass(storePackage, "UserSettings");

		createProjectClass();
		createUserClass();
		createCheckoutClass();
		createGeoTagClass();
		createConcreteRevisionClass();
		createRevisionClass();
		createServerSettingsClass();
		createUserSettingsClass();
		
		userHasRightsOn.setEOpposite(projectHasAuthorizedUsers);
		projectHasAuthorizedUsers.setEOpposite(userHasRightsOn);
		
		revisionProject.setEOpposite(projectRevisions);
		projectRevisions.setEOpposite(revisionProject);
		
		checkoutProject.setEOpposite(projectCheckouts);
		projectCheckouts.setEOpposite(checkoutProject);
		
		checkoutRevision.setEOpposite(revisionCheckouts);
		revisionCheckouts.setEOpposite(checkoutRevision);
		
		revisionUser.setEOpposite(userRevisions);
		userRevisions.setEOpposite(revisionUser);
		
		revisionConcreteRevisions.setEOpposite(concreteRevisionRevisions);
		concreteRevisionRevisions.setEOpposite(revisionConcreteRevisions);
		
		concreteRevisionProject.setEOpposite(projectConcreteRevisions);
		projectConcreteRevisions.setEOpposite(concreteRevisionProject);
		
		projectGeoTag.setEOpposite(geoTagProjects);
		geoTagProjects.setEOpposite(projectGeoTag);
		
		projectParentProject.setEOpposite(projectSubProjects);
		projectSubProjects.setEOpposite(projectParentProject);
		
		EClass pluginConfigurationClass = schema.createEClass(schema.getEPackage("store"), "PluginConfiguration");
		schema.createEAttribute(pluginConfigurationClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginConfigurationClass, "enabled", EcorePackage.eINSTANCE.getEBooleanObject(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginConfigurationClass, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginConfigurationClass, "className", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
	}
	
	private void createUserSettingsClass() {
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
		schema.createEEnumLiteral(userTypeEnum, "READ_ONLY");
	}

	private void createObjectStateEnum() {
		objectStateEnum = schema.createEEnum(storePackage, "ObjectState");
		schema.createEEnumLiteral(objectStateEnum, "ACTIVE");
		schema.createEEnumLiteral(objectStateEnum, "DELETED");
	}

	private void createRevisionClass() {
		schema.createEAttribute(revisionClass, "id", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		revisionUser = schema.createEReference(revisionClass, "user", userClass, Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "date", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "comment", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "size", ecorePackage.getELongObject(), Multiplicity.SINGLE);
		revisionConcreteRevisions = schema.createEReference(revisionClass, "concreteRevisions", concreteRevisionClass, Multiplicity.MANY);
		schema.createEReference(revisionClass, "lastConcreteRevision", concreteRevisionClass, Multiplicity.SINGLE);
		revisionCheckouts = schema.createEReference(revisionClass, "checkouts", checkoutClass, Multiplicity.MANY);
		revisionProject = schema.createEReference(revisionClass, "project", projectClass, Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "tag", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "lastError", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "bmi", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
	}

	private void createConcreteRevisionClass() {
		schema.createEAttribute(concreteRevisionClass, "id", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		concreteRevisionProject = schema.createEReference(concreteRevisionClass, "project", projectClass, Multiplicity.SINGLE);
		schema.createEAttribute(concreteRevisionClass, "checksum", ecorePackage.getEByteArray(), Multiplicity.SINGLE);
		concreteRevisionRevisions = schema.createEReference(concreteRevisionClass, "revisions", revisionClass, Multiplicity.MANY);
		schema.createEAttribute(concreteRevisionClass, "size", ecorePackage.getELongObject(), Multiplicity.SINGLE);
		schema.createEAttribute(concreteRevisionClass, "date", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(concreteRevisionClass, "lastError", ecorePackage.getEString(), Multiplicity.SINGLE);
	}

	private void createGeoTagClass() {
		schema.createEAttribute(geoTagClass, "enabled", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		geoTagProjects = schema.createEReference(geoTagClass, "projects", projectClass, Multiplicity.MANY);
		schema.createEAttribute(geoTagClass, "x", ecorePackage.getEDoubleObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geoTagClass, "y", ecorePackage.getEDoubleObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geoTagClass, "z", ecorePackage.getEDoubleObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geoTagClass, "epsg", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geoTagClass, "directionAngle", ecorePackage.getEDoubleObject(), Multiplicity.SINGLE);
	}

	private void createCheckoutClass() {
		schema.createEReference(checkoutClass, "user", userClass, Multiplicity.SINGLE);
		checkoutRevision = schema.createEReference(checkoutClass, "revision", revisionClass, Multiplicity.SINGLE);
		checkoutProject = schema.createEReference(checkoutClass, "project", projectClass, Multiplicity.SINGLE);
		schema.createEAttribute(checkoutClass, "date", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEReference(checkoutClass, "checkin", revisionClass, Multiplicity.SINGLE);
		schema.createEAttribute(checkoutClass, "active", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
	}

	private void createUserClass() {
		schema.createEAttribute(userClass, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "password", ecorePackage.getEString(), Multiplicity.SINGLE);
		userHasRightsOn = schema.createEReference(userClass, "hasRightsOn", projectClass, Multiplicity.MANY);
		userRevisions = schema.createEReference(userClass, "revisions", revisionClass, Multiplicity.MANY);
		schema.createEAttribute(userClass, "state", objectStateEnum, Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "createdOn", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEReference(userClass, "createdBy", userClass, Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "userType", userTypeEnum, Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "username", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "lastSeen", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "token", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "validationToken", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userClass, "validationTokenCreated", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEReference(userClass, "userSettings", userSettings, Multiplicity.SINGLE);
	}

	private void createServerSettingsClass() {
		schema.createEAttribute(serverSettingsClass, "showVersionUpgradeAvailable", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettingsClass, "sendConfirmationEmailAfterRegistration", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettingsClass, "useCaching", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettingsClass, "allowSelfRegistration", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettingsClass, "allowUsersToCreateTopLevelProjects", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettingsClass, "checkinMergingEnabled", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettingsClass, "registrationAddition", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettingsClass, "smtpServer", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettingsClass, "emailSenderAddress", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettingsClass, "customLogoAddress", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettingsClass, "siteAddress", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettingsClass, "whitelistedDomains", ecorePackage.getEString(), Multiplicity.MANY);
		schema.createEAttribute(serverSettingsClass, "hideUserListForNonAdmin", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettingsClass, "protocolBuffersPort", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
	}
	
	private void createProjectClass() {
		schema.createEAttribute(projectClass, "id", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
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
		schema.createEAttribute(projectClass, "exportLengthMeasurePrefix", siPrefixEnum, Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Initial store model";
	}
}