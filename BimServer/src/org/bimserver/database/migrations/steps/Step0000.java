package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import javax.activation.DataHandler;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
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
	private EClass user;
	private EClass checkoutClass;
	private EEnum userTypeEnum;
	private EClass geoTagClass;
	private EClass concreteRevisionClass;
	private EClass project;
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
	private EClass serverSettings;
	private EClass userSettings;

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		this.schema = schema;
		storePackage = schema.createEPackage("store");
		
		createUserTypeEnum();
		createSIPrefixEnum();
		createObjectStateEnum();

		project = schema.createEClass(storePackage, "Project");
		user = schema.createEClass(storePackage, "User");
		revisionClass = schema.createEClass(storePackage, "Revision");
		concreteRevisionClass = schema.createEClass(storePackage, "ConcreteRevision");
		geoTagClass = schema.createEClass(storePackage, "GeoTag");
		checkoutClass = schema.createEClass(storePackage, "Checkout");
		serverSettings = schema.createEClass(storePackage, "ServerSettings");
		userSettings = schema.createEClass(storePackage, "UserSettings");

		createProjectClass();
		createUserClass();
		createCheckoutClass();
		createGeoTagClass();
		createConcreteRevisionClass();
		createRevisionClass();
		createServerSettingsClass();
		
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
		
		projectGeoTag.setEOpposite(geoTagProjects);
		geoTagProjects.setEOpposite(projectGeoTag);
		
		projectParentProject.setEOpposite(projectSubProjects);
		projectSubProjects.setEOpposite(projectParentProject);
		
		EPackage logPackage = schema.createEPackage("log");
		
		EEnum accessMethodEnum = schema.createEEnum(logPackage, "AccessMethod");
		schema.createEEnumLiteral(accessMethodEnum, "SOAP");
		schema.createEEnumLiteral(accessMethodEnum, "WEB_INTERFACE");
		schema.createEEnumLiteral(accessMethodEnum, "INTERNAL");
		schema.createEEnumLiteral(accessMethodEnum, "REST");
		schema.createEEnumLiteral(accessMethodEnum, "SYNDICATION");
		schema.createEEnumLiteral(accessMethodEnum, "JSON");
		
		EClass logAction = schema.createEClass(logPackage, "LogAction");
		schema.createEAttribute(logAction, "date", EcorePackage.eINSTANCE.getEDate(), Multiplicity.SINGLE);
		schema.createEReference(logAction, "executor", user, Multiplicity.SINGLE);
		schema.createEAttribute(logAction, "accessMethod", accessMethodEnum, Multiplicity.SINGLE);

		EClass serverLogClass = schema.createEClass(logPackage, "ServerLog");
		schema.createEReference(serverLogClass, "actions", logAction, Multiplicity.MANY);
		
		EClass projectRelated = schema.createEClass(logPackage, "ProjectRelated", logAction);
		EReference projectRelatedProject = schema.createEReference(projectRelated, "project", project, Multiplicity.SINGLE);

		EClass checkoutRelated = schema.createEClass(logPackage, "CheckoutRelated", logAction);
		EReference checkoutRelatedCheckout = schema.createEReference(checkoutRelated, "checkout", checkoutClass, Multiplicity.SINGLE);

		EClass revisionRelated = schema.createEClass(logPackage, "RevisionRelated", logAction);
		EReference revisionRelatedRevision = schema.createEReference(revisionRelated, "revision", revisionClass, Multiplicity.SINGLE);

		EClass userRelated = schema.createEClass(logPackage, "UserRelated", logAction);
		EReference userRelatedUser = schema.createEReference(userRelated, "user", user, Multiplicity.SINGLE);

		schema.createEClass(logPackage, "NewUserAdded", userRelated);

		EClass newProjectAddedClass = schema.createEClass(logPackage, "NewProjectAdded", projectRelated);
		schema.createEReference(newProjectAddedClass, "parentProject", project, Multiplicity.SINGLE);

		EClass revisionBrancedClass = schema.createEClass(logPackage, "RevisionBranched", logAction);
		schema.createEReference(revisionBrancedClass, "oldrevision", revisionClass, Multiplicity.SINGLE);
		schema.createEReference(revisionBrancedClass, "newrevision", revisionClass, Multiplicity.SINGLE);
	
		EClass newRevisionAdded = schema.createEClass(logPackage, "NewRevisionAdded", revisionRelated);
		schema.createEReference(newRevisionAdded, "project", project, Multiplicity.SINGLE);
		
		schema.createEClass(logPackage, "NewCheckoutAdded", checkoutRelated);
		schema.createEClass(logPackage, "SettingsSaved", logAction);
		
		EClass userAddedToProject = schema.createEClass(logPackage, "UserAddedToProject", userRelated); // and actually also projectRelated
		schema.createEReference(userAddedToProject, "project", project, Multiplicity.SINGLE);
		
		schema.createEClass(logPackage, "NewObjectIDMUploaded", logAction);
		schema.createEClass(logPackage, "Download", logAction);

		EClass userRemovedFromProject = schema.createEClass(logPackage, "UserRemovedFromProject", userRelated); // and actually also projectRelated
		schema.createEReference(userRemovedFromProject, "project", project, Multiplicity.SINGLE);
		
		schema.createEClass(logPackage, "ProjectDeleted", projectRelated);
		schema.createEClass(logPackage, "UserDeleted", userRelated);
		schema.createEClass(logPackage, "PasswordReset", userRelated);
		
		EClass databaseCreatedClass = schema.createEClass(logPackage, "DatabaseCreated", logAction);
		schema.createEAttribute(databaseCreatedClass, "path", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(databaseCreatedClass, "version", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		
		schema.createEClass(logPackage, "ServerStarted", logAction);
		schema.createEClass(logPackage, "ProjectUpdated", projectRelated);
		schema.createEClass(logPackage, "UserUndeleted", userRelated);
		schema.createEClass(logPackage, "ProjectUndeleted", projectRelated);
		schema.createEClass(logPackage, "RevisionUpdated", revisionRelated);
		
		EClass geoTagUpdatedClass = schema.createEClass(logPackage, "GeoTagUpdated", logAction);
		schema.createEReference(geoTagUpdatedClass, "geoTag", geoTagClass, Multiplicity.SINGLE);
		
		schema.createEClass(logPackage, "PasswordChanged", userRelated);
		schema.createEClass(logPackage, "UserChanged", userRelated);
		
		EClass pluginConfiguration = schema.createEClass(storePackage, "PluginConfiguration");
		schema.createEAttribute(pluginConfiguration, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginConfiguration, "enabled", EcorePackage.eINSTANCE.getEBooleanObject(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginConfiguration, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);

		EClass serializerPluginConfiguration = schema.createEClass(storePackage, "SerializerPluginConfiguration", pluginConfiguration);
		EClass objectIDMPluginConfiguration = schema.createEClass(storePackage, "ObjectIDMPluginConfiguration", pluginConfiguration);

		EReference serializerObjectIDMReference = schema.createEReference(serializerPluginConfiguration, "objectIDM", objectIDMPluginConfiguration, Multiplicity.SINGLE);
		EReference serializerSettingsReference = schema.createEReference(serializerPluginConfiguration, "userSettings", userSettings, Multiplicity.SINGLE);
		
		EReference objectIDMSerializers = schema.createEReference(objectIDMPluginConfiguration, "serializers", serializerPluginConfiguration, Multiplicity.MANY);
		EReference objectIDMSettingsReference = schema.createEReference(objectIDMPluginConfiguration, "userSettings", userSettings, Multiplicity.SINGLE);
		
		EReference settingsSerializersReference = schema.createEReference(userSettings, "serializers", serializerPluginConfiguration, Multiplicity.MANY);
		EReference settingsObjectIDMReference = schema.createEReference(userSettings, "objectIDMs", objectIDMPluginConfiguration, Multiplicity.MANY);
		
		serializerSettingsReference.setEOpposite(settingsSerializersReference);
		objectIDMSettingsReference.setEOpposite(settingsObjectIDMReference);

		settingsSerializersReference.setEOpposite(serializerSettingsReference);
		settingsObjectIDMReference.setEOpposite(objectIDMSettingsReference);
		
		objectIDMSerializers.setEOpposite(serializerObjectIDMReference);
		serializerObjectIDMReference.setEOpposite(objectIDMSerializers);

		schema.createEAttribute(serverSettings, "cacheOutputFiles", EcorePackage.eINSTANCE.getEBooleanObject(), Multiplicity.SINGLE);
		
		EClass renderEnginePluginConfiguration = schema.createEClass(storePackage, "RenderEnginePluginConfiguration", pluginConfiguration);

		EReference renderEngineSerializersReference = schema.createEReference(renderEnginePluginConfiguration, "serializers", serializerPluginConfiguration, Multiplicity.MANY);
		EReference serializerRenderEngineReference = schema.createEReference(serializerPluginConfiguration, "renderEngine", renderEnginePluginConfiguration, Multiplicity.SINGLE);
		
		serializerRenderEngineReference.setEOpposite(renderEngineSerializersReference);
		renderEngineSerializersReference.setEOpposite(serializerRenderEngineReference);
		
		EReference renderEngineSettings = schema.createEReference(renderEnginePluginConfiguration, "userSettings", userSettings, Multiplicity.SINGLE);

		EReference settingsRenderEngines = schema.createEReference(userSettings, "renderEngines", renderEnginePluginConfiguration, Multiplicity.MANY);

		settingsRenderEngines.setEOpposite(renderEngineSettings);
		renderEngineSettings.setEOpposite(settingsRenderEngines);
		
		EClass deserializerPluginClass = schema.createEClass(storePackage, "DeserializerPluginConfiguration", pluginConfiguration);

		EReference deserializerSettingsReference = schema.createEReference(deserializerPluginClass, "userSettings", userSettings, Multiplicity.SINGLE);
		EReference settingsDeserializersReference = schema.createEReference(userSettings, "deserializers", deserializerPluginClass, Multiplicity.MANY);
		
		deserializerSettingsReference.setEOpposite(settingsDeserializersReference);
		settingsDeserializersReference.setEOpposite(deserializerSettingsReference);
		
		EDataType dataHandler = schema.createEDataType(storePackage, EcoreFactory.eINSTANCE.createEDataType());
		dataHandler.setName("DataHandler");
		dataHandler.setInstanceClass(DataHandler.class);
		
		EClass downloadResultClass = schema.createEClass(storePackage, "DownloadResult");
		schema.createEAttribute(downloadResultClass, "projectName", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(downloadResultClass, "revisionNr", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(downloadResultClass, "file", dataHandler, Multiplicity.SINGLE);

		schema.createEClass(storePackage, "CheckoutResult", downloadResultClass);
		
		EClass dataValue = schema.createEClass(storePackage, "DataValue");
		schema.createEAttribute(dataValue, "fieldName", ecorePackage.getEString(), Multiplicity.SINGLE);

		EClass dataObjectClass = schema.createEClass(storePackage, "DataObject");
		schema.createEAttribute(dataObjectClass, "type", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(dataObjectClass, "guid", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(dataObjectClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(dataObjectClass, "values", dataValue, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EClass userSessionClass = schema.createEClass(storePackage, "UserSession");
		schema.createEReference(userSessionClass, "user", user, Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "username", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "type", schema.getEEnum("store", "UserType"), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "remoteAddress", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "activeSince", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "lastActive", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "accessMethod", schema.getEEnum("log", "AccessMethod"), Multiplicity.SINGLE);
		
		EClass migrationClass = schema.createEClass(storePackage, "Migration");
		schema.createEAttribute(migrationClass, "number", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(migrationClass, "description", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(migrationClass, "executed", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		
		EClass referenceDataValue = schema.createEClass(storePackage, "ReferenceDataValue", dataValue);
		schema.createEAttribute(referenceDataValue, "typeName", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(referenceDataValue, "guid", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EClass listDataValue = schema.createEClass(storePackage, "ListDataValue", dataValue);
		schema.createEReference(listDataValue, "values", dataValue, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EClass simpleDataValue = schema.createEClass(storePackage, "SimpleDataValue", dataValue);
		schema.createEAttribute(simpleDataValue, "stringValue", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EClass databaseInformationItem = schema.createEClass(storePackage, "DatabaseInformationItem");
		schema.createEAttribute(databaseInformationItem, "key", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(databaseInformationItem, "value", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EClass databaseInformationCategoryClass = schema.createEClass(storePackage, "DatabaseInformationCategory");
		schema.createEAttribute(databaseInformationCategoryClass, "title", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEReference(databaseInformationCategoryClass, "items", databaseInformationItem, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EClass databaseInformationClass = schema.createEClass(storePackage, "DatabaseInformation");
		schema.createEAttribute(databaseInformationClass, "numberOfProjects", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(databaseInformationClass, "numberOfUsers", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(databaseInformationClass, "numberOfRevisions", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(databaseInformationClass, "numberOfCheckouts", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(databaseInformationClass, "databaseSizeInBytes", ecorePackage.getELongObject(), Multiplicity.SINGLE);
		schema.createEAttribute(databaseInformationClass, "type", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(databaseInformationClass, "created", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(databaseInformationClass, "location", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(databaseInformationClass, "schemaVersion", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEReference(databaseInformationClass, "categories", databaseInformationCategoryClass, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EClass pluginDescriptor = schema.createEClass(storePackage, "PluginDescriptor");
		schema.createEAttribute(pluginDescriptor, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginDescriptor, "pluginClassName", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginDescriptor, "description", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginDescriptor, "location", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginDescriptor, "enabled", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginDescriptor, "pluginInterfaceClassName", ecorePackage.getEString(), Multiplicity.SINGLE);

		EReference pluginConfigurationPluginDescriptor = schema.createEReference(pluginConfiguration, "pluginDescriptor", pluginDescriptor, Multiplicity.SINGLE);
		EReference pluginDescriptorPluginConfiguration = schema.createEReference(pluginDescriptor, "configurations", pluginConfiguration, Multiplicity.MANY);
		
		pluginDescriptorPluginConfiguration.setEOpposite(pluginConfigurationPluginDescriptor);
		pluginConfigurationPluginDescriptor.setEOpposite(pluginDescriptorPluginConfiguration);
		
		EClass revisionSummaryTypeClass = schema.createEClass(storePackage, "RevisionSummaryType");
		schema.createEAttribute(revisionSummaryTypeClass, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionSummaryTypeClass, "count", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		
		EClass revisionSummaryContainerClass = schema.createEClass(storePackage, "RevisionSummaryContainer");
		schema.createEAttribute(revisionSummaryContainerClass, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEReference(revisionSummaryContainerClass, "types", revisionSummaryTypeClass, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EClass revisionSummaryClass = schema.createEClass(storePackage, "RevisionSummary");
		schema.createEReference(revisionSummaryClass, "list", revisionSummaryContainerClass, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEReference(concreteRevisionClass, "summary", revisionSummaryClass, Multiplicity.SINGLE);
		
		EClass longActionClass = schema.createEClass(storePackage, "LongAction");
		schema.createEAttribute(longActionClass, "identification", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEReference(longActionClass, "user", user, Multiplicity.SINGLE);
		schema.createEAttribute(longActionClass, "start", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(longActionClass, "username", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(longActionClass, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EClass objectIDMPluginDescriptor = schema.createEClass(storePackage, "ObjectIDMPluginDescriptor");
		schema.createEAttribute(objectIDMPluginDescriptor, "className", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EEnum compareTypeEnum = schema.createEEnum(storePackage, "CompareType");
		schema.createEEnumLiteral(compareTypeEnum, "ALL");
		schema.createEEnumLiteral(compareTypeEnum, "ADD");
		schema.createEEnumLiteral(compareTypeEnum, "MODIFY");
		schema.createEEnumLiteral(compareTypeEnum, "DELETE");
		
		EClass compareItemClass = schema.createEClass(storePackage, "CompareItem");
		schema.createEReference(compareItemClass, "dataObject", dataObjectClass, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		schema.createEClass(storePackage, "ObjectAdded", compareItemClass);
		
		schema.createEClass(storePackage, "ObjectRemoved", compareItemClass);
		
		EClass objectModified = schema.createEClass(storePackage, "ObjectModified", compareItemClass);
		schema.createEAttribute(objectModified, "fieldName", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(objectModified, "oldValue", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(objectModified, "newValue", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EClass compareContainerClass = schema.createEClass(storePackage, "CompareContainer");
		schema.createEAttribute(compareContainerClass, "type", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEReference(compareContainerClass, "items", compareItemClass, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());

		EClass compareResultClass = schema.createEClass(storePackage, "CompareResult");		
		schema.createEReference(compareResultClass, "items", compareContainerClass, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EEnum actionStateEnum = schema.createEEnum(storePackage, "ActionState");
		schema.createEEnumLiteral(actionStateEnum, "UNKNOWN");
		schema.createEEnumLiteral(actionStateEnum, "STARTED");
		schema.createEEnumLiteral(actionStateEnum, "AS_ERROR");
		schema.createEEnumLiteral(actionStateEnum, "FINISHED");
		
		EClass longActionStateClass = schema.createEClass(storePackage, "LongActionState");
		schema.createEAttribute(longActionStateClass, "start", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(longActionStateClass, "end", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(longActionStateClass, "progress", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(longActionStateClass, "state", actionStateEnum, Multiplicity.SINGLE);
		schema.createEAttribute(longActionStateClass, "title", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(longActionStateClass, "stage", EcorePackage.eINSTANCE.getEInt(), Multiplicity.SINGLE);
		schema.createEAttribute(longActionStateClass, "errors", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(longActionStateClass, "warnings", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(longActionStateClass, "infos", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		
		schema.createEEnumLiteral(accessMethodEnum, "PROTOCOL_BUFFERS");
		
		EEnum serverState = schema.createEEnum(storePackage, "ServerState");
		schema.createEEnumLiteral(serverState, "UNDEFINED");
		schema.createEEnumLiteral(serverState, "NOT_SETUP");
		schema.createEEnumLiteral(serverState, "SETUP");
		schema.createEEnumLiteral(serverState, "MIGRATION_REQUIRED");
		schema.createEEnumLiteral(serverState, "MIGRATION_IMPOSSIBLE");
		schema.createEEnumLiteral(serverState, "FATAL_ERROR");
		schema.createEEnumLiteral(serverState, "RUNNING");
		
		EClass serverInfoClass = schema.createEClass(storePackage, "ServerInfo");
		schema.createEAttribute(serverInfoClass, "serverState", serverState, Multiplicity.SINGLE);
		schema.createEAttribute(serverInfoClass, "errorMessage", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EClass versionInfoClass = schema.createEClass(storePackage, "Version");
		schema.createEAttribute(versionInfoClass, "major", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "minor", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "revision", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "fullString", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "date", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "downloadUrl", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "supportUrl", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(versionInfoClass, "supportEmail", ecorePackage.getEString(), Multiplicity.SINGLE);

		schema.createEReference(concreteRevisionClass, "user", user, Multiplicity.SINGLE);

		EClass file = schema.createEClass("store", "File");
		schema.createEAttribute(file, "data", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(file, "filename", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(file, "mime", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(file, "size", EcorePackage.eINSTANCE.getELong(), Multiplicity.SINGLE);
		
		EClass extendedDataSchema = schema.createEClass(storePackage, "ExtendedDataSchema");
		schema.createEAttribute(extendedDataSchema, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataSchema, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataSchema, "contentType", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataSchema, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(extendedDataSchema, "file", file, Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataSchema, "size", EcorePackage.eINSTANCE.getELong(), Multiplicity.SINGLE);
		
		EClass extendedDataClass = schema.createEClass(storePackage, "ExtendedData");
		schema.createEAttribute(extendedDataClass, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(extendedDataClass, "file", file, Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataClass, "size", EcorePackage.eINSTANCE.getELong(), Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataClass, "title", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(extendedDataClass, "added", EcorePackage.eINSTANCE.getEDate(), Multiplicity.SINGLE);
		
		EReference userToExtendedDataSchema = schema.createEReference(user, "schemas", extendedDataSchema, Multiplicity.MANY);
		EReference extendedDataSchemaToUser = schema.createEReference(extendedDataSchema, "users", user, Multiplicity.MANY);
		userToExtendedDataSchema.setEOpposite(extendedDataSchemaToUser);
		extendedDataSchemaToUser.setEOpposite(userToExtendedDataSchema);

		EReference extendedDataToUser = schema.createEReference(extendedDataClass, "user", user, Multiplicity.SINGLE);
		EReference userToExtendedData = schema.createEReference(user, "extendedData", extendedDataClass, Multiplicity.MANY);
		extendedDataToUser.setEOpposite(userToExtendedData);
		userToExtendedData.setEOpposite(extendedDataToUser);
		
		EReference extendedDataToExtendedDataSchema = schema.createEReference(extendedDataClass, "schema", extendedDataSchema, Multiplicity.SINGLE);
		EReference extendedDataSchemaToExtendedData = schema.createEReference(extendedDataSchema, "extendedData", extendedDataClass, Multiplicity.MANY);
		extendedDataToExtendedDataSchema.setEOpposite(extendedDataSchemaToExtendedData);
		extendedDataSchemaToExtendedData.setEOpposite(extendedDataToExtendedDataSchema);
		
		EReference revisionExtendedData = schema.createEReference(revisionClass, "extendedData", extendedDataClass, Multiplicity.MANY);
		EReference extendedDataRevision = schema.createEReference(extendedDataClass, "revision", revisionClass, Multiplicity.SINGLE);
		
		revisionExtendedData.setEOpposite(extendedDataRevision);
		extendedDataRevision.setEOpposite(revisionExtendedData);
		
		EReference projectExtendedData = schema.createEReference(project, "extendedData", extendedDataClass, Multiplicity.MANY);
		EReference extendedDataProject = schema.createEReference(extendedDataClass, "project", project, Multiplicity.SINGLE);
		
		projectExtendedData.setEOpposite(extendedDataProject);
		extendedDataProject.setEOpposite(projectExtendedData);
		
		EClass queryEnginePluginConfiguration = schema.createEClass(storePackage, "QueryEnginePluginConfiguration", pluginConfiguration);

		EReference queryEngineSettingsReference = schema.createEReference(queryEnginePluginConfiguration, "userSettings", userSettings, Multiplicity.SINGLE);
		EReference settingsQueryEnginesReference = schema.createEReference(userSettings, "queryEngines", queryEnginePluginConfiguration, Multiplicity.MANY);
		
		queryEngineSettingsReference.setEOpposite(settingsQueryEnginesReference);
		settingsQueryEnginesReference.setEOpposite(queryEngineSettingsReference);

		EClass webModulePluginConfiguration = schema.createEClass(storePackage, "WebModulePluginConfiguration", pluginConfiguration);
		
		EReference webModulePluginSettingsReference = schema.createEReference(webModulePluginConfiguration, "serverSettings", serverSettings, Multiplicity.SINGLE);
		EReference settingsWebReference = schema.createEReference(serverSettings, "webModules", webModulePluginConfiguration, Multiplicity.MANY);
		
		webModulePluginSettingsReference.setEOpposite(settingsWebReference);
		settingsWebReference.setEOpposite(webModulePluginSettingsReference);
		
		EClass modelMergerPluginConfiguration = schema.createEClass(storePackage, "ModelMergerPluginConfiguration", pluginConfiguration);

		EReference modelMergerSettingsReference = schema.createEReference(modelMergerPluginConfiguration, "userSettings", userSettings, Multiplicity.SINGLE);
		EReference settingsModelMergersReference = schema.createEReference(userSettings, "modelMergers", modelMergerPluginConfiguration, Multiplicity.MANY);
		
		modelMergerSettingsReference.setEOpposite(settingsModelMergersReference);
		settingsModelMergersReference.setEOpposite(modelMergerSettingsReference);

		EClass modelComparePluginConfiguration = schema.createEClass(storePackage, "ModelComparePluginConfiguration", pluginConfiguration);

		EReference modelCompareSettingsReference = schema.createEReference(modelComparePluginConfiguration, "userSettings", userSettings, Multiplicity.SINGLE);
		EReference settingsModelComparesReference = schema.createEReference(userSettings, "modelCompares", modelComparePluginConfiguration, Multiplicity.MANY);

		modelCompareSettingsReference.setEOpposite(settingsModelComparesReference);
		settingsModelComparesReference.setEOpposite(modelCompareSettingsReference);
		
		schema.createEReference(userSettings, "defaultModelMerger", modelMergerPluginConfiguration, Multiplicity.SINGLE);
		schema.createEReference(userSettings, "defaultModelCompare", modelComparePluginConfiguration, Multiplicity.SINGLE);
		schema.createEReference(userSettings, "defaultQueryEngine", queryEnginePluginConfiguration, Multiplicity.SINGLE);
		schema.createEReference(userSettings, "defaultRenderEngine", renderEnginePluginConfiguration, Multiplicity.SINGLE);
		schema.createEReference(userSettings, "defaultSerializer", serializerPluginConfiguration, Multiplicity.SINGLE);
		schema.createEReference(userSettings, "defaultObjectIDM", objectIDMPluginConfiguration, Multiplicity.SINGLE);
		schema.createEReference(serverSettings, "webModule", webModulePluginConfiguration, Multiplicity.SINGLE);

		EEnum trigger = schema.createEEnum("store", "Trigger");
		schema.createEEnumLiteral(trigger, "NEW_REVISION");
		schema.createEEnumLiteral(trigger, "NEW_PROJECT");
		schema.createEEnumLiteral(trigger, "NEW_EXTENDED_DATA");
		
		EClass profileDescriptor = schema.createEClass(storePackage, "ProfileDescriptor");
		profileDescriptor.getEAnnotations().add(createNoDatabaseAnnotation());
		schema.createEAttribute(profileDescriptor, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(profileDescriptor, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(profileDescriptor, "publicProfile", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(profileDescriptor, "identifier", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);

		EClass serviceDescriptor = schema.createEClass(storePackage, "ServiceDescriptor");
		serviceDescriptor.getEAnnotations().add(createNoDatabaseAnnotation());
		schema.createEAttribute(serviceDescriptor, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "token", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "identifier", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "notificationProtocol", schema.getEEnum("log", "AccessMethod"), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "trigger", trigger, Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "readRevision", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "readExtendedData", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "writeRevision", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "writeExtendedData", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceDescriptor, "providerName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		EClass service = schema.createEClass("store", "Service");
		schema.createEAttribute(service, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "serviceName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "serviceIdentifier", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "providerName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "url", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "token", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "notificationProtocol", schema.getEEnum("log", "AccessMethod"), Multiplicity.SINGLE);
		schema.createEAttribute(service, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "trigger", trigger, Multiplicity.SINGLE);
		schema.createEAttribute(service, "readRevision", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEReference(service, "readExtendedData", extendedDataSchema, Multiplicity.SINGLE);
		schema.createEReference(service, "writeRevision", project, Multiplicity.SINGLE);
		schema.createEReference(service, "writeExtendedData", extendedDataSchema, Multiplicity.SINGLE);
		schema.createEAttribute(service, "profileIdentifier", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "profileName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "profileDescription", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(service, "profilePublic", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		
		EReference serviceProject = schema.createEReference(service, "project", project, Multiplicity.SINGLE);
		EReference projectServices = schema.createEReference(project, "services", service, Multiplicity.MANY);
		
		serviceProject.setEOpposite(projectServices);
		projectServices.setEOpposite(serviceProject);
		
		EReference serviceUser = schema.createEReference(service, "user", user, Multiplicity.SINGLE);
		EReference userServices = schema.createEReference(user, "services", service, Multiplicity.MANY);
		
		serviceUser.setEOpposite(userServices);
		userServices.setEOpposite(serviceUser);
		
		schema.createEAttribute(serverSettings, "serviceRepositoryUrl", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		EClass tokenClass = schema.createEClass("store", "Token");
		schema.createEAttribute(tokenClass, "tokenString", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(tokenClass, "expires", EcorePackage.eINSTANCE.getELong(), Multiplicity.SINGLE);
		
		EClass internalServicePluginConfiguration = schema.createEClass(storePackage, "InternalServicePluginConfiguration", pluginConfiguration);
		schema.createEAttribute(internalServicePluginConfiguration, "remoteAccessible", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		
		schema.createEReference(service, "internalService", internalServicePluginConfiguration, Multiplicity.SINGLE);

		EReference serviceSettingsReference = schema.createEReference(internalServicePluginConfiguration, "userSettings", userSettings, Multiplicity.SINGLE);
		EReference settingsServicesReference = schema.createEReference(userSettings, "services", internalServicePluginConfiguration, Multiplicity.MANY);
		
		serviceSettingsReference.setEOpposite(settingsServicesReference);
		settingsServicesReference.setEOpposite(serviceSettingsReference);

		EClass serviceInterface = schema.createEClass("store", "ServiceInterface");
		serviceInterface.getEAnnotations().add(createNoDatabaseAnnotation());
		schema.createEAttribute(serviceInterface, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceInterface, "nameSpace", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceInterface, "simpleName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		EClass serviceMethod = schema.createEClass("store", "ServiceMethod");
		serviceMethod.getEAnnotations().add(createNoDatabaseAnnotation());
		schema.createEAttribute(serviceMethod, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceMethod, "doc", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceMethod, "returnDoc", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);

		EEnum serviceSimpleType = schema.createEEnum("store", "ServiceSimpleType");
		
		schema.createEEnumLiteral(serviceSimpleType, "ENUM");
		schema.createEEnumLiteral(serviceSimpleType, "STRING");
		schema.createEEnumLiteral(serviceSimpleType, "LONG");
		schema.createEEnumLiteral(serviceSimpleType, "INT");
		schema.createEEnumLiteral(serviceSimpleType, "BOOLEAN");
		schema.createEEnumLiteral(serviceSimpleType, "FLOAT");
		schema.createEEnumLiteral(serviceSimpleType, "DOUBLE");
		schema.createEEnumLiteral(serviceSimpleType, "DATE");
		schema.createEEnumLiteral(serviceSimpleType, "CLASS");
		schema.createEEnumLiteral(serviceSimpleType, "DATAHANDLER");
		schema.createEEnumLiteral(serviceSimpleType, "BYTEARRAY");
		schema.createEEnumLiteral(serviceSimpleType, "LIST");
		schema.createEEnumLiteral(serviceSimpleType, "SET");
		schema.createEEnumLiteral(serviceSimpleType, "VOID");
		schema.createEEnumLiteral(serviceSimpleType, "UNKNOWN");
		
		EClass serviceField = schema.createEClass("store", "ServiceField");
		serviceField.getEAnnotations().add(createNoDatabaseAnnotation());
		EClass serviceType = schema.createEClass("store", "ServiceType");

		schema.createEAttribute(serviceField, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(serviceField, "type", serviceType, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEReference(serviceField, "genericType", serviceType, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEAttribute(serviceField, "doc", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		schema.createEAttribute(serviceType, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceType, "simpleName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(serviceType, "fields", serviceField, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEAttribute(serviceType, "simpleType", serviceSimpleType, Multiplicity.SINGLE).getEAnnotations();

		EClass serviceParameter = schema.createEClass("store", "ServiceParameter");
		serviceParameter.getEAnnotations().add(createNoDatabaseAnnotation());
		schema.createEAttribute(serviceParameter, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceParameter, "doc", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(serviceParameter, "type", serviceType, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEReference(serviceParameter, "genericType", serviceType, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EClass extendedDataAddedToRevision = schema.createEClass(logPackage, "ExtendedDataAddedToRevision", logAction);
		schema.createEReference(extendedDataAddedToRevision, "revision", revisionClass, Multiplicity.SINGLE);
		schema.createEReference(extendedDataAddedToRevision, "extendedData", extendedDataClass, Multiplicity.SINGLE);
		
		EClass extendedDataAddedToProject = schema.createEClass(logPackage, "ExtendedDataAddedToProject", logAction);
		schema.createEReference(extendedDataAddedToProject, "project", project, Multiplicity.SINGLE);
		schema.createEReference(extendedDataAddedToProject, "extendedData", extendedDataClass, Multiplicity.SINGLE);

		EEnum primitiveEnum = schema.createEEnum("store", "PrimitiveEnum");
		schema.createEEnumLiteral(primitiveEnum, "LONG");
		schema.createEEnumLiteral(primitiveEnum, "DOUBLE");
		schema.createEEnumLiteral(primitiveEnum, "BOOLEAN");
		schema.createEEnumLiteral(primitiveEnum, "STRING");
		schema.createEEnumLiteral(primitiveEnum, "BYTE_ARRAY");

		EClass typeDefinition = schema.createEClass("store", "TypeDefinition");
		typeDefinition.getEAnnotations().add(createNoDatabaseAnnotation());
		EClass objectDefinition = schema.createEClass("store", "ObjectDefinition", typeDefinition);
		objectDefinition.getEAnnotations().add(createNoDatabaseAnnotation());
		EClass primitiveDefinition = schema.createEClass("store", "PrimitiveDefinition", typeDefinition);
		primitiveDefinition.getEAnnotations().add(createNoDatabaseAnnotation());
		EClass arrayDefinition = schema.createEClass("store", "ArrayDefinition", typeDefinition);
		arrayDefinition.getEAnnotations().add(createNoDatabaseAnnotation());
		EClass parameterDefinition = schema.createEClass("store", "ParameterDefinition");
		parameterDefinition.getEAnnotations().add(createNoDatabaseAnnotation());
		
		schema.createEAttribute(parameterDefinition, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(parameterDefinition, "identifier", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(parameterDefinition, "required", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(parameterDefinition, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(parameterDefinition, "type", typeDefinition, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		schema.createEReference(objectDefinition, "parameters", parameterDefinition, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		schema.createEAttribute(primitiveDefinition, "type", primitiveEnum, Multiplicity.SINGLE);
		
		schema.createEReference(arrayDefinition, "type", typeDefinition, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EClass type = schema.createEClass("store", "Type");
		EClass objectType = schema.createEClass("store", "ObjectType", type);
		EClass primitiveType = schema.createEClass("store", "PrimitiveType", type);
		EClass longType = schema.createEClass("store", "LongType", primitiveType);
		EClass byteArrayType = schema.createEClass("store", "ByteArrayType", primitiveType);
		EClass doubleType = schema.createEClass("store", "DoubleType", primitiveType);
		EClass stringType = schema.createEClass("store", "StringType", primitiveType);
		EClass booleanType = schema.createEClass("store", "BooleanType", primitiveType);
		EClass arrayType = schema.createEClass("store", "ArrayType", type);
		EClass parameter = schema.createEClass("store", "Parameter");
		
		schema.createEAttribute(objectType, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(objectType, "parameters", parameter, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEAttribute(parameter, "identifier", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(parameter, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(parameter, "value", type, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());

		schema.createEReference(parameterDefinition, "defaultValue", type, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		schema.createEReference(arrayType, "values", type, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		schema.createEAttribute(longType, "value", EcorePackage.eINSTANCE.getELong(), Multiplicity.SINGLE);
		schema.createEAttribute(doubleType, "value", EcorePackage.eINSTANCE.getEDouble(), Multiplicity.SINGLE);
		schema.createEAttribute(byteArrayType, "value", EcorePackage.eINSTANCE.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(stringType, "value", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(booleanType, "value", EcorePackage.eINSTANCE.getEBoolean(), Multiplicity.SINGLE);
		
		schema.createEReference(pluginConfiguration, "settings", objectType, Multiplicity.SINGLE);
		
		EEnum notificationResultEnum = schema.createEEnum("store", "NotifictionResultEnum");
		schema.createEEnumLiteral(notificationResultEnum, "NR_ERROR");
		schema.createEEnumLiteral(notificationResultEnum, "SUCCESS");
		schema.createEEnumLiteral(notificationResultEnum, "PROGRESS_UNKNOWN");
		schema.createEEnumLiteral(notificationResultEnum, "PROGRESS_PERCENTAGE");
		
		EClass immediateNotificationResult = schema.createEClass("store", "ImmediateNotificationResult");
		schema.createEAttribute(immediateNotificationResult, "result", notificationResultEnum, Multiplicity.SINGLE);
		schema.createEAttribute(immediateNotificationResult, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		EClass remoteServiceCalled = schema.createEClass("log", "RemoteServiceCalled", logAction);
		schema.createEReference(remoteServiceCalled, "service", service, Multiplicity.SINGLE);
		schema.createEAttribute(remoteServiceCalled, "state", notificationResultEnum, Multiplicity.SINGLE);
		schema.createEAttribute(remoteServiceCalled, "percentage", EcorePackage.eINSTANCE.getEInt(), Multiplicity.SINGLE);
		schema.createEAttribute(remoteServiceCalled, "infos", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(remoteServiceCalled, "warnings", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(remoteServiceCalled, "errors", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		
		EReference projectLogs = schema.createEReference(project, "logs", projectRelated, Multiplicity.MANY);
		EReference revisionLogs = schema.createEReference(revisionClass, "logs", revisionRelated, Multiplicity.MANY);
		EReference userLogs = schema.createEReference(user, "logs", userRelated, Multiplicity.MANY);
		EReference checkoutLogs = schema.createEReference(checkoutClass, "logs", checkoutRelated, Multiplicity.MANY);
		
		projectRelatedProject.setEOpposite(projectLogs);
		projectLogs.setEOpposite(projectRelatedProject);
		
		revisionRelatedRevision.setEOpposite(revisionLogs);
		revisionLogs.setEOpposite(revisionRelatedRevision);
		
		userRelatedUser.setEOpposite(userLogs);
		userLogs.setEOpposite(userRelatedUser);
		
		checkoutRelatedCheckout.setEOpposite(checkoutLogs);
		checkoutLogs.setEOpposite(checkoutRelatedCheckout);
		
		EClass remoteServiceUpdate = schema.createEClass("store", "RemoteServiceUpdate");
		EClass percentageChange = schema.createEClass("store", "PercentageChange", remoteServiceUpdate);
		schema.createEAttribute(percentageChange, "percentage", EcorePackage.eINSTANCE.getEInt(), Multiplicity.SINGLE);
		
		EClass systemInfo = schema.createEClass("store", "SystemInfo");
		schema.createEAttribute(systemInfo, "cpucores", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(systemInfo, "datetime", EcorePackage.eINSTANCE.getEDate());
		schema.createEAttribute(systemInfo, "osname", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(systemInfo, "osversion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(systemInfo, "userName", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(systemInfo, "userHome", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(systemInfo, "userDir", EcorePackage.eINSTANCE.getEString());
		
		EClass javaInfo = schema.createEClass("store", "JavaInfo");
		schema.createEAttribute(javaInfo, "heapTotal", EcorePackage.eINSTANCE.getELong());
		schema.createEAttribute(javaInfo, "heapUsed", EcorePackage.eINSTANCE.getELong());
		schema.createEAttribute(javaInfo, "heapFree", EcorePackage.eINSTANCE.getELong());
		schema.createEAttribute(javaInfo, "heapMax", EcorePackage.eINSTANCE.getELong());
		schema.createEAttribute(javaInfo, "threads", EcorePackage.eINSTANCE.getEInt());

		schema.createEAttribute(javaInfo, "javaHome", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaVendor", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaVendorurl", EcorePackage.eINSTANCE.getEString());
		
		schema.createEAttribute(javaInfo, "javavmVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javavmVendor", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javavmName", EcorePackage.eINSTANCE.getEString());

		schema.createEAttribute(javaInfo, "javaspecVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaspecVendor", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaspecName", EcorePackage.eINSTANCE.getEString());

		schema.createEAttribute(javaInfo, "javaClassVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaClasspath", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(javaInfo, "javaLibrarypath", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(javaInfo, "javaIoTmp", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaExtdir", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaFileSeparator", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaPathSeparator", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(javaInfo, "javaLineSeparator", EcorePackage.eINSTANCE.getEString());

		EClass bimserverInfo = schema.createEClass("store", "BimServerInfo");
		schema.createEAttribute(bimserverInfo, "currentVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(bimserverInfo, "currentDate", EcorePackage.eINSTANCE.getEDate());
		schema.createEAttribute(bimserverInfo, "schemaVersion", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(bimserverInfo, "latestDate", EcorePackage.eINSTANCE.getEDate());
		schema.createEAttribute(bimserverInfo, "latestVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(bimserverInfo, "projects", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(bimserverInfo, "revisions", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(bimserverInfo, "users", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(bimserverInfo, "checkouts", EcorePackage.eINSTANCE.getEInt());
		schema.createEAttribute(bimserverInfo, "serverLogUrl", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(bimserverInfo, "started", EcorePackage.eINSTANCE.getEDate());
		
		EEnum progressTopicType = schema.createEEnum("store", "ProgressTopicType");
		schema.createEEnumLiteral(progressTopicType, "DOWNLOAD");
		schema.createEEnumLiteral(progressTopicType, "UPLOAD");
		schema.createEEnumLiteral(progressTopicType, "RUNNING_SERVICE");
		schema.createEEnumLiteral(progressTopicType, "BRANCH");
		
		schema.createEReference(revisionClass, "service", service, Multiplicity.SINGLE);
		
		EClass projectSmall = schema.createEClass("store", "ProjectSmall");
		schema.createEAttribute(projectSmall, "name", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(projectSmall, "parentId", EcorePackage.eINSTANCE.getELong());
		
		EClass ifcHeader = schema.createEClass("store", "IfcHeader");
		schema.createEAttribute(ifcHeader, "description", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY).setUnique(false);
		schema.createEAttribute(ifcHeader, "implementationLevel", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(ifcHeader, "filename", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(ifcHeader, "timeStamp", EcorePackage.eINSTANCE.getEDate());
		schema.createEAttribute(ifcHeader, "author", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY).setUnique(false);
		schema.createEAttribute(ifcHeader, "organization", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY).setUnique(false);
		schema.createEAttribute(ifcHeader, "preProcessorVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(ifcHeader, "originatingSystem", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(ifcHeader, "ifcSchemaVersion", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(ifcHeader, "authorization", EcorePackage.eINSTANCE.getEString());
		
		schema.createEReference(concreteRevisionClass, "ifcHeader", ifcHeader, Multiplicity.SINGLE);
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
		schema.createEReference(revisionClass, "user", user, Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "date", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "comment", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "size", ecorePackage.getELongObject(), Multiplicity.SINGLE);
		revisionConcreteRevisions = schema.createEReference(revisionClass, "concreteRevisions", concreteRevisionClass, Multiplicity.MANY);
		schema.createEReference(revisionClass, "lastConcreteRevision", concreteRevisionClass, Multiplicity.SINGLE);
		revisionCheckouts = schema.createEReference(revisionClass, "checkouts", checkoutClass, Multiplicity.MANY);
		revisionProject = schema.createEReference(revisionClass, "project", project, Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "tag", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "lastError", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionClass, "bmi", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
	}

	private void createConcreteRevisionClass() {
		schema.createEAttribute(concreteRevisionClass, "id", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		concreteRevisionProject = schema.createEReference(concreteRevisionClass, "project", project, Multiplicity.SINGLE);
		schema.createEAttribute(concreteRevisionClass, "checksum", ecorePackage.getEByteArray(), Multiplicity.SINGLE);
		concreteRevisionRevisions = schema.createEReference(concreteRevisionClass, "revisions", revisionClass, Multiplicity.MANY);
		schema.createEAttribute(concreteRevisionClass, "size", ecorePackage.getELongObject(), Multiplicity.SINGLE);
		schema.createEAttribute(concreteRevisionClass, "date", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(concreteRevisionClass, "lastError", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(concreteRevisionClass, "clear", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
	}

	private void createGeoTagClass() {
		schema.createEAttribute(geoTagClass, "enabled", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		geoTagProjects = schema.createEReference(geoTagClass, "projects", project, Multiplicity.MANY);
		schema.createEAttribute(geoTagClass, "x", ecorePackage.getEDoubleObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geoTagClass, "y", ecorePackage.getEDoubleObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geoTagClass, "z", ecorePackage.getEDoubleObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geoTagClass, "epsg", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(geoTagClass, "directionAngle", ecorePackage.getEDoubleObject(), Multiplicity.SINGLE);
	}

	private void createCheckoutClass() {
		schema.createEReference(checkoutClass, "user", user, Multiplicity.SINGLE);
		checkoutRevision = schema.createEReference(checkoutClass, "revision", revisionClass, Multiplicity.SINGLE);
		checkoutRevision.getEAnnotations().add(createEmbedsReferenceAnnotation());
		checkoutProject = schema.createEReference(checkoutClass, "project", project, Multiplicity.SINGLE);
		schema.createEAttribute(checkoutClass, "date", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEReference(checkoutClass, "checkin", revisionClass, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEAttribute(checkoutClass, "active", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
	}

	private void createUserClass() {
		schema.createEAttribute(user, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(user, "passwordHash", ecorePackage.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(user, "passwordSalt", ecorePackage.getEByteArray(), Multiplicity.SINGLE);
		userHasRightsOn = schema.createEReference(user, "hasRightsOn", project, Multiplicity.MANY);
		schema.createEAttribute(user, "state", objectStateEnum, Multiplicity.SINGLE);
		schema.createEAttribute(user, "createdOn", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEReference(user, "createdBy", user, Multiplicity.SINGLE);
		schema.createEAttribute(user, "userType", userTypeEnum, Multiplicity.SINGLE);
		schema.createEAttribute(user, "username", ecorePackage.getEString(), Multiplicity.SINGLE).getEAnnotations().add(createUniqueAnnotation());
		schema.createEAttribute(user, "lastSeen", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(user, "token", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(user, "validationToken", ecorePackage.getEByteArray(), Multiplicity.SINGLE);
		schema.createEAttribute(user, "validationTokenCreated", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEReference(user, "userSettings", userSettings, Multiplicity.SINGLE);
	}

	private void createServerSettingsClass() {
		schema.createEAttribute(serverSettings, "sendConfirmationEmailAfterRegistration", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettings, "allowSelfRegistration", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettings, "allowUsersToCreateTopLevelProjects", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettings, "checkinMergingEnabled", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettings, "smtpServer", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettings, "emailSenderAddress", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettings, "emailSenderName", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettings, "siteAddress", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettings, "generateGeometryOnCheckin", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettings, "allowOnlyWhitelisted", ecorePackage.getEBoolean(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettings, "whitelistedDomains", ecorePackage.getEString(), Multiplicity.MANY);
		schema.createEAttribute(serverSettings, "hideUserListForNonAdmin", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		schema.createEAttribute(serverSettings, "protocolBuffersPort", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
	}
	
	private void createProjectClass() {
		schema.createEAttribute(project, "id", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		EAttribute projectName = schema.createEAttribute(project, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.addIndex(projectName);
		projectHasAuthorizedUsers = schema.createEReference(project, "hasAuthorizedUsers", user, Multiplicity.MANY);
		projectConcreteRevisions = schema.createEReference(project, "concreteRevisions", concreteRevisionClass, Multiplicity.MANY);
		projectRevisions = schema.createEReference(project, "revisions", revisionClass, Multiplicity.MANY);
		schema.createEReference(project, "lastConcreteRevision", concreteRevisionClass, Multiplicity.SINGLE);
		schema.createEReference(project, "lastRevision", revisionClass, Multiplicity.SINGLE);
		projectCheckouts = schema.createEReference(project, "checkouts", checkoutClass, Multiplicity.MANY);
		schema.createEAttribute(project, "state", objectStateEnum, Multiplicity.SINGLE);
		schema.createEAttribute(project, "createdDate", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEReference(project, "createdBy", user, Multiplicity.SINGLE);
		projectGeoTag = schema.createEReference(project, "geoTag", geoTagClass, Multiplicity.SINGLE);
		projectSubProjects = schema.createEReference(project, "subProjects", project, Multiplicity.MANY);
		projectParentProject = schema.createEReference(project, "parent", project, Multiplicity.SINGLE);
		schema.createEAttribute(project, "description", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(project, "exportLengthMeasurePrefix", siPrefixEnum, Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "Initial store model";
	}
}