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
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.CheckinResult;
import org.bimserver.models.store.CheckinStatus;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.CheckoutResult;
import org.bimserver.models.store.CompareContainer;
import org.bimserver.models.store.CompareItem;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.CompareType;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DataObject;
import org.bimserver.models.store.DataValue;
import org.bimserver.models.store.DatabaseInformation;
import org.bimserver.models.store.DatabaseInformationCategory;
import org.bimserver.models.store.DatabaseInformationItem;
import org.bimserver.models.store.Deserializer;
import org.bimserver.models.store.DeserializerPluginDescriptor;
import org.bimserver.models.store.DownloadResult;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.ExtendedDataSchemaType;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.IfcEnginePluginDescriptor;
import org.bimserver.models.store.ListDataValue;
import org.bimserver.models.store.LongAction;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.LongCheckinAction;
import org.bimserver.models.store.Migration;
import org.bimserver.models.store.ModelCompare;
import org.bimserver.models.store.ModelComparePluginDescriptor;
import org.bimserver.models.store.ModelMerger;
import org.bimserver.models.store.ModelMergerPluginDescriptor;
import org.bimserver.models.store.NewProjectNotification;
import org.bimserver.models.store.NewRevisionNotification;
import org.bimserver.models.store.Notification;
import org.bimserver.models.store.ObjectAdded;
import org.bimserver.models.store.ObjectIDM;
import org.bimserver.models.store.ObjectIDMPluginDescriptor;
import org.bimserver.models.store.ObjectModified;
import org.bimserver.models.store.ObjectRemoved;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Plugin;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.QueryEngine;
import org.bimserver.models.store.QueryEnginePluginDescriptor;
import org.bimserver.models.store.ReferenceDataValue;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.RevisionSummaryContainer;
import org.bimserver.models.store.RevisionSummaryType;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.SerializerPluginDescriptor;
import org.bimserver.models.store.ServerInfo;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.SimpleDataValue;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSession;
import org.bimserver.models.store.UserSettings;
import org.bimserver.models.store.UserType;
import org.bimserver.models.store.Version;
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
		case StorePackage.REVISION:
			return (EObject) createRevision();
		case StorePackage.CONCRETE_REVISION:
			return (EObject) createConcreteRevision();
		case StorePackage.GEO_TAG:
			return (EObject) createGeoTag();
		case StorePackage.CHECKOUT:
			return (EObject) createCheckout();
		case StorePackage.SERVER_SETTINGS:
			return (EObject) createServerSettings();
		case StorePackage.USER_SETTINGS:
			return (EObject) createUserSettings();
		case StorePackage.PLUGIN:
			return (EObject) createPlugin();
		case StorePackage.SERIALIZER:
			return (EObject) createSerializer();
		case StorePackage.OBJECT_IDM:
			return (EObject) createObjectIDM();
		case StorePackage.IFC_ENGINE:
			return (EObject) createIfcEngine();
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
		case StorePackage.PLUGIN_DESCRIPTOR:
			return (EObject) createPluginDescriptor();
		case StorePackage.SERIALIZER_PLUGIN_DESCRIPTOR:
			return (EObject) createSerializerPluginDescriptor();
		case StorePackage.DESERIALIZER_PLUGIN_DESCRIPTOR:
			return (EObject) createDeserializerPluginDescriptor();
		case StorePackage.REVISION_SUMMARY_TYPE:
			return (EObject) createRevisionSummaryType();
		case StorePackage.REVISION_SUMMARY_CONTAINER:
			return (EObject) createRevisionSummaryContainer();
		case StorePackage.REVISION_SUMMARY:
			return (EObject) createRevisionSummary();
		case StorePackage.LONG_ACTION:
			return (EObject) createLongAction();
		case StorePackage.LONG_CHECKIN_ACTION:
			return (EObject) createLongCheckinAction();
		case StorePackage.OBJECT_IDM_PLUGIN_DESCRIPTOR:
			return (EObject) createObjectIDMPluginDescriptor();
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
		case StorePackage.SERVER_INFO:
			return (EObject) createServerInfo();
		case StorePackage.VERSION:
			return (EObject) createVersion();
		case StorePackage.IFC_ENGINE_PLUGIN_DESCRIPTOR:
			return (EObject) createIfcEnginePluginDescriptor();
		case StorePackage.EXTENDED_DATA_SCHEMA:
			return (EObject) createExtendedDataSchema();
		case StorePackage.EXTENDED_DATA:
			return (EObject) createExtendedData();
		case StorePackage.QUERY_ENGINE_PLUGIN_DESCRIPTOR:
			return (EObject) createQueryEnginePluginDescriptor();
		case StorePackage.QUERY_ENGINE:
			return (EObject) createQueryEngine();
		case StorePackage.MODEL_MERGER_PLUGIN_DESCRIPTOR:
			return (EObject) createModelMergerPluginDescriptor();
		case StorePackage.MODEL_MERGER:
			return (EObject) createModelMerger();
		case StorePackage.MODEL_COMPARE_PLUGIN_DESCRIPTOR:
			return (EObject) createModelComparePluginDescriptor();
		case StorePackage.MODEL_COMPARE:
			return (EObject) createModelCompare();
		case StorePackage.SERVER_DESCRIPTOR:
			return (EObject) createServerDescriptor();
		case StorePackage.SERVICE_DESCRIPTOR:
			return (EObject) createServiceDescriptor();
		case StorePackage.SERVICE:
			return (EObject) createService();
		case StorePackage.TOKEN:
			return (EObject) createToken();
		case StorePackage.SERVICE_PLUGIN_DESCRIPTOR:
			return (EObject) createServicePluginDescriptor();
		case StorePackage.ESERVICE:
			return (EObject) createEService();
		case StorePackage.SERVICE_INTERFACE:
			return (EObject) createServiceInterface();
		case StorePackage.SERVICE_METHOD:
			return (EObject) createServiceMethod();
		case StorePackage.SERVICE_FIELD:
			return (EObject) createServiceField();
		case StorePackage.SERVICE_TYPE:
			return (EObject) createServiceType();
		case StorePackage.SERVICE_PARAMETER:
			return (EObject) createServiceParameter();
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
		case StorePackage.SI_PREFIX:
			return createSIPrefixFromString(eDataType, initialValue);
		case StorePackage.OBJECT_STATE:
			return createObjectStateFromString(eDataType, initialValue);
		case StorePackage.COMPARE_TYPE:
			return createCompareTypeFromString(eDataType, initialValue);
		case StorePackage.ACTION_STATE:
			return createActionStateFromString(eDataType, initialValue);
		case StorePackage.SERVER_STATE:
			return createServerStateFromString(eDataType, initialValue);
		case StorePackage.CHECKIN_STATUS:
			return createCheckinStatusFromString(eDataType, initialValue);
		case StorePackage.EXTENDED_DATA_SCHEMA_TYPE:
			return createExtendedDataSchemaTypeFromString(eDataType, initialValue);
		case StorePackage.TRIGGER:
			return createTriggerFromString(eDataType, initialValue);
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
		case StorePackage.SI_PREFIX:
			return convertSIPrefixToString(eDataType, instanceValue);
		case StorePackage.OBJECT_STATE:
			return convertObjectStateToString(eDataType, instanceValue);
		case StorePackage.COMPARE_TYPE:
			return convertCompareTypeToString(eDataType, instanceValue);
		case StorePackage.ACTION_STATE:
			return convertActionStateToString(eDataType, instanceValue);
		case StorePackage.SERVER_STATE:
			return convertServerStateToString(eDataType, instanceValue);
		case StorePackage.CHECKIN_STATUS:
			return convertCheckinStatusToString(eDataType, instanceValue);
		case StorePackage.EXTENDED_DATA_SCHEMA_TYPE:
			return convertExtendedDataSchemaTypeToString(eDataType, instanceValue);
		case StorePackage.TRIGGER:
			return convertTriggerToString(eDataType, instanceValue);
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
	public ServerSettings createServerSettings() {
		ServerSettingsImpl serverSettings = new ServerSettingsImpl();
		return serverSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserSettings createUserSettings() {
		UserSettingsImpl userSettings = new UserSettingsImpl();
		return userSettings;
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
	public Serializer createSerializer() {
		SerializerImpl serializer = new SerializerImpl();
		return serializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectIDM createObjectIDM() {
		ObjectIDMImpl objectIDM = new ObjectIDMImpl();
		return objectIDM;
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
	public DeserializerPluginDescriptor createDeserializerPluginDescriptor() {
		DeserializerPluginDescriptorImpl deserializerPluginDescriptor = new DeserializerPluginDescriptorImpl();
		return deserializerPluginDescriptor;
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
	public LongCheckinAction createLongCheckinAction() {
		LongCheckinActionImpl longCheckinAction = new LongCheckinActionImpl();
		return longCheckinAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectIDMPluginDescriptor createObjectIDMPluginDescriptor() {
		ObjectIDMPluginDescriptorImpl objectIDMPluginDescriptor = new ObjectIDMPluginDescriptorImpl();
		return objectIDMPluginDescriptor;
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
	public ServerInfo createServerInfo() {
		ServerInfoImpl serverInfo = new ServerInfoImpl();
		return serverInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version createVersion() {
		VersionImpl version = new VersionImpl();
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEnginePluginDescriptor createIfcEnginePluginDescriptor() {
		IfcEnginePluginDescriptorImpl ifcEnginePluginDescriptor = new IfcEnginePluginDescriptorImpl();
		return ifcEnginePluginDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedDataSchema createExtendedDataSchema() {
		ExtendedDataSchemaImpl extendedDataSchema = new ExtendedDataSchemaImpl();
		return extendedDataSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedData createExtendedData() {
		ExtendedDataImpl extendedData = new ExtendedDataImpl();
		return extendedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryEnginePluginDescriptor createQueryEnginePluginDescriptor() {
		QueryEnginePluginDescriptorImpl queryEnginePluginDescriptor = new QueryEnginePluginDescriptorImpl();
		return queryEnginePluginDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryEngine createQueryEngine() {
		QueryEngineImpl queryEngine = new QueryEngineImpl();
		return queryEngine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelMergerPluginDescriptor createModelMergerPluginDescriptor() {
		ModelMergerPluginDescriptorImpl modelMergerPluginDescriptor = new ModelMergerPluginDescriptorImpl();
		return modelMergerPluginDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelMerger createModelMerger() {
		ModelMergerImpl modelMerger = new ModelMergerImpl();
		return modelMerger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelComparePluginDescriptor createModelComparePluginDescriptor() {
		ModelComparePluginDescriptorImpl modelComparePluginDescriptor = new ModelComparePluginDescriptorImpl();
		return modelComparePluginDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelCompare createModelCompare() {
		ModelCompareImpl modelCompare = new ModelCompareImpl();
		return modelCompare;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerDescriptor createServerDescriptor() {
		ServerDescriptorImpl serverDescriptor = new ServerDescriptorImpl();
		return serverDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceDescriptor createServiceDescriptor() {
		ServiceDescriptorImpl serviceDescriptor = new ServiceDescriptorImpl();
		return serviceDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Token createToken() {
		TokenImpl token = new TokenImpl();
		return token;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicePluginDescriptor createServicePluginDescriptor() {
		ServicePluginDescriptorImpl servicePluginDescriptor = new ServicePluginDescriptorImpl();
		return servicePluginDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EService createEService() {
		EServiceImpl eService = new EServiceImpl();
		return eService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceInterface createServiceInterface() {
		ServiceInterfaceImpl serviceInterface = new ServiceInterfaceImpl();
		return serviceInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceMethod createServiceMethod() {
		ServiceMethodImpl serviceMethod = new ServiceMethodImpl();
		return serviceMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceField createServiceField() {
		ServiceFieldImpl serviceField = new ServiceFieldImpl();
		return serviceField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceType createServiceType() {
		ServiceTypeImpl serviceType = new ServiceTypeImpl();
		return serviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceParameter createServiceParameter() {
		ServiceParameterImpl serviceParameter = new ServiceParameterImpl();
		return serviceParameter;
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
	public ServerState createServerStateFromString(EDataType eDataType, String initialValue) {
		ServerState result = ServerState.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertServerStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckinStatus createCheckinStatusFromString(EDataType eDataType, String initialValue) {
		CheckinStatus result = CheckinStatus.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCheckinStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedDataSchemaType createExtendedDataSchemaTypeFromString(EDataType eDataType, String initialValue) {
		ExtendedDataSchemaType result = ExtendedDataSchemaType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExtendedDataSchemaTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger createTriggerFromString(EDataType eDataType, String initialValue) {
		Trigger result = Trigger.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTriggerToString(EDataType eDataType, Object instanceValue) {
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
