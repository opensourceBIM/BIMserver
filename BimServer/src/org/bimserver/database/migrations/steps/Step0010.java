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

import javax.activation.DataHandler;

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0010 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass checkinResultClass = schema.createEClass(schema.getEPackage("store"), "CheckinResult");
		schema.createEReference(checkinResultClass, "revision", schema.getEClass("store", "Revision"), Multiplicity.SINGLE);
		schema.createEReference(checkinResultClass, "project", schema.getEClass("store", "Project"), Multiplicity.SINGLE);
		schema.createEAttribute(checkinResultClass, "progress", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(checkinResultClass, "lastError", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EDataType dataHandler = schema.createEDataType(schema.getEPackage("store"), EcoreFactory.eINSTANCE.createEDataType());
		dataHandler.setName("DataHandler");
		dataHandler.setInstanceClass(DataHandler.class);
		
		EClass downloadResultClass = schema.createEClass(schema.getEPackage("store"), "DownloadResult");
		schema.createEAttribute(downloadResultClass, "projectName", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(downloadResultClass, "revisionNr", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(downloadResultClass, "file", dataHandler, Multiplicity.SINGLE);

		schema.createEClass(schema.getEPackage("store"), "CheckoutResult", downloadResultClass);
		
		EClass dataValue = schema.createEClass(schema.getEPackage("store"), "DataValue");
		schema.createEAttribute(dataValue, "fieldName", ecorePackage.getEString(), Multiplicity.SINGLE);

		EClass dataObjectClass = schema.createEClass(schema.getEPackage("store"), "DataObject");
		schema.createEAttribute(dataObjectClass, "type", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(dataObjectClass, "guid", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(dataObjectClass, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(dataObjectClass, "values", dataValue, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EClass userSessionClass = schema.createEClass(schema.getEPackage("store"), "UserSession");
		schema.createEReference(userSessionClass, "user", schema.getEClass("store", "User"), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "username", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "type", schema.getEEnum("store", "UserType"), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "remoteAddress", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "activeSince", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "lastActive", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(userSessionClass, "accessMethod", schema.getEEnum("log", "AccessMethod"), Multiplicity.SINGLE);
		
		EClass migrationClass = schema.createEClass(schema.getEPackage("store"), "Migration");
		schema.createEAttribute(migrationClass, "number", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(migrationClass, "description", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(migrationClass, "executed", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);
		
		EClass referenceDataValue = schema.createEClass(schema.getEPackage("store"), "ReferenceDataValue", dataValue);
		schema.createEAttribute(referenceDataValue, "typeName", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(referenceDataValue, "guid", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EClass listDataValue = schema.createEClass(schema.getEPackage("store"), "ListDataValue", dataValue);
		schema.createEReference(listDataValue, "values", dataValue, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());;
		
		EClass simpleDataValue = schema.createEClass(schema.getEPackage("store"), "SimpleDataValue", dataValue);
		schema.createEAttribute(simpleDataValue, "stringValue", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EClass databaseInformationItem = schema.createEClass(schema.getEPackage("store"), "DatabaseInformationItem");
		schema.createEAttribute(databaseInformationItem, "key", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(databaseInformationItem, "value", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EClass databaseInformationCategoryClass = schema.createEClass(schema.getEPackage("store"), "DatabaseInformationCategory");
		schema.createEAttribute(databaseInformationCategoryClass, "title", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEReference(databaseInformationCategoryClass, "items", databaseInformationItem, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EClass databaseInformationClass = schema.createEClass(schema.getEPackage("store"), "DatabaseInformation");
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
		
		EClass pluginDescriptorClass = schema.createEClass(schema.getEPackage("store"), "PluginDescriptor");
		schema.createEAttribute(pluginDescriptorClass, "defaultName", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginDescriptorClass, "pluginClassName", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginDescriptorClass, "description", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginDescriptorClass, "location", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(pluginDescriptorClass, "enabled", ecorePackage.getEBooleanObject(), Multiplicity.SINGLE);

		EClass serializerPluginDescriptorClass = schema.createEClass(schema.getEPackage("store"), "SerializerPluginDescriptor", pluginDescriptorClass);
		schema.createEAttribute(serializerPluginDescriptorClass, "defaultExtension", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serializerPluginDescriptorClass, "defaultContentType", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		schema.createEClass(schema.getEPackage("store"), "DeserializerPluginDescriptor", pluginDescriptorClass);
		
		EClass revisionSummaryTypeClass = schema.createEClass(schema.getEPackage("store"), "RevisionSummaryType");
		schema.createEAttribute(revisionSummaryTypeClass, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(revisionSummaryTypeClass, "count", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		
		EClass revisionSummaryContainerClass = schema.createEClass(schema.getEPackage("store"), "RevisionSummaryContainer");
		schema.createEAttribute(revisionSummaryContainerClass, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEReference(revisionSummaryContainerClass, "types", revisionSummaryTypeClass, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EClass revisionSummaryClass = schema.createEClass(schema.getEPackage("store"), "RevisionSummary");
		schema.createEReference(revisionSummaryClass, "list", revisionSummaryContainerClass, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEReference(schema.getEClass("store", "ConcreteRevision"), "summary", revisionSummaryClass, Multiplicity.SINGLE);
		
		EClass longActionClass = schema.createEClass(schema.getEPackage("store"), "LongAction");
		schema.createEAttribute(longActionClass, "identification", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEReference(longActionClass, "user", schema.getEClass("store", "User"), Multiplicity.SINGLE);
		schema.createEAttribute(longActionClass, "start", ecorePackage.getEDate(), Multiplicity.SINGLE);
		schema.createEAttribute(longActionClass, "username", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(longActionClass, "name", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EClass longCheckinActionClass = schema.createEClass(schema.getEPackage("store"), "LongCheckinAction", longActionClass);
		schema.createEReference(longCheckinActionClass, "revisions", schema.getEClass("store", "Revision"), Multiplicity.MANY);
		
		EClass objectIDMPluginDescriptor = schema.createEClass(schema.getEPackage("store"), "ObjectIDMPluginDescriptor");
		schema.createEAttribute(objectIDMPluginDescriptor, "className", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EEnum compareTypeEnum = schema.createEEnum(schema.getEPackage("store"), "CompareType");
		schema.createEEnumLiteral(compareTypeEnum, "ALL");
		schema.createEEnumLiteral(compareTypeEnum, "ADD");
		schema.createEEnumLiteral(compareTypeEnum, "MODIFY");
		schema.createEEnumLiteral(compareTypeEnum, "DELETE");
		
		EClass compareItemClass = schema.createEClass(schema.getEPackage("store"), "CompareItem");
		schema.createEReference(compareItemClass, "dataObject", dataObjectClass, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		schema.createEClass(schema.getEPackage("store"), "ObjectAdded", compareItemClass);
		
		schema.createEClass(schema.getEPackage("store"), "ObjectRemoved", compareItemClass);
		
		EClass objectModified = schema.createEClass(schema.getEPackage("store"), "ObjectModified", compareItemClass);
		schema.createEAttribute(objectModified, "fieldName", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(objectModified, "oldValue", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(objectModified, "newValue", ecorePackage.getEString(), Multiplicity.SINGLE);
		
		EClass compareContainerClass = schema.createEClass(schema.getEPackage("store"), "CompareContainer");
		schema.createEAttribute(compareContainerClass, "type", ecorePackage.getEString(), Multiplicity.SINGLE);
		schema.createEReference(compareContainerClass, "items", compareItemClass, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());

		EClass compareResultClass = schema.createEClass(schema.getEPackage("store"), "CompareResult");		
		schema.createEReference(compareResultClass, "items", compareContainerClass, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		EEnum actionStateEnum = schema.createEEnum(schema.getEPackage("store"), "ActionState");
		schema.createEEnumLiteral(actionStateEnum, "UNKNOWN");
		schema.createEEnumLiteral(actionStateEnum, "STARTED");
		schema.createEEnumLiteral(actionStateEnum, "FINISHED");
		
		EClass longActionStateClass = schema.createEClass(schema.getEPackage("store"), "LongActionState");
		schema.createEAttribute(longActionStateClass, "progress", ecorePackage.getEIntegerObject(), Multiplicity.SINGLE);
		schema.createEAttribute(longActionStateClass, "state", actionStateEnum, Multiplicity.SINGLE);
		schema.createEAttribute(longActionStateClass, "title", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(longActionStateClass, "stage", EcorePackage.eINSTANCE.getEInt(), Multiplicity.SINGLE);
		schema.createEAttribute(longActionStateClass, "errors", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(longActionStateClass, "warnings", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		schema.createEAttribute(longActionStateClass, "infos", EcorePackage.eINSTANCE.getEString(), Multiplicity.MANY);
		
		EEnum accessMethodEnum = schema.getEEnum("log", "AccessMethod");
		schema.createEEnumLiteral(accessMethodEnum, "PROTOCOL_BUFFERS");
	}

	@Override
	public String getDescription() {
		return "Adds notification stuff";
	}
}