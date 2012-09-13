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
		case StorePackage.PLUGIN: {
			Plugin plugin = (Plugin) theEObject;
			T result = casePlugin(plugin);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.SERIALIZER: {
			Serializer serializer = (Serializer) theEObject;
			T result = caseSerializer(serializer);
			if (result == null)
				result = casePlugin(serializer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.OBJECT_IDM: {
			ObjectIDM objectIDM = (ObjectIDM) theEObject;
			T result = caseObjectIDM(objectIDM);
			if (result == null)
				result = casePlugin(objectIDM);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.IFC_ENGINE: {
			IfcEngine ifcEngine = (IfcEngine) theEObject;
			T result = caseIfcEngine(ifcEngine);
			if (result == null)
				result = casePlugin(ifcEngine);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.DESERIALIZER: {
			Deserializer deserializer = (Deserializer) theEObject;
			T result = caseDeserializer(deserializer);
			if (result == null)
				result = casePlugin(deserializer);
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
		case StorePackage.NOTIFICATION: {
			Notification notification = (Notification) theEObject;
			T result = caseNotification(notification);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.NEW_PROJECT_NOTIFICATION: {
			NewProjectNotification newProjectNotification = (NewProjectNotification) theEObject;
			T result = caseNewProjectNotification(newProjectNotification);
			if (result == null)
				result = caseNotification(newProjectNotification);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case StorePackage.NEW_REVISION_NOTIFICATION: {
			NewRevisionNotification newRevisionNotification = (NewRevisionNotification) theEObject;
			T result = caseNewRevisionNotification(newRevisionNotification);
			if (result == null)
				result = caseNotification(newRevisionNotification);
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
		case StorePackage.QUERY_ENGINE: {
			QueryEngine queryEngine = (QueryEngine) theEObject;
			T result = caseQueryEngine(queryEngine);
			if (result == null)
				result = casePlugin(queryEngine);
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
		case StorePackage.MODEL_MERGER: {
			ModelMerger modelMerger = (ModelMerger) theEObject;
			T result = caseModelMerger(modelMerger);
			if (result == null)
				result = casePlugin(modelMerger);
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
		case StorePackage.MODEL_COMPARE: {
			ModelCompare modelCompare = (ModelCompare) theEObject;
			T result = caseModelCompare(modelCompare);
			if (result == null)
				result = casePlugin(modelCompare);
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
	 * Returns the result of interpreting the object as an instance of '<em>Serializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Serializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSerializer(Serializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object IDM</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object IDM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectIDM(ObjectIDM object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Engine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Engine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEngine(IfcEngine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plugin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plugin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlugin(Plugin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deserializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deserializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeserializer(Deserializer object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotification(Notification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Project Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Project Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewProjectNotification(NewProjectNotification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Revision Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Revision Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewRevisionNotification(NewRevisionNotification object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Query Engine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query Engine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueryEngine(QueryEngine object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Model Merger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Merger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelMerger(ModelMerger object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Model Compare</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Compare</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelCompare(ModelCompare object) {
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
