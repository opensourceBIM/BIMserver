/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.log.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.impl.Ifc2x3PackageImpl;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.ClashDetectionSettingsUpdated;
import org.bimserver.models.log.DatabaseCreated;
import org.bimserver.models.log.Download;
import org.bimserver.models.log.GeoTagUpdated;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.log.NewCheckoutAdded;
import org.bimserver.models.log.NewGuidanceProviderUploaded;
import org.bimserver.models.log.NewProjectAdded;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.log.NewUserAdded;
import org.bimserver.models.log.PasswordChanged;
import org.bimserver.models.log.PasswordReset;
import org.bimserver.models.log.ProjectDeleted;
import org.bimserver.models.log.ProjectUndeleted;
import org.bimserver.models.log.ProjectUpdated;
import org.bimserver.models.log.RevisionUpdated;
import org.bimserver.models.log.ServerLog;
import org.bimserver.models.log.ServerStarted;
import org.bimserver.models.log.SettingsSaved;
import org.bimserver.models.log.UserAddedToProject;
import org.bimserver.models.log.UserChanged;
import org.bimserver.models.log.UserDeleted;
import org.bimserver.models.log.UserRemovedFromProject;
import org.bimserver.models.log.UserUndeleted;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.impl.StorePackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
public class LogPackageImpl extends EPackageImpl implements LogPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverLogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newUserAddedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newProjectAddedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newRevisionAddedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newCheckoutAddedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass settingsSavedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userAddedToProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newGuidanceProviderUploadedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass downloadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userRemovedFromProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectDeletedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDeletedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass passwordResetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass databaseCreatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverStartedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectUpdatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userUndeletedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectUndeletedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass revisionUpdatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geoTagUpdatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clashDetectionSettingsUpdatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass passwordChangedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userChangedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum accessMethodEEnum = null;

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
	 * @see org.bimserver.models.log.LogPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LogPackageImpl() {
		super(eNS_URI, LogFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LogPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LogPackage init() {
		if (isInited) return (LogPackage)EPackage.Registry.INSTANCE.getEPackage(LogPackage.eNS_URI);

		// Obtain or create and register package
		LogPackageImpl theLogPackage = (LogPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LogPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LogPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		StorePackageImpl theStorePackage = (StorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI) instanceof StorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI) : StorePackage.eINSTANCE);
		Ifc2x3PackageImpl theIfc2x3Package = (Ifc2x3PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ifc2x3Package.eNS_URI) instanceof Ifc2x3PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ifc2x3Package.eNS_URI) : Ifc2x3Package.eINSTANCE);

		// Load packages
		theIfc2x3Package.loadPackage();

		// Create package meta-data objects
		theLogPackage.createPackageContents();
		theStorePackage.createPackageContents();

		// Initialize created meta-data
		theLogPackage.initializePackageContents();
		theStorePackage.initializePackageContents();

		// Fix loaded packages
		theIfc2x3Package.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theLogPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LogPackage.eNS_URI, theLogPackage);
		return theLogPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogAction() {
		return logActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogAction_Date() {
		return (EAttribute)logActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogAction_Executor() {
		return (EReference)logActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogAction_AccessMethod() {
		return (EAttribute)logActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerLog() {
		return serverLogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerLog_Actions() {
		return (EReference)serverLogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewUserAdded() {
		return newUserAddedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewUserAdded_User() {
		return (EReference)newUserAddedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewProjectAdded() {
		return newProjectAddedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewProjectAdded_Project() {
		return (EReference)newProjectAddedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewProjectAdded_ParentProject() {
		return (EReference)newProjectAddedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewRevisionAdded() {
		return newRevisionAddedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewRevisionAdded_Revision() {
		return (EReference)newRevisionAddedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewCheckoutAdded() {
		return newCheckoutAddedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewCheckoutAdded_Checkout() {
		return (EReference)newCheckoutAddedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSettingsSaved() {
		return settingsSavedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserAddedToProject() {
		return userAddedToProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserAddedToProject_User() {
		return (EReference)userAddedToProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserAddedToProject_Project() {
		return (EReference)userAddedToProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewGuidanceProviderUploaded() {
		return newGuidanceProviderUploadedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDownload() {
		return downloadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserRemovedFromProject() {
		return userRemovedFromProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserRemovedFromProject_User() {
		return (EReference)userRemovedFromProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserRemovedFromProject_Project() {
		return (EReference)userRemovedFromProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectDeleted() {
		return projectDeletedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectDeleted_Project() {
		return (EReference)projectDeletedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserDeleted() {
		return userDeletedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserDeleted_User() {
		return (EReference)userDeletedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPasswordReset() {
		return passwordResetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPasswordReset_User() {
		return (EReference)passwordResetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseCreated() {
		return databaseCreatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseCreated_Path() {
		return (EAttribute)databaseCreatedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseCreated_Version() {
		return (EAttribute)databaseCreatedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerStarted() {
		return serverStartedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectUpdated() {
		return projectUpdatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectUpdated_Project() {
		return (EReference)projectUpdatedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserUndeleted() {
		return userUndeletedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserUndeleted_User() {
		return (EReference)userUndeletedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectUndeleted() {
		return projectUndeletedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectUndeleted_Project() {
		return (EReference)projectUndeletedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevisionUpdated() {
		return revisionUpdatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevisionUpdated_Revision() {
		return (EReference)revisionUpdatedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeoTagUpdated() {
		return geoTagUpdatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeoTagUpdated_GeoTag() {
		return (EReference)geoTagUpdatedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClashDetectionSettingsUpdated() {
		return clashDetectionSettingsUpdatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClashDetectionSettingsUpdated_ClashDetectionSettings() {
		return (EReference)clashDetectionSettingsUpdatedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPasswordChanged() {
		return passwordChangedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPasswordChanged_User() {
		return (EReference)passwordChangedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserChanged() {
		return userChangedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserChanged_User() {
		return (EReference)userChangedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAccessMethod() {
		return accessMethodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogFactory getLogFactory() {
		return (LogFactory)getEFactoryInstance();
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		logActionEClass = createEClass(LOG_ACTION);
		createEAttribute(logActionEClass, LOG_ACTION__DATE);
		createEReference(logActionEClass, LOG_ACTION__EXECUTOR);
		createEAttribute(logActionEClass, LOG_ACTION__ACCESS_METHOD);

		serverLogEClass = createEClass(SERVER_LOG);
		createEReference(serverLogEClass, SERVER_LOG__ACTIONS);

		newUserAddedEClass = createEClass(NEW_USER_ADDED);
		createEReference(newUserAddedEClass, NEW_USER_ADDED__USER);

		newProjectAddedEClass = createEClass(NEW_PROJECT_ADDED);
		createEReference(newProjectAddedEClass, NEW_PROJECT_ADDED__PROJECT);
		createEReference(newProjectAddedEClass, NEW_PROJECT_ADDED__PARENT_PROJECT);

		newRevisionAddedEClass = createEClass(NEW_REVISION_ADDED);
		createEReference(newRevisionAddedEClass, NEW_REVISION_ADDED__REVISION);

		newCheckoutAddedEClass = createEClass(NEW_CHECKOUT_ADDED);
		createEReference(newCheckoutAddedEClass, NEW_CHECKOUT_ADDED__CHECKOUT);

		settingsSavedEClass = createEClass(SETTINGS_SAVED);

		userAddedToProjectEClass = createEClass(USER_ADDED_TO_PROJECT);
		createEReference(userAddedToProjectEClass, USER_ADDED_TO_PROJECT__USER);
		createEReference(userAddedToProjectEClass, USER_ADDED_TO_PROJECT__PROJECT);

		newGuidanceProviderUploadedEClass = createEClass(NEW_GUIDANCE_PROVIDER_UPLOADED);

		downloadEClass = createEClass(DOWNLOAD);

		userRemovedFromProjectEClass = createEClass(USER_REMOVED_FROM_PROJECT);
		createEReference(userRemovedFromProjectEClass, USER_REMOVED_FROM_PROJECT__USER);
		createEReference(userRemovedFromProjectEClass, USER_REMOVED_FROM_PROJECT__PROJECT);

		projectDeletedEClass = createEClass(PROJECT_DELETED);
		createEReference(projectDeletedEClass, PROJECT_DELETED__PROJECT);

		userDeletedEClass = createEClass(USER_DELETED);
		createEReference(userDeletedEClass, USER_DELETED__USER);

		passwordResetEClass = createEClass(PASSWORD_RESET);
		createEReference(passwordResetEClass, PASSWORD_RESET__USER);

		databaseCreatedEClass = createEClass(DATABASE_CREATED);
		createEAttribute(databaseCreatedEClass, DATABASE_CREATED__PATH);
		createEAttribute(databaseCreatedEClass, DATABASE_CREATED__VERSION);

		serverStartedEClass = createEClass(SERVER_STARTED);

		projectUpdatedEClass = createEClass(PROJECT_UPDATED);
		createEReference(projectUpdatedEClass, PROJECT_UPDATED__PROJECT);

		userUndeletedEClass = createEClass(USER_UNDELETED);
		createEReference(userUndeletedEClass, USER_UNDELETED__USER);

		projectUndeletedEClass = createEClass(PROJECT_UNDELETED);
		createEReference(projectUndeletedEClass, PROJECT_UNDELETED__PROJECT);

		revisionUpdatedEClass = createEClass(REVISION_UPDATED);
		createEReference(revisionUpdatedEClass, REVISION_UPDATED__REVISION);

		geoTagUpdatedEClass = createEClass(GEO_TAG_UPDATED);
		createEReference(geoTagUpdatedEClass, GEO_TAG_UPDATED__GEO_TAG);

		clashDetectionSettingsUpdatedEClass = createEClass(CLASH_DETECTION_SETTINGS_UPDATED);
		createEReference(clashDetectionSettingsUpdatedEClass, CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS);

		passwordChangedEClass = createEClass(PASSWORD_CHANGED);
		createEReference(passwordChangedEClass, PASSWORD_CHANGED__USER);

		userChangedEClass = createEClass(USER_CHANGED);
		createEReference(userChangedEClass, USER_CHANGED__USER);

		// Create enums
		accessMethodEEnum = createEEnum(ACCESS_METHOD);
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
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		StorePackage theStorePackage = (StorePackage)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		newUserAddedEClass.getESuperTypes().add(this.getLogAction());
		newProjectAddedEClass.getESuperTypes().add(this.getLogAction());
		newRevisionAddedEClass.getESuperTypes().add(this.getLogAction());
		newCheckoutAddedEClass.getESuperTypes().add(this.getLogAction());
		settingsSavedEClass.getESuperTypes().add(this.getLogAction());
		userAddedToProjectEClass.getESuperTypes().add(this.getLogAction());
		newGuidanceProviderUploadedEClass.getESuperTypes().add(this.getLogAction());
		downloadEClass.getESuperTypes().add(this.getLogAction());
		userRemovedFromProjectEClass.getESuperTypes().add(this.getLogAction());
		projectDeletedEClass.getESuperTypes().add(this.getLogAction());
		userDeletedEClass.getESuperTypes().add(this.getLogAction());
		passwordResetEClass.getESuperTypes().add(this.getLogAction());
		databaseCreatedEClass.getESuperTypes().add(this.getLogAction());
		serverStartedEClass.getESuperTypes().add(this.getLogAction());
		projectUpdatedEClass.getESuperTypes().add(this.getLogAction());
		userUndeletedEClass.getESuperTypes().add(this.getLogAction());
		projectUndeletedEClass.getESuperTypes().add(this.getLogAction());
		revisionUpdatedEClass.getESuperTypes().add(this.getLogAction());
		geoTagUpdatedEClass.getESuperTypes().add(this.getLogAction());
		clashDetectionSettingsUpdatedEClass.getESuperTypes().add(this.getLogAction());
		passwordChangedEClass.getESuperTypes().add(this.getLogAction());
		userChangedEClass.getESuperTypes().add(this.getLogAction());

		// Initialize classes and features; add operations and parameters
		initEClass(logActionEClass, LogAction.class, "LogAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogAction_Date(), ecorePackage.getEDate(), "date", null, 0, 1, LogAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogAction_Executor(), theStorePackage.getUser(), null, "executor", null, 0, 1, LogAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogAction_AccessMethod(), this.getAccessMethod(), "accessMethod", null, 0, 1, LogAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serverLogEClass, ServerLog.class, "ServerLog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServerLog_Actions(), this.getLogAction(), null, "actions", null, 0, -1, ServerLog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newUserAddedEClass, NewUserAdded.class, "NewUserAdded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewUserAdded_User(), theStorePackage.getUser(), null, "user", null, 0, 1, NewUserAdded.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newProjectAddedEClass, NewProjectAdded.class, "NewProjectAdded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewProjectAdded_Project(), theStorePackage.getProject(), null, "project", null, 0, 1, NewProjectAdded.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewProjectAdded_ParentProject(), theStorePackage.getProject(), null, "parentProject", null, 0, 1, NewProjectAdded.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newRevisionAddedEClass, NewRevisionAdded.class, "NewRevisionAdded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewRevisionAdded_Revision(), theStorePackage.getRevision(), null, "revision", null, 0, 1, NewRevisionAdded.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newCheckoutAddedEClass, NewCheckoutAdded.class, "NewCheckoutAdded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewCheckoutAdded_Checkout(), theStorePackage.getCheckout(), null, "checkout", null, 0, 1, NewCheckoutAdded.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(settingsSavedEClass, SettingsSaved.class, "SettingsSaved", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(userAddedToProjectEClass, UserAddedToProject.class, "UserAddedToProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserAddedToProject_User(), theStorePackage.getUser(), null, "user", null, 0, 1, UserAddedToProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserAddedToProject_Project(), theStorePackage.getProject(), null, "project", null, 0, 1, UserAddedToProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newGuidanceProviderUploadedEClass, NewGuidanceProviderUploaded.class, "NewGuidanceProviderUploaded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(downloadEClass, Download.class, "Download", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(userRemovedFromProjectEClass, UserRemovedFromProject.class, "UserRemovedFromProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserRemovedFromProject_User(), theStorePackage.getUser(), null, "user", null, 0, 1, UserRemovedFromProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserRemovedFromProject_Project(), theStorePackage.getProject(), null, "project", null, 0, 1, UserRemovedFromProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectDeletedEClass, ProjectDeleted.class, "ProjectDeleted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectDeleted_Project(), theStorePackage.getProject(), null, "project", null, 0, 1, ProjectDeleted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userDeletedEClass, UserDeleted.class, "UserDeleted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserDeleted_User(), theStorePackage.getUser(), null, "user", null, 0, 1, UserDeleted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(passwordResetEClass, PasswordReset.class, "PasswordReset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPasswordReset_User(), theStorePackage.getUser(), null, "user", null, 0, 1, PasswordReset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(databaseCreatedEClass, DatabaseCreated.class, "DatabaseCreated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDatabaseCreated_Path(), ecorePackage.getEString(), "path", null, 0, 1, DatabaseCreated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseCreated_Version(), ecorePackage.getEInt(), "version", null, 0, 1, DatabaseCreated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serverStartedEClass, ServerStarted.class, "ServerStarted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(projectUpdatedEClass, ProjectUpdated.class, "ProjectUpdated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectUpdated_Project(), theStorePackage.getProject(), null, "project", null, 0, 1, ProjectUpdated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userUndeletedEClass, UserUndeleted.class, "UserUndeleted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserUndeleted_User(), theStorePackage.getUser(), null, "user", null, 0, 1, UserUndeleted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectUndeletedEClass, ProjectUndeleted.class, "ProjectUndeleted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectUndeleted_Project(), theStorePackage.getProject(), null, "project", null, 0, 1, ProjectUndeleted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(revisionUpdatedEClass, RevisionUpdated.class, "RevisionUpdated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRevisionUpdated_Revision(), theStorePackage.getRevision(), null, "revision", null, 0, 1, RevisionUpdated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(geoTagUpdatedEClass, GeoTagUpdated.class, "GeoTagUpdated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeoTagUpdated_GeoTag(), theStorePackage.getGeoTag(), null, "geoTag", null, 0, 1, GeoTagUpdated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clashDetectionSettingsUpdatedEClass, ClashDetectionSettingsUpdated.class, "ClashDetectionSettingsUpdated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClashDetectionSettingsUpdated_ClashDetectionSettings(), theStorePackage.getClashDetectionSettings(), null, "clashDetectionSettings", null, 0, 1, ClashDetectionSettingsUpdated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(passwordChangedEClass, PasswordChanged.class, "PasswordChanged", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPasswordChanged_User(), theStorePackage.getUser(), null, "user", null, 0, 1, PasswordChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userChangedEClass, UserChanged.class, "UserChanged", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserChanged_User(), theStorePackage.getUser(), null, "user", null, 0, 1, UserChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(accessMethodEEnum, AccessMethod.class, "AccessMethod");
		addEEnumLiteral(accessMethodEEnum, AccessMethod.SOAP);
		addEEnumLiteral(accessMethodEEnum, AccessMethod.WEB_INTERFACE);
		addEEnumLiteral(accessMethodEEnum, AccessMethod.INTERNAL);
		addEEnumLiteral(accessMethodEEnum, AccessMethod.REST);
		addEEnumLiteral(accessMethodEEnum, AccessMethod.SYNDICATION);

		// Create resource
		createResource(eNS_URI);
	}

} //LogPackageImpl
