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
package org.bimserver.models.store.impl;

import javax.activation.DataHandler;

import org.bimserver.models.store.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoreFactoryImpl extends EFactoryImpl implements StoreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StoreFactory init() {
		try {
			StoreFactory theStoreFactory = (StoreFactory) EPackage.Registry.INSTANCE.getEFactory("store");
			if (theStoreFactory != null) {
				return theStoreFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case StorePackage.PROJECT:
			return (EObject) createProject();
		case StorePackage.USER:
			return (EObject) createUser();
		case StorePackage.CLASH:
			return (EObject) createClash();
		case StorePackage.EID_CLASH:
			return (EObject) createEidClash();
		case StorePackage.GUID_CLASH:
			return (EObject) createGuidClash();
		case StorePackage.CLASH_DETECTION_SETTINGS:
			return (EObject) createClashDetectionSettings();
		case StorePackage.REVISION:
			return (EObject) createRevision();
		case StorePackage.CONCRETE_REVISION:
			return (EObject) createConcreteRevision();
		case StorePackage.GEO_TAG:
			return (EObject) createGeoTag();
		case StorePackage.CHECKOUT:
			return (EObject) createCheckout();
		case StorePackage.SETTINGS:
			return (EObject) createSettings();
		case StorePackage.SERIALIZER:
			return (EObject) createSerializer();
		case StorePackage.GUIDANCE_PROVIDER:
			return (EObject) createGuidanceProvider();
		case StorePackage.IFC_ENGINE:
			return (EObject) createIfcEngine();
		case StorePackage.PLUGIN:
			return (EObject) createPlugin();
		case StorePackage.DESERIALIZER:
			return (EObject) createDeserializer();
		case StorePackage.CHECKIN_RESULT:
			return (EObject) createCheckinResult();
		case StorePackage.DOWNLOAD_RESULT:
			return (EObject) createDownloadResult();
		case StorePackage.CHECKOUT_RESULT:
			return (EObject) createCheckoutResult();
		case StorePackage.DATA_VALUE:
			return (EObject) createDataValue();
		case StorePackage.DATA_OBJECT:
			return (EObject) createDataObject();
		case StorePackage.USER_SESSION:
			return (EObject) createUserSession();
		case StorePackage.MIGRATION:
			return (EObject) createMigration();
		case StorePackage.REFERENCE_DATA_VALUE:
			return (EObject) createReferenceDataValue();
		case StorePackage.LIST_DATA_VALUE:
			return (EObject) createListDataValue();
		case StorePackage.SIMPLE_DATA_VALUE:
			return (EObject) createSimpleDataValue();
		case StorePackage.DATABASE_INFORMATION_ITEM:
			return (EObject) createDatabaseInformationItem();
		case StorePackage.DATABASE_INFORMATION_CATEGORY:
			return (EObject) createDatabaseInformationCategory();
		case StorePackage.DATABASE_INFORMATION:
			return (EObject) createDatabaseInformation();
		case StorePackage.SERIALIZER_PLUGIN_DESCRIPTOR:
			return (EObject) createSerializerPluginDescriptor();
		case StorePackage.REVISION_SUMMARY_TYPE:
			return (EObject) createRevisionSummaryType();
		case StorePackage.REVISION_SUMMARY_CONTAINER:
			return (EObject) createRevisionSummaryContainer();
		case StorePackage.REVISION_SUMMARY:
			return (EObject) createRevisionSummary();
		case StorePackage.PLUGIN_DESCRIPTOR:
			return (EObject) createPluginDescriptor();
		case StorePackage.LONG_ACTION:
			return (EObject) createLongAction();
		case StorePackage.GUIDANCE_PROVIDER_PLUGIN_DESCRIPTOR:
			return (EObject) createGuidanceProviderPluginDescriptor();
		case StorePackage.COMPARE_ITEM:
			return (EObject) createCompareItem();
		case StorePackage.OBJECT_ADDED:
			return (EObject) createObjectAdded();
		case StorePackage.OBJECT_REMOVED:
			return (EObject) createObjectRemoved();
		case StorePackage.OBJECT_MODIFIED:
			return (EObject) createObjectModified();
		case StorePackage.COMPARE_CONTAINER:
			return (EObject) createCompareContainer();
		case StorePackage.COMPARE_RESULT:
			return (EObject) createCompareResult();
		case StorePackage.LONG_ACTION_STATE:
			return (EObject) createLongActionState();
		case StorePackage.NOTIFICATION:
			return (EObject) createNotification();
		case StorePackage.NEW_PROJECT_NOTIFICATION:
			return (EObject) createNewProjectNotification();
		case StorePackage.NEW_REVISION_NOTIFICATION:
			return (EObject) createNewRevisionNotification();
		case StorePackage.COMPILE_RESULT:
			return (EObject) createCompileResult();
		case StorePackage.RUN_RESULT:
			return (EObject) createRunResult();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case StorePackage.USER_TYPE:
			return createUserTypeFromString(eDataType, initialValue);
		case StorePackage.CHECKIN_STATE:
			return createCheckinStateFromString(eDataType, initialValue);
		case StorePackage.SI_PREFIX:
			return createSIPrefixFromString(eDataType, initialValue);
		case StorePackage.OBJECT_STATE:
			return createObjectStateFromString(eDataType, initialValue);
		case StorePackage.MERGE_IDENTIFIER:
			return createMergeIdentifierFromString(eDataType, initialValue);
		case StorePackage.COMPARE_IDENTIFIER:
			return createCompareIdentifierFromString(eDataType, initialValue);
		case StorePackage.COMPARE_TYPE:
			return createCompareTypeFromString(eDataType, initialValue);
		case StorePackage.ACTION_STATE:
			return createActionStateFromString(eDataType, initialValue);
		case StorePackage.DATA_HANDLER:
			return createDataHandlerFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case StorePackage.USER_TYPE:
			return convertUserTypeToString(eDataType, instanceValue);
		case StorePackage.CHECKIN_STATE:
			return convertCheckinStateToString(eDataType, instanceValue);
		case StorePackage.SI_PREFIX:
			return convertSIPrefixToString(eDataType, instanceValue);
		case StorePackage.OBJECT_STATE:
			return convertObjectStateToString(eDataType, instanceValue);
		case StorePackage.MERGE_IDENTIFIER:
			return convertMergeIdentifierToString(eDataType, instanceValue);
		case StorePackage.COMPARE_IDENTIFIER:
			return convertCompareIdentifierToString(eDataType, instanceValue);
		case StorePackage.COMPARE_TYPE:
			return convertCompareTypeToString(eDataType, instanceValue);
		case StorePackage.ACTION_STATE:
			return convertActionStateToString(eDataType, instanceValue);
		case StorePackage.DATA_HANDLER:
			return convertDataHandlerToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clash createClash() {
		ClashImpl clash = new ClashImpl();
		return clash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EidClash createEidClash() {
		EidClashImpl eidClash = new EidClashImpl();
		return eidClash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuidClash createGuidClash() {
		GuidClashImpl guidClash = new GuidClashImpl();
		return guidClash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClashDetectionSettings createClashDetectionSettings() {
		ClashDetectionSettingsImpl clashDetectionSettings = new ClashDetectionSettingsImpl();
		return clashDetectionSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision createRevision() {
		RevisionImpl revision = new RevisionImpl();
		return revision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteRevision createConcreteRevision() {
		ConcreteRevisionImpl concreteRevision = new ConcreteRevisionImpl();
		return concreteRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeoTag createGeoTag() {
		GeoTagImpl geoTag = new GeoTagImpl();
		return geoTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Checkout createCheckout() {
		CheckoutImpl checkout = new CheckoutImpl();
		return checkout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Settings createSettings() {
		SettingsImpl settings = new SettingsImpl();
		return settings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Serializer createSerializer() {
		SerializerImpl serializer = new SerializerImpl();
		return serializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuidanceProvider createGuidanceProvider() {
		GuidanceProviderImpl guidanceProvider = new GuidanceProviderImpl();
		return guidanceProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEngine createIfcEngine() {
		IfcEngineImpl ifcEngine = new IfcEngineImpl();
		return ifcEngine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plugin createPlugin() {
		PluginImpl plugin = new PluginImpl();
		return plugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deserializer createDeserializer() {
		DeserializerImpl deserializer = new DeserializerImpl();
		return deserializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckinResult createCheckinResult() {
		CheckinResultImpl checkinResult = new CheckinResultImpl();
		return checkinResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DownloadResult createDownloadResult() {
		DownloadResultImpl downloadResult = new DownloadResultImpl();
		return downloadResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckoutResult createCheckoutResult() {
		CheckoutResultImpl checkoutResult = new CheckoutResultImpl();
		return checkoutResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataValue createDataValue() {
		DataValueImpl dataValue = new DataValueImpl();
		return dataValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataObject createDataObject() {
		DataObjectImpl dataObject = new DataObjectImpl();
		return dataObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserSession createUserSession() {
		UserSessionImpl userSession = new UserSessionImpl();
		return userSession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Migration createMigration() {
		MigrationImpl migration = new MigrationImpl();
		return migration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceDataValue createReferenceDataValue() {
		ReferenceDataValueImpl referenceDataValue = new ReferenceDataValueImpl();
		return referenceDataValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListDataValue createListDataValue() {
		ListDataValueImpl listDataValue = new ListDataValueImpl();
		return listDataValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleDataValue createSimpleDataValue() {
		SimpleDataValueImpl simpleDataValue = new SimpleDataValueImpl();
		return simpleDataValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseInformationItem createDatabaseInformationItem() {
		DatabaseInformationItemImpl databaseInformationItem = new DatabaseInformationItemImpl();
		return databaseInformationItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseInformationCategory createDatabaseInformationCategory() {
		DatabaseInformationCategoryImpl databaseInformationCategory = new DatabaseInformationCategoryImpl();
		return databaseInformationCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseInformation createDatabaseInformation() {
		DatabaseInformationImpl databaseInformation = new DatabaseInformationImpl();
		return databaseInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SerializerPluginDescriptor createSerializerPluginDescriptor() {
		SerializerPluginDescriptorImpl serializerPluginDescriptor = new SerializerPluginDescriptorImpl();
		return serializerPluginDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RevisionSummaryType createRevisionSummaryType() {
		RevisionSummaryTypeImpl revisionSummaryType = new RevisionSummaryTypeImpl();
		return revisionSummaryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RevisionSummaryContainer createRevisionSummaryContainer() {
		RevisionSummaryContainerImpl revisionSummaryContainer = new RevisionSummaryContainerImpl();
		return revisionSummaryContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RevisionSummary createRevisionSummary() {
		RevisionSummaryImpl revisionSummary = new RevisionSummaryImpl();
		return revisionSummary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PluginDescriptor createPluginDescriptor() {
		PluginDescriptorImpl pluginDescriptor = new PluginDescriptorImpl();
		return pluginDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongAction createLongAction() {
		LongActionImpl longAction = new LongActionImpl();
		return longAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuidanceProviderPluginDescriptor createGuidanceProviderPluginDescriptor() {
		GuidanceProviderPluginDescriptorImpl guidanceProviderPluginDescriptor = new GuidanceProviderPluginDescriptorImpl();
		return guidanceProviderPluginDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareItem createCompareItem() {
		CompareItemImpl compareItem = new CompareItemImpl();
		return compareItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectAdded createObjectAdded() {
		ObjectAddedImpl objectAdded = new ObjectAddedImpl();
		return objectAdded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectRemoved createObjectRemoved() {
		ObjectRemovedImpl objectRemoved = new ObjectRemovedImpl();
		return objectRemoved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectModified createObjectModified() {
		ObjectModifiedImpl objectModified = new ObjectModifiedImpl();
		return objectModified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareContainer createCompareContainer() {
		CompareContainerImpl compareContainer = new CompareContainerImpl();
		return compareContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareResult createCompareResult() {
		CompareResultImpl compareResult = new CompareResultImpl();
		return compareResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongActionState createLongActionState() {
		LongActionStateImpl longActionState = new LongActionStateImpl();
		return longActionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Notification createNotification() {
		NotificationImpl notification = new NotificationImpl();
		return notification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewProjectNotification createNewProjectNotification() {
		NewProjectNotificationImpl newProjectNotification = new NewProjectNotificationImpl();
		return newProjectNotification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewRevisionNotification createNewRevisionNotification() {
		NewRevisionNotificationImpl newRevisionNotification = new NewRevisionNotificationImpl();
		return newRevisionNotification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompileResult createCompileResult() {
		CompileResultImpl compileResult = new CompileResultImpl();
		return compileResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunResult createRunResult() {
		RunResultImpl runResult = new RunResultImpl();
		return runResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserType createUserTypeFromString(EDataType eDataType, String initialValue) {
		UserType result = UserType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUserTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckinState createCheckinStateFromString(EDataType eDataType, String initialValue) {
		CheckinState result = CheckinState.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCheckinStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIPrefix createSIPrefixFromString(EDataType eDataType, String initialValue) {
		SIPrefix result = SIPrefix.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSIPrefixToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectState createObjectStateFromString(EDataType eDataType, String initialValue) {
		ObjectState result = ObjectState.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeIdentifier createMergeIdentifierFromString(EDataType eDataType, String initialValue) {
		MergeIdentifier result = MergeIdentifier.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMergeIdentifierToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareIdentifier createCompareIdentifierFromString(EDataType eDataType, String initialValue) {
		CompareIdentifier result = CompareIdentifier.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompareIdentifierToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareType createCompareTypeFromString(EDataType eDataType, String initialValue) {
		CompareType result = CompareType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompareTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionState createActionStateFromString(EDataType eDataType, String initialValue) {
		ActionState result = ActionState.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataHandler createDataHandlerFromString(EDataType eDataType, String initialValue) {
		return (DataHandler) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataHandlerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorePackage getStorePackage() {
		return (StorePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StorePackage getPackage() {
		return StorePackage.eINSTANCE;
	}

} //StoreFactoryImpl
