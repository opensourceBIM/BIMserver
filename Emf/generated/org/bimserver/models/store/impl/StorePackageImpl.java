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

import org.bimserver.models.ifc2x3.Ifc2x3Package;

import org.bimserver.models.ifc2x3.impl.Ifc2x3PackageImpl;

import org.bimserver.models.log.LogPackage;

import org.bimserver.models.log.impl.LogPackageImpl;

import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.CheckinResult;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.CheckoutResult;
import org.bimserver.models.store.Clash;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.CompareContainer;
import org.bimserver.models.store.CompareIdentifier;
import org.bimserver.models.store.CompareItem;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.CompareType;
import org.bimserver.models.store.CompileResult;
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
import org.bimserver.models.store.MergeIdentifier;
import org.bimserver.models.store.Migration;
import org.bimserver.models.store.NewProjectNotification;
import org.bimserver.models.store.NewRevisionNotification;
import org.bimserver.models.store.Notification;
import org.bimserver.models.store.ObjectAdded;
import org.bimserver.models.store.ObjectModified;
import org.bimserver.models.store.ObjectRemoved;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.Plugin;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.ReferenceDataValue;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.RevisionSummaryContainer;
import org.bimserver.models.store.RevisionSummaryType;
import org.bimserver.models.store.RunResult;
import org.bimserver.models.store.SIPrefix;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.SerializerPluginDescriptor;
import org.bimserver.models.store.ServerInfo;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.SimpleDataValue;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSession;
import org.bimserver.models.store.UserType;

import org.bimserver.models.store.Version;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

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
	private EClass clashEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eidClashEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guidClashEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clashDetectionSettingsEClass = null;

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
	private EClass settingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guidanceProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEngineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pluginEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deserializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkinResultEClass = null;

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
	private EClass serializerPluginDescriptorEClass = null;

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
	private EClass pluginDescriptorEClass = null;

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
	private EClass guidanceProviderPluginDescriptorEClass = null;

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
	private EClass notificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newProjectNotificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newRevisionNotificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compileResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runResultEClass = null;

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
	private EEnum userTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum checkinStateEEnum = null;

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
	private EEnum mergeIdentifierEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum compareIdentifierEEnum = null;

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
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StorePackage init() {
		if (isInited)
			return (StorePackage) EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI);

		// Obtain or create and register package
		StorePackageImpl theStorePackage = (StorePackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
				: new StorePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		LogPackageImpl theLogPackage = (LogPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(LogPackage.eNS_URI) instanceof LogPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(LogPackage.eNS_URI) : LogPackage.eINSTANCE);
		Ifc2x3PackageImpl theIfc2x3Package = (Ifc2x3PackageImpl) (EPackage.Registry.INSTANCE.getEPackage(Ifc2x3Package.eNS_URI) instanceof Ifc2x3PackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(Ifc2x3Package.eNS_URI) : Ifc2x3Package.eINSTANCE);

		// Load packages
		theIfc2x3Package.loadPackage();

		// Create package meta-data objects
		theStorePackage.createPackageContents();
		theLogPackage.createPackageContents();

		// Initialize created meta-data
		theStorePackage.initializePackageContents();
		theLogPackage.initializePackageContents();

		// Fix loaded packages
		theIfc2x3Package.fixPackageContents();

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
		return projectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Id() {
		return (EAttribute) projectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Name() {
		return (EAttribute) projectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_HasAuthorizedUsers() {
		return (EReference) projectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_ConcreteRevisions() {
		return (EReference) projectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Revisions() {
		return (EReference) projectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_LastConcreteRevision() {
		return (EReference) projectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_LastRevision() {
		return (EReference) projectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Checkouts() {
		return (EReference) projectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_State() {
		return (EAttribute) projectEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_CreatedDate() {
		return (EAttribute) projectEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_CreatedBy() {
		return (EReference) projectEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_GeoTag() {
		return (EReference) projectEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_SubProjects() {
		return (EReference) projectEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Parent() {
		return (EReference) projectEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Description() {
		return (EAttribute) projectEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_ClashDetectionSettings() {
		return (EReference) projectEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_ExportLengthMeasurePrefix() {
		return (EAttribute) projectEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Name() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Password() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_HasRightsOn() {
		return (EReference) userEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_Revisions() {
		return (EReference) userEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_State() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_CreatedOn() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_CreatedBy() {
		return (EReference) userEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_UserType() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Username() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_LastSeen() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_ValidationToken() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_ValidationTokenCreated() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_NotificationUrl() {
		return (EAttribute) userEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClash() {
		return clashEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClash_Name1() {
		return (EAttribute) clashEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClash_Name2() {
		return (EAttribute) clashEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClash_Type1() {
		return (EAttribute) clashEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClash_Type2() {
		return (EAttribute) clashEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClash_Revision1() {
		return (EReference) clashEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClash_Revision2() {
		return (EReference) clashEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEidClash() {
		return eidClashEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEidClash_Eid1() {
		return (EAttribute) eidClashEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEidClash_Eid2() {
		return (EAttribute) eidClashEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuidClash() {
		return guidClashEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGuidClash_Guid1() {
		return (EAttribute) guidClashEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGuidClash_Guid2() {
		return (EAttribute) guidClashEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClashDetectionSettings() {
		return clashDetectionSettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClashDetectionSettings_Enabled() {
		return (EAttribute) clashDetectionSettingsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClashDetectionSettings_Projects() {
		return (EReference) clashDetectionSettingsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClashDetectionSettings_Margin() {
		return (EAttribute) clashDetectionSettingsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClashDetectionSettings_Revisions() {
		return (EReference) clashDetectionSettingsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClashDetectionSettings_IgnoredClasses() {
		return (EAttribute) clashDetectionSettingsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevision() {
		return revisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Id() {
		return (EAttribute) revisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_User() {
		return (EReference) revisionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Date() {
		return (EAttribute) revisionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Comment() {
		return (EAttribute) revisionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Size() {
		return (EAttribute) revisionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_ConcreteRevisions() {
		return (EReference) revisionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_LastConcreteRevision() {
		return (EReference) revisionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_Checkouts() {
		return (EReference) revisionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_Project() {
		return (EReference) revisionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_State() {
		return (EAttribute) revisionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_LastClashes() {
		return (EReference) revisionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Tag() {
		return (EAttribute) revisionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_LastError() {
		return (EAttribute) revisionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Bmi() {
		return (EAttribute) revisionEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_NrClashes() {
		return (EAttribute) revisionEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Laid() {
		return (EAttribute) revisionEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteRevision() {
		return concreteRevisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Id() {
		return (EAttribute) concreteRevisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteRevision_Project() {
		return (EReference) concreteRevisionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_State() {
		return (EAttribute) concreteRevisionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Checksum() {
		return (EAttribute) concreteRevisionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteRevision_Revisions() {
		return (EReference) concreteRevisionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Size() {
		return (EAttribute) concreteRevisionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Date() {
		return (EAttribute) concreteRevisionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_LastError() {
		return (EAttribute) concreteRevisionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeoTag() {
		return geoTagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_Enabled() {
		return (EAttribute) geoTagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeoTag_Projects() {
		return (EReference) geoTagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_X() {
		return (EAttribute) geoTagEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_Y() {
		return (EAttribute) geoTagEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_Z() {
		return (EAttribute) geoTagEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_Epsg() {
		return (EAttribute) geoTagEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_DirectionAngle() {
		return (EAttribute) geoTagEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckout() {
		return checkoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_User() {
		return (EReference) checkoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_Revision() {
		return (EReference) checkoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_Project() {
		return (EReference) checkoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckout_Date() {
		return (EAttribute) checkoutEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_Checkin() {
		return (EReference) checkoutEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckout_Active() {
		return (EAttribute) checkoutEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSettings() {
		return settingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_ShowVersionUpgradeAvailable() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_SendConfirmationEmailAfterRegistration() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_UseCaching() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_AllowSelfRegistration() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_AutoTestClashes() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_IntelligentMerging() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_AllowUsersToCreateTopLevelProjects() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_CheckinMergingEnabled() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_RegistrationAddition() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_SmtpServer() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_EmailSenderAddress() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_EnabledExportTypes() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_CustomLogoAddress() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_SiteAddress() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSettings_Serializers() {
		return (EReference) settingsEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSettings_GuidanceProviders() {
		return (EReference) settingsEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_HeaderAddition() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_FooterAddition() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_MergeIdentifier() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_CacheOutputFiles() {
		return (EAttribute) settingsEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSettings_IfcEngines() {
		return (EReference) settingsEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSettings_Plugins() {
		return (EReference) settingsEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSettings_Deserializers() {
		return (EReference) settingsEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSerializer() {
		return serializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializer_Name() {
		return (EAttribute) serializerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializer_Description() {
		return (EAttribute) serializerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializer_Extension() {
		return (EAttribute) serializerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializer_ContentType() {
		return (EAttribute) serializerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializer_ClassName() {
		return (EAttribute) serializerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializer_Enabled() {
		return (EAttribute) serializerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializer_DefaultSerializer() {
		return (EAttribute) serializerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSerializer_GuidanceProvider() {
		return (EReference) serializerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSerializer_Settings() {
		return (EReference) serializerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuidanceProvider() {
		return guidanceProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGuidanceProvider_Name() {
		return (EAttribute) guidanceProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGuidanceProvider_ClassName() {
		return (EAttribute) guidanceProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGuidanceProvider_Serializers() {
		return (EReference) guidanceProviderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGuidanceProvider_Settings() {
		return (EReference) guidanceProviderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEngine() {
		return ifcEngineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEngine_Name() {
		return (EAttribute) ifcEngineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEngine_Active() {
		return (EAttribute) ifcEngineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcEngine_Settings() {
		return (EReference) ifcEngineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlugin() {
		return pluginEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlugin_Name() {
		return (EAttribute) pluginEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlugin_Enabled() {
		return (EAttribute) pluginEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlugin_Settings() {
		return (EReference) pluginEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeserializer() {
		return deserializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeserializer_Name() {
		return (EAttribute) deserializerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeserializer_Description() {
		return (EAttribute) deserializerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeserializer_ClassName() {
		return (EAttribute) deserializerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeserializer_Enabled() {
		return (EAttribute) deserializerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeserializer_DefaultDeserializer() {
		return (EAttribute) deserializerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeserializer_Settings() {
		return (EReference) deserializerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckinResult() {
		return checkinResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckinResult_Revision() {
		return (EReference) checkinResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckinResult_Rid() {
		return (EAttribute) checkinResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckinResult_Project() {
		return (EReference) checkinResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDownloadResult() {
		return downloadResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDownloadResult_ProjectName() {
		return (EAttribute) downloadResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDownloadResult_RevisionNr() {
		return (EAttribute) downloadResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDownloadResult_File() {
		return (EAttribute) downloadResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckoutResult() {
		return checkoutResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataValue() {
		return dataValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataValue_FieldName() {
		return (EAttribute) dataValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataObject() {
		return dataObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataObject_Type() {
		return (EAttribute) dataObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataObject_Guid() {
		return (EAttribute) dataObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataObject_Name() {
		return (EAttribute) dataObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataObject_Values() {
		return (EReference) dataObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserSession() {
		return userSessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserSession_User() {
		return (EReference) userSessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_Username() {
		return (EAttribute) userSessionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_Name() {
		return (EAttribute) userSessionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_Type() {
		return (EAttribute) userSessionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_ActiveSince() {
		return (EAttribute) userSessionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_LastActive() {
		return (EAttribute) userSessionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserSession_AccessMethod() {
		return (EAttribute) userSessionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMigration() {
		return migrationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMigration_Number() {
		return (EAttribute) migrationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMigration_Description() {
		return (EAttribute) migrationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMigration_Executed() {
		return (EAttribute) migrationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceDataValue() {
		return referenceDataValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceDataValue_TypeName() {
		return (EAttribute) referenceDataValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceDataValue_Guid() {
		return (EAttribute) referenceDataValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListDataValue() {
		return listDataValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListDataValue_Values() {
		return (EReference) listDataValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleDataValue() {
		return simpleDataValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleDataValue_StringValue() {
		return (EAttribute) simpleDataValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseInformationItem() {
		return databaseInformationItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformationItem_Key() {
		return (EAttribute) databaseInformationItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformationItem_Value() {
		return (EAttribute) databaseInformationItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseInformationCategory() {
		return databaseInformationCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformationCategory_Title() {
		return (EAttribute) databaseInformationCategoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDatabaseInformationCategory_Items() {
		return (EReference) databaseInformationCategoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseInformation() {
		return databaseInformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_NumberOfProjects() {
		return (EAttribute) databaseInformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_NumberOfUsers() {
		return (EAttribute) databaseInformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_NumberOfRevisions() {
		return (EAttribute) databaseInformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_NumberOfCheckouts() {
		return (EAttribute) databaseInformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_DatabaseSizeInBytes() {
		return (EAttribute) databaseInformationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_Type() {
		return (EAttribute) databaseInformationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_Created() {
		return (EAttribute) databaseInformationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_Location() {
		return (EAttribute) databaseInformationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseInformation_SchemaVersion() {
		return (EAttribute) databaseInformationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDatabaseInformation_Categories() {
		return (EReference) databaseInformationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSerializerPluginDescriptor() {
		return serializerPluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializerPluginDescriptor_PluginClassName() {
		return (EAttribute) serializerPluginDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializerPluginDescriptor_DefaultName() {
		return (EAttribute) serializerPluginDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializerPluginDescriptor_DefaultExtension() {
		return (EAttribute) serializerPluginDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializerPluginDescriptor_DefaultContentType() {
		return (EAttribute) serializerPluginDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevisionSummaryType() {
		return revisionSummaryTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionSummaryType_Name() {
		return (EAttribute) revisionSummaryTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionSummaryType_Count() {
		return (EAttribute) revisionSummaryTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevisionSummaryContainer() {
		return revisionSummaryContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevisionSummaryContainer_Name() {
		return (EAttribute) revisionSummaryContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevisionSummaryContainer_Types() {
		return (EReference) revisionSummaryContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevisionSummary() {
		return revisionSummaryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevisionSummary_List() {
		return (EReference) revisionSummaryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPluginDescriptor() {
		return pluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginDescriptor_Name() {
		return (EAttribute) pluginDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginDescriptor_Description() {
		return (EAttribute) pluginDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginDescriptor_Location() {
		return (EAttribute) pluginDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginDescriptor_Enabled() {
		return (EAttribute) pluginDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongAction() {
		return longActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongAction_Identification() {
		return (EAttribute) longActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLongAction_User() {
		return (EReference) longActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongAction_Start() {
		return (EAttribute) longActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongAction_Username() {
		return (EAttribute) longActionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongAction_Name() {
		return (EAttribute) longActionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuidanceProviderPluginDescriptor() {
		return guidanceProviderPluginDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGuidanceProviderPluginDescriptor_ClassName() {
		return (EAttribute) guidanceProviderPluginDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompareItem() {
		return compareItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompareItem_DataObject() {
		return (EReference) compareItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectAdded() {
		return objectAddedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectRemoved() {
		return objectRemovedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectModified() {
		return objectModifiedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectModified_FieldName() {
		return (EAttribute) objectModifiedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectModified_OldValue() {
		return (EAttribute) objectModifiedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectModified_NewValue() {
		return (EAttribute) objectModifiedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompareContainer() {
		return compareContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompareContainer_Type() {
		return (EAttribute) compareContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompareContainer_Items() {
		return (EReference) compareContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompareResult() {
		return compareResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompareResult_Items() {
		return (EReference) compareResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongActionState() {
		return longActionStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongActionState_Progress() {
		return (EAttribute) longActionStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongActionState_State() {
		return (EAttribute) longActionStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotification() {
		return notificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewProjectNotification() {
		return newProjectNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewProjectNotification_Project() {
		return (EReference) newProjectNotificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewRevisionNotification() {
		return newRevisionNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewRevisionNotification_Revision() {
		return (EReference) newRevisionNotificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompileResult() {
		return compileResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompileResult_CompileOke() {
		return (EAttribute) compileResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompileResult_Warnings() {
		return (EAttribute) compileResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompileResult_Errors() {
		return (EAttribute) compileResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRunResult() {
		return runResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRunResult_RunOke() {
		return (EAttribute) runResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRunResult_Warnings() {
		return (EAttribute) runResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRunResult_Errors() {
		return (EAttribute) runResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRunResult_Output() {
		return (EAttribute) runResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerInfo() {
		return serverInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerInfo_ServerState() {
		return (EAttribute) serverInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerInfo_ErrorMessage() {
		return (EAttribute) serverInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersion() {
		return versionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Major() {
		return (EAttribute) versionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Minor() {
		return (EAttribute) versionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Revision() {
		return (EAttribute) versionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_Date() {
		return (EAttribute) versionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_DownloadUrl() {
		return (EAttribute) versionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_SupportUrl() {
		return (EAttribute) versionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersion_SupportEmail() {
		return (EAttribute) versionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUserType() {
		return userTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCheckinState() {
		return checkinStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSIPrefix() {
		return siPrefixEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getObjectState() {
		return objectStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMergeIdentifier() {
		return mergeIdentifierEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompareIdentifier() {
		return compareIdentifierEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompareType() {
		return compareTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActionState() {
		return actionStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getServerState() {
		return serverStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDataHandler() {
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
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		projectEClass = createEClass(PROJECT);
		createEAttribute(projectEClass, PROJECT__ID);
		createEAttribute(projectEClass, PROJECT__NAME);
		createEReference(projectEClass, PROJECT__HAS_AUTHORIZED_USERS);
		createEReference(projectEClass, PROJECT__CONCRETE_REVISIONS);
		createEReference(projectEClass, PROJECT__REVISIONS);
		createEReference(projectEClass, PROJECT__LAST_CONCRETE_REVISION);
		createEReference(projectEClass, PROJECT__LAST_REVISION);
		createEReference(projectEClass, PROJECT__CHECKOUTS);
		createEAttribute(projectEClass, PROJECT__STATE);
		createEAttribute(projectEClass, PROJECT__CREATED_DATE);
		createEReference(projectEClass, PROJECT__CREATED_BY);
		createEReference(projectEClass, PROJECT__GEO_TAG);
		createEReference(projectEClass, PROJECT__SUB_PROJECTS);
		createEReference(projectEClass, PROJECT__PARENT);
		createEAttribute(projectEClass, PROJECT__DESCRIPTION);
		createEReference(projectEClass, PROJECT__CLASH_DETECTION_SETTINGS);
		createEAttribute(projectEClass, PROJECT__EXPORT_LENGTH_MEASURE_PREFIX);

		userEClass = createEClass(USER);
		createEAttribute(userEClass, USER__NAME);
		createEAttribute(userEClass, USER__PASSWORD);
		createEReference(userEClass, USER__HAS_RIGHTS_ON);
		createEReference(userEClass, USER__REVISIONS);
		createEAttribute(userEClass, USER__STATE);
		createEAttribute(userEClass, USER__CREATED_ON);
		createEReference(userEClass, USER__CREATED_BY);
		createEAttribute(userEClass, USER__USER_TYPE);
		createEAttribute(userEClass, USER__USERNAME);
		createEAttribute(userEClass, USER__LAST_SEEN);
		createEAttribute(userEClass, USER__VALIDATION_TOKEN);
		createEAttribute(userEClass, USER__VALIDATION_TOKEN_CREATED);
		createEAttribute(userEClass, USER__NOTIFICATION_URL);

		clashEClass = createEClass(CLASH);
		createEAttribute(clashEClass, CLASH__NAME1);
		createEAttribute(clashEClass, CLASH__NAME2);
		createEAttribute(clashEClass, CLASH__TYPE1);
		createEAttribute(clashEClass, CLASH__TYPE2);
		createEReference(clashEClass, CLASH__REVISION1);
		createEReference(clashEClass, CLASH__REVISION2);

		eidClashEClass = createEClass(EID_CLASH);
		createEAttribute(eidClashEClass, EID_CLASH__EID1);
		createEAttribute(eidClashEClass, EID_CLASH__EID2);

		guidClashEClass = createEClass(GUID_CLASH);
		createEAttribute(guidClashEClass, GUID_CLASH__GUID1);
		createEAttribute(guidClashEClass, GUID_CLASH__GUID2);

		clashDetectionSettingsEClass = createEClass(CLASH_DETECTION_SETTINGS);
		createEAttribute(clashDetectionSettingsEClass, CLASH_DETECTION_SETTINGS__ENABLED);
		createEReference(clashDetectionSettingsEClass, CLASH_DETECTION_SETTINGS__PROJECTS);
		createEAttribute(clashDetectionSettingsEClass, CLASH_DETECTION_SETTINGS__MARGIN);
		createEReference(clashDetectionSettingsEClass, CLASH_DETECTION_SETTINGS__REVISIONS);
		createEAttribute(clashDetectionSettingsEClass, CLASH_DETECTION_SETTINGS__IGNORED_CLASSES);

		revisionEClass = createEClass(REVISION);
		createEAttribute(revisionEClass, REVISION__ID);
		createEReference(revisionEClass, REVISION__USER);
		createEAttribute(revisionEClass, REVISION__DATE);
		createEAttribute(revisionEClass, REVISION__COMMENT);
		createEAttribute(revisionEClass, REVISION__SIZE);
		createEReference(revisionEClass, REVISION__CONCRETE_REVISIONS);
		createEReference(revisionEClass, REVISION__LAST_CONCRETE_REVISION);
		createEReference(revisionEClass, REVISION__CHECKOUTS);
		createEReference(revisionEClass, REVISION__PROJECT);
		createEAttribute(revisionEClass, REVISION__STATE);
		createEReference(revisionEClass, REVISION__LAST_CLASHES);
		createEAttribute(revisionEClass, REVISION__TAG);
		createEAttribute(revisionEClass, REVISION__LAST_ERROR);
		createEAttribute(revisionEClass, REVISION__BMI);
		createEAttribute(revisionEClass, REVISION__NR_CLASHES);
		createEAttribute(revisionEClass, REVISION__LAID);

		concreteRevisionEClass = createEClass(CONCRETE_REVISION);
		createEAttribute(concreteRevisionEClass, CONCRETE_REVISION__ID);
		createEReference(concreteRevisionEClass, CONCRETE_REVISION__PROJECT);
		createEAttribute(concreteRevisionEClass, CONCRETE_REVISION__STATE);
		createEAttribute(concreteRevisionEClass, CONCRETE_REVISION__CHECKSUM);
		createEReference(concreteRevisionEClass, CONCRETE_REVISION__REVISIONS);
		createEAttribute(concreteRevisionEClass, CONCRETE_REVISION__SIZE);
		createEAttribute(concreteRevisionEClass, CONCRETE_REVISION__DATE);
		createEAttribute(concreteRevisionEClass, CONCRETE_REVISION__LAST_ERROR);

		geoTagEClass = createEClass(GEO_TAG);
		createEAttribute(geoTagEClass, GEO_TAG__ENABLED);
		createEReference(geoTagEClass, GEO_TAG__PROJECTS);
		createEAttribute(geoTagEClass, GEO_TAG__X);
		createEAttribute(geoTagEClass, GEO_TAG__Y);
		createEAttribute(geoTagEClass, GEO_TAG__Z);
		createEAttribute(geoTagEClass, GEO_TAG__EPSG);
		createEAttribute(geoTagEClass, GEO_TAG__DIRECTION_ANGLE);

		checkoutEClass = createEClass(CHECKOUT);
		createEReference(checkoutEClass, CHECKOUT__USER);
		createEReference(checkoutEClass, CHECKOUT__REVISION);
		createEReference(checkoutEClass, CHECKOUT__PROJECT);
		createEAttribute(checkoutEClass, CHECKOUT__DATE);
		createEReference(checkoutEClass, CHECKOUT__CHECKIN);
		createEAttribute(checkoutEClass, CHECKOUT__ACTIVE);

		settingsEClass = createEClass(SETTINGS);
		createEAttribute(settingsEClass, SETTINGS__SHOW_VERSION_UPGRADE_AVAILABLE);
		createEAttribute(settingsEClass, SETTINGS__SEND_CONFIRMATION_EMAIL_AFTER_REGISTRATION);
		createEAttribute(settingsEClass, SETTINGS__USE_CACHING);
		createEAttribute(settingsEClass, SETTINGS__ALLOW_SELF_REGISTRATION);
		createEAttribute(settingsEClass, SETTINGS__AUTO_TEST_CLASHES);
		createEAttribute(settingsEClass, SETTINGS__INTELLIGENT_MERGING);
		createEAttribute(settingsEClass, SETTINGS__ALLOW_USERS_TO_CREATE_TOP_LEVEL_PROJECTS);
		createEAttribute(settingsEClass, SETTINGS__CHECKIN_MERGING_ENABLED);
		createEAttribute(settingsEClass, SETTINGS__REGISTRATION_ADDITION);
		createEAttribute(settingsEClass, SETTINGS__SMTP_SERVER);
		createEAttribute(settingsEClass, SETTINGS__EMAIL_SENDER_ADDRESS);
		createEAttribute(settingsEClass, SETTINGS__ENABLED_EXPORT_TYPES);
		createEAttribute(settingsEClass, SETTINGS__CUSTOM_LOGO_ADDRESS);
		createEAttribute(settingsEClass, SETTINGS__SITE_ADDRESS);
		createEReference(settingsEClass, SETTINGS__SERIALIZERS);
		createEReference(settingsEClass, SETTINGS__GUIDANCE_PROVIDERS);
		createEAttribute(settingsEClass, SETTINGS__HEADER_ADDITION);
		createEAttribute(settingsEClass, SETTINGS__FOOTER_ADDITION);
		createEAttribute(settingsEClass, SETTINGS__MERGE_IDENTIFIER);
		createEAttribute(settingsEClass, SETTINGS__CACHE_OUTPUT_FILES);
		createEReference(settingsEClass, SETTINGS__IFC_ENGINES);
		createEReference(settingsEClass, SETTINGS__PLUGINS);
		createEReference(settingsEClass, SETTINGS__DESERIALIZERS);

		serializerEClass = createEClass(SERIALIZER);
		createEAttribute(serializerEClass, SERIALIZER__NAME);
		createEAttribute(serializerEClass, SERIALIZER__DESCRIPTION);
		createEAttribute(serializerEClass, SERIALIZER__EXTENSION);
		createEAttribute(serializerEClass, SERIALIZER__CONTENT_TYPE);
		createEAttribute(serializerEClass, SERIALIZER__CLASS_NAME);
		createEAttribute(serializerEClass, SERIALIZER__ENABLED);
		createEAttribute(serializerEClass, SERIALIZER__DEFAULT_SERIALIZER);
		createEReference(serializerEClass, SERIALIZER__GUIDANCE_PROVIDER);
		createEReference(serializerEClass, SERIALIZER__SETTINGS);

		guidanceProviderEClass = createEClass(GUIDANCE_PROVIDER);
		createEAttribute(guidanceProviderEClass, GUIDANCE_PROVIDER__NAME);
		createEAttribute(guidanceProviderEClass, GUIDANCE_PROVIDER__CLASS_NAME);
		createEReference(guidanceProviderEClass, GUIDANCE_PROVIDER__SERIALIZERS);
		createEReference(guidanceProviderEClass, GUIDANCE_PROVIDER__SETTINGS);

		ifcEngineEClass = createEClass(IFC_ENGINE);
		createEAttribute(ifcEngineEClass, IFC_ENGINE__NAME);
		createEAttribute(ifcEngineEClass, IFC_ENGINE__ACTIVE);
		createEReference(ifcEngineEClass, IFC_ENGINE__SETTINGS);

		pluginEClass = createEClass(PLUGIN);
		createEAttribute(pluginEClass, PLUGIN__NAME);
		createEAttribute(pluginEClass, PLUGIN__ENABLED);
		createEReference(pluginEClass, PLUGIN__SETTINGS);

		deserializerEClass = createEClass(DESERIALIZER);
		createEAttribute(deserializerEClass, DESERIALIZER__NAME);
		createEAttribute(deserializerEClass, DESERIALIZER__DESCRIPTION);
		createEAttribute(deserializerEClass, DESERIALIZER__CLASS_NAME);
		createEAttribute(deserializerEClass, DESERIALIZER__ENABLED);
		createEAttribute(deserializerEClass, DESERIALIZER__DEFAULT_DESERIALIZER);
		createEReference(deserializerEClass, DESERIALIZER__SETTINGS);

		checkinResultEClass = createEClass(CHECKIN_RESULT);
		createEReference(checkinResultEClass, CHECKIN_RESULT__REVISION);
		createEAttribute(checkinResultEClass, CHECKIN_RESULT__RID);
		createEReference(checkinResultEClass, CHECKIN_RESULT__PROJECT);

		downloadResultEClass = createEClass(DOWNLOAD_RESULT);
		createEAttribute(downloadResultEClass, DOWNLOAD_RESULT__PROJECT_NAME);
		createEAttribute(downloadResultEClass, DOWNLOAD_RESULT__REVISION_NR);
		createEAttribute(downloadResultEClass, DOWNLOAD_RESULT__FILE);

		checkoutResultEClass = createEClass(CHECKOUT_RESULT);

		dataValueEClass = createEClass(DATA_VALUE);
		createEAttribute(dataValueEClass, DATA_VALUE__FIELD_NAME);

		dataObjectEClass = createEClass(DATA_OBJECT);
		createEAttribute(dataObjectEClass, DATA_OBJECT__TYPE);
		createEAttribute(dataObjectEClass, DATA_OBJECT__GUID);
		createEAttribute(dataObjectEClass, DATA_OBJECT__NAME);
		createEReference(dataObjectEClass, DATA_OBJECT__VALUES);

		userSessionEClass = createEClass(USER_SESSION);
		createEReference(userSessionEClass, USER_SESSION__USER);
		createEAttribute(userSessionEClass, USER_SESSION__USERNAME);
		createEAttribute(userSessionEClass, USER_SESSION__NAME);
		createEAttribute(userSessionEClass, USER_SESSION__TYPE);
		createEAttribute(userSessionEClass, USER_SESSION__ACTIVE_SINCE);
		createEAttribute(userSessionEClass, USER_SESSION__LAST_ACTIVE);
		createEAttribute(userSessionEClass, USER_SESSION__ACCESS_METHOD);

		migrationEClass = createEClass(MIGRATION);
		createEAttribute(migrationEClass, MIGRATION__NUMBER);
		createEAttribute(migrationEClass, MIGRATION__DESCRIPTION);
		createEAttribute(migrationEClass, MIGRATION__EXECUTED);

		referenceDataValueEClass = createEClass(REFERENCE_DATA_VALUE);
		createEAttribute(referenceDataValueEClass, REFERENCE_DATA_VALUE__TYPE_NAME);
		createEAttribute(referenceDataValueEClass, REFERENCE_DATA_VALUE__GUID);

		listDataValueEClass = createEClass(LIST_DATA_VALUE);
		createEReference(listDataValueEClass, LIST_DATA_VALUE__VALUES);

		simpleDataValueEClass = createEClass(SIMPLE_DATA_VALUE);
		createEAttribute(simpleDataValueEClass, SIMPLE_DATA_VALUE__STRING_VALUE);

		databaseInformationItemEClass = createEClass(DATABASE_INFORMATION_ITEM);
		createEAttribute(databaseInformationItemEClass, DATABASE_INFORMATION_ITEM__KEY);
		createEAttribute(databaseInformationItemEClass, DATABASE_INFORMATION_ITEM__VALUE);

		databaseInformationCategoryEClass = createEClass(DATABASE_INFORMATION_CATEGORY);
		createEAttribute(databaseInformationCategoryEClass, DATABASE_INFORMATION_CATEGORY__TITLE);
		createEReference(databaseInformationCategoryEClass, DATABASE_INFORMATION_CATEGORY__ITEMS);

		databaseInformationEClass = createEClass(DATABASE_INFORMATION);
		createEAttribute(databaseInformationEClass, DATABASE_INFORMATION__NUMBER_OF_PROJECTS);
		createEAttribute(databaseInformationEClass, DATABASE_INFORMATION__NUMBER_OF_USERS);
		createEAttribute(databaseInformationEClass, DATABASE_INFORMATION__NUMBER_OF_REVISIONS);
		createEAttribute(databaseInformationEClass, DATABASE_INFORMATION__NUMBER_OF_CHECKOUTS);
		createEAttribute(databaseInformationEClass, DATABASE_INFORMATION__DATABASE_SIZE_IN_BYTES);
		createEAttribute(databaseInformationEClass, DATABASE_INFORMATION__TYPE);
		createEAttribute(databaseInformationEClass, DATABASE_INFORMATION__CREATED);
		createEAttribute(databaseInformationEClass, DATABASE_INFORMATION__LOCATION);
		createEAttribute(databaseInformationEClass, DATABASE_INFORMATION__SCHEMA_VERSION);
		createEReference(databaseInformationEClass, DATABASE_INFORMATION__CATEGORIES);

		serializerPluginDescriptorEClass = createEClass(SERIALIZER_PLUGIN_DESCRIPTOR);
		createEAttribute(serializerPluginDescriptorEClass, SERIALIZER_PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME);
		createEAttribute(serializerPluginDescriptorEClass, SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_NAME);
		createEAttribute(serializerPluginDescriptorEClass, SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_EXTENSION);
		createEAttribute(serializerPluginDescriptorEClass, SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_CONTENT_TYPE);

		revisionSummaryTypeEClass = createEClass(REVISION_SUMMARY_TYPE);
		createEAttribute(revisionSummaryTypeEClass, REVISION_SUMMARY_TYPE__NAME);
		createEAttribute(revisionSummaryTypeEClass, REVISION_SUMMARY_TYPE__COUNT);

		revisionSummaryContainerEClass = createEClass(REVISION_SUMMARY_CONTAINER);
		createEAttribute(revisionSummaryContainerEClass, REVISION_SUMMARY_CONTAINER__NAME);
		createEReference(revisionSummaryContainerEClass, REVISION_SUMMARY_CONTAINER__TYPES);

		revisionSummaryEClass = createEClass(REVISION_SUMMARY);
		createEReference(revisionSummaryEClass, REVISION_SUMMARY__LIST);

		pluginDescriptorEClass = createEClass(PLUGIN_DESCRIPTOR);
		createEAttribute(pluginDescriptorEClass, PLUGIN_DESCRIPTOR__NAME);
		createEAttribute(pluginDescriptorEClass, PLUGIN_DESCRIPTOR__DESCRIPTION);
		createEAttribute(pluginDescriptorEClass, PLUGIN_DESCRIPTOR__LOCATION);
		createEAttribute(pluginDescriptorEClass, PLUGIN_DESCRIPTOR__ENABLED);

		longActionEClass = createEClass(LONG_ACTION);
		createEAttribute(longActionEClass, LONG_ACTION__IDENTIFICATION);
		createEReference(longActionEClass, LONG_ACTION__USER);
		createEAttribute(longActionEClass, LONG_ACTION__START);
		createEAttribute(longActionEClass, LONG_ACTION__USERNAME);
		createEAttribute(longActionEClass, LONG_ACTION__NAME);

		guidanceProviderPluginDescriptorEClass = createEClass(GUIDANCE_PROVIDER_PLUGIN_DESCRIPTOR);
		createEAttribute(guidanceProviderPluginDescriptorEClass, GUIDANCE_PROVIDER_PLUGIN_DESCRIPTOR__CLASS_NAME);

		compareItemEClass = createEClass(COMPARE_ITEM);
		createEReference(compareItemEClass, COMPARE_ITEM__DATA_OBJECT);

		objectAddedEClass = createEClass(OBJECT_ADDED);

		objectRemovedEClass = createEClass(OBJECT_REMOVED);

		objectModifiedEClass = createEClass(OBJECT_MODIFIED);
		createEAttribute(objectModifiedEClass, OBJECT_MODIFIED__FIELD_NAME);
		createEAttribute(objectModifiedEClass, OBJECT_MODIFIED__OLD_VALUE);
		createEAttribute(objectModifiedEClass, OBJECT_MODIFIED__NEW_VALUE);

		compareContainerEClass = createEClass(COMPARE_CONTAINER);
		createEAttribute(compareContainerEClass, COMPARE_CONTAINER__TYPE);
		createEReference(compareContainerEClass, COMPARE_CONTAINER__ITEMS);

		compareResultEClass = createEClass(COMPARE_RESULT);
		createEReference(compareResultEClass, COMPARE_RESULT__ITEMS);

		longActionStateEClass = createEClass(LONG_ACTION_STATE);
		createEAttribute(longActionStateEClass, LONG_ACTION_STATE__PROGRESS);
		createEAttribute(longActionStateEClass, LONG_ACTION_STATE__STATE);

		notificationEClass = createEClass(NOTIFICATION);

		newProjectNotificationEClass = createEClass(NEW_PROJECT_NOTIFICATION);
		createEReference(newProjectNotificationEClass, NEW_PROJECT_NOTIFICATION__PROJECT);

		newRevisionNotificationEClass = createEClass(NEW_REVISION_NOTIFICATION);
		createEReference(newRevisionNotificationEClass, NEW_REVISION_NOTIFICATION__REVISION);

		compileResultEClass = createEClass(COMPILE_RESULT);
		createEAttribute(compileResultEClass, COMPILE_RESULT__COMPILE_OKE);
		createEAttribute(compileResultEClass, COMPILE_RESULT__WARNINGS);
		createEAttribute(compileResultEClass, COMPILE_RESULT__ERRORS);

		runResultEClass = createEClass(RUN_RESULT);
		createEAttribute(runResultEClass, RUN_RESULT__RUN_OKE);
		createEAttribute(runResultEClass, RUN_RESULT__WARNINGS);
		createEAttribute(runResultEClass, RUN_RESULT__ERRORS);
		createEAttribute(runResultEClass, RUN_RESULT__OUTPUT);

		serverInfoEClass = createEClass(SERVER_INFO);
		createEAttribute(serverInfoEClass, SERVER_INFO__SERVER_STATE);
		createEAttribute(serverInfoEClass, SERVER_INFO__ERROR_MESSAGE);

		versionEClass = createEClass(VERSION);
		createEAttribute(versionEClass, VERSION__MAJOR);
		createEAttribute(versionEClass, VERSION__MINOR);
		createEAttribute(versionEClass, VERSION__REVISION);
		createEAttribute(versionEClass, VERSION__DATE);
		createEAttribute(versionEClass, VERSION__DOWNLOAD_URL);
		createEAttribute(versionEClass, VERSION__SUPPORT_URL);
		createEAttribute(versionEClass, VERSION__SUPPORT_EMAIL);

		// Create enums
		userTypeEEnum = createEEnum(USER_TYPE);
		checkinStateEEnum = createEEnum(CHECKIN_STATE);
		siPrefixEEnum = createEEnum(SI_PREFIX);
		objectStateEEnum = createEEnum(OBJECT_STATE);
		mergeIdentifierEEnum = createEEnum(MERGE_IDENTIFIER);
		compareIdentifierEEnum = createEEnum(COMPARE_IDENTIFIER);
		compareTypeEEnum = createEEnum(COMPARE_TYPE);
		actionStateEEnum = createEEnum(ACTION_STATE);
		serverStateEEnum = createEEnum(SERVER_STATE);

		// Create data types
		dataHandlerEDataType = createEDataType(DATA_HANDLER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		LogPackage theLogPackage = (LogPackage) EPackage.Registry.INSTANCE.getEPackage(LogPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eidClashEClass.getESuperTypes().add(this.getClash());
		guidClashEClass.getESuperTypes().add(this.getClash());
		checkoutResultEClass.getESuperTypes().add(this.getDownloadResult());
		referenceDataValueEClass.getESuperTypes().add(this.getDataValue());
		listDataValueEClass.getESuperTypes().add(this.getDataValue());
		simpleDataValueEClass.getESuperTypes().add(this.getDataValue());
		objectAddedEClass.getESuperTypes().add(this.getCompareItem());
		objectRemovedEClass.getESuperTypes().add(this.getCompareItem());
		objectModifiedEClass.getESuperTypes().add(this.getCompareItem());
		newProjectNotificationEClass.getESuperTypes().add(this.getNotification());
		newRevisionNotificationEClass.getESuperTypes().add(this.getNotification());

		// Initialize classes and features; add operations and parameters
		initEClass(projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProject_Id(), ecorePackage.getEInt(), "id", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_Name(), ecorePackage.getEString(), "name", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_HasAuthorizedUsers(), this.getUser(), this.getUser_HasRightsOn(), "hasAuthorizedUsers", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_ConcreteRevisions(), this.getConcreteRevision(), this.getConcreteRevision_Project(), "concreteRevisions", null, 0, -1, Project.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Revisions(), this.getRevision(), this.getRevision_Project(), "revisions", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_LastConcreteRevision(), this.getConcreteRevision(), null, "lastConcreteRevision", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_LastRevision(), this.getRevision(), null, "lastRevision", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Checkouts(), this.getCheckout(), this.getCheckout_Project(), "checkouts", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_State(), this.getObjectState(), "state", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_CreatedDate(), ecorePackage.getEDate(), "createdDate", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_CreatedBy(), this.getUser(), null, "createdBy", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_GeoTag(), this.getGeoTag(), this.getGeoTag_Projects(), "geoTag", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_SubProjects(), this.getProject(), this.getProject_Parent(), "subProjects", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Parent(), this.getProject(), this.getProject_SubProjects(), "parent", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_Description(), ecorePackage.getEString(), "description", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_ClashDetectionSettings(), this.getClashDetectionSettings(), this.getClashDetectionSettings_Projects(), "clashDetectionSettings", null, 0, 1,
				Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_ExportLengthMeasurePrefix(), this.getSIPrefix(), "exportLengthMeasurePrefix", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUser_Name(), ecorePackage.getEString(), "name", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Password(), ecorePackage.getEString(), "password", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUser_HasRightsOn(), this.getProject(), this.getProject_HasAuthorizedUsers(), "hasRightsOn", null, 0, -1, User.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUser_Revisions(), this.getRevision(), null, "revisions", null, 0, -1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_State(), this.getObjectState(), "state", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_CreatedOn(), ecorePackage.getEDate(), "createdOn", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUser_CreatedBy(), this.getUser(), null, "createdBy", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_UserType(), this.getUserType(), "userType", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Username(), ecorePackage.getEString(), "username", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_LastSeen(), ecorePackage.getEDate(), "lastSeen", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_ValidationToken(), ecorePackage.getEString(), "validationToken", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_ValidationTokenCreated(), ecorePackage.getEDate(), "validationTokenCreated", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_NotificationUrl(), ecorePackage.getEString(), "notificationUrl", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clashEClass, Clash.class, "Clash", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClash_Name1(), ecorePackage.getEString(), "name1", null, 0, 1, Clash.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClash_Name2(), ecorePackage.getEString(), "name2", null, 0, 1, Clash.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClash_Type1(), ecorePackage.getEString(), "type1", null, 0, 1, Clash.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClash_Type2(), ecorePackage.getEString(), "type2", null, 0, 1, Clash.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClash_Revision1(), this.getRevision(), null, "revision1", null, 0, 1, Clash.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClash_Revision2(), this.getRevision(), null, "revision2", null, 0, 1, Clash.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eidClashEClass, EidClash.class, "EidClash", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEidClash_Eid1(), ecorePackage.getELong(), "eid1", null, 0, 1, EidClash.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEidClash_Eid2(), ecorePackage.getELong(), "eid2", null, 0, 1, EidClash.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guidClashEClass, GuidClash.class, "GuidClash", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGuidClash_Guid1(), ecorePackage.getEString(), "guid1", null, 0, 1, GuidClash.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGuidClash_Guid2(), ecorePackage.getEString(), "guid2", null, 0, 1, GuidClash.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clashDetectionSettingsEClass, ClashDetectionSettings.class, "ClashDetectionSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClashDetectionSettings_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 0, 1, ClashDetectionSettings.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClashDetectionSettings_Projects(), this.getProject(), this.getProject_ClashDetectionSettings(), "projects", null, 0, -1, ClashDetectionSettings.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClashDetectionSettings_Margin(), ecorePackage.getEFloat(), "margin", null, 0, 1, ClashDetectionSettings.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClashDetectionSettings_Revisions(), this.getRevision(), null, "revisions", null, 0, -1, ClashDetectionSettings.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClashDetectionSettings_IgnoredClasses(), ecorePackage.getEString(), "ignoredClasses", null, 0, -1, ClashDetectionSettings.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(revisionEClass, Revision.class, "Revision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRevision_Id(), ecorePackage.getEInt(), "id", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getRevision_User(), this.getUser(), null, "user", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevision_Date(), ecorePackage.getEDate(), "date", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevision_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevision_Size(), ecorePackage.getELong(), "size", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRevision_ConcreteRevisions(), this.getConcreteRevision(), this.getConcreteRevision_Revisions(), "concreteRevisions", null, 0, -1, Revision.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRevision_LastConcreteRevision(), this.getConcreteRevision(), null, "lastConcreteRevision", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRevision_Checkouts(), this.getCheckout(), this.getCheckout_Revision(), "checkouts", null, 0, -1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRevision_Project(), this.getProject(), this.getProject_Revisions(), "project", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevision_State(), this.getCheckinState(), "state", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRevision_LastClashes(), this.getClash(), null, "lastClashes", null, 0, -1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevision_Tag(), ecorePackage.getEString(), "tag", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevision_LastError(), ecorePackage.getEString(), "lastError", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevision_Bmi(), ecorePackage.getEInt(), "bmi", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevision_NrClashes(), ecorePackage.getEInt(), "nrClashes", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevision_Laid(), ecorePackage.getELong(), "laid", null, 0, 1, Revision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concreteRevisionEClass, ConcreteRevision.class, "ConcreteRevision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConcreteRevision_Id(), ecorePackage.getEInt(), "id", null, 0, 1, ConcreteRevision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteRevision_Project(), this.getProject(), this.getProject_ConcreteRevisions(), "project", null, 0, 1, ConcreteRevision.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteRevision_State(), this.getCheckinState(), "state", null, 0, 1, ConcreteRevision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteRevision_Checksum(), ecorePackage.getEByteArray(), "checksum", null, 0, 1, ConcreteRevision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteRevision_Revisions(), this.getRevision(), this.getRevision_ConcreteRevisions(), "revisions", null, 0, -1, ConcreteRevision.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteRevision_Size(), ecorePackage.getELong(), "size", null, 0, 1, ConcreteRevision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteRevision_Date(), ecorePackage.getEDate(), "date", null, 0, 1, ConcreteRevision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteRevision_LastError(), ecorePackage.getEString(), "lastError", null, 0, 1, ConcreteRevision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(geoTagEClass, GeoTag.class, "GeoTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGeoTag_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 0, 1, GeoTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeoTag_Projects(), this.getProject(), this.getProject_GeoTag(), "projects", null, 0, -1, GeoTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeoTag_X(), ecorePackage.getEFloat(), "x", null, 0, 1, GeoTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeoTag_Y(), ecorePackage.getEFloat(), "y", null, 0, 1, GeoTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeoTag_Z(), ecorePackage.getEFloat(), "z", null, 0, 1, GeoTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeoTag_Epsg(), ecorePackage.getEInt(), "epsg", null, 0, 1, GeoTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeoTag_DirectionAngle(), ecorePackage.getEFloat(), "directionAngle", null, 0, 1, GeoTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(checkoutEClass, Checkout.class, "Checkout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCheckout_User(), this.getUser(), null, "user", null, 0, 1, Checkout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCheckout_Revision(), this.getRevision(), this.getRevision_Checkouts(), "revision", null, 0, 1, Checkout.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCheckout_Project(), this.getProject(), this.getProject_Checkouts(), "project", null, 0, 1, Checkout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCheckout_Date(), ecorePackage.getEDate(), "date", null, 0, 1, Checkout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCheckout_Checkin(), this.getRevision(), null, "checkin", null, 0, 1, Checkout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCheckout_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1, Checkout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(settingsEClass, Settings.class, "Settings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSettings_ShowVersionUpgradeAvailable(), ecorePackage.getEBoolean(), "showVersionUpgradeAvailable", null, 0, 1, Settings.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_SendConfirmationEmailAfterRegistration(), ecorePackage.getEBoolean(), "sendConfirmationEmailAfterRegistration", null, 0, 1, Settings.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_UseCaching(), ecorePackage.getEBoolean(), "useCaching", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_AllowSelfRegistration(), ecorePackage.getEBoolean(), "allowSelfRegistration", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_AutoTestClashes(), ecorePackage.getEBoolean(), "autoTestClashes", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_IntelligentMerging(), ecorePackage.getEBoolean(), "intelligentMerging", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_AllowUsersToCreateTopLevelProjects(), ecorePackage.getEBoolean(), "allowUsersToCreateTopLevelProjects", null, 0, 1, Settings.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_CheckinMergingEnabled(), ecorePackage.getEBoolean(), "checkinMergingEnabled", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_RegistrationAddition(), ecorePackage.getEString(), "registrationAddition", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_SmtpServer(), ecorePackage.getEString(), "smtpServer", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_EmailSenderAddress(), ecorePackage.getEString(), "emailSenderAddress", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_EnabledExportTypes(), ecorePackage.getEString(), "enabledExportTypes", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_CustomLogoAddress(), ecorePackage.getEString(), "customLogoAddress", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_SiteAddress(), ecorePackage.getEString(), "siteAddress", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSettings_Serializers(), this.getSerializer(), this.getSerializer_Settings(), "serializers", null, 0, -1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSettings_GuidanceProviders(), this.getGuidanceProvider(), this.getGuidanceProvider_Settings(), "guidanceProviders", null, 0, -1, Settings.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_HeaderAddition(), ecorePackage.getEString(), "headerAddition", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_FooterAddition(), ecorePackage.getEString(), "footerAddition", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_MergeIdentifier(), this.getMergeIdentifier(), "mergeIdentifier", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSettings_CacheOutputFiles(), ecorePackage.getEBoolean(), "cacheOutputFiles", null, 0, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSettings_IfcEngines(), this.getIfcEngine(), this.getIfcEngine_Settings(), "ifcEngines", null, 0, -1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSettings_Plugins(), this.getPlugin(), this.getPlugin_Settings(), "plugins", null, 0, -1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSettings_Deserializers(), this.getDeserializer(), this.getDeserializer_Settings(), "deserializers", null, 0, -1, Settings.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serializerEClass, Serializer.class, "Serializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSerializer_Name(), ecorePackage.getEString(), "name", null, 0, 1, Serializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSerializer_Description(), ecorePackage.getEString(), "description", null, 0, 1, Serializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSerializer_Extension(), ecorePackage.getEString(), "extension", null, 0, 1, Serializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSerializer_ContentType(), ecorePackage.getEString(), "contentType", null, 0, 1, Serializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSerializer_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, Serializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSerializer_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 0, 1, Serializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSerializer_DefaultSerializer(), ecorePackage.getEBoolean(), "defaultSerializer", null, 0, 1, Serializer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSerializer_GuidanceProvider(), this.getGuidanceProvider(), this.getGuidanceProvider_Serializers(), "guidanceProvider", null, 0, 1, Serializer.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSerializer_Settings(), this.getSettings(), this.getSettings_Serializers(), "settings", null, 0, 1, Serializer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guidanceProviderEClass, GuidanceProvider.class, "GuidanceProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGuidanceProvider_Name(), ecorePackage.getEString(), "name", null, 0, 1, GuidanceProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGuidanceProvider_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, GuidanceProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGuidanceProvider_Serializers(), this.getSerializer(), this.getSerializer_GuidanceProvider(), "serializers", null, 0, -1, GuidanceProvider.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGuidanceProvider_Settings(), this.getSettings(), this.getSettings_GuidanceProviders(), "settings", null, 0, 1, GuidanceProvider.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifcEngineEClass, IfcEngine.class, "IfcEngine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIfcEngine_Name(), ecorePackage.getEString(), "name", null, 0, 1, IfcEngine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIfcEngine_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1, IfcEngine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfcEngine_Settings(), this.getSettings(), this.getSettings_IfcEngines(), "settings", null, 0, 1, IfcEngine.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pluginEClass, Plugin.class, "Plugin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlugin_Name(), ecorePackage.getEString(), "name", null, 0, 1, Plugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlugin_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 0, 1, Plugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlugin_Settings(), this.getSettings(), this.getSettings_Plugins(), "settings", null, 0, 1, Plugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deserializerEClass, Deserializer.class, "Deserializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeserializer_Name(), ecorePackage.getEString(), "name", null, 0, 1, Deserializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeserializer_Description(), ecorePackage.getEString(), "description", null, 0, 1, Deserializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeserializer_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, Deserializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeserializer_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 0, 1, Deserializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeserializer_DefaultDeserializer(), ecorePackage.getEBoolean(), "defaultDeserializer", null, 0, 1, Deserializer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeserializer_Settings(), this.getSettings(), this.getSettings_Deserializers(), "settings", null, 0, 1, Deserializer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(checkinResultEClass, CheckinResult.class, "CheckinResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCheckinResult_Revision(), this.getRevision(), null, "revision", null, 0, 1, CheckinResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCheckinResult_Rid(), ecorePackage.getEInt(), "rid", null, 0, 1, CheckinResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCheckinResult_Project(), this.getProject(), null, "project", null, 0, 1, CheckinResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(downloadResultEClass, DownloadResult.class, "DownloadResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDownloadResult_ProjectName(), ecorePackage.getEString(), "projectName", null, 0, 1, DownloadResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDownloadResult_RevisionNr(), ecorePackage.getEInt(), "revisionNr", null, 0, 1, DownloadResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDownloadResult_File(), this.getDataHandler(), "file", null, 0, 1, DownloadResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(checkoutResultEClass, CheckoutResult.class, "CheckoutResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataValueEClass, DataValue.class, "DataValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataValue_FieldName(), ecorePackage.getEString(), "fieldName", null, 0, 1, DataValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataObjectEClass, DataObject.class, "DataObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataObject_Type(), ecorePackage.getEString(), "type", null, 0, 1, DataObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataObject_Guid(), ecorePackage.getEString(), "guid", null, 0, 1, DataObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, DataObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataObject_Values(), this.getDataValue(), null, "values", null, 0, -1, DataObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userSessionEClass, UserSession.class, "UserSession", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserSession_User(), this.getUser(), null, "user", null, 0, 1, UserSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserSession_Username(), ecorePackage.getEString(), "username", null, 0, 1, UserSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserSession_Name(), ecorePackage.getEString(), "name", null, 0, 1, UserSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserSession_Type(), this.getUserType(), "type", null, 0, 1, UserSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserSession_ActiveSince(), ecorePackage.getEDate(), "activeSince", null, 0, 1, UserSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserSession_LastActive(), ecorePackage.getEDate(), "lastActive", null, 0, 1, UserSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserSession_AccessMethod(), theLogPackage.getAccessMethod(), "accessMethod", null, 0, 1, UserSession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(migrationEClass, Migration.class, "Migration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMigration_Number(), ecorePackage.getEInt(), "number", null, 0, 1, Migration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMigration_Description(), ecorePackage.getEString(), "description", null, 0, 1, Migration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMigration_Executed(), ecorePackage.getEBoolean(), "executed", null, 0, 1, Migration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceDataValueEClass, ReferenceDataValue.class, "ReferenceDataValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceDataValue_TypeName(), ecorePackage.getEString(), "typeName", null, 0, 1, ReferenceDataValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceDataValue_Guid(), ecorePackage.getEString(), "guid", null, 0, 1, ReferenceDataValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listDataValueEClass, ListDataValue.class, "ListDataValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListDataValue_Values(), this.getDataValue(), null, "values", null, 0, -1, ListDataValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleDataValueEClass, SimpleDataValue.class, "SimpleDataValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleDataValue_StringValue(), ecorePackage.getEString(), "stringValue", null, 0, 1, SimpleDataValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(databaseInformationItemEClass, DatabaseInformationItem.class, "DatabaseInformationItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDatabaseInformationItem_Key(), ecorePackage.getEString(), "key", null, 0, 1, DatabaseInformationItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseInformationItem_Value(), ecorePackage.getEString(), "value", null, 0, 1, DatabaseInformationItem.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(databaseInformationCategoryEClass, DatabaseInformationCategory.class, "DatabaseInformationCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDatabaseInformationCategory_Title(), ecorePackage.getEString(), "title", null, 0, 1, DatabaseInformationCategory.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDatabaseInformationCategory_Items(), this.getDatabaseInformationItem(), null, "items", null, 0, -1, DatabaseInformationCategory.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(databaseInformationEClass, DatabaseInformation.class, "DatabaseInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDatabaseInformation_NumberOfProjects(), ecorePackage.getEInt(), "numberOfProjects", null, 0, 1, DatabaseInformation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseInformation_NumberOfUsers(), ecorePackage.getEInt(), "numberOfUsers", null, 0, 1, DatabaseInformation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseInformation_NumberOfRevisions(), ecorePackage.getEInt(), "numberOfRevisions", null, 0, 1, DatabaseInformation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseInformation_NumberOfCheckouts(), ecorePackage.getEInt(), "numberOfCheckouts", null, 0, 1, DatabaseInformation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseInformation_DatabaseSizeInBytes(), ecorePackage.getELong(), "databaseSizeInBytes", null, 0, 1, DatabaseInformation.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseInformation_Type(), ecorePackage.getEString(), "type", null, 0, 1, DatabaseInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseInformation_Created(), ecorePackage.getEDate(), "created", null, 0, 1, DatabaseInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseInformation_Location(), ecorePackage.getEString(), "location", null, 0, 1, DatabaseInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseInformation_SchemaVersion(), ecorePackage.getEInt(), "schemaVersion", null, 0, 1, DatabaseInformation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDatabaseInformation_Categories(), this.getDatabaseInformationCategory(), null, "categories", null, 0, -1, DatabaseInformation.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serializerPluginDescriptorEClass, SerializerPluginDescriptor.class, "SerializerPluginDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSerializerPluginDescriptor_PluginClassName(), ecorePackage.getEString(), "pluginClassName", null, 0, 1, SerializerPluginDescriptor.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSerializerPluginDescriptor_DefaultName(), ecorePackage.getEString(), "defaultName", null, 0, 1, SerializerPluginDescriptor.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSerializerPluginDescriptor_DefaultExtension(), ecorePackage.getEString(), "defaultExtension", null, 0, 1, SerializerPluginDescriptor.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSerializerPluginDescriptor_DefaultContentType(), ecorePackage.getEString(), "defaultContentType", null, 0, 1, SerializerPluginDescriptor.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(revisionSummaryTypeEClass, RevisionSummaryType.class, "RevisionSummaryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRevisionSummaryType_Name(), ecorePackage.getEString(), "name", null, 0, 1, RevisionSummaryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRevisionSummaryType_Count(), ecorePackage.getEInt(), "count", null, 0, 1, RevisionSummaryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(revisionSummaryContainerEClass, RevisionSummaryContainer.class, "RevisionSummaryContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRevisionSummaryContainer_Name(), ecorePackage.getEString(), "name", null, 0, 1, RevisionSummaryContainer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRevisionSummaryContainer_Types(), this.getRevisionSummaryType(), null, "types", null, 0, -1, RevisionSummaryContainer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(revisionSummaryEClass, RevisionSummary.class, "RevisionSummary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRevisionSummary_List(), this.getRevisionSummaryContainer(), null, "list", null, 0, -1, RevisionSummary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pluginDescriptorEClass, PluginDescriptor.class, "PluginDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPluginDescriptor_Name(), ecorePackage.getEString(), "name", null, 0, 1, PluginDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPluginDescriptor_Description(), ecorePackage.getEString(), "description", null, 0, 1, PluginDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPluginDescriptor_Location(), ecorePackage.getEString(), "location", null, 0, 1, PluginDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPluginDescriptor_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 0, 1, PluginDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(longActionEClass, LongAction.class, "LongAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLongAction_Identification(), ecorePackage.getEString(), "identification", null, 0, 1, LongAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLongAction_User(), this.getUser(), null, "user", null, 0, 1, LongAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLongAction_Start(), ecorePackage.getEDate(), "start", null, 0, 1, LongAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLongAction_Username(), ecorePackage.getEString(), "username", null, 0, 1, LongAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLongAction_Name(), ecorePackage.getEString(), "name", null, 0, 1, LongAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guidanceProviderPluginDescriptorEClass, GuidanceProviderPluginDescriptor.class, "GuidanceProviderPluginDescriptor", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGuidanceProviderPluginDescriptor_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, GuidanceProviderPluginDescriptor.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compareItemEClass, CompareItem.class, "CompareItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompareItem_DataObject(), this.getDataObject(), null, "dataObject", null, 0, 1, CompareItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectAddedEClass, ObjectAdded.class, "ObjectAdded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectRemovedEClass, ObjectRemoved.class, "ObjectRemoved", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectModifiedEClass, ObjectModified.class, "ObjectModified", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectModified_FieldName(), ecorePackage.getEString(), "fieldName", null, 0, 1, ObjectModified.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjectModified_OldValue(), ecorePackage.getEString(), "oldValue", null, 0, 1, ObjectModified.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjectModified_NewValue(), ecorePackage.getEString(), "newValue", null, 0, 1, ObjectModified.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compareContainerEClass, CompareContainer.class, "CompareContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompareContainer_Type(), ecorePackage.getEString(), "type", null, 0, 1, CompareContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompareContainer_Items(), this.getCompareItem(), null, "items", null, 0, -1, CompareContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compareResultEClass, CompareResult.class, "CompareResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompareResult_Items(), this.getCompareContainer(), null, "items", null, 0, -1, CompareResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(longActionStateEClass, LongActionState.class, "LongActionState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLongActionState_Progress(), ecorePackage.getEInt(), "progress", null, 0, 1, LongActionState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLongActionState_State(), this.getActionState(), "state", null, 0, 1, LongActionState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notificationEClass, Notification.class, "Notification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(newProjectNotificationEClass, NewProjectNotification.class, "NewProjectNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewProjectNotification_Project(), this.getProject(), null, "project", null, 0, 1, NewProjectNotification.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newRevisionNotificationEClass, NewRevisionNotification.class, "NewRevisionNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewRevisionNotification_Revision(), this.getRevision(), null, "revision", null, 0, 1, NewRevisionNotification.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compileResultEClass, CompileResult.class, "CompileResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompileResult_CompileOke(), ecorePackage.getEBoolean(), "compileOke", null, 0, 1, CompileResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompileResult_Warnings(), ecorePackage.getEString(), "warnings", null, 0, -1, CompileResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompileResult_Errors(), ecorePackage.getEString(), "errors", null, 0, -1, CompileResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(runResultEClass, RunResult.class, "RunResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRunResult_RunOke(), ecorePackage.getEBoolean(), "runOke", null, 0, 1, RunResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRunResult_Warnings(), ecorePackage.getEString(), "warnings", null, 0, -1, RunResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRunResult_Errors(), ecorePackage.getEString(), "errors", null, 0, -1, RunResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRunResult_Output(), ecorePackage.getEString(), "output", null, 0, 1, RunResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serverInfoEClass, ServerInfo.class, "ServerInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServerInfo_ServerState(), this.getServerState(), "serverState", null, 0, 1, ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServerInfo_ErrorMessage(), ecorePackage.getEString(), "errorMessage", null, 0, 1, ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionEClass, Version.class, "Version", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersion_Major(), ecorePackage.getEInt(), "major", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_Minor(), ecorePackage.getEInt(), "minor", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_Revision(), ecorePackage.getEInt(), "revision", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_Date(), ecorePackage.getEDate(), "date", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_DownloadUrl(), ecorePackage.getEString(), "downloadUrl", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_SupportUrl(), ecorePackage.getEString(), "supportUrl", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersion_SupportEmail(), ecorePackage.getEString(), "supportEmail", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(userTypeEEnum, UserType.class, "UserType");
		addEEnumLiteral(userTypeEEnum, UserType.SYSTEM);
		addEEnumLiteral(userTypeEEnum, UserType.ADMIN);
		addEEnumLiteral(userTypeEEnum, UserType.USER);
		addEEnumLiteral(userTypeEEnum, UserType.ANONYMOUS);

		initEEnum(checkinStateEEnum, CheckinState.class, "CheckinState");
		addEEnumLiteral(checkinStateEEnum, CheckinState.UPLOADING);
		addEEnumLiteral(checkinStateEEnum, CheckinState.PARSING);
		addEEnumLiteral(checkinStateEEnum, CheckinState.STORING);
		addEEnumLiteral(checkinStateEEnum, CheckinState.SEARCHING_CLASHES);
		addEEnumLiteral(checkinStateEEnum, CheckinState.DONE);
		addEEnumLiteral(checkinStateEEnum, CheckinState.ERROR);
		addEEnumLiteral(checkinStateEEnum, CheckinState.CLASHES_ERROR);

		initEEnum(siPrefixEEnum, SIPrefix.class, "SIPrefix");
		addEEnumLiteral(siPrefixEEnum, SIPrefix.METER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.ATTOMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.FEMTOMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.PICOMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.NANOMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.MICROMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.MILLIMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.CENTIMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.DECIMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.DECAMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.HECTOMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.KILOMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.MEGAMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.GIGAMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.TERAMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.PETAMETER);
		addEEnumLiteral(siPrefixEEnum, SIPrefix.EXAMETER);

		initEEnum(objectStateEEnum, ObjectState.class, "ObjectState");
		addEEnumLiteral(objectStateEEnum, ObjectState.ACTIVE);
		addEEnumLiteral(objectStateEEnum, ObjectState.DELETED);

		initEEnum(mergeIdentifierEEnum, MergeIdentifier.class, "MergeIdentifier");
		addEEnumLiteral(mergeIdentifierEEnum, MergeIdentifier.NAME);
		addEEnumLiteral(mergeIdentifierEEnum, MergeIdentifier.GUID);

		initEEnum(compareIdentifierEEnum, CompareIdentifier.class, "CompareIdentifier");
		addEEnumLiteral(compareIdentifierEEnum, CompareIdentifier.NAME_ID);
		addEEnumLiteral(compareIdentifierEEnum, CompareIdentifier.GUID_ID);

		initEEnum(compareTypeEEnum, CompareType.class, "CompareType");
		addEEnumLiteral(compareTypeEEnum, CompareType.ALL);
		addEEnumLiteral(compareTypeEEnum, CompareType.ADD);
		addEEnumLiteral(compareTypeEEnum, CompareType.MODIFY);
		addEEnumLiteral(compareTypeEEnum, CompareType.DELETE);

		initEEnum(actionStateEEnum, ActionState.class, "ActionState");
		addEEnumLiteral(actionStateEEnum, ActionState.UNKNOWN);
		addEEnumLiteral(actionStateEEnum, ActionState.STARTED);
		addEEnumLiteral(actionStateEEnum, ActionState.FINISHED);

		initEEnum(serverStateEEnum, ServerState.class, "ServerState");
		addEEnumLiteral(serverStateEEnum, ServerState.UNDEFINED);
		addEEnumLiteral(serverStateEEnum, ServerState.NOT_SETUP);
		addEEnumLiteral(serverStateEEnum, ServerState.MIGRATION_REQUIRED);
		addEEnumLiteral(serverStateEEnum, ServerState.MIGRATION_IMPOSSIBLE);
		addEEnumLiteral(serverStateEEnum, ServerState.FATAL_ERROR);
		addEEnumLiteral(serverStateEEnum, ServerState.RUNNING);

		// Initialize data types
		initEDataType(dataHandlerEDataType, DataHandler.class, "DataHandler", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// embedsreference
		createEmbedsreferenceAnnotations();
	}

	/**
	 * Initializes the annotations for <b>embedsreference</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmbedsreferenceAnnotations() {
		String source = "embedsreference";
		addAnnotation(getDataObject_Values(), source, new String[] {});
		addAnnotation(getListDataValue_Values(), source, new String[] {});
		addAnnotation(getDatabaseInformationCategory_Items(), source, new String[] {});
		addAnnotation(getDatabaseInformation_Categories(), source, new String[] {});
		addAnnotation(getRevisionSummaryContainer_Types(), source, new String[] {});
		addAnnotation(getRevisionSummary_List(), source, new String[] {});
		addAnnotation(getCompareItem_DataObject(), source, new String[] {});
		addAnnotation(getCompareContainer_Items(), source, new String[] {});
		addAnnotation(getCompareResult_Items(), source, new String[] {});
	}

} //StorePackageImpl
