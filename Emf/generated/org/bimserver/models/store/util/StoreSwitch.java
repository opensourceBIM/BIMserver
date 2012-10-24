/**
 * Copyright (C) 2011  BIMserver.org
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
 */
package org.bimserver.models.store.util;

import org.bimserver.models.store.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.store.StorePackage
 * @generated
 */
public class StoreSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StorePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreSwitch() {
		if (modelPackage == null) {
			modelPackage = StorePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case StorePackage.PROJECT: {
			Project project = (Project) theEObject;
			T result = caseProject(project);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.USER: {
			User user = (User) theEObject;
			T result = caseUser(user);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.REVISION: {
			Revision revision = (Revision) theEObject;
			T result = caseRevision(revision);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.CONCRETE_REVISION: {
			ConcreteRevision concreteRevision = (ConcreteRevision) theEObject;
			T result = caseConcreteRevision(concreteRevision);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.GEO_TAG: {
			GeoTag geoTag = (GeoTag) theEObject;
			T result = caseGeoTag(geoTag);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.CHECKOUT: {
			Checkout checkout = (Checkout) theEObject;
			T result = caseCheckout(checkout);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERVER_SETTINGS: {
			ServerSettings serverSettings = (ServerSettings) theEObject;
			T result = caseServerSettings(serverSettings);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.USER_SETTINGS: {
			UserSettings userSettings = (UserSettings) theEObject;
			T result = caseUserSettings(userSettings);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.PLUGIN_CONFIGURATION: {
			PluginConfiguration pluginConfiguration = (PluginConfiguration) theEObject;
			T result = casePluginConfiguration(pluginConfiguration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERIALIZER_PLUGIN_CONFIGURATION: {
			SerializerPluginConfiguration serializerPluginConfiguration = (SerializerPluginConfiguration) theEObject;
			T result = caseSerializerPluginConfiguration(serializerPluginConfiguration);
			if (result == null)
				result = casePluginConfiguration(serializerPluginConfiguration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.OBJECT_IDM_PLUGIN_CONFIGURATION: {
			ObjectIDMPluginConfiguration objectIDMPluginConfiguration = (ObjectIDMPluginConfiguration) theEObject;
			T result = caseObjectIDMPluginConfiguration(objectIDMPluginConfiguration);
			if (result == null)
				result = casePluginConfiguration(objectIDMPluginConfiguration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.IFC_ENGINE_PLUGIN_CONFIGURATION: {
			IfcEnginePluginConfiguration ifcEnginePluginConfiguration = (IfcEnginePluginConfiguration) theEObject;
			T result = caseIfcEnginePluginConfiguration(ifcEnginePluginConfiguration);
			if (result == null)
				result = casePluginConfiguration(ifcEnginePluginConfiguration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.DESERIALIZER_PLUGIN_CONFIGURATION: {
			DeserializerPluginConfiguration deserializerPluginConfiguration = (DeserializerPluginConfiguration) theEObject;
			T result = caseDeserializerPluginConfiguration(deserializerPluginConfiguration);
			if (result == null)
				result = casePluginConfiguration(deserializerPluginConfiguration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.CHECKIN_RESULT: {
			CheckinResult checkinResult = (CheckinResult) theEObject;
			T result = caseCheckinResult(checkinResult);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.DOWNLOAD_RESULT: {
			DownloadResult downloadResult = (DownloadResult) theEObject;
			T result = caseDownloadResult(downloadResult);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.CHECKOUT_RESULT: {
			CheckoutResult checkoutResult = (CheckoutResult) theEObject;
			T result = caseCheckoutResult(checkoutResult);
			if (result == null)
				result = caseDownloadResult(checkoutResult);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.DATA_VALUE: {
			DataValue dataValue = (DataValue) theEObject;
			T result = caseDataValue(dataValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.DATA_OBJECT: {
			DataObject dataObject = (DataObject) theEObject;
			T result = caseDataObject(dataObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.USER_SESSION: {
			UserSession userSession = (UserSession) theEObject;
			T result = caseUserSession(userSession);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.MIGRATION: {
			Migration migration = (Migration) theEObject;
			T result = caseMigration(migration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.REFERENCE_DATA_VALUE: {
			ReferenceDataValue referenceDataValue = (ReferenceDataValue) theEObject;
			T result = caseReferenceDataValue(referenceDataValue);
			if (result == null)
				result = caseDataValue(referenceDataValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.LIST_DATA_VALUE: {
			ListDataValue listDataValue = (ListDataValue) theEObject;
			T result = caseListDataValue(listDataValue);
			if (result == null)
				result = caseDataValue(listDataValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SIMPLE_DATA_VALUE: {
			SimpleDataValue simpleDataValue = (SimpleDataValue) theEObject;
			T result = caseSimpleDataValue(simpleDataValue);
			if (result == null)
				result = caseDataValue(simpleDataValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.DATABASE_INFORMATION_ITEM: {
			DatabaseInformationItem databaseInformationItem = (DatabaseInformationItem) theEObject;
			T result = caseDatabaseInformationItem(databaseInformationItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.DATABASE_INFORMATION_CATEGORY: {
			DatabaseInformationCategory databaseInformationCategory = (DatabaseInformationCategory) theEObject;
			T result = caseDatabaseInformationCategory(databaseInformationCategory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.DATABASE_INFORMATION: {
			DatabaseInformation databaseInformation = (DatabaseInformation) theEObject;
			T result = caseDatabaseInformation(databaseInformation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.PLUGIN_DESCRIPTOR: {
			PluginDescriptor pluginDescriptor = (PluginDescriptor) theEObject;
			T result = casePluginDescriptor(pluginDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERIALIZER_PLUGIN_DESCRIPTOR: {
			SerializerPluginDescriptor serializerPluginDescriptor = (SerializerPluginDescriptor) theEObject;
			T result = caseSerializerPluginDescriptor(serializerPluginDescriptor);
			if (result == null)
				result = casePluginDescriptor(serializerPluginDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.DESERIALIZER_PLUGIN_DESCRIPTOR: {
			DeserializerPluginDescriptor deserializerPluginDescriptor = (DeserializerPluginDescriptor) theEObject;
			T result = caseDeserializerPluginDescriptor(deserializerPluginDescriptor);
			if (result == null)
				result = casePluginDescriptor(deserializerPluginDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.REVISION_SUMMARY_TYPE: {
			RevisionSummaryType revisionSummaryType = (RevisionSummaryType) theEObject;
			T result = caseRevisionSummaryType(revisionSummaryType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.REVISION_SUMMARY_CONTAINER: {
			RevisionSummaryContainer revisionSummaryContainer = (RevisionSummaryContainer) theEObject;
			T result = caseRevisionSummaryContainer(revisionSummaryContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.REVISION_SUMMARY: {
			RevisionSummary revisionSummary = (RevisionSummary) theEObject;
			T result = caseRevisionSummary(revisionSummary);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.LONG_ACTION: {
			LongAction longAction = (LongAction) theEObject;
			T result = caseLongAction(longAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.LONG_CHECKIN_ACTION: {
			LongCheckinAction longCheckinAction = (LongCheckinAction) theEObject;
			T result = caseLongCheckinAction(longCheckinAction);
			if (result == null)
				result = caseLongAction(longCheckinAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.OBJECT_IDM_PLUGIN_DESCRIPTOR: {
			ObjectIDMPluginDescriptor objectIDMPluginDescriptor = (ObjectIDMPluginDescriptor) theEObject;
			T result = caseObjectIDMPluginDescriptor(objectIDMPluginDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.COMPARE_ITEM: {
			CompareItem compareItem = (CompareItem) theEObject;
			T result = caseCompareItem(compareItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.OBJECT_ADDED: {
			ObjectAdded objectAdded = (ObjectAdded) theEObject;
			T result = caseObjectAdded(objectAdded);
			if (result == null)
				result = caseCompareItem(objectAdded);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.OBJECT_REMOVED: {
			ObjectRemoved objectRemoved = (ObjectRemoved) theEObject;
			T result = caseObjectRemoved(objectRemoved);
			if (result == null)
				result = caseCompareItem(objectRemoved);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.OBJECT_MODIFIED: {
			ObjectModified objectModified = (ObjectModified) theEObject;
			T result = caseObjectModified(objectModified);
			if (result == null)
				result = caseCompareItem(objectModified);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.COMPARE_CONTAINER: {
			CompareContainer compareContainer = (CompareContainer) theEObject;
			T result = caseCompareContainer(compareContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.COMPARE_RESULT: {
			CompareResult compareResult = (CompareResult) theEObject;
			T result = caseCompareResult(compareResult);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.LONG_ACTION_STATE: {
			LongActionState longActionState = (LongActionState) theEObject;
			T result = caseLongActionState(longActionState);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERVER_INFO: {
			ServerInfo serverInfo = (ServerInfo) theEObject;
			T result = caseServerInfo(serverInfo);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.VERSION: {
			Version version = (Version) theEObject;
			T result = caseVersion(version);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.IFC_ENGINE_PLUGIN_DESCRIPTOR: {
			IfcEnginePluginDescriptor ifcEnginePluginDescriptor = (IfcEnginePluginDescriptor) theEObject;
			T result = caseIfcEnginePluginDescriptor(ifcEnginePluginDescriptor);
			if (result == null)
				result = casePluginDescriptor(ifcEnginePluginDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.FILE: {
			File file = (File) theEObject;
			T result = caseFile(file);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.EXTENDED_DATA_SCHEMA: {
			ExtendedDataSchema extendedDataSchema = (ExtendedDataSchema) theEObject;
			T result = caseExtendedDataSchema(extendedDataSchema);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.EXTENDED_DATA: {
			ExtendedData extendedData = (ExtendedData) theEObject;
			T result = caseExtendedData(extendedData);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.QUERY_ENGINE_PLUGIN_DESCRIPTOR: {
			QueryEnginePluginDescriptor queryEnginePluginDescriptor = (QueryEnginePluginDescriptor) theEObject;
			T result = caseQueryEnginePluginDescriptor(queryEnginePluginDescriptor);
			if (result == null)
				result = casePluginDescriptor(queryEnginePluginDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.QUERY_ENGINE_PLUGIN_CONFIGURATION: {
			QueryEnginePluginConfiguration queryEnginePluginConfiguration = (QueryEnginePluginConfiguration) theEObject;
			T result = caseQueryEnginePluginConfiguration(queryEnginePluginConfiguration);
			if (result == null)
				result = casePluginConfiguration(queryEnginePluginConfiguration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.MODEL_MERGER_PLUGIN_DESCRIPTOR: {
			ModelMergerPluginDescriptor modelMergerPluginDescriptor = (ModelMergerPluginDescriptor) theEObject;
			T result = caseModelMergerPluginDescriptor(modelMergerPluginDescriptor);
			if (result == null)
				result = casePluginDescriptor(modelMergerPluginDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.MODEL_MERGER_PLUGIN_CONFIGURATION: {
			ModelMergerPluginConfiguration modelMergerPluginConfiguration = (ModelMergerPluginConfiguration) theEObject;
			T result = caseModelMergerPluginConfiguration(modelMergerPluginConfiguration);
			if (result == null)
				result = casePluginConfiguration(modelMergerPluginConfiguration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.MODEL_COMPARE_PLUGIN_DESCRIPTOR: {
			ModelComparePluginDescriptor modelComparePluginDescriptor = (ModelComparePluginDescriptor) theEObject;
			T result = caseModelComparePluginDescriptor(modelComparePluginDescriptor);
			if (result == null)
				result = casePluginDescriptor(modelComparePluginDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.MODEL_COMPARE_PLUGIN_CONFIGURATION: {
			ModelComparePluginConfiguration modelComparePluginConfiguration = (ModelComparePluginConfiguration) theEObject;
			T result = caseModelComparePluginConfiguration(modelComparePluginConfiguration);
			if (result == null)
				result = casePluginConfiguration(modelComparePluginConfiguration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.PROFILE_DESCRIPTOR: {
			ProfileDescriptor profileDescriptor = (ProfileDescriptor) theEObject;
			T result = caseProfileDescriptor(profileDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERVICE_DESCRIPTOR: {
			ServiceDescriptor serviceDescriptor = (ServiceDescriptor) theEObject;
			T result = caseServiceDescriptor(serviceDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERVICE: {
			Service service = (Service) theEObject;
			T result = caseService(service);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.TOKEN: {
			Token token = (Token) theEObject;
			T result = caseToken(token);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERVICE_PLUGIN_DESCRIPTOR: {
			ServicePluginDescriptor servicePluginDescriptor = (ServicePluginDescriptor) theEObject;
			T result = caseServicePluginDescriptor(servicePluginDescriptor);
			if (result == null)
				result = casePluginDescriptor(servicePluginDescriptor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.INTERNAL_SERVICE_PLUGIN_CONFIGURATION: {
			InternalServicePluginConfiguration internalServicePluginConfiguration = (InternalServicePluginConfiguration) theEObject;
			T result = caseInternalServicePluginConfiguration(internalServicePluginConfiguration);
			if (result == null)
				result = casePluginConfiguration(internalServicePluginConfiguration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERVICE_INTERFACE: {
			ServiceInterface serviceInterface = (ServiceInterface) theEObject;
			T result = caseServiceInterface(serviceInterface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERVICE_METHOD: {
			ServiceMethod serviceMethod = (ServiceMethod) theEObject;
			T result = caseServiceMethod(serviceMethod);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERVICE_FIELD: {
			ServiceField serviceField = (ServiceField) theEObject;
			T result = caseServiceField(serviceField);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERVICE_TYPE: {
			ServiceType serviceType = (ServiceType) theEObject;
			T result = caseServiceType(serviceType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERVICE_PARAMETER: {
			ServiceParameter serviceParameter = (ServiceParameter) theEObject;
			T result = caseServiceParameter(serviceParameter);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.TYPE_DEFINITION: {
			TypeDefinition typeDefinition = (TypeDefinition) theEObject;
			T result = caseTypeDefinition(typeDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.OBJECT_DEFINITION: {
			ObjectDefinition objectDefinition = (ObjectDefinition) theEObject;
			T result = caseObjectDefinition(objectDefinition);
			if (result == null)
				result = caseTypeDefinition(objectDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.PRIMITIVE_DEFINITION: {
			PrimitiveDefinition primitiveDefinition = (PrimitiveDefinition) theEObject;
			T result = casePrimitiveDefinition(primitiveDefinition);
			if (result == null)
				result = caseTypeDefinition(primitiveDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.ARRAY_DEFINITION: {
			ArrayDefinition arrayDefinition = (ArrayDefinition) theEObject;
			T result = caseArrayDefinition(arrayDefinition);
			if (result == null)
				result = caseTypeDefinition(arrayDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.PARAMETER_DEFINITION: {
			ParameterDefinition parameterDefinition = (ParameterDefinition) theEObject;
			T result = caseParameterDefinition(parameterDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.TYPE: {
			Type type = (Type) theEObject;
			T result = caseType(type);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.OBJECT_TYPE: {
			ObjectType objectType = (ObjectType) theEObject;
			T result = caseObjectType(objectType);
			if (result == null)
				result = caseType(objectType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.PRIMITIVE_TYPE: {
			PrimitiveType primitiveType = (PrimitiveType) theEObject;
			T result = casePrimitiveType(primitiveType);
			if (result == null)
				result = caseType(primitiveType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.LONG_TYPE: {
			LongType longType = (LongType) theEObject;
			T result = caseLongType(longType);
			if (result == null)
				result = casePrimitiveType(longType);
			if (result == null)
				result = caseType(longType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.DOUBLE_TYPE: {
			DoubleType doubleType = (DoubleType) theEObject;
			T result = caseDoubleType(doubleType);
			if (result == null)
				result = casePrimitiveType(doubleType);
			if (result == null)
				result = caseType(doubleType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.STRING_TYPE: {
			StringType stringType = (StringType) theEObject;
			T result = caseStringType(stringType);
			if (result == null)
				result = casePrimitiveType(stringType);
			if (result == null)
				result = caseType(stringType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.BOOLEAN_TYPE: {
			BooleanType booleanType = (BooleanType) theEObject;
			T result = caseBooleanType(booleanType);
			if (result == null)
				result = casePrimitiveType(booleanType);
			if (result == null)
				result = caseType(booleanType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.ARRAY_TYPE: {
			ArrayType arrayType = (ArrayType) theEObject;
			T result = caseArrayType(arrayType);
			if (result == null)
				result = caseType(arrayType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.PARAMETER: {
			Parameter parameter = (Parameter) theEObject;
			T result = caseParameter(parameter);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.IMMEDIATE_NOTIFICATION_RESULT: {
			ImmediateNotificationResult immediateNotificationResult = (ImmediateNotificationResult) theEObject;
			T result = caseImmediateNotificationResult(immediateNotificationResult);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.EXTERNAL_SERVICE_UPDATE: {
			ExternalServiceUpdate externalServiceUpdate = (ExternalServiceUpdate) theEObject;
			T result = caseExternalServiceUpdate(externalServiceUpdate);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.PERCENTAGE_CHANGE: {
			PercentageChange percentageChange = (PercentageChange) theEObject;
			T result = casePercentageChange(percentageChange);
			if (result == null)
				result = caseExternalServiceUpdate(percentageChange);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.BOUNDS: {
			Bounds bounds = (Bounds) theEObject;
			T result = caseBounds(bounds);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.VECTOR3F: {
			Vector3f vector3f = (Vector3f) theEObject;
			T result = caseVector3f(vector3f);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.GEOMETRY: {
			Geometry geometry = (Geometry) theEObject;
			T result = caseGeometry(geometry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProject(Project object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUser(User object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Revision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Revision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRevision(Revision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concrete Revision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concrete Revision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcreteRevision(ConcreteRevision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Geo Tag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Geo Tag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeoTag(GeoTag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Checkout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Checkout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckout(Checkout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Server Settings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Server Settings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServerSettings(ServerSettings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Settings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Settings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserSettings(UserSettings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plugin Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePluginConfiguration(PluginConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Serializer Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Serializer Plugin Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSerializerPluginConfiguration(SerializerPluginConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object IDM Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object IDM Plugin Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectIDMPluginConfiguration(ObjectIDMPluginConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Engine Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Engine Plugin Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEnginePluginConfiguration(IfcEnginePluginConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deserializer Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deserializer Plugin Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeserializerPluginConfiguration(DeserializerPluginConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Checkin Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Checkin Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckinResult(CheckinResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Download Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Download Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDownloadResult(DownloadResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Checkout Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Checkout Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckoutResult(CheckoutResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataValue(DataValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataObject(DataObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Session</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Session</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserSession(UserSession object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Migration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Migration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMigration(Migration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Data Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Data Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceDataValue(ReferenceDataValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Data Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Data Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListDataValue(ListDataValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Data Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Data Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleDataValue(SimpleDataValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Database Information Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Database Information Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDatabaseInformationItem(DatabaseInformationItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Database Information Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Database Information Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDatabaseInformationCategory(DatabaseInformationCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Database Information</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Database Information</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDatabaseInformation(DatabaseInformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Serializer Plugin Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Serializer Plugin Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSerializerPluginDescriptor(SerializerPluginDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deserializer Plugin Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deserializer Plugin Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeserializerPluginDescriptor(DeserializerPluginDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Revision Summary Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Revision Summary Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRevisionSummaryType(RevisionSummaryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Revision Summary Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Revision Summary Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRevisionSummaryContainer(RevisionSummaryContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Revision Summary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Revision Summary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRevisionSummary(RevisionSummary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plugin Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plugin Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePluginDescriptor(PluginDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLongAction(LongAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Checkin Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Checkin Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLongCheckinAction(LongCheckinAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object IDM Plugin Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object IDM Plugin Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectIDMPluginDescriptor(ObjectIDMPluginDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compare Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compare Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompareItem(CompareItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Added</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Added</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectAdded(ObjectAdded object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Removed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Removed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectRemoved(ObjectRemoved object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Modified</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Modified</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectModified(ObjectModified object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compare Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compare Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompareContainer(CompareContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compare Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compare Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompareResult(CompareResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Action State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Action State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLongActionState(LongActionState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Server Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Server Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServerInfo(ServerInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVersion(Version object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Engine Plugin Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Engine Plugin Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEnginePluginDescriptor(IfcEnginePluginDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFile(File object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Data Schema</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Data Schema</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendedDataSchema(ExtendedDataSchema object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendedData(ExtendedData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query Engine Plugin Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query Engine Plugin Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueryEnginePluginDescriptor(QueryEnginePluginDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query Engine Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query Engine Plugin Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueryEnginePluginConfiguration(QueryEnginePluginConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Merger Plugin Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Merger Plugin Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelMergerPluginDescriptor(ModelMergerPluginDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Merger Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Merger Plugin Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelMergerPluginConfiguration(ModelMergerPluginConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Compare Plugin Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Compare Plugin Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelComparePluginDescriptor(ModelComparePluginDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Compare Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Compare Plugin Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelComparePluginConfiguration(ModelComparePluginConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Profile Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Profile Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProfileDescriptor(ProfileDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceDescriptor(ServiceDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseService(Service object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Token</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Token</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToken(Token object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Plugin Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Plugin Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServicePluginDescriptor(ServicePluginDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Service Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Service Plugin Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalServicePluginConfiguration(InternalServicePluginConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceInterface(ServiceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceMethod(ServiceMethod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceField(ServiceField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceType(ServiceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceParameter(ServiceParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeDefinition(TypeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectDefinition(ObjectDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveDefinition(PrimitiveDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayDefinition(ArrayDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterDefinition(ParameterDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectType(ObjectType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLongType(LongType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleType(DoubleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayType(ArrayType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Immediate Notification Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Immediate Notification Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImmediateNotificationResult(ImmediateNotificationResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Service Update</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Service Update</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalServiceUpdate(ExternalServiceUpdate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Percentage Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Percentage Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePercentageChange(PercentageChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bounds</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bounds</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBounds(Bounds object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vector3f</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vector3f</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVector3f(Vector3f object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Geometry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Geometry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeometry(Geometry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //StoreSwitch
