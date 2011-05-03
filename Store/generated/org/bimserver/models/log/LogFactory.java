/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.log;

import org.bimserver.models.log.ClashDetectionSettingsUpdated;
import org.bimserver.models.log.DatabaseCreated;
import org.bimserver.models.log.Download;
import org.bimserver.models.log.GeoTagUpdated;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.log.NewCheckoutAdded;
import org.bimserver.models.log.NewIgnoreFileUploaded;
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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.log.LogPackage
 * @generated
 */
public interface LogFactory extends EFactory
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LogFactory eINSTANCE = org.bimserver.models.log.impl.LogFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
	LogAction createLogAction();

	/**
	 * Returns a new object of class '<em>Server Log</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server Log</em>'.
	 * @generated
	 */
	ServerLog createServerLog();

	/**
	 * Returns a new object of class '<em>New User Added</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New User Added</em>'.
	 * @generated
	 */
	NewUserAdded createNewUserAdded();

	/**
	 * Returns a new object of class '<em>New Project Added</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Project Added</em>'.
	 * @generated
	 */
	NewProjectAdded createNewProjectAdded();

	/**
	 * Returns a new object of class '<em>New Revision Added</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Revision Added</em>'.
	 * @generated
	 */
	NewRevisionAdded createNewRevisionAdded();

	/**
	 * Returns a new object of class '<em>New Checkout Added</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Checkout Added</em>'.
	 * @generated
	 */
	NewCheckoutAdded createNewCheckoutAdded();

	/**
	 * Returns a new object of class '<em>Settings Saved</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Settings Saved</em>'.
	 * @generated
	 */
	SettingsSaved createSettingsSaved();

	/**
	 * Returns a new object of class '<em>User Added To Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Added To Project</em>'.
	 * @generated
	 */
	UserAddedToProject createUserAddedToProject();

	/**
	 * Returns a new object of class '<em>New Ignore File Uploaded</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Ignore File Uploaded</em>'.
	 * @generated
	 */
	NewIgnoreFileUploaded createNewIgnoreFileUploaded();

	/**
	 * Returns a new object of class '<em>Download</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Download</em>'.
	 * @generated
	 */
	Download createDownload();

	/**
	 * Returns a new object of class '<em>User Removed From Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Removed From Project</em>'.
	 * @generated
	 */
	UserRemovedFromProject createUserRemovedFromProject();

	/**
	 * Returns a new object of class '<em>Project Deleted</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Deleted</em>'.
	 * @generated
	 */
	ProjectDeleted createProjectDeleted();

	/**
	 * Returns a new object of class '<em>User Deleted</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Deleted</em>'.
	 * @generated
	 */
	UserDeleted createUserDeleted();

	/**
	 * Returns a new object of class '<em>Password Reset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Password Reset</em>'.
	 * @generated
	 */
	PasswordReset createPasswordReset();

	/**
	 * Returns a new object of class '<em>Database Created</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Database Created</em>'.
	 * @generated
	 */
	DatabaseCreated createDatabaseCreated();

	/**
	 * Returns a new object of class '<em>Server Started</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server Started</em>'.
	 * @generated
	 */
	ServerStarted createServerStarted();

	/**
	 * Returns a new object of class '<em>Project Updated</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Updated</em>'.
	 * @generated
	 */
	ProjectUpdated createProjectUpdated();

	/**
	 * Returns a new object of class '<em>User Undeleted</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Undeleted</em>'.
	 * @generated
	 */
	UserUndeleted createUserUndeleted();

	/**
	 * Returns a new object of class '<em>Project Undeleted</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Undeleted</em>'.
	 * @generated
	 */
	ProjectUndeleted createProjectUndeleted();

	/**
	 * Returns a new object of class '<em>Revision Updated</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Revision Updated</em>'.
	 * @generated
	 */
	RevisionUpdated createRevisionUpdated();

	/**
	 * Returns a new object of class '<em>Geo Tag Updated</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Geo Tag Updated</em>'.
	 * @generated
	 */
	GeoTagUpdated createGeoTagUpdated();

	/**
	 * Returns a new object of class '<em>Clash Detection Settings Updated</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clash Detection Settings Updated</em>'.
	 * @generated
	 */
	ClashDetectionSettingsUpdated createClashDetectionSettingsUpdated();

	/**
	 * Returns a new object of class '<em>Password Changed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Password Changed</em>'.
	 * @generated
	 */
	PasswordChanged createPasswordChanged();

	/**
	 * Returns a new object of class '<em>User Changed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Changed</em>'.
	 * @generated
	 */
	UserChanged createUserChanged();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LogPackage getLogPackage();

} //LogFactory
