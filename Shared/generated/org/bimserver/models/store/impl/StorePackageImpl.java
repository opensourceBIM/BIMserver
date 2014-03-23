/**
 * Copyright (C) 2009-2013 BIMserver.org
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

import java.io.IOException;
import java.net.URL;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.impl.Ifc2x3tc1PackageImpl;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.log.impl.LogPackageImpl;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StorePackageImpl extends EPackageImpl implements StorePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "store.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass revisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteRevisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geoTagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverSettingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userSettingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pluginConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serializerPluginConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectIDMPluginConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renderEnginePluginConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deserializerPluginConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass downloadResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkoutResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userSessionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass migrationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceDataValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listDataValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleDataValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass databaseInformationItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass databaseInformationCategoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass databaseInformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pluginDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serializerPluginDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deserializerPluginDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass revisionSummaryTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass revisionSummaryContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass revisionSummaryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectIDMPluginDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compareItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectAddedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectRemovedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectModifiedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compareContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compareResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longActionStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renderEnginePluginDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedDataSchemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryEnginePluginDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryEnginePluginConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass webModulePluginDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass webModulePluginConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelMergerPluginDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelMergerPluginConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelComparePluginDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelComparePluginConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass profileDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tokenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass servicePluginDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalServicePluginConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass byteArrayTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass immediateNotificationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass remoteServiceUpdateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass percentageChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bimServerInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectSmallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelCheckerResultItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelCheckerResultHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelCheckerResultLineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelCheckerResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelCheckerInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelCheckerPluginDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum userTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum siPrefixEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum objectStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum compareTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum actionStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum serverStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum extendedDataSchemaTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum triggerEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum serviceSimpleTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum primitiveEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum notifictionResultEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum progressTopicTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum modelCheckerResultTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum smtpProtocolEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dataHandlerEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.bimserver.models.store.StorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StorePackageImpl() {
		super(eNS_URI, StoreFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link StorePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static StorePackage init() {
		if (isInited)
			return (StorePackage) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI);

		// Obtain or create and register package
		StorePackageImpl theStorePackage = (StorePackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof StorePackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new StorePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		Ifc2x3tc1PackageImpl theIfc2x3tc1Package = (Ifc2x3tc1PackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(Ifc2x3tc1Package.eNS_URI) instanceof Ifc2x3tc1PackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(Ifc2x3tc1Package.eNS_URI)
				: Ifc2x3tc1Package.eINSTANCE);
		LogPackageImpl theLogPackage = (LogPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(LogPackage.eNS_URI) instanceof LogPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(LogPackage.eNS_URI) : LogPackage.eINSTANCE);

		// Load packages
		theStorePackage.loadPackage();
		theIfc2x3tc1Package.loadPackage();
		theLogPackage.loadPackage();

		// Fix loaded packages
		theStorePackage.fixPackageContents();
		theIfc2x3tc1Package.fixPackageContents();
		theLogPackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theStorePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StorePackage.eNS_URI, theStorePackage);
		return theStorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProject() {
		if (projectEClass == null) {
			projectEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(3);
		}
		return projectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Id() {
		return (EAttribute) getProject().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Name() {
		return (EAttribute) getProject().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_HasAuthorizedUsers() {
		return (EReference) getProject().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_ConcreteRevisions() {
		return (EReference) getProject().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Revisions() {
		return (EReference) getProject().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_LastConcreteRevision() {
		return (EReference) getProject().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_LastRevision() {
		return (EReference) getProject().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Checkouts() {
		return (EReference) getProject().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_State() {
		return (EAttribute) getProject().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_CreatedDate() {
		return (EAttribute) getProject().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_CreatedBy() {
		return (EReference) getProject().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_GeoTag() {
		return (EReference) getProject().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_SubProjects() {
		return (EReference) getProject().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Parent() {
		return (EReference) getProject().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Description() {
		return (EAttribute) getProject().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_ExportLengthMeasurePrefix() {
		return (EAttribute) getProject().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_ExtendedData() {
		return (EReference) getProject().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Services() {
		return (EReference) getProject().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Logs() {
		return (EReference) getProject().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_ModelCheckers() {
		return (EReference) getProject().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser() {
		if (userEClass == null) {
			userEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(4);
		}
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Name() {
		return (EAttribute) getUser().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_PasswordHash() {
		return (EAttribute) getUser().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_PasswordSalt() {
		return (EAttribute) getUser().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_HasRightsOn() {
		return (EReference) getUser().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_Revisions() {
		return (EReference) getUser().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_State() {
		return (EAttribute) getUser().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_CreatedOn() {
		return (EAttribute) getUser().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_CreatedBy() {
		return (EReference) getUser().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_UserType() {
		return (EAttribute) getUser().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Username() {
		return (EAttribute) getUser().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_LastSeen() {
		return (EAttribute) getUser().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Token() {
		return (EAttribute) getUser().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_ValidationToken() {
		return (EAttribute) getUser().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_ValidationTokenCreated() {
		return (EAttribute) getUser().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_UserSettings() {
		return (EReference) getUser().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_Schemas() {
		return (EReference) getUser().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_ExtendedData() {
		return (EReference) getUser().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_Services() {
		return (EReference) getUser().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_Logs() {
		return (EReference) getUser().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevision() {
		if (revisionEClass == null) {
			revisionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(5);
		}
		return revisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Id() {
		return (EAttribute) getRevision().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_User() {
		return (EReference) getRevision().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Date() {
		return (EAttribute) getRevision().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Comment() {
		return (EAttribute) getRevision().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Size() {
		return (EAttribute) getRevision().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_ConcreteRevisions() {
		return (EReference) getRevision().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_LastConcreteRevision() {
		return (EReference) getRevision().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_Checkouts() {
		return (EReference) getRevision().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_Project() {
		return (EReference) getRevision().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Tag() {
		return (EAttribute) getRevision().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_LastError() {
		return (EAttribute) getRevision().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Bmi() {
		return (EAttribute) getRevision().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_ExtendedData() {
		return (EReference) getRevision().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_Logs() {
		return (EReference) getRevision().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_Service() {
		return (EReference) getRevision().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_HasGeometry() {
		return (EAttribute) getRevision().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteRevision() {
		if (concreteRevisionEClass == null) {
			concreteRevisionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(6);
		}
		return concreteRevisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Id() {
		return (EAttribute) getConcreteRevision().getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteRevision_Project() {
		return (EReference) getConcreteRevision().getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Checksum() {
		return (EAttribute) getConcreteRevision().getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteRevision_Revisions() {
		return (EReference) getConcreteRevision().getEStructuralFeatures().get(
				3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Size() {
		return (EAttribute) getConcreteRevision().getEStructuralFeatures().get(
				4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Date() {
		return (EAttribute) getConcreteRevision().getEStructuralFeatures().get(
				5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_LastError() {
		return (EAttribute) getConcreteRevision().getEStructuralFeatures().get(
				6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Clear() {
		return (EAttribute) getConcreteRevision().getEStructuralFeatures().get(
				7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteRevision_Summary() {
		return (EReference) getConcreteRevision().getEStructuralFeatures().get(
				8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteRevision_User() {
		return (EReference) getConcreteRevision().getEStructuralFeatures().get(
				9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteRevision_IfcHeader() {
		return (EReference) getConcreteRevision().getEStructuralFeatures().get(
				10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeoTag() {
		if (geoTagEClass == null) {
			geoTagEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(7);
		}
		return geoTagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_Enabled() {
		return (EAttribute) getGeoTag().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeoTag_Projects() {
		return (EReference) getGeoTag().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_X() {
		return (EAttribute) getGeoTag().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_Y() {
		return (EAttribute) getGeoTag().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_Z() {
		return (EAttribute) getGeoTag().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_Epsg() {
		return (EAttribute) getGeoTag().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_DirectionAngle() {
		return (EAttribute) getGeoTag().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckout() {
		if (checkoutEClass == null) {
			checkoutEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(8);
		}
		return checkoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_User() {
		return (EReference) getCheckout().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_Revision() {
		return (EReference) getCheckout().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_Project() {
		return (EReference) getCheckout().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckout_Date() {
		return (EAttribute) getCheckout().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_Checkin() {
		return (EReference) getCheckout().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckout_Active() {
		return (EAttribute) getCheckout().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_Logs() {
		return (EReference) getCheckout().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerSettings() {
		if (serverSettingsEClass == null) {
			serverSettingsEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(9);
		}
		return serverSettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_SendConfirmationEmailAfterRegistration() {
		return (EAttribute) getServerSettings().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_AllowSelfRegistration() {
		return (EAttribute) getServerSettings().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_AllowUsersToCreateTopLevelProjects() {
		return (EAttribute) getServerSettings().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_CheckinMergingEnabled() {
		return (EAttribute) getServerSettings().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_SmtpServer() {
		return (EAttribute) getServerSettings().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_EmailSenderAddress() {
		return (EAttribute) getServerSettings().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_EmailSenderName() {
		return (EAttribute) getServerSettings().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_SiteAddress() {
		return (EAttribute) getServerSettings().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_GenerateGeometryOnCheckin() {
		return (EAttribute) getServerSettings().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_AllowOnlyWhitelisted() {
		return (EAttribute) getServerSettings().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_WhitelistedDomains() {
		return (EAttribute) getServerSettings().getEStructuralFeatures()
				.get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_HideUserListForNonAdmin() {
		return (EAttribute) getServerSettings().getEStructuralFeatures()
				.get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_ProtocolBuffersPort() {
		return (EAttribute) getServerSettings().getEStructuralFeatures()
				.get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_CacheOutputFiles() {
		return (EAttribute) getServerSettings().getEStructuralFeatures()
				.get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerSettings_WebModules() {
		return (EReference) getServerSettings().getEStructuralFeatures()
				.get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerSettings_WebModule() {
		return (EReference) getServerSettings().getEStructuralFeatures()
				.get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_ServiceRepositoryUrl() {
		return (EAttribute) getServerSettings().getEStructuralFeatures()
				.get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_SendEmailOnNewRevision() {
		return (EAttribute) getServerSettings().getEStructuralFeatures()
				.get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_SessionTimeOutSeconds() {
		return (EAttribute) getServerSettings().getEStructuralFeatures()
				.get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_SmtpUsername() {
		return (EAttribute) getServerSettings().getEStructuralFeatures()
				.get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_SmtpPassword() {
		return (EAttribute) getServerSettings().getEStructuralFeatures()
				.get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_SmtpPort() {
		return (EAttribute) getServerSettings().getEStructuralFeatures()
				.get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_SmtpProtocol() {
		return (EAttribute) getServerSettings().getEStructuralFeatures()
				.get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerSettings_ReuseGeometry() {
		return (EAttribute) getServerSettings().getEStructuralFeatures()
				.get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserSettings() {
		if (userSettingsEClass == null) {
			userSettingsEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(10);
		}
		return userSettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_Serializers() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_ObjectIDMs() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_RenderEngines() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_Deserializers() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_Queryengines() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_Modelmergers() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_Modelcompares() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_DefaultModelMerger() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_DefaultModelCompare() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_DefaultQueryEngine() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_DefaultRenderEngine() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_DefaultSerializer() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_DefaultObjectIDM() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSettings_Services() {
		return (EReference) getUserSettings().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPluginConfiguration() {
		if (pluginConfigurationEClass == null) {
			pluginConfigurationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(11);
		}
		return pluginConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginConfiguration_Name() {
		return (EAttribute) getPluginConfiguration().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginConfiguration_Enabled() {
		return (EAttribute) getPluginConfiguration().getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginConfiguration_Description() {
		return (EAttribute) getPluginConfiguration().getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPluginConfiguration_PluginDescriptor() {
		return (EReference) getPluginConfiguration().getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPluginConfiguration_Settings() {
		return (EReference) getPluginConfiguration().getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSerializerPluginConfiguration() {
		if (serializerPluginConfigurationEClass == null) {
			serializerPluginConfigurationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(12);
		}
		return serializerPluginConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSerializerPluginConfiguration_ObjectIDM() {
		return (EReference) getSerializerPluginConfiguration()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSerializerPluginConfiguration_UserSettings() {
		return (EReference) getSerializerPluginConfiguration()
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSerializerPluginConfiguration_RenderEngine() {
		return (EReference) getSerializerPluginConfiguration()
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectIDMPluginConfiguration() {
		if (objectIDMPluginConfigurationEClass == null) {
			objectIDMPluginConfigurationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(13);
		}
		return objectIDMPluginConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectIDMPluginConfiguration_Serializers() {
		return (EReference) getObjectIDMPluginConfiguration()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectIDMPluginConfiguration_UserSettings() {
		return (EReference) getObjectIDMPluginConfiguration()
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRenderEnginePluginConfiguration() {
		if (renderEnginePluginConfigurationEClass == null) {
			renderEnginePluginConfigurationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(14);
		}
		return renderEnginePluginConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenderEnginePluginConfiguration_Serializers() {
		return (EReference) getRenderEnginePluginConfiguration()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenderEnginePluginConfiguration_UserSettings() {
		return (EReference) getRenderEnginePluginConfiguration()
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeserializerPluginConfiguration() {
		if (deserializerPluginConfigurationEClass == null) {
			deserializerPluginConfigurationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(15);
		}
		return deserializerPluginConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeserializerPluginConfiguration_UserSettings() {
		return (EReference) getDeserializerPluginConfiguration()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDownloadResult() {
		if (downloadResultEClass == null) {
			downloadResultEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(17);
		}
		return downloadResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDownloadResult_ProjectName() {
		return (EAttribute) getDownloadResult().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDownloadResult_RevisionNr() {
		return (EAttribute) getDownloadResult().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDownloadResult_File() {
		return (EAttribute) getDownloadResult().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckoutResult() {
		if (checkoutResultEClass == null) {
			checkoutResultEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(18);
		}
		return checkoutResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataValue() {
		if (dataValueEClass == null) {
			dataValueEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(19);
		}
		return dataValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataValue_FieldName() {
		return (EAttribute) getDataValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataObject() {
		if (dataObjectEClass == null) {
			dataObjectEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(20);
		}
		return dataObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataObject_Type() {
		return (EAttribute) getDataObject().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataObject_Guid() {
		return (EAttribute) getDataObject().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataObject_Name() {
		return (EAttribute) getDataObject().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataObject_Values() {
		return (EReference) getDataObject().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserSession() {
		if (userSessionEClass == null) {
			userSessionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(21);
		}
		return userSessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSession_User() {
		return (EReference) getUserSession().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_Username() {
		return (EAttribute) getUserSession().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_Name() {
		return (EAttribute) getUserSession().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_Type() {
		return (EAttribute) getUserSession().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_RemoteAddress() {
		return (EAttribute) getUserSession().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_ActiveSince() {
		return (EAttribute) getUserSession().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_LastActive() {
		return (EAttribute) getUserSession().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_AccessMethod() {
		return (EAttribute) getUserSession().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMigration() {
		if (migrationEClass == null) {
			migrationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(22);
		}
		return migrationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMigration_Number() {
		return (EAttribute) getMigration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMigration_Description() {
		return (EAttribute) getMigration().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMigration_Executed() {
		return (EAttribute) getMigration().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceDataValue() {
		if (referenceDataValueEClass == null) {
			referenceDataValueEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(23);
		}
		return referenceDataValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceDataValue_TypeName() {
		return (EAttribute) getReferenceDataValue().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceDataValue_Guid() {
		return (EAttribute) getReferenceDataValue().getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListDataValue() {
		if (listDataValueEClass == null) {
			listDataValueEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(24);
		}
		return listDataValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListDataValue_Values() {
		return (EReference) getListDataValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleDataValue() {
		if (simpleDataValueEClass == null) {
			simpleDataValueEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(25);
		}
		return simpleDataValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleDataValue_StringValue() {
		return (EAttribute) getSimpleDataValue().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseInformationItem() {
		if (databaseInformationItemEClass == null) {
			databaseInformationItemEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(26);
		}
		return databaseInformationItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformationItem_Key() {
		return (EAttribute) getDatabaseInformationItem()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformationItem_Value() {
		return (EAttribute) getDatabaseInformationItem()
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseInformationCategory() {
		if (databaseInformationCategoryEClass == null) {
			databaseInformationCategoryEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(27);
		}
		return databaseInformationCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformationCategory_Title() {
		return (EAttribute) getDatabaseInformationCategory()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDatabaseInformationCategory_Items() {
		return (EReference) getDatabaseInformationCategory()
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseInformation() {
		if (databaseInformationEClass == null) {
			databaseInformationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(28);
		}
		return databaseInformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_NumberOfProjects() {
		return (EAttribute) getDatabaseInformation().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_NumberOfUsers() {
		return (EAttribute) getDatabaseInformation().getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_NumberOfRevisions() {
		return (EAttribute) getDatabaseInformation().getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_NumberOfCheckouts() {
		return (EAttribute) getDatabaseInformation().getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_DatabaseSizeInBytes() {
		return (EAttribute) getDatabaseInformation().getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_Type() {
		return (EAttribute) getDatabaseInformation().getEStructuralFeatures()
				.get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_Created() {
		return (EAttribute) getDatabaseInformation().getEStructuralFeatures()
				.get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_Location() {
		return (EAttribute) getDatabaseInformation().getEStructuralFeatures()
				.get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_SchemaVersion() {
		return (EAttribute) getDatabaseInformation().getEStructuralFeatures()
				.get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDatabaseInformation_Categories() {
		return (EReference) getDatabaseInformation().getEStructuralFeatures()
				.get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPluginDescriptor() {
		if (pluginDescriptorEClass == null) {
			pluginDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(29);
		}
		return pluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginDescriptor_SimpleName() {
		return (EAttribute) getPluginDescriptor().getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginDescriptor_DefaultName() {
		return (EAttribute) getPluginDescriptor().getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginDescriptor_PluginClassName() {
		return (EAttribute) getPluginDescriptor().getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginDescriptor_Description() {
		return (EAttribute) getPluginDescriptor().getEStructuralFeatures().get(
				3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginDescriptor_Location() {
		return (EAttribute) getPluginDescriptor().getEStructuralFeatures().get(
				4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginDescriptor_Enabled() {
		return (EAttribute) getPluginDescriptor().getEStructuralFeatures().get(
				5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginDescriptor_PluginInterfaceClassName() {
		return (EAttribute) getPluginDescriptor().getEStructuralFeatures().get(
				6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPluginDescriptor_Configurations() {
		return (EReference) getPluginDescriptor().getEStructuralFeatures().get(
				7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSerializerPluginDescriptor() {
		if (serializerPluginDescriptorEClass == null) {
			serializerPluginDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(30);
		}
		return serializerPluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeserializerPluginDescriptor() {
		if (deserializerPluginDescriptorEClass == null) {
			deserializerPluginDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(31);
		}
		return deserializerPluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevisionSummaryType() {
		if (revisionSummaryTypeEClass == null) {
			revisionSummaryTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(32);
		}
		return revisionSummaryTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionSummaryType_Name() {
		return (EAttribute) getRevisionSummaryType().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionSummaryType_Count() {
		return (EAttribute) getRevisionSummaryType().getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevisionSummaryContainer() {
		if (revisionSummaryContainerEClass == null) {
			revisionSummaryContainerEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(33);
		}
		return revisionSummaryContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionSummaryContainer_Name() {
		return (EAttribute) getRevisionSummaryContainer()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevisionSummaryContainer_Types() {
		return (EReference) getRevisionSummaryContainer()
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevisionSummary() {
		if (revisionSummaryEClass == null) {
			revisionSummaryEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(34);
		}
		return revisionSummaryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevisionSummary_List() {
		return (EReference) getRevisionSummary().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongAction() {
		if (longActionEClass == null) {
			longActionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(35);
		}
		return longActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongAction_Identification() {
		return (EAttribute) getLongAction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLongAction_User() {
		return (EReference) getLongAction().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongAction_Start() {
		return (EAttribute) getLongAction().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongAction_Username() {
		return (EAttribute) getLongAction().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongAction_Name() {
		return (EAttribute) getLongAction().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectIDMPluginDescriptor() {
		if (objectIDMPluginDescriptorEClass == null) {
			objectIDMPluginDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(36);
		}
		return objectIDMPluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectIDMPluginDescriptor_ClassName() {
		return (EAttribute) getObjectIDMPluginDescriptor()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompareItem() {
		if (compareItemEClass == null) {
			compareItemEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(38);
		}
		return compareItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompareItem_DataObject() {
		return (EReference) getCompareItem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectAdded() {
		if (objectAddedEClass == null) {
			objectAddedEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(39);
		}
		return objectAddedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectRemoved() {
		if (objectRemovedEClass == null) {
			objectRemovedEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(40);
		}
		return objectRemovedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectModified() {
		if (objectModifiedEClass == null) {
			objectModifiedEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(41);
		}
		return objectModifiedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectModified_FieldName() {
		return (EAttribute) getObjectModified().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectModified_OldValue() {
		return (EAttribute) getObjectModified().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectModified_NewValue() {
		return (EAttribute) getObjectModified().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompareContainer() {
		if (compareContainerEClass == null) {
			compareContainerEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(42);
		}
		return compareContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompareContainer_Type() {
		return (EAttribute) getCompareContainer().getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompareContainer_Items() {
		return (EReference) getCompareContainer().getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompareResult() {
		if (compareResultEClass == null) {
			compareResultEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(43);
		}
		return compareResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompareResult_Items() {
		return (EReference) getCompareResult().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongActionState() {
		if (longActionStateEClass == null) {
			longActionStateEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(45);
		}
		return longActionStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongActionState_Start() {
		return (EAttribute) getLongActionState().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongActionState_End() {
		return (EAttribute) getLongActionState().getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongActionState_Progress() {
		return (EAttribute) getLongActionState().getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongActionState_State() {
		return (EAttribute) getLongActionState().getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongActionState_Title() {
		return (EAttribute) getLongActionState().getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongActionState_Stage() {
		return (EAttribute) getLongActionState().getEStructuralFeatures()
				.get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongActionState_Errors() {
		return (EAttribute) getLongActionState().getEStructuralFeatures()
				.get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongActionState_Warnings() {
		return (EAttribute) getLongActionState().getEStructuralFeatures()
				.get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongActionState_Infos() {
		return (EAttribute) getLongActionState().getEStructuralFeatures()
				.get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerInfo() {
		if (serverInfoEClass == null) {
			serverInfoEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(47);
		}
		return serverInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerInfo_ServerState() {
		return (EAttribute) getServerInfo().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerInfo_ErrorMessage() {
		return (EAttribute) getServerInfo().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersion() {
		if (versionEClass == null) {
			versionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(48);
		}
		return versionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Major() {
		return (EAttribute) getVersion().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Minor() {
		return (EAttribute) getVersion().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Revision() {
		return (EAttribute) getVersion().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Date() {
		return (EAttribute) getVersion().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_DownloadUrl() {
		return (EAttribute) getVersion().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_SupportUrl() {
		return (EAttribute) getVersion().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_SupportEmail() {
		return (EAttribute) getVersion().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRenderEnginePluginDescriptor() {
		if (renderEnginePluginDescriptorEClass == null) {
			renderEnginePluginDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(49);
		}
		return renderEnginePluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFile() {
		if (fileEClass == null) {
			fileEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(51);
		}
		return fileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFile_Data() {
		return (EAttribute) getFile().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFile_Filename() {
		return (EAttribute) getFile().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFile_Mime() {
		return (EAttribute) getFile().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedDataSchema() {
		if (extendedDataSchemaEClass == null) {
			extendedDataSchemaEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(52);
		}
		return extendedDataSchemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedDataSchema_Name() {
		return (EAttribute) getExtendedDataSchema().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedDataSchema_Url() {
		return (EAttribute) getExtendedDataSchema().getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedDataSchema_Namespace() {
		return (EAttribute) getExtendedDataSchema().getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedDataSchema_Description() {
		return (EAttribute) getExtendedDataSchema().getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedDataSchema_File() {
		return (EReference) getExtendedDataSchema().getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedDataSchema_Size() {
		return (EAttribute) getExtendedDataSchema().getEStructuralFeatures()
				.get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedDataSchema_Validate() {
		return (EAttribute) getExtendedDataSchema().getEStructuralFeatures()
				.get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedDataSchema_Type() {
		return (EAttribute) getExtendedDataSchema().getEStructuralFeatures()
				.get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedDataSchema_Users() {
		return (EReference) getExtendedDataSchema().getEStructuralFeatures()
				.get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedDataSchema_ExtendedData() {
		return (EReference) getExtendedDataSchema().getEStructuralFeatures()
				.get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedData() {
		if (extendedDataEClass == null) {
			extendedDataEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(53);
		}
		return extendedDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedData_Url() {
		return (EAttribute) getExtendedData().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedData_File() {
		return (EReference) getExtendedData().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedData_Size() {
		return (EAttribute) getExtendedData().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedData_Title() {
		return (EAttribute) getExtendedData().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedData_Added() {
		return (EAttribute) getExtendedData().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedData_User() {
		return (EReference) getExtendedData().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedData_Schema() {
		return (EReference) getExtendedData().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedData_Revision() {
		return (EReference) getExtendedData().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedData_Project() {
		return (EReference) getExtendedData().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueryEnginePluginDescriptor() {
		if (queryEnginePluginDescriptorEClass == null) {
			queryEnginePluginDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(54);
		}
		return queryEnginePluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueryEnginePluginConfiguration() {
		if (queryEnginePluginConfigurationEClass == null) {
			queryEnginePluginConfigurationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(55);
		}
		return queryEnginePluginConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryEnginePluginConfiguration_UserSettings() {
		return (EReference) getQueryEnginePluginConfiguration()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWebModulePluginDescriptor() {
		if (webModulePluginDescriptorEClass == null) {
			webModulePluginDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(56);
		}
		return webModulePluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWebModulePluginConfiguration() {
		if (webModulePluginConfigurationEClass == null) {
			webModulePluginConfigurationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(57);
		}
		return webModulePluginConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWebModulePluginConfiguration_ServerSettings() {
		return (EReference) getWebModulePluginConfiguration()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelMergerPluginDescriptor() {
		if (modelMergerPluginDescriptorEClass == null) {
			modelMergerPluginDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(58);
		}
		return modelMergerPluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelMergerPluginConfiguration() {
		if (modelMergerPluginConfigurationEClass == null) {
			modelMergerPluginConfigurationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(59);
		}
		return modelMergerPluginConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelMergerPluginConfiguration_UserSettings() {
		return (EReference) getModelMergerPluginConfiguration()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelComparePluginDescriptor() {
		if (modelComparePluginDescriptorEClass == null) {
			modelComparePluginDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(60);
		}
		return modelComparePluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelComparePluginConfiguration() {
		if (modelComparePluginConfigurationEClass == null) {
			modelComparePluginConfigurationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(61);
		}
		return modelComparePluginConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelComparePluginConfiguration_UserSettings() {
		return (EReference) getModelComparePluginConfiguration()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProfileDescriptor() {
		if (profileDescriptorEClass == null) {
			profileDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(63);
		}
		return profileDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfileDescriptor_Name() {
		return (EAttribute) getProfileDescriptor().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfileDescriptor_Description() {
		return (EAttribute) getProfileDescriptor().getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfileDescriptor_PublicProfile() {
		return (EAttribute) getProfileDescriptor().getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfileDescriptor_Identifier() {
		return (EAttribute) getProfileDescriptor().getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceDescriptor() {
		if (serviceDescriptorEClass == null) {
			serviceDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(64);
		}
		return serviceDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_Name() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_Url() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_Token() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_Identifier() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_NotificationProtocol() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_Description() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_Trigger() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_ReadRevision() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_ReadExtendedData() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_WriteRevision() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_WriteExtendedData() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_ProviderName() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_CompanyUrl() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_TokenUrl() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDescriptor_NewProfileUrl() {
		return (EAttribute) getServiceDescriptor().getEStructuralFeatures()
				.get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		if (serviceEClass == null) {
			serviceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(65);
		}
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Name() {
		return (EAttribute) getService().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ServiceName() {
		return (EAttribute) getService().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ServiceIdentifier() {
		return (EAttribute) getService().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ProviderName() {
		return (EAttribute) getService().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Url() {
		return (EAttribute) getService().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Token() {
		return (EAttribute) getService().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_NotificationProtocol() {
		return (EAttribute) getService().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Description() {
		return (EAttribute) getService().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Trigger() {
		return (EAttribute) getService().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ReadRevision() {
		return (EAttribute) getService().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_ReadExtendedData() {
		return (EReference) getService().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_WriteRevision() {
		return (EReference) getService().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_WriteExtendedData() {
		return (EReference) getService().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ProfileIdentifier() {
		return (EAttribute) getService().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ProfileName() {
		return (EAttribute) getService().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ProfileDescription() {
		return (EAttribute) getService().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ProfilePublic() {
		return (EAttribute) getService().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Project() {
		return (EReference) getService().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_User() {
		return (EReference) getService().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_InternalService() {
		return (EReference) getService().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_ModelCheckers() {
		return (EReference) getService().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToken() {
		if (tokenEClass == null) {
			tokenEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(66);
		}
		return tokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToken_TokenString() {
		return (EAttribute) getToken().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToken_Expires() {
		return (EAttribute) getToken().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServicePluginDescriptor() {
		if (servicePluginDescriptorEClass == null) {
			servicePluginDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(67);
		}
		return servicePluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalServicePluginConfiguration() {
		if (internalServicePluginConfigurationEClass == null) {
			internalServicePluginConfigurationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(68);
		}
		return internalServicePluginConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalServicePluginConfiguration_RemoteAccessible() {
		return (EAttribute) getInternalServicePluginConfiguration()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalServicePluginConfiguration_UserSettings() {
		return (EReference) getInternalServicePluginConfiguration()
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalServicePluginConfiguration_PublicProfile() {
		return (EAttribute) getInternalServicePluginConfiguration()
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceInterface() {
		if (serviceInterfaceEClass == null) {
			serviceInterfaceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(69);
		}
		return serviceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceInterface_Name() {
		return (EAttribute) getServiceInterface().getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceInterface_NameSpace() {
		return (EAttribute) getServiceInterface().getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceInterface_SimpleName() {
		return (EAttribute) getServiceInterface().getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceMethod() {
		if (serviceMethodEClass == null) {
			serviceMethodEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(70);
		}
		return serviceMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceMethod_Name() {
		return (EAttribute) getServiceMethod().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceMethod_Doc() {
		return (EAttribute) getServiceMethod().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceMethod_ReturnDoc() {
		return (EAttribute) getServiceMethod().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceField() {
		if (serviceFieldEClass == null) {
			serviceFieldEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(72);
		}
		return serviceFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceField_Name() {
		return (EAttribute) getServiceField().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceField_Type() {
		return (EReference) getServiceField().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceField_GenericType() {
		return (EReference) getServiceField().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceField_Doc() {
		return (EAttribute) getServiceField().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceType() {
		if (serviceTypeEClass == null) {
			serviceTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(73);
		}
		return serviceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceType_Name() {
		return (EAttribute) getServiceType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceType_SimpleName() {
		return (EAttribute) getServiceType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceType_Fields() {
		return (EReference) getServiceType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceType_SimpleType() {
		return (EAttribute) getServiceType().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceParameter() {
		if (serviceParameterEClass == null) {
			serviceParameterEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(74);
		}
		return serviceParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceParameter_Name() {
		return (EAttribute) getServiceParameter().getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceParameter_Doc() {
		return (EAttribute) getServiceParameter().getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceParameter_Type() {
		return (EReference) getServiceParameter().getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceParameter_GenericType() {
		return (EReference) getServiceParameter().getEStructuralFeatures().get(
				3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeDefinition() {
		if (typeDefinitionEClass == null) {
			typeDefinitionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(76);
		}
		return typeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectDefinition() {
		if (objectDefinitionEClass == null) {
			objectDefinitionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(77);
		}
		return objectDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectDefinition_Parameters() {
		return (EReference) getObjectDefinition().getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveDefinition() {
		if (primitiveDefinitionEClass == null) {
			primitiveDefinitionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(78);
		}
		return primitiveDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveDefinition_Type() {
		return (EAttribute) getPrimitiveDefinition().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayDefinition() {
		if (arrayDefinitionEClass == null) {
			arrayDefinitionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(79);
		}
		return arrayDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayDefinition_Type() {
		return (EReference) getArrayDefinition().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterDefinition() {
		if (parameterDefinitionEClass == null) {
			parameterDefinitionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(80);
		}
		return parameterDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDefinition_Name() {
		return (EAttribute) getParameterDefinition().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDefinition_Required() {
		return (EAttribute) getParameterDefinition().getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDefinition_Description() {
		return (EAttribute) getParameterDefinition().getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDefinition_Type() {
		return (EReference) getParameterDefinition().getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDefinition_DefaultValue() {
		return (EReference) getParameterDefinition().getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		if (typeEClass == null) {
			typeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(81);
		}
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectType() {
		if (objectTypeEClass == null) {
			objectTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(82);
		}
		return objectTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectType_Name() {
		return (EAttribute) getObjectType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectType_Parameters() {
		return (EReference) getObjectType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType() {
		if (primitiveTypeEClass == null) {
			primitiveTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(83);
		}
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongType() {
		if (longTypeEClass == null) {
			longTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(84);
		}
		return longTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongType_Value() {
		return (EAttribute) getLongType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getByteArrayType() {
		if (byteArrayTypeEClass == null) {
			byteArrayTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(85);
		}
		return byteArrayTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getByteArrayType_Value() {
		return (EAttribute) getByteArrayType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleType() {
		if (doubleTypeEClass == null) {
			doubleTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(86);
		}
		return doubleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleType_Value() {
		return (EAttribute) getDoubleType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringType() {
		if (stringTypeEClass == null) {
			stringTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(87);
		}
		return stringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringType_Value() {
		return (EAttribute) getStringType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanType() {
		if (booleanTypeEClass == null) {
			booleanTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(88);
		}
		return booleanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanType_Value() {
		return (EAttribute) getBooleanType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayType() {
		if (arrayTypeEClass == null) {
			arrayTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(89);
		}
		return arrayTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayType_Values() {
		return (EReference) getArrayType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		if (parameterEClass == null) {
			parameterEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(90);
		}
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Name() {
		return (EAttribute) getParameter().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_Value() {
		return (EReference) getParameter().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImmediateNotificationResult() {
		if (immediateNotificationResultEClass == null) {
			immediateNotificationResultEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(92);
		}
		return immediateNotificationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImmediateNotificationResult_Result() {
		return (EAttribute) getImmediateNotificationResult()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImmediateNotificationResult_Description() {
		return (EAttribute) getImmediateNotificationResult()
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoteServiceUpdate() {
		if (remoteServiceUpdateEClass == null) {
			remoteServiceUpdateEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(93);
		}
		return remoteServiceUpdateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPercentageChange() {
		if (percentageChangeEClass == null) {
			percentageChangeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(94);
		}
		return percentageChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPercentageChange_Percentage() {
		return (EAttribute) getPercentageChange().getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemInfo() {
		if (systemInfoEClass == null) {
			systemInfoEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(95);
		}
		return systemInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemInfo_Cpucores() {
		return (EAttribute) getSystemInfo().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemInfo_Datetime() {
		return (EAttribute) getSystemInfo().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemInfo_Osname() {
		return (EAttribute) getSystemInfo().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemInfo_Osversion() {
		return (EAttribute) getSystemInfo().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemInfo_UserName() {
		return (EAttribute) getSystemInfo().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemInfo_UserHome() {
		return (EAttribute) getSystemInfo().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemInfo_UserDir() {
		return (EAttribute) getSystemInfo().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaInfo() {
		if (javaInfoEClass == null) {
			javaInfoEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(96);
		}
		return javaInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_HeapTotal() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_HeapUsed() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_HeapFree() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_HeapMax() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_Threads() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaHome() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaVersion() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaVendor() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaVendorurl() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavavmVersion() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavavmVendor() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavavmName() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaspecVersion() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaspecVendor() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaspecName() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaClassVersion() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaClasspath() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaLibrarypath() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaIoTmp() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaExtdir() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaFileSeparator() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaPathSeparator() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_JavaLineSeparator() {
		return (EAttribute) getJavaInfo().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBimServerInfo() {
		if (bimServerInfoEClass == null) {
			bimServerInfoEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(97);
		}
		return bimServerInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBimServerInfo_CurrentVersion() {
		return (EAttribute) getBimServerInfo().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBimServerInfo_CurrentDate() {
		return (EAttribute) getBimServerInfo().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBimServerInfo_SchemaVersion() {
		return (EAttribute) getBimServerInfo().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBimServerInfo_LatestDate() {
		return (EAttribute) getBimServerInfo().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBimServerInfo_LatestVersion() {
		return (EAttribute) getBimServerInfo().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBimServerInfo_Projects() {
		return (EAttribute) getBimServerInfo().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBimServerInfo_Revisions() {
		return (EAttribute) getBimServerInfo().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBimServerInfo_Users() {
		return (EAttribute) getBimServerInfo().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBimServerInfo_Checkouts() {
		return (EAttribute) getBimServerInfo().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBimServerInfo_ServerLogUrl() {
		return (EAttribute) getBimServerInfo().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBimServerInfo_Started() {
		return (EAttribute) getBimServerInfo().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectSmall() {
		if (projectSmallEClass == null) {
			projectSmallEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(99);
		}
		return projectSmallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSmall_Name() {
		return (EAttribute) getProjectSmall().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSmall_ParentId() {
		return (EAttribute) getProjectSmall().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSmall_State() {
		return (EAttribute) getProjectSmall().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSmall_NrRevisions() {
		return (EAttribute) getProjectSmall().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSmall_NrSubProjects() {
		return (EAttribute) getProjectSmall().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSmall_HasCheckinRights() {
		return (EAttribute) getProjectSmall().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSmall_LastRevisionId() {
		return (EAttribute) getProjectSmall().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcHeader() {
		if (ifcHeaderEClass == null) {
			ifcHeaderEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(100);
		}
		return ifcHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeader_Description() {
		return (EAttribute) getIfcHeader().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeader_ImplementationLevel() {
		return (EAttribute) getIfcHeader().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeader_Filename() {
		return (EAttribute) getIfcHeader().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeader_TimeStamp() {
		return (EAttribute) getIfcHeader().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeader_Author() {
		return (EAttribute) getIfcHeader().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeader_Organization() {
		return (EAttribute) getIfcHeader().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeader_PreProcessorVersion() {
		return (EAttribute) getIfcHeader().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeader_OriginatingSystem() {
		return (EAttribute) getIfcHeader().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeader_IfcSchemaVersion() {
		return (EAttribute) getIfcHeader().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeader_Authorization() {
		return (EAttribute) getIfcHeader().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelCheckerResultItem() {
		if (modelCheckerResultItemEClass == null) {
			modelCheckerResultItemEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(101);
		}
		return modelCheckerResultItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelCheckerResultHeader() {
		if (modelCheckerResultHeaderEClass == null) {
			modelCheckerResultHeaderEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(102);
		}
		return modelCheckerResultHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerResultHeader_Text() {
		return (EAttribute) getModelCheckerResultHeader()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelCheckerResultLine() {
		if (modelCheckerResultLineEClass == null) {
			modelCheckerResultLineEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(104);
		}
		return modelCheckerResultLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerResultLine_FieldOrClass() {
		return (EAttribute) getModelCheckerResultLine()
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerResultLine_Value() {
		return (EAttribute) getModelCheckerResultLine()
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerResultLine_ShouldBe() {
		return (EAttribute) getModelCheckerResultLine()
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerResultLine_Type() {
		return (EAttribute) getModelCheckerResultLine()
				.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerResultLine_ObjectId() {
		return (EAttribute) getModelCheckerResultLine()
				.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelCheckerResult() {
		if (modelCheckerResultEClass == null) {
			modelCheckerResultEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(105);
		}
		return modelCheckerResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerResult_Valid() {
		return (EAttribute) getModelCheckerResult().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelCheckerResult_Items() {
		return (EReference) getModelCheckerResult().getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelCheckerInstance() {
		if (modelCheckerInstanceEClass == null) {
			modelCheckerInstanceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(106);
		}
		return modelCheckerInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerInstance_Name() {
		return (EAttribute) getModelCheckerInstance().getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerInstance_Description() {
		return (EAttribute) getModelCheckerInstance().getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerInstance_Code() {
		return (EAttribute) getModelCheckerInstance().getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerInstance_Compiled() {
		return (EAttribute) getModelCheckerInstance().getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerInstance_Valid() {
		return (EAttribute) getModelCheckerInstance().getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelCheckerInstance_ModelCheckerPluginClassName() {
		return (EAttribute) getModelCheckerInstance().getEStructuralFeatures()
				.get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelCheckerPluginDescriptor() {
		if (modelCheckerPluginDescriptorEClass == null) {
			modelCheckerPluginDescriptorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(107);
		}
		return modelCheckerPluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUserType() {
		if (userTypeEEnum == null) {
			userTypeEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(0);
		}
		return userTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSIPrefix() {
		if (siPrefixEEnum == null) {
			siPrefixEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(1);
		}
		return siPrefixEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getObjectState() {
		if (objectStateEEnum == null) {
			objectStateEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(2);
		}
		return objectStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompareType() {
		if (compareTypeEEnum == null) {
			compareTypeEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(37);
		}
		return compareTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActionState() {
		if (actionStateEEnum == null) {
			actionStateEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(44);
		}
		return actionStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getServerState() {
		if (serverStateEEnum == null) {
			serverStateEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(46);
		}
		return serverStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExtendedDataSchemaType() {
		if (extendedDataSchemaTypeEEnum == null) {
			extendedDataSchemaTypeEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(50);
		}
		return extendedDataSchemaTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTrigger() {
		if (triggerEEnum == null) {
			triggerEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(62);
		}
		return triggerEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getServiceSimpleType() {
		if (serviceSimpleTypeEEnum == null) {
			serviceSimpleTypeEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(71);
		}
		return serviceSimpleTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPrimitiveEnum() {
		if (primitiveEnumEEnum == null) {
			primitiveEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(75);
		}
		return primitiveEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNotifictionResultEnum() {
		if (notifictionResultEnumEEnum == null) {
			notifictionResultEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(91);
		}
		return notifictionResultEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProgressTopicType() {
		if (progressTopicTypeEEnum == null) {
			progressTopicTypeEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(98);
		}
		return progressTopicTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getModelCheckerResultType() {
		if (modelCheckerResultTypeEEnum == null) {
			modelCheckerResultTypeEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(103);
		}
		return modelCheckerResultTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSmtpProtocol() {
		if (smtpProtocolEEnum == null) {
			smtpProtocolEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(108);
		}
		return smtpProtocolEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDataHandler() {
		if (dataHandlerEDataType == null) {
			dataHandlerEDataType = (EDataType) EPackage.Registry.INSTANCE
					.getEPackage(StorePackage.eNS_URI).getEClassifiers()
					.get(16);
		}
		return dataHandlerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreFactory getStoreFactory() {
		return (StoreFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded)
			return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: "
					+ packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		} catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage) resource.getContents()
				.get(0));
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed)
			return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("org.bimserver.models.store."
					+ eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //StorePackageImpl
