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
package org.bimserver.models.store;

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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.store.StorePackage
 * @generated
 */
public interface StoreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StoreFactory eINSTANCE = org.bimserver.models.store.impl.StoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project</em>'.
	 * @generated
	 */
	Project createProject();

	/**
	 * Returns a new object of class '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	User createUser();

	/**
	 * Returns a new object of class '<em>Revision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Revision</em>'.
	 * @generated
	 */
	Revision createRevision();

	/**
	 * Returns a new object of class '<em>Concrete Revision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Revision</em>'.
	 * @generated
	 */
	ConcreteRevision createConcreteRevision();

	/**
	 * Returns a new object of class '<em>Geo Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Geo Tag</em>'.
	 * @generated
	 */
	GeoTag createGeoTag();

	/**
	 * Returns a new object of class '<em>Checkout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Checkout</em>'.
	 * @generated
	 */
	Checkout createCheckout();

	/**
	 * Returns a new object of class '<em>Server Settings</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server Settings</em>'.
	 * @generated
	 */
	ServerSettings createServerSettings();

	/**
	 * Returns a new object of class '<em>User Settings</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Settings</em>'.
	 * @generated
	 */
	UserSettings createUserSettings();

	/**
	 * Returns a new object of class '<em>Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugin Configuration</em>'.
	 * @generated
	 */
	PluginConfiguration createPluginConfiguration();

	/**
	 * Returns a new object of class '<em>Serializer Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Serializer Plugin Configuration</em>'.
	 * @generated
	 */
	SerializerPluginConfiguration createSerializerPluginConfiguration();

	/**
	 * Returns a new object of class '<em>Object IDM Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object IDM Plugin Configuration</em>'.
	 * @generated
	 */
	ObjectIDMPluginConfiguration createObjectIDMPluginConfiguration();

	/**
	 * Returns a new object of class '<em>Render Engine Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Render Engine Plugin Configuration</em>'.
	 * @generated
	 */
	RenderEnginePluginConfiguration createRenderEnginePluginConfiguration();

	/**
	 * Returns a new object of class '<em>Deserializer Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deserializer Plugin Configuration</em>'.
	 * @generated
	 */
	DeserializerPluginConfiguration createDeserializerPluginConfiguration();

	/**
	 * Returns a new object of class '<em>Download Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Download Result</em>'.
	 * @generated
	 */
	DownloadResult createDownloadResult();

	/**
	 * Returns a new object of class '<em>Checkout Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Checkout Result</em>'.
	 * @generated
	 */
	CheckoutResult createCheckoutResult();

	/**
	 * Returns a new object of class '<em>Data Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Value</em>'.
	 * @generated
	 */
	DataValue createDataValue();

	/**
	 * Returns a new object of class '<em>Data Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Object</em>'.
	 * @generated
	 */
	DataObject createDataObject();

	/**
	 * Returns a new object of class '<em>User Session</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Session</em>'.
	 * @generated
	 */
	UserSession createUserSession();

	/**
	 * Returns a new object of class '<em>Migration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Migration</em>'.
	 * @generated
	 */
	Migration createMigration();

	/**
	 * Returns a new object of class '<em>Reference Data Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Data Value</em>'.
	 * @generated
	 */
	ReferenceDataValue createReferenceDataValue();

	/**
	 * Returns a new object of class '<em>List Data Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Data Value</em>'.
	 * @generated
	 */
	ListDataValue createListDataValue();

	/**
	 * Returns a new object of class '<em>Simple Data Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Data Value</em>'.
	 * @generated
	 */
	SimpleDataValue createSimpleDataValue();

	/**
	 * Returns a new object of class '<em>Database Information Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Database Information Item</em>'.
	 * @generated
	 */
	DatabaseInformationItem createDatabaseInformationItem();

	/**
	 * Returns a new object of class '<em>Database Information Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Database Information Category</em>'.
	 * @generated
	 */
	DatabaseInformationCategory createDatabaseInformationCategory();

	/**
	 * Returns a new object of class '<em>Database Information</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Database Information</em>'.
	 * @generated
	 */
	DatabaseInformation createDatabaseInformation();

	/**
	 * Returns a new object of class '<em>Plugin Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugin Descriptor</em>'.
	 * @generated
	 */
	PluginDescriptor createPluginDescriptor();

	/**
	 * Returns a new object of class '<em>Revision Summary Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Revision Summary Type</em>'.
	 * @generated
	 */
	RevisionSummaryType createRevisionSummaryType();

	/**
	 * Returns a new object of class '<em>Revision Summary Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Revision Summary Container</em>'.
	 * @generated
	 */
	RevisionSummaryContainer createRevisionSummaryContainer();

	/**
	 * Returns a new object of class '<em>Revision Summary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Revision Summary</em>'.
	 * @generated
	 */
	RevisionSummary createRevisionSummary();

	/**
	 * Returns a new object of class '<em>Long Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Long Action</em>'.
	 * @generated
	 */
	LongAction createLongAction();

	/**
	 * Returns a new object of class '<em>Object IDM Plugin Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object IDM Plugin Descriptor</em>'.
	 * @generated
	 */
	ObjectIDMPluginDescriptor createObjectIDMPluginDescriptor();

	/**
	 * Returns a new object of class '<em>Compare Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compare Item</em>'.
	 * @generated
	 */
	CompareItem createCompareItem();

	/**
	 * Returns a new object of class '<em>Object Added</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Added</em>'.
	 * @generated
	 */
	ObjectAdded createObjectAdded();

	/**
	 * Returns a new object of class '<em>Object Removed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Removed</em>'.
	 * @generated
	 */
	ObjectRemoved createObjectRemoved();

	/**
	 * Returns a new object of class '<em>Object Modified</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Modified</em>'.
	 * @generated
	 */
	ObjectModified createObjectModified();

	/**
	 * Returns a new object of class '<em>Compare Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compare Container</em>'.
	 * @generated
	 */
	CompareContainer createCompareContainer();

	/**
	 * Returns a new object of class '<em>Compare Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compare Result</em>'.
	 * @generated
	 */
	CompareResult createCompareResult();

	/**
	 * Returns a new object of class '<em>Long Action State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Long Action State</em>'.
	 * @generated
	 */
	LongActionState createLongActionState();

	/**
	 * Returns a new object of class '<em>Server Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server Info</em>'.
	 * @generated
	 */
	ServerInfo createServerInfo();

	/**
	 * Returns a new object of class '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Version</em>'.
	 * @generated
	 */
	Version createVersion();

	/**
	 * Returns a new object of class '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File</em>'.
	 * @generated
	 */
	File createFile();

	/**
	 * Returns a new object of class '<em>Extended Data Schema</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extended Data Schema</em>'.
	 * @generated
	 */
	ExtendedDataSchema createExtendedDataSchema();

	/**
	 * Returns a new object of class '<em>Extended Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extended Data</em>'.
	 * @generated
	 */
	ExtendedData createExtendedData();

	/**
	 * Returns a new object of class '<em>Query Engine Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query Engine Plugin Configuration</em>'.
	 * @generated
	 */
	QueryEnginePluginConfiguration createQueryEnginePluginConfiguration();

	/**
	 * Returns a new object of class '<em>Web Module Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Web Module Plugin Configuration</em>'.
	 * @generated
	 */
	WebModulePluginConfiguration createWebModulePluginConfiguration();

	/**
	 * Returns a new object of class '<em>Model Merger Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Merger Plugin Configuration</em>'.
	 * @generated
	 */
	ModelMergerPluginConfiguration createModelMergerPluginConfiguration();

	/**
	 * Returns a new object of class '<em>Model Compare Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Compare Plugin Configuration</em>'.
	 * @generated
	 */
	ModelComparePluginConfiguration createModelComparePluginConfiguration();

	/**
	 * Returns a new object of class '<em>Profile Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Profile Descriptor</em>'.
	 * @generated
	 */
	ProfileDescriptor createProfileDescriptor();

	/**
	 * Returns a new object of class '<em>Service Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Descriptor</em>'.
	 * @generated
	 */
	ServiceDescriptor createServiceDescriptor();

	/**
	 * Returns a new object of class '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service</em>'.
	 * @generated
	 */
	Service createService();

	/**
	 * Returns a new object of class '<em>Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Token</em>'.
	 * @generated
	 */
	Token createToken();

	/**
	 * Returns a new object of class '<em>Internal Service Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Service Plugin Configuration</em>'.
	 * @generated
	 */
	InternalServicePluginConfiguration createInternalServicePluginConfiguration();

	/**
	 * Returns a new object of class '<em>Service Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Interface</em>'.
	 * @generated
	 */
	ServiceInterface createServiceInterface();

	/**
	 * Returns a new object of class '<em>Service Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Method</em>'.
	 * @generated
	 */
	ServiceMethod createServiceMethod();

	/**
	 * Returns a new object of class '<em>Service Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Field</em>'.
	 * @generated
	 */
	ServiceField createServiceField();

	/**
	 * Returns a new object of class '<em>Service Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Type</em>'.
	 * @generated
	 */
	ServiceType createServiceType();

	/**
	 * Returns a new object of class '<em>Service Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Parameter</em>'.
	 * @generated
	 */
	ServiceParameter createServiceParameter();

	/**
	 * Returns a new object of class '<em>Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Definition</em>'.
	 * @generated
	 */
	TypeDefinition createTypeDefinition();

	/**
	 * Returns a new object of class '<em>Object Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Definition</em>'.
	 * @generated
	 */
	ObjectDefinition createObjectDefinition();

	/**
	 * Returns a new object of class '<em>Primitive Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Definition</em>'.
	 * @generated
	 */
	PrimitiveDefinition createPrimitiveDefinition();

	/**
	 * Returns a new object of class '<em>Array Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Definition</em>'.
	 * @generated
	 */
	ArrayDefinition createArrayDefinition();

	/**
	 * Returns a new object of class '<em>Parameter Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Definition</em>'.
	 * @generated
	 */
	ParameterDefinition createParameterDefinition();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	Type createType();

	/**
	 * Returns a new object of class '<em>Object Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Type</em>'.
	 * @generated
	 */
	ObjectType createObjectType();

	/**
	 * Returns a new object of class '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type</em>'.
	 * @generated
	 */
	PrimitiveType createPrimitiveType();

	/**
	 * Returns a new object of class '<em>Long Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Long Type</em>'.
	 * @generated
	 */
	LongType createLongType();

	/**
	 * Returns a new object of class '<em>Byte Array Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Byte Array Type</em>'.
	 * @generated
	 */
	ByteArrayType createByteArrayType();

	/**
	 * Returns a new object of class '<em>Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Type</em>'.
	 * @generated
	 */
	DoubleType createDoubleType();

	/**
	 * Returns a new object of class '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Type</em>'.
	 * @generated
	 */
	StringType createStringType();

	/**
	 * Returns a new object of class '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Type</em>'.
	 * @generated
	 */
	BooleanType createBooleanType();

	/**
	 * Returns a new object of class '<em>Array Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Type</em>'.
	 * @generated
	 */
	ArrayType createArrayType();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Immediate Notification Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Immediate Notification Result</em>'.
	 * @generated
	 */
	ImmediateNotificationResult createImmediateNotificationResult();

	/**
	 * Returns a new object of class '<em>Remote Service Update</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remote Service Update</em>'.
	 * @generated
	 */
	RemoteServiceUpdate createRemoteServiceUpdate();

	/**
	 * Returns a new object of class '<em>Percentage Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Percentage Change</em>'.
	 * @generated
	 */
	PercentageChange createPercentageChange();

	/**
	 * Returns a new object of class '<em>System Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Info</em>'.
	 * @generated
	 */
	SystemInfo createSystemInfo();

	/**
	 * Returns a new object of class '<em>Java Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Info</em>'.
	 * @generated
	 */
	JavaInfo createJavaInfo();

	/**
	 * Returns a new object of class '<em>Bim Server Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bim Server Info</em>'.
	 * @generated
	 */
	BimServerInfo createBimServerInfo();

	/**
	 * Returns a new object of class '<em>Project Small</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Small</em>'.
	 * @generated
	 */
	ProjectSmall createProjectSmall();

	/**
	 * Returns a new object of class '<em>Ifc Header</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Header</em>'.
	 * @generated
	 */
	IfcHeader createIfcHeader();

	/**
	 * Returns a new object of class '<em>Model Checker Result Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Checker Result Item</em>'.
	 * @generated
	 */
	ModelCheckerResultItem createModelCheckerResultItem();

	/**
	 * Returns a new object of class '<em>Model Checker Result Header</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Checker Result Header</em>'.
	 * @generated
	 */
	ModelCheckerResultHeader createModelCheckerResultHeader();

	/**
	 * Returns a new object of class '<em>Model Checker Result Line</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Checker Result Line</em>'.
	 * @generated
	 */
	ModelCheckerResultLine createModelCheckerResultLine();

	/**
	 * Returns a new object of class '<em>Model Checker Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Checker Result</em>'.
	 * @generated
	 */
	ModelCheckerResult createModelCheckerResult();

	/**
	 * Returns a new object of class '<em>Model Checker Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Checker Instance</em>'.
	 * @generated
	 */
	ModelCheckerInstance createModelCheckerInstance();

	/**
	 * Returns a new object of class '<em>Messaging Serializer Plugin Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Messaging Serializer Plugin Configuration</em>'.
	 * @generated
	 */
	MessagingSerializerPluginConfiguration createMessagingSerializerPluginConfiguration();

	/**
	 * Returns a new object of class '<em>Metrics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metrics</em>'.
	 * @generated
	 */
	Metrics createMetrics();

	/**
	 * Returns a new object of class '<em>Interface Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Metric</em>'.
	 * @generated
	 */
	InterfaceMetric createInterfaceMetric();

	/**
	 * Returns a new object of class '<em>Method Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Metric</em>'.
	 * @generated
	 */
	MethodMetric createMethodMetric();

	/**
	 * Returns a new object of class '<em>Plugin Bundle Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugin Bundle Version</em>'.
	 * @generated
	 */
	PluginBundleVersion createPluginBundleVersion();

	/**
	 * Returns a new object of class '<em>Plugin Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugin Bundle</em>'.
	 * @generated
	 */
	PluginBundle createPluginBundle();

	/**
	 * Returns a new object of class '<em>Plugin Information</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugin Information</em>'.
	 * @generated
	 */
	PluginInformation createPluginInformation();

	/**
	 * Returns a new object of class '<em>OAuth Server</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OAuth Server</em>'.
	 * @generated
	 */
	OAuthServer createOAuthServer();

	/**
	 * Returns a new object of class '<em>OAuth Authorization Code</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OAuth Authorization Code</em>'.
	 * @generated
	 */
	OAuthAuthorizationCode createOAuthAuthorizationCode();

	/**
	 * Returns a new object of class '<em>Authorization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Authorization</em>'.
	 * @generated
	 */
	Authorization createAuthorization();

	/**
	 * Returns a new object of class '<em>Single Project Authorization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Single Project Authorization</em>'.
	 * @generated
	 */
	SingleProjectAuthorization createSingleProjectAuthorization();

	/**
	 * Returns a new object of class '<em>New Service Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Service Descriptor</em>'.
	 * @generated
	 */
	NewServiceDescriptor createNewServiceDescriptor();

	/**
	 * Returns a new object of class '<em>Format Serializer Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Format Serializer Map</em>'.
	 * @generated
	 */
	FormatSerializerMap createFormatSerializerMap();

	/**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
	Action createAction();

	/**
	 * Returns a new object of class '<em>Extended Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extended Data</em>'.
	 * @generated
	 */
	StoreExtendedData createStoreExtendedData();

	/**
	 * Returns a new object of class '<em>Checkin Revision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Checkin Revision</em>'.
	 * @generated
	 */
	CheckinRevision createCheckinRevision();

	/**
	 * Returns a new object of class '<em>New Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Service</em>'.
	 * @generated
	 */
	NewService createNewService();

	/**
	 * Returns a new object of class '<em>Run Service Authorization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Run Service Authorization</em>'.
	 * @generated
	 */
	RunServiceAuthorization createRunServiceAuthorization();

	/**
	 * Returns a new object of class '<em>Density Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Density Collection</em>'.
	 * @generated
	 */
	DensityCollection createDensityCollection();

	/**
	 * Returns a new object of class '<em>Density</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Density</em>'.
	 * @generated
	 */
	Density createDensity();

	/**
	 * Returns a new object of class '<em>Long Checkin Action State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Long Checkin Action State</em>'.
	 * @generated
	 */
	LongCheckinActionState createLongCheckinActionState();

	/**
	 * Returns a new object of class '<em>Tile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tile</em>'.
	 * @generated
	 */
	Tile createTile();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StorePackage getStorePackage();

} //StoreFactory
