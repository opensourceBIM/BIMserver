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
package org.bimserver.models.store;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
	 * The feature id for the '<em><b>Notification Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NOTIFICATION_URL = 12;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 13;

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
	 * The feature id for the '<em><b>Hide User List For Non Admin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__HIDE_USER_LIST_FOR_NON_ADMIN = 14;

	/**
	 * The feature id for the '<em><b>Serializers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__SERIALIZERS = 15;

	/**
	 * The feature id for the '<em><b>Object ID Ms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__OBJECT_ID_MS = 16;

	/**
	 * The feature id for the '<em><b>Header Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__HEADER_ADDITION = 17;

	/**
	 * The feature id for the '<em><b>Footer Addition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__FOOTER_ADDITION = 18;

	/**
	 * The feature id for the '<em><b>Merge Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__MERGE_IDENTIFIER = 19;

	/**
	 * The feature id for the '<em><b>Cache Output Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__CACHE_OUTPUT_FILES = 20;

	/**
	 * The feature id for the '<em><b>Ifc Engines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__IFC_ENGINES = 21;

	/**
	 * The feature id for the '<em><b>Plugins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__PLUGINS = 22;

	/**
	 * The feature id for the '<em><b>Deserializers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS__DESERIALIZERS = 23;

	/**
	 * The number of structural features of the '<em>Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_FEATURE_COUNT = 24;

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
	 * The feature id for the '<em><b>Object IDM</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER__OBJECT_IDM = 7;

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
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ObjectIDMImpl <em>Object IDM</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ObjectIDMImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectIDM()
	 * @generated
	 */
	int OBJECT_IDM = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM__CLASS_NAME = 1;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM__ENABLED = 2;

	/**
	 * The feature id for the '<em><b>Serializers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM__SERIALIZERS = 3;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM__SETTINGS = 4;

	/**
	 * The number of structural features of the '<em>Object IDM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM_FEATURE_COUNT = 5;

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
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DeserializerImpl <em>Deserializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DeserializerImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDeserializer()
	 * @generated
	 */
	int DESERIALIZER = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER__CLASS_NAME = 2;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER__ENABLED = 3;

	/**
	 * The feature id for the '<em><b>Default Deserializer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER__DEFAULT_DESERIALIZER = 4;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER__SETTINGS = 5;

	/**
	 * The number of structural features of the '<em>Deserializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.CheckinResultImpl <em>Checkin Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.CheckinResultImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCheckinResult()
	 * @generated
	 */
	int CHECKIN_RESULT = 16;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKIN_RESULT__REVISION = 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKIN_RESULT__PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKIN_RESULT__PROGRESS = 2;

	/**
	 * The number of structural features of the '<em>Checkin Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKIN_RESULT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DownloadResultImpl <em>Download Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DownloadResultImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDownloadResult()
	 * @generated
	 */
	int DOWNLOAD_RESULT = 17;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_RESULT__PROJECT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Revision Nr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_RESULT__REVISION_NR = 1;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_RESULT__FILE = 2;

	/**
	 * The number of structural features of the '<em>Download Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_RESULT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.CheckoutResultImpl <em>Checkout Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.CheckoutResultImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCheckoutResult()
	 * @generated
	 */
	int CHECKOUT_RESULT = 18;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_RESULT__PROJECT_NAME = DOWNLOAD_RESULT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Revision Nr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_RESULT__REVISION_NR = DOWNLOAD_RESULT__REVISION_NR;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_RESULT__FILE = DOWNLOAD_RESULT__FILE;

	/**
	 * The number of structural features of the '<em>Checkout Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_RESULT_FEATURE_COUNT = DOWNLOAD_RESULT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DataValueImpl <em>Data Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DataValueImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDataValue()
	 * @generated
	 */
	int DATA_VALUE = 19;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VALUE__FIELD_NAME = 0;

	/**
	 * The number of structural features of the '<em>Data Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VALUE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DataObjectImpl <em>Data Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DataObjectImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDataObject()
	 * @generated
	 */
	int DATA_OBJECT = 20;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__GUID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__NAME = 2;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__VALUES = 3;

	/**
	 * The number of structural features of the '<em>Data Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.UserSessionImpl <em>User Session</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.UserSessionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getUserSession()
	 * @generated
	 */
	int USER_SESSION = 21;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SESSION__USER = 0;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SESSION__USERNAME = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SESSION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SESSION__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Remote Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SESSION__REMOTE_ADDRESS = 4;

	/**
	 * The feature id for the '<em><b>Active Since</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SESSION__ACTIVE_SINCE = 5;

	/**
	 * The feature id for the '<em><b>Last Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SESSION__LAST_ACTIVE = 6;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SESSION__ACCESS_METHOD = 7;

	/**
	 * The number of structural features of the '<em>User Session</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SESSION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.MigrationImpl <em>Migration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.MigrationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getMigration()
	 * @generated
	 */
	int MIGRATION = 22;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION__NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Executed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION__EXECUTED = 2;

	/**
	 * The number of structural features of the '<em>Migration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ReferenceDataValueImpl <em>Reference Data Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ReferenceDataValueImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getReferenceDataValue()
	 * @generated
	 */
	int REFERENCE_DATA_VALUE = 23;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_DATA_VALUE__FIELD_NAME = DATA_VALUE__FIELD_NAME;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_DATA_VALUE__TYPE_NAME = DATA_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_DATA_VALUE__GUID = DATA_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference Data Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_DATA_VALUE_FEATURE_COUNT = DATA_VALUE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ListDataValueImpl <em>List Data Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ListDataValueImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getListDataValue()
	 * @generated
	 */
	int LIST_DATA_VALUE = 24;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_DATA_VALUE__FIELD_NAME = DATA_VALUE__FIELD_NAME;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_DATA_VALUE__VALUES = DATA_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Data Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_DATA_VALUE_FEATURE_COUNT = DATA_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.SimpleDataValueImpl <em>Simple Data Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.SimpleDataValueImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getSimpleDataValue()
	 * @generated
	 */
	int SIMPLE_DATA_VALUE = 25;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_VALUE__FIELD_NAME = DATA_VALUE__FIELD_NAME;

	/**
	 * The feature id for the '<em><b>String Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_VALUE__STRING_VALUE = DATA_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Data Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DATA_VALUE_FEATURE_COUNT = DATA_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DatabaseInformationItemImpl <em>Database Information Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DatabaseInformationItemImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDatabaseInformationItem()
	 * @generated
	 */
	int DATABASE_INFORMATION_ITEM = 26;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION_ITEM__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION_ITEM__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Database Information Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION_ITEM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DatabaseInformationCategoryImpl <em>Database Information Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DatabaseInformationCategoryImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDatabaseInformationCategory()
	 * @generated
	 */
	int DATABASE_INFORMATION_CATEGORY = 27;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION_CATEGORY__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION_CATEGORY__ITEMS = 1;

	/**
	 * The number of structural features of the '<em>Database Information Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION_CATEGORY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DatabaseInformationImpl <em>Database Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DatabaseInformationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDatabaseInformation()
	 * @generated
	 */
	int DATABASE_INFORMATION = 28;

	/**
	 * The feature id for the '<em><b>Number Of Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION__NUMBER_OF_PROJECTS = 0;

	/**
	 * The feature id for the '<em><b>Number Of Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION__NUMBER_OF_USERS = 1;

	/**
	 * The feature id for the '<em><b>Number Of Revisions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION__NUMBER_OF_REVISIONS = 2;

	/**
	 * The feature id for the '<em><b>Number Of Checkouts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION__NUMBER_OF_CHECKOUTS = 3;

	/**
	 * The feature id for the '<em><b>Database Size In Bytes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION__DATABASE_SIZE_IN_BYTES = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION__TYPE = 5;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION__CREATED = 6;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION__LOCATION = 7;

	/**
	 * The feature id for the '<em><b>Schema Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION__SCHEMA_VERSION = 8;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION__CATEGORIES = 9;

	/**
	 * The number of structural features of the '<em>Database Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_INFORMATION_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.SerializerPluginDescriptorImpl <em>Serializer Plugin Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.SerializerPluginDescriptorImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getSerializerPluginDescriptor()
	 * @generated
	 */
	int SERIALIZER_PLUGIN_DESCRIPTOR = 29;

	/**
	 * The feature id for the '<em><b>Plugin Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Default Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_NAME = 1;

	/**
	 * The feature id for the '<em><b>Default Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_EXTENSION = 2;

	/**
	 * The feature id for the '<em><b>Default Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_CONTENT_TYPE = 3;

	/**
	 * The number of structural features of the '<em>Serializer Plugin Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_DESCRIPTOR_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DeserializerPluginDescriptorImpl <em>Deserializer Plugin Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DeserializerPluginDescriptorImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDeserializerPluginDescriptor()
	 * @generated
	 */
	int DESERIALIZER_PLUGIN_DESCRIPTOR = 30;

	/**
	 * The feature id for the '<em><b>Plugin Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER_PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Default Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_NAME = 1;

	/**
	 * The number of structural features of the '<em>Deserializer Plugin Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER_PLUGIN_DESCRIPTOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.RevisionSummaryTypeImpl <em>Revision Summary Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.RevisionSummaryTypeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getRevisionSummaryType()
	 * @generated
	 */
	int REVISION_SUMMARY_TYPE = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_SUMMARY_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_SUMMARY_TYPE__COUNT = 1;

	/**
	 * The number of structural features of the '<em>Revision Summary Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_SUMMARY_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.RevisionSummaryContainerImpl <em>Revision Summary Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.RevisionSummaryContainerImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getRevisionSummaryContainer()
	 * @generated
	 */
	int REVISION_SUMMARY_CONTAINER = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_SUMMARY_CONTAINER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_SUMMARY_CONTAINER__TYPES = 1;

	/**
	 * The number of structural features of the '<em>Revision Summary Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_SUMMARY_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.RevisionSummaryImpl <em>Revision Summary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.RevisionSummaryImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getRevisionSummary()
	 * @generated
	 */
	int REVISION_SUMMARY = 33;

	/**
	 * The feature id for the '<em><b>List</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_SUMMARY__LIST = 0;

	/**
	 * The number of structural features of the '<em>Revision Summary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_SUMMARY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.PluginDescriptorImpl <em>Plugin Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.PluginDescriptorImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginDescriptor()
	 * @generated
	 */
	int PLUGIN_DESCRIPTOR = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__ENABLED = 3;

	/**
	 * The number of structural features of the '<em>Plugin Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.LongActionImpl <em>Long Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.LongActionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getLongAction()
	 * @generated
	 */
	int LONG_ACTION = 35;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION__IDENTIFICATION = 0;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION__USER = 1;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION__START = 2;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION__USERNAME = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION__NAME = 4;

	/**
	 * The number of structural features of the '<em>Long Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.LongCheckinActionImpl <em>Long Checkin Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.LongCheckinActionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getLongCheckinAction()
	 * @generated
	 */
	int LONG_CHECKIN_ACTION = 36;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION__IDENTIFICATION = LONG_ACTION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION__USER = LONG_ACTION__USER;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION__START = LONG_ACTION__START;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION__USERNAME = LONG_ACTION__USERNAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION__NAME = LONG_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Revisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION__REVISIONS = LONG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Long Checkin Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_FEATURE_COUNT = LONG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ObjectIDMPluginDescriptorImpl <em>Object IDM Plugin Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ObjectIDMPluginDescriptorImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectIDMPluginDescriptor()
	 * @generated
	 */
	int OBJECT_IDM_PLUGIN_DESCRIPTOR = 37;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM_PLUGIN_DESCRIPTOR__CLASS_NAME = 0;

	/**
	 * The number of structural features of the '<em>Object IDM Plugin Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM_PLUGIN_DESCRIPTOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.CompareItemImpl <em>Compare Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.CompareItemImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompareItem()
	 * @generated
	 */
	int COMPARE_ITEM = 38;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_ITEM__DATA_OBJECT = 0;

	/**
	 * The number of structural features of the '<em>Compare Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_ITEM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ObjectAddedImpl <em>Object Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ObjectAddedImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectAdded()
	 * @generated
	 */
	int OBJECT_ADDED = 39;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ADDED__DATA_OBJECT = COMPARE_ITEM__DATA_OBJECT;

	/**
	 * The number of structural features of the '<em>Object Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ADDED_FEATURE_COUNT = COMPARE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ObjectRemovedImpl <em>Object Removed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ObjectRemovedImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectRemoved()
	 * @generated
	 */
	int OBJECT_REMOVED = 40;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REMOVED__DATA_OBJECT = COMPARE_ITEM__DATA_OBJECT;

	/**
	 * The number of structural features of the '<em>Object Removed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REMOVED_FEATURE_COUNT = COMPARE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ObjectModifiedImpl <em>Object Modified</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ObjectModifiedImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectModified()
	 * @generated
	 */
	int OBJECT_MODIFIED = 41;

	/**
	 * The feature id for the '<em><b>Data Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_MODIFIED__DATA_OBJECT = COMPARE_ITEM__DATA_OBJECT;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_MODIFIED__FIELD_NAME = COMPARE_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_MODIFIED__OLD_VALUE = COMPARE_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_MODIFIED__NEW_VALUE = COMPARE_ITEM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Object Modified</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_MODIFIED_FEATURE_COUNT = COMPARE_ITEM_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.CompareContainerImpl <em>Compare Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.CompareContainerImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompareContainer()
	 * @generated
	 */
	int COMPARE_CONTAINER = 42;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_CONTAINER__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_CONTAINER__ITEMS = 1;

	/**
	 * The number of structural features of the '<em>Compare Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.CompareResultImpl <em>Compare Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.CompareResultImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompareResult()
	 * @generated
	 */
	int COMPARE_RESULT = 43;

	/**
	 * The feature id for the '<em><b>Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_RESULT__ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Compare Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_RESULT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.LongActionStateImpl <em>Long Action State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.LongActionStateImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getLongActionState()
	 * @generated
	 */
	int LONG_ACTION_STATE = 44;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE__PROGRESS = 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE__STATE = 1;

	/**
	 * The number of structural features of the '<em>Long Action State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.NotificationImpl <em>Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.NotificationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getNotification()
	 * @generated
	 */
	int NOTIFICATION = 45;

	/**
	 * The number of structural features of the '<em>Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.NewProjectNotificationImpl <em>New Project Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.NewProjectNotificationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getNewProjectNotification()
	 * @generated
	 */
	int NEW_PROJECT_NOTIFICATION = 46;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_NOTIFICATION__PROJECT = NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Project Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_NOTIFICATION_FEATURE_COUNT = NOTIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.NewRevisionNotificationImpl <em>New Revision Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.NewRevisionNotificationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getNewRevisionNotification()
	 * @generated
	 */
	int NEW_REVISION_NOTIFICATION = 47;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_NOTIFICATION__REVISION = NOTIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Revision Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_NOTIFICATION_FEATURE_COUNT = NOTIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.CompileResultImpl <em>Compile Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.CompileResultImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompileResult()
	 * @generated
	 */
	int COMPILE_RESULT = 48;

	/**
	 * The feature id for the '<em><b>Compile Oke</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILE_RESULT__COMPILE_OKE = 0;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILE_RESULT__WARNINGS = 1;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILE_RESULT__ERRORS = 2;

	/**
	 * The number of structural features of the '<em>Compile Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILE_RESULT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.RunResultImpl <em>Run Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.RunResultImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getRunResult()
	 * @generated
	 */
	int RUN_RESULT = 49;

	/**
	 * The feature id for the '<em><b>Run Oke</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_RESULT__RUN_OKE = 0;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_RESULT__WARNINGS = 1;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_RESULT__ERRORS = 2;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_RESULT__OUTPUT = 3;

	/**
	 * The number of structural features of the '<em>Run Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_RESULT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ServerInfoImpl <em>Server Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ServerInfoImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServerInfo()
	 * @generated
	 */
	int SERVER_INFO = 50;

	/**
	 * The feature id for the '<em><b>Server State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__SERVER_STATE = 0;

	/**
	 * The feature id for the '<em><b>Error Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__ERROR_MESSAGE = 1;

	/**
	 * The number of structural features of the '<em>Server Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.VersionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 51;

	/**
	 * The feature id for the '<em><b>Major</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__MAJOR = 0;

	/**
	 * The feature id for the '<em><b>Minor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__MINOR = 1;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__REVISION = 2;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__DATE = 3;

	/**
	 * The feature id for the '<em><b>Download Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__DOWNLOAD_URL = 4;

	/**
	 * The feature id for the '<em><b>Support Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__SUPPORT_URL = 5;

	/**
	 * The feature id for the '<em><b>Support Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__SUPPORT_EMAIL = 6;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.UserType <em>User Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.UserType
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getUserType()
	 * @generated
	 */
	int USER_TYPE = 52;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.CheckinState <em>Checkin State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.CheckinState
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCheckinState()
	 * @generated
	 */
	int CHECKIN_STATE = 53;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.SIPrefix <em>SI Prefix</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.SIPrefix
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getSIPrefix()
	 * @generated
	 */
	int SI_PREFIX = 54;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.ObjectState <em>Object State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.ObjectState
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectState()
	 * @generated
	 */
	int OBJECT_STATE = 55;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.MergeIdentifier <em>Merge Identifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.MergeIdentifier
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getMergeIdentifier()
	 * @generated
	 */
	int MERGE_IDENTIFIER = 56;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.CompareIdentifier <em>Compare Identifier</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.CompareIdentifier
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompareIdentifier()
	 * @generated
	 */
	int COMPARE_IDENTIFIER = 57;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.CompareType <em>Compare Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.CompareType
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompareType()
	 * @generated
	 */
	int COMPARE_TYPE = 58;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.ActionState <em>Action State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.ActionState
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getActionState()
	 * @generated
	 */
	int ACTION_STATE = 59;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.ServerState <em>Server State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.ServerState
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServerState()
	 * @generated
	 */
	int SERVER_STATE = 60;

	/**
	 * The meta object id for the '<em>Data Handler</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.activation.DataHandler
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDataHandler()
	 * @generated
	 */
	int DATA_HANDLER = 61;

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getNotificationUrl <em>Notification Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Notification Url</em>'.
	 * @see org.bimserver.models.store.User#getNotificationUrl()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_NotificationUrl();

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Settings#isHideUserListForNonAdmin <em>Hide User List For Non Admin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide User List For Non Admin</em>'.
	 * @see org.bimserver.models.store.Settings#isHideUserListForNonAdmin()
	 * @see #getSettings()
	 * @generated
	 */
	EAttribute getSettings_HideUserListForNonAdmin();

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
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Settings#getObjectIDMs <em>Object ID Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Object ID Ms</em>'.
	 * @see org.bimserver.models.store.Settings#getObjectIDMs()
	 * @see #getSettings()
	 * @generated
	 */
	EReference getSettings_ObjectIDMs();

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
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Settings#getDeserializers <em>Deserializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Deserializers</em>'.
	 * @see org.bimserver.models.store.Settings#getDeserializers()
	 * @see #getSettings()
	 * @generated
	 */
	EReference getSettings_Deserializers();

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
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Serializer#getObjectIDM <em>Object IDM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object IDM</em>'.
	 * @see org.bimserver.models.store.Serializer#getObjectIDM()
	 * @see #getSerializer()
	 * @generated
	 */
	EReference getSerializer_ObjectIDM();

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
	 * Returns the meta object for class '{@link org.bimserver.models.store.ObjectIDM <em>Object IDM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object IDM</em>'.
	 * @see org.bimserver.models.store.ObjectIDM
	 * @generated
	 */
	EClass getObjectIDM();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ObjectIDM#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ObjectIDM#getName()
	 * @see #getObjectIDM()
	 * @generated
	 */
	EAttribute getObjectIDM_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ObjectIDM#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.bimserver.models.store.ObjectIDM#getClassName()
	 * @see #getObjectIDM()
	 * @generated
	 */
	EAttribute getObjectIDM_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ObjectIDM#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.bimserver.models.store.ObjectIDM#isEnabled()
	 * @see #getObjectIDM()
	 * @generated
	 */
	EAttribute getObjectIDM_Enabled();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ObjectIDM#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Serializers</em>'.
	 * @see org.bimserver.models.store.ObjectIDM#getSerializers()
	 * @see #getObjectIDM()
	 * @generated
	 */
	EReference getObjectIDM_Serializers();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ObjectIDM#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Settings</em>'.
	 * @see org.bimserver.models.store.ObjectIDM#getSettings()
	 * @see #getObjectIDM()
	 * @generated
	 */
	EReference getObjectIDM_Settings();

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
	 * Returns the meta object for class '{@link org.bimserver.models.store.Deserializer <em>Deserializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deserializer</em>'.
	 * @see org.bimserver.models.store.Deserializer
	 * @generated
	 */
	EClass getDeserializer();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Deserializer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.Deserializer#getName()
	 * @see #getDeserializer()
	 * @generated
	 */
	EAttribute getDeserializer_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Deserializer#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.Deserializer#getDescription()
	 * @see #getDeserializer()
	 * @generated
	 */
	EAttribute getDeserializer_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Deserializer#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.bimserver.models.store.Deserializer#getClassName()
	 * @see #getDeserializer()
	 * @generated
	 */
	EAttribute getDeserializer_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Deserializer#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.bimserver.models.store.Deserializer#isEnabled()
	 * @see #getDeserializer()
	 * @generated
	 */
	EAttribute getDeserializer_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Deserializer#isDefaultDeserializer <em>Default Deserializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Deserializer</em>'.
	 * @see org.bimserver.models.store.Deserializer#isDefaultDeserializer()
	 * @see #getDeserializer()
	 * @generated
	 */
	EAttribute getDeserializer_DefaultDeserializer();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Deserializer#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Settings</em>'.
	 * @see org.bimserver.models.store.Deserializer#getSettings()
	 * @see #getDeserializer()
	 * @generated
	 */
	EReference getDeserializer_Settings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.CheckinResult <em>Checkin Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Checkin Result</em>'.
	 * @see org.bimserver.models.store.CheckinResult
	 * @generated
	 */
	EClass getCheckinResult();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.CheckinResult#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see org.bimserver.models.store.CheckinResult#getRevision()
	 * @see #getCheckinResult()
	 * @generated
	 */
	EReference getCheckinResult_Revision();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.CheckinResult#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.store.CheckinResult#getProject()
	 * @see #getCheckinResult()
	 * @generated
	 */
	EReference getCheckinResult_Project();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.CheckinResult#getProgress <em>Progress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress</em>'.
	 * @see org.bimserver.models.store.CheckinResult#getProgress()
	 * @see #getCheckinResult()
	 * @generated
	 */
	EAttribute getCheckinResult_Progress();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.DownloadResult <em>Download Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Download Result</em>'.
	 * @see org.bimserver.models.store.DownloadResult
	 * @generated
	 */
	EClass getDownloadResult();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DownloadResult#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.bimserver.models.store.DownloadResult#getProjectName()
	 * @see #getDownloadResult()
	 * @generated
	 */
	EAttribute getDownloadResult_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DownloadResult#getRevisionNr <em>Revision Nr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Revision Nr</em>'.
	 * @see org.bimserver.models.store.DownloadResult#getRevisionNr()
	 * @see #getDownloadResult()
	 * @generated
	 */
	EAttribute getDownloadResult_RevisionNr();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DownloadResult#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see org.bimserver.models.store.DownloadResult#getFile()
	 * @see #getDownloadResult()
	 * @generated
	 */
	EAttribute getDownloadResult_File();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.CheckoutResult <em>Checkout Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Checkout Result</em>'.
	 * @see org.bimserver.models.store.CheckoutResult
	 * @generated
	 */
	EClass getCheckoutResult();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.DataValue <em>Data Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Value</em>'.
	 * @see org.bimserver.models.store.DataValue
	 * @generated
	 */
	EClass getDataValue();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DataValue#getFieldName <em>Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Name</em>'.
	 * @see org.bimserver.models.store.DataValue#getFieldName()
	 * @see #getDataValue()
	 * @generated
	 */
	EAttribute getDataValue_FieldName();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.DataObject <em>Data Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Object</em>'.
	 * @see org.bimserver.models.store.DataObject
	 * @generated
	 */
	EClass getDataObject();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DataObject#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.bimserver.models.store.DataObject#getType()
	 * @see #getDataObject()
	 * @generated
	 */
	EAttribute getDataObject_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DataObject#getGuid <em>Guid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guid</em>'.
	 * @see org.bimserver.models.store.DataObject#getGuid()
	 * @see #getDataObject()
	 * @generated
	 */
	EAttribute getDataObject_Guid();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DataObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.DataObject#getName()
	 * @see #getDataObject()
	 * @generated
	 */
	EAttribute getDataObject_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.DataObject#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.bimserver.models.store.DataObject#getValues()
	 * @see #getDataObject()
	 * @generated
	 */
	EReference getDataObject_Values();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.UserSession <em>User Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Session</em>'.
	 * @see org.bimserver.models.store.UserSession
	 * @generated
	 */
	EClass getUserSession();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.UserSession#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.store.UserSession#getUser()
	 * @see #getUserSession()
	 * @generated
	 */
	EReference getUserSession_User();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.UserSession#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see org.bimserver.models.store.UserSession#getUsername()
	 * @see #getUserSession()
	 * @generated
	 */
	EAttribute getUserSession_Username();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.UserSession#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.UserSession#getName()
	 * @see #getUserSession()
	 * @generated
	 */
	EAttribute getUserSession_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.UserSession#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.bimserver.models.store.UserSession#getType()
	 * @see #getUserSession()
	 * @generated
	 */
	EAttribute getUserSession_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.UserSession#getRemoteAddress <em>Remote Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Address</em>'.
	 * @see org.bimserver.models.store.UserSession#getRemoteAddress()
	 * @see #getUserSession()
	 * @generated
	 */
	EAttribute getUserSession_RemoteAddress();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.UserSession#getActiveSince <em>Active Since</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active Since</em>'.
	 * @see org.bimserver.models.store.UserSession#getActiveSince()
	 * @see #getUserSession()
	 * @generated
	 */
	EAttribute getUserSession_ActiveSince();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.UserSession#getLastActive <em>Last Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Active</em>'.
	 * @see org.bimserver.models.store.UserSession#getLastActive()
	 * @see #getUserSession()
	 * @generated
	 */
	EAttribute getUserSession_LastActive();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.UserSession#getAccessMethod <em>Access Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Method</em>'.
	 * @see org.bimserver.models.store.UserSession#getAccessMethod()
	 * @see #getUserSession()
	 * @generated
	 */
	EAttribute getUserSession_AccessMethod();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Migration <em>Migration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Migration</em>'.
	 * @see org.bimserver.models.store.Migration
	 * @generated
	 */
	EClass getMigration();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Migration#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see org.bimserver.models.store.Migration#getNumber()
	 * @see #getMigration()
	 * @generated
	 */
	EAttribute getMigration_Number();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Migration#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.Migration#getDescription()
	 * @see #getMigration()
	 * @generated
	 */
	EAttribute getMigration_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Migration#isExecuted <em>Executed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executed</em>'.
	 * @see org.bimserver.models.store.Migration#isExecuted()
	 * @see #getMigration()
	 * @generated
	 */
	EAttribute getMigration_Executed();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ReferenceDataValue <em>Reference Data Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Data Value</em>'.
	 * @see org.bimserver.models.store.ReferenceDataValue
	 * @generated
	 */
	EClass getReferenceDataValue();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ReferenceDataValue#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see org.bimserver.models.store.ReferenceDataValue#getTypeName()
	 * @see #getReferenceDataValue()
	 * @generated
	 */
	EAttribute getReferenceDataValue_TypeName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ReferenceDataValue#getGuid <em>Guid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guid</em>'.
	 * @see org.bimserver.models.store.ReferenceDataValue#getGuid()
	 * @see #getReferenceDataValue()
	 * @generated
	 */
	EAttribute getReferenceDataValue_Guid();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ListDataValue <em>List Data Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Data Value</em>'.
	 * @see org.bimserver.models.store.ListDataValue
	 * @generated
	 */
	EClass getListDataValue();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ListDataValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.bimserver.models.store.ListDataValue#getValues()
	 * @see #getListDataValue()
	 * @generated
	 */
	EReference getListDataValue_Values();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.SimpleDataValue <em>Simple Data Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Data Value</em>'.
	 * @see org.bimserver.models.store.SimpleDataValue
	 * @generated
	 */
	EClass getSimpleDataValue();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SimpleDataValue#getStringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Value</em>'.
	 * @see org.bimserver.models.store.SimpleDataValue#getStringValue()
	 * @see #getSimpleDataValue()
	 * @generated
	 */
	EAttribute getSimpleDataValue_StringValue();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.DatabaseInformationItem <em>Database Information Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Information Item</em>'.
	 * @see org.bimserver.models.store.DatabaseInformationItem
	 * @generated
	 */
	EClass getDatabaseInformationItem();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DatabaseInformationItem#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.bimserver.models.store.DatabaseInformationItem#getKey()
	 * @see #getDatabaseInformationItem()
	 * @generated
	 */
	EAttribute getDatabaseInformationItem_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DatabaseInformationItem#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.bimserver.models.store.DatabaseInformationItem#getValue()
	 * @see #getDatabaseInformationItem()
	 * @generated
	 */
	EAttribute getDatabaseInformationItem_Value();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.DatabaseInformationCategory <em>Database Information Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Information Category</em>'.
	 * @see org.bimserver.models.store.DatabaseInformationCategory
	 * @generated
	 */
	EClass getDatabaseInformationCategory();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DatabaseInformationCategory#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.bimserver.models.store.DatabaseInformationCategory#getTitle()
	 * @see #getDatabaseInformationCategory()
	 * @generated
	 */
	EAttribute getDatabaseInformationCategory_Title();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.DatabaseInformationCategory#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Items</em>'.
	 * @see org.bimserver.models.store.DatabaseInformationCategory#getItems()
	 * @see #getDatabaseInformationCategory()
	 * @generated
	 */
	EReference getDatabaseInformationCategory_Items();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.DatabaseInformation <em>Database Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Information</em>'.
	 * @see org.bimserver.models.store.DatabaseInformation
	 * @generated
	 */
	EClass getDatabaseInformation();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DatabaseInformation#getNumberOfProjects <em>Number Of Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Projects</em>'.
	 * @see org.bimserver.models.store.DatabaseInformation#getNumberOfProjects()
	 * @see #getDatabaseInformation()
	 * @generated
	 */
	EAttribute getDatabaseInformation_NumberOfProjects();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DatabaseInformation#getNumberOfUsers <em>Number Of Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Users</em>'.
	 * @see org.bimserver.models.store.DatabaseInformation#getNumberOfUsers()
	 * @see #getDatabaseInformation()
	 * @generated
	 */
	EAttribute getDatabaseInformation_NumberOfUsers();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DatabaseInformation#getNumberOfRevisions <em>Number Of Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Revisions</em>'.
	 * @see org.bimserver.models.store.DatabaseInformation#getNumberOfRevisions()
	 * @see #getDatabaseInformation()
	 * @generated
	 */
	EAttribute getDatabaseInformation_NumberOfRevisions();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DatabaseInformation#getNumberOfCheckouts <em>Number Of Checkouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Checkouts</em>'.
	 * @see org.bimserver.models.store.DatabaseInformation#getNumberOfCheckouts()
	 * @see #getDatabaseInformation()
	 * @generated
	 */
	EAttribute getDatabaseInformation_NumberOfCheckouts();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DatabaseInformation#getDatabaseSizeInBytes <em>Database Size In Bytes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Database Size In Bytes</em>'.
	 * @see org.bimserver.models.store.DatabaseInformation#getDatabaseSizeInBytes()
	 * @see #getDatabaseInformation()
	 * @generated
	 */
	EAttribute getDatabaseInformation_DatabaseSizeInBytes();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DatabaseInformation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.bimserver.models.store.DatabaseInformation#getType()
	 * @see #getDatabaseInformation()
	 * @generated
	 */
	EAttribute getDatabaseInformation_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DatabaseInformation#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see org.bimserver.models.store.DatabaseInformation#getCreated()
	 * @see #getDatabaseInformation()
	 * @generated
	 */
	EAttribute getDatabaseInformation_Created();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DatabaseInformation#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.bimserver.models.store.DatabaseInformation#getLocation()
	 * @see #getDatabaseInformation()
	 * @generated
	 */
	EAttribute getDatabaseInformation_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DatabaseInformation#getSchemaVersion <em>Schema Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema Version</em>'.
	 * @see org.bimserver.models.store.DatabaseInformation#getSchemaVersion()
	 * @see #getDatabaseInformation()
	 * @generated
	 */
	EAttribute getDatabaseInformation_SchemaVersion();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.DatabaseInformation#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Categories</em>'.
	 * @see org.bimserver.models.store.DatabaseInformation#getCategories()
	 * @see #getDatabaseInformation()
	 * @generated
	 */
	EReference getDatabaseInformation_Categories();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.SerializerPluginDescriptor <em>Serializer Plugin Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Serializer Plugin Descriptor</em>'.
	 * @see org.bimserver.models.store.SerializerPluginDescriptor
	 * @generated
	 */
	EClass getSerializerPluginDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SerializerPluginDescriptor#getPluginClassName <em>Plugin Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin Class Name</em>'.
	 * @see org.bimserver.models.store.SerializerPluginDescriptor#getPluginClassName()
	 * @see #getSerializerPluginDescriptor()
	 * @generated
	 */
	EAttribute getSerializerPluginDescriptor_PluginClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultName <em>Default Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Name</em>'.
	 * @see org.bimserver.models.store.SerializerPluginDescriptor#getDefaultName()
	 * @see #getSerializerPluginDescriptor()
	 * @generated
	 */
	EAttribute getSerializerPluginDescriptor_DefaultName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultExtension <em>Default Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Extension</em>'.
	 * @see org.bimserver.models.store.SerializerPluginDescriptor#getDefaultExtension()
	 * @see #getSerializerPluginDescriptor()
	 * @generated
	 */
	EAttribute getSerializerPluginDescriptor_DefaultExtension();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SerializerPluginDescriptor#getDefaultContentType <em>Default Content Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Content Type</em>'.
	 * @see org.bimserver.models.store.SerializerPluginDescriptor#getDefaultContentType()
	 * @see #getSerializerPluginDescriptor()
	 * @generated
	 */
	EAttribute getSerializerPluginDescriptor_DefaultContentType();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.DeserializerPluginDescriptor <em>Deserializer Plugin Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deserializer Plugin Descriptor</em>'.
	 * @see org.bimserver.models.store.DeserializerPluginDescriptor
	 * @generated
	 */
	EClass getDeserializerPluginDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DeserializerPluginDescriptor#getPluginClassName <em>Plugin Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin Class Name</em>'.
	 * @see org.bimserver.models.store.DeserializerPluginDescriptor#getPluginClassName()
	 * @see #getDeserializerPluginDescriptor()
	 * @generated
	 */
	EAttribute getDeserializerPluginDescriptor_PluginClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DeserializerPluginDescriptor#getDefaultName <em>Default Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Name</em>'.
	 * @see org.bimserver.models.store.DeserializerPluginDescriptor#getDefaultName()
	 * @see #getDeserializerPluginDescriptor()
	 * @generated
	 */
	EAttribute getDeserializerPluginDescriptor_DefaultName();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.RevisionSummaryType <em>Revision Summary Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Revision Summary Type</em>'.
	 * @see org.bimserver.models.store.RevisionSummaryType
	 * @generated
	 */
	EClass getRevisionSummaryType();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.RevisionSummaryType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.RevisionSummaryType#getName()
	 * @see #getRevisionSummaryType()
	 * @generated
	 */
	EAttribute getRevisionSummaryType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.RevisionSummaryType#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.bimserver.models.store.RevisionSummaryType#getCount()
	 * @see #getRevisionSummaryType()
	 * @generated
	 */
	EAttribute getRevisionSummaryType_Count();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.RevisionSummaryContainer <em>Revision Summary Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Revision Summary Container</em>'.
	 * @see org.bimserver.models.store.RevisionSummaryContainer
	 * @generated
	 */
	EClass getRevisionSummaryContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.RevisionSummaryContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.RevisionSummaryContainer#getName()
	 * @see #getRevisionSummaryContainer()
	 * @generated
	 */
	EAttribute getRevisionSummaryContainer_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.RevisionSummaryContainer#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Types</em>'.
	 * @see org.bimserver.models.store.RevisionSummaryContainer#getTypes()
	 * @see #getRevisionSummaryContainer()
	 * @generated
	 */
	EReference getRevisionSummaryContainer_Types();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.RevisionSummary <em>Revision Summary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Revision Summary</em>'.
	 * @see org.bimserver.models.store.RevisionSummary
	 * @generated
	 */
	EClass getRevisionSummary();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.RevisionSummary#getList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>List</em>'.
	 * @see org.bimserver.models.store.RevisionSummary#getList()
	 * @see #getRevisionSummary()
	 * @generated
	 */
	EReference getRevisionSummary_List();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.PluginDescriptor <em>Plugin Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin Descriptor</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor
	 * @generated
	 */
	EClass getPluginDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor#getName()
	 * @see #getPluginDescriptor()
	 * @generated
	 */
	EAttribute getPluginDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginDescriptor#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor#getDescription()
	 * @see #getPluginDescriptor()
	 * @generated
	 */
	EAttribute getPluginDescriptor_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginDescriptor#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor#getLocation()
	 * @see #getPluginDescriptor()
	 * @generated
	 */
	EAttribute getPluginDescriptor_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginDescriptor#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor#isEnabled()
	 * @see #getPluginDescriptor()
	 * @generated
	 */
	EAttribute getPluginDescriptor_Enabled();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.LongAction <em>Long Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Action</em>'.
	 * @see org.bimserver.models.store.LongAction
	 * @generated
	 */
	EClass getLongAction();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongAction#getIdentification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identification</em>'.
	 * @see org.bimserver.models.store.LongAction#getIdentification()
	 * @see #getLongAction()
	 * @generated
	 */
	EAttribute getLongAction_Identification();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.LongAction#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.store.LongAction#getUser()
	 * @see #getLongAction()
	 * @generated
	 */
	EReference getLongAction_User();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongAction#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.bimserver.models.store.LongAction#getStart()
	 * @see #getLongAction()
	 * @generated
	 */
	EAttribute getLongAction_Start();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongAction#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see org.bimserver.models.store.LongAction#getUsername()
	 * @see #getLongAction()
	 * @generated
	 */
	EAttribute getLongAction_Username();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongAction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.LongAction#getName()
	 * @see #getLongAction()
	 * @generated
	 */
	EAttribute getLongAction_Name();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.LongCheckinAction <em>Long Checkin Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Checkin Action</em>'.
	 * @see org.bimserver.models.store.LongCheckinAction
	 * @generated
	 */
	EClass getLongCheckinAction();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.LongCheckinAction#getRevisions <em>Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Revisions</em>'.
	 * @see org.bimserver.models.store.LongCheckinAction#getRevisions()
	 * @see #getLongCheckinAction()
	 * @generated
	 */
	EReference getLongCheckinAction_Revisions();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ObjectIDMPluginDescriptor <em>Object IDM Plugin Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object IDM Plugin Descriptor</em>'.
	 * @see org.bimserver.models.store.ObjectIDMPluginDescriptor
	 * @generated
	 */
	EClass getObjectIDMPluginDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ObjectIDMPluginDescriptor#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.bimserver.models.store.ObjectIDMPluginDescriptor#getClassName()
	 * @see #getObjectIDMPluginDescriptor()
	 * @generated
	 */
	EAttribute getObjectIDMPluginDescriptor_ClassName();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.CompareItem <em>Compare Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compare Item</em>'.
	 * @see org.bimserver.models.store.CompareItem
	 * @generated
	 */
	EClass getCompareItem();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.CompareItem#getDataObject <em>Data Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Object</em>'.
	 * @see org.bimserver.models.store.CompareItem#getDataObject()
	 * @see #getCompareItem()
	 * @generated
	 */
	EReference getCompareItem_DataObject();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ObjectAdded <em>Object Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Added</em>'.
	 * @see org.bimserver.models.store.ObjectAdded
	 * @generated
	 */
	EClass getObjectAdded();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ObjectRemoved <em>Object Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Removed</em>'.
	 * @see org.bimserver.models.store.ObjectRemoved
	 * @generated
	 */
	EClass getObjectRemoved();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ObjectModified <em>Object Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Modified</em>'.
	 * @see org.bimserver.models.store.ObjectModified
	 * @generated
	 */
	EClass getObjectModified();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ObjectModified#getFieldName <em>Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Name</em>'.
	 * @see org.bimserver.models.store.ObjectModified#getFieldName()
	 * @see #getObjectModified()
	 * @generated
	 */
	EAttribute getObjectModified_FieldName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ObjectModified#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Value</em>'.
	 * @see org.bimserver.models.store.ObjectModified#getOldValue()
	 * @see #getObjectModified()
	 * @generated
	 */
	EAttribute getObjectModified_OldValue();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ObjectModified#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see org.bimserver.models.store.ObjectModified#getNewValue()
	 * @see #getObjectModified()
	 * @generated
	 */
	EAttribute getObjectModified_NewValue();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.CompareContainer <em>Compare Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compare Container</em>'.
	 * @see org.bimserver.models.store.CompareContainer
	 * @generated
	 */
	EClass getCompareContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.CompareContainer#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.bimserver.models.store.CompareContainer#getType()
	 * @see #getCompareContainer()
	 * @generated
	 */
	EAttribute getCompareContainer_Type();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.CompareContainer#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Items</em>'.
	 * @see org.bimserver.models.store.CompareContainer#getItems()
	 * @see #getCompareContainer()
	 * @generated
	 */
	EReference getCompareContainer_Items();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.CompareResult <em>Compare Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compare Result</em>'.
	 * @see org.bimserver.models.store.CompareResult
	 * @generated
	 */
	EClass getCompareResult();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.CompareResult#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Items</em>'.
	 * @see org.bimserver.models.store.CompareResult#getItems()
	 * @see #getCompareResult()
	 * @generated
	 */
	EReference getCompareResult_Items();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.LongActionState <em>Long Action State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Action State</em>'.
	 * @see org.bimserver.models.store.LongActionState
	 * @generated
	 */
	EClass getLongActionState();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongActionState#getProgress <em>Progress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress</em>'.
	 * @see org.bimserver.models.store.LongActionState#getProgress()
	 * @see #getLongActionState()
	 * @generated
	 */
	EAttribute getLongActionState_Progress();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongActionState#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.bimserver.models.store.LongActionState#getState()
	 * @see #getLongActionState()
	 * @generated
	 */
	EAttribute getLongActionState_State();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Notification <em>Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notification</em>'.
	 * @see org.bimserver.models.store.Notification
	 * @generated
	 */
	EClass getNotification();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.NewProjectNotification <em>New Project Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Project Notification</em>'.
	 * @see org.bimserver.models.store.NewProjectNotification
	 * @generated
	 */
	EClass getNewProjectNotification();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.NewProjectNotification#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.store.NewProjectNotification#getProject()
	 * @see #getNewProjectNotification()
	 * @generated
	 */
	EReference getNewProjectNotification_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.NewRevisionNotification <em>New Revision Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Revision Notification</em>'.
	 * @see org.bimserver.models.store.NewRevisionNotification
	 * @generated
	 */
	EClass getNewRevisionNotification();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.NewRevisionNotification#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see org.bimserver.models.store.NewRevisionNotification#getRevision()
	 * @see #getNewRevisionNotification()
	 * @generated
	 */
	EReference getNewRevisionNotification_Revision();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.CompileResult <em>Compile Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compile Result</em>'.
	 * @see org.bimserver.models.store.CompileResult
	 * @generated
	 */
	EClass getCompileResult();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.CompileResult#isCompileOke <em>Compile Oke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compile Oke</em>'.
	 * @see org.bimserver.models.store.CompileResult#isCompileOke()
	 * @see #getCompileResult()
	 * @generated
	 */
	EAttribute getCompileResult_CompileOke();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.CompileResult#getWarnings <em>Warnings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Warnings</em>'.
	 * @see org.bimserver.models.store.CompileResult#getWarnings()
	 * @see #getCompileResult()
	 * @generated
	 */
	EAttribute getCompileResult_Warnings();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.CompileResult#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Errors</em>'.
	 * @see org.bimserver.models.store.CompileResult#getErrors()
	 * @see #getCompileResult()
	 * @generated
	 */
	EAttribute getCompileResult_Errors();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.RunResult <em>Run Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run Result</em>'.
	 * @see org.bimserver.models.store.RunResult
	 * @generated
	 */
	EClass getRunResult();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.RunResult#isRunOke <em>Run Oke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Run Oke</em>'.
	 * @see org.bimserver.models.store.RunResult#isRunOke()
	 * @see #getRunResult()
	 * @generated
	 */
	EAttribute getRunResult_RunOke();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.RunResult#getWarnings <em>Warnings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Warnings</em>'.
	 * @see org.bimserver.models.store.RunResult#getWarnings()
	 * @see #getRunResult()
	 * @generated
	 */
	EAttribute getRunResult_Warnings();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.RunResult#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Errors</em>'.
	 * @see org.bimserver.models.store.RunResult#getErrors()
	 * @see #getRunResult()
	 * @generated
	 */
	EAttribute getRunResult_Errors();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.RunResult#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see org.bimserver.models.store.RunResult#getOutput()
	 * @see #getRunResult()
	 * @generated
	 */
	EAttribute getRunResult_Output();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ServerInfo <em>Server Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Info</em>'.
	 * @see org.bimserver.models.store.ServerInfo
	 * @generated
	 */
	EClass getServerInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerInfo#getServerState <em>Server State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server State</em>'.
	 * @see org.bimserver.models.store.ServerInfo#getServerState()
	 * @see #getServerInfo()
	 * @generated
	 */
	EAttribute getServerInfo_ServerState();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerInfo#getErrorMessage <em>Error Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Message</em>'.
	 * @see org.bimserver.models.store.ServerInfo#getErrorMessage()
	 * @see #getServerInfo()
	 * @generated
	 */
	EAttribute getServerInfo_ErrorMessage();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.bimserver.models.store.Version
	 * @generated
	 */
	EClass getVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Version#getMajor <em>Major</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Major</em>'.
	 * @see org.bimserver.models.store.Version#getMajor()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Major();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Version#getMinor <em>Minor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minor</em>'.
	 * @see org.bimserver.models.store.Version#getMinor()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Minor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Version#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Revision</em>'.
	 * @see org.bimserver.models.store.Version#getRevision()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Revision();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Version#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.bimserver.models.store.Version#getDate()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Version#getDownloadUrl <em>Download Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Download Url</em>'.
	 * @see org.bimserver.models.store.Version#getDownloadUrl()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_DownloadUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Version#getSupportUrl <em>Support Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Support Url</em>'.
	 * @see org.bimserver.models.store.Version#getSupportUrl()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_SupportUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Version#getSupportEmail <em>Support Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Support Email</em>'.
	 * @see org.bimserver.models.store.Version#getSupportEmail()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_SupportEmail();

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
	 * Returns the meta object for enum '{@link org.bimserver.models.store.CompareIdentifier <em>Compare Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Compare Identifier</em>'.
	 * @see org.bimserver.models.store.CompareIdentifier
	 * @generated
	 */
	EEnum getCompareIdentifier();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.CompareType <em>Compare Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Compare Type</em>'.
	 * @see org.bimserver.models.store.CompareType
	 * @generated
	 */
	EEnum getCompareType();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.ActionState <em>Action State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action State</em>'.
	 * @see org.bimserver.models.store.ActionState
	 * @generated
	 */
	EEnum getActionState();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.ServerState <em>Server State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Server State</em>'.
	 * @see org.bimserver.models.store.ServerState
	 * @generated
	 */
	EEnum getServerState();

	/**
	 * Returns the meta object for data type '{@link javax.activation.DataHandler <em>Data Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Data Handler</em>'.
	 * @see javax.activation.DataHandler
	 * @model instanceClass="javax.activation.DataHandler"
	 * @generated
	 */
	EDataType getDataHandler();

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
		 * The meta object literal for the '<em><b>Notification Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__NOTIFICATION_URL = eINSTANCE.getUser_NotificationUrl();

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
		 * The meta object literal for the '<em><b>Hide User List For Non Admin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SETTINGS__HIDE_USER_LIST_FOR_NON_ADMIN = eINSTANCE.getSettings_HideUserListForNonAdmin();

		/**
		 * The meta object literal for the '<em><b>Serializers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTINGS__SERIALIZERS = eINSTANCE.getSettings_Serializers();

		/**
		 * The meta object literal for the '<em><b>Object ID Ms</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTINGS__OBJECT_ID_MS = eINSTANCE.getSettings_ObjectIDMs();

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
		 * The meta object literal for the '<em><b>Deserializers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SETTINGS__DESERIALIZERS = eINSTANCE.getSettings_Deserializers();

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
		 * The meta object literal for the '<em><b>Object IDM</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERIALIZER__OBJECT_IDM = eINSTANCE.getSerializer_ObjectIDM();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERIALIZER__SETTINGS = eINSTANCE.getSerializer_Settings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ObjectIDMImpl <em>Object IDM</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ObjectIDMImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectIDM()
		 * @generated
		 */
		EClass OBJECT_IDM = eINSTANCE.getObjectIDM();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_IDM__NAME = eINSTANCE.getObjectIDM_Name();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_IDM__CLASS_NAME = eINSTANCE.getObjectIDM_ClassName();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_IDM__ENABLED = eINSTANCE.getObjectIDM_Enabled();

		/**
		 * The meta object literal for the '<em><b>Serializers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_IDM__SERIALIZERS = eINSTANCE.getObjectIDM_Serializers();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_IDM__SETTINGS = eINSTANCE.getObjectIDM_Settings();

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
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.DeserializerImpl <em>Deserializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.DeserializerImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDeserializer()
		 * @generated
		 */
		EClass DESERIALIZER = eINSTANCE.getDeserializer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESERIALIZER__NAME = eINSTANCE.getDeserializer_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESERIALIZER__DESCRIPTION = eINSTANCE.getDeserializer_Description();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESERIALIZER__CLASS_NAME = eINSTANCE.getDeserializer_ClassName();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESERIALIZER__ENABLED = eINSTANCE.getDeserializer_Enabled();

		/**
		 * The meta object literal for the '<em><b>Default Deserializer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESERIALIZER__DEFAULT_DESERIALIZER = eINSTANCE.getDeserializer_DefaultDeserializer();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESERIALIZER__SETTINGS = eINSTANCE.getDeserializer_Settings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.CheckinResultImpl <em>Checkin Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.CheckinResultImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getCheckinResult()
		 * @generated
		 */
		EClass CHECKIN_RESULT = eINSTANCE.getCheckinResult();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECKIN_RESULT__REVISION = eINSTANCE.getCheckinResult_Revision();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECKIN_RESULT__PROJECT = eINSTANCE.getCheckinResult_Project();

		/**
		 * The meta object literal for the '<em><b>Progress</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECKIN_RESULT__PROGRESS = eINSTANCE.getCheckinResult_Progress();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.DownloadResultImpl <em>Download Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.DownloadResultImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDownloadResult()
		 * @generated
		 */
		EClass DOWNLOAD_RESULT = eINSTANCE.getDownloadResult();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOWNLOAD_RESULT__PROJECT_NAME = eINSTANCE.getDownloadResult_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Revision Nr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOWNLOAD_RESULT__REVISION_NR = eINSTANCE.getDownloadResult_RevisionNr();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOWNLOAD_RESULT__FILE = eINSTANCE.getDownloadResult_File();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.CheckoutResultImpl <em>Checkout Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.CheckoutResultImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getCheckoutResult()
		 * @generated
		 */
		EClass CHECKOUT_RESULT = eINSTANCE.getCheckoutResult();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.DataValueImpl <em>Data Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.DataValueImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDataValue()
		 * @generated
		 */
		EClass DATA_VALUE = eINSTANCE.getDataValue();

		/**
		 * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_VALUE__FIELD_NAME = eINSTANCE.getDataValue_FieldName();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.DataObjectImpl <em>Data Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.DataObjectImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDataObject()
		 * @generated
		 */
		EClass DATA_OBJECT = eINSTANCE.getDataObject();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_OBJECT__TYPE = eINSTANCE.getDataObject_Type();

		/**
		 * The meta object literal for the '<em><b>Guid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_OBJECT__GUID = eINSTANCE.getDataObject_Guid();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_OBJECT__NAME = eINSTANCE.getDataObject_Name();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_OBJECT__VALUES = eINSTANCE.getDataObject_Values();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.UserSessionImpl <em>User Session</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.UserSessionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getUserSession()
		 * @generated
		 */
		EClass USER_SESSION = eINSTANCE.getUserSession();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SESSION__USER = eINSTANCE.getUserSession_User();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_SESSION__USERNAME = eINSTANCE.getUserSession_Username();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_SESSION__NAME = eINSTANCE.getUserSession_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_SESSION__TYPE = eINSTANCE.getUserSession_Type();

		/**
		 * The meta object literal for the '<em><b>Remote Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_SESSION__REMOTE_ADDRESS = eINSTANCE.getUserSession_RemoteAddress();

		/**
		 * The meta object literal for the '<em><b>Active Since</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_SESSION__ACTIVE_SINCE = eINSTANCE.getUserSession_ActiveSince();

		/**
		 * The meta object literal for the '<em><b>Last Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_SESSION__LAST_ACTIVE = eINSTANCE.getUserSession_LastActive();

		/**
		 * The meta object literal for the '<em><b>Access Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_SESSION__ACCESS_METHOD = eINSTANCE.getUserSession_AccessMethod();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.MigrationImpl <em>Migration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.MigrationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getMigration()
		 * @generated
		 */
		EClass MIGRATION = eINSTANCE.getMigration();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION__NUMBER = eINSTANCE.getMigration_Number();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION__DESCRIPTION = eINSTANCE.getMigration_Description();

		/**
		 * The meta object literal for the '<em><b>Executed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION__EXECUTED = eINSTANCE.getMigration_Executed();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ReferenceDataValueImpl <em>Reference Data Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ReferenceDataValueImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getReferenceDataValue()
		 * @generated
		 */
		EClass REFERENCE_DATA_VALUE = eINSTANCE.getReferenceDataValue();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_DATA_VALUE__TYPE_NAME = eINSTANCE.getReferenceDataValue_TypeName();

		/**
		 * The meta object literal for the '<em><b>Guid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_DATA_VALUE__GUID = eINSTANCE.getReferenceDataValue_Guid();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ListDataValueImpl <em>List Data Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ListDataValueImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getListDataValue()
		 * @generated
		 */
		EClass LIST_DATA_VALUE = eINSTANCE.getListDataValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_DATA_VALUE__VALUES = eINSTANCE.getListDataValue_Values();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.SimpleDataValueImpl <em>Simple Data Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.SimpleDataValueImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getSimpleDataValue()
		 * @generated
		 */
		EClass SIMPLE_DATA_VALUE = eINSTANCE.getSimpleDataValue();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_DATA_VALUE__STRING_VALUE = eINSTANCE.getSimpleDataValue_StringValue();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.DatabaseInformationItemImpl <em>Database Information Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.DatabaseInformationItemImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDatabaseInformationItem()
		 * @generated
		 */
		EClass DATABASE_INFORMATION_ITEM = eINSTANCE.getDatabaseInformationItem();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_INFORMATION_ITEM__KEY = eINSTANCE.getDatabaseInformationItem_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_INFORMATION_ITEM__VALUE = eINSTANCE.getDatabaseInformationItem_Value();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.DatabaseInformationCategoryImpl <em>Database Information Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.DatabaseInformationCategoryImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDatabaseInformationCategory()
		 * @generated
		 */
		EClass DATABASE_INFORMATION_CATEGORY = eINSTANCE.getDatabaseInformationCategory();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_INFORMATION_CATEGORY__TITLE = eINSTANCE.getDatabaseInformationCategory_Title();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_INFORMATION_CATEGORY__ITEMS = eINSTANCE.getDatabaseInformationCategory_Items();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.DatabaseInformationImpl <em>Database Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.DatabaseInformationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDatabaseInformation()
		 * @generated
		 */
		EClass DATABASE_INFORMATION = eINSTANCE.getDatabaseInformation();

		/**
		 * The meta object literal for the '<em><b>Number Of Projects</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_INFORMATION__NUMBER_OF_PROJECTS = eINSTANCE.getDatabaseInformation_NumberOfProjects();

		/**
		 * The meta object literal for the '<em><b>Number Of Users</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_INFORMATION__NUMBER_OF_USERS = eINSTANCE.getDatabaseInformation_NumberOfUsers();

		/**
		 * The meta object literal for the '<em><b>Number Of Revisions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_INFORMATION__NUMBER_OF_REVISIONS = eINSTANCE.getDatabaseInformation_NumberOfRevisions();

		/**
		 * The meta object literal for the '<em><b>Number Of Checkouts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_INFORMATION__NUMBER_OF_CHECKOUTS = eINSTANCE.getDatabaseInformation_NumberOfCheckouts();

		/**
		 * The meta object literal for the '<em><b>Database Size In Bytes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_INFORMATION__DATABASE_SIZE_IN_BYTES = eINSTANCE.getDatabaseInformation_DatabaseSizeInBytes();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_INFORMATION__TYPE = eINSTANCE.getDatabaseInformation_Type();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_INFORMATION__CREATED = eINSTANCE.getDatabaseInformation_Created();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_INFORMATION__LOCATION = eINSTANCE.getDatabaseInformation_Location();

		/**
		 * The meta object literal for the '<em><b>Schema Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_INFORMATION__SCHEMA_VERSION = eINSTANCE.getDatabaseInformation_SchemaVersion();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE_INFORMATION__CATEGORIES = eINSTANCE.getDatabaseInformation_Categories();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.SerializerPluginDescriptorImpl <em>Serializer Plugin Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.SerializerPluginDescriptorImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getSerializerPluginDescriptor()
		 * @generated
		 */
		EClass SERIALIZER_PLUGIN_DESCRIPTOR = eINSTANCE.getSerializerPluginDescriptor();

		/**
		 * The meta object literal for the '<em><b>Plugin Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER_PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME = eINSTANCE.getSerializerPluginDescriptor_PluginClassName();

		/**
		 * The meta object literal for the '<em><b>Default Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_NAME = eINSTANCE.getSerializerPluginDescriptor_DefaultName();

		/**
		 * The meta object literal for the '<em><b>Default Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_EXTENSION = eINSTANCE.getSerializerPluginDescriptor_DefaultExtension();

		/**
		 * The meta object literal for the '<em><b>Default Content Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_CONTENT_TYPE = eINSTANCE.getSerializerPluginDescriptor_DefaultContentType();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.DeserializerPluginDescriptorImpl <em>Deserializer Plugin Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.DeserializerPluginDescriptorImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDeserializerPluginDescriptor()
		 * @generated
		 */
		EClass DESERIALIZER_PLUGIN_DESCRIPTOR = eINSTANCE.getDeserializerPluginDescriptor();

		/**
		 * The meta object literal for the '<em><b>Plugin Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESERIALIZER_PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME = eINSTANCE.getDeserializerPluginDescriptor_PluginClassName();

		/**
		 * The meta object literal for the '<em><b>Default Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESERIALIZER_PLUGIN_DESCRIPTOR__DEFAULT_NAME = eINSTANCE.getDeserializerPluginDescriptor_DefaultName();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.RevisionSummaryTypeImpl <em>Revision Summary Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.RevisionSummaryTypeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getRevisionSummaryType()
		 * @generated
		 */
		EClass REVISION_SUMMARY_TYPE = eINSTANCE.getRevisionSummaryType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION_SUMMARY_TYPE__NAME = eINSTANCE.getRevisionSummaryType_Name();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION_SUMMARY_TYPE__COUNT = eINSTANCE.getRevisionSummaryType_Count();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.RevisionSummaryContainerImpl <em>Revision Summary Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.RevisionSummaryContainerImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getRevisionSummaryContainer()
		 * @generated
		 */
		EClass REVISION_SUMMARY_CONTAINER = eINSTANCE.getRevisionSummaryContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION_SUMMARY_CONTAINER__NAME = eINSTANCE.getRevisionSummaryContainer_Name();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION_SUMMARY_CONTAINER__TYPES = eINSTANCE.getRevisionSummaryContainer_Types();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.RevisionSummaryImpl <em>Revision Summary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.RevisionSummaryImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getRevisionSummary()
		 * @generated
		 */
		EClass REVISION_SUMMARY = eINSTANCE.getRevisionSummary();

		/**
		 * The meta object literal for the '<em><b>List</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION_SUMMARY__LIST = eINSTANCE.getRevisionSummary_List();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.PluginDescriptorImpl <em>Plugin Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.PluginDescriptorImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginDescriptor()
		 * @generated
		 */
		EClass PLUGIN_DESCRIPTOR = eINSTANCE.getPluginDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_DESCRIPTOR__NAME = eINSTANCE.getPluginDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_DESCRIPTOR__DESCRIPTION = eINSTANCE.getPluginDescriptor_Description();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_DESCRIPTOR__LOCATION = eINSTANCE.getPluginDescriptor_Location();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_DESCRIPTOR__ENABLED = eINSTANCE.getPluginDescriptor_Enabled();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.LongActionImpl <em>Long Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.LongActionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getLongAction()
		 * @generated
		 */
		EClass LONG_ACTION = eINSTANCE.getLongAction();

		/**
		 * The meta object literal for the '<em><b>Identification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION__IDENTIFICATION = eINSTANCE.getLongAction_Identification();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LONG_ACTION__USER = eINSTANCE.getLongAction_User();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION__START = eINSTANCE.getLongAction_Start();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION__USERNAME = eINSTANCE.getLongAction_Username();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION__NAME = eINSTANCE.getLongAction_Name();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.LongCheckinActionImpl <em>Long Checkin Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.LongCheckinActionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getLongCheckinAction()
		 * @generated
		 */
		EClass LONG_CHECKIN_ACTION = eINSTANCE.getLongCheckinAction();

		/**
		 * The meta object literal for the '<em><b>Revisions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LONG_CHECKIN_ACTION__REVISIONS = eINSTANCE.getLongCheckinAction_Revisions();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ObjectIDMPluginDescriptorImpl <em>Object IDM Plugin Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ObjectIDMPluginDescriptorImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectIDMPluginDescriptor()
		 * @generated
		 */
		EClass OBJECT_IDM_PLUGIN_DESCRIPTOR = eINSTANCE.getObjectIDMPluginDescriptor();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_IDM_PLUGIN_DESCRIPTOR__CLASS_NAME = eINSTANCE.getObjectIDMPluginDescriptor_ClassName();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.CompareItemImpl <em>Compare Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.CompareItemImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompareItem()
		 * @generated
		 */
		EClass COMPARE_ITEM = eINSTANCE.getCompareItem();

		/**
		 * The meta object literal for the '<em><b>Data Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARE_ITEM__DATA_OBJECT = eINSTANCE.getCompareItem_DataObject();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ObjectAddedImpl <em>Object Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ObjectAddedImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectAdded()
		 * @generated
		 */
		EClass OBJECT_ADDED = eINSTANCE.getObjectAdded();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ObjectRemovedImpl <em>Object Removed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ObjectRemovedImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectRemoved()
		 * @generated
		 */
		EClass OBJECT_REMOVED = eINSTANCE.getObjectRemoved();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ObjectModifiedImpl <em>Object Modified</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ObjectModifiedImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectModified()
		 * @generated
		 */
		EClass OBJECT_MODIFIED = eINSTANCE.getObjectModified();

		/**
		 * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_MODIFIED__FIELD_NAME = eINSTANCE.getObjectModified_FieldName();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_MODIFIED__OLD_VALUE = eINSTANCE.getObjectModified_OldValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_MODIFIED__NEW_VALUE = eINSTANCE.getObjectModified_NewValue();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.CompareContainerImpl <em>Compare Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.CompareContainerImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompareContainer()
		 * @generated
		 */
		EClass COMPARE_CONTAINER = eINSTANCE.getCompareContainer();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARE_CONTAINER__TYPE = eINSTANCE.getCompareContainer_Type();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARE_CONTAINER__ITEMS = eINSTANCE.getCompareContainer_Items();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.CompareResultImpl <em>Compare Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.CompareResultImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompareResult()
		 * @generated
		 */
		EClass COMPARE_RESULT = eINSTANCE.getCompareResult();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARE_RESULT__ITEMS = eINSTANCE.getCompareResult_Items();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.LongActionStateImpl <em>Long Action State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.LongActionStateImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getLongActionState()
		 * @generated
		 */
		EClass LONG_ACTION_STATE = eINSTANCE.getLongActionState();

		/**
		 * The meta object literal for the '<em><b>Progress</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION_STATE__PROGRESS = eINSTANCE.getLongActionState_Progress();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION_STATE__STATE = eINSTANCE.getLongActionState_State();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.NotificationImpl <em>Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.NotificationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getNotification()
		 * @generated
		 */
		EClass NOTIFICATION = eINSTANCE.getNotification();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.NewProjectNotificationImpl <em>New Project Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.NewProjectNotificationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getNewProjectNotification()
		 * @generated
		 */
		EClass NEW_PROJECT_NOTIFICATION = eINSTANCE.getNewProjectNotification();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_PROJECT_NOTIFICATION__PROJECT = eINSTANCE.getNewProjectNotification_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.NewRevisionNotificationImpl <em>New Revision Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.NewRevisionNotificationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getNewRevisionNotification()
		 * @generated
		 */
		EClass NEW_REVISION_NOTIFICATION = eINSTANCE.getNewRevisionNotification();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_REVISION_NOTIFICATION__REVISION = eINSTANCE.getNewRevisionNotification_Revision();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.CompileResultImpl <em>Compile Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.CompileResultImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompileResult()
		 * @generated
		 */
		EClass COMPILE_RESULT = eINSTANCE.getCompileResult();

		/**
		 * The meta object literal for the '<em><b>Compile Oke</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILE_RESULT__COMPILE_OKE = eINSTANCE.getCompileResult_CompileOke();

		/**
		 * The meta object literal for the '<em><b>Warnings</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILE_RESULT__WARNINGS = eINSTANCE.getCompileResult_Warnings();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILE_RESULT__ERRORS = eINSTANCE.getCompileResult_Errors();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.RunResultImpl <em>Run Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.RunResultImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getRunResult()
		 * @generated
		 */
		EClass RUN_RESULT = eINSTANCE.getRunResult();

		/**
		 * The meta object literal for the '<em><b>Run Oke</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN_RESULT__RUN_OKE = eINSTANCE.getRunResult_RunOke();

		/**
		 * The meta object literal for the '<em><b>Warnings</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN_RESULT__WARNINGS = eINSTANCE.getRunResult_Warnings();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN_RESULT__ERRORS = eINSTANCE.getRunResult_Errors();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN_RESULT__OUTPUT = eINSTANCE.getRunResult_Output();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ServerInfoImpl <em>Server Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ServerInfoImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getServerInfo()
		 * @generated
		 */
		EClass SERVER_INFO = eINSTANCE.getServerInfo();

		/**
		 * The meta object literal for the '<em><b>Server State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_INFO__SERVER_STATE = eINSTANCE.getServerInfo_ServerState();

		/**
		 * The meta object literal for the '<em><b>Error Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_INFO__ERROR_MESSAGE = eINSTANCE.getServerInfo_ErrorMessage();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.VersionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getVersion()
		 * @generated
		 */
		EClass VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '<em><b>Major</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__MAJOR = eINSTANCE.getVersion_Major();

		/**
		 * The meta object literal for the '<em><b>Minor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__MINOR = eINSTANCE.getVersion_Minor();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__REVISION = eINSTANCE.getVersion_Revision();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__DATE = eINSTANCE.getVersion_Date();

		/**
		 * The meta object literal for the '<em><b>Download Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__DOWNLOAD_URL = eINSTANCE.getVersion_DownloadUrl();

		/**
		 * The meta object literal for the '<em><b>Support Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__SUPPORT_URL = eINSTANCE.getVersion_SupportUrl();

		/**
		 * The meta object literal for the '<em><b>Support Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__SUPPORT_EMAIL = eINSTANCE.getVersion_SupportEmail();

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

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.CompareIdentifier <em>Compare Identifier</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.CompareIdentifier
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompareIdentifier()
		 * @generated
		 */
		EEnum COMPARE_IDENTIFIER = eINSTANCE.getCompareIdentifier();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.CompareType <em>Compare Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.CompareType
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompareType()
		 * @generated
		 */
		EEnum COMPARE_TYPE = eINSTANCE.getCompareType();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.ActionState <em>Action State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.ActionState
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getActionState()
		 * @generated
		 */
		EEnum ACTION_STATE = eINSTANCE.getActionState();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.ServerState <em>Server State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.ServerState
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getServerState()
		 * @generated
		 */
		EEnum SERVER_STATE = eINSTANCE.getServerState();

		/**
		 * The meta object literal for the '<em>Data Handler</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.activation.DataHandler
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDataHandler()
		 * @generated
		 */
		EDataType DATA_HANDLER = eINSTANCE.getDataHandler();

	}

} //StorePackage
