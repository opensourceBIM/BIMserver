/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.log;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.bimserver.models.log.LogFactory
 * @model kind="package"
 * @generated
 */
public interface LogPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "log";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "log";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "log";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LogPackage eINSTANCE = org.bimserver.models.log.impl.LogPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.LogActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.LogActionImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getLogAction()
	 * @generated
	 */
	int LOG_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ACTION__DATE = 0;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ACTION__EXECUTOR = 1;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ACTION__ACCESS_METHOD = 2;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ACTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ServerLogImpl <em>Server Log</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ServerLogImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getServerLog()
	 * @generated
	 */
	int SERVER_LOG = 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_LOG__ACTIONS = 0;

	/**
	 * The number of structural features of the '<em>Server Log</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_LOG_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewUserAddedImpl <em>New User Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewUserAddedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewUserAdded()
	 * @generated
	 */
	int NEW_USER_ADDED = 2;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New User Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewProjectAddedImpl <em>New Project Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewProjectAddedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewProjectAdded()
	 * @generated
	 */
	int NEW_PROJECT_ADDED = 3;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__PROJECT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__PARENT_PROJECT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>New Project Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewRevisionAddedImpl <em>New Revision Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewRevisionAddedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewRevisionAdded()
	 * @generated
	 */
	int NEW_REVISION_ADDED = 4;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__REVISION = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Revision Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewCheckoutAddedImpl <em>New Checkout Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewCheckoutAddedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewCheckoutAdded()
	 * @generated
	 */
	int NEW_CHECKOUT_ADDED = 5;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Checkout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED__CHECKOUT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Checkout Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.SettingsSavedImpl <em>Settings Saved</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.SettingsSavedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getSettingsSaved()
	 * @generated
	 */
	int SETTINGS_SAVED = 6;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_SAVED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_SAVED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_SAVED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The number of structural features of the '<em>Settings Saved</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_SAVED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserAddedToProjectImpl <em>User Added To Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserAddedToProjectImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserAddedToProject()
	 * @generated
	 */
	int USER_ADDED_TO_PROJECT = 7;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__PROJECT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>User Added To Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewGuidanceProviderUploadedImpl <em>New Guidance Provider Uploaded</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewGuidanceProviderUploadedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewGuidanceProviderUploaded()
	 * @generated
	 */
	int NEW_GUIDANCE_PROVIDER_UPLOADED = 8;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_GUIDANCE_PROVIDER_UPLOADED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_GUIDANCE_PROVIDER_UPLOADED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_GUIDANCE_PROVIDER_UPLOADED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The number of structural features of the '<em>New Guidance Provider Uploaded</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_GUIDANCE_PROVIDER_UPLOADED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.DownloadImpl <em>Download</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.DownloadImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getDownload()
	 * @generated
	 */
	int DOWNLOAD = 9;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The number of structural features of the '<em>Download</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserRemovedFromProjectImpl <em>User Removed From Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserRemovedFromProjectImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserRemovedFromProject()
	 * @generated
	 */
	int USER_REMOVED_FROM_PROJECT = 10;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__PROJECT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>User Removed From Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ProjectDeletedImpl <em>Project Deleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ProjectDeletedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectDeleted()
	 * @generated
	 */
	int PROJECT_DELETED = 11;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED__PROJECT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project Deleted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserDeletedImpl <em>User Deleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserDeletedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserDeleted()
	 * @generated
	 */
	int USER_DELETED = 12;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Deleted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.PasswordResetImpl <em>Password Reset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.PasswordResetImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getPasswordReset()
	 * @generated
	 */
	int PASSWORD_RESET = 13;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Password Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.DatabaseCreatedImpl <em>Database Created</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.DatabaseCreatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getDatabaseCreated()
	 * @generated
	 */
	int DATABASE_CREATED = 14;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED__PATH = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED__VERSION = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Database Created</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ServerStartedImpl <em>Server Started</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ServerStartedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getServerStarted()
	 * @generated
	 */
	int SERVER_STARTED = 15;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_STARTED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_STARTED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_STARTED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The number of structural features of the '<em>Server Started</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_STARTED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ProjectUpdatedImpl <em>Project Updated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ProjectUpdatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectUpdated()
	 * @generated
	 */
	int PROJECT_UPDATED = 16;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED__PROJECT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project Updated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserUndeletedImpl <em>User Undeleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserUndeletedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserUndeleted()
	 * @generated
	 */
	int USER_UNDELETED = 17;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Undeleted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ProjectUndeletedImpl <em>Project Undeleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ProjectUndeletedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectUndeleted()
	 * @generated
	 */
	int PROJECT_UNDELETED = 18;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED__PROJECT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project Undeleted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.RevisionUpdatedImpl <em>Revision Updated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.RevisionUpdatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getRevisionUpdated()
	 * @generated
	 */
	int REVISION_UPDATED = 19;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED__REVISION = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Revision Updated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.GeoTagUpdatedImpl <em>Geo Tag Updated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.GeoTagUpdatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getGeoTagUpdated()
	 * @generated
	 */
	int GEO_TAG_UPDATED = 20;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG_UPDATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG_UPDATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG_UPDATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Geo Tag</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG_UPDATED__GEO_TAG = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Geo Tag Updated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG_UPDATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ClashDetectionSettingsUpdatedImpl <em>Clash Detection Settings Updated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ClashDetectionSettingsUpdatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getClashDetectionSettingsUpdated()
	 * @generated
	 */
	int CLASH_DETECTION_SETTINGS_UPDATED = 21;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS_UPDATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS_UPDATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS_UPDATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Clash Detection Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Clash Detection Settings Updated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS_UPDATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.PasswordChangedImpl <em>Password Changed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.PasswordChangedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getPasswordChanged()
	 * @generated
	 */
	int PASSWORD_CHANGED = 22;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Password Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserChangedImpl <em>User Changed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserChangedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserChanged()
	 * @generated
	 */
	int USER_CHANGED = 23;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.AccessMethod <em>Access Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.AccessMethod
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getAccessMethod()
	 * @generated
	 */
	int ACCESS_METHOD = 24;


	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.LogAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.bimserver.models.log.LogAction
	 * @generated
	 */
	EClass getLogAction();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.log.LogAction#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.bimserver.models.log.LogAction#getDate()
	 * @see #getLogAction()
	 * @generated
	 */
	EAttribute getLogAction_Date();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.LogAction#getExecutor <em>Executor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executor</em>'.
	 * @see org.bimserver.models.log.LogAction#getExecutor()
	 * @see #getLogAction()
	 * @generated
	 */
	EReference getLogAction_Executor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.log.LogAction#getAccessMethod <em>Access Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Method</em>'.
	 * @see org.bimserver.models.log.LogAction#getAccessMethod()
	 * @see #getLogAction()
	 * @generated
	 */
	EAttribute getLogAction_AccessMethod();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ServerLog <em>Server Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Log</em>'.
	 * @see org.bimserver.models.log.ServerLog
	 * @generated
	 */
	EClass getServerLog();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.log.ServerLog#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see org.bimserver.models.log.ServerLog#getActions()
	 * @see #getServerLog()
	 * @generated
	 */
	EReference getServerLog_Actions();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.NewUserAdded <em>New User Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New User Added</em>'.
	 * @see org.bimserver.models.log.NewUserAdded
	 * @generated
	 */
	EClass getNewUserAdded();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.NewUserAdded#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.NewUserAdded#getUser()
	 * @see #getNewUserAdded()
	 * @generated
	 */
	EReference getNewUserAdded_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.NewProjectAdded <em>New Project Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Project Added</em>'.
	 * @see org.bimserver.models.log.NewProjectAdded
	 * @generated
	 */
	EClass getNewProjectAdded();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.NewProjectAdded#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.NewProjectAdded#getProject()
	 * @see #getNewProjectAdded()
	 * @generated
	 */
	EReference getNewProjectAdded_Project();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.NewProjectAdded#getParentProject <em>Parent Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Project</em>'.
	 * @see org.bimserver.models.log.NewProjectAdded#getParentProject()
	 * @see #getNewProjectAdded()
	 * @generated
	 */
	EReference getNewProjectAdded_ParentProject();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.NewRevisionAdded <em>New Revision Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Revision Added</em>'.
	 * @see org.bimserver.models.log.NewRevisionAdded
	 * @generated
	 */
	EClass getNewRevisionAdded();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.NewRevisionAdded#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see org.bimserver.models.log.NewRevisionAdded#getRevision()
	 * @see #getNewRevisionAdded()
	 * @generated
	 */
	EReference getNewRevisionAdded_Revision();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.NewCheckoutAdded <em>New Checkout Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Checkout Added</em>'.
	 * @see org.bimserver.models.log.NewCheckoutAdded
	 * @generated
	 */
	EClass getNewCheckoutAdded();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.NewCheckoutAdded#getCheckout <em>Checkout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Checkout</em>'.
	 * @see org.bimserver.models.log.NewCheckoutAdded#getCheckout()
	 * @see #getNewCheckoutAdded()
	 * @generated
	 */
	EReference getNewCheckoutAdded_Checkout();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.SettingsSaved <em>Settings Saved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Settings Saved</em>'.
	 * @see org.bimserver.models.log.SettingsSaved
	 * @generated
	 */
	EClass getSettingsSaved();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserAddedToProject <em>User Added To Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Added To Project</em>'.
	 * @see org.bimserver.models.log.UserAddedToProject
	 * @generated
	 */
	EClass getUserAddedToProject();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserAddedToProject#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.UserAddedToProject#getUser()
	 * @see #getUserAddedToProject()
	 * @generated
	 */
	EReference getUserAddedToProject_User();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserAddedToProject#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.UserAddedToProject#getProject()
	 * @see #getUserAddedToProject()
	 * @generated
	 */
	EReference getUserAddedToProject_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.NewGuidanceProviderUploaded <em>New Guidance Provider Uploaded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Guidance Provider Uploaded</em>'.
	 * @see org.bimserver.models.log.NewGuidanceProviderUploaded
	 * @generated
	 */
	EClass getNewGuidanceProviderUploaded();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.Download <em>Download</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Download</em>'.
	 * @see org.bimserver.models.log.Download
	 * @generated
	 */
	EClass getDownload();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserRemovedFromProject <em>User Removed From Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Removed From Project</em>'.
	 * @see org.bimserver.models.log.UserRemovedFromProject
	 * @generated
	 */
	EClass getUserRemovedFromProject();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserRemovedFromProject#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.UserRemovedFromProject#getUser()
	 * @see #getUserRemovedFromProject()
	 * @generated
	 */
	EReference getUserRemovedFromProject_User();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserRemovedFromProject#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.UserRemovedFromProject#getProject()
	 * @see #getUserRemovedFromProject()
	 * @generated
	 */
	EReference getUserRemovedFromProject_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ProjectDeleted <em>Project Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Deleted</em>'.
	 * @see org.bimserver.models.log.ProjectDeleted
	 * @generated
	 */
	EClass getProjectDeleted();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ProjectDeleted#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.ProjectDeleted#getProject()
	 * @see #getProjectDeleted()
	 * @generated
	 */
	EReference getProjectDeleted_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserDeleted <em>User Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Deleted</em>'.
	 * @see org.bimserver.models.log.UserDeleted
	 * @generated
	 */
	EClass getUserDeleted();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserDeleted#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.UserDeleted#getUser()
	 * @see #getUserDeleted()
	 * @generated
	 */
	EReference getUserDeleted_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.PasswordReset <em>Password Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Password Reset</em>'.
	 * @see org.bimserver.models.log.PasswordReset
	 * @generated
	 */
	EClass getPasswordReset();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.PasswordReset#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.PasswordReset#getUser()
	 * @see #getPasswordReset()
	 * @generated
	 */
	EReference getPasswordReset_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.DatabaseCreated <em>Database Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Created</em>'.
	 * @see org.bimserver.models.log.DatabaseCreated
	 * @generated
	 */
	EClass getDatabaseCreated();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.log.DatabaseCreated#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.bimserver.models.log.DatabaseCreated#getPath()
	 * @see #getDatabaseCreated()
	 * @generated
	 */
	EAttribute getDatabaseCreated_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.log.DatabaseCreated#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.bimserver.models.log.DatabaseCreated#getVersion()
	 * @see #getDatabaseCreated()
	 * @generated
	 */
	EAttribute getDatabaseCreated_Version();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ServerStarted <em>Server Started</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Started</em>'.
	 * @see org.bimserver.models.log.ServerStarted
	 * @generated
	 */
	EClass getServerStarted();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ProjectUpdated <em>Project Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Updated</em>'.
	 * @see org.bimserver.models.log.ProjectUpdated
	 * @generated
	 */
	EClass getProjectUpdated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ProjectUpdated#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.ProjectUpdated#getProject()
	 * @see #getProjectUpdated()
	 * @generated
	 */
	EReference getProjectUpdated_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserUndeleted <em>User Undeleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Undeleted</em>'.
	 * @see org.bimserver.models.log.UserUndeleted
	 * @generated
	 */
	EClass getUserUndeleted();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserUndeleted#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.UserUndeleted#getUser()
	 * @see #getUserUndeleted()
	 * @generated
	 */
	EReference getUserUndeleted_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ProjectUndeleted <em>Project Undeleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Undeleted</em>'.
	 * @see org.bimserver.models.log.ProjectUndeleted
	 * @generated
	 */
	EClass getProjectUndeleted();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ProjectUndeleted#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.ProjectUndeleted#getProject()
	 * @see #getProjectUndeleted()
	 * @generated
	 */
	EReference getProjectUndeleted_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.RevisionUpdated <em>Revision Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Revision Updated</em>'.
	 * @see org.bimserver.models.log.RevisionUpdated
	 * @generated
	 */
	EClass getRevisionUpdated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.RevisionUpdated#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see org.bimserver.models.log.RevisionUpdated#getRevision()
	 * @see #getRevisionUpdated()
	 * @generated
	 */
	EReference getRevisionUpdated_Revision();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.GeoTagUpdated <em>Geo Tag Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Geo Tag Updated</em>'.
	 * @see org.bimserver.models.log.GeoTagUpdated
	 * @generated
	 */
	EClass getGeoTagUpdated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.GeoTagUpdated#getGeoTag <em>Geo Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Geo Tag</em>'.
	 * @see org.bimserver.models.log.GeoTagUpdated#getGeoTag()
	 * @see #getGeoTagUpdated()
	 * @generated
	 */
	EReference getGeoTagUpdated_GeoTag();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ClashDetectionSettingsUpdated <em>Clash Detection Settings Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clash Detection Settings Updated</em>'.
	 * @see org.bimserver.models.log.ClashDetectionSettingsUpdated
	 * @generated
	 */
	EClass getClashDetectionSettingsUpdated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ClashDetectionSettingsUpdated#getClashDetectionSettings <em>Clash Detection Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clash Detection Settings</em>'.
	 * @see org.bimserver.models.log.ClashDetectionSettingsUpdated#getClashDetectionSettings()
	 * @see #getClashDetectionSettingsUpdated()
	 * @generated
	 */
	EReference getClashDetectionSettingsUpdated_ClashDetectionSettings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.PasswordChanged <em>Password Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Password Changed</em>'.
	 * @see org.bimserver.models.log.PasswordChanged
	 * @generated
	 */
	EClass getPasswordChanged();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.PasswordChanged#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.PasswordChanged#getUser()
	 * @see #getPasswordChanged()
	 * @generated
	 */
	EReference getPasswordChanged_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserChanged <em>User Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Changed</em>'.
	 * @see org.bimserver.models.log.UserChanged
	 * @generated
	 */
	EClass getUserChanged();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserChanged#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.UserChanged#getUser()
	 * @see #getUserChanged()
	 * @generated
	 */
	EReference getUserChanged_User();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.log.AccessMethod <em>Access Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Access Method</em>'.
	 * @see org.bimserver.models.log.AccessMethod
	 * @generated
	 */
	EEnum getAccessMethod();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LogFactory getLogFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.LogActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.LogActionImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getLogAction()
		 * @generated
		 */
		EClass LOG_ACTION = eINSTANCE.getLogAction();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_ACTION__DATE = eINSTANCE.getLogAction_Date();

		/**
		 * The meta object literal for the '<em><b>Executor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOG_ACTION__EXECUTOR = eINSTANCE.getLogAction_Executor();

		/**
		 * The meta object literal for the '<em><b>Access Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_ACTION__ACCESS_METHOD = eINSTANCE.getLogAction_AccessMethod();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ServerLogImpl <em>Server Log</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ServerLogImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getServerLog()
		 * @generated
		 */
		EClass SERVER_LOG = eINSTANCE.getServerLog();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_LOG__ACTIONS = eINSTANCE.getServerLog_Actions();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.NewUserAddedImpl <em>New User Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.NewUserAddedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewUserAdded()
		 * @generated
		 */
		EClass NEW_USER_ADDED = eINSTANCE.getNewUserAdded();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_USER_ADDED__USER = eINSTANCE.getNewUserAdded_User();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.NewProjectAddedImpl <em>New Project Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.NewProjectAddedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewProjectAdded()
		 * @generated
		 */
		EClass NEW_PROJECT_ADDED = eINSTANCE.getNewProjectAdded();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_PROJECT_ADDED__PROJECT = eINSTANCE.getNewProjectAdded_Project();

		/**
		 * The meta object literal for the '<em><b>Parent Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_PROJECT_ADDED__PARENT_PROJECT = eINSTANCE.getNewProjectAdded_ParentProject();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.NewRevisionAddedImpl <em>New Revision Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.NewRevisionAddedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewRevisionAdded()
		 * @generated
		 */
		EClass NEW_REVISION_ADDED = eINSTANCE.getNewRevisionAdded();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_REVISION_ADDED__REVISION = eINSTANCE.getNewRevisionAdded_Revision();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.NewCheckoutAddedImpl <em>New Checkout Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.NewCheckoutAddedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewCheckoutAdded()
		 * @generated
		 */
		EClass NEW_CHECKOUT_ADDED = eINSTANCE.getNewCheckoutAdded();

		/**
		 * The meta object literal for the '<em><b>Checkout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_CHECKOUT_ADDED__CHECKOUT = eINSTANCE.getNewCheckoutAdded_Checkout();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.SettingsSavedImpl <em>Settings Saved</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.SettingsSavedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getSettingsSaved()
		 * @generated
		 */
		EClass SETTINGS_SAVED = eINSTANCE.getSettingsSaved();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserAddedToProjectImpl <em>User Added To Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserAddedToProjectImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserAddedToProject()
		 * @generated
		 */
		EClass USER_ADDED_TO_PROJECT = eINSTANCE.getUserAddedToProject();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ADDED_TO_PROJECT__USER = eINSTANCE.getUserAddedToProject_User();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ADDED_TO_PROJECT__PROJECT = eINSTANCE.getUserAddedToProject_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.NewGuidanceProviderUploadedImpl <em>New Guidance Provider Uploaded</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.NewGuidanceProviderUploadedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewGuidanceProviderUploaded()
		 * @generated
		 */
		EClass NEW_GUIDANCE_PROVIDER_UPLOADED = eINSTANCE.getNewGuidanceProviderUploaded();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.DownloadImpl <em>Download</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.DownloadImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getDownload()
		 * @generated
		 */
		EClass DOWNLOAD = eINSTANCE.getDownload();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserRemovedFromProjectImpl <em>User Removed From Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserRemovedFromProjectImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserRemovedFromProject()
		 * @generated
		 */
		EClass USER_REMOVED_FROM_PROJECT = eINSTANCE.getUserRemovedFromProject();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_REMOVED_FROM_PROJECT__USER = eINSTANCE.getUserRemovedFromProject_User();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_REMOVED_FROM_PROJECT__PROJECT = eINSTANCE.getUserRemovedFromProject_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ProjectDeletedImpl <em>Project Deleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ProjectDeletedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectDeleted()
		 * @generated
		 */
		EClass PROJECT_DELETED = eINSTANCE.getProjectDeleted();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_DELETED__PROJECT = eINSTANCE.getProjectDeleted_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserDeletedImpl <em>User Deleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserDeletedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserDeleted()
		 * @generated
		 */
		EClass USER_DELETED = eINSTANCE.getUserDeleted();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_DELETED__USER = eINSTANCE.getUserDeleted_User();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.PasswordResetImpl <em>Password Reset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.PasswordResetImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getPasswordReset()
		 * @generated
		 */
		EClass PASSWORD_RESET = eINSTANCE.getPasswordReset();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSWORD_RESET__USER = eINSTANCE.getPasswordReset_User();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.DatabaseCreatedImpl <em>Database Created</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.DatabaseCreatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getDatabaseCreated()
		 * @generated
		 */
		EClass DATABASE_CREATED = eINSTANCE.getDatabaseCreated();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_CREATED__PATH = eINSTANCE.getDatabaseCreated_Path();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_CREATED__VERSION = eINSTANCE.getDatabaseCreated_Version();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ServerStartedImpl <em>Server Started</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ServerStartedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getServerStarted()
		 * @generated
		 */
		EClass SERVER_STARTED = eINSTANCE.getServerStarted();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ProjectUpdatedImpl <em>Project Updated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ProjectUpdatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectUpdated()
		 * @generated
		 */
		EClass PROJECT_UPDATED = eINSTANCE.getProjectUpdated();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_UPDATED__PROJECT = eINSTANCE.getProjectUpdated_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserUndeletedImpl <em>User Undeleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserUndeletedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserUndeleted()
		 * @generated
		 */
		EClass USER_UNDELETED = eINSTANCE.getUserUndeleted();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_UNDELETED__USER = eINSTANCE.getUserUndeleted_User();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ProjectUndeletedImpl <em>Project Undeleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ProjectUndeletedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectUndeleted()
		 * @generated
		 */
		EClass PROJECT_UNDELETED = eINSTANCE.getProjectUndeleted();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_UNDELETED__PROJECT = eINSTANCE.getProjectUndeleted_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.RevisionUpdatedImpl <em>Revision Updated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.RevisionUpdatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getRevisionUpdated()
		 * @generated
		 */
		EClass REVISION_UPDATED = eINSTANCE.getRevisionUpdated();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION_UPDATED__REVISION = eINSTANCE.getRevisionUpdated_Revision();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.GeoTagUpdatedImpl <em>Geo Tag Updated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.GeoTagUpdatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getGeoTagUpdated()
		 * @generated
		 */
		EClass GEO_TAG_UPDATED = eINSTANCE.getGeoTagUpdated();

		/**
		 * The meta object literal for the '<em><b>Geo Tag</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEO_TAG_UPDATED__GEO_TAG = eINSTANCE.getGeoTagUpdated_GeoTag();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ClashDetectionSettingsUpdatedImpl <em>Clash Detection Settings Updated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ClashDetectionSettingsUpdatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getClashDetectionSettingsUpdated()
		 * @generated
		 */
		EClass CLASH_DETECTION_SETTINGS_UPDATED = eINSTANCE.getClashDetectionSettingsUpdated();

		/**
		 * The meta object literal for the '<em><b>Clash Detection Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS = eINSTANCE.getClashDetectionSettingsUpdated_ClashDetectionSettings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.PasswordChangedImpl <em>Password Changed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.PasswordChangedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getPasswordChanged()
		 * @generated
		 */
		EClass PASSWORD_CHANGED = eINSTANCE.getPasswordChanged();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSWORD_CHANGED__USER = eINSTANCE.getPasswordChanged_User();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserChangedImpl <em>User Changed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserChangedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserChanged()
		 * @generated
		 */
		EClass USER_CHANGED = eINSTANCE.getUserChanged();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_CHANGED__USER = eINSTANCE.getUserChanged_User();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.AccessMethod <em>Access Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.AccessMethod
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getAccessMethod()
		 * @generated
		 */
		EEnum ACCESS_METHOD = eINSTANCE.getAccessMethod();

	}

} //LogPackage
