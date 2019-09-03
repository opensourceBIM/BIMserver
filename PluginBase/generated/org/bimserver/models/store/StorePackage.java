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
	 * The feature id for the '<em><b>Export Length Measure Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__EXPORT_LENGTH_MEASURE_PREFIX = 15;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__EXTENDED_DATA = 16;

	/**
	 * The feature id for the '<em><b>Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__SERVICES = 17;

	/**
	 * The feature id for the '<em><b>Logs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__LOGS = 18;

	/**
	 * The feature id for the '<em><b>Model Checkers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__MODEL_CHECKERS = 19;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__SCHEMA = 20;

	/**
	 * The feature id for the '<em><b>Send Email On New Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__SEND_EMAIL_ON_NEW_REVISION = 21;

	/**
	 * The feature id for the '<em><b>New Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NEW_SERVICES = 22;

	/**
	 * The feature id for the '<em><b>Checkin In Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__CHECKIN_IN_PROGRESS = 23;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 24;

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
	 * The feature id for the '<em><b>Password Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PASSWORD_HASH = 1;

	/**
	 * The feature id for the '<em><b>Password Salt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PASSWORD_SALT = 2;

	/**
	 * The feature id for the '<em><b>Has Rights On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__HAS_RIGHTS_ON = 3;

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
	 * The feature id for the '<em><b>Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__TOKEN = 10;

	/**
	 * The feature id for the '<em><b>Validation Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__VALIDATION_TOKEN = 11;

	/**
	 * The feature id for the '<em><b>Validation Token Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__VALIDATION_TOKEN_CREATED = 12;

	/**
	 * The feature id for the '<em><b>User Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USER_SETTINGS = 13;

	/**
	 * The feature id for the '<em><b>Schemas</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__SCHEMAS = 14;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__EXTENDED_DATA = 15;

	/**
	 * The feature id for the '<em><b>Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__SERVICES = 16;

	/**
	 * The feature id for the '<em><b>Logs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__LOGS = 17;

	/**
	 * The feature id for the '<em><b>OAuth Authorization Codes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__OAUTH_AUTHORIZATION_CODES = 18;

	/**
	 * The feature id for the '<em><b>OAuth Issued Authorization Codes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__OAUTH_ISSUED_AUTHORIZATION_CODES = 19;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 20;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.RevisionImpl <em>Revision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.RevisionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getRevision()
	 * @generated
	 */
	int REVISION = 2;

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
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__TAG = 9;

	/**
	 * The feature id for the '<em><b>Last Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__LAST_ERROR = 10;

	/**
	 * The feature id for the '<em><b>Bmi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__BMI = 11;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__EXTENDED_DATA = 12;

	/**
	 * The feature id for the '<em><b>Logs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__LOGS = 13;

	/**
	 * The feature id for the '<em><b>Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__SERVICE = 14;

	/**
	 * The feature id for the '<em><b>Has Geometry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__HAS_GEOMETRY = 15;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__BOUNDS = 16;

	/**
	 * The feature id for the '<em><b>Bounds Untransformed</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__BOUNDS_UNTRANSFORMED = 17;

	/**
	 * The feature id for the '<em><b>Bounds Mm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__BOUNDS_MM = 18;

	/**
	 * The feature id for the '<em><b>Bounds Untransformed Mm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__BOUNDS_UNTRANSFORMED_MM = 19;

	/**
	 * The feature id for the '<em><b>Services Linked</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__SERVICES_LINKED = 20;

	/**
	 * The feature id for the '<em><b>Density Collection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__DENSITY_COLLECTION = 21;

	/**
	 * The feature id for the '<em><b>Nr Primitives</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__NR_PRIMITIVES = 22;

	/**
	 * The number of structural features of the '<em>Revision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_FEATURE_COUNT = 23;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ConcreteRevisionImpl <em>Concrete Revision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ConcreteRevisionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getConcreteRevision()
	 * @generated
	 */
	int CONCRETE_REVISION = 3;

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
	 * The feature id for the '<em><b>Checksum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__CHECKSUM = 2;

	/**
	 * The feature id for the '<em><b>Revisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__REVISIONS = 3;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__SIZE = 4;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__DATE = 5;

	/**
	 * The feature id for the '<em><b>Last Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__LAST_ERROR = 6;

	/**
	 * The feature id for the '<em><b>Clear</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__CLEAR = 7;

	/**
	 * The feature id for the '<em><b>Summary</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__SUMMARY = 8;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__USER = 9;

	/**
	 * The feature id for the '<em><b>Ifc Header</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__IFC_HEADER = 10;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__BOUNDS = 11;

	/**
	 * The feature id for the '<em><b>Bounds Untransformed</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__BOUNDS_UNTRANSFORMED = 12;

	/**
	 * The feature id for the '<em><b>Oid Counters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__OID_COUNTERS = 13;

	/**
	 * The feature id for the '<em><b>Multiplier To Mm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__MULTIPLIER_TO_MM = 14;

	/**
	 * The feature id for the '<em><b>Density Collection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION__DENSITY_COLLECTION = 15;

	/**
	 * The number of structural features of the '<em>Concrete Revision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_REVISION_FEATURE_COUNT = 16;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.GeoTagImpl <em>Geo Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.GeoTagImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getGeoTag()
	 * @generated
	 */
	int GEO_TAG = 4;

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
	int CHECKOUT = 5;

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
	 * The feature id for the '<em><b>Logs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT__LOGS = 6;

	/**
	 * The number of structural features of the '<em>Checkout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ServerSettingsImpl <em>Server Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ServerSettingsImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServerSettings()
	 * @generated
	 */
	int SERVER_SETTINGS = 6;

	/**
	 * The feature id for the '<em><b>Send Confirmation Email After Registration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__SEND_CONFIRMATION_EMAIL_AFTER_REGISTRATION = 0;

	/**
	 * The feature id for the '<em><b>Allow Self Registration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__ALLOW_SELF_REGISTRATION = 1;

	/**
	 * The feature id for the '<em><b>Allow Users To Create Top Level Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__ALLOW_USERS_TO_CREATE_TOP_LEVEL_PROJECTS = 2;

	/**
	 * The feature id for the '<em><b>Checkin Merging Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__CHECKIN_MERGING_ENABLED = 3;

	/**
	 * The feature id for the '<em><b>Smtp Server</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__SMTP_SERVER = 4;

	/**
	 * The feature id for the '<em><b>Email Sender Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__EMAIL_SENDER_ADDRESS = 5;

	/**
	 * The feature id for the '<em><b>Email Sender Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__EMAIL_SENDER_NAME = 6;

	/**
	 * The feature id for the '<em><b>Site Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__SITE_ADDRESS = 7;

	/**
	 * The feature id for the '<em><b>Generate Geometry On Checkin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__GENERATE_GEOMETRY_ON_CHECKIN = 8;

	/**
	 * The feature id for the '<em><b>Allow Only Whitelisted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__ALLOW_ONLY_WHITELISTED = 9;

	/**
	 * The feature id for the '<em><b>Whitelisted Domains</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__WHITELISTED_DOMAINS = 10;

	/**
	 * The feature id for the '<em><b>Hide User List For Non Admin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__HIDE_USER_LIST_FOR_NON_ADMIN = 11;

	/**
	 * The feature id for the '<em><b>Protocol Buffers Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__PROTOCOL_BUFFERS_PORT = 12;

	/**
	 * The feature id for the '<em><b>Cache Output Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__CACHE_OUTPUT_FILES = 13;

	/**
	 * The feature id for the '<em><b>Web Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__WEB_MODULES = 14;

	/**
	 * The feature id for the '<em><b>Web Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__WEB_MODULE = 15;

	/**
	 * The feature id for the '<em><b>Service Repository Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__SERVICE_REPOSITORY_URL = 16;

	/**
	 * The feature id for the '<em><b>Send Email On New Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__SEND_EMAIL_ON_NEW_REVISION = 17;

	/**
	 * The feature id for the '<em><b>Session Time Out Seconds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__SESSION_TIME_OUT_SECONDS = 18;

	/**
	 * The feature id for the '<em><b>Smtp Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__SMTP_USERNAME = 19;

	/**
	 * The feature id for the '<em><b>Smtp Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__SMTP_PASSWORD = 20;

	/**
	 * The feature id for the '<em><b>Smtp Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__SMTP_PORT = 21;

	/**
	 * The feature id for the '<em><b>Smtp Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__SMTP_PROTOCOL = 22;

	/**
	 * The feature id for the '<em><b>Reuse Geometry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__REUSE_GEOMETRY = 23;

	/**
	 * The feature id for the '<em><b>Allow Create Validated User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__ALLOW_CREATE_VALIDATED_USER = 24;

	/**
	 * The feature id for the '<em><b>Render Engine Processes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__RENDER_ENGINE_PROCESSES = 25;

	/**
	 * The feature id for the '<em><b>Plugin Strict Version Checking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__PLUGIN_STRICT_VERSION_CHECKING = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__NAME = 27;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__DESCRIPTION = 28;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__ICON = 29;

	/**
	 * The feature id for the '<em><b>Store Last Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__STORE_LAST_LOGIN = 30;

	/**
	 * The feature id for the '<em><b>Store Service Runs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__STORE_SERVICE_RUNS = 31;

	/**
	 * The feature id for the '<em><b>Optimize Mapped Items</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__OPTIMIZE_MAPPED_ITEMS = 32;

	/**
	 * The feature id for the '<em><b>Default Render Engine Plugin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS__DEFAULT_RENDER_ENGINE_PLUGIN = 33;

	/**
	 * The number of structural features of the '<em>Server Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_SETTINGS_FEATURE_COUNT = 34;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.UserSettingsImpl <em>User Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.UserSettingsImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getUserSettings()
	 * @generated
	 */
	int USER_SETTINGS = 7;

	/**
	 * The feature id for the '<em><b>Serializers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__SERIALIZERS = 0;

	/**
	 * The feature id for the '<em><b>Object ID Ms</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__OBJECT_ID_MS = 1;

	/**
	 * The feature id for the '<em><b>Render Engines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__RENDER_ENGINES = 2;

	/**
	 * The feature id for the '<em><b>Deserializers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__DESERIALIZERS = 3;

	/**
	 * The feature id for the '<em><b>Query Engines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__QUERY_ENGINES = 4;

	/**
	 * The feature id for the '<em><b>Model Mergers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__MODEL_MERGERS = 5;

	/**
	 * The feature id for the '<em><b>Model Compares</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__MODEL_COMPARES = 6;

	/**
	 * The feature id for the '<em><b>Default Model Merger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__DEFAULT_MODEL_MERGER = 7;

	/**
	 * The feature id for the '<em><b>Default Model Compare</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__DEFAULT_MODEL_COMPARE = 8;

	/**
	 * The feature id for the '<em><b>Default Query Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__DEFAULT_QUERY_ENGINE = 9;

	/**
	 * The feature id for the '<em><b>Default Render Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__DEFAULT_RENDER_ENGINE = 10;

	/**
	 * The feature id for the '<em><b>Default Serializer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__DEFAULT_SERIALIZER = 11;

	/**
	 * The feature id for the '<em><b>Default Object IDM</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__DEFAULT_OBJECT_IDM = 12;

	/**
	 * The feature id for the '<em><b>Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS__SERVICES = 13;

	/**
	 * The number of structural features of the '<em>User Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_SETTINGS_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.PluginConfigurationImpl <em>Plugin Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.PluginConfigurationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginConfiguration()
	 * @generated
	 */
	int PLUGIN_CONFIGURATION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_CONFIGURATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_CONFIGURATION__ENABLED = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_CONFIGURATION__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Plugin Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR = 3;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_CONFIGURATION__SETTINGS = 4;

	/**
	 * The number of structural features of the '<em>Plugin Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_CONFIGURATION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.SerializerPluginConfigurationImpl <em>Serializer Plugin Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.SerializerPluginConfigurationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getSerializerPluginConfiguration()
	 * @generated
	 */
	int SERIALIZER_PLUGIN_CONFIGURATION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_CONFIGURATION__NAME = PLUGIN_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_CONFIGURATION__ENABLED = PLUGIN_CONFIGURATION__ENABLED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_CONFIGURATION__DESCRIPTION = PLUGIN_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Plugin Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR = PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_CONFIGURATION__SETTINGS = PLUGIN_CONFIGURATION__SETTINGS;

	/**
	 * The feature id for the '<em><b>Object IDM</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_CONFIGURATION__OBJECT_IDM = PLUGIN_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>User Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_CONFIGURATION__USER_SETTINGS = PLUGIN_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Render Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_CONFIGURATION__RENDER_ENGINE = PLUGIN_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Streaming</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_CONFIGURATION__STREAMING = PLUGIN_CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Serializer Plugin Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZER_PLUGIN_CONFIGURATION_FEATURE_COUNT = PLUGIN_CONFIGURATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ObjectIDMPluginConfigurationImpl <em>Object IDM Plugin Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ObjectIDMPluginConfigurationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectIDMPluginConfiguration()
	 * @generated
	 */
	int OBJECT_IDM_PLUGIN_CONFIGURATION = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM_PLUGIN_CONFIGURATION__NAME = PLUGIN_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM_PLUGIN_CONFIGURATION__ENABLED = PLUGIN_CONFIGURATION__ENABLED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM_PLUGIN_CONFIGURATION__DESCRIPTION = PLUGIN_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Plugin Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM_PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR = PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM_PLUGIN_CONFIGURATION__SETTINGS = PLUGIN_CONFIGURATION__SETTINGS;

	/**
	 * The feature id for the '<em><b>Serializers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM_PLUGIN_CONFIGURATION__SERIALIZERS = PLUGIN_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>User Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM_PLUGIN_CONFIGURATION__USER_SETTINGS = PLUGIN_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object IDM Plugin Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_IDM_PLUGIN_CONFIGURATION_FEATURE_COUNT = PLUGIN_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.RenderEnginePluginConfigurationImpl <em>Render Engine Plugin Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.RenderEnginePluginConfigurationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getRenderEnginePluginConfiguration()
	 * @generated
	 */
	int RENDER_ENGINE_PLUGIN_CONFIGURATION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_ENGINE_PLUGIN_CONFIGURATION__NAME = PLUGIN_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_ENGINE_PLUGIN_CONFIGURATION__ENABLED = PLUGIN_CONFIGURATION__ENABLED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_ENGINE_PLUGIN_CONFIGURATION__DESCRIPTION = PLUGIN_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Plugin Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_ENGINE_PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR = PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_ENGINE_PLUGIN_CONFIGURATION__SETTINGS = PLUGIN_CONFIGURATION__SETTINGS;

	/**
	 * The feature id for the '<em><b>Serializers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_ENGINE_PLUGIN_CONFIGURATION__SERIALIZERS = PLUGIN_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>User Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_ENGINE_PLUGIN_CONFIGURATION__USER_SETTINGS = PLUGIN_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Render Engine Plugin Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDER_ENGINE_PLUGIN_CONFIGURATION_FEATURE_COUNT = PLUGIN_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DeserializerPluginConfigurationImpl <em>Deserializer Plugin Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DeserializerPluginConfigurationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDeserializerPluginConfiguration()
	 * @generated
	 */
	int DESERIALIZER_PLUGIN_CONFIGURATION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER_PLUGIN_CONFIGURATION__NAME = PLUGIN_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER_PLUGIN_CONFIGURATION__ENABLED = PLUGIN_CONFIGURATION__ENABLED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER_PLUGIN_CONFIGURATION__DESCRIPTION = PLUGIN_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Plugin Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER_PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR = PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER_PLUGIN_CONFIGURATION__SETTINGS = PLUGIN_CONFIGURATION__SETTINGS;

	/**
	 * The feature id for the '<em><b>User Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER_PLUGIN_CONFIGURATION__USER_SETTINGS = PLUGIN_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Deserializer Plugin Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESERIALIZER_PLUGIN_CONFIGURATION_FEATURE_COUNT = PLUGIN_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DownloadResultImpl <em>Download Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DownloadResultImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDownloadResult()
	 * @generated
	 */
	int DOWNLOAD_RESULT = 13;

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
	 * The feature id for the '<em><b>Serializer Oid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_RESULT__SERIALIZER_OID = 3;

	/**
	 * The number of structural features of the '<em>Download Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_RESULT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.CheckoutResultImpl <em>Checkout Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.CheckoutResultImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCheckoutResult()
	 * @generated
	 */
	int CHECKOUT_RESULT = 14;

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
	 * The feature id for the '<em><b>Serializer Oid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_RESULT__SERIALIZER_OID = DOWNLOAD_RESULT__SERIALIZER_OID;

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
	int DATA_VALUE = 15;

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
	int DATA_OBJECT = 16;

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
	int USER_SESSION = 17;

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
	int MIGRATION = 18;

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
	int REFERENCE_DATA_VALUE = 19;

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
	int LIST_DATA_VALUE = 20;

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
	int SIMPLE_DATA_VALUE = 21;

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
	int DATABASE_INFORMATION_ITEM = 22;

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
	int DATABASE_INFORMATION_CATEGORY = 23;

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
	int DATABASE_INFORMATION = 24;

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
	 * The meta object id for the '{@link org.bimserver.models.store.impl.PluginDescriptorImpl <em>Plugin Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.PluginDescriptorImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginDescriptor()
	 * @generated
	 */
	int PLUGIN_DESCRIPTOR = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Plugin Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__LOCATION = 3;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__ENABLED = 4;

	/**
	 * The feature id for the '<em><b>Plugin Interface Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__PLUGIN_INTERFACE_CLASS_NAME = 5;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__CONFIGURATIONS = 6;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__IDENTIFIER = 7;

	/**
	 * The feature id for the '<em><b>Install For New Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__INSTALL_FOR_NEW_USERS = 8;

	/**
	 * The feature id for the '<em><b>Plugin Bundle Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__PLUGIN_BUNDLE_VERSION = 9;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR__SETTINGS = 10;

	/**
	 * The number of structural features of the '<em>Plugin Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_DESCRIPTOR_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.RevisionSummaryTypeImpl <em>Revision Summary Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.RevisionSummaryTypeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getRevisionSummaryType()
	 * @generated
	 */
	int REVISION_SUMMARY_TYPE = 26;

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
	 * The feature id for the '<em><b>Schema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_SUMMARY_TYPE__SCHEMA = 2;

	/**
	 * The number of structural features of the '<em>Revision Summary Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_SUMMARY_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.RevisionSummaryContainerImpl <em>Revision Summary Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.RevisionSummaryContainerImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getRevisionSummaryContainer()
	 * @generated
	 */
	int REVISION_SUMMARY_CONTAINER = 27;

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
	int REVISION_SUMMARY = 28;

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
	 * The meta object id for the '{@link org.bimserver.models.store.impl.LongActionImpl <em>Long Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.LongActionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getLongAction()
	 * @generated
	 */
	int LONG_ACTION = 29;

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
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ObjectIDMPluginDescriptorImpl <em>Object IDM Plugin Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ObjectIDMPluginDescriptorImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectIDMPluginDescriptor()
	 * @generated
	 */
	int OBJECT_IDM_PLUGIN_DESCRIPTOR = 30;

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
	int COMPARE_ITEM = 31;

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
	int OBJECT_ADDED = 32;

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
	int OBJECT_REMOVED = 33;

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
	int OBJECT_MODIFIED = 34;

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
	int COMPARE_CONTAINER = 35;

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
	int COMPARE_RESULT = 36;

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
	int LONG_ACTION_STATE = 37;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE__START = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE__END = 1;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE__PROGRESS = 2;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE__STATE = 3;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE__TITLE = 4;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE__STAGE = 5;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE__ERRORS = 6;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE__WARNINGS = 7;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE__INFOS = 8;

	/**
	 * The feature id for the '<em><b>Topic Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE__TOPIC_ID = 9;

	/**
	 * The number of structural features of the '<em>Long Action State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_ACTION_STATE_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ServerInfoImpl <em>Server Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ServerInfoImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServerInfo()
	 * @generated
	 */
	int SERVER_INFO = 38;

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
	 * The feature id for the '<em><b>Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__VERSION = 2;

	/**
	 * The number of structural features of the '<em>Server Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.VersionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 39;

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
	 * The feature id for the '<em><b>Full String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__FULL_STRING = 3;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__DATE = 4;

	/**
	 * The feature id for the '<em><b>Download Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__DOWNLOAD_URL = 5;

	/**
	 * The feature id for the '<em><b>Support Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__SUPPORT_URL = 6;

	/**
	 * The feature id for the '<em><b>Support Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__SUPPORT_EMAIL = 7;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.FileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.FileImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getFile()
	 * @generated
	 */
	int FILE = 40;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__DATA = 0;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__FILENAME = 1;

	/**
	 * The feature id for the '<em><b>Mime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__MIME = 2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__SIZE = 3;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ExtendedDataSchemaImpl <em>Extended Data Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ExtendedDataSchemaImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getExtendedDataSchema()
	 * @generated
	 */
	int EXTENDED_DATA_SCHEMA = 41;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_SCHEMA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_SCHEMA__URL = 1;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_SCHEMA__CONTENT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_SCHEMA__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>File</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_SCHEMA__FILE = 4;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_SCHEMA__SIZE = 5;

	/**
	 * The feature id for the '<em><b>Users</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_SCHEMA__USERS = 6;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_SCHEMA__EXTENDED_DATA = 7;

	/**
	 * The number of structural features of the '<em>Extended Data Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_SCHEMA_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ExtendedDataImpl <em>Extended Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ExtendedDataImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getExtendedData()
	 * @generated
	 */
	int EXTENDED_DATA = 42;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA__URL = 0;

	/**
	 * The feature id for the '<em><b>File</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA__FILE = 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA__SIZE = 2;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA__TITLE = 3;

	/**
	 * The feature id for the '<em><b>Added</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA__ADDED = 4;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA__USER = 5;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA__SCHEMA = 6;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA__REVISION = 7;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA__PROJECT = 8;

	/**
	 * The feature id for the '<em><b>Time To Generate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA__TIME_TO_GENERATE = 9;

	/**
	 * The number of structural features of the '<em>Extended Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.QueryEnginePluginConfigurationImpl <em>Query Engine Plugin Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.QueryEnginePluginConfigurationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getQueryEnginePluginConfiguration()
	 * @generated
	 */
	int QUERY_ENGINE_PLUGIN_CONFIGURATION = 43;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_ENGINE_PLUGIN_CONFIGURATION__NAME = PLUGIN_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_ENGINE_PLUGIN_CONFIGURATION__ENABLED = PLUGIN_CONFIGURATION__ENABLED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_ENGINE_PLUGIN_CONFIGURATION__DESCRIPTION = PLUGIN_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Plugin Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_ENGINE_PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR = PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_ENGINE_PLUGIN_CONFIGURATION__SETTINGS = PLUGIN_CONFIGURATION__SETTINGS;

	/**
	 * The feature id for the '<em><b>User Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_ENGINE_PLUGIN_CONFIGURATION__USER_SETTINGS = PLUGIN_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Query Engine Plugin Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_ENGINE_PLUGIN_CONFIGURATION_FEATURE_COUNT = PLUGIN_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.WebModulePluginConfigurationImpl <em>Web Module Plugin Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.WebModulePluginConfigurationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getWebModulePluginConfiguration()
	 * @generated
	 */
	int WEB_MODULE_PLUGIN_CONFIGURATION = 44;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_PLUGIN_CONFIGURATION__NAME = PLUGIN_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_PLUGIN_CONFIGURATION__ENABLED = PLUGIN_CONFIGURATION__ENABLED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_PLUGIN_CONFIGURATION__DESCRIPTION = PLUGIN_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Plugin Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR = PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_PLUGIN_CONFIGURATION__SETTINGS = PLUGIN_CONFIGURATION__SETTINGS;

	/**
	 * The feature id for the '<em><b>Server Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_PLUGIN_CONFIGURATION__SERVER_SETTINGS = PLUGIN_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Web Module Plugin Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_MODULE_PLUGIN_CONFIGURATION_FEATURE_COUNT = PLUGIN_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ModelMergerPluginConfigurationImpl <em>Model Merger Plugin Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ModelMergerPluginConfigurationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelMergerPluginConfiguration()
	 * @generated
	 */
	int MODEL_MERGER_PLUGIN_CONFIGURATION = 45;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_MERGER_PLUGIN_CONFIGURATION__NAME = PLUGIN_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_MERGER_PLUGIN_CONFIGURATION__ENABLED = PLUGIN_CONFIGURATION__ENABLED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_MERGER_PLUGIN_CONFIGURATION__DESCRIPTION = PLUGIN_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Plugin Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_MERGER_PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR = PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_MERGER_PLUGIN_CONFIGURATION__SETTINGS = PLUGIN_CONFIGURATION__SETTINGS;

	/**
	 * The feature id for the '<em><b>User Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_MERGER_PLUGIN_CONFIGURATION__USER_SETTINGS = PLUGIN_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Merger Plugin Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_MERGER_PLUGIN_CONFIGURATION_FEATURE_COUNT = PLUGIN_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ModelComparePluginConfigurationImpl <em>Model Compare Plugin Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ModelComparePluginConfigurationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelComparePluginConfiguration()
	 * @generated
	 */
	int MODEL_COMPARE_PLUGIN_CONFIGURATION = 46;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_COMPARE_PLUGIN_CONFIGURATION__NAME = PLUGIN_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_COMPARE_PLUGIN_CONFIGURATION__ENABLED = PLUGIN_CONFIGURATION__ENABLED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_COMPARE_PLUGIN_CONFIGURATION__DESCRIPTION = PLUGIN_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Plugin Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_COMPARE_PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR = PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_COMPARE_PLUGIN_CONFIGURATION__SETTINGS = PLUGIN_CONFIGURATION__SETTINGS;

	/**
	 * The feature id for the '<em><b>User Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_COMPARE_PLUGIN_CONFIGURATION__USER_SETTINGS = PLUGIN_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Compare Plugin Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_COMPARE_PLUGIN_CONFIGURATION_FEATURE_COUNT = PLUGIN_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ProfileDescriptorImpl <em>Profile Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ProfileDescriptorImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getProfileDescriptor()
	 * @generated
	 */
	int PROFILE_DESCRIPTOR = 47;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_DESCRIPTOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_DESCRIPTOR__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Public Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_DESCRIPTOR__PUBLIC_PROFILE = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_DESCRIPTOR__IDENTIFIER = 3;

	/**
	 * The number of structural features of the '<em>Profile Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_DESCRIPTOR_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ServiceDescriptorImpl <em>Service Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ServiceDescriptorImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceDescriptor()
	 * @generated
	 */
	int SERVICE_DESCRIPTOR = 48;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__URL = 1;

	/**
	 * The feature id for the '<em><b>Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__TOKEN = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__IDENTIFIER = 3;

	/**
	 * The feature id for the '<em><b>Notification Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__NOTIFICATION_PROTOCOL = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__TRIGGER = 6;

	/**
	 * The feature id for the '<em><b>Read Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__READ_REVISION = 7;

	/**
	 * The feature id for the '<em><b>Read Extended Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__READ_EXTENDED_DATA = 8;

	/**
	 * The feature id for the '<em><b>Write Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__WRITE_REVISION = 9;

	/**
	 * The feature id for the '<em><b>Write Extended Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__WRITE_EXTENDED_DATA = 10;

	/**
	 * The feature id for the '<em><b>Provider Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__PROVIDER_NAME = 11;

	/**
	 * The feature id for the '<em><b>Company Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__COMPANY_URL = 12;

	/**
	 * The feature id for the '<em><b>Token Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__TOKEN_URL = 13;

	/**
	 * The feature id for the '<em><b>New Profile Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__NEW_PROFILE_URL = 14;

	/**
	 * The feature id for the '<em><b>Register Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__REGISTER_URL = 15;

	/**
	 * The feature id for the '<em><b>Authorize Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR__AUTHORIZE_URL = 16;

	/**
	 * The number of structural features of the '<em>Service Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DESCRIPTOR_FEATURE_COUNT = 17;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ServiceImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 49;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Service Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_IDENTIFIER = 2;

	/**
	 * The feature id for the '<em><b>Provider Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PROVIDER_NAME = 3;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__URL = 4;

	/**
	 * The feature id for the '<em><b>Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__TOKEN = 5;

	/**
	 * The feature id for the '<em><b>Notification Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NOTIFICATION_PROTOCOL = 6;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = 7;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__TRIGGER = 8;

	/**
	 * The feature id for the '<em><b>Read Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__READ_REVISION = 9;

	/**
	 * The feature id for the '<em><b>Read Extended Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__READ_EXTENDED_DATA = 10;

	/**
	 * The feature id for the '<em><b>Write Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__WRITE_REVISION = 11;

	/**
	 * The feature id for the '<em><b>Write Extended Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__WRITE_EXTENDED_DATA = 12;

	/**
	 * The feature id for the '<em><b>Profile Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PROFILE_IDENTIFIER = 13;

	/**
	 * The feature id for the '<em><b>Profile Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PROFILE_NAME = 14;

	/**
	 * The feature id for the '<em><b>Profile Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PROFILE_DESCRIPTION = 15;

	/**
	 * The feature id for the '<em><b>Profile Public</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PROFILE_PUBLIC = 16;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PROJECT = 17;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__USER = 18;

	/**
	 * The feature id for the '<em><b>Internal Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__INTERNAL_SERVICE = 19;

	/**
	 * The feature id for the '<em><b>Model Checkers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__MODEL_CHECKERS = 20;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 21;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.TokenImpl <em>Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.TokenImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getToken()
	 * @generated
	 */
	int TOKEN = 50;

	/**
	 * The feature id for the '<em><b>Token String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__TOKEN_STRING = 0;

	/**
	 * The feature id for the '<em><b>Expires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__EXPIRES = 1;

	/**
	 * The number of structural features of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.InternalServicePluginConfigurationImpl <em>Internal Service Plugin Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.InternalServicePluginConfigurationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getInternalServicePluginConfiguration()
	 * @generated
	 */
	int INTERNAL_SERVICE_PLUGIN_CONFIGURATION = 51;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_SERVICE_PLUGIN_CONFIGURATION__NAME = PLUGIN_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_SERVICE_PLUGIN_CONFIGURATION__ENABLED = PLUGIN_CONFIGURATION__ENABLED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_SERVICE_PLUGIN_CONFIGURATION__DESCRIPTION = PLUGIN_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Plugin Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_SERVICE_PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR = PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_SERVICE_PLUGIN_CONFIGURATION__SETTINGS = PLUGIN_CONFIGURATION__SETTINGS;

	/**
	 * The feature id for the '<em><b>Remote Accessible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_SERVICE_PLUGIN_CONFIGURATION__REMOTE_ACCESSIBLE = PLUGIN_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>User Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_SERVICE_PLUGIN_CONFIGURATION__USER_SETTINGS = PLUGIN_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Public Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_SERVICE_PLUGIN_CONFIGURATION__PUBLIC_PROFILE = PLUGIN_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Internal Service Plugin Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_SERVICE_PLUGIN_CONFIGURATION_FEATURE_COUNT = PLUGIN_CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ServiceInterfaceImpl <em>Service Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ServiceInterfaceImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceInterface()
	 * @generated
	 */
	int SERVICE_INTERFACE = 52;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Name Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE__NAME_SPACE = 1;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE__SIMPLE_NAME = 2;

	/**
	 * The number of structural features of the '<em>Service Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ServiceMethodImpl <em>Service Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ServiceMethodImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceMethod()
	 * @generated
	 */
	int SERVICE_METHOD = 53;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_METHOD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_METHOD__DOC = 1;

	/**
	 * The feature id for the '<em><b>Return Doc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_METHOD__RETURN_DOC = 2;

	/**
	 * The number of structural features of the '<em>Service Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_METHOD_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ServiceFieldImpl <em>Service Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ServiceFieldImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceField()
	 * @generated
	 */
	int SERVICE_FIELD = 54;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FIELD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FIELD__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Generic Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FIELD__GENERIC_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FIELD__DOC = 3;

	/**
	 * The number of structural features of the '<em>Service Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FIELD_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ServiceTypeImpl <em>Service Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ServiceTypeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceType()
	 * @generated
	 */
	int SERVICE_TYPE = 55;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TYPE__SIMPLE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TYPE__FIELDS = 2;

	/**
	 * The feature id for the '<em><b>Simple Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TYPE__SIMPLE_TYPE = 3;

	/**
	 * The number of structural features of the '<em>Service Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ServiceParameterImpl <em>Service Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ServiceParameterImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceParameter()
	 * @generated
	 */
	int SERVICE_PARAMETER = 56;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PARAMETER__DOC = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PARAMETER__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Generic Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PARAMETER__GENERIC_TYPE = 3;

	/**
	 * The number of structural features of the '<em>Service Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PARAMETER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.TypeDefinitionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getTypeDefinition()
	 * @generated
	 */
	int TYPE_DEFINITION = 57;

	/**
	 * The number of structural features of the '<em>Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ObjectDefinitionImpl <em>Object Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ObjectDefinitionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectDefinition()
	 * @generated
	 */
	int OBJECT_DEFINITION = 58;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DEFINITION__PARAMETERS = TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DEFINITION_FEATURE_COUNT = TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.PrimitiveDefinitionImpl <em>Primitive Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.PrimitiveDefinitionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPrimitiveDefinition()
	 * @generated
	 */
	int PRIMITIVE_DEFINITION = 59;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DEFINITION__TYPE = TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DEFINITION_FEATURE_COUNT = TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ArrayDefinitionImpl <em>Array Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ArrayDefinitionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getArrayDefinition()
	 * @generated
	 */
	int ARRAY_DEFINITION = 60;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DEFINITION__TYPE = TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DEFINITION_FEATURE_COUNT = TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ParameterDefinitionImpl <em>Parameter Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ParameterDefinitionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getParameterDefinition()
	 * @generated
	 */
	int PARAMETER_DEFINITION = 61;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__IDENTIFIER = 1;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__REQUIRED = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__TYPE = 4;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION__DEFAULT_VALUE = 5;

	/**
	 * The number of structural features of the '<em>Parameter Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DEFINITION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.TypeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getType()
	 * @generated
	 */
	int TYPE = 62;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ObjectTypeImpl <em>Object Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ObjectTypeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectType()
	 * @generated
	 */
	int OBJECT_TYPE = 63;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__NAME = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__PARAMETERS = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.PrimitiveTypeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 64;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.LongTypeImpl <em>Long Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.LongTypeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getLongType()
	 * @generated
	 */
	int LONG_TYPE = 65;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_TYPE__VALUE = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Long Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ByteArrayTypeImpl <em>Byte Array Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ByteArrayTypeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getByteArrayType()
	 * @generated
	 */
	int BYTE_ARRAY_TYPE = 66;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_ARRAY_TYPE__VALUE = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Byte Array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_ARRAY_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DoubleTypeImpl <em>Double Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DoubleTypeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDoubleType()
	 * @generated
	 */
	int DOUBLE_TYPE = 67;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE__VALUE = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.StringTypeImpl <em>String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.StringTypeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 68;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__VALUE = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.BooleanTypeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 69;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__VALUE = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ArrayTypeImpl <em>Array Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ArrayTypeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getArrayType()
	 * @generated
	 */
	int ARRAY_TYPE = 70;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__VALUES = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ParameterImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 71;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ImmediateNotificationResultImpl <em>Immediate Notification Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ImmediateNotificationResultImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getImmediateNotificationResult()
	 * @generated
	 */
	int IMMEDIATE_NOTIFICATION_RESULT = 72;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMMEDIATE_NOTIFICATION_RESULT__RESULT = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMMEDIATE_NOTIFICATION_RESULT__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>Immediate Notification Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMMEDIATE_NOTIFICATION_RESULT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.RemoteServiceUpdateImpl <em>Remote Service Update</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.RemoteServiceUpdateImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getRemoteServiceUpdate()
	 * @generated
	 */
	int REMOTE_SERVICE_UPDATE = 73;

	/**
	 * The number of structural features of the '<em>Remote Service Update</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SERVICE_UPDATE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.PercentageChangeImpl <em>Percentage Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.PercentageChangeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPercentageChange()
	 * @generated
	 */
	int PERCENTAGE_CHANGE = 74;

	/**
	 * The feature id for the '<em><b>Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCENTAGE_CHANGE__PERCENTAGE = REMOTE_SERVICE_UPDATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Percentage Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERCENTAGE_CHANGE_FEATURE_COUNT = REMOTE_SERVICE_UPDATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.SystemInfoImpl <em>System Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.SystemInfoImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getSystemInfo()
	 * @generated
	 */
	int SYSTEM_INFO = 75;

	/**
	 * The feature id for the '<em><b>Cpucores</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO__CPUCORES = 0;

	/**
	 * The feature id for the '<em><b>Datetime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO__DATETIME = 1;

	/**
	 * The feature id for the '<em><b>Osname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO__OSNAME = 2;

	/**
	 * The feature id for the '<em><b>Osversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO__OSVERSION = 3;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO__USER_NAME = 4;

	/**
	 * The feature id for the '<em><b>User Home</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO__USER_HOME = 5;

	/**
	 * The feature id for the '<em><b>User Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO__USER_DIR = 6;

	/**
	 * The number of structural features of the '<em>System Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.JavaInfoImpl <em>Java Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.JavaInfoImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getJavaInfo()
	 * @generated
	 */
	int JAVA_INFO = 76;

	/**
	 * The feature id for the '<em><b>Heap Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__HEAP_TOTAL = 0;

	/**
	 * The feature id for the '<em><b>Heap Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__HEAP_USED = 1;

	/**
	 * The feature id for the '<em><b>Heap Free</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__HEAP_FREE = 2;

	/**
	 * The feature id for the '<em><b>Heap Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__HEAP_MAX = 3;

	/**
	 * The feature id for the '<em><b>Threads</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__THREADS = 4;

	/**
	 * The feature id for the '<em><b>Java Home</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVA_HOME = 5;

	/**
	 * The feature id for the '<em><b>Java Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVA_VERSION = 6;

	/**
	 * The feature id for the '<em><b>Java Vendor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVA_VENDOR = 7;

	/**
	 * The feature id for the '<em><b>Java Vendorurl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVA_VENDORURL = 8;

	/**
	 * The feature id for the '<em><b>Javavm Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVAVM_VERSION = 9;

	/**
	 * The feature id for the '<em><b>Javavm Vendor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVAVM_VENDOR = 10;

	/**
	 * The feature id for the '<em><b>Javavm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVAVM_NAME = 11;

	/**
	 * The feature id for the '<em><b>Javaspec Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVASPEC_VERSION = 12;

	/**
	 * The feature id for the '<em><b>Javaspec Vendor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVASPEC_VENDOR = 13;

	/**
	 * The feature id for the '<em><b>Javaspec Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVASPEC_NAME = 14;

	/**
	 * The feature id for the '<em><b>Java Class Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVA_CLASS_VERSION = 15;

	/**
	 * The feature id for the '<em><b>Java Classpath</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVA_CLASSPATH = 16;

	/**
	 * The feature id for the '<em><b>Java Librarypath</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVA_LIBRARYPATH = 17;

	/**
	 * The feature id for the '<em><b>Java Io Tmp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVA_IO_TMP = 18;

	/**
	 * The feature id for the '<em><b>Java Extdir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVA_EXTDIR = 19;

	/**
	 * The feature id for the '<em><b>Java File Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVA_FILE_SEPARATOR = 20;

	/**
	 * The feature id for the '<em><b>Java Path Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVA_PATH_SEPARATOR = 21;

	/**
	 * The feature id for the '<em><b>Java Line Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__JAVA_LINE_SEPARATOR = 22;

	/**
	 * The number of structural features of the '<em>Java Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO_FEATURE_COUNT = 23;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.BimServerInfoImpl <em>Bim Server Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.BimServerInfoImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getBimServerInfo()
	 * @generated
	 */
	int BIM_SERVER_INFO = 77;

	/**
	 * The feature id for the '<em><b>Current Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIM_SERVER_INFO__CURRENT_VERSION = 0;

	/**
	 * The feature id for the '<em><b>Current Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIM_SERVER_INFO__CURRENT_DATE = 1;

	/**
	 * The feature id for the '<em><b>Schema Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIM_SERVER_INFO__SCHEMA_VERSION = 2;

	/**
	 * The feature id for the '<em><b>Latest Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIM_SERVER_INFO__LATEST_DATE = 3;

	/**
	 * The feature id for the '<em><b>Latest Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIM_SERVER_INFO__LATEST_VERSION = 4;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIM_SERVER_INFO__PROJECTS = 5;

	/**
	 * The feature id for the '<em><b>Revisions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIM_SERVER_INFO__REVISIONS = 6;

	/**
	 * The feature id for the '<em><b>Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIM_SERVER_INFO__USERS = 7;

	/**
	 * The feature id for the '<em><b>Checkouts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIM_SERVER_INFO__CHECKOUTS = 8;

	/**
	 * The feature id for the '<em><b>Server Log Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIM_SERVER_INFO__SERVER_LOG_URL = 9;

	/**
	 * The feature id for the '<em><b>Started</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIM_SERVER_INFO__STARTED = 10;

	/**
	 * The number of structural features of the '<em>Bim Server Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIM_SERVER_INFO_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ProjectSmallImpl <em>Project Small</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ProjectSmallImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getProjectSmall()
	 * @generated
	 */
	int PROJECT_SMALL = 78;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SMALL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Parent Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SMALL__PARENT_ID = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SMALL__STATE = 2;

	/**
	 * The feature id for the '<em><b>Nr Revisions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SMALL__NR_REVISIONS = 3;

	/**
	 * The feature id for the '<em><b>Nr Sub Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SMALL__NR_SUB_PROJECTS = 4;

	/**
	 * The feature id for the '<em><b>Has Checkin Rights</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SMALL__HAS_CHECKIN_RIGHTS = 5;

	/**
	 * The feature id for the '<em><b>Last Revision Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SMALL__LAST_REVISION_ID = 6;

	/**
	 * The feature id for the '<em><b>Schema</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SMALL__SCHEMA = 7;

	/**
	 * The number of structural features of the '<em>Project Small</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SMALL_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.IfcHeaderImpl <em>Ifc Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.IfcHeaderImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getIfcHeader()
	 * @generated
	 */
	int IFC_HEADER = 79;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_HEADER__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Implementation Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_HEADER__IMPLEMENTATION_LEVEL = 1;

	/**
	 * The feature id for the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_HEADER__FILENAME = 2;

	/**
	 * The feature id for the '<em><b>Time Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_HEADER__TIME_STAMP = 3;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_HEADER__AUTHOR = 4;

	/**
	 * The feature id for the '<em><b>Organization</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_HEADER__ORGANIZATION = 5;

	/**
	 * The feature id for the '<em><b>Pre Processor Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_HEADER__PRE_PROCESSOR_VERSION = 6;

	/**
	 * The feature id for the '<em><b>Originating System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_HEADER__ORIGINATING_SYSTEM = 7;

	/**
	 * The feature id for the '<em><b>Ifc Schema Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_HEADER__IFC_SCHEMA_VERSION = 8;

	/**
	 * The feature id for the '<em><b>Authorization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_HEADER__AUTHORIZATION = 9;

	/**
	 * The number of structural features of the '<em>Ifc Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFC_HEADER_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ModelCheckerResultItemImpl <em>Model Checker Result Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ModelCheckerResultItemImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelCheckerResultItem()
	 * @generated
	 */
	int MODEL_CHECKER_RESULT_ITEM = 80;

	/**
	 * The number of structural features of the '<em>Model Checker Result Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_RESULT_ITEM_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ModelCheckerResultHeaderImpl <em>Model Checker Result Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ModelCheckerResultHeaderImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelCheckerResultHeader()
	 * @generated
	 */
	int MODEL_CHECKER_RESULT_HEADER = 81;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_RESULT_HEADER__TEXT = MODEL_CHECKER_RESULT_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Checker Result Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_RESULT_HEADER_FEATURE_COUNT = MODEL_CHECKER_RESULT_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ModelCheckerResultLineImpl <em>Model Checker Result Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ModelCheckerResultLineImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelCheckerResultLine()
	 * @generated
	 */
	int MODEL_CHECKER_RESULT_LINE = 82;

	/**
	 * The feature id for the '<em><b>Field Or Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_RESULT_LINE__FIELD_OR_CLASS = MODEL_CHECKER_RESULT_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_RESULT_LINE__VALUE = MODEL_CHECKER_RESULT_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Should Be</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_RESULT_LINE__SHOULD_BE = MODEL_CHECKER_RESULT_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_RESULT_LINE__TYPE = MODEL_CHECKER_RESULT_ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Object Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_RESULT_LINE__OBJECT_ID = MODEL_CHECKER_RESULT_ITEM_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Model Checker Result Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_RESULT_LINE_FEATURE_COUNT = MODEL_CHECKER_RESULT_ITEM_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ModelCheckerResultImpl <em>Model Checker Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ModelCheckerResultImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelCheckerResult()
	 * @generated
	 */
	int MODEL_CHECKER_RESULT = 83;

	/**
	 * The feature id for the '<em><b>Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_RESULT__VALID = 0;

	/**
	 * The feature id for the '<em><b>Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_RESULT__ITEMS = 1;

	/**
	 * The number of structural features of the '<em>Model Checker Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_RESULT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ModelCheckerInstanceImpl <em>Model Checker Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ModelCheckerInstanceImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelCheckerInstance()
	 * @generated
	 */
	int MODEL_CHECKER_INSTANCE = 84;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_INSTANCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_INSTANCE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_INSTANCE__CODE = 2;

	/**
	 * The feature id for the '<em><b>Compiled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_INSTANCE__COMPILED = 3;

	/**
	 * The feature id for the '<em><b>Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_INSTANCE__VALID = 4;

	/**
	 * The feature id for the '<em><b>Model Checker Plugin Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_INSTANCE__MODEL_CHECKER_PLUGIN_CLASS_NAME = 5;

	/**
	 * The number of structural features of the '<em>Model Checker Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHECKER_INSTANCE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.MessagingSerializerPluginConfigurationImpl <em>Messaging Serializer Plugin Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.MessagingSerializerPluginConfigurationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getMessagingSerializerPluginConfiguration()
	 * @generated
	 */
	int MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION = 85;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION__NAME = SERIALIZER_PLUGIN_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION__ENABLED = SERIALIZER_PLUGIN_CONFIGURATION__ENABLED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION__DESCRIPTION = SERIALIZER_PLUGIN_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Plugin Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR = SERIALIZER_PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION__SETTINGS = SERIALIZER_PLUGIN_CONFIGURATION__SETTINGS;

	/**
	 * The feature id for the '<em><b>Object IDM</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION__OBJECT_IDM = SERIALIZER_PLUGIN_CONFIGURATION__OBJECT_IDM;

	/**
	 * The feature id for the '<em><b>User Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION__USER_SETTINGS = SERIALIZER_PLUGIN_CONFIGURATION__USER_SETTINGS;

	/**
	 * The feature id for the '<em><b>Render Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION__RENDER_ENGINE = SERIALIZER_PLUGIN_CONFIGURATION__RENDER_ENGINE;

	/**
	 * The feature id for the '<em><b>Streaming</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION__STREAMING = SERIALIZER_PLUGIN_CONFIGURATION__STREAMING;

	/**
	 * The number of structural features of the '<em>Messaging Serializer Plugin Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION_FEATURE_COUNT = SERIALIZER_PLUGIN_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.MetricsImpl <em>Metrics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.MetricsImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getMetrics()
	 * @generated
	 */
	int METRICS = 86;

	/**
	 * The feature id for the '<em><b>Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__INTERFACES = 0;

	/**
	 * The number of structural features of the '<em>Metrics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.InterfaceMetricImpl <em>Interface Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.InterfaceMetricImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getInterfaceMetric()
	 * @generated
	 */
	int INTERFACE_METRIC = 87;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_METRIC__METHODS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_METRIC__NAME = 1;

	/**
	 * The number of structural features of the '<em>Interface Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_METRIC_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.MethodMetricImpl <em>Method Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.MethodMetricImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getMethodMetric()
	 * @generated
	 */
	int METHOD_METRIC = 88;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_METRIC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Nr Calls</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_METRIC__NR_CALLS = 1;

	/**
	 * The feature id for the '<em><b>Last Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_METRIC__LAST_CALL = 2;

	/**
	 * The feature id for the '<em><b>Average Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_METRIC__AVERAGE_MS = 3;

	/**
	 * The feature id for the '<em><b>Shortest Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_METRIC__SHORTEST_MS = 4;

	/**
	 * The feature id for the '<em><b>Longest Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_METRIC__LONGEST_MS = 5;

	/**
	 * The number of structural features of the '<em>Method Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_METRIC_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.PluginBundleVersionImpl <em>Plugin Bundle Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.PluginBundleVersionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginBundleVersion()
	 * @generated
	 */
	int PLUGIN_BUNDLE_VERSION = 89;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_VERSION__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_VERSION__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_VERSION__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Mismatch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_VERSION__MISMATCH = 3;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_VERSION__REPOSITORY = 4;

	/**
	 * The feature id for the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_VERSION__GROUP_ID = 5;

	/**
	 * The feature id for the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_VERSION__ARTIFACT_ID = 6;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_VERSION__ICON = 7;

	/**
	 * The feature id for the '<em><b>Organization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_VERSION__ORGANIZATION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_VERSION__NAME = 9;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_VERSION__DATE = 10;

	/**
	 * The number of structural features of the '<em>Plugin Bundle Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_VERSION_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.PluginBundleImpl <em>Plugin Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.PluginBundleImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginBundle()
	 * @generated
	 */
	int PLUGIN_BUNDLE = 90;

	/**
	 * The feature id for the '<em><b>Organization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE__ORGANIZATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Latest Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE__LATEST_VERSION = 2;

	/**
	 * The feature id for the '<em><b>Available Versions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE__AVAILABLE_VERSIONS = 3;

	/**
	 * The feature id for the '<em><b>Installed Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE__INSTALLED_VERSION = 4;

	/**
	 * The number of structural features of the '<em>Plugin Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_BUNDLE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.PluginInformationImpl <em>Plugin Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.PluginInformationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginInformation()
	 * @generated
	 */
	int PLUGIN_INFORMATION = 91;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_INFORMATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_INFORMATION__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_INFORMATION__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_INFORMATION__ENABLED = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_INFORMATION__IDENTIFIER = 4;

	/**
	 * The feature id for the '<em><b>Install For All Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_INFORMATION__INSTALL_FOR_ALL_USERS = 5;

	/**
	 * The feature id for the '<em><b>Install For New Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_INFORMATION__INSTALL_FOR_NEW_USERS = 6;

	/**
	 * The number of structural features of the '<em>Plugin Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_INFORMATION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.OAuthServerImpl <em>OAuth Server</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.OAuthServerImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getOAuthServer()
	 * @generated
	 */
	int OAUTH_SERVER = 92;

	/**
	 * The feature id for the '<em><b>Registration Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__REGISTRATION_URL = 0;

	/**
	 * The feature id for the '<em><b>Client Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__CLIENT_ID = 1;

	/**
	 * The feature id for the '<em><b>Client Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__CLIENT_SECRET = 2;

	/**
	 * The feature id for the '<em><b>Client Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__CLIENT_NAME = 3;

	/**
	 * The feature id for the '<em><b>Client Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__CLIENT_ICON = 4;

	/**
	 * The feature id for the '<em><b>Client Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__CLIENT_URL = 5;

	/**
	 * The feature id for the '<em><b>Client Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__CLIENT_DESCRIPTION = 6;

	/**
	 * The feature id for the '<em><b>Redirect Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__REDIRECT_URL = 7;

	/**
	 * The feature id for the '<em><b>Expires At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__EXPIRES_AT = 8;

	/**
	 * The feature id for the '<em><b>Issued At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__ISSUED_AT = 9;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__INCOMING = 10;

	/**
	 * The feature id for the '<em><b>Api Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__API_URL = 11;

	/**
	 * The feature id for the '<em><b>Registration Endpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER__REGISTRATION_ENDPOINT = 12;

	/**
	 * The number of structural features of the '<em>OAuth Server</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_SERVER_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.OAuthAuthorizationCodeImpl <em>OAuth Authorization Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.OAuthAuthorizationCodeImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getOAuthAuthorizationCode()
	 * @generated
	 */
	int OAUTH_AUTHORIZATION_CODE = 93;

	/**
	 * The feature id for the '<em><b>Oauth Server</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_AUTHORIZATION_CODE__OAUTH_SERVER = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_AUTHORIZATION_CODE__CODE = 1;

	/**
	 * The feature id for the '<em><b>Authorization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_AUTHORIZATION_CODE__AUTHORIZATION = 2;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_AUTHORIZATION_CODE__USER = 3;

	/**
	 * The feature id for the '<em><b>Issued</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_AUTHORIZATION_CODE__ISSUED = 4;

	/**
	 * The number of structural features of the '<em>OAuth Authorization Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_AUTHORIZATION_CODE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.AuthorizationImpl <em>Authorization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.AuthorizationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getAuthorization()
	 * @generated
	 */
	int AUTHORIZATION = 94;

	/**
	 * The number of structural features of the '<em>Authorization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.SingleProjectAuthorizationImpl <em>Single Project Authorization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.SingleProjectAuthorizationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getSingleProjectAuthorization()
	 * @generated
	 */
	int SINGLE_PROJECT_AUTHORIZATION = 95;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_PROJECT_AUTHORIZATION__PROJECT = AUTHORIZATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Single Project Authorization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_PROJECT_AUTHORIZATION_FEATURE_COUNT = AUTHORIZATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.NewServiceDescriptorImpl <em>New Service Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.NewServiceDescriptorImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getNewServiceDescriptor()
	 * @generated
	 */
	int NEW_SERVICE_DESCRIPTOR = 96;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE_DESCRIPTOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE_DESCRIPTOR__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE_DESCRIPTOR__PROVIDER = 2;

	/**
	 * The feature id for the '<em><b>Authorization Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE_DESCRIPTOR__AUTHORIZATION_URL = 3;

	/**
	 * The feature id for the '<em><b>Token Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE_DESCRIPTOR__TOKEN_URL = 4;

	/**
	 * The feature id for the '<em><b>Resource Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE_DESCRIPTOR__RESOURCE_URL = 5;

	/**
	 * The feature id for the '<em><b>Register Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE_DESCRIPTOR__REGISTER_URL = 6;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE_DESCRIPTOR__INPUTS = 7;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE_DESCRIPTOR__OUTPUTS = 8;

	/**
	 * The number of structural features of the '<em>New Service Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE_DESCRIPTOR_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.FormatSerializerMapImpl <em>Format Serializer Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.FormatSerializerMapImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getFormatSerializerMap()
	 * @generated
	 */
	int FORMAT_SERIALIZER_MAP = 97;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_SERIALIZER_MAP__FORMAT = 0;

	/**
	 * The feature id for the '<em><b>Serializers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_SERIALIZER_MAP__SERIALIZERS = 1;

	/**
	 * The number of structural features of the '<em>Format Serializer Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_SERIALIZER_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.ActionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 98;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.StoreExtendedDataImpl <em>Extended Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.StoreExtendedDataImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getStoreExtendedData()
	 * @generated
	 */
	int STORE_EXTENDED_DATA = 99;

	/**
	 * The number of structural features of the '<em>Extended Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_EXTENDED_DATA_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.CheckinRevisionImpl <em>Checkin Revision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.CheckinRevisionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCheckinRevision()
	 * @generated
	 */
	int CHECKIN_REVISION = 100;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKIN_REVISION__PROJECT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Checkin Revision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKIN_REVISION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.NewServiceImpl <em>New Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.NewServiceImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getNewService()
	 * @generated
	 */
	int NEW_SERVICE = 101;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Authorization Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__AUTHORIZATION_URL = 3;

	/**
	 * The feature id for the '<em><b>Token Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__TOKEN_URL = 4;

	/**
	 * The feature id for the '<em><b>Resource Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__RESOURCE_URL = 5;

	/**
	 * The feature id for the '<em><b>Register Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__REGISTER_URL = 6;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__INPUT = 7;

	/**
	 * The feature id for the '<em><b>Oauth Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__OAUTH_CODE = 8;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__STATUS = 9;

	/**
	 * The feature id for the '<em><b>Serializer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__SERIALIZER = 10;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__OUTPUT = 11;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__ACTION = 12;

	/**
	 * The feature id for the '<em><b>Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__ACCESS_TOKEN = 13;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__PROJECT = 14;

	/**
	 * The feature id for the '<em><b>State Json</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE__STATE_JSON = 15;

	/**
	 * The number of structural features of the '<em>New Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_SERVICE_FEATURE_COUNT = 16;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.RunServiceAuthorizationImpl <em>Run Service Authorization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.RunServiceAuthorizationImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getRunServiceAuthorization()
	 * @generated
	 */
	int RUN_SERVICE_AUTHORIZATION = 102;

	/**
	 * The feature id for the '<em><b>Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_SERVICE_AUTHORIZATION__SERVICE = AUTHORIZATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Run Service Authorization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_SERVICE_AUTHORIZATION_FEATURE_COUNT = AUTHORIZATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DensityCollectionImpl <em>Density Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DensityCollectionImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDensityCollection()
	 * @generated
	 */
	int DENSITY_COLLECTION = 103;

	/**
	 * The feature id for the '<em><b>Densities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DENSITY_COLLECTION__DENSITIES = 0;

	/**
	 * The number of structural features of the '<em>Density Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DENSITY_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.DensityImpl <em>Density</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.DensityImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDensity()
	 * @generated
	 */
	int DENSITY = 104;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DENSITY__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Geometry Info Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DENSITY__GEOMETRY_INFO_ID = 1;

	/**
	 * The feature id for the '<em><b>Triangles Below</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DENSITY__TRIANGLES_BELOW = 2;

	/**
	 * The feature id for the '<em><b>Triangles Above</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DENSITY__TRIANGLES_ABOVE = 3;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DENSITY__VOLUME = 4;

	/**
	 * The feature id for the '<em><b>Density</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DENSITY__DENSITY = 5;

	/**
	 * The number of structural features of the '<em>Density</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DENSITY_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.LongCheckinActionStateImpl <em>Long Checkin Action State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.LongCheckinActionStateImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getLongCheckinActionState()
	 * @generated
	 */
	int LONG_CHECKIN_ACTION_STATE = 105;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE__START = LONG_ACTION_STATE__START;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE__END = LONG_ACTION_STATE__END;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE__PROGRESS = LONG_ACTION_STATE__PROGRESS;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE__STATE = LONG_ACTION_STATE__STATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE__TITLE = LONG_ACTION_STATE__TITLE;

	/**
	 * The feature id for the '<em><b>Stage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE__STAGE = LONG_ACTION_STATE__STAGE;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE__ERRORS = LONG_ACTION_STATE__ERRORS;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE__WARNINGS = LONG_ACTION_STATE__WARNINGS;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE__INFOS = LONG_ACTION_STATE__INFOS;

	/**
	 * The feature id for the '<em><b>Topic Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE__TOPIC_ID = LONG_ACTION_STATE__TOPIC_ID;

	/**
	 * The feature id for the '<em><b>Roid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE__ROID = LONG_ACTION_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deserialize Error Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE__DESERIALIZE_ERROR_CODE = LONG_ACTION_STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Long Checkin Action State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHECKIN_ACTION_STATE_FEATURE_COUNT = LONG_ACTION_STATE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.impl.TileImpl <em>Tile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.impl.TileImpl
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getTile()
	 * @generated
	 */
	int TILE = 106;

	/**
	 * The feature id for the '<em><b>Tile Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE__TILE_ID = 0;

	/**
	 * The feature id for the '<em><b>Nr Objects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE__NR_OBJECTS = 1;

	/**
	 * The feature id for the '<em><b>Min Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE__MIN_BOUNDS = 2;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE__BOUNDS = 3;

	/**
	 * The number of structural features of the '<em>Tile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.UserType <em>User Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.UserType
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getUserType()
	 * @generated
	 */
	int USER_TYPE = 107;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.SIPrefix <em>SI Prefix</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.SIPrefix
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getSIPrefix()
	 * @generated
	 */
	int SI_PREFIX = 108;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.ObjectState <em>Object State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.ObjectState
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectState()
	 * @generated
	 */
	int OBJECT_STATE = 109;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.CompareType <em>Compare Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.CompareType
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getCompareType()
	 * @generated
	 */
	int COMPARE_TYPE = 110;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.ActionState <em>Action State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.ActionState
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getActionState()
	 * @generated
	 */
	int ACTION_STATE = 111;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.ServerState <em>Server State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.ServerState
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServerState()
	 * @generated
	 */
	int SERVER_STATE = 112;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.Trigger <em>Trigger</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.Trigger
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getTrigger()
	 * @generated
	 */
	int TRIGGER = 113;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.ServiceSimpleType <em>Service Simple Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.ServiceSimpleType
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceSimpleType()
	 * @generated
	 */
	int SERVICE_SIMPLE_TYPE = 114;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.PrimitiveEnum <em>Primitive Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.PrimitiveEnum
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPrimitiveEnum()
	 * @generated
	 */
	int PRIMITIVE_ENUM = 115;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.NotifictionResultEnum <em>Notifiction Result Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.NotifictionResultEnum
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getNotifictionResultEnum()
	 * @generated
	 */
	int NOTIFICTION_RESULT_ENUM = 116;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.ProgressTopicType <em>Progress Topic Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.ProgressTopicType
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getProgressTopicType()
	 * @generated
	 */
	int PROGRESS_TOPIC_TYPE = 117;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.ModelCheckerResultType <em>Model Checker Result Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.ModelCheckerResultType
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelCheckerResultType()
	 * @generated
	 */
	int MODEL_CHECKER_RESULT_TYPE = 118;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.SmtpProtocol <em>Smtp Protocol</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.SmtpProtocol
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getSmtpProtocol()
	 * @generated
	 */
	int SMTP_PROTOCOL = 119;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.PluginBundleType <em>Plugin Bundle Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.PluginBundleType
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginBundleType()
	 * @generated
	 */
	int PLUGIN_BUNDLE_TYPE = 120;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.PluginType <em>Plugin Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.PluginType
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginType()
	 * @generated
	 */
	int PLUGIN_TYPE = 121;

	/**
	 * The meta object id for the '{@link org.bimserver.models.store.ServiceStatus <em>Service Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.store.ServiceStatus
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceStatus()
	 * @generated
	 */
	int SERVICE_STATUS = 122;

	/**
	 * The meta object id for the '<em>Data Handler</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.activation.DataHandler
	 * @see org.bimserver.models.store.impl.StorePackageImpl#getDataHandler()
	 * @generated
	 */
	int DATA_HANDLER = 123;

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
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Project#getExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extended Data</em>'.
	 * @see org.bimserver.models.store.Project#getExtendedData()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_ExtendedData();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Project#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Services</em>'.
	 * @see org.bimserver.models.store.Project#getServices()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Services();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Project#getLogs <em>Logs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Logs</em>'.
	 * @see org.bimserver.models.store.Project#getLogs()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Logs();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Project#getModelCheckers <em>Model Checkers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Checkers</em>'.
	 * @see org.bimserver.models.store.Project#getModelCheckers()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_ModelCheckers();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Project#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema</em>'.
	 * @see org.bimserver.models.store.Project#getSchema()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Schema();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Project#isSendEmailOnNewRevision <em>Send Email On New Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Send Email On New Revision</em>'.
	 * @see org.bimserver.models.store.Project#isSendEmailOnNewRevision()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_SendEmailOnNewRevision();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Project#getNewServices <em>New Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>New Services</em>'.
	 * @see org.bimserver.models.store.Project#getNewServices()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_NewServices();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Project#getCheckinInProgress <em>Checkin In Progress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkin In Progress</em>'.
	 * @see org.bimserver.models.store.Project#getCheckinInProgress()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_CheckinInProgress();

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getPasswordHash <em>Password Hash</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password Hash</em>'.
	 * @see org.bimserver.models.store.User#getPasswordHash()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_PasswordHash();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getPasswordSalt <em>Password Salt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password Salt</em>'.
	 * @see org.bimserver.models.store.User#getPasswordSalt()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_PasswordSalt();

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.User#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token</em>'.
	 * @see org.bimserver.models.store.User#getToken()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Token();

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
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.User#getUserSettings <em>User Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User Settings</em>'.
	 * @see org.bimserver.models.store.User#getUserSettings()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_UserSettings();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.User#getSchemas <em>Schemas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Schemas</em>'.
	 * @see org.bimserver.models.store.User#getSchemas()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Schemas();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.User#getExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extended Data</em>'.
	 * @see org.bimserver.models.store.User#getExtendedData()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_ExtendedData();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.User#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Services</em>'.
	 * @see org.bimserver.models.store.User#getServices()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Services();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.User#getLogs <em>Logs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Logs</em>'.
	 * @see org.bimserver.models.store.User#getLogs()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Logs();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.User#getOAuthAuthorizationCodes <em>OAuth Authorization Codes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>OAuth Authorization Codes</em>'.
	 * @see org.bimserver.models.store.User#getOAuthAuthorizationCodes()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_OAuthAuthorizationCodes();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.User#getOAuthIssuedAuthorizationCodes <em>OAuth Issued Authorization Codes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>OAuth Issued Authorization Codes</em>'.
	 * @see org.bimserver.models.store.User#getOAuthIssuedAuthorizationCodes()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_OAuthIssuedAuthorizationCodes();

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
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Revision#getExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extended Data</em>'.
	 * @see org.bimserver.models.store.Revision#getExtendedData()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_ExtendedData();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Revision#getLogs <em>Logs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Logs</em>'.
	 * @see org.bimserver.models.store.Revision#getLogs()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_Logs();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Revision#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service</em>'.
	 * @see org.bimserver.models.store.Revision#getService()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_Service();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Revision#isHasGeometry <em>Has Geometry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Geometry</em>'.
	 * @see org.bimserver.models.store.Revision#isHasGeometry()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_HasGeometry();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Revision#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bounds</em>'.
	 * @see org.bimserver.models.store.Revision#getBounds()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_Bounds();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Revision#getBoundsUntransformed <em>Bounds Untransformed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bounds Untransformed</em>'.
	 * @see org.bimserver.models.store.Revision#getBoundsUntransformed()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_BoundsUntransformed();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Revision#getBoundsMm <em>Bounds Mm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bounds Mm</em>'.
	 * @see org.bimserver.models.store.Revision#getBoundsMm()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_BoundsMm();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Revision#getBoundsUntransformedMm <em>Bounds Untransformed Mm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bounds Untransformed Mm</em>'.
	 * @see org.bimserver.models.store.Revision#getBoundsUntransformedMm()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_BoundsUntransformedMm();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Revision#getServicesLinked <em>Services Linked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Services Linked</em>'.
	 * @see org.bimserver.models.store.Revision#getServicesLinked()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_ServicesLinked();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Revision#getDensityCollection <em>Density Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Density Collection</em>'.
	 * @see org.bimserver.models.store.Revision#getDensityCollection()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_DensityCollection();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Revision#getNrPrimitives <em>Nr Primitives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nr Primitives</em>'.
	 * @see org.bimserver.models.store.Revision#getNrPrimitives()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_NrPrimitives();

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ConcreteRevision#isClear <em>Clear</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clear</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#isClear()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EAttribute getConcreteRevision_Clear();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ConcreteRevision#getSummary <em>Summary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Summary</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getSummary()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EReference getConcreteRevision_Summary();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ConcreteRevision#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getUser()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EReference getConcreteRevision_User();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ConcreteRevision#getIfcHeader <em>Ifc Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ifc Header</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getIfcHeader()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EReference getConcreteRevision_IfcHeader();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ConcreteRevision#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bounds</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getBounds()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EReference getConcreteRevision_Bounds();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ConcreteRevision#getBoundsUntransformed <em>Bounds Untransformed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bounds Untransformed</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getBoundsUntransformed()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EReference getConcreteRevision_BoundsUntransformed();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ConcreteRevision#getOidCounters <em>Oid Counters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Oid Counters</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getOidCounters()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EAttribute getConcreteRevision_OidCounters();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ConcreteRevision#getMultiplierToMm <em>Multiplier To Mm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplier To Mm</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getMultiplierToMm()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EAttribute getConcreteRevision_MultiplierToMm();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ConcreteRevision#getDensityCollection <em>Density Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Density Collection</em>'.
	 * @see org.bimserver.models.store.ConcreteRevision#getDensityCollection()
	 * @see #getConcreteRevision()
	 * @generated
	 */
	EReference getConcreteRevision_DensityCollection();

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.GeoTag#getEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.bimserver.models.store.GeoTag#getEnabled()
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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Checkout#getActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see org.bimserver.models.store.Checkout#getActive()
	 * @see #getCheckout()
	 * @generated
	 */
	EAttribute getCheckout_Active();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Checkout#getLogs <em>Logs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Logs</em>'.
	 * @see org.bimserver.models.store.Checkout#getLogs()
	 * @see #getCheckout()
	 * @generated
	 */
	EReference getCheckout_Logs();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ServerSettings <em>Server Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Settings</em>'.
	 * @see org.bimserver.models.store.ServerSettings
	 * @generated
	 */
	EClass getServerSettings();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#isSendConfirmationEmailAfterRegistration <em>Send Confirmation Email After Registration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Send Confirmation Email After Registration</em>'.
	 * @see org.bimserver.models.store.ServerSettings#isSendConfirmationEmailAfterRegistration()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_SendConfirmationEmailAfterRegistration();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getAllowSelfRegistration <em>Allow Self Registration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Self Registration</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getAllowSelfRegistration()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_AllowSelfRegistration();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#isAllowUsersToCreateTopLevelProjects <em>Allow Users To Create Top Level Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Users To Create Top Level Projects</em>'.
	 * @see org.bimserver.models.store.ServerSettings#isAllowUsersToCreateTopLevelProjects()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_AllowUsersToCreateTopLevelProjects();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getCheckinMergingEnabled <em>Checkin Merging Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkin Merging Enabled</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getCheckinMergingEnabled()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_CheckinMergingEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getSmtpServer <em>Smtp Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp Server</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getSmtpServer()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_SmtpServer();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getEmailSenderAddress <em>Email Sender Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email Sender Address</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getEmailSenderAddress()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_EmailSenderAddress();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getEmailSenderName <em>Email Sender Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email Sender Name</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getEmailSenderName()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_EmailSenderName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getSiteAddress <em>Site Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Site Address</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getSiteAddress()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_SiteAddress();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#isGenerateGeometryOnCheckin <em>Generate Geometry On Checkin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generate Geometry On Checkin</em>'.
	 * @see org.bimserver.models.store.ServerSettings#isGenerateGeometryOnCheckin()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_GenerateGeometryOnCheckin();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#isAllowOnlyWhitelisted <em>Allow Only Whitelisted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Only Whitelisted</em>'.
	 * @see org.bimserver.models.store.ServerSettings#isAllowOnlyWhitelisted()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_AllowOnlyWhitelisted();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.ServerSettings#getWhitelistedDomains <em>Whitelisted Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Whitelisted Domains</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getWhitelistedDomains()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_WhitelistedDomains();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getHideUserListForNonAdmin <em>Hide User List For Non Admin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide User List For Non Admin</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getHideUserListForNonAdmin()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_HideUserListForNonAdmin();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getProtocolBuffersPort <em>Protocol Buffers Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protocol Buffers Port</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getProtocolBuffersPort()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_ProtocolBuffersPort();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getCacheOutputFiles <em>Cache Output Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cache Output Files</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getCacheOutputFiles()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_CacheOutputFiles();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ServerSettings#getWebModules <em>Web Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Web Modules</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getWebModules()
	 * @see #getServerSettings()
	 * @generated
	 */
	EReference getServerSettings_WebModules();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ServerSettings#getWebModule <em>Web Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Web Module</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getWebModule()
	 * @see #getServerSettings()
	 * @generated
	 */
	EReference getServerSettings_WebModule();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getServiceRepositoryUrl <em>Service Repository Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Repository Url</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getServiceRepositoryUrl()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_ServiceRepositoryUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#isSendEmailOnNewRevision <em>Send Email On New Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Send Email On New Revision</em>'.
	 * @see org.bimserver.models.store.ServerSettings#isSendEmailOnNewRevision()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_SendEmailOnNewRevision();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getSessionTimeOutSeconds <em>Session Time Out Seconds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Session Time Out Seconds</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getSessionTimeOutSeconds()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_SessionTimeOutSeconds();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getSmtpUsername <em>Smtp Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp Username</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getSmtpUsername()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_SmtpUsername();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getSmtpPassword <em>Smtp Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp Password</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getSmtpPassword()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_SmtpPassword();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getSmtpPort <em>Smtp Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp Port</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getSmtpPort()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_SmtpPort();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getSmtpProtocol <em>Smtp Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Smtp Protocol</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getSmtpProtocol()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_SmtpProtocol();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#isReuseGeometry <em>Reuse Geometry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reuse Geometry</em>'.
	 * @see org.bimserver.models.store.ServerSettings#isReuseGeometry()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_ReuseGeometry();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#isAllowCreateValidatedUser <em>Allow Create Validated User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Create Validated User</em>'.
	 * @see org.bimserver.models.store.ServerSettings#isAllowCreateValidatedUser()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_AllowCreateValidatedUser();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getRenderEngineProcesses <em>Render Engine Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Render Engine Processes</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getRenderEngineProcesses()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_RenderEngineProcesses();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#isPluginStrictVersionChecking <em>Plugin Strict Version Checking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin Strict Version Checking</em>'.
	 * @see org.bimserver.models.store.ServerSettings#isPluginStrictVersionChecking()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_PluginStrictVersionChecking();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getName()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getDescription()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getIcon()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_Icon();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#isStoreLastLogin <em>Store Last Login</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Store Last Login</em>'.
	 * @see org.bimserver.models.store.ServerSettings#isStoreLastLogin()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_StoreLastLogin();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#isStoreServiceRuns <em>Store Service Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Store Service Runs</em>'.
	 * @see org.bimserver.models.store.ServerSettings#isStoreServiceRuns()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_StoreServiceRuns();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServerSettings#isOptimizeMappedItems <em>Optimize Mapped Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optimize Mapped Items</em>'.
	 * @see org.bimserver.models.store.ServerSettings#isOptimizeMappedItems()
	 * @see #getServerSettings()
	 * @generated
	 */
	EAttribute getServerSettings_OptimizeMappedItems();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ServerSettings#getDefaultRenderEnginePlugin <em>Default Render Engine Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Render Engine Plugin</em>'.
	 * @see org.bimserver.models.store.ServerSettings#getDefaultRenderEnginePlugin()
	 * @see #getServerSettings()
	 * @generated
	 */
	EReference getServerSettings_DefaultRenderEnginePlugin();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.UserSettings <em>User Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Settings</em>'.
	 * @see org.bimserver.models.store.UserSettings
	 * @generated
	 */
	EClass getUserSettings();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.UserSettings#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Serializers</em>'.
	 * @see org.bimserver.models.store.UserSettings#getSerializers()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_Serializers();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.UserSettings#getObjectIDMs <em>Object ID Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Object ID Ms</em>'.
	 * @see org.bimserver.models.store.UserSettings#getObjectIDMs()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_ObjectIDMs();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.UserSettings#getRenderEngines <em>Render Engines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Render Engines</em>'.
	 * @see org.bimserver.models.store.UserSettings#getRenderEngines()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_RenderEngines();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.UserSettings#getDeserializers <em>Deserializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Deserializers</em>'.
	 * @see org.bimserver.models.store.UserSettings#getDeserializers()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_Deserializers();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.UserSettings#getQueryEngines <em>Query Engines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Query Engines</em>'.
	 * @see org.bimserver.models.store.UserSettings#getQueryEngines()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_QueryEngines();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.UserSettings#getModelMergers <em>Model Mergers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Mergers</em>'.
	 * @see org.bimserver.models.store.UserSettings#getModelMergers()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_ModelMergers();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.UserSettings#getModelCompares <em>Model Compares</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Compares</em>'.
	 * @see org.bimserver.models.store.UserSettings#getModelCompares()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_ModelCompares();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.UserSettings#getDefaultModelMerger <em>Default Model Merger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Model Merger</em>'.
	 * @see org.bimserver.models.store.UserSettings#getDefaultModelMerger()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_DefaultModelMerger();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.UserSettings#getDefaultModelCompare <em>Default Model Compare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Model Compare</em>'.
	 * @see org.bimserver.models.store.UserSettings#getDefaultModelCompare()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_DefaultModelCompare();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.UserSettings#getDefaultQueryEngine <em>Default Query Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Query Engine</em>'.
	 * @see org.bimserver.models.store.UserSettings#getDefaultQueryEngine()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_DefaultQueryEngine();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.UserSettings#getDefaultRenderEngine <em>Default Render Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Render Engine</em>'.
	 * @see org.bimserver.models.store.UserSettings#getDefaultRenderEngine()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_DefaultRenderEngine();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.UserSettings#getDefaultSerializer <em>Default Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Serializer</em>'.
	 * @see org.bimserver.models.store.UserSettings#getDefaultSerializer()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_DefaultSerializer();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.UserSettings#getDefaultObjectIDM <em>Default Object IDM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Object IDM</em>'.
	 * @see org.bimserver.models.store.UserSettings#getDefaultObjectIDM()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_DefaultObjectIDM();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.UserSettings#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Services</em>'.
	 * @see org.bimserver.models.store.UserSettings#getServices()
	 * @see #getUserSettings()
	 * @generated
	 */
	EReference getUserSettings_Services();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.PluginConfiguration <em>Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin Configuration</em>'.
	 * @see org.bimserver.models.store.PluginConfiguration
	 * @generated
	 */
	EClass getPluginConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.PluginConfiguration#getName()
	 * @see #getPluginConfiguration()
	 * @generated
	 */
	EAttribute getPluginConfiguration_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginConfiguration#getEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.bimserver.models.store.PluginConfiguration#getEnabled()
	 * @see #getPluginConfiguration()
	 * @generated
	 */
	EAttribute getPluginConfiguration_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginConfiguration#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.PluginConfiguration#getDescription()
	 * @see #getPluginConfiguration()
	 * @generated
	 */
	EAttribute getPluginConfiguration_Description();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.PluginConfiguration#getPluginDescriptor <em>Plugin Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Plugin Descriptor</em>'.
	 * @see org.bimserver.models.store.PluginConfiguration#getPluginDescriptor()
	 * @see #getPluginConfiguration()
	 * @generated
	 */
	EReference getPluginConfiguration_PluginDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.PluginConfiguration#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Settings</em>'.
	 * @see org.bimserver.models.store.PluginConfiguration#getSettings()
	 * @see #getPluginConfiguration()
	 * @generated
	 */
	EReference getPluginConfiguration_Settings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.SerializerPluginConfiguration <em>Serializer Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Serializer Plugin Configuration</em>'.
	 * @see org.bimserver.models.store.SerializerPluginConfiguration
	 * @generated
	 */
	EClass getSerializerPluginConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.SerializerPluginConfiguration#getObjectIDM <em>Object IDM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object IDM</em>'.
	 * @see org.bimserver.models.store.SerializerPluginConfiguration#getObjectIDM()
	 * @see #getSerializerPluginConfiguration()
	 * @generated
	 */
	EReference getSerializerPluginConfiguration_ObjectIDM();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.SerializerPluginConfiguration#getUserSettings <em>User Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User Settings</em>'.
	 * @see org.bimserver.models.store.SerializerPluginConfiguration#getUserSettings()
	 * @see #getSerializerPluginConfiguration()
	 * @generated
	 */
	EReference getSerializerPluginConfiguration_UserSettings();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.SerializerPluginConfiguration#getRenderEngine <em>Render Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Render Engine</em>'.
	 * @see org.bimserver.models.store.SerializerPluginConfiguration#getRenderEngine()
	 * @see #getSerializerPluginConfiguration()
	 * @generated
	 */
	EReference getSerializerPluginConfiguration_RenderEngine();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SerializerPluginConfiguration#isStreaming <em>Streaming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Streaming</em>'.
	 * @see org.bimserver.models.store.SerializerPluginConfiguration#isStreaming()
	 * @see #getSerializerPluginConfiguration()
	 * @generated
	 */
	EAttribute getSerializerPluginConfiguration_Streaming();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ObjectIDMPluginConfiguration <em>Object IDM Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object IDM Plugin Configuration</em>'.
	 * @see org.bimserver.models.store.ObjectIDMPluginConfiguration
	 * @generated
	 */
	EClass getObjectIDMPluginConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ObjectIDMPluginConfiguration#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Serializers</em>'.
	 * @see org.bimserver.models.store.ObjectIDMPluginConfiguration#getSerializers()
	 * @see #getObjectIDMPluginConfiguration()
	 * @generated
	 */
	EReference getObjectIDMPluginConfiguration_Serializers();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ObjectIDMPluginConfiguration#getUserSettings <em>User Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User Settings</em>'.
	 * @see org.bimserver.models.store.ObjectIDMPluginConfiguration#getUserSettings()
	 * @see #getObjectIDMPluginConfiguration()
	 * @generated
	 */
	EReference getObjectIDMPluginConfiguration_UserSettings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.RenderEnginePluginConfiguration <em>Render Engine Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Render Engine Plugin Configuration</em>'.
	 * @see org.bimserver.models.store.RenderEnginePluginConfiguration
	 * @generated
	 */
	EClass getRenderEnginePluginConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.RenderEnginePluginConfiguration#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Serializers</em>'.
	 * @see org.bimserver.models.store.RenderEnginePluginConfiguration#getSerializers()
	 * @see #getRenderEnginePluginConfiguration()
	 * @generated
	 */
	EReference getRenderEnginePluginConfiguration_Serializers();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.RenderEnginePluginConfiguration#getUserSettings <em>User Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User Settings</em>'.
	 * @see org.bimserver.models.store.RenderEnginePluginConfiguration#getUserSettings()
	 * @see #getRenderEnginePluginConfiguration()
	 * @generated
	 */
	EReference getRenderEnginePluginConfiguration_UserSettings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.DeserializerPluginConfiguration <em>Deserializer Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deserializer Plugin Configuration</em>'.
	 * @see org.bimserver.models.store.DeserializerPluginConfiguration
	 * @generated
	 */
	EClass getDeserializerPluginConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.DeserializerPluginConfiguration#getUserSettings <em>User Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User Settings</em>'.
	 * @see org.bimserver.models.store.DeserializerPluginConfiguration#getUserSettings()
	 * @see #getDeserializerPluginConfiguration()
	 * @generated
	 */
	EReference getDeserializerPluginConfiguration_UserSettings();

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DownloadResult#getSerializerOid <em>Serializer Oid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Serializer Oid</em>'.
	 * @see org.bimserver.models.store.DownloadResult#getSerializerOid()
	 * @see #getDownloadResult()
	 * @generated
	 */
	EAttribute getDownloadResult_SerializerOid();

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Migration#getExecuted <em>Executed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executed</em>'.
	 * @see org.bimserver.models.store.Migration#getExecuted()
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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginDescriptor#getPluginClassName <em>Plugin Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin Class Name</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor#getPluginClassName()
	 * @see #getPluginDescriptor()
	 * @generated
	 */
	EAttribute getPluginDescriptor_PluginClassName();

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginDescriptor#getEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor#getEnabled()
	 * @see #getPluginDescriptor()
	 * @generated
	 */
	EAttribute getPluginDescriptor_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginDescriptor#getPluginInterfaceClassName <em>Plugin Interface Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin Interface Class Name</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor#getPluginInterfaceClassName()
	 * @see #getPluginDescriptor()
	 * @generated
	 */
	EAttribute getPluginDescriptor_PluginInterfaceClassName();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.PluginDescriptor#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Configurations</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor#getConfigurations()
	 * @see #getPluginDescriptor()
	 * @generated
	 */
	EReference getPluginDescriptor_Configurations();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginDescriptor#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor#getIdentifier()
	 * @see #getPluginDescriptor()
	 * @generated
	 */
	EAttribute getPluginDescriptor_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginDescriptor#isInstallForNewUsers <em>Install For New Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install For New Users</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor#isInstallForNewUsers()
	 * @see #getPluginDescriptor()
	 * @generated
	 */
	EAttribute getPluginDescriptor_InstallForNewUsers();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.PluginDescriptor#getPluginBundleVersion <em>Plugin Bundle Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Plugin Bundle Version</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor#getPluginBundleVersion()
	 * @see #getPluginDescriptor()
	 * @generated
	 */
	EReference getPluginDescriptor_PluginBundleVersion();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.PluginDescriptor#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Settings</em>'.
	 * @see org.bimserver.models.store.PluginDescriptor#getSettings()
	 * @see #getPluginDescriptor()
	 * @generated
	 */
	EReference getPluginDescriptor_Settings();

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.RevisionSummaryType#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema</em>'.
	 * @see org.bimserver.models.store.RevisionSummaryType#getSchema()
	 * @see #getRevisionSummaryType()
	 * @generated
	 */
	EAttribute getRevisionSummaryType_Schema();

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongActionState#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.bimserver.models.store.LongActionState#getStart()
	 * @see #getLongActionState()
	 * @generated
	 */
	EAttribute getLongActionState_Start();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongActionState#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see org.bimserver.models.store.LongActionState#getEnd()
	 * @see #getLongActionState()
	 * @generated
	 */
	EAttribute getLongActionState_End();

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongActionState#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.bimserver.models.store.LongActionState#getTitle()
	 * @see #getLongActionState()
	 * @generated
	 */
	EAttribute getLongActionState_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongActionState#getStage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stage</em>'.
	 * @see org.bimserver.models.store.LongActionState#getStage()
	 * @see #getLongActionState()
	 * @generated
	 */
	EAttribute getLongActionState_Stage();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.LongActionState#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Errors</em>'.
	 * @see org.bimserver.models.store.LongActionState#getErrors()
	 * @see #getLongActionState()
	 * @generated
	 */
	EAttribute getLongActionState_Errors();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.LongActionState#getWarnings <em>Warnings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Warnings</em>'.
	 * @see org.bimserver.models.store.LongActionState#getWarnings()
	 * @see #getLongActionState()
	 * @generated
	 */
	EAttribute getLongActionState_Warnings();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.LongActionState#getInfos <em>Infos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Infos</em>'.
	 * @see org.bimserver.models.store.LongActionState#getInfos()
	 * @see #getLongActionState()
	 * @generated
	 */
	EAttribute getLongActionState_Infos();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongActionState#getTopicId <em>Topic Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Topic Id</em>'.
	 * @see org.bimserver.models.store.LongActionState#getTopicId()
	 * @see #getLongActionState()
	 * @generated
	 */
	EAttribute getLongActionState_TopicId();

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
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ServerInfo#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Version</em>'.
	 * @see org.bimserver.models.store.ServerInfo#getVersion()
	 * @see #getServerInfo()
	 * @generated
	 */
	EReference getServerInfo_Version();

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
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Version#getFullString <em>Full String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full String</em>'.
	 * @see org.bimserver.models.store.Version#getFullString()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_FullString();

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
	 * Returns the meta object for class '{@link org.bimserver.models.store.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see org.bimserver.models.store.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.File#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.bimserver.models.store.File#getData()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Data();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.File#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filename</em>'.
	 * @see org.bimserver.models.store.File#getFilename()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Filename();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.File#getMime <em>Mime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mime</em>'.
	 * @see org.bimserver.models.store.File#getMime()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Mime();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.File#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.bimserver.models.store.File#getSize()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Size();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ExtendedDataSchema <em>Extended Data Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Data Schema</em>'.
	 * @see org.bimserver.models.store.ExtendedDataSchema
	 * @generated
	 */
	EClass getExtendedDataSchema();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ExtendedDataSchema#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ExtendedDataSchema#getName()
	 * @see #getExtendedDataSchema()
	 * @generated
	 */
	EAttribute getExtendedDataSchema_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ExtendedDataSchema#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.bimserver.models.store.ExtendedDataSchema#getUrl()
	 * @see #getExtendedDataSchema()
	 * @generated
	 */
	EAttribute getExtendedDataSchema_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ExtendedDataSchema#getContentType <em>Content Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Type</em>'.
	 * @see org.bimserver.models.store.ExtendedDataSchema#getContentType()
	 * @see #getExtendedDataSchema()
	 * @generated
	 */
	EAttribute getExtendedDataSchema_ContentType();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ExtendedDataSchema#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.ExtendedDataSchema#getDescription()
	 * @see #getExtendedDataSchema()
	 * @generated
	 */
	EAttribute getExtendedDataSchema_Description();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ExtendedDataSchema#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>File</em>'.
	 * @see org.bimserver.models.store.ExtendedDataSchema#getFile()
	 * @see #getExtendedDataSchema()
	 * @generated
	 */
	EReference getExtendedDataSchema_File();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ExtendedDataSchema#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.bimserver.models.store.ExtendedDataSchema#getSize()
	 * @see #getExtendedDataSchema()
	 * @generated
	 */
	EAttribute getExtendedDataSchema_Size();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ExtendedDataSchema#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Users</em>'.
	 * @see org.bimserver.models.store.ExtendedDataSchema#getUsers()
	 * @see #getExtendedDataSchema()
	 * @generated
	 */
	EReference getExtendedDataSchema_Users();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ExtendedDataSchema#getExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extended Data</em>'.
	 * @see org.bimserver.models.store.ExtendedDataSchema#getExtendedData()
	 * @see #getExtendedDataSchema()
	 * @generated
	 */
	EReference getExtendedDataSchema_ExtendedData();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Data</em>'.
	 * @see org.bimserver.models.store.ExtendedData
	 * @generated
	 */
	EClass getExtendedData();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ExtendedData#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.bimserver.models.store.ExtendedData#getUrl()
	 * @see #getExtendedData()
	 * @generated
	 */
	EAttribute getExtendedData_Url();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ExtendedData#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>File</em>'.
	 * @see org.bimserver.models.store.ExtendedData#getFile()
	 * @see #getExtendedData()
	 * @generated
	 */
	EReference getExtendedData_File();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ExtendedData#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.bimserver.models.store.ExtendedData#getSize()
	 * @see #getExtendedData()
	 * @generated
	 */
	EAttribute getExtendedData_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ExtendedData#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.bimserver.models.store.ExtendedData#getTitle()
	 * @see #getExtendedData()
	 * @generated
	 */
	EAttribute getExtendedData_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ExtendedData#getAdded <em>Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Added</em>'.
	 * @see org.bimserver.models.store.ExtendedData#getAdded()
	 * @see #getExtendedData()
	 * @generated
	 */
	EAttribute getExtendedData_Added();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ExtendedData#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.store.ExtendedData#getUser()
	 * @see #getExtendedData()
	 * @generated
	 */
	EReference getExtendedData_User();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ExtendedData#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Schema</em>'.
	 * @see org.bimserver.models.store.ExtendedData#getSchema()
	 * @see #getExtendedData()
	 * @generated
	 */
	EReference getExtendedData_Schema();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ExtendedData#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see org.bimserver.models.store.ExtendedData#getRevision()
	 * @see #getExtendedData()
	 * @generated
	 */
	EReference getExtendedData_Revision();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ExtendedData#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.store.ExtendedData#getProject()
	 * @see #getExtendedData()
	 * @generated
	 */
	EReference getExtendedData_Project();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ExtendedData#getTimeToGenerate <em>Time To Generate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time To Generate</em>'.
	 * @see org.bimserver.models.store.ExtendedData#getTimeToGenerate()
	 * @see #getExtendedData()
	 * @generated
	 */
	EAttribute getExtendedData_TimeToGenerate();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.QueryEnginePluginConfiguration <em>Query Engine Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Engine Plugin Configuration</em>'.
	 * @see org.bimserver.models.store.QueryEnginePluginConfiguration
	 * @generated
	 */
	EClass getQueryEnginePluginConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.QueryEnginePluginConfiguration#getUserSettings <em>User Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User Settings</em>'.
	 * @see org.bimserver.models.store.QueryEnginePluginConfiguration#getUserSettings()
	 * @see #getQueryEnginePluginConfiguration()
	 * @generated
	 */
	EReference getQueryEnginePluginConfiguration_UserSettings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.WebModulePluginConfiguration <em>Web Module Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Module Plugin Configuration</em>'.
	 * @see org.bimserver.models.store.WebModulePluginConfiguration
	 * @generated
	 */
	EClass getWebModulePluginConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.WebModulePluginConfiguration#getServerSettings <em>Server Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Server Settings</em>'.
	 * @see org.bimserver.models.store.WebModulePluginConfiguration#getServerSettings()
	 * @see #getWebModulePluginConfiguration()
	 * @generated
	 */
	EReference getWebModulePluginConfiguration_ServerSettings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ModelMergerPluginConfiguration <em>Model Merger Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Merger Plugin Configuration</em>'.
	 * @see org.bimserver.models.store.ModelMergerPluginConfiguration
	 * @generated
	 */
	EClass getModelMergerPluginConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ModelMergerPluginConfiguration#getUserSettings <em>User Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User Settings</em>'.
	 * @see org.bimserver.models.store.ModelMergerPluginConfiguration#getUserSettings()
	 * @see #getModelMergerPluginConfiguration()
	 * @generated
	 */
	EReference getModelMergerPluginConfiguration_UserSettings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ModelComparePluginConfiguration <em>Model Compare Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Compare Plugin Configuration</em>'.
	 * @see org.bimserver.models.store.ModelComparePluginConfiguration
	 * @generated
	 */
	EClass getModelComparePluginConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ModelComparePluginConfiguration#getUserSettings <em>User Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User Settings</em>'.
	 * @see org.bimserver.models.store.ModelComparePluginConfiguration#getUserSettings()
	 * @see #getModelComparePluginConfiguration()
	 * @generated
	 */
	EReference getModelComparePluginConfiguration_UserSettings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ProfileDescriptor <em>Profile Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profile Descriptor</em>'.
	 * @see org.bimserver.models.store.ProfileDescriptor
	 * @generated
	 */
	EClass getProfileDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ProfileDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ProfileDescriptor#getName()
	 * @see #getProfileDescriptor()
	 * @generated
	 */
	EAttribute getProfileDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ProfileDescriptor#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.ProfileDescriptor#getDescription()
	 * @see #getProfileDescriptor()
	 * @generated
	 */
	EAttribute getProfileDescriptor_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ProfileDescriptor#isPublicProfile <em>Public Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public Profile</em>'.
	 * @see org.bimserver.models.store.ProfileDescriptor#isPublicProfile()
	 * @see #getProfileDescriptor()
	 * @generated
	 */
	EAttribute getProfileDescriptor_PublicProfile();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ProfileDescriptor#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.bimserver.models.store.ProfileDescriptor#getIdentifier()
	 * @see #getProfileDescriptor()
	 * @generated
	 */
	EAttribute getProfileDescriptor_Identifier();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ServiceDescriptor <em>Service Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Descriptor</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor
	 * @generated
	 */
	EClass getServiceDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getName()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getUrl()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getToken()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_Token();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getIdentifier()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getNotificationProtocol <em>Notification Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Notification Protocol</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getNotificationProtocol()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_NotificationProtocol();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getDescription()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getTrigger()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_Trigger();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#isReadRevision <em>Read Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Revision</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#isReadRevision()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_ReadRevision();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getReadExtendedData <em>Read Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Extended Data</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getReadExtendedData()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_ReadExtendedData();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#isWriteRevision <em>Write Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Write Revision</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#isWriteRevision()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_WriteRevision();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getWriteExtendedData <em>Write Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Write Extended Data</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getWriteExtendedData()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_WriteExtendedData();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getProviderName <em>Provider Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider Name</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getProviderName()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_ProviderName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getCompanyUrl <em>Company Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Company Url</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getCompanyUrl()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_CompanyUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getTokenUrl <em>Token Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token Url</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getTokenUrl()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_TokenUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getNewProfileUrl <em>New Profile Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Profile Url</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getNewProfileUrl()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_NewProfileUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getRegisterUrl <em>Register Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Register Url</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getRegisterUrl()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_RegisterUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceDescriptor#getAuthorizeUrl <em>Authorize Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Authorize Url</em>'.
	 * @see org.bimserver.models.store.ServiceDescriptor#getAuthorizeUrl()
	 * @see #getServiceDescriptor()
	 * @generated
	 */
	EAttribute getServiceDescriptor_AuthorizeUrl();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see org.bimserver.models.store.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.Service#getName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#getServiceName <em>Service Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Name</em>'.
	 * @see org.bimserver.models.store.Service#getServiceName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ServiceName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#getServiceIdentifier <em>Service Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Identifier</em>'.
	 * @see org.bimserver.models.store.Service#getServiceIdentifier()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ServiceIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#getProviderName <em>Provider Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider Name</em>'.
	 * @see org.bimserver.models.store.Service#getProviderName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ProviderName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.bimserver.models.store.Service#getUrl()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token</em>'.
	 * @see org.bimserver.models.store.Service#getToken()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Token();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#getNotificationProtocol <em>Notification Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Notification Protocol</em>'.
	 * @see org.bimserver.models.store.Service#getNotificationProtocol()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_NotificationProtocol();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.Service#getDescription()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger</em>'.
	 * @see org.bimserver.models.store.Service#getTrigger()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Trigger();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#isReadRevision <em>Read Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Revision</em>'.
	 * @see org.bimserver.models.store.Service#isReadRevision()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ReadRevision();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Service#getReadExtendedData <em>Read Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Read Extended Data</em>'.
	 * @see org.bimserver.models.store.Service#getReadExtendedData()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ReadExtendedData();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Service#getWriteRevision <em>Write Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Write Revision</em>'.
	 * @see org.bimserver.models.store.Service#getWriteRevision()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_WriteRevision();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Service#getWriteExtendedData <em>Write Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Write Extended Data</em>'.
	 * @see org.bimserver.models.store.Service#getWriteExtendedData()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_WriteExtendedData();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#getProfileIdentifier <em>Profile Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Identifier</em>'.
	 * @see org.bimserver.models.store.Service#getProfileIdentifier()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ProfileIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#getProfileName <em>Profile Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Name</em>'.
	 * @see org.bimserver.models.store.Service#getProfileName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ProfileName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#getProfileDescription <em>Profile Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Description</em>'.
	 * @see org.bimserver.models.store.Service#getProfileDescription()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ProfileDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Service#isProfilePublic <em>Profile Public</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Public</em>'.
	 * @see org.bimserver.models.store.Service#isProfilePublic()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_ProfilePublic();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Service#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.store.Service#getProject()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Project();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Service#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.store.Service#getUser()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_User();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Service#getInternalService <em>Internal Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Internal Service</em>'.
	 * @see org.bimserver.models.store.Service#getInternalService()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_InternalService();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Service#getModelCheckers <em>Model Checkers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Checkers</em>'.
	 * @see org.bimserver.models.store.Service#getModelCheckers()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_ModelCheckers();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token</em>'.
	 * @see org.bimserver.models.store.Token
	 * @generated
	 */
	EClass getToken();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Token#getTokenString <em>Token String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token String</em>'.
	 * @see org.bimserver.models.store.Token#getTokenString()
	 * @see #getToken()
	 * @generated
	 */
	EAttribute getToken_TokenString();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Token#getExpires <em>Expires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expires</em>'.
	 * @see org.bimserver.models.store.Token#getExpires()
	 * @see #getToken()
	 * @generated
	 */
	EAttribute getToken_Expires();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.InternalServicePluginConfiguration <em>Internal Service Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Service Plugin Configuration</em>'.
	 * @see org.bimserver.models.store.InternalServicePluginConfiguration
	 * @generated
	 */
	EClass getInternalServicePluginConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.InternalServicePluginConfiguration#isRemoteAccessible <em>Remote Accessible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Accessible</em>'.
	 * @see org.bimserver.models.store.InternalServicePluginConfiguration#isRemoteAccessible()
	 * @see #getInternalServicePluginConfiguration()
	 * @generated
	 */
	EAttribute getInternalServicePluginConfiguration_RemoteAccessible();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.InternalServicePluginConfiguration#getUserSettings <em>User Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User Settings</em>'.
	 * @see org.bimserver.models.store.InternalServicePluginConfiguration#getUserSettings()
	 * @see #getInternalServicePluginConfiguration()
	 * @generated
	 */
	EReference getInternalServicePluginConfiguration_UserSettings();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.InternalServicePluginConfiguration#isPublicProfile <em>Public Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public Profile</em>'.
	 * @see org.bimserver.models.store.InternalServicePluginConfiguration#isPublicProfile()
	 * @see #getInternalServicePluginConfiguration()
	 * @generated
	 */
	EAttribute getInternalServicePluginConfiguration_PublicProfile();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ServiceInterface <em>Service Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Interface</em>'.
	 * @see org.bimserver.models.store.ServiceInterface
	 * @generated
	 */
	EClass getServiceInterface();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceInterface#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ServiceInterface#getName()
	 * @see #getServiceInterface()
	 * @generated
	 */
	EAttribute getServiceInterface_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceInterface#getNameSpace <em>Name Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Space</em>'.
	 * @see org.bimserver.models.store.ServiceInterface#getNameSpace()
	 * @see #getServiceInterface()
	 * @generated
	 */
	EAttribute getServiceInterface_NameSpace();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceInterface#getSimpleName <em>Simple Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name</em>'.
	 * @see org.bimserver.models.store.ServiceInterface#getSimpleName()
	 * @see #getServiceInterface()
	 * @generated
	 */
	EAttribute getServiceInterface_SimpleName();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ServiceMethod <em>Service Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Method</em>'.
	 * @see org.bimserver.models.store.ServiceMethod
	 * @generated
	 */
	EClass getServiceMethod();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceMethod#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ServiceMethod#getName()
	 * @see #getServiceMethod()
	 * @generated
	 */
	EAttribute getServiceMethod_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceMethod#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Doc</em>'.
	 * @see org.bimserver.models.store.ServiceMethod#getDoc()
	 * @see #getServiceMethod()
	 * @generated
	 */
	EAttribute getServiceMethod_Doc();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceMethod#getReturnDoc <em>Return Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return Doc</em>'.
	 * @see org.bimserver.models.store.ServiceMethod#getReturnDoc()
	 * @see #getServiceMethod()
	 * @generated
	 */
	EAttribute getServiceMethod_ReturnDoc();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ServiceField <em>Service Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Field</em>'.
	 * @see org.bimserver.models.store.ServiceField
	 * @generated
	 */
	EClass getServiceField();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceField#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ServiceField#getName()
	 * @see #getServiceField()
	 * @generated
	 */
	EAttribute getServiceField_Name();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ServiceField#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.bimserver.models.store.ServiceField#getType()
	 * @see #getServiceField()
	 * @generated
	 */
	EReference getServiceField_Type();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ServiceField#getGenericType <em>Generic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Generic Type</em>'.
	 * @see org.bimserver.models.store.ServiceField#getGenericType()
	 * @see #getServiceField()
	 * @generated
	 */
	EReference getServiceField_GenericType();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceField#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Doc</em>'.
	 * @see org.bimserver.models.store.ServiceField#getDoc()
	 * @see #getServiceField()
	 * @generated
	 */
	EAttribute getServiceField_Doc();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ServiceType <em>Service Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Type</em>'.
	 * @see org.bimserver.models.store.ServiceType
	 * @generated
	 */
	EClass getServiceType();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ServiceType#getName()
	 * @see #getServiceType()
	 * @generated
	 */
	EAttribute getServiceType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceType#getSimpleName <em>Simple Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name</em>'.
	 * @see org.bimserver.models.store.ServiceType#getSimpleName()
	 * @see #getServiceType()
	 * @generated
	 */
	EAttribute getServiceType_SimpleName();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ServiceType#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fields</em>'.
	 * @see org.bimserver.models.store.ServiceType#getFields()
	 * @see #getServiceType()
	 * @generated
	 */
	EReference getServiceType_Fields();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceType#getSimpleType <em>Simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Type</em>'.
	 * @see org.bimserver.models.store.ServiceType#getSimpleType()
	 * @see #getServiceType()
	 * @generated
	 */
	EAttribute getServiceType_SimpleType();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ServiceParameter <em>Service Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Parameter</em>'.
	 * @see org.bimserver.models.store.ServiceParameter
	 * @generated
	 */
	EClass getServiceParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ServiceParameter#getName()
	 * @see #getServiceParameter()
	 * @generated
	 */
	EAttribute getServiceParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ServiceParameter#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Doc</em>'.
	 * @see org.bimserver.models.store.ServiceParameter#getDoc()
	 * @see #getServiceParameter()
	 * @generated
	 */
	EAttribute getServiceParameter_Doc();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ServiceParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.bimserver.models.store.ServiceParameter#getType()
	 * @see #getServiceParameter()
	 * @generated
	 */
	EReference getServiceParameter_Type();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ServiceParameter#getGenericType <em>Generic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Generic Type</em>'.
	 * @see org.bimserver.models.store.ServiceParameter#getGenericType()
	 * @see #getServiceParameter()
	 * @generated
	 */
	EReference getServiceParameter_GenericType();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.TypeDefinition <em>Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Definition</em>'.
	 * @see org.bimserver.models.store.TypeDefinition
	 * @generated
	 */
	EClass getTypeDefinition();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ObjectDefinition <em>Object Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Definition</em>'.
	 * @see org.bimserver.models.store.ObjectDefinition
	 * @generated
	 */
	EClass getObjectDefinition();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ObjectDefinition#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see org.bimserver.models.store.ObjectDefinition#getParameters()
	 * @see #getObjectDefinition()
	 * @generated
	 */
	EReference getObjectDefinition_Parameters();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.PrimitiveDefinition <em>Primitive Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Definition</em>'.
	 * @see org.bimserver.models.store.PrimitiveDefinition
	 * @generated
	 */
	EClass getPrimitiveDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PrimitiveDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.bimserver.models.store.PrimitiveDefinition#getType()
	 * @see #getPrimitiveDefinition()
	 * @generated
	 */
	EAttribute getPrimitiveDefinition_Type();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ArrayDefinition <em>Array Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Definition</em>'.
	 * @see org.bimserver.models.store.ArrayDefinition
	 * @generated
	 */
	EClass getArrayDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ArrayDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.bimserver.models.store.ArrayDefinition#getType()
	 * @see #getArrayDefinition()
	 * @generated
	 */
	EReference getArrayDefinition_Type();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ParameterDefinition <em>Parameter Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Definition</em>'.
	 * @see org.bimserver.models.store.ParameterDefinition
	 * @generated
	 */
	EClass getParameterDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ParameterDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ParameterDefinition#getName()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EAttribute getParameterDefinition_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ParameterDefinition#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.bimserver.models.store.ParameterDefinition#getIdentifier()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EAttribute getParameterDefinition_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ParameterDefinition#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.bimserver.models.store.ParameterDefinition#isRequired()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EAttribute getParameterDefinition_Required();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ParameterDefinition#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.ParameterDefinition#getDescription()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EAttribute getParameterDefinition_Description();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ParameterDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.bimserver.models.store.ParameterDefinition#getType()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EReference getParameterDefinition_Type();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.ParameterDefinition#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Value</em>'.
	 * @see org.bimserver.models.store.ParameterDefinition#getDefaultValue()
	 * @see #getParameterDefinition()
	 * @generated
	 */
	EReference getParameterDefinition_DefaultValue();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.bimserver.models.store.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ObjectType <em>Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Type</em>'.
	 * @see org.bimserver.models.store.ObjectType
	 * @generated
	 */
	EClass getObjectType();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ObjectType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ObjectType#getName()
	 * @see #getObjectType()
	 * @generated
	 */
	EAttribute getObjectType_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ObjectType#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see org.bimserver.models.store.ObjectType#getParameters()
	 * @see #getObjectType()
	 * @generated
	 */
	EReference getObjectType_Parameters();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.bimserver.models.store.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.LongType <em>Long Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Type</em>'.
	 * @see org.bimserver.models.store.LongType
	 * @generated
	 */
	EClass getLongType();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.bimserver.models.store.LongType#getValue()
	 * @see #getLongType()
	 * @generated
	 */
	EAttribute getLongType_Value();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ByteArrayType <em>Byte Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Byte Array Type</em>'.
	 * @see org.bimserver.models.store.ByteArrayType
	 * @generated
	 */
	EClass getByteArrayType();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ByteArrayType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.bimserver.models.store.ByteArrayType#getValue()
	 * @see #getByteArrayType()
	 * @generated
	 */
	EAttribute getByteArrayType_Value();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.DoubleType <em>Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Type</em>'.
	 * @see org.bimserver.models.store.DoubleType
	 * @generated
	 */
	EClass getDoubleType();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.DoubleType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.bimserver.models.store.DoubleType#getValue()
	 * @see #getDoubleType()
	 * @generated
	 */
	EAttribute getDoubleType_Value();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see org.bimserver.models.store.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.StringType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.bimserver.models.store.StringType#getValue()
	 * @see #getStringType()
	 * @generated
	 */
	EAttribute getStringType_Value();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see org.bimserver.models.store.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.BooleanType#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.bimserver.models.store.BooleanType#isValue()
	 * @see #getBooleanType()
	 * @generated
	 */
	EAttribute getBooleanType_Value();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Type</em>'.
	 * @see org.bimserver.models.store.ArrayType
	 * @generated
	 */
	EClass getArrayType();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ArrayType#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.bimserver.models.store.ArrayType#getValues()
	 * @see #getArrayType()
	 * @generated
	 */
	EReference getArrayType_Values();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.bimserver.models.store.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Parameter#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.bimserver.models.store.Parameter#getIdentifier()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Parameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.bimserver.models.store.Parameter#getValue()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Value();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ImmediateNotificationResult <em>Immediate Notification Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Immediate Notification Result</em>'.
	 * @see org.bimserver.models.store.ImmediateNotificationResult
	 * @generated
	 */
	EClass getImmediateNotificationResult();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ImmediateNotificationResult#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see org.bimserver.models.store.ImmediateNotificationResult#getResult()
	 * @see #getImmediateNotificationResult()
	 * @generated
	 */
	EAttribute getImmediateNotificationResult_Result();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ImmediateNotificationResult#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.ImmediateNotificationResult#getDescription()
	 * @see #getImmediateNotificationResult()
	 * @generated
	 */
	EAttribute getImmediateNotificationResult_Description();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.RemoteServiceUpdate <em>Remote Service Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remote Service Update</em>'.
	 * @see org.bimserver.models.store.RemoteServiceUpdate
	 * @generated
	 */
	EClass getRemoteServiceUpdate();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.PercentageChange <em>Percentage Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Percentage Change</em>'.
	 * @see org.bimserver.models.store.PercentageChange
	 * @generated
	 */
	EClass getPercentageChange();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PercentageChange#getPercentage <em>Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percentage</em>'.
	 * @see org.bimserver.models.store.PercentageChange#getPercentage()
	 * @see #getPercentageChange()
	 * @generated
	 */
	EAttribute getPercentageChange_Percentage();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.SystemInfo <em>System Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Info</em>'.
	 * @see org.bimserver.models.store.SystemInfo
	 * @generated
	 */
	EClass getSystemInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SystemInfo#getCpucores <em>Cpucores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpucores</em>'.
	 * @see org.bimserver.models.store.SystemInfo#getCpucores()
	 * @see #getSystemInfo()
	 * @generated
	 */
	EAttribute getSystemInfo_Cpucores();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SystemInfo#getDatetime <em>Datetime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Datetime</em>'.
	 * @see org.bimserver.models.store.SystemInfo#getDatetime()
	 * @see #getSystemInfo()
	 * @generated
	 */
	EAttribute getSystemInfo_Datetime();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SystemInfo#getOsname <em>Osname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Osname</em>'.
	 * @see org.bimserver.models.store.SystemInfo#getOsname()
	 * @see #getSystemInfo()
	 * @generated
	 */
	EAttribute getSystemInfo_Osname();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SystemInfo#getOsversion <em>Osversion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Osversion</em>'.
	 * @see org.bimserver.models.store.SystemInfo#getOsversion()
	 * @see #getSystemInfo()
	 * @generated
	 */
	EAttribute getSystemInfo_Osversion();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SystemInfo#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see org.bimserver.models.store.SystemInfo#getUserName()
	 * @see #getSystemInfo()
	 * @generated
	 */
	EAttribute getSystemInfo_UserName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SystemInfo#getUserHome <em>User Home</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Home</em>'.
	 * @see org.bimserver.models.store.SystemInfo#getUserHome()
	 * @see #getSystemInfo()
	 * @generated
	 */
	EAttribute getSystemInfo_UserHome();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.SystemInfo#getUserDir <em>User Dir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Dir</em>'.
	 * @see org.bimserver.models.store.SystemInfo#getUserDir()
	 * @see #getSystemInfo()
	 * @generated
	 */
	EAttribute getSystemInfo_UserDir();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.JavaInfo <em>Java Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Info</em>'.
	 * @see org.bimserver.models.store.JavaInfo
	 * @generated
	 */
	EClass getJavaInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getHeapTotal <em>Heap Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heap Total</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getHeapTotal()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_HeapTotal();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getHeapUsed <em>Heap Used</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heap Used</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getHeapUsed()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_HeapUsed();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getHeapFree <em>Heap Free</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heap Free</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getHeapFree()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_HeapFree();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getHeapMax <em>Heap Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heap Max</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getHeapMax()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_HeapMax();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getThreads <em>Threads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Threads</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getThreads()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_Threads();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaHome <em>Java Home</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Home</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaHome()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaHome();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaVersion <em>Java Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Version</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaVersion()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaVendor <em>Java Vendor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Vendor</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaVendor()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaVendor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaVendorurl <em>Java Vendorurl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Vendorurl</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaVendorurl()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaVendorurl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavavmVersion <em>Javavm Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Javavm Version</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavavmVersion()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavavmVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavavmVendor <em>Javavm Vendor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Javavm Vendor</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavavmVendor()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavavmVendor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavavmName <em>Javavm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Javavm Name</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavavmName()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavavmName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaspecVersion <em>Javaspec Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Javaspec Version</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaspecVersion()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaspecVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaspecVendor <em>Javaspec Vendor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Javaspec Vendor</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaspecVendor()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaspecVendor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaspecName <em>Javaspec Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Javaspec Name</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaspecName()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaspecName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaClassVersion <em>Java Class Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Class Version</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaClassVersion()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaClassVersion();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.JavaInfo#getJavaClasspath <em>Java Classpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Java Classpath</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaClasspath()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaClasspath();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.JavaInfo#getJavaLibrarypath <em>Java Librarypath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Java Librarypath</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaLibrarypath()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaLibrarypath();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaIoTmp <em>Java Io Tmp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Io Tmp</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaIoTmp()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaIoTmp();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaExtdir <em>Java Extdir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Extdir</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaExtdir()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaExtdir();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaFileSeparator <em>Java File Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java File Separator</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaFileSeparator()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaFileSeparator();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaPathSeparator <em>Java Path Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Path Separator</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaPathSeparator()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaPathSeparator();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.JavaInfo#getJavaLineSeparator <em>Java Line Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Line Separator</em>'.
	 * @see org.bimserver.models.store.JavaInfo#getJavaLineSeparator()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_JavaLineSeparator();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.BimServerInfo <em>Bim Server Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bim Server Info</em>'.
	 * @see org.bimserver.models.store.BimServerInfo
	 * @generated
	 */
	EClass getBimServerInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.BimServerInfo#getCurrentVersion <em>Current Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Version</em>'.
	 * @see org.bimserver.models.store.BimServerInfo#getCurrentVersion()
	 * @see #getBimServerInfo()
	 * @generated
	 */
	EAttribute getBimServerInfo_CurrentVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.BimServerInfo#getCurrentDate <em>Current Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Date</em>'.
	 * @see org.bimserver.models.store.BimServerInfo#getCurrentDate()
	 * @see #getBimServerInfo()
	 * @generated
	 */
	EAttribute getBimServerInfo_CurrentDate();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.BimServerInfo#getSchemaVersion <em>Schema Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema Version</em>'.
	 * @see org.bimserver.models.store.BimServerInfo#getSchemaVersion()
	 * @see #getBimServerInfo()
	 * @generated
	 */
	EAttribute getBimServerInfo_SchemaVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.BimServerInfo#getLatestDate <em>Latest Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latest Date</em>'.
	 * @see org.bimserver.models.store.BimServerInfo#getLatestDate()
	 * @see #getBimServerInfo()
	 * @generated
	 */
	EAttribute getBimServerInfo_LatestDate();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.BimServerInfo#getLatestVersion <em>Latest Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latest Version</em>'.
	 * @see org.bimserver.models.store.BimServerInfo#getLatestVersion()
	 * @see #getBimServerInfo()
	 * @generated
	 */
	EAttribute getBimServerInfo_LatestVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.BimServerInfo#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Projects</em>'.
	 * @see org.bimserver.models.store.BimServerInfo#getProjects()
	 * @see #getBimServerInfo()
	 * @generated
	 */
	EAttribute getBimServerInfo_Projects();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.BimServerInfo#getRevisions <em>Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Revisions</em>'.
	 * @see org.bimserver.models.store.BimServerInfo#getRevisions()
	 * @see #getBimServerInfo()
	 * @generated
	 */
	EAttribute getBimServerInfo_Revisions();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.BimServerInfo#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Users</em>'.
	 * @see org.bimserver.models.store.BimServerInfo#getUsers()
	 * @see #getBimServerInfo()
	 * @generated
	 */
	EAttribute getBimServerInfo_Users();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.BimServerInfo#getCheckouts <em>Checkouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkouts</em>'.
	 * @see org.bimserver.models.store.BimServerInfo#getCheckouts()
	 * @see #getBimServerInfo()
	 * @generated
	 */
	EAttribute getBimServerInfo_Checkouts();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.BimServerInfo#getServerLogUrl <em>Server Log Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Log Url</em>'.
	 * @see org.bimserver.models.store.BimServerInfo#getServerLogUrl()
	 * @see #getBimServerInfo()
	 * @generated
	 */
	EAttribute getBimServerInfo_ServerLogUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.BimServerInfo#getStarted <em>Started</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Started</em>'.
	 * @see org.bimserver.models.store.BimServerInfo#getStarted()
	 * @see #getBimServerInfo()
	 * @generated
	 */
	EAttribute getBimServerInfo_Started();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ProjectSmall <em>Project Small</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Small</em>'.
	 * @see org.bimserver.models.store.ProjectSmall
	 * @generated
	 */
	EClass getProjectSmall();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ProjectSmall#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ProjectSmall#getName()
	 * @see #getProjectSmall()
	 * @generated
	 */
	EAttribute getProjectSmall_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ProjectSmall#getParentId <em>Parent Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Id</em>'.
	 * @see org.bimserver.models.store.ProjectSmall#getParentId()
	 * @see #getProjectSmall()
	 * @generated
	 */
	EAttribute getProjectSmall_ParentId();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ProjectSmall#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.bimserver.models.store.ProjectSmall#getState()
	 * @see #getProjectSmall()
	 * @generated
	 */
	EAttribute getProjectSmall_State();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ProjectSmall#getNrRevisions <em>Nr Revisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nr Revisions</em>'.
	 * @see org.bimserver.models.store.ProjectSmall#getNrRevisions()
	 * @see #getProjectSmall()
	 * @generated
	 */
	EAttribute getProjectSmall_NrRevisions();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ProjectSmall#getNrSubProjects <em>Nr Sub Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nr Sub Projects</em>'.
	 * @see org.bimserver.models.store.ProjectSmall#getNrSubProjects()
	 * @see #getProjectSmall()
	 * @generated
	 */
	EAttribute getProjectSmall_NrSubProjects();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ProjectSmall#isHasCheckinRights <em>Has Checkin Rights</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Checkin Rights</em>'.
	 * @see org.bimserver.models.store.ProjectSmall#isHasCheckinRights()
	 * @see #getProjectSmall()
	 * @generated
	 */
	EAttribute getProjectSmall_HasCheckinRights();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ProjectSmall#getLastRevisionId <em>Last Revision Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Revision Id</em>'.
	 * @see org.bimserver.models.store.ProjectSmall#getLastRevisionId()
	 * @see #getProjectSmall()
	 * @generated
	 */
	EAttribute getProjectSmall_LastRevisionId();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ProjectSmall#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schema</em>'.
	 * @see org.bimserver.models.store.ProjectSmall#getSchema()
	 * @see #getProjectSmall()
	 * @generated
	 */
	EAttribute getProjectSmall_Schema();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.IfcHeader <em>Ifc Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ifc Header</em>'.
	 * @see org.bimserver.models.store.IfcHeader
	 * @generated
	 */
	EClass getIfcHeader();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.IfcHeader#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Description</em>'.
	 * @see org.bimserver.models.store.IfcHeader#getDescription()
	 * @see #getIfcHeader()
	 * @generated
	 */
	EAttribute getIfcHeader_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.IfcHeader#getImplementationLevel <em>Implementation Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Level</em>'.
	 * @see org.bimserver.models.store.IfcHeader#getImplementationLevel()
	 * @see #getIfcHeader()
	 * @generated
	 */
	EAttribute getIfcHeader_ImplementationLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.IfcHeader#getFilename <em>Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filename</em>'.
	 * @see org.bimserver.models.store.IfcHeader#getFilename()
	 * @see #getIfcHeader()
	 * @generated
	 */
	EAttribute getIfcHeader_Filename();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.IfcHeader#getTimeStamp <em>Time Stamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Stamp</em>'.
	 * @see org.bimserver.models.store.IfcHeader#getTimeStamp()
	 * @see #getIfcHeader()
	 * @generated
	 */
	EAttribute getIfcHeader_TimeStamp();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.IfcHeader#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Author</em>'.
	 * @see org.bimserver.models.store.IfcHeader#getAuthor()
	 * @see #getIfcHeader()
	 * @generated
	 */
	EAttribute getIfcHeader_Author();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.IfcHeader#getOrganization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Organization</em>'.
	 * @see org.bimserver.models.store.IfcHeader#getOrganization()
	 * @see #getIfcHeader()
	 * @generated
	 */
	EAttribute getIfcHeader_Organization();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.IfcHeader#getPreProcessorVersion <em>Pre Processor Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pre Processor Version</em>'.
	 * @see org.bimserver.models.store.IfcHeader#getPreProcessorVersion()
	 * @see #getIfcHeader()
	 * @generated
	 */
	EAttribute getIfcHeader_PreProcessorVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.IfcHeader#getOriginatingSystem <em>Originating System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Originating System</em>'.
	 * @see org.bimserver.models.store.IfcHeader#getOriginatingSystem()
	 * @see #getIfcHeader()
	 * @generated
	 */
	EAttribute getIfcHeader_OriginatingSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.IfcHeader#getIfcSchemaVersion <em>Ifc Schema Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ifc Schema Version</em>'.
	 * @see org.bimserver.models.store.IfcHeader#getIfcSchemaVersion()
	 * @see #getIfcHeader()
	 * @generated
	 */
	EAttribute getIfcHeader_IfcSchemaVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.IfcHeader#getAuthorization <em>Authorization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Authorization</em>'.
	 * @see org.bimserver.models.store.IfcHeader#getAuthorization()
	 * @see #getIfcHeader()
	 * @generated
	 */
	EAttribute getIfcHeader_Authorization();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ModelCheckerResultItem <em>Model Checker Result Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Checker Result Item</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResultItem
	 * @generated
	 */
	EClass getModelCheckerResultItem();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ModelCheckerResultHeader <em>Model Checker Result Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Checker Result Header</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResultHeader
	 * @generated
	 */
	EClass getModelCheckerResultHeader();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerResultHeader#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResultHeader#getText()
	 * @see #getModelCheckerResultHeader()
	 * @generated
	 */
	EAttribute getModelCheckerResultHeader_Text();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ModelCheckerResultLine <em>Model Checker Result Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Checker Result Line</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResultLine
	 * @generated
	 */
	EClass getModelCheckerResultLine();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerResultLine#getFieldOrClass <em>Field Or Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Or Class</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResultLine#getFieldOrClass()
	 * @see #getModelCheckerResultLine()
	 * @generated
	 */
	EAttribute getModelCheckerResultLine_FieldOrClass();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerResultLine#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResultLine#getValue()
	 * @see #getModelCheckerResultLine()
	 * @generated
	 */
	EAttribute getModelCheckerResultLine_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerResultLine#getShouldBe <em>Should Be</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Should Be</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResultLine#getShouldBe()
	 * @see #getModelCheckerResultLine()
	 * @generated
	 */
	EAttribute getModelCheckerResultLine_ShouldBe();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerResultLine#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResultLine#getType()
	 * @see #getModelCheckerResultLine()
	 * @generated
	 */
	EAttribute getModelCheckerResultLine_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerResultLine#getObjectId <em>Object Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Id</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResultLine#getObjectId()
	 * @see #getModelCheckerResultLine()
	 * @generated
	 */
	EAttribute getModelCheckerResultLine_ObjectId();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ModelCheckerResult <em>Model Checker Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Checker Result</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResult
	 * @generated
	 */
	EClass getModelCheckerResult();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerResult#isValid <em>Valid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResult#isValid()
	 * @see #getModelCheckerResult()
	 * @generated
	 */
	EAttribute getModelCheckerResult_Valid();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.ModelCheckerResult#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Items</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResult#getItems()
	 * @see #getModelCheckerResult()
	 * @generated
	 */
	EReference getModelCheckerResult_Items();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.ModelCheckerInstance <em>Model Checker Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Checker Instance</em>'.
	 * @see org.bimserver.models.store.ModelCheckerInstance
	 * @generated
	 */
	EClass getModelCheckerInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerInstance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.ModelCheckerInstance#getName()
	 * @see #getModelCheckerInstance()
	 * @generated
	 */
	EAttribute getModelCheckerInstance_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerInstance#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.ModelCheckerInstance#getDescription()
	 * @see #getModelCheckerInstance()
	 * @generated
	 */
	EAttribute getModelCheckerInstance_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerInstance#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.bimserver.models.store.ModelCheckerInstance#getCode()
	 * @see #getModelCheckerInstance()
	 * @generated
	 */
	EAttribute getModelCheckerInstance_Code();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerInstance#getCompiled <em>Compiled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compiled</em>'.
	 * @see org.bimserver.models.store.ModelCheckerInstance#getCompiled()
	 * @see #getModelCheckerInstance()
	 * @generated
	 */
	EAttribute getModelCheckerInstance_Compiled();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerInstance#isValid <em>Valid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid</em>'.
	 * @see org.bimserver.models.store.ModelCheckerInstance#isValid()
	 * @see #getModelCheckerInstance()
	 * @generated
	 */
	EAttribute getModelCheckerInstance_Valid();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.ModelCheckerInstance#getModelCheckerPluginClassName <em>Model Checker Plugin Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Checker Plugin Class Name</em>'.
	 * @see org.bimserver.models.store.ModelCheckerInstance#getModelCheckerPluginClassName()
	 * @see #getModelCheckerInstance()
	 * @generated
	 */
	EAttribute getModelCheckerInstance_ModelCheckerPluginClassName();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.MessagingSerializerPluginConfiguration <em>Messaging Serializer Plugin Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Messaging Serializer Plugin Configuration</em>'.
	 * @see org.bimserver.models.store.MessagingSerializerPluginConfiguration
	 * @generated
	 */
	EClass getMessagingSerializerPluginConfiguration();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Metrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metrics</em>'.
	 * @see org.bimserver.models.store.Metrics
	 * @generated
	 */
	EClass getMetrics();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.Metrics#getInterfaces <em>Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Interfaces</em>'.
	 * @see org.bimserver.models.store.Metrics#getInterfaces()
	 * @see #getMetrics()
	 * @generated
	 */
	EReference getMetrics_Interfaces();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.InterfaceMetric <em>Interface Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Metric</em>'.
	 * @see org.bimserver.models.store.InterfaceMetric
	 * @generated
	 */
	EClass getInterfaceMetric();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.InterfaceMetric#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Methods</em>'.
	 * @see org.bimserver.models.store.InterfaceMetric#getMethods()
	 * @see #getInterfaceMetric()
	 * @generated
	 */
	EReference getInterfaceMetric_Methods();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.InterfaceMetric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.InterfaceMetric#getName()
	 * @see #getInterfaceMetric()
	 * @generated
	 */
	EAttribute getInterfaceMetric_Name();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.MethodMetric <em>Method Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Metric</em>'.
	 * @see org.bimserver.models.store.MethodMetric
	 * @generated
	 */
	EClass getMethodMetric();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.MethodMetric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.MethodMetric#getName()
	 * @see #getMethodMetric()
	 * @generated
	 */
	EAttribute getMethodMetric_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.MethodMetric#getNrCalls <em>Nr Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nr Calls</em>'.
	 * @see org.bimserver.models.store.MethodMetric#getNrCalls()
	 * @see #getMethodMetric()
	 * @generated
	 */
	EAttribute getMethodMetric_NrCalls();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.MethodMetric#getLastCall <em>Last Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Call</em>'.
	 * @see org.bimserver.models.store.MethodMetric#getLastCall()
	 * @see #getMethodMetric()
	 * @generated
	 */
	EAttribute getMethodMetric_LastCall();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.MethodMetric#getAverageMs <em>Average Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Average Ms</em>'.
	 * @see org.bimserver.models.store.MethodMetric#getAverageMs()
	 * @see #getMethodMetric()
	 * @generated
	 */
	EAttribute getMethodMetric_AverageMs();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.MethodMetric#getShortestMs <em>Shortest Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shortest Ms</em>'.
	 * @see org.bimserver.models.store.MethodMetric#getShortestMs()
	 * @see #getMethodMetric()
	 * @generated
	 */
	EAttribute getMethodMetric_ShortestMs();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.MethodMetric#getLongestMs <em>Longest Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Longest Ms</em>'.
	 * @see org.bimserver.models.store.MethodMetric#getLongestMs()
	 * @see #getMethodMetric()
	 * @generated
	 */
	EAttribute getMethodMetric_LongestMs();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.PluginBundleVersion <em>Plugin Bundle Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin Bundle Version</em>'.
	 * @see org.bimserver.models.store.PluginBundleVersion
	 * @generated
	 */
	EClass getPluginBundleVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundleVersion#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.bimserver.models.store.PluginBundleVersion#getVersion()
	 * @see #getPluginBundleVersion()
	 * @generated
	 */
	EAttribute getPluginBundleVersion_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundleVersion#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.bimserver.models.store.PluginBundleVersion#getType()
	 * @see #getPluginBundleVersion()
	 * @generated
	 */
	EAttribute getPluginBundleVersion_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundleVersion#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.PluginBundleVersion#getDescription()
	 * @see #getPluginBundleVersion()
	 * @generated
	 */
	EAttribute getPluginBundleVersion_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundleVersion#isMismatch <em>Mismatch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mismatch</em>'.
	 * @see org.bimserver.models.store.PluginBundleVersion#isMismatch()
	 * @see #getPluginBundleVersion()
	 * @generated
	 */
	EAttribute getPluginBundleVersion_Mismatch();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundleVersion#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository</em>'.
	 * @see org.bimserver.models.store.PluginBundleVersion#getRepository()
	 * @see #getPluginBundleVersion()
	 * @generated
	 */
	EAttribute getPluginBundleVersion_Repository();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundleVersion#getGroupId <em>Group Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Id</em>'.
	 * @see org.bimserver.models.store.PluginBundleVersion#getGroupId()
	 * @see #getPluginBundleVersion()
	 * @generated
	 */
	EAttribute getPluginBundleVersion_GroupId();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundleVersion#getArtifactId <em>Artifact Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Artifact Id</em>'.
	 * @see org.bimserver.models.store.PluginBundleVersion#getArtifactId()
	 * @see #getPluginBundleVersion()
	 * @generated
	 */
	EAttribute getPluginBundleVersion_ArtifactId();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundleVersion#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.bimserver.models.store.PluginBundleVersion#getIcon()
	 * @see #getPluginBundleVersion()
	 * @generated
	 */
	EAttribute getPluginBundleVersion_Icon();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundleVersion#getOrganization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Organization</em>'.
	 * @see org.bimserver.models.store.PluginBundleVersion#getOrganization()
	 * @see #getPluginBundleVersion()
	 * @generated
	 */
	EAttribute getPluginBundleVersion_Organization();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundleVersion#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.PluginBundleVersion#getName()
	 * @see #getPluginBundleVersion()
	 * @generated
	 */
	EAttribute getPluginBundleVersion_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundleVersion#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.bimserver.models.store.PluginBundleVersion#getDate()
	 * @see #getPluginBundleVersion()
	 * @generated
	 */
	EAttribute getPluginBundleVersion_Date();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.PluginBundle <em>Plugin Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin Bundle</em>'.
	 * @see org.bimserver.models.store.PluginBundle
	 * @generated
	 */
	EClass getPluginBundle();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundle#getOrganization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Organization</em>'.
	 * @see org.bimserver.models.store.PluginBundle#getOrganization()
	 * @see #getPluginBundle()
	 * @generated
	 */
	EAttribute getPluginBundle_Organization();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginBundle#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.PluginBundle#getName()
	 * @see #getPluginBundle()
	 * @generated
	 */
	EAttribute getPluginBundle_Name();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.PluginBundle#getLatestVersion <em>Latest Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Latest Version</em>'.
	 * @see org.bimserver.models.store.PluginBundle#getLatestVersion()
	 * @see #getPluginBundle()
	 * @generated
	 */
	EReference getPluginBundle_LatestVersion();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.PluginBundle#getAvailableVersions <em>Available Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Available Versions</em>'.
	 * @see org.bimserver.models.store.PluginBundle#getAvailableVersions()
	 * @see #getPluginBundle()
	 * @generated
	 */
	EReference getPluginBundle_AvailableVersions();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.PluginBundle#getInstalledVersion <em>Installed Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Installed Version</em>'.
	 * @see org.bimserver.models.store.PluginBundle#getInstalledVersion()
	 * @see #getPluginBundle()
	 * @generated
	 */
	EReference getPluginBundle_InstalledVersion();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.PluginInformation <em>Plugin Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin Information</em>'.
	 * @see org.bimserver.models.store.PluginInformation
	 * @generated
	 */
	EClass getPluginInformation();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginInformation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.PluginInformation#getName()
	 * @see #getPluginInformation()
	 * @generated
	 */
	EAttribute getPluginInformation_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginInformation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.bimserver.models.store.PluginInformation#getType()
	 * @see #getPluginInformation()
	 * @generated
	 */
	EAttribute getPluginInformation_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginInformation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.PluginInformation#getDescription()
	 * @see #getPluginInformation()
	 * @generated
	 */
	EAttribute getPluginInformation_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginInformation#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.bimserver.models.store.PluginInformation#isEnabled()
	 * @see #getPluginInformation()
	 * @generated
	 */
	EAttribute getPluginInformation_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginInformation#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.bimserver.models.store.PluginInformation#getIdentifier()
	 * @see #getPluginInformation()
	 * @generated
	 */
	EAttribute getPluginInformation_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginInformation#isInstallForAllUsers <em>Install For All Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install For All Users</em>'.
	 * @see org.bimserver.models.store.PluginInformation#isInstallForAllUsers()
	 * @see #getPluginInformation()
	 * @generated
	 */
	EAttribute getPluginInformation_InstallForAllUsers();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.PluginInformation#isInstallForNewUsers <em>Install For New Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install For New Users</em>'.
	 * @see org.bimserver.models.store.PluginInformation#isInstallForNewUsers()
	 * @see #getPluginInformation()
	 * @generated
	 */
	EAttribute getPluginInformation_InstallForNewUsers();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.OAuthServer <em>OAuth Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OAuth Server</em>'.
	 * @see org.bimserver.models.store.OAuthServer
	 * @generated
	 */
	EClass getOAuthServer();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#getRegistrationUrl <em>Registration Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Url</em>'.
	 * @see org.bimserver.models.store.OAuthServer#getRegistrationUrl()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_RegistrationUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#getClientId <em>Client Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Id</em>'.
	 * @see org.bimserver.models.store.OAuthServer#getClientId()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_ClientId();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#getClientSecret <em>Client Secret</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Secret</em>'.
	 * @see org.bimserver.models.store.OAuthServer#getClientSecret()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_ClientSecret();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#getClientName <em>Client Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Name</em>'.
	 * @see org.bimserver.models.store.OAuthServer#getClientName()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_ClientName();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#getClientIcon <em>Client Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Icon</em>'.
	 * @see org.bimserver.models.store.OAuthServer#getClientIcon()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_ClientIcon();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#getClientUrl <em>Client Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Url</em>'.
	 * @see org.bimserver.models.store.OAuthServer#getClientUrl()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_ClientUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#getClientDescription <em>Client Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Description</em>'.
	 * @see org.bimserver.models.store.OAuthServer#getClientDescription()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_ClientDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#getRedirectUrl <em>Redirect Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Redirect Url</em>'.
	 * @see org.bimserver.models.store.OAuthServer#getRedirectUrl()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_RedirectUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#getExpiresAt <em>Expires At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expires At</em>'.
	 * @see org.bimserver.models.store.OAuthServer#getExpiresAt()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_ExpiresAt();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#getIssuedAt <em>Issued At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Issued At</em>'.
	 * @see org.bimserver.models.store.OAuthServer#getIssuedAt()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_IssuedAt();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#isIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Incoming</em>'.
	 * @see org.bimserver.models.store.OAuthServer#isIncoming()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_Incoming();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#getApiUrl <em>Api Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Api Url</em>'.
	 * @see org.bimserver.models.store.OAuthServer#getApiUrl()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_ApiUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthServer#getRegistrationEndpoint <em>Registration Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Endpoint</em>'.
	 * @see org.bimserver.models.store.OAuthServer#getRegistrationEndpoint()
	 * @see #getOAuthServer()
	 * @generated
	 */
	EAttribute getOAuthServer_RegistrationEndpoint();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.OAuthAuthorizationCode <em>OAuth Authorization Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OAuth Authorization Code</em>'.
	 * @see org.bimserver.models.store.OAuthAuthorizationCode
	 * @generated
	 */
	EClass getOAuthAuthorizationCode();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.OAuthAuthorizationCode#getOauthServer <em>Oauth Server</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Oauth Server</em>'.
	 * @see org.bimserver.models.store.OAuthAuthorizationCode#getOauthServer()
	 * @see #getOAuthAuthorizationCode()
	 * @generated
	 */
	EReference getOAuthAuthorizationCode_OauthServer();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthAuthorizationCode#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.bimserver.models.store.OAuthAuthorizationCode#getCode()
	 * @see #getOAuthAuthorizationCode()
	 * @generated
	 */
	EAttribute getOAuthAuthorizationCode_Code();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.OAuthAuthorizationCode#getAuthorization <em>Authorization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Authorization</em>'.
	 * @see org.bimserver.models.store.OAuthAuthorizationCode#getAuthorization()
	 * @see #getOAuthAuthorizationCode()
	 * @generated
	 */
	EReference getOAuthAuthorizationCode_Authorization();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.OAuthAuthorizationCode#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.store.OAuthAuthorizationCode#getUser()
	 * @see #getOAuthAuthorizationCode()
	 * @generated
	 */
	EReference getOAuthAuthorizationCode_User();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.OAuthAuthorizationCode#getIssued <em>Issued</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Issued</em>'.
	 * @see org.bimserver.models.store.OAuthAuthorizationCode#getIssued()
	 * @see #getOAuthAuthorizationCode()
	 * @generated
	 */
	EAttribute getOAuthAuthorizationCode_Issued();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Authorization <em>Authorization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Authorization</em>'.
	 * @see org.bimserver.models.store.Authorization
	 * @generated
	 */
	EClass getAuthorization();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.SingleProjectAuthorization <em>Single Project Authorization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Project Authorization</em>'.
	 * @see org.bimserver.models.store.SingleProjectAuthorization
	 * @generated
	 */
	EClass getSingleProjectAuthorization();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.SingleProjectAuthorization#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.store.SingleProjectAuthorization#getProject()
	 * @see #getSingleProjectAuthorization()
	 * @generated
	 */
	EReference getSingleProjectAuthorization_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.NewServiceDescriptor <em>New Service Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Service Descriptor</em>'.
	 * @see org.bimserver.models.store.NewServiceDescriptor
	 * @generated
	 */
	EClass getNewServiceDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewServiceDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.NewServiceDescriptor#getName()
	 * @see #getNewServiceDescriptor()
	 * @generated
	 */
	EAttribute getNewServiceDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewServiceDescriptor#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.NewServiceDescriptor#getDescription()
	 * @see #getNewServiceDescriptor()
	 * @generated
	 */
	EAttribute getNewServiceDescriptor_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewServiceDescriptor#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.bimserver.models.store.NewServiceDescriptor#getProvider()
	 * @see #getNewServiceDescriptor()
	 * @generated
	 */
	EAttribute getNewServiceDescriptor_Provider();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewServiceDescriptor#getAuthorizationUrl <em>Authorization Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Authorization Url</em>'.
	 * @see org.bimserver.models.store.NewServiceDescriptor#getAuthorizationUrl()
	 * @see #getNewServiceDescriptor()
	 * @generated
	 */
	EAttribute getNewServiceDescriptor_AuthorizationUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewServiceDescriptor#getTokenUrl <em>Token Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token Url</em>'.
	 * @see org.bimserver.models.store.NewServiceDescriptor#getTokenUrl()
	 * @see #getNewServiceDescriptor()
	 * @generated
	 */
	EAttribute getNewServiceDescriptor_TokenUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewServiceDescriptor#getResourceUrl <em>Resource Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Url</em>'.
	 * @see org.bimserver.models.store.NewServiceDescriptor#getResourceUrl()
	 * @see #getNewServiceDescriptor()
	 * @generated
	 */
	EAttribute getNewServiceDescriptor_ResourceUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewServiceDescriptor#getRegisterUrl <em>Register Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Register Url</em>'.
	 * @see org.bimserver.models.store.NewServiceDescriptor#getRegisterUrl()
	 * @see #getNewServiceDescriptor()
	 * @generated
	 */
	EAttribute getNewServiceDescriptor_RegisterUrl();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.NewServiceDescriptor#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Inputs</em>'.
	 * @see org.bimserver.models.store.NewServiceDescriptor#getInputs()
	 * @see #getNewServiceDescriptor()
	 * @generated
	 */
	EAttribute getNewServiceDescriptor_Inputs();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.store.NewServiceDescriptor#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Outputs</em>'.
	 * @see org.bimserver.models.store.NewServiceDescriptor#getOutputs()
	 * @see #getNewServiceDescriptor()
	 * @generated
	 */
	EAttribute getNewServiceDescriptor_Outputs();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.FormatSerializerMap <em>Format Serializer Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Format Serializer Map</em>'.
	 * @see org.bimserver.models.store.FormatSerializerMap
	 * @generated
	 */
	EClass getFormatSerializerMap();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.FormatSerializerMap#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.bimserver.models.store.FormatSerializerMap#getFormat()
	 * @see #getFormatSerializerMap()
	 * @generated
	 */
	EAttribute getFormatSerializerMap_Format();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.FormatSerializerMap#getSerializers <em>Serializers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Serializers</em>'.
	 * @see org.bimserver.models.store.FormatSerializerMap#getSerializers()
	 * @see #getFormatSerializerMap()
	 * @generated
	 */
	EReference getFormatSerializerMap_Serializers();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.bimserver.models.store.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.StoreExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Data</em>'.
	 * @see org.bimserver.models.store.StoreExtendedData
	 * @generated
	 */
	EClass getStoreExtendedData();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.CheckinRevision <em>Checkin Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Checkin Revision</em>'.
	 * @see org.bimserver.models.store.CheckinRevision
	 * @generated
	 */
	EClass getCheckinRevision();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.CheckinRevision#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.store.CheckinRevision#getProject()
	 * @see #getCheckinRevision()
	 * @generated
	 */
	EReference getCheckinRevision_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.NewService <em>New Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Service</em>'.
	 * @see org.bimserver.models.store.NewService
	 * @generated
	 */
	EClass getNewService();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.bimserver.models.store.NewService#getName()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.bimserver.models.store.NewService#getProvider()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_Provider();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.bimserver.models.store.NewService#getDescription()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getAuthorizationUrl <em>Authorization Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Authorization Url</em>'.
	 * @see org.bimserver.models.store.NewService#getAuthorizationUrl()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_AuthorizationUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getTokenUrl <em>Token Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token Url</em>'.
	 * @see org.bimserver.models.store.NewService#getTokenUrl()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_TokenUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getResourceUrl <em>Resource Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Url</em>'.
	 * @see org.bimserver.models.store.NewService#getResourceUrl()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_ResourceUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getRegisterUrl <em>Register Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Register Url</em>'.
	 * @see org.bimserver.models.store.NewService#getRegisterUrl()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_RegisterUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see org.bimserver.models.store.NewService#getInput()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_Input();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getOauthCode <em>Oauth Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Oauth Code</em>'.
	 * @see org.bimserver.models.store.NewService#getOauthCode()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_OauthCode();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.bimserver.models.store.NewService#getStatus()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_Status();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.NewService#getSerializer <em>Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Serializer</em>'.
	 * @see org.bimserver.models.store.NewService#getSerializer()
	 * @see #getNewService()
	 * @generated
	 */
	EReference getNewService_Serializer();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see org.bimserver.models.store.NewService#getOutput()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_Output();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.NewService#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see org.bimserver.models.store.NewService#getAction()
	 * @see #getNewService()
	 * @generated
	 */
	EReference getNewService_Action();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getAccessToken <em>Access Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Token</em>'.
	 * @see org.bimserver.models.store.NewService#getAccessToken()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_AccessToken();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.NewService#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.store.NewService#getProject()
	 * @see #getNewService()
	 * @generated
	 */
	EReference getNewService_Project();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.NewService#getStateJson <em>State Json</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Json</em>'.
	 * @see org.bimserver.models.store.NewService#getStateJson()
	 * @see #getNewService()
	 * @generated
	 */
	EAttribute getNewService_StateJson();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.RunServiceAuthorization <em>Run Service Authorization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run Service Authorization</em>'.
	 * @see org.bimserver.models.store.RunServiceAuthorization
	 * @generated
	 */
	EClass getRunServiceAuthorization();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.RunServiceAuthorization#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service</em>'.
	 * @see org.bimserver.models.store.RunServiceAuthorization#getService()
	 * @see #getRunServiceAuthorization()
	 * @generated
	 */
	EReference getRunServiceAuthorization_Service();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.DensityCollection <em>Density Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Density Collection</em>'.
	 * @see org.bimserver.models.store.DensityCollection
	 * @generated
	 */
	EClass getDensityCollection();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.store.DensityCollection#getDensities <em>Densities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Densities</em>'.
	 * @see org.bimserver.models.store.DensityCollection#getDensities()
	 * @see #getDensityCollection()
	 * @generated
	 */
	EReference getDensityCollection_Densities();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Density <em>Density</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Density</em>'.
	 * @see org.bimserver.models.store.Density
	 * @generated
	 */
	EClass getDensity();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Density#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.bimserver.models.store.Density#getType()
	 * @see #getDensity()
	 * @generated
	 */
	EAttribute getDensity_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Density#getGeometryInfoId <em>Geometry Info Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Geometry Info Id</em>'.
	 * @see org.bimserver.models.store.Density#getGeometryInfoId()
	 * @see #getDensity()
	 * @generated
	 */
	EAttribute getDensity_GeometryInfoId();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Density#getTrianglesBelow <em>Triangles Below</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Triangles Below</em>'.
	 * @see org.bimserver.models.store.Density#getTrianglesBelow()
	 * @see #getDensity()
	 * @generated
	 */
	EAttribute getDensity_TrianglesBelow();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Density#getTrianglesAbove <em>Triangles Above</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Triangles Above</em>'.
	 * @see org.bimserver.models.store.Density#getTrianglesAbove()
	 * @see #getDensity()
	 * @generated
	 */
	EAttribute getDensity_TrianglesAbove();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Density#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volume</em>'.
	 * @see org.bimserver.models.store.Density#getVolume()
	 * @see #getDensity()
	 * @generated
	 */
	EAttribute getDensity_Volume();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Density#getDensity <em>Density</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Density</em>'.
	 * @see org.bimserver.models.store.Density#getDensity()
	 * @see #getDensity()
	 * @generated
	 */
	EAttribute getDensity_Density();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.LongCheckinActionState <em>Long Checkin Action State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Checkin Action State</em>'.
	 * @see org.bimserver.models.store.LongCheckinActionState
	 * @generated
	 */
	EClass getLongCheckinActionState();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongCheckinActionState#getRoid <em>Roid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Roid</em>'.
	 * @see org.bimserver.models.store.LongCheckinActionState#getRoid()
	 * @see #getLongCheckinActionState()
	 * @generated
	 */
	EAttribute getLongCheckinActionState_Roid();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.LongCheckinActionState#getDeserializeErrorCode <em>Deserialize Error Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deserialize Error Code</em>'.
	 * @see org.bimserver.models.store.LongCheckinActionState#getDeserializeErrorCode()
	 * @see #getLongCheckinActionState()
	 * @generated
	 */
	EAttribute getLongCheckinActionState_DeserializeErrorCode();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.store.Tile <em>Tile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tile</em>'.
	 * @see org.bimserver.models.store.Tile
	 * @generated
	 */
	EClass getTile();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Tile#getTileId <em>Tile Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tile Id</em>'.
	 * @see org.bimserver.models.store.Tile#getTileId()
	 * @see #getTile()
	 * @generated
	 */
	EAttribute getTile_TileId();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.store.Tile#getNrObjects <em>Nr Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nr Objects</em>'.
	 * @see org.bimserver.models.store.Tile#getNrObjects()
	 * @see #getTile()
	 * @generated
	 */
	EAttribute getTile_NrObjects();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Tile#getMinBounds <em>Min Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min Bounds</em>'.
	 * @see org.bimserver.models.store.Tile#getMinBounds()
	 * @see #getTile()
	 * @generated
	 */
	EReference getTile_MinBounds();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.store.Tile#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bounds</em>'.
	 * @see org.bimserver.models.store.Tile#getBounds()
	 * @see #getTile()
	 * @generated
	 */
	EReference getTile_Bounds();

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
	 * Returns the meta object for enum '{@link org.bimserver.models.store.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Trigger</em>'.
	 * @see org.bimserver.models.store.Trigger
	 * @generated
	 */
	EEnum getTrigger();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.ServiceSimpleType <em>Service Simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Simple Type</em>'.
	 * @see org.bimserver.models.store.ServiceSimpleType
	 * @generated
	 */
	EEnum getServiceSimpleType();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.PrimitiveEnum <em>Primitive Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Enum</em>'.
	 * @see org.bimserver.models.store.PrimitiveEnum
	 * @generated
	 */
	EEnum getPrimitiveEnum();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.NotifictionResultEnum <em>Notifiction Result Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Notifiction Result Enum</em>'.
	 * @see org.bimserver.models.store.NotifictionResultEnum
	 * @generated
	 */
	EEnum getNotifictionResultEnum();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.ProgressTopicType <em>Progress Topic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Progress Topic Type</em>'.
	 * @see org.bimserver.models.store.ProgressTopicType
	 * @generated
	 */
	EEnum getProgressTopicType();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.ModelCheckerResultType <em>Model Checker Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Model Checker Result Type</em>'.
	 * @see org.bimserver.models.store.ModelCheckerResultType
	 * @generated
	 */
	EEnum getModelCheckerResultType();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.SmtpProtocol <em>Smtp Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Smtp Protocol</em>'.
	 * @see org.bimserver.models.store.SmtpProtocol
	 * @generated
	 */
	EEnum getSmtpProtocol();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.PluginBundleType <em>Plugin Bundle Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Plugin Bundle Type</em>'.
	 * @see org.bimserver.models.store.PluginBundleType
	 * @generated
	 */
	EEnum getPluginBundleType();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.PluginType <em>Plugin Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Plugin Type</em>'.
	 * @see org.bimserver.models.store.PluginType
	 * @generated
	 */
	EEnum getPluginType();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.store.ServiceStatus <em>Service Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Status</em>'.
	 * @see org.bimserver.models.store.ServiceStatus
	 * @generated
	 */
	EEnum getServiceStatus();

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
		 * The meta object literal for the '<em><b>Export Length Measure Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__EXPORT_LENGTH_MEASURE_PREFIX = eINSTANCE.getProject_ExportLengthMeasurePrefix();

		/**
		 * The meta object literal for the '<em><b>Extended Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__EXTENDED_DATA = eINSTANCE.getProject_ExtendedData();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__SERVICES = eINSTANCE.getProject_Services();

		/**
		 * The meta object literal for the '<em><b>Logs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__LOGS = eINSTANCE.getProject_Logs();

		/**
		 * The meta object literal for the '<em><b>Model Checkers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__MODEL_CHECKERS = eINSTANCE.getProject_ModelCheckers();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__SCHEMA = eINSTANCE.getProject_Schema();

		/**
		 * The meta object literal for the '<em><b>Send Email On New Revision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__SEND_EMAIL_ON_NEW_REVISION = eINSTANCE.getProject_SendEmailOnNewRevision();

		/**
		 * The meta object literal for the '<em><b>New Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__NEW_SERVICES = eINSTANCE.getProject_NewServices();

		/**
		 * The meta object literal for the '<em><b>Checkin In Progress</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__CHECKIN_IN_PROGRESS = eINSTANCE.getProject_CheckinInProgress();

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
		 * The meta object literal for the '<em><b>Password Hash</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__PASSWORD_HASH = eINSTANCE.getUser_PasswordHash();

		/**
		 * The meta object literal for the '<em><b>Password Salt</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__PASSWORD_SALT = eINSTANCE.getUser_PasswordSalt();

		/**
		 * The meta object literal for the '<em><b>Has Rights On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__HAS_RIGHTS_ON = eINSTANCE.getUser_HasRightsOn();

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
		 * The meta object literal for the '<em><b>Token</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__TOKEN = eINSTANCE.getUser_Token();

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
		 * The meta object literal for the '<em><b>User Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__USER_SETTINGS = eINSTANCE.getUser_UserSettings();

		/**
		 * The meta object literal for the '<em><b>Schemas</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__SCHEMAS = eINSTANCE.getUser_Schemas();

		/**
		 * The meta object literal for the '<em><b>Extended Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__EXTENDED_DATA = eINSTANCE.getUser_ExtendedData();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__SERVICES = eINSTANCE.getUser_Services();

		/**
		 * The meta object literal for the '<em><b>Logs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__LOGS = eINSTANCE.getUser_Logs();

		/**
		 * The meta object literal for the '<em><b>OAuth Authorization Codes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__OAUTH_AUTHORIZATION_CODES = eINSTANCE.getUser_OAuthAuthorizationCodes();

		/**
		 * The meta object literal for the '<em><b>OAuth Issued Authorization Codes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__OAUTH_ISSUED_AUTHORIZATION_CODES = eINSTANCE.getUser_OAuthIssuedAuthorizationCodes();

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
		 * The meta object literal for the '<em><b>Extended Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__EXTENDED_DATA = eINSTANCE.getRevision_ExtendedData();

		/**
		 * The meta object literal for the '<em><b>Logs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__LOGS = eINSTANCE.getRevision_Logs();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__SERVICE = eINSTANCE.getRevision_Service();

		/**
		 * The meta object literal for the '<em><b>Has Geometry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__HAS_GEOMETRY = eINSTANCE.getRevision_HasGeometry();

		/**
		 * The meta object literal for the '<em><b>Bounds</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__BOUNDS = eINSTANCE.getRevision_Bounds();

		/**
		 * The meta object literal for the '<em><b>Bounds Untransformed</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__BOUNDS_UNTRANSFORMED = eINSTANCE.getRevision_BoundsUntransformed();

		/**
		 * The meta object literal for the '<em><b>Bounds Mm</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__BOUNDS_MM = eINSTANCE.getRevision_BoundsMm();

		/**
		 * The meta object literal for the '<em><b>Bounds Untransformed Mm</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__BOUNDS_UNTRANSFORMED_MM = eINSTANCE.getRevision_BoundsUntransformedMm();

		/**
		 * The meta object literal for the '<em><b>Services Linked</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__SERVICES_LINKED = eINSTANCE.getRevision_ServicesLinked();

		/**
		 * The meta object literal for the '<em><b>Density Collection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__DENSITY_COLLECTION = eINSTANCE.getRevision_DensityCollection();

		/**
		 * The meta object literal for the '<em><b>Nr Primitives</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__NR_PRIMITIVES = eINSTANCE.getRevision_NrPrimitives();

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
		 * The meta object literal for the '<em><b>Clear</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_REVISION__CLEAR = eINSTANCE.getConcreteRevision_Clear();

		/**
		 * The meta object literal for the '<em><b>Summary</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_REVISION__SUMMARY = eINSTANCE.getConcreteRevision_Summary();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_REVISION__USER = eINSTANCE.getConcreteRevision_User();

		/**
		 * The meta object literal for the '<em><b>Ifc Header</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_REVISION__IFC_HEADER = eINSTANCE.getConcreteRevision_IfcHeader();

		/**
		 * The meta object literal for the '<em><b>Bounds</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_REVISION__BOUNDS = eINSTANCE.getConcreteRevision_Bounds();

		/**
		 * The meta object literal for the '<em><b>Bounds Untransformed</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_REVISION__BOUNDS_UNTRANSFORMED = eINSTANCE.getConcreteRevision_BoundsUntransformed();

		/**
		 * The meta object literal for the '<em><b>Oid Counters</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_REVISION__OID_COUNTERS = eINSTANCE.getConcreteRevision_OidCounters();

		/**
		 * The meta object literal for the '<em><b>Multiplier To Mm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_REVISION__MULTIPLIER_TO_MM = eINSTANCE.getConcreteRevision_MultiplierToMm();

		/**
		 * The meta object literal for the '<em><b>Density Collection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_REVISION__DENSITY_COLLECTION = eINSTANCE.getConcreteRevision_DensityCollection();

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
		 * The meta object literal for the '<em><b>Logs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECKOUT__LOGS = eINSTANCE.getCheckout_Logs();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ServerSettingsImpl <em>Server Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ServerSettingsImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getServerSettings()
		 * @generated
		 */
		EClass SERVER_SETTINGS = eINSTANCE.getServerSettings();

		/**
		 * The meta object literal for the '<em><b>Send Confirmation Email After Registration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__SEND_CONFIRMATION_EMAIL_AFTER_REGISTRATION = eINSTANCE.getServerSettings_SendConfirmationEmailAfterRegistration();

		/**
		 * The meta object literal for the '<em><b>Allow Self Registration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__ALLOW_SELF_REGISTRATION = eINSTANCE.getServerSettings_AllowSelfRegistration();

		/**
		 * The meta object literal for the '<em><b>Allow Users To Create Top Level Projects</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__ALLOW_USERS_TO_CREATE_TOP_LEVEL_PROJECTS = eINSTANCE.getServerSettings_AllowUsersToCreateTopLevelProjects();

		/**
		 * The meta object literal for the '<em><b>Checkin Merging Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__CHECKIN_MERGING_ENABLED = eINSTANCE.getServerSettings_CheckinMergingEnabled();

		/**
		 * The meta object literal for the '<em><b>Smtp Server</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__SMTP_SERVER = eINSTANCE.getServerSettings_SmtpServer();

		/**
		 * The meta object literal for the '<em><b>Email Sender Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__EMAIL_SENDER_ADDRESS = eINSTANCE.getServerSettings_EmailSenderAddress();

		/**
		 * The meta object literal for the '<em><b>Email Sender Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__EMAIL_SENDER_NAME = eINSTANCE.getServerSettings_EmailSenderName();

		/**
		 * The meta object literal for the '<em><b>Site Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__SITE_ADDRESS = eINSTANCE.getServerSettings_SiteAddress();

		/**
		 * The meta object literal for the '<em><b>Generate Geometry On Checkin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__GENERATE_GEOMETRY_ON_CHECKIN = eINSTANCE.getServerSettings_GenerateGeometryOnCheckin();

		/**
		 * The meta object literal for the '<em><b>Allow Only Whitelisted</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__ALLOW_ONLY_WHITELISTED = eINSTANCE.getServerSettings_AllowOnlyWhitelisted();

		/**
		 * The meta object literal for the '<em><b>Whitelisted Domains</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__WHITELISTED_DOMAINS = eINSTANCE.getServerSettings_WhitelistedDomains();

		/**
		 * The meta object literal for the '<em><b>Hide User List For Non Admin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__HIDE_USER_LIST_FOR_NON_ADMIN = eINSTANCE.getServerSettings_HideUserListForNonAdmin();

		/**
		 * The meta object literal for the '<em><b>Protocol Buffers Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__PROTOCOL_BUFFERS_PORT = eINSTANCE.getServerSettings_ProtocolBuffersPort();

		/**
		 * The meta object literal for the '<em><b>Cache Output Files</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__CACHE_OUTPUT_FILES = eINSTANCE.getServerSettings_CacheOutputFiles();

		/**
		 * The meta object literal for the '<em><b>Web Modules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_SETTINGS__WEB_MODULES = eINSTANCE.getServerSettings_WebModules();

		/**
		 * The meta object literal for the '<em><b>Web Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_SETTINGS__WEB_MODULE = eINSTANCE.getServerSettings_WebModule();

		/**
		 * The meta object literal for the '<em><b>Service Repository Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__SERVICE_REPOSITORY_URL = eINSTANCE.getServerSettings_ServiceRepositoryUrl();

		/**
		 * The meta object literal for the '<em><b>Send Email On New Revision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__SEND_EMAIL_ON_NEW_REVISION = eINSTANCE.getServerSettings_SendEmailOnNewRevision();

		/**
		 * The meta object literal for the '<em><b>Session Time Out Seconds</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__SESSION_TIME_OUT_SECONDS = eINSTANCE.getServerSettings_SessionTimeOutSeconds();

		/**
		 * The meta object literal for the '<em><b>Smtp Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__SMTP_USERNAME = eINSTANCE.getServerSettings_SmtpUsername();

		/**
		 * The meta object literal for the '<em><b>Smtp Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__SMTP_PASSWORD = eINSTANCE.getServerSettings_SmtpPassword();

		/**
		 * The meta object literal for the '<em><b>Smtp Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__SMTP_PORT = eINSTANCE.getServerSettings_SmtpPort();

		/**
		 * The meta object literal for the '<em><b>Smtp Protocol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__SMTP_PROTOCOL = eINSTANCE.getServerSettings_SmtpProtocol();

		/**
		 * The meta object literal for the '<em><b>Reuse Geometry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__REUSE_GEOMETRY = eINSTANCE.getServerSettings_ReuseGeometry();

		/**
		 * The meta object literal for the '<em><b>Allow Create Validated User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__ALLOW_CREATE_VALIDATED_USER = eINSTANCE.getServerSettings_AllowCreateValidatedUser();

		/**
		 * The meta object literal for the '<em><b>Render Engine Processes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__RENDER_ENGINE_PROCESSES = eINSTANCE.getServerSettings_RenderEngineProcesses();

		/**
		 * The meta object literal for the '<em><b>Plugin Strict Version Checking</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__PLUGIN_STRICT_VERSION_CHECKING = eINSTANCE.getServerSettings_PluginStrictVersionChecking();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__NAME = eINSTANCE.getServerSettings_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__DESCRIPTION = eINSTANCE.getServerSettings_Description();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__ICON = eINSTANCE.getServerSettings_Icon();

		/**
		 * The meta object literal for the '<em><b>Store Last Login</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__STORE_LAST_LOGIN = eINSTANCE.getServerSettings_StoreLastLogin();

		/**
		 * The meta object literal for the '<em><b>Store Service Runs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__STORE_SERVICE_RUNS = eINSTANCE.getServerSettings_StoreServiceRuns();

		/**
		 * The meta object literal for the '<em><b>Optimize Mapped Items</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_SETTINGS__OPTIMIZE_MAPPED_ITEMS = eINSTANCE.getServerSettings_OptimizeMappedItems();

		/**
		 * The meta object literal for the '<em><b>Default Render Engine Plugin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_SETTINGS__DEFAULT_RENDER_ENGINE_PLUGIN = eINSTANCE.getServerSettings_DefaultRenderEnginePlugin();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.UserSettingsImpl <em>User Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.UserSettingsImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getUserSettings()
		 * @generated
		 */
		EClass USER_SETTINGS = eINSTANCE.getUserSettings();

		/**
		 * The meta object literal for the '<em><b>Serializers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__SERIALIZERS = eINSTANCE.getUserSettings_Serializers();

		/**
		 * The meta object literal for the '<em><b>Object ID Ms</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__OBJECT_ID_MS = eINSTANCE.getUserSettings_ObjectIDMs();

		/**
		 * The meta object literal for the '<em><b>Render Engines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__RENDER_ENGINES = eINSTANCE.getUserSettings_RenderEngines();

		/**
		 * The meta object literal for the '<em><b>Deserializers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__DESERIALIZERS = eINSTANCE.getUserSettings_Deserializers();

		/**
		 * The meta object literal for the '<em><b>Query Engines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__QUERY_ENGINES = eINSTANCE.getUserSettings_QueryEngines();

		/**
		 * The meta object literal for the '<em><b>Model Mergers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__MODEL_MERGERS = eINSTANCE.getUserSettings_ModelMergers();

		/**
		 * The meta object literal for the '<em><b>Model Compares</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__MODEL_COMPARES = eINSTANCE.getUserSettings_ModelCompares();

		/**
		 * The meta object literal for the '<em><b>Default Model Merger</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__DEFAULT_MODEL_MERGER = eINSTANCE.getUserSettings_DefaultModelMerger();

		/**
		 * The meta object literal for the '<em><b>Default Model Compare</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__DEFAULT_MODEL_COMPARE = eINSTANCE.getUserSettings_DefaultModelCompare();

		/**
		 * The meta object literal for the '<em><b>Default Query Engine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__DEFAULT_QUERY_ENGINE = eINSTANCE.getUserSettings_DefaultQueryEngine();

		/**
		 * The meta object literal for the '<em><b>Default Render Engine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__DEFAULT_RENDER_ENGINE = eINSTANCE.getUserSettings_DefaultRenderEngine();

		/**
		 * The meta object literal for the '<em><b>Default Serializer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__DEFAULT_SERIALIZER = eINSTANCE.getUserSettings_DefaultSerializer();

		/**
		 * The meta object literal for the '<em><b>Default Object IDM</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__DEFAULT_OBJECT_IDM = eINSTANCE.getUserSettings_DefaultObjectIDM();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_SETTINGS__SERVICES = eINSTANCE.getUserSettings_Services();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.PluginConfigurationImpl <em>Plugin Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.PluginConfigurationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginConfiguration()
		 * @generated
		 */
		EClass PLUGIN_CONFIGURATION = eINSTANCE.getPluginConfiguration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_CONFIGURATION__NAME = eINSTANCE.getPluginConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_CONFIGURATION__ENABLED = eINSTANCE.getPluginConfiguration_Enabled();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_CONFIGURATION__DESCRIPTION = eINSTANCE.getPluginConfiguration_Description();

		/**
		 * The meta object literal for the '<em><b>Plugin Descriptor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUGIN_CONFIGURATION__PLUGIN_DESCRIPTOR = eINSTANCE.getPluginConfiguration_PluginDescriptor();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUGIN_CONFIGURATION__SETTINGS = eINSTANCE.getPluginConfiguration_Settings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.SerializerPluginConfigurationImpl <em>Serializer Plugin Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.SerializerPluginConfigurationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getSerializerPluginConfiguration()
		 * @generated
		 */
		EClass SERIALIZER_PLUGIN_CONFIGURATION = eINSTANCE.getSerializerPluginConfiguration();

		/**
		 * The meta object literal for the '<em><b>Object IDM</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERIALIZER_PLUGIN_CONFIGURATION__OBJECT_IDM = eINSTANCE.getSerializerPluginConfiguration_ObjectIDM();

		/**
		 * The meta object literal for the '<em><b>User Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERIALIZER_PLUGIN_CONFIGURATION__USER_SETTINGS = eINSTANCE.getSerializerPluginConfiguration_UserSettings();

		/**
		 * The meta object literal for the '<em><b>Render Engine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERIALIZER_PLUGIN_CONFIGURATION__RENDER_ENGINE = eINSTANCE.getSerializerPluginConfiguration_RenderEngine();

		/**
		 * The meta object literal for the '<em><b>Streaming</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZER_PLUGIN_CONFIGURATION__STREAMING = eINSTANCE.getSerializerPluginConfiguration_Streaming();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ObjectIDMPluginConfigurationImpl <em>Object IDM Plugin Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ObjectIDMPluginConfigurationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectIDMPluginConfiguration()
		 * @generated
		 */
		EClass OBJECT_IDM_PLUGIN_CONFIGURATION = eINSTANCE.getObjectIDMPluginConfiguration();

		/**
		 * The meta object literal for the '<em><b>Serializers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_IDM_PLUGIN_CONFIGURATION__SERIALIZERS = eINSTANCE.getObjectIDMPluginConfiguration_Serializers();

		/**
		 * The meta object literal for the '<em><b>User Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_IDM_PLUGIN_CONFIGURATION__USER_SETTINGS = eINSTANCE.getObjectIDMPluginConfiguration_UserSettings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.RenderEnginePluginConfigurationImpl <em>Render Engine Plugin Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.RenderEnginePluginConfigurationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getRenderEnginePluginConfiguration()
		 * @generated
		 */
		EClass RENDER_ENGINE_PLUGIN_CONFIGURATION = eINSTANCE.getRenderEnginePluginConfiguration();

		/**
		 * The meta object literal for the '<em><b>Serializers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENDER_ENGINE_PLUGIN_CONFIGURATION__SERIALIZERS = eINSTANCE.getRenderEnginePluginConfiguration_Serializers();

		/**
		 * The meta object literal for the '<em><b>User Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENDER_ENGINE_PLUGIN_CONFIGURATION__USER_SETTINGS = eINSTANCE.getRenderEnginePluginConfiguration_UserSettings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.DeserializerPluginConfigurationImpl <em>Deserializer Plugin Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.DeserializerPluginConfigurationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDeserializerPluginConfiguration()
		 * @generated
		 */
		EClass DESERIALIZER_PLUGIN_CONFIGURATION = eINSTANCE.getDeserializerPluginConfiguration();

		/**
		 * The meta object literal for the '<em><b>User Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESERIALIZER_PLUGIN_CONFIGURATION__USER_SETTINGS = eINSTANCE.getDeserializerPluginConfiguration_UserSettings();

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
		 * The meta object literal for the '<em><b>Serializer Oid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOWNLOAD_RESULT__SERIALIZER_OID = eINSTANCE.getDownloadResult_SerializerOid();

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
		 * The meta object literal for the '<em><b>Plugin Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_DESCRIPTOR__PLUGIN_CLASS_NAME = eINSTANCE.getPluginDescriptor_PluginClassName();

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
		 * The meta object literal for the '<em><b>Plugin Interface Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_DESCRIPTOR__PLUGIN_INTERFACE_CLASS_NAME = eINSTANCE.getPluginDescriptor_PluginInterfaceClassName();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUGIN_DESCRIPTOR__CONFIGURATIONS = eINSTANCE.getPluginDescriptor_Configurations();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_DESCRIPTOR__IDENTIFIER = eINSTANCE.getPluginDescriptor_Identifier();

		/**
		 * The meta object literal for the '<em><b>Install For New Users</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_DESCRIPTOR__INSTALL_FOR_NEW_USERS = eINSTANCE.getPluginDescriptor_InstallForNewUsers();

		/**
		 * The meta object literal for the '<em><b>Plugin Bundle Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUGIN_DESCRIPTOR__PLUGIN_BUNDLE_VERSION = eINSTANCE.getPluginDescriptor_PluginBundleVersion();

		/**
		 * The meta object literal for the '<em><b>Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUGIN_DESCRIPTOR__SETTINGS = eINSTANCE.getPluginDescriptor_Settings();

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
		 * The meta object literal for the '<em><b>Schema</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION_SUMMARY_TYPE__SCHEMA = eINSTANCE.getRevisionSummaryType_Schema();

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
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION_STATE__START = eINSTANCE.getLongActionState_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION_STATE__END = eINSTANCE.getLongActionState_End();

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
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION_STATE__TITLE = eINSTANCE.getLongActionState_Title();

		/**
		 * The meta object literal for the '<em><b>Stage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION_STATE__STAGE = eINSTANCE.getLongActionState_Stage();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION_STATE__ERRORS = eINSTANCE.getLongActionState_Errors();

		/**
		 * The meta object literal for the '<em><b>Warnings</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION_STATE__WARNINGS = eINSTANCE.getLongActionState_Warnings();

		/**
		 * The meta object literal for the '<em><b>Infos</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION_STATE__INFOS = eINSTANCE.getLongActionState_Infos();

		/**
		 * The meta object literal for the '<em><b>Topic Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_ACTION_STATE__TOPIC_ID = eINSTANCE.getLongActionState_TopicId();

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
		 * The meta object literal for the '<em><b>Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_INFO__VERSION = eINSTANCE.getServerInfo_Version();

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
		 * The meta object literal for the '<em><b>Full String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__FULL_STRING = eINSTANCE.getVersion_FullString();

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
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.FileImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__DATA = eINSTANCE.getFile_Data();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__FILENAME = eINSTANCE.getFile_Filename();

		/**
		 * The meta object literal for the '<em><b>Mime</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__MIME = eINSTANCE.getFile_Mime();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__SIZE = eINSTANCE.getFile_Size();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ExtendedDataSchemaImpl <em>Extended Data Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ExtendedDataSchemaImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getExtendedDataSchema()
		 * @generated
		 */
		EClass EXTENDED_DATA_SCHEMA = eINSTANCE.getExtendedDataSchema();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_DATA_SCHEMA__NAME = eINSTANCE.getExtendedDataSchema_Name();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_DATA_SCHEMA__URL = eINSTANCE.getExtendedDataSchema_Url();

		/**
		 * The meta object literal for the '<em><b>Content Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_DATA_SCHEMA__CONTENT_TYPE = eINSTANCE.getExtendedDataSchema_ContentType();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_DATA_SCHEMA__DESCRIPTION = eINSTANCE.getExtendedDataSchema_Description();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_DATA_SCHEMA__FILE = eINSTANCE.getExtendedDataSchema_File();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_DATA_SCHEMA__SIZE = eINSTANCE.getExtendedDataSchema_Size();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_DATA_SCHEMA__USERS = eINSTANCE.getExtendedDataSchema_Users();

		/**
		 * The meta object literal for the '<em><b>Extended Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_DATA_SCHEMA__EXTENDED_DATA = eINSTANCE.getExtendedDataSchema_ExtendedData();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ExtendedDataImpl <em>Extended Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ExtendedDataImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getExtendedData()
		 * @generated
		 */
		EClass EXTENDED_DATA = eINSTANCE.getExtendedData();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_DATA__URL = eINSTANCE.getExtendedData_Url();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_DATA__FILE = eINSTANCE.getExtendedData_File();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_DATA__SIZE = eINSTANCE.getExtendedData_Size();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_DATA__TITLE = eINSTANCE.getExtendedData_Title();

		/**
		 * The meta object literal for the '<em><b>Added</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_DATA__ADDED = eINSTANCE.getExtendedData_Added();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_DATA__USER = eINSTANCE.getExtendedData_User();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_DATA__SCHEMA = eINSTANCE.getExtendedData_Schema();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_DATA__REVISION = eINSTANCE.getExtendedData_Revision();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_DATA__PROJECT = eINSTANCE.getExtendedData_Project();

		/**
		 * The meta object literal for the '<em><b>Time To Generate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_DATA__TIME_TO_GENERATE = eINSTANCE.getExtendedData_TimeToGenerate();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.QueryEnginePluginConfigurationImpl <em>Query Engine Plugin Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.QueryEnginePluginConfigurationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getQueryEnginePluginConfiguration()
		 * @generated
		 */
		EClass QUERY_ENGINE_PLUGIN_CONFIGURATION = eINSTANCE.getQueryEnginePluginConfiguration();

		/**
		 * The meta object literal for the '<em><b>User Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_ENGINE_PLUGIN_CONFIGURATION__USER_SETTINGS = eINSTANCE.getQueryEnginePluginConfiguration_UserSettings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.WebModulePluginConfigurationImpl <em>Web Module Plugin Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.WebModulePluginConfigurationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getWebModulePluginConfiguration()
		 * @generated
		 */
		EClass WEB_MODULE_PLUGIN_CONFIGURATION = eINSTANCE.getWebModulePluginConfiguration();

		/**
		 * The meta object literal for the '<em><b>Server Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WEB_MODULE_PLUGIN_CONFIGURATION__SERVER_SETTINGS = eINSTANCE.getWebModulePluginConfiguration_ServerSettings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ModelMergerPluginConfigurationImpl <em>Model Merger Plugin Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ModelMergerPluginConfigurationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelMergerPluginConfiguration()
		 * @generated
		 */
		EClass MODEL_MERGER_PLUGIN_CONFIGURATION = eINSTANCE.getModelMergerPluginConfiguration();

		/**
		 * The meta object literal for the '<em><b>User Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_MERGER_PLUGIN_CONFIGURATION__USER_SETTINGS = eINSTANCE.getModelMergerPluginConfiguration_UserSettings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ModelComparePluginConfigurationImpl <em>Model Compare Plugin Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ModelComparePluginConfigurationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelComparePluginConfiguration()
		 * @generated
		 */
		EClass MODEL_COMPARE_PLUGIN_CONFIGURATION = eINSTANCE.getModelComparePluginConfiguration();

		/**
		 * The meta object literal for the '<em><b>User Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_COMPARE_PLUGIN_CONFIGURATION__USER_SETTINGS = eINSTANCE.getModelComparePluginConfiguration_UserSettings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ProfileDescriptorImpl <em>Profile Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ProfileDescriptorImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getProfileDescriptor()
		 * @generated
		 */
		EClass PROFILE_DESCRIPTOR = eINSTANCE.getProfileDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_DESCRIPTOR__NAME = eINSTANCE.getProfileDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_DESCRIPTOR__DESCRIPTION = eINSTANCE.getProfileDescriptor_Description();

		/**
		 * The meta object literal for the '<em><b>Public Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_DESCRIPTOR__PUBLIC_PROFILE = eINSTANCE.getProfileDescriptor_PublicProfile();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE_DESCRIPTOR__IDENTIFIER = eINSTANCE.getProfileDescriptor_Identifier();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ServiceDescriptorImpl <em>Service Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ServiceDescriptorImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceDescriptor()
		 * @generated
		 */
		EClass SERVICE_DESCRIPTOR = eINSTANCE.getServiceDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__NAME = eINSTANCE.getServiceDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__URL = eINSTANCE.getServiceDescriptor_Url();

		/**
		 * The meta object literal for the '<em><b>Token</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__TOKEN = eINSTANCE.getServiceDescriptor_Token();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__IDENTIFIER = eINSTANCE.getServiceDescriptor_Identifier();

		/**
		 * The meta object literal for the '<em><b>Notification Protocol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__NOTIFICATION_PROTOCOL = eINSTANCE.getServiceDescriptor_NotificationProtocol();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__DESCRIPTION = eINSTANCE.getServiceDescriptor_Description();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__TRIGGER = eINSTANCE.getServiceDescriptor_Trigger();

		/**
		 * The meta object literal for the '<em><b>Read Revision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__READ_REVISION = eINSTANCE.getServiceDescriptor_ReadRevision();

		/**
		 * The meta object literal for the '<em><b>Read Extended Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__READ_EXTENDED_DATA = eINSTANCE.getServiceDescriptor_ReadExtendedData();

		/**
		 * The meta object literal for the '<em><b>Write Revision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__WRITE_REVISION = eINSTANCE.getServiceDescriptor_WriteRevision();

		/**
		 * The meta object literal for the '<em><b>Write Extended Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__WRITE_EXTENDED_DATA = eINSTANCE.getServiceDescriptor_WriteExtendedData();

		/**
		 * The meta object literal for the '<em><b>Provider Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__PROVIDER_NAME = eINSTANCE.getServiceDescriptor_ProviderName();

		/**
		 * The meta object literal for the '<em><b>Company Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__COMPANY_URL = eINSTANCE.getServiceDescriptor_CompanyUrl();

		/**
		 * The meta object literal for the '<em><b>Token Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__TOKEN_URL = eINSTANCE.getServiceDescriptor_TokenUrl();

		/**
		 * The meta object literal for the '<em><b>New Profile Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__NEW_PROFILE_URL = eINSTANCE.getServiceDescriptor_NewProfileUrl();

		/**
		 * The meta object literal for the '<em><b>Register Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__REGISTER_URL = eINSTANCE.getServiceDescriptor_RegisterUrl();

		/**
		 * The meta object literal for the '<em><b>Authorize Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DESCRIPTOR__AUTHORIZE_URL = eINSTANCE.getServiceDescriptor_AuthorizeUrl();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ServiceImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__NAME = eINSTANCE.getService_Name();

		/**
		 * The meta object literal for the '<em><b>Service Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__SERVICE_NAME = eINSTANCE.getService_ServiceName();

		/**
		 * The meta object literal for the '<em><b>Service Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__SERVICE_IDENTIFIER = eINSTANCE.getService_ServiceIdentifier();

		/**
		 * The meta object literal for the '<em><b>Provider Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__PROVIDER_NAME = eINSTANCE.getService_ProviderName();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__URL = eINSTANCE.getService_Url();

		/**
		 * The meta object literal for the '<em><b>Token</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__TOKEN = eINSTANCE.getService_Token();

		/**
		 * The meta object literal for the '<em><b>Notification Protocol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__NOTIFICATION_PROTOCOL = eINSTANCE.getService_NotificationProtocol();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__DESCRIPTION = eINSTANCE.getService_Description();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__TRIGGER = eINSTANCE.getService_Trigger();

		/**
		 * The meta object literal for the '<em><b>Read Revision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__READ_REVISION = eINSTANCE.getService_ReadRevision();

		/**
		 * The meta object literal for the '<em><b>Read Extended Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__READ_EXTENDED_DATA = eINSTANCE.getService_ReadExtendedData();

		/**
		 * The meta object literal for the '<em><b>Write Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__WRITE_REVISION = eINSTANCE.getService_WriteRevision();

		/**
		 * The meta object literal for the '<em><b>Write Extended Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__WRITE_EXTENDED_DATA = eINSTANCE.getService_WriteExtendedData();

		/**
		 * The meta object literal for the '<em><b>Profile Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__PROFILE_IDENTIFIER = eINSTANCE.getService_ProfileIdentifier();

		/**
		 * The meta object literal for the '<em><b>Profile Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__PROFILE_NAME = eINSTANCE.getService_ProfileName();

		/**
		 * The meta object literal for the '<em><b>Profile Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__PROFILE_DESCRIPTION = eINSTANCE.getService_ProfileDescription();

		/**
		 * The meta object literal for the '<em><b>Profile Public</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__PROFILE_PUBLIC = eINSTANCE.getService_ProfilePublic();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__PROJECT = eINSTANCE.getService_Project();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__USER = eINSTANCE.getService_User();

		/**
		 * The meta object literal for the '<em><b>Internal Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__INTERNAL_SERVICE = eINSTANCE.getService_InternalService();

		/**
		 * The meta object literal for the '<em><b>Model Checkers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__MODEL_CHECKERS = eINSTANCE.getService_ModelCheckers();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.TokenImpl <em>Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.TokenImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getToken()
		 * @generated
		 */
		EClass TOKEN = eINSTANCE.getToken();

		/**
		 * The meta object literal for the '<em><b>Token String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN__TOKEN_STRING = eINSTANCE.getToken_TokenString();

		/**
		 * The meta object literal for the '<em><b>Expires</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN__EXPIRES = eINSTANCE.getToken_Expires();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.InternalServicePluginConfigurationImpl <em>Internal Service Plugin Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.InternalServicePluginConfigurationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getInternalServicePluginConfiguration()
		 * @generated
		 */
		EClass INTERNAL_SERVICE_PLUGIN_CONFIGURATION = eINSTANCE.getInternalServicePluginConfiguration();

		/**
		 * The meta object literal for the '<em><b>Remote Accessible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_SERVICE_PLUGIN_CONFIGURATION__REMOTE_ACCESSIBLE = eINSTANCE.getInternalServicePluginConfiguration_RemoteAccessible();

		/**
		 * The meta object literal for the '<em><b>User Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_SERVICE_PLUGIN_CONFIGURATION__USER_SETTINGS = eINSTANCE.getInternalServicePluginConfiguration_UserSettings();

		/**
		 * The meta object literal for the '<em><b>Public Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_SERVICE_PLUGIN_CONFIGURATION__PUBLIC_PROFILE = eINSTANCE.getInternalServicePluginConfiguration_PublicProfile();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ServiceInterfaceImpl <em>Service Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ServiceInterfaceImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceInterface()
		 * @generated
		 */
		EClass SERVICE_INTERFACE = eINSTANCE.getServiceInterface();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_INTERFACE__NAME = eINSTANCE.getServiceInterface_Name();

		/**
		 * The meta object literal for the '<em><b>Name Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_INTERFACE__NAME_SPACE = eINSTANCE.getServiceInterface_NameSpace();

		/**
		 * The meta object literal for the '<em><b>Simple Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_INTERFACE__SIMPLE_NAME = eINSTANCE.getServiceInterface_SimpleName();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ServiceMethodImpl <em>Service Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ServiceMethodImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceMethod()
		 * @generated
		 */
		EClass SERVICE_METHOD = eINSTANCE.getServiceMethod();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_METHOD__NAME = eINSTANCE.getServiceMethod_Name();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_METHOD__DOC = eINSTANCE.getServiceMethod_Doc();

		/**
		 * The meta object literal for the '<em><b>Return Doc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_METHOD__RETURN_DOC = eINSTANCE.getServiceMethod_ReturnDoc();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ServiceFieldImpl <em>Service Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ServiceFieldImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceField()
		 * @generated
		 */
		EClass SERVICE_FIELD = eINSTANCE.getServiceField();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FIELD__NAME = eINSTANCE.getServiceField_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FIELD__TYPE = eINSTANCE.getServiceField_Type();

		/**
		 * The meta object literal for the '<em><b>Generic Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_FIELD__GENERIC_TYPE = eINSTANCE.getServiceField_GenericType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_FIELD__DOC = eINSTANCE.getServiceField_Doc();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ServiceTypeImpl <em>Service Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ServiceTypeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceType()
		 * @generated
		 */
		EClass SERVICE_TYPE = eINSTANCE.getServiceType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_TYPE__NAME = eINSTANCE.getServiceType_Name();

		/**
		 * The meta object literal for the '<em><b>Simple Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_TYPE__SIMPLE_NAME = eINSTANCE.getServiceType_SimpleName();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_TYPE__FIELDS = eINSTANCE.getServiceType_Fields();

		/**
		 * The meta object literal for the '<em><b>Simple Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_TYPE__SIMPLE_TYPE = eINSTANCE.getServiceType_SimpleType();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ServiceParameterImpl <em>Service Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ServiceParameterImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceParameter()
		 * @generated
		 */
		EClass SERVICE_PARAMETER = eINSTANCE.getServiceParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_PARAMETER__NAME = eINSTANCE.getServiceParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_PARAMETER__DOC = eINSTANCE.getServiceParameter_Doc();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_PARAMETER__TYPE = eINSTANCE.getServiceParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Generic Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_PARAMETER__GENERIC_TYPE = eINSTANCE.getServiceParameter_GenericType();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.TypeDefinitionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getTypeDefinition()
		 * @generated
		 */
		EClass TYPE_DEFINITION = eINSTANCE.getTypeDefinition();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ObjectDefinitionImpl <em>Object Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ObjectDefinitionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectDefinition()
		 * @generated
		 */
		EClass OBJECT_DEFINITION = eINSTANCE.getObjectDefinition();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_DEFINITION__PARAMETERS = eINSTANCE.getObjectDefinition_Parameters();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.PrimitiveDefinitionImpl <em>Primitive Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.PrimitiveDefinitionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getPrimitiveDefinition()
		 * @generated
		 */
		EClass PRIMITIVE_DEFINITION = eINSTANCE.getPrimitiveDefinition();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_DEFINITION__TYPE = eINSTANCE.getPrimitiveDefinition_Type();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ArrayDefinitionImpl <em>Array Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ArrayDefinitionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getArrayDefinition()
		 * @generated
		 */
		EClass ARRAY_DEFINITION = eINSTANCE.getArrayDefinition();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_DEFINITION__TYPE = eINSTANCE.getArrayDefinition_Type();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ParameterDefinitionImpl <em>Parameter Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ParameterDefinitionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getParameterDefinition()
		 * @generated
		 */
		EClass PARAMETER_DEFINITION = eINSTANCE.getParameterDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DEFINITION__NAME = eINSTANCE.getParameterDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DEFINITION__IDENTIFIER = eINSTANCE.getParameterDefinition_Identifier();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DEFINITION__REQUIRED = eINSTANCE.getParameterDefinition_Required();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DEFINITION__DESCRIPTION = eINSTANCE.getParameterDefinition_Description();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DEFINITION__TYPE = eINSTANCE.getParameterDefinition_Type();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DEFINITION__DEFAULT_VALUE = eINSTANCE.getParameterDefinition_DefaultValue();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.TypeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ObjectTypeImpl <em>Object Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ObjectTypeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getObjectType()
		 * @generated
		 */
		EClass OBJECT_TYPE = eINSTANCE.getObjectType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_TYPE__NAME = eINSTANCE.getObjectType_Name();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TYPE__PARAMETERS = eINSTANCE.getObjectType_Parameters();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.PrimitiveTypeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.LongTypeImpl <em>Long Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.LongTypeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getLongType()
		 * @generated
		 */
		EClass LONG_TYPE = eINSTANCE.getLongType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_TYPE__VALUE = eINSTANCE.getLongType_Value();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ByteArrayTypeImpl <em>Byte Array Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ByteArrayTypeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getByteArrayType()
		 * @generated
		 */
		EClass BYTE_ARRAY_TYPE = eINSTANCE.getByteArrayType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BYTE_ARRAY_TYPE__VALUE = eINSTANCE.getByteArrayType_Value();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.DoubleTypeImpl <em>Double Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.DoubleTypeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDoubleType()
		 * @generated
		 */
		EClass DOUBLE_TYPE = eINSTANCE.getDoubleType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_TYPE__VALUE = eINSTANCE.getDoubleType_Value();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.StringTypeImpl <em>String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.StringTypeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TYPE__VALUE = eINSTANCE.getStringType_Value();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.BooleanTypeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_TYPE__VALUE = eINSTANCE.getBooleanType_Value();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ArrayTypeImpl <em>Array Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ArrayTypeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getArrayType()
		 * @generated
		 */
		EClass ARRAY_TYPE = eINSTANCE.getArrayType();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_TYPE__VALUES = eINSTANCE.getArrayType_Values();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ParameterImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__IDENTIFIER = eINSTANCE.getParameter_Identifier();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__VALUE = eINSTANCE.getParameter_Value();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ImmediateNotificationResultImpl <em>Immediate Notification Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ImmediateNotificationResultImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getImmediateNotificationResult()
		 * @generated
		 */
		EClass IMMEDIATE_NOTIFICATION_RESULT = eINSTANCE.getImmediateNotificationResult();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMMEDIATE_NOTIFICATION_RESULT__RESULT = eINSTANCE.getImmediateNotificationResult_Result();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMMEDIATE_NOTIFICATION_RESULT__DESCRIPTION = eINSTANCE.getImmediateNotificationResult_Description();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.RemoteServiceUpdateImpl <em>Remote Service Update</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.RemoteServiceUpdateImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getRemoteServiceUpdate()
		 * @generated
		 */
		EClass REMOTE_SERVICE_UPDATE = eINSTANCE.getRemoteServiceUpdate();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.PercentageChangeImpl <em>Percentage Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.PercentageChangeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getPercentageChange()
		 * @generated
		 */
		EClass PERCENTAGE_CHANGE = eINSTANCE.getPercentageChange();

		/**
		 * The meta object literal for the '<em><b>Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERCENTAGE_CHANGE__PERCENTAGE = eINSTANCE.getPercentageChange_Percentage();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.SystemInfoImpl <em>System Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.SystemInfoImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getSystemInfo()
		 * @generated
		 */
		EClass SYSTEM_INFO = eINSTANCE.getSystemInfo();

		/**
		 * The meta object literal for the '<em><b>Cpucores</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_INFO__CPUCORES = eINSTANCE.getSystemInfo_Cpucores();

		/**
		 * The meta object literal for the '<em><b>Datetime</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_INFO__DATETIME = eINSTANCE.getSystemInfo_Datetime();

		/**
		 * The meta object literal for the '<em><b>Osname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_INFO__OSNAME = eINSTANCE.getSystemInfo_Osname();

		/**
		 * The meta object literal for the '<em><b>Osversion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_INFO__OSVERSION = eINSTANCE.getSystemInfo_Osversion();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_INFO__USER_NAME = eINSTANCE.getSystemInfo_UserName();

		/**
		 * The meta object literal for the '<em><b>User Home</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_INFO__USER_HOME = eINSTANCE.getSystemInfo_UserHome();

		/**
		 * The meta object literal for the '<em><b>User Dir</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_INFO__USER_DIR = eINSTANCE.getSystemInfo_UserDir();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.JavaInfoImpl <em>Java Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.JavaInfoImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getJavaInfo()
		 * @generated
		 */
		EClass JAVA_INFO = eINSTANCE.getJavaInfo();

		/**
		 * The meta object literal for the '<em><b>Heap Total</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__HEAP_TOTAL = eINSTANCE.getJavaInfo_HeapTotal();

		/**
		 * The meta object literal for the '<em><b>Heap Used</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__HEAP_USED = eINSTANCE.getJavaInfo_HeapUsed();

		/**
		 * The meta object literal for the '<em><b>Heap Free</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__HEAP_FREE = eINSTANCE.getJavaInfo_HeapFree();

		/**
		 * The meta object literal for the '<em><b>Heap Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__HEAP_MAX = eINSTANCE.getJavaInfo_HeapMax();

		/**
		 * The meta object literal for the '<em><b>Threads</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__THREADS = eINSTANCE.getJavaInfo_Threads();

		/**
		 * The meta object literal for the '<em><b>Java Home</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVA_HOME = eINSTANCE.getJavaInfo_JavaHome();

		/**
		 * The meta object literal for the '<em><b>Java Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVA_VERSION = eINSTANCE.getJavaInfo_JavaVersion();

		/**
		 * The meta object literal for the '<em><b>Java Vendor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVA_VENDOR = eINSTANCE.getJavaInfo_JavaVendor();

		/**
		 * The meta object literal for the '<em><b>Java Vendorurl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVA_VENDORURL = eINSTANCE.getJavaInfo_JavaVendorurl();

		/**
		 * The meta object literal for the '<em><b>Javavm Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVAVM_VERSION = eINSTANCE.getJavaInfo_JavavmVersion();

		/**
		 * The meta object literal for the '<em><b>Javavm Vendor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVAVM_VENDOR = eINSTANCE.getJavaInfo_JavavmVendor();

		/**
		 * The meta object literal for the '<em><b>Javavm Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVAVM_NAME = eINSTANCE.getJavaInfo_JavavmName();

		/**
		 * The meta object literal for the '<em><b>Javaspec Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVASPEC_VERSION = eINSTANCE.getJavaInfo_JavaspecVersion();

		/**
		 * The meta object literal for the '<em><b>Javaspec Vendor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVASPEC_VENDOR = eINSTANCE.getJavaInfo_JavaspecVendor();

		/**
		 * The meta object literal for the '<em><b>Javaspec Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVASPEC_NAME = eINSTANCE.getJavaInfo_JavaspecName();

		/**
		 * The meta object literal for the '<em><b>Java Class Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVA_CLASS_VERSION = eINSTANCE.getJavaInfo_JavaClassVersion();

		/**
		 * The meta object literal for the '<em><b>Java Classpath</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVA_CLASSPATH = eINSTANCE.getJavaInfo_JavaClasspath();

		/**
		 * The meta object literal for the '<em><b>Java Librarypath</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVA_LIBRARYPATH = eINSTANCE.getJavaInfo_JavaLibrarypath();

		/**
		 * The meta object literal for the '<em><b>Java Io Tmp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVA_IO_TMP = eINSTANCE.getJavaInfo_JavaIoTmp();

		/**
		 * The meta object literal for the '<em><b>Java Extdir</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVA_EXTDIR = eINSTANCE.getJavaInfo_JavaExtdir();

		/**
		 * The meta object literal for the '<em><b>Java File Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVA_FILE_SEPARATOR = eINSTANCE.getJavaInfo_JavaFileSeparator();

		/**
		 * The meta object literal for the '<em><b>Java Path Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVA_PATH_SEPARATOR = eINSTANCE.getJavaInfo_JavaPathSeparator();

		/**
		 * The meta object literal for the '<em><b>Java Line Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__JAVA_LINE_SEPARATOR = eINSTANCE.getJavaInfo_JavaLineSeparator();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.BimServerInfoImpl <em>Bim Server Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.BimServerInfoImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getBimServerInfo()
		 * @generated
		 */
		EClass BIM_SERVER_INFO = eINSTANCE.getBimServerInfo();

		/**
		 * The meta object literal for the '<em><b>Current Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIM_SERVER_INFO__CURRENT_VERSION = eINSTANCE.getBimServerInfo_CurrentVersion();

		/**
		 * The meta object literal for the '<em><b>Current Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIM_SERVER_INFO__CURRENT_DATE = eINSTANCE.getBimServerInfo_CurrentDate();

		/**
		 * The meta object literal for the '<em><b>Schema Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIM_SERVER_INFO__SCHEMA_VERSION = eINSTANCE.getBimServerInfo_SchemaVersion();

		/**
		 * The meta object literal for the '<em><b>Latest Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIM_SERVER_INFO__LATEST_DATE = eINSTANCE.getBimServerInfo_LatestDate();

		/**
		 * The meta object literal for the '<em><b>Latest Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIM_SERVER_INFO__LATEST_VERSION = eINSTANCE.getBimServerInfo_LatestVersion();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIM_SERVER_INFO__PROJECTS = eINSTANCE.getBimServerInfo_Projects();

		/**
		 * The meta object literal for the '<em><b>Revisions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIM_SERVER_INFO__REVISIONS = eINSTANCE.getBimServerInfo_Revisions();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIM_SERVER_INFO__USERS = eINSTANCE.getBimServerInfo_Users();

		/**
		 * The meta object literal for the '<em><b>Checkouts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIM_SERVER_INFO__CHECKOUTS = eINSTANCE.getBimServerInfo_Checkouts();

		/**
		 * The meta object literal for the '<em><b>Server Log Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIM_SERVER_INFO__SERVER_LOG_URL = eINSTANCE.getBimServerInfo_ServerLogUrl();

		/**
		 * The meta object literal for the '<em><b>Started</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BIM_SERVER_INFO__STARTED = eINSTANCE.getBimServerInfo_Started();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ProjectSmallImpl <em>Project Small</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ProjectSmallImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getProjectSmall()
		 * @generated
		 */
		EClass PROJECT_SMALL = eINSTANCE.getProjectSmall();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SMALL__NAME = eINSTANCE.getProjectSmall_Name();

		/**
		 * The meta object literal for the '<em><b>Parent Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SMALL__PARENT_ID = eINSTANCE.getProjectSmall_ParentId();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SMALL__STATE = eINSTANCE.getProjectSmall_State();

		/**
		 * The meta object literal for the '<em><b>Nr Revisions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SMALL__NR_REVISIONS = eINSTANCE.getProjectSmall_NrRevisions();

		/**
		 * The meta object literal for the '<em><b>Nr Sub Projects</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SMALL__NR_SUB_PROJECTS = eINSTANCE.getProjectSmall_NrSubProjects();

		/**
		 * The meta object literal for the '<em><b>Has Checkin Rights</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SMALL__HAS_CHECKIN_RIGHTS = eINSTANCE.getProjectSmall_HasCheckinRights();

		/**
		 * The meta object literal for the '<em><b>Last Revision Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SMALL__LAST_REVISION_ID = eINSTANCE.getProjectSmall_LastRevisionId();

		/**
		 * The meta object literal for the '<em><b>Schema</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SMALL__SCHEMA = eINSTANCE.getProjectSmall_Schema();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.IfcHeaderImpl <em>Ifc Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.IfcHeaderImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getIfcHeader()
		 * @generated
		 */
		EClass IFC_HEADER = eINSTANCE.getIfcHeader();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFC_HEADER__DESCRIPTION = eINSTANCE.getIfcHeader_Description();

		/**
		 * The meta object literal for the '<em><b>Implementation Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFC_HEADER__IMPLEMENTATION_LEVEL = eINSTANCE.getIfcHeader_ImplementationLevel();

		/**
		 * The meta object literal for the '<em><b>Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFC_HEADER__FILENAME = eINSTANCE.getIfcHeader_Filename();

		/**
		 * The meta object literal for the '<em><b>Time Stamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFC_HEADER__TIME_STAMP = eINSTANCE.getIfcHeader_TimeStamp();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFC_HEADER__AUTHOR = eINSTANCE.getIfcHeader_Author();

		/**
		 * The meta object literal for the '<em><b>Organization</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFC_HEADER__ORGANIZATION = eINSTANCE.getIfcHeader_Organization();

		/**
		 * The meta object literal for the '<em><b>Pre Processor Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFC_HEADER__PRE_PROCESSOR_VERSION = eINSTANCE.getIfcHeader_PreProcessorVersion();

		/**
		 * The meta object literal for the '<em><b>Originating System</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFC_HEADER__ORIGINATING_SYSTEM = eINSTANCE.getIfcHeader_OriginatingSystem();

		/**
		 * The meta object literal for the '<em><b>Ifc Schema Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFC_HEADER__IFC_SCHEMA_VERSION = eINSTANCE.getIfcHeader_IfcSchemaVersion();

		/**
		 * The meta object literal for the '<em><b>Authorization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IFC_HEADER__AUTHORIZATION = eINSTANCE.getIfcHeader_Authorization();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ModelCheckerResultItemImpl <em>Model Checker Result Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ModelCheckerResultItemImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelCheckerResultItem()
		 * @generated
		 */
		EClass MODEL_CHECKER_RESULT_ITEM = eINSTANCE.getModelCheckerResultItem();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ModelCheckerResultHeaderImpl <em>Model Checker Result Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ModelCheckerResultHeaderImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelCheckerResultHeader()
		 * @generated
		 */
		EClass MODEL_CHECKER_RESULT_HEADER = eINSTANCE.getModelCheckerResultHeader();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_RESULT_HEADER__TEXT = eINSTANCE.getModelCheckerResultHeader_Text();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ModelCheckerResultLineImpl <em>Model Checker Result Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ModelCheckerResultLineImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelCheckerResultLine()
		 * @generated
		 */
		EClass MODEL_CHECKER_RESULT_LINE = eINSTANCE.getModelCheckerResultLine();

		/**
		 * The meta object literal for the '<em><b>Field Or Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_RESULT_LINE__FIELD_OR_CLASS = eINSTANCE.getModelCheckerResultLine_FieldOrClass();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_RESULT_LINE__VALUE = eINSTANCE.getModelCheckerResultLine_Value();

		/**
		 * The meta object literal for the '<em><b>Should Be</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_RESULT_LINE__SHOULD_BE = eINSTANCE.getModelCheckerResultLine_ShouldBe();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_RESULT_LINE__TYPE = eINSTANCE.getModelCheckerResultLine_Type();

		/**
		 * The meta object literal for the '<em><b>Object Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_RESULT_LINE__OBJECT_ID = eINSTANCE.getModelCheckerResultLine_ObjectId();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ModelCheckerResultImpl <em>Model Checker Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ModelCheckerResultImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelCheckerResult()
		 * @generated
		 */
		EClass MODEL_CHECKER_RESULT = eINSTANCE.getModelCheckerResult();

		/**
		 * The meta object literal for the '<em><b>Valid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_RESULT__VALID = eINSTANCE.getModelCheckerResult_Valid();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CHECKER_RESULT__ITEMS = eINSTANCE.getModelCheckerResult_Items();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ModelCheckerInstanceImpl <em>Model Checker Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ModelCheckerInstanceImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelCheckerInstance()
		 * @generated
		 */
		EClass MODEL_CHECKER_INSTANCE = eINSTANCE.getModelCheckerInstance();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_INSTANCE__NAME = eINSTANCE.getModelCheckerInstance_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_INSTANCE__DESCRIPTION = eINSTANCE.getModelCheckerInstance_Description();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_INSTANCE__CODE = eINSTANCE.getModelCheckerInstance_Code();

		/**
		 * The meta object literal for the '<em><b>Compiled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_INSTANCE__COMPILED = eINSTANCE.getModelCheckerInstance_Compiled();

		/**
		 * The meta object literal for the '<em><b>Valid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_INSTANCE__VALID = eINSTANCE.getModelCheckerInstance_Valid();

		/**
		 * The meta object literal for the '<em><b>Model Checker Plugin Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHECKER_INSTANCE__MODEL_CHECKER_PLUGIN_CLASS_NAME = eINSTANCE.getModelCheckerInstance_ModelCheckerPluginClassName();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.MessagingSerializerPluginConfigurationImpl <em>Messaging Serializer Plugin Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.MessagingSerializerPluginConfigurationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getMessagingSerializerPluginConfiguration()
		 * @generated
		 */
		EClass MESSAGING_SERIALIZER_PLUGIN_CONFIGURATION = eINSTANCE.getMessagingSerializerPluginConfiguration();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.MetricsImpl <em>Metrics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.MetricsImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getMetrics()
		 * @generated
		 */
		EClass METRICS = eINSTANCE.getMetrics();

		/**
		 * The meta object literal for the '<em><b>Interfaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRICS__INTERFACES = eINSTANCE.getMetrics_Interfaces();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.InterfaceMetricImpl <em>Interface Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.InterfaceMetricImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getInterfaceMetric()
		 * @generated
		 */
		EClass INTERFACE_METRIC = eINSTANCE.getInterfaceMetric();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_METRIC__METHODS = eINSTANCE.getInterfaceMetric_Methods();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_METRIC__NAME = eINSTANCE.getInterfaceMetric_Name();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.MethodMetricImpl <em>Method Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.MethodMetricImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getMethodMetric()
		 * @generated
		 */
		EClass METHOD_METRIC = eINSTANCE.getMethodMetric();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_METRIC__NAME = eINSTANCE.getMethodMetric_Name();

		/**
		 * The meta object literal for the '<em><b>Nr Calls</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_METRIC__NR_CALLS = eINSTANCE.getMethodMetric_NrCalls();

		/**
		 * The meta object literal for the '<em><b>Last Call</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_METRIC__LAST_CALL = eINSTANCE.getMethodMetric_LastCall();

		/**
		 * The meta object literal for the '<em><b>Average Ms</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_METRIC__AVERAGE_MS = eINSTANCE.getMethodMetric_AverageMs();

		/**
		 * The meta object literal for the '<em><b>Shortest Ms</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_METRIC__SHORTEST_MS = eINSTANCE.getMethodMetric_ShortestMs();

		/**
		 * The meta object literal for the '<em><b>Longest Ms</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_METRIC__LONGEST_MS = eINSTANCE.getMethodMetric_LongestMs();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.PluginBundleVersionImpl <em>Plugin Bundle Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.PluginBundleVersionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginBundleVersion()
		 * @generated
		 */
		EClass PLUGIN_BUNDLE_VERSION = eINSTANCE.getPluginBundleVersion();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE_VERSION__VERSION = eINSTANCE.getPluginBundleVersion_Version();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE_VERSION__TYPE = eINSTANCE.getPluginBundleVersion_Type();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE_VERSION__DESCRIPTION = eINSTANCE.getPluginBundleVersion_Description();

		/**
		 * The meta object literal for the '<em><b>Mismatch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE_VERSION__MISMATCH = eINSTANCE.getPluginBundleVersion_Mismatch();

		/**
		 * The meta object literal for the '<em><b>Repository</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE_VERSION__REPOSITORY = eINSTANCE.getPluginBundleVersion_Repository();

		/**
		 * The meta object literal for the '<em><b>Group Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE_VERSION__GROUP_ID = eINSTANCE.getPluginBundleVersion_GroupId();

		/**
		 * The meta object literal for the '<em><b>Artifact Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE_VERSION__ARTIFACT_ID = eINSTANCE.getPluginBundleVersion_ArtifactId();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE_VERSION__ICON = eINSTANCE.getPluginBundleVersion_Icon();

		/**
		 * The meta object literal for the '<em><b>Organization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE_VERSION__ORGANIZATION = eINSTANCE.getPluginBundleVersion_Organization();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE_VERSION__NAME = eINSTANCE.getPluginBundleVersion_Name();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE_VERSION__DATE = eINSTANCE.getPluginBundleVersion_Date();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.PluginBundleImpl <em>Plugin Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.PluginBundleImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginBundle()
		 * @generated
		 */
		EClass PLUGIN_BUNDLE = eINSTANCE.getPluginBundle();

		/**
		 * The meta object literal for the '<em><b>Organization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE__ORGANIZATION = eINSTANCE.getPluginBundle_Organization();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_BUNDLE__NAME = eINSTANCE.getPluginBundle_Name();

		/**
		 * The meta object literal for the '<em><b>Latest Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUGIN_BUNDLE__LATEST_VERSION = eINSTANCE.getPluginBundle_LatestVersion();

		/**
		 * The meta object literal for the '<em><b>Available Versions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUGIN_BUNDLE__AVAILABLE_VERSIONS = eINSTANCE.getPluginBundle_AvailableVersions();

		/**
		 * The meta object literal for the '<em><b>Installed Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUGIN_BUNDLE__INSTALLED_VERSION = eINSTANCE.getPluginBundle_InstalledVersion();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.PluginInformationImpl <em>Plugin Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.PluginInformationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginInformation()
		 * @generated
		 */
		EClass PLUGIN_INFORMATION = eINSTANCE.getPluginInformation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_INFORMATION__NAME = eINSTANCE.getPluginInformation_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_INFORMATION__TYPE = eINSTANCE.getPluginInformation_Type();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_INFORMATION__DESCRIPTION = eINSTANCE.getPluginInformation_Description();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_INFORMATION__ENABLED = eINSTANCE.getPluginInformation_Enabled();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_INFORMATION__IDENTIFIER = eINSTANCE.getPluginInformation_Identifier();

		/**
		 * The meta object literal for the '<em><b>Install For All Users</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_INFORMATION__INSTALL_FOR_ALL_USERS = eINSTANCE.getPluginInformation_InstallForAllUsers();

		/**
		 * The meta object literal for the '<em><b>Install For New Users</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN_INFORMATION__INSTALL_FOR_NEW_USERS = eINSTANCE.getPluginInformation_InstallForNewUsers();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.OAuthServerImpl <em>OAuth Server</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.OAuthServerImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getOAuthServer()
		 * @generated
		 */
		EClass OAUTH_SERVER = eINSTANCE.getOAuthServer();

		/**
		 * The meta object literal for the '<em><b>Registration Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__REGISTRATION_URL = eINSTANCE.getOAuthServer_RegistrationUrl();

		/**
		 * The meta object literal for the '<em><b>Client Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__CLIENT_ID = eINSTANCE.getOAuthServer_ClientId();

		/**
		 * The meta object literal for the '<em><b>Client Secret</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__CLIENT_SECRET = eINSTANCE.getOAuthServer_ClientSecret();

		/**
		 * The meta object literal for the '<em><b>Client Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__CLIENT_NAME = eINSTANCE.getOAuthServer_ClientName();

		/**
		 * The meta object literal for the '<em><b>Client Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__CLIENT_ICON = eINSTANCE.getOAuthServer_ClientIcon();

		/**
		 * The meta object literal for the '<em><b>Client Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__CLIENT_URL = eINSTANCE.getOAuthServer_ClientUrl();

		/**
		 * The meta object literal for the '<em><b>Client Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__CLIENT_DESCRIPTION = eINSTANCE.getOAuthServer_ClientDescription();

		/**
		 * The meta object literal for the '<em><b>Redirect Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__REDIRECT_URL = eINSTANCE.getOAuthServer_RedirectUrl();

		/**
		 * The meta object literal for the '<em><b>Expires At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__EXPIRES_AT = eINSTANCE.getOAuthServer_ExpiresAt();

		/**
		 * The meta object literal for the '<em><b>Issued At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__ISSUED_AT = eINSTANCE.getOAuthServer_IssuedAt();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__INCOMING = eINSTANCE.getOAuthServer_Incoming();

		/**
		 * The meta object literal for the '<em><b>Api Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__API_URL = eINSTANCE.getOAuthServer_ApiUrl();

		/**
		 * The meta object literal for the '<em><b>Registration Endpoint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_SERVER__REGISTRATION_ENDPOINT = eINSTANCE.getOAuthServer_RegistrationEndpoint();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.OAuthAuthorizationCodeImpl <em>OAuth Authorization Code</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.OAuthAuthorizationCodeImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getOAuthAuthorizationCode()
		 * @generated
		 */
		EClass OAUTH_AUTHORIZATION_CODE = eINSTANCE.getOAuthAuthorizationCode();

		/**
		 * The meta object literal for the '<em><b>Oauth Server</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OAUTH_AUTHORIZATION_CODE__OAUTH_SERVER = eINSTANCE.getOAuthAuthorizationCode_OauthServer();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_AUTHORIZATION_CODE__CODE = eINSTANCE.getOAuthAuthorizationCode_Code();

		/**
		 * The meta object literal for the '<em><b>Authorization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OAUTH_AUTHORIZATION_CODE__AUTHORIZATION = eINSTANCE.getOAuthAuthorizationCode_Authorization();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OAUTH_AUTHORIZATION_CODE__USER = eINSTANCE.getOAuthAuthorizationCode_User();

		/**
		 * The meta object literal for the '<em><b>Issued</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_AUTHORIZATION_CODE__ISSUED = eINSTANCE.getOAuthAuthorizationCode_Issued();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.AuthorizationImpl <em>Authorization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.AuthorizationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getAuthorization()
		 * @generated
		 */
		EClass AUTHORIZATION = eINSTANCE.getAuthorization();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.SingleProjectAuthorizationImpl <em>Single Project Authorization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.SingleProjectAuthorizationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getSingleProjectAuthorization()
		 * @generated
		 */
		EClass SINGLE_PROJECT_AUTHORIZATION = eINSTANCE.getSingleProjectAuthorization();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_PROJECT_AUTHORIZATION__PROJECT = eINSTANCE.getSingleProjectAuthorization_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.NewServiceDescriptorImpl <em>New Service Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.NewServiceDescriptorImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getNewServiceDescriptor()
		 * @generated
		 */
		EClass NEW_SERVICE_DESCRIPTOR = eINSTANCE.getNewServiceDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE_DESCRIPTOR__NAME = eINSTANCE.getNewServiceDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE_DESCRIPTOR__DESCRIPTION = eINSTANCE.getNewServiceDescriptor_Description();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE_DESCRIPTOR__PROVIDER = eINSTANCE.getNewServiceDescriptor_Provider();

		/**
		 * The meta object literal for the '<em><b>Authorization Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE_DESCRIPTOR__AUTHORIZATION_URL = eINSTANCE.getNewServiceDescriptor_AuthorizationUrl();

		/**
		 * The meta object literal for the '<em><b>Token Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE_DESCRIPTOR__TOKEN_URL = eINSTANCE.getNewServiceDescriptor_TokenUrl();

		/**
		 * The meta object literal for the '<em><b>Resource Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE_DESCRIPTOR__RESOURCE_URL = eINSTANCE.getNewServiceDescriptor_ResourceUrl();

		/**
		 * The meta object literal for the '<em><b>Register Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE_DESCRIPTOR__REGISTER_URL = eINSTANCE.getNewServiceDescriptor_RegisterUrl();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE_DESCRIPTOR__INPUTS = eINSTANCE.getNewServiceDescriptor_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE_DESCRIPTOR__OUTPUTS = eINSTANCE.getNewServiceDescriptor_Outputs();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.FormatSerializerMapImpl <em>Format Serializer Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.FormatSerializerMapImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getFormatSerializerMap()
		 * @generated
		 */
		EClass FORMAT_SERIALIZER_MAP = eINSTANCE.getFormatSerializerMap();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMAT_SERIALIZER_MAP__FORMAT = eINSTANCE.getFormatSerializerMap_Format();

		/**
		 * The meta object literal for the '<em><b>Serializers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMAT_SERIALIZER_MAP__SERIALIZERS = eINSTANCE.getFormatSerializerMap_Serializers();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.ActionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.StoreExtendedDataImpl <em>Extended Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.StoreExtendedDataImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getStoreExtendedData()
		 * @generated
		 */
		EClass STORE_EXTENDED_DATA = eINSTANCE.getStoreExtendedData();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.CheckinRevisionImpl <em>Checkin Revision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.CheckinRevisionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getCheckinRevision()
		 * @generated
		 */
		EClass CHECKIN_REVISION = eINSTANCE.getCheckinRevision();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECKIN_REVISION__PROJECT = eINSTANCE.getCheckinRevision_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.NewServiceImpl <em>New Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.NewServiceImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getNewService()
		 * @generated
		 */
		EClass NEW_SERVICE = eINSTANCE.getNewService();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__NAME = eINSTANCE.getNewService_Name();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__PROVIDER = eINSTANCE.getNewService_Provider();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__DESCRIPTION = eINSTANCE.getNewService_Description();

		/**
		 * The meta object literal for the '<em><b>Authorization Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__AUTHORIZATION_URL = eINSTANCE.getNewService_AuthorizationUrl();

		/**
		 * The meta object literal for the '<em><b>Token Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__TOKEN_URL = eINSTANCE.getNewService_TokenUrl();

		/**
		 * The meta object literal for the '<em><b>Resource Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__RESOURCE_URL = eINSTANCE.getNewService_ResourceUrl();

		/**
		 * The meta object literal for the '<em><b>Register Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__REGISTER_URL = eINSTANCE.getNewService_RegisterUrl();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__INPUT = eINSTANCE.getNewService_Input();

		/**
		 * The meta object literal for the '<em><b>Oauth Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__OAUTH_CODE = eINSTANCE.getNewService_OauthCode();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__STATUS = eINSTANCE.getNewService_Status();

		/**
		 * The meta object literal for the '<em><b>Serializer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_SERVICE__SERIALIZER = eINSTANCE.getNewService_Serializer();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__OUTPUT = eINSTANCE.getNewService_Output();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_SERVICE__ACTION = eINSTANCE.getNewService_Action();

		/**
		 * The meta object literal for the '<em><b>Access Token</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__ACCESS_TOKEN = eINSTANCE.getNewService_AccessToken();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_SERVICE__PROJECT = eINSTANCE.getNewService_Project();

		/**
		 * The meta object literal for the '<em><b>State Json</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_SERVICE__STATE_JSON = eINSTANCE.getNewService_StateJson();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.RunServiceAuthorizationImpl <em>Run Service Authorization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.RunServiceAuthorizationImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getRunServiceAuthorization()
		 * @generated
		 */
		EClass RUN_SERVICE_AUTHORIZATION = eINSTANCE.getRunServiceAuthorization();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_SERVICE_AUTHORIZATION__SERVICE = eINSTANCE.getRunServiceAuthorization_Service();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.DensityCollectionImpl <em>Density Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.DensityCollectionImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDensityCollection()
		 * @generated
		 */
		EClass DENSITY_COLLECTION = eINSTANCE.getDensityCollection();

		/**
		 * The meta object literal for the '<em><b>Densities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DENSITY_COLLECTION__DENSITIES = eINSTANCE.getDensityCollection_Densities();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.DensityImpl <em>Density</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.DensityImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getDensity()
		 * @generated
		 */
		EClass DENSITY = eINSTANCE.getDensity();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DENSITY__TYPE = eINSTANCE.getDensity_Type();

		/**
		 * The meta object literal for the '<em><b>Geometry Info Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DENSITY__GEOMETRY_INFO_ID = eINSTANCE.getDensity_GeometryInfoId();

		/**
		 * The meta object literal for the '<em><b>Triangles Below</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DENSITY__TRIANGLES_BELOW = eINSTANCE.getDensity_TrianglesBelow();

		/**
		 * The meta object literal for the '<em><b>Triangles Above</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DENSITY__TRIANGLES_ABOVE = eINSTANCE.getDensity_TrianglesAbove();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DENSITY__VOLUME = eINSTANCE.getDensity_Volume();

		/**
		 * The meta object literal for the '<em><b>Density</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DENSITY__DENSITY = eINSTANCE.getDensity_Density();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.LongCheckinActionStateImpl <em>Long Checkin Action State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.LongCheckinActionStateImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getLongCheckinActionState()
		 * @generated
		 */
		EClass LONG_CHECKIN_ACTION_STATE = eINSTANCE.getLongCheckinActionState();

		/**
		 * The meta object literal for the '<em><b>Roid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_CHECKIN_ACTION_STATE__ROID = eINSTANCE.getLongCheckinActionState_Roid();

		/**
		 * The meta object literal for the '<em><b>Deserialize Error Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_CHECKIN_ACTION_STATE__DESERIALIZE_ERROR_CODE = eINSTANCE.getLongCheckinActionState_DeserializeErrorCode();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.impl.TileImpl <em>Tile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.impl.TileImpl
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getTile()
		 * @generated
		 */
		EClass TILE = eINSTANCE.getTile();

		/**
		 * The meta object literal for the '<em><b>Tile Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TILE__TILE_ID = eINSTANCE.getTile_TileId();

		/**
		 * The meta object literal for the '<em><b>Nr Objects</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TILE__NR_OBJECTS = eINSTANCE.getTile_NrObjects();

		/**
		 * The meta object literal for the '<em><b>Min Bounds</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TILE__MIN_BOUNDS = eINSTANCE.getTile_MinBounds();

		/**
		 * The meta object literal for the '<em><b>Bounds</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TILE__BOUNDS = eINSTANCE.getTile_Bounds();

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
		 * The meta object literal for the '{@link org.bimserver.models.store.Trigger <em>Trigger</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.Trigger
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getTrigger()
		 * @generated
		 */
		EEnum TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.ServiceSimpleType <em>Service Simple Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.ServiceSimpleType
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceSimpleType()
		 * @generated
		 */
		EEnum SERVICE_SIMPLE_TYPE = eINSTANCE.getServiceSimpleType();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.PrimitiveEnum <em>Primitive Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.PrimitiveEnum
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getPrimitiveEnum()
		 * @generated
		 */
		EEnum PRIMITIVE_ENUM = eINSTANCE.getPrimitiveEnum();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.NotifictionResultEnum <em>Notifiction Result Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.NotifictionResultEnum
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getNotifictionResultEnum()
		 * @generated
		 */
		EEnum NOTIFICTION_RESULT_ENUM = eINSTANCE.getNotifictionResultEnum();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.ProgressTopicType <em>Progress Topic Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.ProgressTopicType
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getProgressTopicType()
		 * @generated
		 */
		EEnum PROGRESS_TOPIC_TYPE = eINSTANCE.getProgressTopicType();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.ModelCheckerResultType <em>Model Checker Result Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.ModelCheckerResultType
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getModelCheckerResultType()
		 * @generated
		 */
		EEnum MODEL_CHECKER_RESULT_TYPE = eINSTANCE.getModelCheckerResultType();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.SmtpProtocol <em>Smtp Protocol</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.SmtpProtocol
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getSmtpProtocol()
		 * @generated
		 */
		EEnum SMTP_PROTOCOL = eINSTANCE.getSmtpProtocol();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.PluginBundleType <em>Plugin Bundle Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.PluginBundleType
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginBundleType()
		 * @generated
		 */
		EEnum PLUGIN_BUNDLE_TYPE = eINSTANCE.getPluginBundleType();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.PluginType <em>Plugin Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.PluginType
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getPluginType()
		 * @generated
		 */
		EEnum PLUGIN_TYPE = eINSTANCE.getPluginType();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.store.ServiceStatus <em>Service Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.store.ServiceStatus
		 * @see org.bimserver.models.store.impl.StorePackageImpl#getServiceStatus()
		 * @generated
		 */
		EEnum SERVICE_STATUS = eINSTANCE.getServiceStatus();

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
