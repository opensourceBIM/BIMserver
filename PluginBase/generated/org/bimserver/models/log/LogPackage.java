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
package org.bimserver.models.log;

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
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ProjectRelatedImpl <em>Project Related</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ProjectRelatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectRelated()
	 * @generated
	 */
	int PROJECT_RELATED = 2;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RELATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RELATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RELATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RELATED__PROJECT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project Related</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RELATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.CheckoutRelatedImpl <em>Checkout Related</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.CheckoutRelatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getCheckoutRelated()
	 * @generated
	 */
	int CHECKOUT_RELATED = 3;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_RELATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_RELATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_RELATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Checkout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_RELATED__CHECKOUT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Checkout Related</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKOUT_RELATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.RevisionRelatedImpl <em>Revision Related</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.RevisionRelatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getRevisionRelated()
	 * @generated
	 */
	int REVISION_RELATED = 4;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_RELATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_RELATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_RELATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_RELATED__REVISION = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Revision Related</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_RELATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserRelatedImpl <em>User Related</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserRelatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserRelated()
	 * @generated
	 */
	int USER_RELATED = 5;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_RELATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_RELATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_RELATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_RELATED__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Related</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_RELATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewUserAddedImpl <em>New User Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewUserAddedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewUserAdded()
	 * @generated
	 */
	int NEW_USER_ADDED = 6;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED__DATE = USER_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED__EXECUTOR = USER_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED__ACCESS_METHOD = USER_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED__USER = USER_RELATED__USER;

	/**
	 * The number of structural features of the '<em>New User Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED_FEATURE_COUNT = USER_RELATED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewProjectAddedImpl <em>New Project Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewProjectAddedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewProjectAdded()
	 * @generated
	 */
	int NEW_PROJECT_ADDED = 7;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__DATE = PROJECT_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__EXECUTOR = PROJECT_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__ACCESS_METHOD = PROJECT_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__PROJECT = PROJECT_RELATED__PROJECT;

	/**
	 * The feature id for the '<em><b>Parent Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__PARENT_PROJECT = PROJECT_RELATED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Project Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED_FEATURE_COUNT = PROJECT_RELATED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.RevisionBranchedImpl <em>Revision Branched</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.RevisionBranchedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getRevisionBranched()
	 * @generated
	 */
	int REVISION_BRANCHED = 8;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_BRANCHED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_BRANCHED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_BRANCHED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Oldrevision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_BRANCHED__OLDREVISION = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Newrevision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_BRANCHED__NEWREVISION = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Revision Branched</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_BRANCHED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewRevisionAddedImpl <em>New Revision Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewRevisionAddedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewRevisionAdded()
	 * @generated
	 */
	int NEW_REVISION_ADDED = 9;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__DATE = REVISION_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__EXECUTOR = REVISION_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__ACCESS_METHOD = REVISION_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__REVISION = REVISION_RELATED__REVISION;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__PROJECT = REVISION_RELATED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Revision Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED_FEATURE_COUNT = REVISION_RELATED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewCheckoutAddedImpl <em>New Checkout Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewCheckoutAddedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewCheckoutAdded()
	 * @generated
	 */
	int NEW_CHECKOUT_ADDED = 10;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED__DATE = CHECKOUT_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED__EXECUTOR = CHECKOUT_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED__ACCESS_METHOD = CHECKOUT_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Checkout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED__CHECKOUT = CHECKOUT_RELATED__CHECKOUT;

	/**
	 * The number of structural features of the '<em>New Checkout Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED_FEATURE_COUNT = CHECKOUT_RELATED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.SettingsSavedImpl <em>Settings Saved</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.SettingsSavedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getSettingsSaved()
	 * @generated
	 */
	int SETTINGS_SAVED = 11;

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
	int USER_ADDED_TO_PROJECT = 12;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__DATE = USER_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__EXECUTOR = USER_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__ACCESS_METHOD = USER_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__USER = USER_RELATED__USER;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__PROJECT = USER_RELATED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Added To Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT_FEATURE_COUNT = USER_RELATED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewObjectIDMUploadedImpl <em>New Object IDM Uploaded</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewObjectIDMUploadedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewObjectIDMUploaded()
	 * @generated
	 */
	int NEW_OBJECT_IDM_UPLOADED = 13;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_OBJECT_IDM_UPLOADED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_OBJECT_IDM_UPLOADED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_OBJECT_IDM_UPLOADED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The number of structural features of the '<em>New Object IDM Uploaded</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_OBJECT_IDM_UPLOADED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.DownloadImpl <em>Download</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.DownloadImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getDownload()
	 * @generated
	 */
	int DOWNLOAD = 14;

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
	int USER_REMOVED_FROM_PROJECT = 15;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__DATE = USER_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__EXECUTOR = USER_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__ACCESS_METHOD = USER_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__USER = USER_RELATED__USER;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__PROJECT = USER_RELATED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Removed From Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT_FEATURE_COUNT = USER_RELATED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ProjectDeletedImpl <em>Project Deleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ProjectDeletedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectDeleted()
	 * @generated
	 */
	int PROJECT_DELETED = 16;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED__DATE = PROJECT_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED__EXECUTOR = PROJECT_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED__ACCESS_METHOD = PROJECT_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED__PROJECT = PROJECT_RELATED__PROJECT;

	/**
	 * The number of structural features of the '<em>Project Deleted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED_FEATURE_COUNT = PROJECT_RELATED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserDeletedImpl <em>User Deleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserDeletedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserDeleted()
	 * @generated
	 */
	int USER_DELETED = 17;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED__DATE = USER_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED__EXECUTOR = USER_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED__ACCESS_METHOD = USER_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED__USER = USER_RELATED__USER;

	/**
	 * The number of structural features of the '<em>User Deleted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED_FEATURE_COUNT = USER_RELATED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.PasswordResetImpl <em>Password Reset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.PasswordResetImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getPasswordReset()
	 * @generated
	 */
	int PASSWORD_RESET = 18;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET__DATE = USER_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET__EXECUTOR = USER_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET__ACCESS_METHOD = USER_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET__USER = USER_RELATED__USER;

	/**
	 * The number of structural features of the '<em>Password Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET_FEATURE_COUNT = USER_RELATED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.DatabaseCreatedImpl <em>Database Created</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.DatabaseCreatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getDatabaseCreated()
	 * @generated
	 */
	int DATABASE_CREATED = 19;

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
	int SERVER_STARTED = 20;

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
	int PROJECT_UPDATED = 21;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED__DATE = PROJECT_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED__EXECUTOR = PROJECT_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED__ACCESS_METHOD = PROJECT_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED__PROJECT = PROJECT_RELATED__PROJECT;

	/**
	 * The number of structural features of the '<em>Project Updated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED_FEATURE_COUNT = PROJECT_RELATED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserUndeletedImpl <em>User Undeleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserUndeletedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserUndeleted()
	 * @generated
	 */
	int USER_UNDELETED = 22;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED__DATE = USER_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED__EXECUTOR = USER_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED__ACCESS_METHOD = USER_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED__USER = USER_RELATED__USER;

	/**
	 * The number of structural features of the '<em>User Undeleted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED_FEATURE_COUNT = USER_RELATED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ProjectUndeletedImpl <em>Project Undeleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ProjectUndeletedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectUndeleted()
	 * @generated
	 */
	int PROJECT_UNDELETED = 23;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED__DATE = PROJECT_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED__EXECUTOR = PROJECT_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED__ACCESS_METHOD = PROJECT_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED__PROJECT = PROJECT_RELATED__PROJECT;

	/**
	 * The number of structural features of the '<em>Project Undeleted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED_FEATURE_COUNT = PROJECT_RELATED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.RevisionUpdatedImpl <em>Revision Updated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.RevisionUpdatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getRevisionUpdated()
	 * @generated
	 */
	int REVISION_UPDATED = 24;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED__DATE = REVISION_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED__EXECUTOR = REVISION_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED__ACCESS_METHOD = REVISION_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED__REVISION = REVISION_RELATED__REVISION;

	/**
	 * The number of structural features of the '<em>Revision Updated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED_FEATURE_COUNT = REVISION_RELATED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.GeoTagUpdatedImpl <em>Geo Tag Updated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.GeoTagUpdatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getGeoTagUpdated()
	 * @generated
	 */
	int GEO_TAG_UPDATED = 25;

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
	 * The meta object id for the '{@link org.bimserver.models.log.impl.PasswordChangedImpl <em>Password Changed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.PasswordChangedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getPasswordChanged()
	 * @generated
	 */
	int PASSWORD_CHANGED = 26;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED__DATE = USER_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED__EXECUTOR = USER_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED__ACCESS_METHOD = USER_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED__USER = USER_RELATED__USER;

	/**
	 * The number of structural features of the '<em>Password Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED_FEATURE_COUNT = USER_RELATED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserChangedImpl <em>User Changed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserChangedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserChanged()
	 * @generated
	 */
	int USER_CHANGED = 27;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED__DATE = USER_RELATED__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED__EXECUTOR = USER_RELATED__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED__ACCESS_METHOD = USER_RELATED__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED__USER = USER_RELATED__USER;

	/**
	 * The number of structural features of the '<em>User Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED_FEATURE_COUNT = USER_RELATED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ExtendedDataAddedToRevisionImpl <em>Extended Data Added To Revision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ExtendedDataAddedToRevisionImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getExtendedDataAddedToRevision()
	 * @generated
	 */
	int EXTENDED_DATA_ADDED_TO_REVISION = 28;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_ADDED_TO_REVISION__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_ADDED_TO_REVISION__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_ADDED_TO_REVISION__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_ADDED_TO_REVISION__REVISION = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_ADDED_TO_REVISION__EXTENDED_DATA = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Extended Data Added To Revision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_ADDED_TO_REVISION_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ExtendedDataAddedToProjectImpl <em>Extended Data Added To Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ExtendedDataAddedToProjectImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getExtendedDataAddedToProject()
	 * @generated
	 */
	int EXTENDED_DATA_ADDED_TO_PROJECT = 29;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_ADDED_TO_PROJECT__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_ADDED_TO_PROJECT__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_ADDED_TO_PROJECT__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_ADDED_TO_PROJECT__PROJECT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_ADDED_TO_PROJECT__EXTENDED_DATA = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Extended Data Added To Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_DATA_ADDED_TO_PROJECT_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.RemoteServiceCalledImpl <em>Remote Service Called</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.RemoteServiceCalledImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getRemoteServiceCalled()
	 * @generated
	 */
	int REMOTE_SERVICE_CALLED = 30;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SERVICE_CALLED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SERVICE_CALLED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SERVICE_CALLED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SERVICE_CALLED__SERVICE = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SERVICE_CALLED__STATE = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SERVICE_CALLED__PERCENTAGE = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SERVICE_CALLED__INFOS = LOG_ACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SERVICE_CALLED__WARNINGS = LOG_ACTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SERVICE_CALLED__ERRORS = LOG_ACTION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Remote Service Called</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_SERVICE_CALLED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.AccessMethod <em>Access Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.AccessMethod
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getAccessMethod()
	 * @generated
	 */
	int ACCESS_METHOD = 31;

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
	 * Returns the meta object for class '{@link org.bimserver.models.log.ProjectRelated <em>Project Related</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Related</em>'.
	 * @see org.bimserver.models.log.ProjectRelated
	 * @generated
	 */
	EClass getProjectRelated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ProjectRelated#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.ProjectRelated#getProject()
	 * @see #getProjectRelated()
	 * @generated
	 */
	EReference getProjectRelated_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.CheckoutRelated <em>Checkout Related</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Checkout Related</em>'.
	 * @see org.bimserver.models.log.CheckoutRelated
	 * @generated
	 */
	EClass getCheckoutRelated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.CheckoutRelated#getCheckout <em>Checkout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Checkout</em>'.
	 * @see org.bimserver.models.log.CheckoutRelated#getCheckout()
	 * @see #getCheckoutRelated()
	 * @generated
	 */
	EReference getCheckoutRelated_Checkout();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.RevisionRelated <em>Revision Related</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Revision Related</em>'.
	 * @see org.bimserver.models.log.RevisionRelated
	 * @generated
	 */
	EClass getRevisionRelated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.RevisionRelated#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see org.bimserver.models.log.RevisionRelated#getRevision()
	 * @see #getRevisionRelated()
	 * @generated
	 */
	EReference getRevisionRelated_Revision();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserRelated <em>User Related</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Related</em>'.
	 * @see org.bimserver.models.log.UserRelated
	 * @generated
	 */
	EClass getUserRelated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserRelated#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.UserRelated#getUser()
	 * @see #getUserRelated()
	 * @generated
	 */
	EReference getUserRelated_User();

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
	 * Returns the meta object for class '{@link org.bimserver.models.log.NewProjectAdded <em>New Project Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Project Added</em>'.
	 * @see org.bimserver.models.log.NewProjectAdded
	 * @generated
	 */
	EClass getNewProjectAdded();

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
	 * Returns the meta object for class '{@link org.bimserver.models.log.RevisionBranched <em>Revision Branched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Revision Branched</em>'.
	 * @see org.bimserver.models.log.RevisionBranched
	 * @generated
	 */
	EClass getRevisionBranched();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.RevisionBranched#getOldrevision <em>Oldrevision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Oldrevision</em>'.
	 * @see org.bimserver.models.log.RevisionBranched#getOldrevision()
	 * @see #getRevisionBranched()
	 * @generated
	 */
	EReference getRevisionBranched_Oldrevision();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.RevisionBranched#getNewrevision <em>Newrevision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Newrevision</em>'.
	 * @see org.bimserver.models.log.RevisionBranched#getNewrevision()
	 * @see #getRevisionBranched()
	 * @generated
	 */
	EReference getRevisionBranched_Newrevision();

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
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.NewRevisionAdded#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.NewRevisionAdded#getProject()
	 * @see #getNewRevisionAdded()
	 * @generated
	 */
	EReference getNewRevisionAdded_Project();

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
	 * Returns the meta object for class '{@link org.bimserver.models.log.NewObjectIDMUploaded <em>New Object IDM Uploaded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Object IDM Uploaded</em>'.
	 * @see org.bimserver.models.log.NewObjectIDMUploaded
	 * @generated
	 */
	EClass getNewObjectIDMUploaded();

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
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserDeleted <em>User Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Deleted</em>'.
	 * @see org.bimserver.models.log.UserDeleted
	 * @generated
	 */
	EClass getUserDeleted();

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
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserUndeleted <em>User Undeleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Undeleted</em>'.
	 * @see org.bimserver.models.log.UserUndeleted
	 * @generated
	 */
	EClass getUserUndeleted();

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
	 * Returns the meta object for class '{@link org.bimserver.models.log.RevisionUpdated <em>Revision Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Revision Updated</em>'.
	 * @see org.bimserver.models.log.RevisionUpdated
	 * @generated
	 */
	EClass getRevisionUpdated();

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
	 * Returns the meta object for class '{@link org.bimserver.models.log.PasswordChanged <em>Password Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Password Changed</em>'.
	 * @see org.bimserver.models.log.PasswordChanged
	 * @generated
	 */
	EClass getPasswordChanged();

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
	 * Returns the meta object for class '{@link org.bimserver.models.log.ExtendedDataAddedToRevision <em>Extended Data Added To Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Data Added To Revision</em>'.
	 * @see org.bimserver.models.log.ExtendedDataAddedToRevision
	 * @generated
	 */
	EClass getExtendedDataAddedToRevision();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ExtendedDataAddedToRevision#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see org.bimserver.models.log.ExtendedDataAddedToRevision#getRevision()
	 * @see #getExtendedDataAddedToRevision()
	 * @generated
	 */
	EReference getExtendedDataAddedToRevision_Revision();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ExtendedDataAddedToRevision#getExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended Data</em>'.
	 * @see org.bimserver.models.log.ExtendedDataAddedToRevision#getExtendedData()
	 * @see #getExtendedDataAddedToRevision()
	 * @generated
	 */
	EReference getExtendedDataAddedToRevision_ExtendedData();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ExtendedDataAddedToProject <em>Extended Data Added To Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Data Added To Project</em>'.
	 * @see org.bimserver.models.log.ExtendedDataAddedToProject
	 * @generated
	 */
	EClass getExtendedDataAddedToProject();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ExtendedDataAddedToProject#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.ExtendedDataAddedToProject#getProject()
	 * @see #getExtendedDataAddedToProject()
	 * @generated
	 */
	EReference getExtendedDataAddedToProject_Project();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ExtendedDataAddedToProject#getExtendedData <em>Extended Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended Data</em>'.
	 * @see org.bimserver.models.log.ExtendedDataAddedToProject#getExtendedData()
	 * @see #getExtendedDataAddedToProject()
	 * @generated
	 */
	EReference getExtendedDataAddedToProject_ExtendedData();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.RemoteServiceCalled <em>Remote Service Called</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remote Service Called</em>'.
	 * @see org.bimserver.models.log.RemoteServiceCalled
	 * @generated
	 */
	EClass getRemoteServiceCalled();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.RemoteServiceCalled#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service</em>'.
	 * @see org.bimserver.models.log.RemoteServiceCalled#getService()
	 * @see #getRemoteServiceCalled()
	 * @generated
	 */
	EReference getRemoteServiceCalled_Service();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.log.RemoteServiceCalled#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.bimserver.models.log.RemoteServiceCalled#getState()
	 * @see #getRemoteServiceCalled()
	 * @generated
	 */
	EAttribute getRemoteServiceCalled_State();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.log.RemoteServiceCalled#getPercentage <em>Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percentage</em>'.
	 * @see org.bimserver.models.log.RemoteServiceCalled#getPercentage()
	 * @see #getRemoteServiceCalled()
	 * @generated
	 */
	EAttribute getRemoteServiceCalled_Percentage();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.log.RemoteServiceCalled#getInfos <em>Infos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Infos</em>'.
	 * @see org.bimserver.models.log.RemoteServiceCalled#getInfos()
	 * @see #getRemoteServiceCalled()
	 * @generated
	 */
	EAttribute getRemoteServiceCalled_Infos();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.log.RemoteServiceCalled#getWarnings <em>Warnings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Warnings</em>'.
	 * @see org.bimserver.models.log.RemoteServiceCalled#getWarnings()
	 * @see #getRemoteServiceCalled()
	 * @generated
	 */
	EAttribute getRemoteServiceCalled_Warnings();

	/**
	 * Returns the meta object for the attribute list '{@link org.bimserver.models.log.RemoteServiceCalled#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Errors</em>'.
	 * @see org.bimserver.models.log.RemoteServiceCalled#getErrors()
	 * @see #getRemoteServiceCalled()
	 * @generated
	 */
	EAttribute getRemoteServiceCalled_Errors();

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
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ProjectRelatedImpl <em>Project Related</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ProjectRelatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectRelated()
		 * @generated
		 */
		EClass PROJECT_RELATED = eINSTANCE.getProjectRelated();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_RELATED__PROJECT = eINSTANCE.getProjectRelated_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.CheckoutRelatedImpl <em>Checkout Related</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.CheckoutRelatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getCheckoutRelated()
		 * @generated
		 */
		EClass CHECKOUT_RELATED = eINSTANCE.getCheckoutRelated();

		/**
		 * The meta object literal for the '<em><b>Checkout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECKOUT_RELATED__CHECKOUT = eINSTANCE.getCheckoutRelated_Checkout();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.RevisionRelatedImpl <em>Revision Related</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.RevisionRelatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getRevisionRelated()
		 * @generated
		 */
		EClass REVISION_RELATED = eINSTANCE.getRevisionRelated();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION_RELATED__REVISION = eINSTANCE.getRevisionRelated_Revision();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserRelatedImpl <em>User Related</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserRelatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserRelated()
		 * @generated
		 */
		EClass USER_RELATED = eINSTANCE.getUserRelated();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_RELATED__USER = eINSTANCE.getUserRelated_User();

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
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.NewProjectAddedImpl <em>New Project Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.NewProjectAddedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewProjectAdded()
		 * @generated
		 */
		EClass NEW_PROJECT_ADDED = eINSTANCE.getNewProjectAdded();

		/**
		 * The meta object literal for the '<em><b>Parent Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_PROJECT_ADDED__PARENT_PROJECT = eINSTANCE.getNewProjectAdded_ParentProject();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.RevisionBranchedImpl <em>Revision Branched</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.RevisionBranchedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getRevisionBranched()
		 * @generated
		 */
		EClass REVISION_BRANCHED = eINSTANCE.getRevisionBranched();

		/**
		 * The meta object literal for the '<em><b>Oldrevision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION_BRANCHED__OLDREVISION = eINSTANCE.getRevisionBranched_Oldrevision();

		/**
		 * The meta object literal for the '<em><b>Newrevision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION_BRANCHED__NEWREVISION = eINSTANCE.getRevisionBranched_Newrevision();

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
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_REVISION_ADDED__PROJECT = eINSTANCE.getNewRevisionAdded_Project();

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
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ADDED_TO_PROJECT__PROJECT = eINSTANCE.getUserAddedToProject_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.NewObjectIDMUploadedImpl <em>New Object IDM Uploaded</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.NewObjectIDMUploadedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewObjectIDMUploaded()
		 * @generated
		 */
		EClass NEW_OBJECT_IDM_UPLOADED = eINSTANCE.getNewObjectIDMUploaded();

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
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserDeletedImpl <em>User Deleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserDeletedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserDeleted()
		 * @generated
		 */
		EClass USER_DELETED = eINSTANCE.getUserDeleted();

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
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserUndeletedImpl <em>User Undeleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserUndeletedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserUndeleted()
		 * @generated
		 */
		EClass USER_UNDELETED = eINSTANCE.getUserUndeleted();

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
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.RevisionUpdatedImpl <em>Revision Updated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.RevisionUpdatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getRevisionUpdated()
		 * @generated
		 */
		EClass REVISION_UPDATED = eINSTANCE.getRevisionUpdated();

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
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.PasswordChangedImpl <em>Password Changed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.PasswordChangedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getPasswordChanged()
		 * @generated
		 */
		EClass PASSWORD_CHANGED = eINSTANCE.getPasswordChanged();

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
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ExtendedDataAddedToRevisionImpl <em>Extended Data Added To Revision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ExtendedDataAddedToRevisionImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getExtendedDataAddedToRevision()
		 * @generated
		 */
		EClass EXTENDED_DATA_ADDED_TO_REVISION = eINSTANCE.getExtendedDataAddedToRevision();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_DATA_ADDED_TO_REVISION__REVISION = eINSTANCE.getExtendedDataAddedToRevision_Revision();

		/**
		 * The meta object literal for the '<em><b>Extended Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_DATA_ADDED_TO_REVISION__EXTENDED_DATA = eINSTANCE
				.getExtendedDataAddedToRevision_ExtendedData();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ExtendedDataAddedToProjectImpl <em>Extended Data Added To Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ExtendedDataAddedToProjectImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getExtendedDataAddedToProject()
		 * @generated
		 */
		EClass EXTENDED_DATA_ADDED_TO_PROJECT = eINSTANCE.getExtendedDataAddedToProject();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_DATA_ADDED_TO_PROJECT__PROJECT = eINSTANCE.getExtendedDataAddedToProject_Project();

		/**
		 * The meta object literal for the '<em><b>Extended Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_DATA_ADDED_TO_PROJECT__EXTENDED_DATA = eINSTANCE
				.getExtendedDataAddedToProject_ExtendedData();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.RemoteServiceCalledImpl <em>Remote Service Called</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.RemoteServiceCalledImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getRemoteServiceCalled()
		 * @generated
		 */
		EClass REMOTE_SERVICE_CALLED = eINSTANCE.getRemoteServiceCalled();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOTE_SERVICE_CALLED__SERVICE = eINSTANCE.getRemoteServiceCalled_Service();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_SERVICE_CALLED__STATE = eINSTANCE.getRemoteServiceCalled_State();

		/**
		 * The meta object literal for the '<em><b>Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_SERVICE_CALLED__PERCENTAGE = eINSTANCE.getRemoteServiceCalled_Percentage();

		/**
		 * The meta object literal for the '<em><b>Infos</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_SERVICE_CALLED__INFOS = eINSTANCE.getRemoteServiceCalled_Infos();

		/**
		 * The meta object literal for the '<em><b>Warnings</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_SERVICE_CALLED__WARNINGS = eINSTANCE.getRemoteServiceCalled_Warnings();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_SERVICE_CALLED__ERRORS = eINSTANCE.getRemoteServiceCalled_Errors();

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
