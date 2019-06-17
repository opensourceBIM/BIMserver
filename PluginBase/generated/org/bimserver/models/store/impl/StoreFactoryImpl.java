/**
 * Copyright (C) 2009-2014 BIMserver.org
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
			StoreFactory theStoreFactory = (StoreFactory) EPackage.Registry.INSTANCE.getEFactory(StorePackage.eNS_URI);
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
		case StorePackage.PLUGIN_CONFIGURATION:
			return (EObject) createPluginConfiguration();
		case StorePackage.SERIALIZER_PLUGIN_CONFIGURATION:
			return (EObject) createSerializerPluginConfiguration();
		case StorePackage.OBJECT_IDM_PLUGIN_CONFIGURATION:
			return (EObject) createObjectIDMPluginConfiguration();
		case StorePackage.RENDER_ENGINE_PLUGIN_CONFIGURATION:
			return (EObject) createRenderEnginePluginConfiguration();
		case StorePackage.DESERIALIZER_PLUGIN_CONFIGURATION:
			return (EObject) createDeserializerPluginConfiguration();
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
		case StorePackage.REVISION_SUMMARY_TYPE:
			return (EObject) createRevisionSummaryType();
		case StorePackage.REVISION_SUMMARY_CONTAINER:
			return (EObject) createRevisionSummaryContainer();
		case StorePackage.REVISION_SUMMARY:
			return (EObject) createRevisionSummary();
		case StorePackage.LONG_ACTION:
			return (EObject) createLongAction();
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
		case StorePackage.FILE:
			return (EObject) createFile();
		case StorePackage.EXTENDED_DATA_SCHEMA:
			return (EObject) createExtendedDataSchema();
		case StorePackage.EXTENDED_DATA:
			return (EObject) createExtendedData();
		case StorePackage.QUERY_ENGINE_PLUGIN_CONFIGURATION:
			return (EObject) createQueryEnginePluginConfiguration();
		case StorePackage.WEB_MODULE_PLUGIN_CONFIGURATION:
			return (EObject) createWebModulePluginConfiguration();
		case StorePackage.MODEL_MERGER_PLUGIN_CONFIGURATION:
			return (EObject) createModelMergerPluginConfiguration();
		case StorePackage.MODEL_COMPARE_PLUGIN_CONFIGURATION:
			return (EObject) createModelComparePluginConfiguration();
		case StorePackage.PROFILE_DESCRIPTOR:
			return (EObject) createProfileDescriptor();
		case StorePackage.SERVICE_DESCRIPTOR:
			return (EObject) createServiceDescriptor();
		case StorePackage.SERVICE:
			return (EObject) createService();
		case StorePackage.TOKEN:
			return (EObject) createToken();
		case StorePackage.INTERNAL_SERVICE_PLUGIN_CONFIGURATION:
			return (EObject) createInternalServicePluginConfiguration();
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
		case StorePackage.TYPE_DEFINITION:
			return (EObject) createTypeDefinition();
		case StorePackage.OBJECT_DEFINITION:
			return (EObject) createObjectDefinition();
		case StorePackage.PRIMITIVE_DEFINITION:
			return (EObject) createPrimitiveDefinition();
		case StorePackage.ARRAY_DEFINITION:
			return (EObject) createArrayDefinition();
		case StorePackage.PARAMETER_DEFINITION:
			return (EObject) createParameterDefinition();
		case StorePackage.TYPE:
			return (EObject) createType();
		case StorePackage.OBJECT_TYPE:
			return (EObject) createObjectType();
		case StorePackage.PRIMITIVE_TYPE:
			return (EObject) createPrimitiveType();
		case StorePackage.LONG_TYPE:
			return (EObject) createLongType();
		case StorePackage.BYTE_ARRAY_TYPE:
			return (EObject) createByteArrayType();
		case StorePackage.DOUBLE_TYPE:
			return (EObject) createDoubleType();
		case StorePackage.STRING_TYPE:
			return (EObject) createStringType();
		case StorePackage.BOOLEAN_TYPE:
			return (EObject) createBooleanType();
		case StorePackage.ARRAY_TYPE:
			return (EObject) createArrayType();
		case StorePackage.PARAMETER:
			return (EObject) createParameter();
		case StorePackage.IMMEDIATE_NOTIFICATION_RESULT:
			return (EObject) createImmediateNotificationResult();
		case StorePackage.REMOTE_SERVICE_UPDATE:
			return (EObject) createRemoteServiceUpdate();
		case StorePackage.PERCENTAGE_CHANGE:
			return (EObject) createPercentageChange();
		case StorePackage.SYSTEM_INFO:
			return (EObject) createSystemInfo();
		case StorePackage.JAVA_INFO:
			return (EObject) createJavaInfo();
		case StorePackage.BIM_SERVER_INFO:
			return (EObject) createBimServerInfo();
		case StorePackage.PROJECT_SMALL:
			return (EObject) createProjectSmall();
		case StorePackage.IFC_HEADER:
			return (EObject) createIfcHeader();
		case StorePackage.MODEL_CHECKER_RESULT_ITEM:
			return (EObject) createModelCheckerResultItem();
		case StorePackage.MODEL_CHECKER_RESULT_HEADER:
			return (EObject) createModelCheckerResultHeader();
		case StorePackage.MODEL_CHECKER_RESULT_LINE:
			return (EObject) createModelCheckerResultLine();
		case StorePackage.MODEL_CHECKER_RESULT:
			return (EObject) createModelCheckerResult();
		case StorePackage.MODEL_CHECKER_INSTANCE:
			return (EObject) createModelCheckerInstance();
		case StorePackage.MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION:
			return (EObject) createMessagingSerializerPluginConfiguration();
		case StorePackage.METRICS:
			return (EObject) createMetrics();
		case StorePackage.INTERFACE_METRIC:
			return (EObject) createInterfaceMetric();
		case StorePackage.METHOD_METRIC:
			return (EObject) createMethodMetric();
		case StorePackage.PLUGIN_BUNDLE_VERSION:
			return (EObject) createPluginBundleVersion();
		case StorePackage.PLUGIN_BUNDLE:
			return (EObject) createPluginBundle();
		case StorePackage.PLUGIN_INFORMATION:
			return (EObject) createPluginInformation();
		case StorePackage.OAUTH_SERVER:
			return (EObject) createOAuthServer();
		case StorePackage.OAUTH_AUTHORIZATION_CODE:
			return (EObject) createOAuthAuthorizationCode();
		case StorePackage.AUTHORIZATION:
			return (EObject) createAuthorization();
		case StorePackage.SINGLE_PROJECT_AUTHORIZATION:
			return (EObject) createSingleProjectAuthorization();
		case StorePackage.NEW_SERVICE_DESCRIPTOR:
			return (EObject) createNewServiceDescriptor();
		case StorePackage.FORMAT_SERIALIZER_MAP:
			return (EObject) createFormatSerializerMap();
		case StorePackage.ACTION:
			return (EObject) createAction();
		case StorePackage.STORE_EXTENDED_DATA:
			return (EObject) createStoreExtendedData();
		case StorePackage.CHECKIN_REVISION:
			return (EObject) createCheckinRevision();
		case StorePackage.NEW_SERVICE:
			return (EObject) createNewService();
		case StorePackage.RUN_SERVICE_AUTHORIZATION:
			return (EObject) createRunServiceAuthorization();
		case StorePackage.DENSITY_COLLECTION:
			return (EObject) createDensityCollection();
		case StorePackage.DENSITY:
			return (EObject) createDensity();
		case StorePackage.LONG_CHECKIN_ACTION_STATE:
			return (EObject) createLongCheckinActionState();
		case StorePackage.TILE:
			return (EObject) createTile();
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
		case StorePackage.TRIGGER:
			return createTriggerFromString(eDataType, initialValue);
		case StorePackage.SERVICE_SIMPLE_TYPE:
			return createServiceSimpleTypeFromString(eDataType, initialValue);
		case StorePackage.PRIMITIVE_ENUM:
			return createPrimitiveEnumFromString(eDataType, initialValue);
		case StorePackage.NOTIFICTION_RESULT_ENUM:
			return createNotifictionResultEnumFromString(eDataType, initialValue);
		case StorePackage.PROGRESS_TOPIC_TYPE:
			return createProgressTopicTypeFromString(eDataType, initialValue);
		case StorePackage.MODEL_CHECKER_RESULT_TYPE:
			return createModelCheckerResultTypeFromString(eDataType, initialValue);
		case StorePackage.SMTP_PROTOCOL:
			return createSmtpProtocolFromString(eDataType, initialValue);
		case StorePackage.PLUGIN_BUNDLE_TYPE:
			return createPluginBundleTypeFromString(eDataType, initialValue);
		case StorePackage.PLUGIN_TYPE:
			return createPluginTypeFromString(eDataType, initialValue);
		case StorePackage.SERVICE_STATUS:
			return createServiceStatusFromString(eDataType, initialValue);
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
		case StorePackage.TRIGGER:
			return convertTriggerToString(eDataType, instanceValue);
		case StorePackage.SERVICE_SIMPLE_TYPE:
			return convertServiceSimpleTypeToString(eDataType, instanceValue);
		case StorePackage.PRIMITIVE_ENUM:
			return convertPrimitiveEnumToString(eDataType, instanceValue);
		case StorePackage.NOTIFICTION_RESULT_ENUM:
			return convertNotifictionResultEnumToString(eDataType, instanceValue);
		case StorePackage.PROGRESS_TOPIC_TYPE:
			return convertProgressTopicTypeToString(eDataType, instanceValue);
		case StorePackage.MODEL_CHECKER_RESULT_TYPE:
			return convertModelCheckerResultTypeToString(eDataType, instanceValue);
		case StorePackage.SMTP_PROTOCOL:
			return convertSmtpProtocolToString(eDataType, instanceValue);
		case StorePackage.PLUGIN_BUNDLE_TYPE:
			return convertPluginBundleTypeToString(eDataType, instanceValue);
		case StorePackage.PLUGIN_TYPE:
			return convertPluginTypeToString(eDataType, instanceValue);
		case StorePackage.SERVICE_STATUS:
			return convertServiceStatusToString(eDataType, instanceValue);
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
	@Override
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Revision createRevision() {
		RevisionImpl revision = new RevisionImpl();
		return revision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConcreteRevision createConcreteRevision() {
		ConcreteRevisionImpl concreteRevision = new ConcreteRevisionImpl();
		return concreteRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GeoTag createGeoTag() {
		GeoTagImpl geoTag = new GeoTagImpl();
		return geoTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Checkout createCheckout() {
		CheckoutImpl checkout = new CheckoutImpl();
		return checkout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServerSettings createServerSettings() {
		ServerSettingsImpl serverSettings = new ServerSettingsImpl();
		return serverSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UserSettings createUserSettings() {
		UserSettingsImpl userSettings = new UserSettingsImpl();
		return userSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginConfiguration createPluginConfiguration() {
		PluginConfigurationImpl pluginConfiguration = new PluginConfigurationImpl();
		return pluginConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SerializerPluginConfiguration createSerializerPluginConfiguration() {
		SerializerPluginConfigurationImpl serializerPluginConfiguration = new SerializerPluginConfigurationImpl();
		return serializerPluginConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectIDMPluginConfiguration createObjectIDMPluginConfiguration() {
		ObjectIDMPluginConfigurationImpl objectIDMPluginConfiguration = new ObjectIDMPluginConfigurationImpl();
		return objectIDMPluginConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RenderEnginePluginConfiguration createRenderEnginePluginConfiguration() {
		RenderEnginePluginConfigurationImpl renderEnginePluginConfiguration = new RenderEnginePluginConfigurationImpl();
		return renderEnginePluginConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeserializerPluginConfiguration createDeserializerPluginConfiguration() {
		DeserializerPluginConfigurationImpl deserializerPluginConfiguration = new DeserializerPluginConfigurationImpl();
		return deserializerPluginConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DownloadResult createDownloadResult() {
		DownloadResultImpl downloadResult = new DownloadResultImpl();
		return downloadResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CheckoutResult createCheckoutResult() {
		CheckoutResultImpl checkoutResult = new CheckoutResultImpl();
		return checkoutResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataValue createDataValue() {
		DataValueImpl dataValue = new DataValueImpl();
		return dataValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataObject createDataObject() {
		DataObjectImpl dataObject = new DataObjectImpl();
		return dataObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UserSession createUserSession() {
		UserSessionImpl userSession = new UserSessionImpl();
		return userSession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Migration createMigration() {
		MigrationImpl migration = new MigrationImpl();
		return migration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReferenceDataValue createReferenceDataValue() {
		ReferenceDataValueImpl referenceDataValue = new ReferenceDataValueImpl();
		return referenceDataValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ListDataValue createListDataValue() {
		ListDataValueImpl listDataValue = new ListDataValueImpl();
		return listDataValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleDataValue createSimpleDataValue() {
		SimpleDataValueImpl simpleDataValue = new SimpleDataValueImpl();
		return simpleDataValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DatabaseInformationItem createDatabaseInformationItem() {
		DatabaseInformationItemImpl databaseInformationItem = new DatabaseInformationItemImpl();
		return databaseInformationItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DatabaseInformationCategory createDatabaseInformationCategory() {
		DatabaseInformationCategoryImpl databaseInformationCategory = new DatabaseInformationCategoryImpl();
		return databaseInformationCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DatabaseInformation createDatabaseInformation() {
		DatabaseInformationImpl databaseInformation = new DatabaseInformationImpl();
		return databaseInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginDescriptor createPluginDescriptor() {
		PluginDescriptorImpl pluginDescriptor = new PluginDescriptorImpl();
		return pluginDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RevisionSummaryType createRevisionSummaryType() {
		RevisionSummaryTypeImpl revisionSummaryType = new RevisionSummaryTypeImpl();
		return revisionSummaryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RevisionSummaryContainer createRevisionSummaryContainer() {
		RevisionSummaryContainerImpl revisionSummaryContainer = new RevisionSummaryContainerImpl();
		return revisionSummaryContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RevisionSummary createRevisionSummary() {
		RevisionSummaryImpl revisionSummary = new RevisionSummaryImpl();
		return revisionSummary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LongAction createLongAction() {
		LongActionImpl longAction = new LongActionImpl();
		return longAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectIDMPluginDescriptor createObjectIDMPluginDescriptor() {
		ObjectIDMPluginDescriptorImpl objectIDMPluginDescriptor = new ObjectIDMPluginDescriptorImpl();
		return objectIDMPluginDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompareItem createCompareItem() {
		CompareItemImpl compareItem = new CompareItemImpl();
		return compareItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectAdded createObjectAdded() {
		ObjectAddedImpl objectAdded = new ObjectAddedImpl();
		return objectAdded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectRemoved createObjectRemoved() {
		ObjectRemovedImpl objectRemoved = new ObjectRemovedImpl();
		return objectRemoved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectModified createObjectModified() {
		ObjectModifiedImpl objectModified = new ObjectModifiedImpl();
		return objectModified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompareContainer createCompareContainer() {
		CompareContainerImpl compareContainer = new CompareContainerImpl();
		return compareContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompareResult createCompareResult() {
		CompareResultImpl compareResult = new CompareResultImpl();
		return compareResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LongActionState createLongActionState() {
		LongActionStateImpl longActionState = new LongActionStateImpl();
		return longActionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServerInfo createServerInfo() {
		ServerInfoImpl serverInfo = new ServerInfoImpl();
		return serverInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Version createVersion() {
		VersionImpl version = new VersionImpl();
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public File createFile() {
		FileImpl file = new FileImpl();
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExtendedDataSchema createExtendedDataSchema() {
		ExtendedDataSchemaImpl extendedDataSchema = new ExtendedDataSchemaImpl();
		return extendedDataSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExtendedData createExtendedData() {
		ExtendedDataImpl extendedData = new ExtendedDataImpl();
		return extendedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QueryEnginePluginConfiguration createQueryEnginePluginConfiguration() {
		QueryEnginePluginConfigurationImpl queryEnginePluginConfiguration = new QueryEnginePluginConfigurationImpl();
		return queryEnginePluginConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WebModulePluginConfiguration createWebModulePluginConfiguration() {
		WebModulePluginConfigurationImpl webModulePluginConfiguration = new WebModulePluginConfigurationImpl();
		return webModulePluginConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelMergerPluginConfiguration createModelMergerPluginConfiguration() {
		ModelMergerPluginConfigurationImpl modelMergerPluginConfiguration = new ModelMergerPluginConfigurationImpl();
		return modelMergerPluginConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelComparePluginConfiguration createModelComparePluginConfiguration() {
		ModelComparePluginConfigurationImpl modelComparePluginConfiguration = new ModelComparePluginConfigurationImpl();
		return modelComparePluginConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProfileDescriptor createProfileDescriptor() {
		ProfileDescriptorImpl profileDescriptor = new ProfileDescriptorImpl();
		return profileDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceDescriptor createServiceDescriptor() {
		ServiceDescriptorImpl serviceDescriptor = new ServiceDescriptorImpl();
		return serviceDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Token createToken() {
		TokenImpl token = new TokenImpl();
		return token;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InternalServicePluginConfiguration createInternalServicePluginConfiguration() {
		InternalServicePluginConfigurationImpl internalServicePluginConfiguration = new InternalServicePluginConfigurationImpl();
		return internalServicePluginConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceInterface createServiceInterface() {
		ServiceInterfaceImpl serviceInterface = new ServiceInterfaceImpl();
		return serviceInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceMethod createServiceMethod() {
		ServiceMethodImpl serviceMethod = new ServiceMethodImpl();
		return serviceMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceField createServiceField() {
		ServiceFieldImpl serviceField = new ServiceFieldImpl();
		return serviceField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceType createServiceType() {
		ServiceTypeImpl serviceType = new ServiceTypeImpl();
		return serviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceParameter createServiceParameter() {
		ServiceParameterImpl serviceParameter = new ServiceParameterImpl();
		return serviceParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeDefinition createTypeDefinition() {
		TypeDefinitionImpl typeDefinition = new TypeDefinitionImpl();
		return typeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectDefinition createObjectDefinition() {
		ObjectDefinitionImpl objectDefinition = new ObjectDefinitionImpl();
		return objectDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveDefinition createPrimitiveDefinition() {
		PrimitiveDefinitionImpl primitiveDefinition = new PrimitiveDefinitionImpl();
		return primitiveDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArrayDefinition createArrayDefinition() {
		ArrayDefinitionImpl arrayDefinition = new ArrayDefinitionImpl();
		return arrayDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterDefinition createParameterDefinition() {
		ParameterDefinitionImpl parameterDefinition = new ParameterDefinitionImpl();
		return parameterDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type createType() {
		TypeImpl type = new TypeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectType createObjectType() {
		ObjectTypeImpl objectType = new ObjectTypeImpl();
		return objectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LongType createLongType() {
		LongTypeImpl longType = new LongTypeImpl();
		return longType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ByteArrayType createByteArrayType() {
		ByteArrayTypeImpl byteArrayType = new ByteArrayTypeImpl();
		return byteArrayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DoubleType createDoubleType() {
		DoubleTypeImpl doubleType = new DoubleTypeImpl();
		return doubleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringType createStringType() {
		StringTypeImpl stringType = new StringTypeImpl();
		return stringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanType createBooleanType() {
		BooleanTypeImpl booleanType = new BooleanTypeImpl();
		return booleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArrayType createArrayType() {
		ArrayTypeImpl arrayType = new ArrayTypeImpl();
		return arrayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImmediateNotificationResult createImmediateNotificationResult() {
		ImmediateNotificationResultImpl immediateNotificationResult = new ImmediateNotificationResultImpl();
		return immediateNotificationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RemoteServiceUpdate createRemoteServiceUpdate() {
		RemoteServiceUpdateImpl remoteServiceUpdate = new RemoteServiceUpdateImpl();
		return remoteServiceUpdate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PercentageChange createPercentageChange() {
		PercentageChangeImpl percentageChange = new PercentageChangeImpl();
		return percentageChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SystemInfo createSystemInfo() {
		SystemInfoImpl systemInfo = new SystemInfoImpl();
		return systemInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JavaInfo createJavaInfo() {
		JavaInfoImpl javaInfo = new JavaInfoImpl();
		return javaInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BimServerInfo createBimServerInfo() {
		BimServerInfoImpl bimServerInfo = new BimServerInfoImpl();
		return bimServerInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProjectSmall createProjectSmall() {
		ProjectSmallImpl projectSmall = new ProjectSmallImpl();
		return projectSmall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcHeader createIfcHeader() {
		IfcHeaderImpl ifcHeader = new IfcHeaderImpl();
		return ifcHeader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelCheckerResultItem createModelCheckerResultItem() {
		ModelCheckerResultItemImpl modelCheckerResultItem = new ModelCheckerResultItemImpl();
		return modelCheckerResultItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelCheckerResultHeader createModelCheckerResultHeader() {
		ModelCheckerResultHeaderImpl modelCheckerResultHeader = new ModelCheckerResultHeaderImpl();
		return modelCheckerResultHeader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelCheckerResultLine createModelCheckerResultLine() {
		ModelCheckerResultLineImpl modelCheckerResultLine = new ModelCheckerResultLineImpl();
		return modelCheckerResultLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelCheckerResult createModelCheckerResult() {
		ModelCheckerResultImpl modelCheckerResult = new ModelCheckerResultImpl();
		return modelCheckerResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelCheckerInstance createModelCheckerInstance() {
		ModelCheckerInstanceImpl modelCheckerInstance = new ModelCheckerInstanceImpl();
		return modelCheckerInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MessagingSerializerPluginConfiguration createMessagingSerializerPluginConfiguration() {
		MessagingSerializerPluginConfigurationImpl messagingSerializerPluginConfiguration = new MessagingSerializerPluginConfigurationImpl();
		return messagingSerializerPluginConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Metrics createMetrics() {
		MetricsImpl metrics = new MetricsImpl();
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InterfaceMetric createInterfaceMetric() {
		InterfaceMetricImpl interfaceMetric = new InterfaceMetricImpl();
		return interfaceMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MethodMetric createMethodMetric() {
		MethodMetricImpl methodMetric = new MethodMetricImpl();
		return methodMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginBundleVersion createPluginBundleVersion() {
		PluginBundleVersionImpl pluginBundleVersion = new PluginBundleVersionImpl();
		return pluginBundleVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginBundle createPluginBundle() {
		PluginBundleImpl pluginBundle = new PluginBundleImpl();
		return pluginBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginInformation createPluginInformation() {
		PluginInformationImpl pluginInformation = new PluginInformationImpl();
		return pluginInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OAuthServer createOAuthServer() {
		OAuthServerImpl oAuthServer = new OAuthServerImpl();
		return oAuthServer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OAuthAuthorizationCode createOAuthAuthorizationCode() {
		OAuthAuthorizationCodeImpl oAuthAuthorizationCode = new OAuthAuthorizationCodeImpl();
		return oAuthAuthorizationCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Authorization createAuthorization() {
		AuthorizationImpl authorization = new AuthorizationImpl();
		return authorization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SingleProjectAuthorization createSingleProjectAuthorization() {
		SingleProjectAuthorizationImpl singleProjectAuthorization = new SingleProjectAuthorizationImpl();
		return singleProjectAuthorization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NewServiceDescriptor createNewServiceDescriptor() {
		NewServiceDescriptorImpl newServiceDescriptor = new NewServiceDescriptorImpl();
		return newServiceDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FormatSerializerMap createFormatSerializerMap() {
		FormatSerializerMapImpl formatSerializerMap = new FormatSerializerMapImpl();
		return formatSerializerMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StoreExtendedData createStoreExtendedData() {
		StoreExtendedDataImpl storeExtendedData = new StoreExtendedDataImpl();
		return storeExtendedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CheckinRevision createCheckinRevision() {
		CheckinRevisionImpl checkinRevision = new CheckinRevisionImpl();
		return checkinRevision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NewService createNewService() {
		NewServiceImpl newService = new NewServiceImpl();
		return newService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RunServiceAuthorization createRunServiceAuthorization() {
		RunServiceAuthorizationImpl runServiceAuthorization = new RunServiceAuthorizationImpl();
		return runServiceAuthorization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DensityCollection createDensityCollection() {
		DensityCollectionImpl densityCollection = new DensityCollectionImpl();
		return densityCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Density createDensity() {
		DensityImpl density = new DensityImpl();
		return density;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LongCheckinActionState createLongCheckinActionState() {
		LongCheckinActionStateImpl longCheckinActionState = new LongCheckinActionStateImpl();
		return longCheckinActionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tile createTile() {
		TileImpl tile = new TileImpl();
		return tile;
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
	public ServiceSimpleType createServiceSimpleTypeFromString(EDataType eDataType, String initialValue) {
		ServiceSimpleType result = ServiceSimpleType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertServiceSimpleTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveEnum createPrimitiveEnumFromString(EDataType eDataType, String initialValue) {
		PrimitiveEnum result = PrimitiveEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotifictionResultEnum createNotifictionResultEnumFromString(EDataType eDataType, String initialValue) {
		NotifictionResultEnum result = NotifictionResultEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNotifictionResultEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgressTopicType createProgressTopicTypeFromString(EDataType eDataType, String initialValue) {
		ProgressTopicType result = ProgressTopicType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProgressTopicTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelCheckerResultType createModelCheckerResultTypeFromString(EDataType eDataType, String initialValue) {
		ModelCheckerResultType result = ModelCheckerResultType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertModelCheckerResultTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmtpProtocol createSmtpProtocolFromString(EDataType eDataType, String initialValue) {
		SmtpProtocol result = SmtpProtocol.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSmtpProtocolToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PluginBundleType createPluginBundleTypeFromString(EDataType eDataType, String initialValue) {
		PluginBundleType result = PluginBundleType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPluginBundleTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PluginType createPluginTypeFromString(EDataType eDataType, String initialValue) {
		PluginType result = PluginType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPluginTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceStatus createServiceStatusFromString(EDataType eDataType, String initialValue) {
		ServiceStatus result = ServiceStatus.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertServiceStatusToString(EDataType eDataType, Object instanceValue) {
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
	@Override
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
