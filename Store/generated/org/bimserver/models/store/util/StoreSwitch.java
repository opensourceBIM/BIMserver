/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.util;

import org.bimserver.models.store.*;
import org.bimserver.models.store.CheckinResult;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.CheckoutResult;
import org.bimserver.models.store.Clash;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.CompareContainer;
import org.bimserver.models.store.CompareItem;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.DataValue;
import org.bimserver.models.store.DatabaseInformation;
import org.bimserver.models.store.DatabaseInformationCategory;
import org.bimserver.models.store.DatabaseInformationItem;
import org.bimserver.models.store.Deserializer;
import org.bimserver.models.store.DownloadResult;
import org.bimserver.models.store.EidClash;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.GuidClash;
import org.bimserver.models.store.GuidanceProvider;
import org.bimserver.models.store.GuidanceProviderPluginDescriptor;
import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.ListDataValue;
import org.bimserver.models.store.LongAction;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.Migration;
import org.bimserver.models.store.ObjectAdded;
import org.bimserver.models.store.ObjectModified;
import org.bimserver.models.store.ObjectRemoved;
import org.bimserver.models.store.Plugin;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.ReferenceDataValue;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.RevisionSummaryContainer;
import org.bimserver.models.store.RevisionSummaryType;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.SerializerPluginDescriptor;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.SimpleDataValue;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSession;
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
				Project project = (Project)theEObject;
				T result = caseProject(project);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.USER: {
				User user = (User)theEObject;
				T result = caseUser(user);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.CLASH: {
				Clash clash = (Clash)theEObject;
				T result = caseClash(clash);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.EID_CLASH: {
				EidClash eidClash = (EidClash)theEObject;
				T result = caseEidClash(eidClash);
				if (result == null) result = caseClash(eidClash);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.GUID_CLASH: {
				GuidClash guidClash = (GuidClash)theEObject;
				T result = caseGuidClash(guidClash);
				if (result == null) result = caseClash(guidClash);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.CLASH_DETECTION_SETTINGS: {
				ClashDetectionSettings clashDetectionSettings = (ClashDetectionSettings)theEObject;
				T result = caseClashDetectionSettings(clashDetectionSettings);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.REVISION: {
				Revision revision = (Revision)theEObject;
				T result = caseRevision(revision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.CONCRETE_REVISION: {
				ConcreteRevision concreteRevision = (ConcreteRevision)theEObject;
				T result = caseConcreteRevision(concreteRevision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.GEO_TAG: {
				GeoTag geoTag = (GeoTag)theEObject;
				T result = caseGeoTag(geoTag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.CHECKOUT: {
				Checkout checkout = (Checkout)theEObject;
				T result = caseCheckout(checkout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.SETTINGS: {
				Settings settings = (Settings)theEObject;
				T result = caseSettings(settings);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.SERIALIZER: {
				Serializer serializer = (Serializer)theEObject;
				T result = caseSerializer(serializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.GUIDANCE_PROVIDER: {
				GuidanceProvider guidanceProvider = (GuidanceProvider)theEObject;
				T result = caseGuidanceProvider(guidanceProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.IFC_ENGINE: {
				IfcEngine ifcEngine = (IfcEngine)theEObject;
				T result = caseIfcEngine(ifcEngine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.PLUGIN: {
				Plugin plugin = (Plugin)theEObject;
				T result = casePlugin(plugin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.DESERIALIZER: {
				Deserializer deserializer = (Deserializer)theEObject;
				T result = caseDeserializer(deserializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.CHECKIN_RESULT: {
				CheckinResult checkinResult = (CheckinResult)theEObject;
				T result = caseCheckinResult(checkinResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.DOWNLOAD_RESULT: {
				DownloadResult downloadResult = (DownloadResult)theEObject;
				T result = caseDownloadResult(downloadResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.CHECKOUT_RESULT: {
				CheckoutResult checkoutResult = (CheckoutResult)theEObject;
				T result = caseCheckoutResult(checkoutResult);
				if (result == null) result = caseDownloadResult(checkoutResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.DATA_VALUE: {
				DataValue dataValue = (DataValue)theEObject;
				T result = caseDataValue(dataValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.DATA_OBJECT: {
				DataObject dataObject = (DataObject)theEObject;
				T result = caseDataObject(dataObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.USER_SESSION: {
				UserSession userSession = (UserSession)theEObject;
				T result = caseUserSession(userSession);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.MIGRATION: {
				Migration migration = (Migration)theEObject;
				T result = caseMigration(migration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.REFERENCE_DATA_VALUE: {
				ReferenceDataValue referenceDataValue = (ReferenceDataValue)theEObject;
				T result = caseReferenceDataValue(referenceDataValue);
				if (result == null) result = caseDataValue(referenceDataValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.LIST_DATA_VALUE: {
				ListDataValue listDataValue = (ListDataValue)theEObject;
				T result = caseListDataValue(listDataValue);
				if (result == null) result = caseDataValue(listDataValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.SIMPLE_DATA_VALUE: {
				SimpleDataValue simpleDataValue = (SimpleDataValue)theEObject;
				T result = caseSimpleDataValue(simpleDataValue);
				if (result == null) result = caseDataValue(simpleDataValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.DATABASE_INFORMATION_ITEM: {
				DatabaseInformationItem databaseInformationItem = (DatabaseInformationItem)theEObject;
				T result = caseDatabaseInformationItem(databaseInformationItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.DATABASE_INFORMATION_CATEGORY: {
				DatabaseInformationCategory databaseInformationCategory = (DatabaseInformationCategory)theEObject;
				T result = caseDatabaseInformationCategory(databaseInformationCategory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.DATABASE_INFORMATION: {
				DatabaseInformation databaseInformation = (DatabaseInformation)theEObject;
				T result = caseDatabaseInformation(databaseInformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.SERIALIZER_PLUGIN_DESCRIPTOR: {
				SerializerPluginDescriptor serializerPluginDescriptor = (SerializerPluginDescriptor)theEObject;
				T result = caseSerializerPluginDescriptor(serializerPluginDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.REVISION_SUMMARY_TYPE: {
				RevisionSummaryType revisionSummaryType = (RevisionSummaryType)theEObject;
				T result = caseRevisionSummaryType(revisionSummaryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.REVISION_SUMMARY_CONTAINER: {
				RevisionSummaryContainer revisionSummaryContainer = (RevisionSummaryContainer)theEObject;
				T result = caseRevisionSummaryContainer(revisionSummaryContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.REVISION_SUMMARY: {
				RevisionSummary revisionSummary = (RevisionSummary)theEObject;
				T result = caseRevisionSummary(revisionSummary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.PLUGIN_DESCRIPTOR: {
				PluginDescriptor pluginDescriptor = (PluginDescriptor)theEObject;
				T result = casePluginDescriptor(pluginDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.LONG_ACTION: {
				LongAction longAction = (LongAction)theEObject;
				T result = caseLongAction(longAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.GUIDANCE_PROVIDER_PLUGIN_DESCRIPTOR: {
				GuidanceProviderPluginDescriptor guidanceProviderPluginDescriptor = (GuidanceProviderPluginDescriptor)theEObject;
				T result = caseGuidanceProviderPluginDescriptor(guidanceProviderPluginDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.COMPARE_ITEM: {
				CompareItem compareItem = (CompareItem)theEObject;
				T result = caseCompareItem(compareItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.OBJECT_ADDED: {
				ObjectAdded objectAdded = (ObjectAdded)theEObject;
				T result = caseObjectAdded(objectAdded);
				if (result == null) result = caseCompareItem(objectAdded);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.OBJECT_REMOVED: {
				ObjectRemoved objectRemoved = (ObjectRemoved)theEObject;
				T result = caseObjectRemoved(objectRemoved);
				if (result == null) result = caseCompareItem(objectRemoved);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.OBJECT_MODIFIED: {
				ObjectModified objectModified = (ObjectModified)theEObject;
				T result = caseObjectModified(objectModified);
				if (result == null) result = caseCompareItem(objectModified);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.COMPARE_CONTAINER: {
				CompareContainer compareContainer = (CompareContainer)theEObject;
				T result = caseCompareContainer(compareContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.COMPARE_RESULT: {
				CompareResult compareResult = (CompareResult)theEObject;
				T result = caseCompareResult(compareResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.LONG_ACTION_STATE: {
				LongActionState longActionState = (LongActionState)theEObject;
				T result = caseLongActionState(longActionState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.NOTIFICATION: {
				Notification notification = (Notification)theEObject;
				T result = caseNotification(notification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.NEW_PROJECT_NOTIFICATION: {
				NewProjectNotification newProjectNotification = (NewProjectNotification)theEObject;
				T result = caseNewProjectNotification(newProjectNotification);
				if (result == null) result = caseNotification(newProjectNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StorePackage.NEW_REVISION_NOTIFICATION: {
				NewRevisionNotification newRevisionNotification = (NewRevisionNotification)theEObject;
				T result = caseNewRevisionNotification(newRevisionNotification);
				if (result == null) result = caseNotification(newRevisionNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
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
	 * Returns the result of interpreting the object as an instance of '<em>Clash</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clash</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClash(Clash object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eid Clash</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eid Clash</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEidClash(EidClash object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guid Clash</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guid Clash</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuidClash(GuidClash object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clash Detection Settings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clash Detection Settings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClashDetectionSettings(ClashDetectionSettings object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Settings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Settings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSettings(Settings object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Guidance Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guidance Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuidanceProvider(GuidanceProvider object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Guidance Provider Plugin Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guidance Provider Plugin Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuidanceProviderPluginDescriptor(GuidanceProviderPluginDescriptor object) {
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
