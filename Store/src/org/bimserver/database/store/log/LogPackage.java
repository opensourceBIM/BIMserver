/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store.log;

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
 * @see org.bimserver.database.store.log.LogFactory
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
	LogPackage eINSTANCE = org.bimserver.database.store.log.impl.LogPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.ServerLogImpl <em>Server Log</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.ServerLogImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getServerLog()
	 * @generated
	 */
	int SERVER_LOG = 0;

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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.LogActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.LogActionImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getLogAction()
	 * @generated
	 */
	int LOG_ACTION = 1;

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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.NewUserAddedImpl <em>New User Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.NewUserAddedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getNewUserAdded()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.NewProjectAddedImpl <em>New Project Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.NewProjectAddedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getNewProjectAdded()
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
	 * The number of structural features of the '<em>New Project Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.NewRevisionAddedImpl <em>New Revision Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.NewRevisionAddedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getNewRevisionAdded()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.NewCheckoutAddedImpl <em>New Checkout Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.NewCheckoutAddedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getNewCheckoutAdded()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.SettingsSavedImpl <em>Settings Saved</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.SettingsSavedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getSettingsSaved()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.UserAddedToProjectImpl <em>User Added To Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.UserAddedToProjectImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getUserAddedToProject()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.NewIgnoreFileUploadedImpl <em>New Ignore File Uploaded</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.NewIgnoreFileUploadedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getNewIgnoreFileUploaded()
	 * @generated
	 */
	int NEW_IGNORE_FILE_UPLOADED = 8;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_IGNORE_FILE_UPLOADED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_IGNORE_FILE_UPLOADED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_IGNORE_FILE_UPLOADED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The number of structural features of the '<em>New Ignore File Uploaded</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_IGNORE_FILE_UPLOADED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.DownloadImpl <em>Download</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.DownloadImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getDownload()
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
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD__REVISION = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD__TYPE = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Zipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD__ZIPPED = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Download</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.UserRemovedFromProjectImpl <em>User Removed From Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.UserRemovedFromProjectImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getUserRemovedFromProject()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.ProjectDeletedImpl <em>Project Deleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.ProjectDeletedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getProjectDeleted()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.UserDeletedImpl <em>User Deleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.UserDeletedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getUserDeleted()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.PasswordResetImpl <em>Password Reset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.PasswordResetImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getPasswordReset()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.DatabaseCreatedImpl <em>Database Created</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.DatabaseCreatedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getDatabaseCreated()
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
	 * The number of structural features of the '<em>Database Created</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.ServerStartedImpl <em>Server Started</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.ServerStartedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getServerStarted()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.ProjectUpdatedImpl <em>Project Updated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.ProjectUpdatedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getProjectUpdated()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.UserUndeletedImpl <em>User Undeleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.UserUndeletedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getUserUndeleted()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.impl.ProjectUndeletedImpl <em>Project Undeleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.impl.ProjectUndeletedImpl
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getProjectUndeleted()
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
	 * The meta object id for the '{@link org.bimserver.database.store.log.AccessMethod <em>Access Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.database.store.log.AccessMethod
	 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getAccessMethod()
	 * @generated
	 */
	int ACCESS_METHOD = 19;


	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.ServerLog <em>Server Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Log</em>'.
	 * @see org.bimserver.database.store.log.ServerLog
	 * @generated
	 */
	EClass getServerLog();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.database.store.log.ServerLog#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see org.bimserver.database.store.log.ServerLog#getActions()
	 * @see #getServerLog()
	 * @generated
	 */
	EReference getServerLog_Actions();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.LogAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.bimserver.database.store.log.LogAction
	 * @generated
	 */
	EClass getLogAction();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.database.store.log.LogAction#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.bimserver.database.store.log.LogAction#getDate()
	 * @see #getLogAction()
	 * @generated
	 */
	EAttribute getLogAction_Date();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.LogAction#getExecutor <em>Executor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executor</em>'.
	 * @see org.bimserver.database.store.log.LogAction#getExecutor()
	 * @see #getLogAction()
	 * @generated
	 */
	EReference getLogAction_Executor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.database.store.log.LogAction#getAccessMethod <em>Access Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Method</em>'.
	 * @see org.bimserver.database.store.log.LogAction#getAccessMethod()
	 * @see #getLogAction()
	 * @generated
	 */
	EAttribute getLogAction_AccessMethod();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.NewUserAdded <em>New User Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New User Added</em>'.
	 * @see org.bimserver.database.store.log.NewUserAdded
	 * @generated
	 */
	EClass getNewUserAdded();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.NewUserAdded#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.database.store.log.NewUserAdded#getUser()
	 * @see #getNewUserAdded()
	 * @generated
	 */
	EReference getNewUserAdded_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.NewProjectAdded <em>New Project Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Project Added</em>'.
	 * @see org.bimserver.database.store.log.NewProjectAdded
	 * @generated
	 */
	EClass getNewProjectAdded();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.NewProjectAdded#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.database.store.log.NewProjectAdded#getProject()
	 * @see #getNewProjectAdded()
	 * @generated
	 */
	EReference getNewProjectAdded_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.NewRevisionAdded <em>New Revision Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Revision Added</em>'.
	 * @see org.bimserver.database.store.log.NewRevisionAdded
	 * @generated
	 */
	EClass getNewRevisionAdded();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.NewRevisionAdded#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see org.bimserver.database.store.log.NewRevisionAdded#getRevision()
	 * @see #getNewRevisionAdded()
	 * @generated
	 */
	EReference getNewRevisionAdded_Revision();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.NewCheckoutAdded <em>New Checkout Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Checkout Added</em>'.
	 * @see org.bimserver.database.store.log.NewCheckoutAdded
	 * @generated
	 */
	EClass getNewCheckoutAdded();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.NewCheckoutAdded#getCheckout <em>Checkout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Checkout</em>'.
	 * @see org.bimserver.database.store.log.NewCheckoutAdded#getCheckout()
	 * @see #getNewCheckoutAdded()
	 * @generated
	 */
	EReference getNewCheckoutAdded_Checkout();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.SettingsSaved <em>Settings Saved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Settings Saved</em>'.
	 * @see org.bimserver.database.store.log.SettingsSaved
	 * @generated
	 */
	EClass getSettingsSaved();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.UserAddedToProject <em>User Added To Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Added To Project</em>'.
	 * @see org.bimserver.database.store.log.UserAddedToProject
	 * @generated
	 */
	EClass getUserAddedToProject();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.UserAddedToProject#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.database.store.log.UserAddedToProject#getUser()
	 * @see #getUserAddedToProject()
	 * @generated
	 */
	EReference getUserAddedToProject_User();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.UserAddedToProject#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.database.store.log.UserAddedToProject#getProject()
	 * @see #getUserAddedToProject()
	 * @generated
	 */
	EReference getUserAddedToProject_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.NewIgnoreFileUploaded <em>New Ignore File Uploaded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Ignore File Uploaded</em>'.
	 * @see org.bimserver.database.store.log.NewIgnoreFileUploaded
	 * @generated
	 */
	EClass getNewIgnoreFileUploaded();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.Download <em>Download</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Download</em>'.
	 * @see org.bimserver.database.store.log.Download
	 * @generated
	 */
	EClass getDownload();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.Download#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see org.bimserver.database.store.log.Download#getRevision()
	 * @see #getDownload()
	 * @generated
	 */
	EReference getDownload_Revision();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.database.store.log.Download#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.bimserver.database.store.log.Download#getType()
	 * @see #getDownload()
	 * @generated
	 */
	EAttribute getDownload_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.database.store.log.Download#isZipped <em>Zipped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Zipped</em>'.
	 * @see org.bimserver.database.store.log.Download#isZipped()
	 * @see #getDownload()
	 * @generated
	 */
	EAttribute getDownload_Zipped();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.UserRemovedFromProject <em>User Removed From Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Removed From Project</em>'.
	 * @see org.bimserver.database.store.log.UserRemovedFromProject
	 * @generated
	 */
	EClass getUserRemovedFromProject();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.UserRemovedFromProject#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.database.store.log.UserRemovedFromProject#getUser()
	 * @see #getUserRemovedFromProject()
	 * @generated
	 */
	EReference getUserRemovedFromProject_User();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.UserRemovedFromProject#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.database.store.log.UserRemovedFromProject#getProject()
	 * @see #getUserRemovedFromProject()
	 * @generated
	 */
	EReference getUserRemovedFromProject_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.ProjectDeleted <em>Project Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Deleted</em>'.
	 * @see org.bimserver.database.store.log.ProjectDeleted
	 * @generated
	 */
	EClass getProjectDeleted();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.ProjectDeleted#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.database.store.log.ProjectDeleted#getProject()
	 * @see #getProjectDeleted()
	 * @generated
	 */
	EReference getProjectDeleted_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.UserDeleted <em>User Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Deleted</em>'.
	 * @see org.bimserver.database.store.log.UserDeleted
	 * @generated
	 */
	EClass getUserDeleted();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.UserDeleted#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.database.store.log.UserDeleted#getUser()
	 * @see #getUserDeleted()
	 * @generated
	 */
	EReference getUserDeleted_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.PasswordReset <em>Password Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Password Reset</em>'.
	 * @see org.bimserver.database.store.log.PasswordReset
	 * @generated
	 */
	EClass getPasswordReset();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.PasswordReset#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.database.store.log.PasswordReset#getUser()
	 * @see #getPasswordReset()
	 * @generated
	 */
	EReference getPasswordReset_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.DatabaseCreated <em>Database Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Created</em>'.
	 * @see org.bimserver.database.store.log.DatabaseCreated
	 * @generated
	 */
	EClass getDatabaseCreated();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.ServerStarted <em>Server Started</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Started</em>'.
	 * @see org.bimserver.database.store.log.ServerStarted
	 * @generated
	 */
	EClass getServerStarted();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.ProjectUpdated <em>Project Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Updated</em>'.
	 * @see org.bimserver.database.store.log.ProjectUpdated
	 * @generated
	 */
	EClass getProjectUpdated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.ProjectUpdated#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.database.store.log.ProjectUpdated#getProject()
	 * @see #getProjectUpdated()
	 * @generated
	 */
	EReference getProjectUpdated_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.UserUndeleted <em>User Undeleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Undeleted</em>'.
	 * @see org.bimserver.database.store.log.UserUndeleted
	 * @generated
	 */
	EClass getUserUndeleted();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.UserUndeleted#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.database.store.log.UserUndeleted#getUser()
	 * @see #getUserUndeleted()
	 * @generated
	 */
	EReference getUserUndeleted_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.database.store.log.ProjectUndeleted <em>Project Undeleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Undeleted</em>'.
	 * @see org.bimserver.database.store.log.ProjectUndeleted
	 * @generated
	 */
	EClass getProjectUndeleted();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.database.store.log.ProjectUndeleted#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.database.store.log.ProjectUndeleted#getProject()
	 * @see #getProjectUndeleted()
	 * @generated
	 */
	EReference getProjectUndeleted_Project();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.database.store.log.AccessMethod <em>Access Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Access Method</em>'.
	 * @see org.bimserver.database.store.log.AccessMethod
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.ServerLogImpl <em>Server Log</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.ServerLogImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getServerLog()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.LogActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.LogActionImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getLogAction()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.NewUserAddedImpl <em>New User Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.NewUserAddedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getNewUserAdded()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.NewProjectAddedImpl <em>New Project Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.NewProjectAddedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getNewProjectAdded()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.NewRevisionAddedImpl <em>New Revision Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.NewRevisionAddedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getNewRevisionAdded()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.NewCheckoutAddedImpl <em>New Checkout Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.NewCheckoutAddedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getNewCheckoutAdded()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.SettingsSavedImpl <em>Settings Saved</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.SettingsSavedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getSettingsSaved()
		 * @generated
		 */
		EClass SETTINGS_SAVED = eINSTANCE.getSettingsSaved();

		/**
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.UserAddedToProjectImpl <em>User Added To Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.UserAddedToProjectImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getUserAddedToProject()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.NewIgnoreFileUploadedImpl <em>New Ignore File Uploaded</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.NewIgnoreFileUploadedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getNewIgnoreFileUploaded()
		 * @generated
		 */
		EClass NEW_IGNORE_FILE_UPLOADED = eINSTANCE.getNewIgnoreFileUploaded();

		/**
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.DownloadImpl <em>Download</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.DownloadImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getDownload()
		 * @generated
		 */
		EClass DOWNLOAD = eINSTANCE.getDownload();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOWNLOAD__REVISION = eINSTANCE.getDownload_Revision();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOWNLOAD__TYPE = eINSTANCE.getDownload_Type();

		/**
		 * The meta object literal for the '<em><b>Zipped</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOWNLOAD__ZIPPED = eINSTANCE.getDownload_Zipped();

		/**
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.UserRemovedFromProjectImpl <em>User Removed From Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.UserRemovedFromProjectImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getUserRemovedFromProject()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.ProjectDeletedImpl <em>Project Deleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.ProjectDeletedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getProjectDeleted()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.UserDeletedImpl <em>User Deleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.UserDeletedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getUserDeleted()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.PasswordResetImpl <em>Password Reset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.PasswordResetImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getPasswordReset()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.DatabaseCreatedImpl <em>Database Created</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.DatabaseCreatedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getDatabaseCreated()
		 * @generated
		 */
		EClass DATABASE_CREATED = eINSTANCE.getDatabaseCreated();

		/**
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.ServerStartedImpl <em>Server Started</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.ServerStartedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getServerStarted()
		 * @generated
		 */
		EClass SERVER_STARTED = eINSTANCE.getServerStarted();

		/**
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.ProjectUpdatedImpl <em>Project Updated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.ProjectUpdatedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getProjectUpdated()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.UserUndeletedImpl <em>User Undeleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.UserUndeletedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getUserUndeleted()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.impl.ProjectUndeletedImpl <em>Project Undeleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.impl.ProjectUndeletedImpl
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getProjectUndeleted()
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
		 * The meta object literal for the '{@link org.bimserver.database.store.log.AccessMethod <em>Access Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.database.store.log.AccessMethod
		 * @see org.bimserver.database.store.log.impl.LogPackageImpl#getAccessMethod()
		 * @generated
		 */
		EEnum ACCESS_METHOD = eINSTANCE.getAccessMethod();

	}

} //LogPackage
