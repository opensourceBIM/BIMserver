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
package org.bimserver.models.log.util;

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

import org.bimserver.models.log.CheckoutRelated;
import org.bimserver.models.log.DatabaseCreated;
import org.bimserver.models.log.Download;
import org.bimserver.models.log.ExtendedDataAddedToProject;
import org.bimserver.models.log.ExtendedDataAddedToRevision;
import org.bimserver.models.log.GeoTagUpdated;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.log.NewCheckoutAdded;
import org.bimserver.models.log.NewObjectIDMUploaded;
import org.bimserver.models.log.NewProjectAdded;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.log.NewUserAdded;
import org.bimserver.models.log.PasswordChanged;
import org.bimserver.models.log.PasswordReset;
import org.bimserver.models.log.ProjectDeleted;
import org.bimserver.models.log.ProjectRelated;
import org.bimserver.models.log.ProjectUndeleted;
import org.bimserver.models.log.ProjectUpdated;
import org.bimserver.models.log.RemoteServiceCalled;
import org.bimserver.models.log.RevisionBranched;
import org.bimserver.models.log.RevisionRelated;
import org.bimserver.models.log.RevisionUpdated;
import org.bimserver.models.log.ServerLog;
import org.bimserver.models.log.ServerStarted;
import org.bimserver.models.log.SettingsSaved;
import org.bimserver.models.log.UserAddedToProject;
import org.bimserver.models.log.UserChanged;
import org.bimserver.models.log.UserDeleted;
import org.bimserver.models.log.UserRelated;
import org.bimserver.models.log.UserRemovedFromProject;
import org.bimserver.models.log.UserUndeleted;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.log.LogPackage
 * @generated
 */
public class LogSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LogPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogSwitch() {
		if (modelPackage == null) {
			modelPackage = LogPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case LogPackage.LOG_ACTION: {
			LogAction logAction = (LogAction) theEObject;
			T result = caseLogAction(logAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.SERVER_LOG: {
			ServerLog serverLog = (ServerLog) theEObject;
			T result = caseServerLog(serverLog);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.PROJECT_RELATED: {
			ProjectRelated projectRelated = (ProjectRelated) theEObject;
			T result = caseProjectRelated(projectRelated);
			if (result == null)
				result = caseLogAction(projectRelated);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.CHECKOUT_RELATED: {
			CheckoutRelated checkoutRelated = (CheckoutRelated) theEObject;
			T result = caseCheckoutRelated(checkoutRelated);
			if (result == null)
				result = caseLogAction(checkoutRelated);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.REVISION_RELATED: {
			RevisionRelated revisionRelated = (RevisionRelated) theEObject;
			T result = caseRevisionRelated(revisionRelated);
			if (result == null)
				result = caseLogAction(revisionRelated);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.USER_RELATED: {
			UserRelated userRelated = (UserRelated) theEObject;
			T result = caseUserRelated(userRelated);
			if (result == null)
				result = caseLogAction(userRelated);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.NEW_USER_ADDED: {
			NewUserAdded newUserAdded = (NewUserAdded) theEObject;
			T result = caseNewUserAdded(newUserAdded);
			if (result == null)
				result = caseUserRelated(newUserAdded);
			if (result == null)
				result = caseLogAction(newUserAdded);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.NEW_PROJECT_ADDED: {
			NewProjectAdded newProjectAdded = (NewProjectAdded) theEObject;
			T result = caseNewProjectAdded(newProjectAdded);
			if (result == null)
				result = caseProjectRelated(newProjectAdded);
			if (result == null)
				result = caseLogAction(newProjectAdded);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.REVISION_BRANCHED: {
			RevisionBranched revisionBranched = (RevisionBranched) theEObject;
			T result = caseRevisionBranched(revisionBranched);
			if (result == null)
				result = caseLogAction(revisionBranched);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.NEW_REVISION_ADDED: {
			NewRevisionAdded newRevisionAdded = (NewRevisionAdded) theEObject;
			T result = caseNewRevisionAdded(newRevisionAdded);
			if (result == null)
				result = caseRevisionRelated(newRevisionAdded);
			if (result == null)
				result = caseLogAction(newRevisionAdded);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.NEW_CHECKOUT_ADDED: {
			NewCheckoutAdded newCheckoutAdded = (NewCheckoutAdded) theEObject;
			T result = caseNewCheckoutAdded(newCheckoutAdded);
			if (result == null)
				result = caseCheckoutRelated(newCheckoutAdded);
			if (result == null)
				result = caseLogAction(newCheckoutAdded);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.SETTINGS_SAVED: {
			SettingsSaved settingsSaved = (SettingsSaved) theEObject;
			T result = caseSettingsSaved(settingsSaved);
			if (result == null)
				result = caseLogAction(settingsSaved);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.USER_ADDED_TO_PROJECT: {
			UserAddedToProject userAddedToProject = (UserAddedToProject) theEObject;
			T result = caseUserAddedToProject(userAddedToProject);
			if (result == null)
				result = caseUserRelated(userAddedToProject);
			if (result == null)
				result = caseLogAction(userAddedToProject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.NEW_OBJECT_IDM_UPLOADED: {
			NewObjectIDMUploaded newObjectIDMUploaded = (NewObjectIDMUploaded) theEObject;
			T result = caseNewObjectIDMUploaded(newObjectIDMUploaded);
			if (result == null)
				result = caseLogAction(newObjectIDMUploaded);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.DOWNLOAD: {
			Download download = (Download) theEObject;
			T result = caseDownload(download);
			if (result == null)
				result = caseLogAction(download);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.USER_REMOVED_FROM_PROJECT: {
			UserRemovedFromProject userRemovedFromProject = (UserRemovedFromProject) theEObject;
			T result = caseUserRemovedFromProject(userRemovedFromProject);
			if (result == null)
				result = caseUserRelated(userRemovedFromProject);
			if (result == null)
				result = caseLogAction(userRemovedFromProject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.PROJECT_DELETED: {
			ProjectDeleted projectDeleted = (ProjectDeleted) theEObject;
			T result = caseProjectDeleted(projectDeleted);
			if (result == null)
				result = caseProjectRelated(projectDeleted);
			if (result == null)
				result = caseLogAction(projectDeleted);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.USER_DELETED: {
			UserDeleted userDeleted = (UserDeleted) theEObject;
			T result = caseUserDeleted(userDeleted);
			if (result == null)
				result = caseUserRelated(userDeleted);
			if (result == null)
				result = caseLogAction(userDeleted);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.PASSWORD_RESET: {
			PasswordReset passwordReset = (PasswordReset) theEObject;
			T result = casePasswordReset(passwordReset);
			if (result == null)
				result = caseUserRelated(passwordReset);
			if (result == null)
				result = caseLogAction(passwordReset);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.DATABASE_CREATED: {
			DatabaseCreated databaseCreated = (DatabaseCreated) theEObject;
			T result = caseDatabaseCreated(databaseCreated);
			if (result == null)
				result = caseLogAction(databaseCreated);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.SERVER_STARTED: {
			ServerStarted serverStarted = (ServerStarted) theEObject;
			T result = caseServerStarted(serverStarted);
			if (result == null)
				result = caseLogAction(serverStarted);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.PROJECT_UPDATED: {
			ProjectUpdated projectUpdated = (ProjectUpdated) theEObject;
			T result = caseProjectUpdated(projectUpdated);
			if (result == null)
				result = caseProjectRelated(projectUpdated);
			if (result == null)
				result = caseLogAction(projectUpdated);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.USER_UNDELETED: {
			UserUndeleted userUndeleted = (UserUndeleted) theEObject;
			T result = caseUserUndeleted(userUndeleted);
			if (result == null)
				result = caseUserRelated(userUndeleted);
			if (result == null)
				result = caseLogAction(userUndeleted);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.PROJECT_UNDELETED: {
			ProjectUndeleted projectUndeleted = (ProjectUndeleted) theEObject;
			T result = caseProjectUndeleted(projectUndeleted);
			if (result == null)
				result = caseProjectRelated(projectUndeleted);
			if (result == null)
				result = caseLogAction(projectUndeleted);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.REVISION_UPDATED: {
			RevisionUpdated revisionUpdated = (RevisionUpdated) theEObject;
			T result = caseRevisionUpdated(revisionUpdated);
			if (result == null)
				result = caseRevisionRelated(revisionUpdated);
			if (result == null)
				result = caseLogAction(revisionUpdated);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.GEO_TAG_UPDATED: {
			GeoTagUpdated geoTagUpdated = (GeoTagUpdated) theEObject;
			T result = caseGeoTagUpdated(geoTagUpdated);
			if (result == null)
				result = caseLogAction(geoTagUpdated);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.PASSWORD_CHANGED: {
			PasswordChanged passwordChanged = (PasswordChanged) theEObject;
			T result = casePasswordChanged(passwordChanged);
			if (result == null)
				result = caseUserRelated(passwordChanged);
			if (result == null)
				result = caseLogAction(passwordChanged);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.USER_CHANGED: {
			UserChanged userChanged = (UserChanged) theEObject;
			T result = caseUserChanged(userChanged);
			if (result == null)
				result = caseUserRelated(userChanged);
			if (result == null)
				result = caseLogAction(userChanged);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.EXTENDED_DATA_ADDED_TO_REVISION: {
			ExtendedDataAddedToRevision extendedDataAddedToRevision = (ExtendedDataAddedToRevision) theEObject;
			T result = caseExtendedDataAddedToRevision(extendedDataAddedToRevision);
			if (result == null)
				result = caseLogAction(extendedDataAddedToRevision);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.EXTENDED_DATA_ADDED_TO_PROJECT: {
			ExtendedDataAddedToProject extendedDataAddedToProject = (ExtendedDataAddedToProject) theEObject;
			T result = caseExtendedDataAddedToProject(extendedDataAddedToProject);
			if (result == null)
				result = caseLogAction(extendedDataAddedToProject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case LogPackage.REMOTE_SERVICE_CALLED: {
			RemoteServiceCalled remoteServiceCalled = (RemoteServiceCalled) theEObject;
			T result = caseRemoteServiceCalled(remoteServiceCalled);
			if (result == null)
				result = caseLogAction(remoteServiceCalled);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogAction(LogAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Server Log</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Server Log</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServerLog(ServerLog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project Related</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project Related</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProjectRelated(ProjectRelated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Checkout Related</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Checkout Related</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckoutRelated(CheckoutRelated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Revision Related</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Revision Related</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRevisionRelated(RevisionRelated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Related</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Related</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserRelated(UserRelated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New User Added</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New User Added</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewUserAdded(NewUserAdded object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Project Added</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Project Added</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewProjectAdded(NewProjectAdded object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Revision Branched</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Revision Branched</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRevisionBranched(RevisionBranched object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Revision Added</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Revision Added</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewRevisionAdded(NewRevisionAdded object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Checkout Added</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Checkout Added</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewCheckoutAdded(NewCheckoutAdded object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Settings Saved</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Settings Saved</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSettingsSaved(SettingsSaved object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Added To Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Added To Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserAddedToProject(UserAddedToProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Object IDM Uploaded</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Object IDM Uploaded</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewObjectIDMUploaded(NewObjectIDMUploaded object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Download</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Download</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDownload(Download object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Removed From Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Removed From Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserRemovedFromProject(UserRemovedFromProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project Deleted</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project Deleted</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProjectDeleted(ProjectDeleted object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Deleted</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Deleted</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserDeleted(UserDeleted object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Password Reset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Password Reset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePasswordReset(PasswordReset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Database Created</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Database Created</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDatabaseCreated(DatabaseCreated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Server Started</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Server Started</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServerStarted(ServerStarted object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project Updated</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project Updated</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProjectUpdated(ProjectUpdated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Undeleted</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Undeleted</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserUndeleted(UserUndeleted object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project Undeleted</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project Undeleted</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProjectUndeleted(ProjectUndeleted object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Revision Updated</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Revision Updated</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRevisionUpdated(RevisionUpdated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Geo Tag Updated</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Geo Tag Updated</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeoTagUpdated(GeoTagUpdated object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Password Changed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Password Changed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePasswordChanged(PasswordChanged object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Changed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Changed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserChanged(UserChanged object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Data Added To Revision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Data Added To Revision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendedDataAddedToRevision(ExtendedDataAddedToRevision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Data Added To Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Data Added To Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendedDataAddedToProject(ExtendedDataAddedToProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remote Service Called</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remote Service Called</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoteServiceCalled(RemoteServiceCalled object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //LogSwitch
