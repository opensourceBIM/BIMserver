/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;

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
 * @see org.bimserver.models.store.StoreFactory
 * @model kind="package"
 * @generated
 */
public interface StorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "store";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "store";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "store";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StorePackage eINSTANCE = org.bimserver.models.store.impl.StorePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ProjectImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Has Authorized Users</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__HAS_AUTHORIZED_USERS = 2;

	/**
	 * The feature id for the '<em><b>Concrete Revisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__CONCRETE_REVISIONS = 3;

	/**
	 * The feature id for the '<em><b>Revisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__REVISIONS = 4;

	/**
	 * The feature id for the '<em><b>Last Concrete Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__LAST_CONCRETE_REVISION = 5;

	/**
	 * The feature id for the '<em><b>Last Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__LAST_REVISION = 6;

	/**
	 * The feature id for the '<em><b>Checkouts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__CHECKOUTS = 7;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__STATE = 8;

	/**
	 * The feature id for the '<em><b>Created Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__CREATED_DATE = 9;

	/**
	 * The feature id for the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__CREATED_BY = 10;

	/**
	 * The feature id for the '<em><b>Geo Tag</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__GEO_TAG = 11;

	/**
	 * The feature id for the '<em><b>Sub Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__SUB_PROJECTS = 12;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__PARENT = 13;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__DESCRIPTION = 14;

	/**
	 * The feature id for the '<em><b>Clash Detection Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__CLASH_DETECTION_SETTINGS = 15;

	/**
	 * The feature id for the '<em><b>Export Length Measure Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__EXPORT_LENGTH_MEASURE_PREFIX = 16;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 17;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.UserImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getUser()
	 * @generated
	 */
	int USER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PASSWORD = 1;

	/**
	 * The feature id for the '<em><b>Has Rights On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__HAS_RIGHTS_ON = 2;

	/**
	 * The feature id for the '<em><b>Revisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__REVISIONS = 3;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__STATE = 4;

	/**
	 * The feature id for the '<em><b>Created On</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__CREATED_ON = 5;

	/**
	 * The feature id for the '<em><b>Created By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__CREATED_BY = 6;

	/**
	 * The feature id for the '<em><b>User Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USER_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USERNAME = 8;

	/**
	 * The feature id for the '<em><b>Last Seen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__LAST_SEEN = 9;

	/**
	 * The feature id for the '<em><b>Validation Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__VALIDATION_TOKEN = 10;

	/**
	 * The feature id for the '<em><b>Validation Token Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__VALIDATION_TOKEN_CREATED = 11;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ClashImpl <em>Clash</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ClashImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getClash()
	 * @generated
	 */
	int CLASH = 2;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH__NAME1 = 0;

	/**
	 * The feature id for the '<em><b>Name2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH__NAME2 = 1;

	/**
	 * The feature id for the '<em><b>Type1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH__TYPE1 = 2;

	/**
	 * The feature id for the '<em><b>Type2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH__TYPE2 = 3;

	/**
	 * The feature id for the '<em><b>Revision1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH__REVISION1 = 4;

	/**
	 * The feature id for the '<em><b>Revision2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH__REVISION2 = 5;

	/**
	 * The number of structural features of the '<em>Clash</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.EidClashImpl <em>Eid Clash</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.EidClashImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getEidClash()
	 * @generated
	 */
	int EID_CLASH = 3;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EID_CLASH__NAME1 = CLASH__NAME1;

	/**
	 * The feature id for the '<em><b>Name2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EID_CLASH__NAME2 = CLASH__NAME2;

	/**
	 * The feature id for the '<em><b>Type1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EID_CLASH__TYPE1 = CLASH__TYPE1;

	/**
	 * The feature id for the '<em><b>Type2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EID_CLASH__TYPE2 = CLASH__TYPE2;

	/**
	 * The feature id for the '<em><b>Revision1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EID_CLASH__REVISION1 = CLASH__REVISION1;

	/**
	 * The feature id for the '<em><b>Revision2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EID_CLASH__REVISION2 = CLASH__REVISION2;

	/**
	 * The feature id for the '<em><b>Eid1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EID_CLASH__EID1 = CLASH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Eid2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EID_CLASH__EID2 = CLASH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Eid Clash</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EID_CLASH_FEATURE_COUNT = CLASH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.GuidClashImpl <em>Guid Clash</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.GuidClashImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getGuidClash()
	 * @generated
	 */
	int GUID_CLASH = 4;

	/**
	 * The feature id for the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUID_CLASH__NAME1 = CLASH__NAME1;

	/**
	 * The feature id for the '<em><b>Name2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUID_CLASH__NAME2 = CLASH__NAME2;

	/**
	 * The feature id for the '<em><b>Type1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUID_CLASH__TYPE1 = CLASH__TYPE1;

	/**
	 * The feature id for the '<em><b>Type2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUID_CLASH__TYPE2 = CLASH__TYPE2;

	/**
	 * The feature id for the '<em><b>Revision1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUID_CLASH__REVISION1 = CLASH__REVISION1;

	/**
	 * The feature id for the '<em><b>Revision2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUID_CLASH__REVISION2 = CLASH__REVISION2;

	/**
	 * The feature id for the '<em><b>Guid1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUID_CLASH__GUID1 = CLASH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Guid2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUID_CLASH__GUID2 = CLASH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Guid Clash</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUID_CLASH_FEATURE_COUNT = CLASH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ClashDetectionSettingsImpl <em>Clash Detection Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ClashDetectionSettingsImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getClashDetectionSettings()
	 * @generated
	 */
	int CLASH_DETECTION_SETTINGS = 5;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS__ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS__PROJECTS = 1;

	/**
	 * The feature id for the '<em><b>Margin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS__MARGIN = 2;

	/**
	 * The feature id for the '<em><b>Revisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS__REVISIONS = 3;

	/**
	 * The feature id for the '<em><b>Ignored Classes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS__IGNORED_CLASSES = 4;

	/**
	 * The number of structural features of the '<em>Clash Detection Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.RevisionImpl <em>Revision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.RevisionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getRevision()
	 * @generated
	 */
	int REVISION = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__ID = 0;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__USER = 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__DATE = 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__COMMENT = 3;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__SIZE = 4;

	/**
	 * The feature id for the '<em><b>Concrete Revisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__CONCRETE_REVISIONS = 5;

	/**
	 * The feature id for the '<em><b>Last Concrete Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__LAST_CONCRETE_REVISION = 6;

	/**
	 * The feature id for the '<em><b>Checkouts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__CHECKOUTS = 7;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__PROJECT = 8;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__STATE = 9;

	/**
	 * The feature id for the '<em><b>Last Clashes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__LAST_CLASHES = 10;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__TAG = 11;

	/**
	 * The feature id for the '<em><b>Last Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__LAST_ERROR = 12;

	/**
	 * The feature id for the '<em><b>Bmi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__BMI = 13;

	/**
	 * The feature id for the '<em><b>Nr Clashes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__NR_CLASHES = 14;

	/**
	 * The feature id for the '<em><b>Laid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__LAID = 15;

	/**
	 * The number of structural features of the '<em>Revision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_FEATURE_COUNT = 16;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ConcreteRevisionImpl <em>Concrete Revision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ConcreteRevisionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getConcreteRevision()
	 * @generated
	 */
	int CONCRETE_REVISION = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__ID = 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__PROJECT = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__STATE = 2;

	/**
	 * The feature id for the '<em><b>Checksum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__CHECKSUM = 3;

	/**
	 * The feature id for the '<em><b>Revisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__REVISIONS = 4;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__SIZE = 5;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__DATE = 6;

	/**
	 * The feature id for the '<em><b>Last Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__LAST_ERROR = 7;

	/**
	 * The number of structural features of the '<em>Concrete Revision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.GeoTagImpl <em>Geo Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.GeoTagImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getGeoTag()
	 * @generated
	 */
	int GEO_TAG = 8;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG__ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG__PROJECTS = 1;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG__X = 2;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG__Y = 3;

	/**
	 * The feature id for the '<em><b>Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG__Z = 4;

	/**
	 * The feature id for the '<em><b>Epsg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG__EPSG = 5;

	/**
	 * The feature id for the '<em><b>Direction Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG__DIRECTION_ANGLE = 6;

	/**
	 * The number of structural features of the '<em>Geo Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.CheckoutImpl <em>Checkout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.CheckoutImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCheckout()
	 * @generated
	 */
	int CHECKOUT = 9;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT__USER = 0;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT__REVISION = 1;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT__PROJECT = 2;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT__DATE = 3;

	/**
	 * The feature id for the '<em><b>Checkin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT__CHECKIN = 4;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT__ACTIVE = 5;

	/**
	 * The number of structural features of the '<em>Checkout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.SettingsImpl <em>Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.SettingsImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getSettings()
	 * @generated
	 */
	int SETTINGS = 10;

	/**
	 * The feature id for the '<em><b>Show Version Upgrade Available</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__SHOW_VERSION_UPGRADE_AVAILABLE = 0;

	/**
	 * The feature id for the '<em><b>Send Confirmation Email After Registration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__SEND_CONFIRMATION_EMAIL_AFTER_REGISTRATION = 1;

	/**
	 * The feature id for the '<em><b>Use Caching</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__USE_CACHING = 2;

	/**
	 * The feature id for the '<em><b>Allow Self Registration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__ALLOW_SELF_REGISTRATION = 3;

	/**
	 * The feature id for the '<em><b>Auto Test Clashes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__AUTO_TEST_CLASHES = 4;

	/**
	 * The feature id for the '<em><b>Intelligent Merging</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__INTELLIGENT_MERGING = 5;

	/**
	 * The feature id for the '<em><b>Allow Users To Create Top Level Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__ALLOW_USERS_TO_CREATE_TOP_LEVEL_PROJECTS = 6;

	/**
	 * The feature id for the '<em><b>Checkin Merging Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__CHECKIN_MERGING_ENABLED = 7;

	/**
	 * The feature id for the '<em><b>Registration Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__REGISTRATION_ADDITION = 8;

	/**
	 * The feature id for the '<em><b>Smtp Server</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__SMTP_SERVER = 9;

	/**
	 * The feature id for the '<em><b>Email Sender Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__EMAIL_SENDER_ADDRESS = 10;

	/**
	 * The feature id for the '<em><b>Enabled Export Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__ENABLED_EXPORT_TYPES = 11;

	/**
	 * The feature id for the '<em><b>Custom Logo Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__CUSTOM_LOGO_ADDRESS = 12;

	/**
	 * The feature id for the '<em><b>Site Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__SITE_ADDRESS = 13;

	/**
	 * The feature id for the '<em><b>Serializers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__SERIALIZERS = 14;

	/**
	 * The feature id for the '<em><b>Guidance Providers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__GUIDANCE_PROVIDERS = 15;

	/**
	 * The feature id for the '<em><b>Header Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__HEADER_ADDITION = 16;

	/**
	 * The feature id for the '<em><b>Footer Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__FOOTER_ADDITION = 17;

	/**
	 * The feature id for the '<em><b>Merge Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__MERGE_IDENTIFIER = 18;

	/**
	 * The feature id for the '<em><b>Cache Output Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__CACHE_OUTPUT_FILES = 19;

	/**
	 * The feature id for the '<em><b>Ifc Engines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__IFC_ENGINES = 20;

	/**
	 * The feature id for the '<em><b>Plugins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__PLUGINS = 21;

	/**
	 * The number of structural features of the '<em>Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_FEATURE_COUNT = 22;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.SerializerImpl <em>Serializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.SerializerImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getSerializer()
	 * @generated
	 */
	int SERIALIZER = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__EXTENSION = 2;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__CONTENT_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__CLASS_NAME = 4;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__ENABLED = 5;

	/**
	 * The feature id for the '<em><b>Default Serializer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__DEFAULT_SERIALIZER = 6;

	/**
	 * The feature id for the '<em><b>Guidance Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__GUIDANCE_PROVIDER = 7;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__SETTINGS = 8;

	/**
	 * The number of structural features of the '<em>Serializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.GuidanceProviderImpl <em>Guidance Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.GuidanceProviderImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getGuidanceProvider()
	 * @generated
	 */
	int GUIDANCE_PROVIDER = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUIDANCE_PROVIDER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUIDANCE_PROVIDER__CLASS_NAME = 1;

	/**
	 * The feature id for the '<em><b>Serializers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUIDANCE_PROVIDER__SERIALIZERS = 2;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUIDANCE_PROVIDER__SETTINGS = 3;

	/**
	 * The number of structural features of the '<em>Guidance Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUIDANCE_PROVIDER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.IfcEngineImpl <em>Ifc Engine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.IfcEngineImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getIfcEngine()
	 * @generated
	 */
	int IFC_ENGINE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_ENGINE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_ENGINE__ACTIVE = 1;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_ENGINE__SETTINGS = 2;

	/**
	 * The number of structural features of the '<em>Ifc Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_ENGINE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.PluginImpl <em>Plugin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.PluginImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPlugin()
	 * @generated
	 */
	int PLUGIN = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__ENABLED = 1;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__SETTINGS = 2;

	/**
	 * The number of structural features of the '<em>Plugin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.UserType <em>User Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.UserType
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getUserType()
	 * @generated
	 */
	int USER_TYPE = 15;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.CheckinState <em>Checkin State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.CheckinState
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCheckinState()
	 * @generated
	 */
	int CHECKIN_STATE = 16;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.SIPrefix <em>SI Prefix</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.SIPrefix
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getSIPrefix()
	 * @generated
	 */
	int SI_PREFIX = 17;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.ObjectState <em>Object State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.ObjectState
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectState()
	 * @generated
	 */
	int OBJECT_STATE = 18;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.MergeIdentifier <em>Merge Identifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.MergeIdentifier
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getMergeIdentifier()
	 * @generated
	 */
	int MERGE_IDENTIFIER = 19;


	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.bimserver.models.store.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Project#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.bimserver.models.store.Project#getId()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Project#getHasAuthorizedUsers <em>Has Authorized Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Has Authorized Users</em>'.
	 * @see org.bimserver.models.store.Project#getHasAuthorizedUsers()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_HasAuthorizedUsers();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Project#getConcreteRevisions <em>Concrete Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Concrete Revisions</em>'.
	 * @see org.bimserver.models.store.Project#getConcreteRevisions()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_ConcreteRevisions();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Project#getRevisions <em>Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Revisions</em>'.
	 * @see org.bimserver.models.store.Project#getRevisions()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Revisions();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Project#getLastConcreteRevision <em>Last Concrete Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Last Concrete Revision</em>'.
	 * @see org.bimserver.models.store.Project#getLastConcreteRevision()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_LastConcreteRevision();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Project#getLastRevision <em>Last Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Last Revision</em>'.
	 * @see org.bimserver.models.store.Project#getLastRevision()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_LastRevision();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Project#getCheckouts <em>Checkouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Checkouts</em>'.
	 * @see org.bimserver.models.store.Project#getCheckouts()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Checkouts();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Project#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.bimserver.models.store.Project#getState()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_State();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Project#getCreatedDate <em>Created Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created Date</em>'.
	 * @see org.bimserver.models.store.Project#getCreatedDate()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_CreatedDate();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Project#getCreatedBy <em>Created By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Created By</em>'.
	 * @see org.bimserver.models.store.Project#getCreatedBy()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_CreatedBy();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Project#getGeoTag <em>Geo Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Geo Tag</em>'.
	 * @see org.bimserver.models.store.Project#getGeoTag()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_GeoTag();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Project#getSubProjects <em>Sub Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Projects</em>'.
	 * @see org.bimserver.models.store.Project#getSubProjects()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_SubProjects();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Project#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.bimserver.models.store.Project#getParent()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Project#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.Project#getDescription()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Description();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Project#getClashDetectionSettings <em>Clash Detection Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clash Detection Settings</em>'.
	 * @see org.bimserver.models.store.Project#getClashDetectionSettings()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_ClashDetectionSettings();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Project#getExportLengthMeasurePrefix <em>Export Length Measure Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Export Length Measure Prefix</em>'.
	 * @see org.bimserver.models.store.Project#getExportLengthMeasurePrefix()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_ExportLengthMeasurePrefix();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see org.bimserver.models.store.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.User#getName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.bimserver.models.store.User#getPassword()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Password();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.User#getHasRightsOn <em>Has Rights On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Has Rights On</em>'.
	 * @see org.bimserver.models.store.User#getHasRightsOn()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_HasRightsOn();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.User#getRevisions <em>Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Revisions</em>'.
	 * @see org.bimserver.models.store.User#getRevisions()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Revisions();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.bimserver.models.store.User#getState()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_State();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getCreatedOn <em>Created On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created On</em>'.
	 * @see org.bimserver.models.store.User#getCreatedOn()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_CreatedOn();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.User#getCreatedBy <em>Created By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Created By</em>'.
	 * @see org.bimserver.models.store.User#getCreatedBy()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_CreatedBy();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getUserType <em>User Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Type</em>'.
	 * @see org.bimserver.models.store.User#getUserType()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_UserType();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see org.bimserver.models.store.User#getUsername()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Username();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getLastSeen <em>Last Seen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Seen</em>'.
	 * @see org.bimserver.models.store.User#getLastSeen()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_LastSeen();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getValidationToken <em>Validation Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validation Token</em>'.
	 * @see org.bimserver.models.store.User#getValidationToken()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_ValidationToken();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getValidationTokenCreated <em>Validation Token Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validation Token Created</em>'.
	 * @see org.bimserver.models.store.User#getValidationTokenCreated()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_ValidationTokenCreated();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Clash <em>Clash</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clash</em>'.
	 * @see org.bimserver.models.store.Clash
	 * @generated
	 */
	EClass getClash();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Clash#getName1 <em>Name1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name1</em>'.
	 * @see org.bimserver.models.store.Clash#getName1()
	 * @see #getClash()
	 * @generated
	 */
	EAttribute getClash_Name1();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Clash#getName2 <em>Name2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name2</em>'.
	 * @see org.bimserver.models.store.Clash#getName2()
	 * @see #getClash()
	 * @generated
	 */
	EAttribute getClash_Name2();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Clash#getType1 <em>Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type1</em>'.
	 * @see org.bimserver.models.store.Clash#getType1()
	 * @see #getClash()
	 * @generated
	 */
	EAttribute getClash_Type1();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Clash#getType2 <em>Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type2</em>'.
	 * @see org.bimserver.models.store.Clash#getType2()
	 * @see #getClash()
	 * @generated
	 */
	EAttribute getClash_Type2();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Clash#getRevision1 <em>Revision1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision1</em>'.
	 * @see org.bimserver.models.store.Clash#getRevision1()
	 * @see #getClash()
	 * @generated
	 */
	EReference getClash_Revision1();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Clash#getRevision2 <em>Revision2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision2</em>'.
	 * @see org.bimserver.models.store.Clash#getRevision2()
	 * @see #getClash()
	 * @generated
	 */
	EReference getClash_Revision2();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.EidClash <em>Eid Clash</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eid Clash</em>'.
	 * @see org.bimserver.models.store.EidClash
	 * @generated
	 */
	EClass getEidClash();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.EidClash#getEid1 <em>Eid1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Eid1</em>'.
	 * @see org.bimserver.models.store.EidClash#getEid1()
	 * @see #getEidClash()
	 * @generated
	 */
	EAttribute getEidClash_Eid1();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.EidClash#getEid2 <em>Eid2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Eid2</em>'.
	 * @see org.bimserver.models.store.EidClash#getEid2()
	 * @see #getEidClash()
	 * @generated
	 */
	EAttribute getEidClash_Eid2();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.GuidClash <em>Guid Clash</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guid Clash</em>'.
	 * @see org.bimserver.models.store.GuidClash
	 * @generated
	 */
	EClass getGuidClash();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.GuidClash#getGuid1 <em>Guid1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guid1</em>'.
	 * @see org.bimserver.models.store.GuidClash#getGuid1()
	 * @see #getGuidClash()
	 * @generated
	 */
	EAttribute getGuidClash_Guid1();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.GuidClash#getGuid2 <em>Guid2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guid2</em>'.
	 * @see org.bimserver.models.store.GuidClash#getGuid2()
	 * @see #getGuidClash()
	 * @generated
	 */
	EAttribute getGuidClash_Guid2();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ClashDetectionSettings <em>Clash Detection Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clash Detection Settings</em>'.
	 * @see org.bimserver.models.store.ClashDetectionSettings
	 * @generated
	 */
	EClass getClashDetectionSettings();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ClashDetectionSettings#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.bimserver.models.store.ClashDetectionSettings#isEnabled()
	 * @see #getClashDetectionSettings()
	 * @generated
	 */
	EAttribute getClashDetectionSettings_Enabled();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ClashDetectionSettings#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Projects</em>'.
	 * @see org.bimserver.models.store.ClashDetectionSettings#getProjects()
	 * @see #getClashDetectionSettings()
	 * @generated
	 */
	EReference getClashDetectionSettings_Projects();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ClashDetectionSettings#getMargin <em>Margin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Margin</em>'.
	 * @see org.bimserver.models.store.ClashDetectionSettings#getMargin()
	 * @see #getClashDetectionSettings()
	 * @generated
	 */
	EAttribute getClashDetectionSettings_Margin();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ClashDetectionSettings#getRevisions <em>Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Revisions</em>'.
	 * @see org.bimserver.models.store.ClashDetectionSettings#getRevisions()
	 * @see #getClashDetectionSettings()
	 * @generated
	 */
	EReference getClashDetectionSettings_Revisions();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.ClashDetectionSettings#getIgnoredClasses <em>Ignored Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ignored Classes</em>'.
	 * @see org.bimserver.models.store.ClashDetectionSettings#getIgnoredClasses()
	 * @see #getClashDetectionSettings()
	 * @generated
	 */
	EAttribute getClashDetectionSettings_IgnoredClasses();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Revision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Revision</em>'.
	 * @see org.bimserver.models.store.Revision
	 * @generated
	 */
	EClass getRevision();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Revision#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.bimserver.models.store.Revision#getId()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_Id();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Revision#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.store.Revision#getUser()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_User();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Revision#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.bimserver.models.store.Revision#getDate()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Revision#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.bimserver.models.store.Revision#getComment()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Revision#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.bimserver.models.store.Revision#getSize()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_Size();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Revision#getConcreteRevisions <em>Concrete Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Concrete Revisions</em>'.
	 * @see org.bimserver.models.store.Revision#getConcreteRevisions()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_ConcreteRevisions();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Revision#getLastConcreteRevision <em>Last Concrete Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Last Concrete Revision</em>'.
	 * @see org.bimserver.models.store.Revision#getLastConcreteRevision()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_LastConcreteRevision();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Revision#getCheckouts <em>Checkouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Checkouts</em>'.
	 * @see org.bimserver.models.store.Revision#getCheckouts()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_Checkouts();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Revision#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.store.Revision#getProject()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_Project();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Revision#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.bimserver.models.store.Revision#getState()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_State();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Revision#getLastClashes <em>Last Clashes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Last Clashes</em>'.
	 * @see org.bimserver.models.store.Revision#getLastClashes()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_LastClashes();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Revision#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag</em>'.
	 * @see org.bimserver.models.store.Revision#getTag()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_Tag();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Revision#getLastError <em>Last Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Error</em>'.
	 * @see org.bimserver.models.store.Revision#getLastError()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_LastError();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Revision#getBmi <em>Bmi</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bmi</em>'.
	 * @see org.bimserver.models.store.Revision#getBmi()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_Bmi();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Revision#getNrClashes <em>Nr Clashes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nr Clashes</em>'.
	 * @see org.bimserver.models.store.Revision#getNrClashes()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_NrClashes();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Revision#getLaid <em>Laid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Laid</em>'.
	 * @see org.bimserver.models.store.Revision#getLaid()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_Laid();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ConcreteRevision <em>Concrete Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Revision</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision
	 * @generated
	 */
	EClass getConcreteRevision();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ConcreteRevision#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getId()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EAttribute getConcreteRevision_Id();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ConcreteRevision#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getProject()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EReference getConcreteRevision_Project();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ConcreteRevision#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getState()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EAttribute getConcreteRevision_State();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ConcreteRevision#getChecksum <em>Checksum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checksum</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getChecksum()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EAttribute getConcreteRevision_Checksum();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ConcreteRevision#getRevisions <em>Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Revisions</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getRevisions()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EReference getConcreteRevision_Revisions();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ConcreteRevision#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getSize()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EAttribute getConcreteRevision_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ConcreteRevision#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getDate()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EAttribute getConcreteRevision_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ConcreteRevision#getLastError <em>Last Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Error</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getLastError()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EAttribute getConcreteRevision_LastError();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.GeoTag <em>Geo Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Geo Tag</em>'.
	 * @see org.bimserver.models.store.GeoTag
	 * @generated
	 */
	EClass getGeoTag();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.GeoTag#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.bimserver.models.store.GeoTag#isEnabled()
	 * @see #getGeoTag()
	 * @generated
	 */
	EAttribute getGeoTag_Enabled();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.GeoTag#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Projects</em>'.
	 * @see org.bimserver.models.store.GeoTag#getProjects()
	 * @see #getGeoTag()
	 * @generated
	 */
	EReference getGeoTag_Projects();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.GeoTag#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.bimserver.models.store.GeoTag#getX()
	 * @see #getGeoTag()
	 * @generated
	 */
	EAttribute getGeoTag_X();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.GeoTag#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.bimserver.models.store.GeoTag#getY()
	 * @see #getGeoTag()
	 * @generated
	 */
	EAttribute getGeoTag_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.GeoTag#getZ <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Z</em>'.
	 * @see org.bimserver.models.store.GeoTag#getZ()
	 * @see #getGeoTag()
	 * @generated
	 */
	EAttribute getGeoTag_Z();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.GeoTag#getEpsg <em>Epsg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Epsg</em>'.
	 * @see org.bimserver.models.store.GeoTag#getEpsg()
	 * @see #getGeoTag()
	 * @generated
	 */
	EAttribute getGeoTag_Epsg();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.GeoTag#getDirectionAngle <em>Direction Angle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction Angle</em>'.
	 * @see org.bimserver.models.store.GeoTag#getDirectionAngle()
	 * @see #getGeoTag()
	 * @generated
	 */
	EAttribute getGeoTag_DirectionAngle();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Checkout <em>Checkout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Checkout</em>'.
	 * @see org.bimserver.models.store.Checkout
	 * @generated
	 */
	EClass getCheckout();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Checkout#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.store.Checkout#getUser()
	 * @see #getCheckout()
	 * @generated
	 */
	EReference getCheckout_User();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Checkout#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see org.bimserver.models.store.Checkout#getRevision()
	 * @see #getCheckout()
	 * @generated
	 */
	EReference getCheckout_Revision();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Checkout#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.store.Checkout#getProject()
	 * @see #getCheckout()
	 * @generated
	 */
	EReference getCheckout_Project();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Checkout#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.bimserver.models.store.Checkout#getDate()
	 * @see #getCheckout()
	 * @generated
	 */
	EAttribute getCheckout_Date();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Checkout#getCheckin <em>Checkin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Checkin</em>'.
	 * @see org.bimserver.models.store.Checkout#getCheckin()
	 * @see #getCheckout()
	 * @generated
	 */
	EReference getCheckout_Checkin();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Checkout#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see org.bimserver.models.store.Checkout#isActive()
	 * @see #getCheckout()
	 * @generated
	 */
	EAttribute getCheckout_Active();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Settings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Settings</em>'.
	 * @see org.bimserver.models.store.Settings
	 * @generated
	 */
	EClass getSettings();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#isShowVersionUpgradeAvailable <em>Show Version Upgrade Available</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Version Upgrade Available</em>'.
	 * @see org.bimserver.models.store.Settings#isShowVersionUpgradeAvailable()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_ShowVersionUpgradeAvailable();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#isSendConfirmationEmailAfterRegistration <em>Send Confirmation Email After Registration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Send Confirmation Email After Registration</em>'.
	 * @see org.bimserver.models.store.Settings#isSendConfirmationEmailAfterRegistration()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_SendConfirmationEmailAfterRegistration();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#isUseCaching <em>Use Caching</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Caching</em>'.
	 * @see org.bimserver.models.store.Settings#isUseCaching()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_UseCaching();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#isAllowSelfRegistration <em>Allow Self Registration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Self Registration</em>'.
	 * @see org.bimserver.models.store.Settings#isAllowSelfRegistration()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_AllowSelfRegistration();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#isAutoTestClashes <em>Auto Test Clashes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Test Clashes</em>'.
	 * @see org.bimserver.models.store.Settings#isAutoTestClashes()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_AutoTestClashes();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#isIntelligentMerging <em>Intelligent Merging</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intelligent Merging</em>'.
	 * @see org.bimserver.models.store.Settings#isIntelligentMerging()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_IntelligentMerging();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#isAllowUsersToCreateTopLevelProjects <em>Allow Users To Create Top Level Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Users To Create Top Level Projects</em>'.
	 * @see org.bimserver.models.store.Settings#isAllowUsersToCreateTopLevelProjects()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_AllowUsersToCreateTopLevelProjects();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#isCheckinMergingEnabled <em>Checkin Merging Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkin Merging Enabled</em>'.
	 * @see org.bimserver.models.store.Settings#isCheckinMergingEnabled()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_CheckinMergingEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#getRegistrationAddition <em>Registration Addition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Addition</em>'.
	 * @see org.bimserver.models.store.Settings#getRegistrationAddition()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_RegistrationAddition();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#getSmtpServer <em>Smtp Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp Server</em>'.
	 * @see org.bimserver.models.store.Settings#getSmtpServer()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_SmtpServer();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#getEmailSenderAddress <em>Email Sender Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email Sender Address</em>'.
	 * @see org.bimserver.models.store.Settings#getEmailSenderAddress()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_EmailSenderAddress();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#getEnabledExportTypes <em>Enabled Export Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Export Types</em>'.
	 * @see org.bimserver.models.store.Settings#getEnabledExportTypes()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_EnabledExportTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#getCustomLogoAddress <em>Custom Logo Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Logo Address</em>'.
	 * @see org.bimserver.models.store.Settings#getCustomLogoAddress()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_CustomLogoAddress();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#getSiteAddress <em>Site Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Site Address</em>'.
	 * @see org.bimserver.models.store.Settings#getSiteAddress()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_SiteAddress();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Settings#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Serializers</em>'.
	 * @see org.bimserver.models.store.Settings#getSerializers()
	 * @see #getSettings()
	 * @generated
	 */
	EReference getSettings_Serializers();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Settings#getGuidanceProviders <em>Guidance Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Guidance Providers</em>'.
	 * @see org.bimserver.models.store.Settings#getGuidanceProviders()
	 * @see #getSettings()
	 * @generated
	 */
	EReference getSettings_GuidanceProviders();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#getHeaderAddition <em>Header Addition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header Addition</em>'.
	 * @see org.bimserver.models.store.Settings#getHeaderAddition()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_HeaderAddition();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#getFooterAddition <em>Footer Addition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Footer Addition</em>'.
	 * @see org.bimserver.models.store.Settings#getFooterAddition()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_FooterAddition();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#getMergeIdentifier <em>Merge Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Merge Identifier</em>'.
	 * @see org.bimserver.models.store.Settings#getMergeIdentifier()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_MergeIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#isCacheOutputFiles <em>Cache Output Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cache Output Files</em>'.
	 * @see org.bimserver.models.store.Settings#isCacheOutputFiles()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_CacheOutputFiles();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Settings#getIfcEngines <em>Ifc Engines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ifc Engines</em>'.
	 * @see org.bimserver.models.store.Settings#getIfcEngines()
	 * @see #getSettings()
	 * @generated
	 */
	EReference getSettings_IfcEngines();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Settings#getPlugins <em>Plugins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Plugins</em>'.
	 * @see org.bimserver.models.store.Settings#getPlugins()
	 * @see #getSettings()
	 * @generated
	 */
	EReference getSettings_Plugins();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Serializer <em>Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Serializer</em>'.
	 * @see org.bimserver.models.store.Serializer
	 * @generated
	 */
	EClass getSerializer();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Serializer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.Serializer#getName()
	 * @see #getSerializer()
	 * @generated
	 */
	EAttribute getSerializer_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Serializer#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.Serializer#getDescription()
	 * @see #getSerializer()
	 * @generated
	 */
	EAttribute getSerializer_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Serializer#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.bimserver.models.store.Serializer#getExtension()
	 * @see #getSerializer()
	 * @generated
	 */
	EAttribute getSerializer_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Serializer#getContentType <em>Content Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Type</em>'.
	 * @see org.bimserver.models.store.Serializer#getContentType()
	 * @see #getSerializer()
	 * @generated
	 */
	EAttribute getSerializer_ContentType();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Serializer#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.bimserver.models.store.Serializer#getClassName()
	 * @see #getSerializer()
	 * @generated
	 */
	EAttribute getSerializer_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Serializer#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.bimserver.models.store.Serializer#isEnabled()
	 * @see #getSerializer()
	 * @generated
	 */
	EAttribute getSerializer_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Serializer#isDefaultSerializer <em>Default Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Serializer</em>'.
	 * @see org.bimserver.models.store.Serializer#isDefaultSerializer()
	 * @see #getSerializer()
	 * @generated
	 */
	EAttribute getSerializer_DefaultSerializer();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Serializer#getGuidanceProvider <em>Guidance Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Guidance Provider</em>'.
	 * @see org.bimserver.models.store.Serializer#getGuidanceProvider()
	 * @see #getSerializer()
	 * @generated
	 */
	EReference getSerializer_GuidanceProvider();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Serializer#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Settings</em>'.
	 * @see org.bimserver.models.store.Serializer#getSettings()
	 * @see #getSerializer()
	 * @generated
	 */
	EReference getSerializer_Settings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.GuidanceProvider <em>Guidance Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guidance Provider</em>'.
	 * @see org.bimserver.models.store.GuidanceProvider
	 * @generated
	 */
	EClass getGuidanceProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.GuidanceProvider#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.GuidanceProvider#getName()
	 * @see #getGuidanceProvider()
	 * @generated
	 */
	EAttribute getGuidanceProvider_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.GuidanceProvider#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.bimserver.models.store.GuidanceProvider#getClassName()
	 * @see #getGuidanceProvider()
	 * @generated
	 */
	EAttribute getGuidanceProvider_ClassName();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.GuidanceProvider#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Serializers</em>'.
	 * @see org.bimserver.models.store.GuidanceProvider#getSerializers()
	 * @see #getGuidanceProvider()
	 * @generated
	 */
	EReference getGuidanceProvider_Serializers();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.GuidanceProvider#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Settings</em>'.
	 * @see org.bimserver.models.store.GuidanceProvider#getSettings()
	 * @see #getGuidanceProvider()
	 * @generated
	 */
	EReference getGuidanceProvider_Settings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.IfcEngine <em>Ifc Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ifc Engine</em>'.
	 * @see org.bimserver.models.store.IfcEngine
	 * @generated
	 */
	EClass getIfcEngine();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.IfcEngine#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.IfcEngine#getName()
	 * @see #getIfcEngine()
	 * @generated
	 */
	EAttribute getIfcEngine_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.IfcEngine#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see org.bimserver.models.store.IfcEngine#isActive()
	 * @see #getIfcEngine()
	 * @generated
	 */
	EAttribute getIfcEngine_Active();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.IfcEngine#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Settings</em>'.
	 * @see org.bimserver.models.store.IfcEngine#getSettings()
	 * @see #getIfcEngine()
	 * @generated
	 */
	EReference getIfcEngine_Settings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Plugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin</em>'.
	 * @see org.bimserver.models.store.Plugin
	 * @generated
	 */
	EClass getPlugin();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Plugin#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.Plugin#getName()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Plugin#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.bimserver.models.store.Plugin#isEnabled()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_Enabled();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Plugin#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Settings</em>'.
	 * @see org.bimserver.models.store.Plugin#getSettings()
	 * @see #getPlugin()
	 * @generated
	 */
	EReference getPlugin_Settings();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.UserType <em>User Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>User Type</em>'.
	 * @see org.bimserver.models.store.UserType
	 * @generated
	 */
	EEnum getUserType();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.CheckinState <em>Checkin State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Checkin State</em>'.
	 * @see org.bimserver.models.store.CheckinState
	 * @generated
	 */
	EEnum getCheckinState();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.SIPrefix <em>SI Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SI Prefix</em>'.
	 * @see org.bimserver.models.store.SIPrefix
	 * @generated
	 */
	EEnum getSIPrefix();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.ObjectState <em>Object State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Object State</em>'.
	 * @see org.bimserver.models.store.ObjectState
	 * @generated
	 */
	EEnum getObjectState();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.MergeIdentifier <em>Merge Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Merge Identifier</em>'.
	 * @see org.bimserver.models.store.MergeIdentifier
	 * @generated
	 */
	EEnum getMergeIdentifier();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StoreFactory getStoreFactory();

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
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ProjectImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__ID = eINSTANCE.getProject_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Has Authorized Users</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__HAS_AUTHORIZED_USERS = eINSTANCE.getProject_HasAuthorizedUsers();

		/**
		 * The meta object literal for the '<em><b>Concrete Revisions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__CONCRETE_REVISIONS = eINSTANCE.getProject_ConcreteRevisions();

		/**
		 * The meta object literal for the '<em><b>Revisions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__REVISIONS = eINSTANCE.getProject_Revisions();

		/**
		 * The meta object literal for the '<em><b>Last Concrete Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__LAST_CONCRETE_REVISION = eINSTANCE.getProject_LastConcreteRevision();

		/**
		 * The meta object literal for the '<em><b>Last Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__LAST_REVISION = eINSTANCE.getProject_LastRevision();

		/**
		 * The meta object literal for the '<em><b>Checkouts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__CHECKOUTS = eINSTANCE.getProject_Checkouts();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__STATE = eINSTANCE.getProject_State();

		/**
		 * The meta object literal for the '<em><b>Created Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__CREATED_DATE = eINSTANCE.getProject_CreatedDate();

		/**
		 * The meta object literal for the '<em><b>Created By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__CREATED_BY = eINSTANCE.getProject_CreatedBy();

		/**
		 * The meta object literal for the '<em><b>Geo Tag</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__GEO_TAG = eINSTANCE.getProject_GeoTag();

		/**
		 * The meta object literal for the '<em><b>Sub Projects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__SUB_PROJECTS = eINSTANCE.getProject_SubProjects();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__PARENT = eINSTANCE.getProject_Parent();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__DESCRIPTION = eINSTANCE.getProject_Description();

		/**
		 * The meta object literal for the '<em><b>Clash Detection Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__CLASH_DETECTION_SETTINGS = eINSTANCE.getProject_ClashDetectionSettings();

		/**
		 * The meta object literal for the '<em><b>Export Length Measure Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__EXPORT_LENGTH_MEASURE_PREFIX = eINSTANCE.getProject_ExportLengthMeasurePrefix();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.UserImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__NAME = eINSTANCE.getUser_Name();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__PASSWORD = eINSTANCE.getUser_Password();

		/**
		 * The meta object literal for the '<em><b>Has Rights On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__HAS_RIGHTS_ON = eINSTANCE.getUser_HasRightsOn();

		/**
		 * The meta object literal for the '<em><b>Revisions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__REVISIONS = eINSTANCE.getUser_Revisions();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__STATE = eINSTANCE.getUser_State();

		/**
		 * The meta object literal for the '<em><b>Created On</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__CREATED_ON = eINSTANCE.getUser_CreatedOn();

		/**
		 * The meta object literal for the '<em><b>Created By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__CREATED_BY = eINSTANCE.getUser_CreatedBy();

		/**
		 * The meta object literal for the '<em><b>User Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__USER_TYPE = eINSTANCE.getUser_UserType();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__USERNAME = eINSTANCE.getUser_Username();

		/**
		 * The meta object literal for the '<em><b>Last Seen</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__LAST_SEEN = eINSTANCE.getUser_LastSeen();

		/**
		 * The meta object literal for the '<em><b>Validation Token</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__VALIDATION_TOKEN = eINSTANCE.getUser_ValidationToken();

		/**
		 * The meta object literal for the '<em><b>Validation Token Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__VALIDATION_TOKEN_CREATED = eINSTANCE.getUser_ValidationTokenCreated();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ClashImpl <em>Clash</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ClashImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getClash()
		 * @generated
		 */
		EClass CLASH = eINSTANCE.getClash();

		/**
		 * The meta object literal for the '<em><b>Name1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASH__NAME1 = eINSTANCE.getClash_Name1();

		/**
		 * The meta object literal for the '<em><b>Name2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASH__NAME2 = eINSTANCE.getClash_Name2();

		/**
		 * The meta object literal for the '<em><b>Type1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASH__TYPE1 = eINSTANCE.getClash_Type1();

		/**
		 * The meta object literal for the '<em><b>Type2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASH__TYPE2 = eINSTANCE.getClash_Type2();

		/**
		 * The meta object literal for the '<em><b>Revision1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASH__REVISION1 = eINSTANCE.getClash_Revision1();

		/**
		 * The meta object literal for the '<em><b>Revision2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASH__REVISION2 = eINSTANCE.getClash_Revision2();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.EidClashImpl <em>Eid Clash</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.EidClashImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getEidClash()
		 * @generated
		 */
		EClass EID_CLASH = eINSTANCE.getEidClash();

		/**
		 * The meta object literal for the '<em><b>Eid1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EID_CLASH__EID1 = eINSTANCE.getEidClash_Eid1();

		/**
		 * The meta object literal for the '<em><b>Eid2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EID_CLASH__EID2 = eINSTANCE.getEidClash_Eid2();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.GuidClashImpl <em>Guid Clash</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.GuidClashImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getGuidClash()
		 * @generated
		 */
		EClass GUID_CLASH = eINSTANCE.getGuidClash();

		/**
		 * The meta object literal for the '<em><b>Guid1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUID_CLASH__GUID1 = eINSTANCE.getGuidClash_Guid1();

		/**
		 * The meta object literal for the '<em><b>Guid2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUID_CLASH__GUID2 = eINSTANCE.getGuidClash_Guid2();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ClashDetectionSettingsImpl <em>Clash Detection Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ClashDetectionSettingsImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getClashDetectionSettings()
		 * @generated
		 */
		EClass CLASH_DETECTION_SETTINGS = eINSTANCE.getClashDetectionSettings();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASH_DETECTION_SETTINGS__ENABLED = eINSTANCE.getClashDetectionSettings_Enabled();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASH_DETECTION_SETTINGS__PROJECTS = eINSTANCE.getClashDetectionSettings_Projects();

		/**
		 * The meta object literal for the '<em><b>Margin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASH_DETECTION_SETTINGS__MARGIN = eINSTANCE.getClashDetectionSettings_Margin();

		/**
		 * The meta object literal for the '<em><b>Revisions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASH_DETECTION_SETTINGS__REVISIONS = eINSTANCE.getClashDetectionSettings_Revisions();

		/**
		 * The meta object literal for the '<em><b>Ignored Classes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASH_DETECTION_SETTINGS__IGNORED_CLASSES = eINSTANCE.getClashDetectionSettings_IgnoredClasses();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.RevisionImpl <em>Revision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.RevisionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getRevision()
		 * @generated
		 */
		EClass REVISION = eINSTANCE.getRevision();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__ID = eINSTANCE.getRevision_Id();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__USER = eINSTANCE.getRevision_User();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__DATE = eINSTANCE.getRevision_Date();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__COMMENT = eINSTANCE.getRevision_Comment();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__SIZE = eINSTANCE.getRevision_Size();

		/**
		 * The meta object literal for the '<em><b>Concrete Revisions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__CONCRETE_REVISIONS = eINSTANCE.getRevision_ConcreteRevisions();

		/**
		 * The meta object literal for the '<em><b>Last Concrete Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__LAST_CONCRETE_REVISION = eINSTANCE.getRevision_LastConcreteRevision();

		/**
		 * The meta object literal for the '<em><b>Checkouts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__CHECKOUTS = eINSTANCE.getRevision_Checkouts();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__PROJECT = eINSTANCE.getRevision_Project();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__STATE = eINSTANCE.getRevision_State();

		/**
		 * The meta object literal for the '<em><b>Last Clashes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__LAST_CLASHES = eINSTANCE.getRevision_LastClashes();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__TAG = eINSTANCE.getRevision_Tag();

		/**
		 * The meta object literal for the '<em><b>Last Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__LAST_ERROR = eINSTANCE.getRevision_LastError();

		/**
		 * The meta object literal for the '<em><b>Bmi</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__BMI = eINSTANCE.getRevision_Bmi();

		/**
		 * The meta object literal for the '<em><b>Nr Clashes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__NR_CLASHES = eINSTANCE.getRevision_NrClashes();

		/**
		 * The meta object literal for the '<em><b>Laid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__LAID = eINSTANCE.getRevision_Laid();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ConcreteRevisionImpl <em>Concrete Revision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ConcreteRevisionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getConcreteRevision()
		 * @generated
		 */
		EClass CONCRETE_REVISION = eINSTANCE.getConcreteRevision();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_REVISION__ID = eINSTANCE.getConcreteRevision_Id();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_REVISION__PROJECT = eINSTANCE.getConcreteRevision_Project();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_REVISION__STATE = eINSTANCE.getConcreteRevision_State();

		/**
		 * The meta object literal for the '<em><b>Checksum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_REVISION__CHECKSUM = eINSTANCE.getConcreteRevision_Checksum();

		/**
		 * The meta object literal for the '<em><b>Revisions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_REVISION__REVISIONS = eINSTANCE.getConcreteRevision_Revisions();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_REVISION__SIZE = eINSTANCE.getConcreteRevision_Size();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_REVISION__DATE = eINSTANCE.getConcreteRevision_Date();

		/**
		 * The meta object literal for the '<em><b>Last Error</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_REVISION__LAST_ERROR = eINSTANCE.getConcreteRevision_LastError();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.GeoTagImpl <em>Geo Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.GeoTagImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getGeoTag()
		 * @generated
		 */
		EClass GEO_TAG = eINSTANCE.getGeoTag();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEO_TAG__ENABLED = eINSTANCE.getGeoTag_Enabled();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEO_TAG__PROJECTS = eINSTANCE.getGeoTag_Projects();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEO_TAG__X = eINSTANCE.getGeoTag_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEO_TAG__Y = eINSTANCE.getGeoTag_Y();

		/**
		 * The meta object literal for the '<em><b>Z</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEO_TAG__Z = eINSTANCE.getGeoTag_Z();

		/**
		 * The meta object literal for the '<em><b>Epsg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEO_TAG__EPSG = eINSTANCE.getGeoTag_Epsg();

		/**
		 * The meta object literal for the '<em><b>Direction Angle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEO_TAG__DIRECTION_ANGLE = eINSTANCE.getGeoTag_DirectionAngle();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.CheckoutImpl <em>Checkout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.CheckoutImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getCheckout()
		 * @generated
		 */
		EClass CHECKOUT = eINSTANCE.getCheckout();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECKOUT__USER = eINSTANCE.getCheckout_User();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECKOUT__REVISION = eINSTANCE.getCheckout_Revision();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECKOUT__PROJECT = eINSTANCE.getCheckout_Project();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECKOUT__DATE = eINSTANCE.getCheckout_Date();

		/**
		 * The meta object literal for the '<em><b>Checkin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECKOUT__CHECKIN = eINSTANCE.getCheckout_Checkin();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECKOUT__ACTIVE = eINSTANCE.getCheckout_Active();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.SettingsImpl <em>Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.SettingsImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getSettings()
		 * @generated
		 */
		EClass SETTINGS = eINSTANCE.getSettings();

		/**
		 * The meta object literal for the '<em><b>Show Version Upgrade Available</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__SHOW_VERSION_UPGRADE_AVAILABLE = eINSTANCE.getSettings_ShowVersionUpgradeAvailable();

		/**
		 * The meta object literal for the '<em><b>Send Confirmation Email After Registration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__SEND_CONFIRMATION_EMAIL_AFTER_REGISTRATION = eINSTANCE.getSettings_SendConfirmationEmailAfterRegistration();

		/**
		 * The meta object literal for the '<em><b>Use Caching</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__USE_CACHING = eINSTANCE.getSettings_UseCaching();

		/**
		 * The meta object literal for the '<em><b>Allow Self Registration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__ALLOW_SELF_REGISTRATION = eINSTANCE.getSettings_AllowSelfRegistration();

		/**
		 * The meta object literal for the '<em><b>Auto Test Clashes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__AUTO_TEST_CLASHES = eINSTANCE.getSettings_AutoTestClashes();

		/**
		 * The meta object literal for the '<em><b>Intelligent Merging</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__INTELLIGENT_MERGING = eINSTANCE.getSettings_IntelligentMerging();

		/**
		 * The meta object literal for the '<em><b>Allow Users To Create Top Level Projects</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__ALLOW_USERS_TO_CREATE_TOP_LEVEL_PROJECTS = eINSTANCE.getSettings_AllowUsersToCreateTopLevelProjects();

		/**
		 * The meta object literal for the '<em><b>Checkin Merging Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__CHECKIN_MERGING_ENABLED = eINSTANCE.getSettings_CheckinMergingEnabled();

		/**
		 * The meta object literal for the '<em><b>Registration Addition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__REGISTRATION_ADDITION = eINSTANCE.getSettings_RegistrationAddition();

		/**
		 * The meta object literal for the '<em><b>Smtp Server</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__SMTP_SERVER = eINSTANCE.getSettings_SmtpServer();

		/**
		 * The meta object literal for the '<em><b>Email Sender Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__EMAIL_SENDER_ADDRESS = eINSTANCE.getSettings_EmailSenderAddress();

		/**
		 * The meta object literal for the '<em><b>Enabled Export Types</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__ENABLED_EXPORT_TYPES = eINSTANCE.getSettings_EnabledExportTypes();

		/**
		 * The meta object literal for the '<em><b>Custom Logo Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__CUSTOM_LOGO_ADDRESS = eINSTANCE.getSettings_CustomLogoAddress();

		/**
		 * The meta object literal for the '<em><b>Site Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__SITE_ADDRESS = eINSTANCE.getSettings_SiteAddress();

		/**
		 * The meta object literal for the '<em><b>Serializers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTINGS__SERIALIZERS = eINSTANCE.getSettings_Serializers();

		/**
		 * The meta object literal for the '<em><b>Guidance Providers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTINGS__GUIDANCE_PROVIDERS = eINSTANCE.getSettings_GuidanceProviders();

		/**
		 * The meta object literal for the '<em><b>Header Addition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__HEADER_ADDITION = eINSTANCE.getSettings_HeaderAddition();

		/**
		 * The meta object literal for the '<em><b>Footer Addition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__FOOTER_ADDITION = eINSTANCE.getSettings_FooterAddition();

		/**
		 * The meta object literal for the '<em><b>Merge Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__MERGE_IDENTIFIER = eINSTANCE.getSettings_MergeIdentifier();

		/**
		 * The meta object literal for the '<em><b>Cache Output Files</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__CACHE_OUTPUT_FILES = eINSTANCE.getSettings_CacheOutputFiles();

		/**
		 * The meta object literal for the '<em><b>Ifc Engines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTINGS__IFC_ENGINES = eINSTANCE.getSettings_IfcEngines();

		/**
		 * The meta object literal for the '<em><b>Plugins</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTINGS__PLUGINS = eINSTANCE.getSettings_Plugins();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.SerializerImpl <em>Serializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.SerializerImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getSerializer()
		 * @generated
		 */
		EClass SERIALIZER = eINSTANCE.getSerializer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER__NAME = eINSTANCE.getSerializer_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER__DESCRIPTION = eINSTANCE.getSerializer_Description();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER__EXTENSION = eINSTANCE.getSerializer_Extension();

		/**
		 * The meta object literal for the '<em><b>Content Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER__CONTENT_TYPE = eINSTANCE.getSerializer_ContentType();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER__CLASS_NAME = eINSTANCE.getSerializer_ClassName();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER__ENABLED = eINSTANCE.getSerializer_Enabled();

		/**
		 * The meta object literal for the '<em><b>Default Serializer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER__DEFAULT_SERIALIZER = eINSTANCE.getSerializer_DefaultSerializer();

		/**
		 * The meta object literal for the '<em><b>Guidance Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERIALIZER__GUIDANCE_PROVIDER = eINSTANCE.getSerializer_GuidanceProvider();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERIALIZER__SETTINGS = eINSTANCE.getSerializer_Settings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.GuidanceProviderImpl <em>Guidance Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.GuidanceProviderImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getGuidanceProvider()
		 * @generated
		 */
		EClass GUIDANCE_PROVIDER = eINSTANCE.getGuidanceProvider();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUIDANCE_PROVIDER__NAME = eINSTANCE.getGuidanceProvider_Name();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUIDANCE_PROVIDER__CLASS_NAME = eINSTANCE.getGuidanceProvider_ClassName();

		/**
		 * The meta object literal for the '<em><b>Serializers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUIDANCE_PROVIDER__SERIALIZERS = eINSTANCE.getGuidanceProvider_Serializers();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUIDANCE_PROVIDER__SETTINGS = eINSTANCE.getGuidanceProvider_Settings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.IfcEngineImpl <em>Ifc Engine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.IfcEngineImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getIfcEngine()
		 * @generated
		 */
		EClass IFC_ENGINE = eINSTANCE.getIfcEngine();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFC_ENGINE__NAME = eINSTANCE.getIfcEngine_Name();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFC_ENGINE__ACTIVE = eINSTANCE.getIfcEngine_Active();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IFC_ENGINE__SETTINGS = eINSTANCE.getIfcEngine_Settings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.PluginImpl <em>Plugin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.PluginImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getPlugin()
		 * @generated
		 */
		EClass PLUGIN = eINSTANCE.getPlugin();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__NAME = eINSTANCE.getPlugin_Name();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__ENABLED = eINSTANCE.getPlugin_Enabled();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUGIN__SETTINGS = eINSTANCE.getPlugin_Settings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.UserType <em>User Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.UserType
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getUserType()
		 * @generated
		 */
		EEnum USER_TYPE = eINSTANCE.getUserType();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.CheckinState <em>Checkin State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.CheckinState
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getCheckinState()
		 * @generated
		 */
		EEnum CHECKIN_STATE = eINSTANCE.getCheckinState();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.SIPrefix <em>SI Prefix</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.SIPrefix
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getSIPrefix()
		 * @generated
		 */
		EEnum SI_PREFIX = eINSTANCE.getSIPrefix();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.ObjectState <em>Object State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.ObjectState
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectState()
		 * @generated
		 */
		EEnum OBJECT_STATE = eINSTANCE.getObjectState();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.MergeIdentifier <em>Merge Identifier</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.MergeIdentifier
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getMergeIdentifier()
		 * @generated
		 */
		EEnum MERGE_IDENTIFIER = eINSTANCE.getMergeIdentifier();

	}

} //StorePackage
