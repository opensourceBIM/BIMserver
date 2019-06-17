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
package org.bimserver.models.store.util;

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

import org.bimserver.models.store.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.store.StorePackage
 * @generated
 */
public class StoreAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StorePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StorePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StoreSwitch<Adapter> modelSwitch = new StoreSwitch<Adapter>() {
		@Override
		public Adapter caseProject(Project object) {
			return createProjectAdapter();
		}

		@Override
		public Adapter caseUser(User object) {
			return createUserAdapter();
		}

		@Override
		public Adapter caseRevision(Revision object) {
			return createRevisionAdapter();
		}

		@Override
		public Adapter caseConcreteRevision(ConcreteRevision object) {
			return createConcreteRevisionAdapter();
		}

		@Override
		public Adapter caseGeoTag(GeoTag object) {
			return createGeoTagAdapter();
		}

		@Override
		public Adapter caseCheckout(Checkout object) {
			return createCheckoutAdapter();
		}

		@Override
		public Adapter caseServerSettings(ServerSettings object) {
			return createServerSettingsAdapter();
		}

		@Override
		public Adapter caseUserSettings(UserSettings object) {
			return createUserSettingsAdapter();
		}

		@Override
		public Adapter casePluginConfiguration(PluginConfiguration object) {
			return createPluginConfigurationAdapter();
		}

		@Override
		public Adapter caseSerializerPluginConfiguration(SerializerPluginConfiguration object) {
			return createSerializerPluginConfigurationAdapter();
		}

		@Override
		public Adapter caseObjectIDMPluginConfiguration(ObjectIDMPluginConfiguration object) {
			return createObjectIDMPluginConfigurationAdapter();
		}

		@Override
		public Adapter caseRenderEnginePluginConfiguration(RenderEnginePluginConfiguration object) {
			return createRenderEnginePluginConfigurationAdapter();
		}

		@Override
		public Adapter caseDeserializerPluginConfiguration(DeserializerPluginConfiguration object) {
			return createDeserializerPluginConfigurationAdapter();
		}

		@Override
		public Adapter caseDownloadResult(DownloadResult object) {
			return createDownloadResultAdapter();
		}

		@Override
		public Adapter caseCheckoutResult(CheckoutResult object) {
			return createCheckoutResultAdapter();
		}

		@Override
		public Adapter caseDataValue(DataValue object) {
			return createDataValueAdapter();
		}

		@Override
		public Adapter caseDataObject(DataObject object) {
			return createDataObjectAdapter();
		}

		@Override
		public Adapter caseUserSession(UserSession object) {
			return createUserSessionAdapter();
		}

		@Override
		public Adapter caseMigration(Migration object) {
			return createMigrationAdapter();
		}

		@Override
		public Adapter caseReferenceDataValue(ReferenceDataValue object) {
			return createReferenceDataValueAdapter();
		}

		@Override
		public Adapter caseListDataValue(ListDataValue object) {
			return createListDataValueAdapter();
		}

		@Override
		public Adapter caseSimpleDataValue(SimpleDataValue object) {
			return createSimpleDataValueAdapter();
		}

		@Override
		public Adapter caseDatabaseInformationItem(DatabaseInformationItem object) {
			return createDatabaseInformationItemAdapter();
		}

		@Override
		public Adapter caseDatabaseInformationCategory(DatabaseInformationCategory object) {
			return createDatabaseInformationCategoryAdapter();
		}

		@Override
		public Adapter caseDatabaseInformation(DatabaseInformation object) {
			return createDatabaseInformationAdapter();
		}

		@Override
		public Adapter casePluginDescriptor(PluginDescriptor object) {
			return createPluginDescriptorAdapter();
		}

		@Override
		public Adapter caseRevisionSummaryType(RevisionSummaryType object) {
			return createRevisionSummaryTypeAdapter();
		}

		@Override
		public Adapter caseRevisionSummaryContainer(RevisionSummaryContainer object) {
			return createRevisionSummaryContainerAdapter();
		}

		@Override
		public Adapter caseRevisionSummary(RevisionSummary object) {
			return createRevisionSummaryAdapter();
		}

		@Override
		public Adapter caseLongAction(LongAction object) {
			return createLongActionAdapter();
		}

		@Override
		public Adapter caseObjectIDMPluginDescriptor(ObjectIDMPluginDescriptor object) {
			return createObjectIDMPluginDescriptorAdapter();
		}

		@Override
		public Adapter caseCompareItem(CompareItem object) {
			return createCompareItemAdapter();
		}

		@Override
		public Adapter caseObjectAdded(ObjectAdded object) {
			return createObjectAddedAdapter();
		}

		@Override
		public Adapter caseObjectRemoved(ObjectRemoved object) {
			return createObjectRemovedAdapter();
		}

		@Override
		public Adapter caseObjectModified(ObjectModified object) {
			return createObjectModifiedAdapter();
		}

		@Override
		public Adapter caseCompareContainer(CompareContainer object) {
			return createCompareContainerAdapter();
		}

		@Override
		public Adapter caseCompareResult(CompareResult object) {
			return createCompareResultAdapter();
		}

		@Override
		public Adapter caseLongActionState(LongActionState object) {
			return createLongActionStateAdapter();
		}

		@Override
		public Adapter caseServerInfo(ServerInfo object) {
			return createServerInfoAdapter();
		}

		@Override
		public Adapter caseVersion(Version object) {
			return createVersionAdapter();
		}

		@Override
		public Adapter caseFile(File object) {
			return createFileAdapter();
		}

		@Override
		public Adapter caseExtendedDataSchema(ExtendedDataSchema object) {
			return createExtendedDataSchemaAdapter();
		}

		@Override
		public Adapter caseExtendedData(ExtendedData object) {
			return createExtendedDataAdapter();
		}

		@Override
		public Adapter caseQueryEnginePluginConfiguration(QueryEnginePluginConfiguration object) {
			return createQueryEnginePluginConfigurationAdapter();
		}

		@Override
		public Adapter caseWebModulePluginConfiguration(WebModulePluginConfiguration object) {
			return createWebModulePluginConfigurationAdapter();
		}

		@Override
		public Adapter caseModelMergerPluginConfiguration(ModelMergerPluginConfiguration object) {
			return createModelMergerPluginConfigurationAdapter();
		}

		@Override
		public Adapter caseModelComparePluginConfiguration(ModelComparePluginConfiguration object) {
			return createModelComparePluginConfigurationAdapter();
		}

		@Override
		public Adapter caseProfileDescriptor(ProfileDescriptor object) {
			return createProfileDescriptorAdapter();
		}

		@Override
		public Adapter caseServiceDescriptor(ServiceDescriptor object) {
			return createServiceDescriptorAdapter();
		}

		@Override
		public Adapter caseService(Service object) {
			return createServiceAdapter();
		}

		@Override
		public Adapter caseToken(Token object) {
			return createTokenAdapter();
		}

		@Override
		public Adapter caseInternalServicePluginConfiguration(InternalServicePluginConfiguration object) {
			return createInternalServicePluginConfigurationAdapter();
		}

		@Override
		public Adapter caseServiceInterface(ServiceInterface object) {
			return createServiceInterfaceAdapter();
		}

		@Override
		public Adapter caseServiceMethod(ServiceMethod object) {
			return createServiceMethodAdapter();
		}

		@Override
		public Adapter caseServiceField(ServiceField object) {
			return createServiceFieldAdapter();
		}

		@Override
		public Adapter caseServiceType(ServiceType object) {
			return createServiceTypeAdapter();
		}

		@Override
		public Adapter caseServiceParameter(ServiceParameter object) {
			return createServiceParameterAdapter();
		}

		@Override
		public Adapter caseTypeDefinition(TypeDefinition object) {
			return createTypeDefinitionAdapter();
		}

		@Override
		public Adapter caseObjectDefinition(ObjectDefinition object) {
			return createObjectDefinitionAdapter();
		}

		@Override
		public Adapter casePrimitiveDefinition(PrimitiveDefinition object) {
			return createPrimitiveDefinitionAdapter();
		}

		@Override
		public Adapter caseArrayDefinition(ArrayDefinition object) {
			return createArrayDefinitionAdapter();
		}

		@Override
		public Adapter caseParameterDefinition(ParameterDefinition object) {
			return createParameterDefinitionAdapter();
		}

		@Override
		public Adapter caseType(Type object) {
			return createTypeAdapter();
		}

		@Override
		public Adapter caseObjectType(ObjectType object) {
			return createObjectTypeAdapter();
		}

		@Override
		public Adapter casePrimitiveType(PrimitiveType object) {
			return createPrimitiveTypeAdapter();
		}

		@Override
		public Adapter caseLongType(LongType object) {
			return createLongTypeAdapter();
		}

		@Override
		public Adapter caseByteArrayType(ByteArrayType object) {
			return createByteArrayTypeAdapter();
		}

		@Override
		public Adapter caseDoubleType(DoubleType object) {
			return createDoubleTypeAdapter();
		}

		@Override
		public Adapter caseStringType(StringType object) {
			return createStringTypeAdapter();
		}

		@Override
		public Adapter caseBooleanType(BooleanType object) {
			return createBooleanTypeAdapter();
		}

		@Override
		public Adapter caseArrayType(ArrayType object) {
			return createArrayTypeAdapter();
		}

		@Override
		public Adapter caseParameter(Parameter object) {
			return createParameterAdapter();
		}

		@Override
		public Adapter caseImmediateNotificationResult(ImmediateNotificationResult object) {
			return createImmediateNotificationResultAdapter();
		}

		@Override
		public Adapter caseRemoteServiceUpdate(RemoteServiceUpdate object) {
			return createRemoteServiceUpdateAdapter();
		}

		@Override
		public Adapter casePercentageChange(PercentageChange object) {
			return createPercentageChangeAdapter();
		}

		@Override
		public Adapter caseSystemInfo(SystemInfo object) {
			return createSystemInfoAdapter();
		}

		@Override
		public Adapter caseJavaInfo(JavaInfo object) {
			return createJavaInfoAdapter();
		}

		@Override
		public Adapter caseBimServerInfo(BimServerInfo object) {
			return createBimServerInfoAdapter();
		}

		@Override
		public Adapter caseProjectSmall(ProjectSmall object) {
			return createProjectSmallAdapter();
		}

		@Override
		public Adapter caseIfcHeader(IfcHeader object) {
			return createIfcHeaderAdapter();
		}

		@Override
		public Adapter caseModelCheckerResultItem(ModelCheckerResultItem object) {
			return createModelCheckerResultItemAdapter();
		}

		@Override
		public Adapter caseModelCheckerResultHeader(ModelCheckerResultHeader object) {
			return createModelCheckerResultHeaderAdapter();
		}

		@Override
		public Adapter caseModelCheckerResultLine(ModelCheckerResultLine object) {
			return createModelCheckerResultLineAdapter();
		}

		@Override
		public Adapter caseModelCheckerResult(ModelCheckerResult object) {
			return createModelCheckerResultAdapter();
		}

		@Override
		public Adapter caseModelCheckerInstance(ModelCheckerInstance object) {
			return createModelCheckerInstanceAdapter();
		}

		@Override
		public Adapter caseMessagingSerializerPluginConfiguration(MessagingSerializerPluginConfiguration object) {
			return createMessagingSerializerPluginConfigurationAdapter();
		}

		@Override
		public Adapter caseMetrics(Metrics object) {
			return createMetricsAdapter();
		}

		@Override
		public Adapter caseInterfaceMetric(InterfaceMetric object) {
			return createInterfaceMetricAdapter();
		}

		@Override
		public Adapter caseMethodMetric(MethodMetric object) {
			return createMethodMetricAdapter();
		}

		@Override
		public Adapter casePluginBundleVersion(PluginBundleVersion object) {
			return createPluginBundleVersionAdapter();
		}

		@Override
		public Adapter casePluginBundle(PluginBundle object) {
			return createPluginBundleAdapter();
		}

		@Override
		public Adapter casePluginInformation(PluginInformation object) {
			return createPluginInformationAdapter();
		}

		@Override
		public Adapter caseOAuthServer(OAuthServer object) {
			return createOAuthServerAdapter();
		}

		@Override
		public Adapter caseOAuthAuthorizationCode(OAuthAuthorizationCode object) {
			return createOAuthAuthorizationCodeAdapter();
		}

		@Override
		public Adapter caseAuthorization(Authorization object) {
			return createAuthorizationAdapter();
		}

		@Override
		public Adapter caseSingleProjectAuthorization(SingleProjectAuthorization object) {
			return createSingleProjectAuthorizationAdapter();
		}

		@Override
		public Adapter caseNewServiceDescriptor(NewServiceDescriptor object) {
			return createNewServiceDescriptorAdapter();
		}

		@Override
		public Adapter caseFormatSerializerMap(FormatSerializerMap object) {
			return createFormatSerializerMapAdapter();
		}

		@Override
		public Adapter caseAction(Action object) {
			return createActionAdapter();
		}

		@Override
		public Adapter caseStoreExtendedData(StoreExtendedData object) {
			return createStoreExtendedDataAdapter();
		}

		@Override
		public Adapter caseCheckinRevision(CheckinRevision object) {
			return createCheckinRevisionAdapter();
		}

		@Override
		public Adapter caseNewService(NewService object) {
			return createNewServiceAdapter();
		}

		@Override
		public Adapter caseRunServiceAuthorization(RunServiceAuthorization object) {
			return createRunServiceAuthorizationAdapter();
		}

		@Override
		public Adapter caseDensityCollection(DensityCollection object) {
			return createDensityCollectionAdapter();
		}

		@Override
		public Adapter caseDensity(Density object) {
			return createDensityAdapter();
		}

		@Override
		public Adapter caseLongCheckinActionState(LongCheckinActionState object) {
			return createLongCheckinActionStateAdapter();
		}

		@Override
		public Adapter caseTile(Tile object) {
			return createTileAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Project
	 * @generated
	 */
	public Adapter createProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.User
	 * @generated
	 */
	public Adapter createUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Revision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Revision
	 * @generated
	 */
	public Adapter createRevisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ConcreteRevision <em>Concrete Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ConcreteRevision
	 * @generated
	 */
	public Adapter createConcreteRevisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.GeoTag <em>Geo Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.GeoTag
	 * @generated
	 */
	public Adapter createGeoTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Checkout <em>Checkout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Checkout
	 * @generated
	 */
	public Adapter createCheckoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ServerSettings <em>Server Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ServerSettings
	 * @generated
	 */
	public Adapter createServerSettingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.UserSettings <em>User Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.UserSettings
	 * @generated
	 */
	public Adapter createUserSettingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.PluginConfiguration <em>Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.PluginConfiguration
	 * @generated
	 */
	public Adapter createPluginConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.SerializerPluginConfiguration <em>Serializer Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.SerializerPluginConfiguration
	 * @generated
	 */
	public Adapter createSerializerPluginConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ObjectIDMPluginConfiguration <em>Object IDM Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ObjectIDMPluginConfiguration
	 * @generated
	 */
	public Adapter createObjectIDMPluginConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.RenderEnginePluginConfiguration <em>Render Engine Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.RenderEnginePluginConfiguration
	 * @generated
	 */
	public Adapter createRenderEnginePluginConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.DeserializerPluginConfiguration <em>Deserializer Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.DeserializerPluginConfiguration
	 * @generated
	 */
	public Adapter createDeserializerPluginConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.DownloadResult <em>Download Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.DownloadResult
	 * @generated
	 */
	public Adapter createDownloadResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.CheckoutResult <em>Checkout Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.CheckoutResult
	 * @generated
	 */
	public Adapter createCheckoutResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.DataValue <em>Data Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.DataValue
	 * @generated
	 */
	public Adapter createDataValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.DataObject <em>Data Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.DataObject
	 * @generated
	 */
	public Adapter createDataObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.UserSession <em>User Session</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.UserSession
	 * @generated
	 */
	public Adapter createUserSessionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Migration <em>Migration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Migration
	 * @generated
	 */
	public Adapter createMigrationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ReferenceDataValue <em>Reference Data Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ReferenceDataValue
	 * @generated
	 */
	public Adapter createReferenceDataValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ListDataValue <em>List Data Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ListDataValue
	 * @generated
	 */
	public Adapter createListDataValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.SimpleDataValue <em>Simple Data Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.SimpleDataValue
	 * @generated
	 */
	public Adapter createSimpleDataValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.DatabaseInformationItem <em>Database Information Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.DatabaseInformationItem
	 * @generated
	 */
	public Adapter createDatabaseInformationItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.DatabaseInformationCategory <em>Database Information Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.DatabaseInformationCategory
	 * @generated
	 */
	public Adapter createDatabaseInformationCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.DatabaseInformation <em>Database Information</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.DatabaseInformation
	 * @generated
	 */
	public Adapter createDatabaseInformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.PluginDescriptor <em>Plugin Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.PluginDescriptor
	 * @generated
	 */
	public Adapter createPluginDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.RevisionSummaryType <em>Revision Summary Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.RevisionSummaryType
	 * @generated
	 */
	public Adapter createRevisionSummaryTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.RevisionSummaryContainer <em>Revision Summary Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.RevisionSummaryContainer
	 * @generated
	 */
	public Adapter createRevisionSummaryContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.RevisionSummary <em>Revision Summary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.RevisionSummary
	 * @generated
	 */
	public Adapter createRevisionSummaryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.LongAction <em>Long Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.LongAction
	 * @generated
	 */
	public Adapter createLongActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ObjectIDMPluginDescriptor <em>Object IDM Plugin Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ObjectIDMPluginDescriptor
	 * @generated
	 */
	public Adapter createObjectIDMPluginDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.CompareItem <em>Compare Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.CompareItem
	 * @generated
	 */
	public Adapter createCompareItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ObjectAdded <em>Object Added</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ObjectAdded
	 * @generated
	 */
	public Adapter createObjectAddedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ObjectRemoved <em>Object Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ObjectRemoved
	 * @generated
	 */
	public Adapter createObjectRemovedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ObjectModified <em>Object Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ObjectModified
	 * @generated
	 */
	public Adapter createObjectModifiedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.CompareContainer <em>Compare Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.CompareContainer
	 * @generated
	 */
	public Adapter createCompareContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.CompareResult <em>Compare Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.CompareResult
	 * @generated
	 */
	public Adapter createCompareResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.LongActionState <em>Long Action State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.LongActionState
	 * @generated
	 */
	public Adapter createLongActionStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ServerInfo <em>Server Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ServerInfo
	 * @generated
	 */
	public Adapter createServerInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Version
	 * @generated
	 */
	public Adapter createVersionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.File
	 * @generated
	 */
	public Adapter createFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ExtendedDataSchema <em>Extended Data Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ExtendedDataSchema
	 * @generated
	 */
	public Adapter createExtendedDataSchemaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ExtendedData
	 * @generated
	 */
	public Adapter createExtendedDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.QueryEnginePluginConfiguration <em>Query Engine Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.QueryEnginePluginConfiguration
	 * @generated
	 */
	public Adapter createQueryEnginePluginConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.WebModulePluginConfiguration <em>Web Module Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.WebModulePluginConfiguration
	 * @generated
	 */
	public Adapter createWebModulePluginConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ModelMergerPluginConfiguration <em>Model Merger Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ModelMergerPluginConfiguration
	 * @generated
	 */
	public Adapter createModelMergerPluginConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ModelComparePluginConfiguration <em>Model Compare Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ModelComparePluginConfiguration
	 * @generated
	 */
	public Adapter createModelComparePluginConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ProfileDescriptor <em>Profile Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ProfileDescriptor
	 * @generated
	 */
	public Adapter createProfileDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ServiceDescriptor <em>Service Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ServiceDescriptor
	 * @generated
	 */
	public Adapter createServiceDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Service
	 * @generated
	 */
	public Adapter createServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Token
	 * @generated
	 */
	public Adapter createTokenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.InternalServicePluginConfiguration <em>Internal Service Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.InternalServicePluginConfiguration
	 * @generated
	 */
	public Adapter createInternalServicePluginConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ServiceInterface <em>Service Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ServiceInterface
	 * @generated
	 */
	public Adapter createServiceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ServiceMethod <em>Service Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ServiceMethod
	 * @generated
	 */
	public Adapter createServiceMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ServiceField <em>Service Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ServiceField
	 * @generated
	 */
	public Adapter createServiceFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ServiceType <em>Service Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ServiceType
	 * @generated
	 */
	public Adapter createServiceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ServiceParameter <em>Service Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ServiceParameter
	 * @generated
	 */
	public Adapter createServiceParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.TypeDefinition <em>Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.TypeDefinition
	 * @generated
	 */
	public Adapter createTypeDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ObjectDefinition <em>Object Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ObjectDefinition
	 * @generated
	 */
	public Adapter createObjectDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.PrimitiveDefinition <em>Primitive Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.PrimitiveDefinition
	 * @generated
	 */
	public Adapter createPrimitiveDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ArrayDefinition <em>Array Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ArrayDefinition
	 * @generated
	 */
	public Adapter createArrayDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ParameterDefinition <em>Parameter Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ParameterDefinition
	 * @generated
	 */
	public Adapter createParameterDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ObjectType <em>Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ObjectType
	 * @generated
	 */
	public Adapter createObjectTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.PrimitiveType
	 * @generated
	 */
	public Adapter createPrimitiveTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.LongType <em>Long Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.LongType
	 * @generated
	 */
	public Adapter createLongTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ByteArrayType <em>Byte Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ByteArrayType
	 * @generated
	 */
	public Adapter createByteArrayTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.DoubleType <em>Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.DoubleType
	 * @generated
	 */
	public Adapter createDoubleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.StringType
	 * @generated
	 */
	public Adapter createStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.BooleanType
	 * @generated
	 */
	public Adapter createBooleanTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ArrayType
	 * @generated
	 */
	public Adapter createArrayTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ImmediateNotificationResult <em>Immediate Notification Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ImmediateNotificationResult
	 * @generated
	 */
	public Adapter createImmediateNotificationResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.RemoteServiceUpdate <em>Remote Service Update</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.RemoteServiceUpdate
	 * @generated
	 */
	public Adapter createRemoteServiceUpdateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.PercentageChange <em>Percentage Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.PercentageChange
	 * @generated
	 */
	public Adapter createPercentageChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.SystemInfo <em>System Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.SystemInfo
	 * @generated
	 */
	public Adapter createSystemInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.JavaInfo <em>Java Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.JavaInfo
	 * @generated
	 */
	public Adapter createJavaInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.BimServerInfo <em>Bim Server Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.BimServerInfo
	 * @generated
	 */
	public Adapter createBimServerInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ProjectSmall <em>Project Small</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ProjectSmall
	 * @generated
	 */
	public Adapter createProjectSmallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.IfcHeader <em>Ifc Header</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.IfcHeader
	 * @generated
	 */
	public Adapter createIfcHeaderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ModelCheckerResultItem <em>Model Checker Result Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ModelCheckerResultItem
	 * @generated
	 */
	public Adapter createModelCheckerResultItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ModelCheckerResultHeader <em>Model Checker Result Header</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ModelCheckerResultHeader
	 * @generated
	 */
	public Adapter createModelCheckerResultHeaderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ModelCheckerResultLine <em>Model Checker Result Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ModelCheckerResultLine
	 * @generated
	 */
	public Adapter createModelCheckerResultLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ModelCheckerResult <em>Model Checker Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ModelCheckerResult
	 * @generated
	 */
	public Adapter createModelCheckerResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ModelCheckerInstance <em>Model Checker Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ModelCheckerInstance
	 * @generated
	 */
	public Adapter createModelCheckerInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.MessagingSerializerPluginConfiguration <em>Messaging Serializer Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.MessagingSerializerPluginConfiguration
	 * @generated
	 */
	public Adapter createMessagingSerializerPluginConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Metrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Metrics
	 * @generated
	 */
	public Adapter createMetricsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.InterfaceMetric <em>Interface Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.InterfaceMetric
	 * @generated
	 */
	public Adapter createInterfaceMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.MethodMetric <em>Method Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.MethodMetric
	 * @generated
	 */
	public Adapter createMethodMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.PluginBundleVersion <em>Plugin Bundle Version</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.PluginBundleVersion
	 * @generated
	 */
	public Adapter createPluginBundleVersionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.PluginBundle <em>Plugin Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.PluginBundle
	 * @generated
	 */
	public Adapter createPluginBundleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.PluginInformation <em>Plugin Information</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.PluginInformation
	 * @generated
	 */
	public Adapter createPluginInformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.OAuthServer <em>OAuth Server</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.OAuthServer
	 * @generated
	 */
	public Adapter createOAuthServerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.OAuthAuthorizationCode <em>OAuth Authorization Code</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.OAuthAuthorizationCode
	 * @generated
	 */
	public Adapter createOAuthAuthorizationCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Authorization <em>Authorization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Authorization
	 * @generated
	 */
	public Adapter createAuthorizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.SingleProjectAuthorization <em>Single Project Authorization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.SingleProjectAuthorization
	 * @generated
	 */
	public Adapter createSingleProjectAuthorizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.NewServiceDescriptor <em>New Service Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.NewServiceDescriptor
	 * @generated
	 */
	public Adapter createNewServiceDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.FormatSerializerMap <em>Format Serializer Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.FormatSerializerMap
	 * @generated
	 */
	public Adapter createFormatSerializerMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.StoreExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.StoreExtendedData
	 * @generated
	 */
	public Adapter createStoreExtendedDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.CheckinRevision <em>Checkin Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.CheckinRevision
	 * @generated
	 */
	public Adapter createCheckinRevisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.NewService <em>New Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.NewService
	 * @generated
	 */
	public Adapter createNewServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.RunServiceAuthorization <em>Run Service Authorization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.RunServiceAuthorization
	 * @generated
	 */
	public Adapter createRunServiceAuthorizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.DensityCollection <em>Density Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.DensityCollection
	 * @generated
	 */
	public Adapter createDensityCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Density <em>Density</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Density
	 * @generated
	 */
	public Adapter createDensityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.LongCheckinActionState <em>Long Checkin Action State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.LongCheckinActionState
	 * @generated
	 */
	public Adapter createLongCheckinActionStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Tile <em>Tile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Tile
	 * @generated
	 */
	public Adapter createTileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //StoreAdapterFactory
